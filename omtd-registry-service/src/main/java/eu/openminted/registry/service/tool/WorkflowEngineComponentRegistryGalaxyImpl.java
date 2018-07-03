package eu.openminted.registry.service.tool;

import eu.openminted.registry.domain.ComponentDistributionInfo;
import eu.openminted.registry.domain.FrameworkEnum;
import eu.openminted.registry.service.*;
import eu.openminted.workflows.galaxytool.Tool;
import eu.openminted.workflows.galaxywrappers.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.*;
import java.nio.file.*;
import java.util.List;

@Component
public class WorkflowEngineComponentRegistryGalaxyImpl implements WorkflowEngineComponentRegistry {

    private final static String galaxyRootTools = "/opt/galaxy/tools/";
    private final static String prefix = "wrapper_";
    private static Logger logger = LogManager.getLogger(WorkflowEngineComponentRegistry.class);
    @Autowired
    private GalaxyWrapperGenerator galaxyWrapperGenerator;

    @Autowired
    private GalaxyToolWrapperWriter galaxyToolWrapperWriter;

    @Autowired
    private DockerImageProvider dockerImageProvider;

    private static Path getWrapperName(String folder, String resourceID) {
        return Paths.get(galaxyRootTools + folder + prefix + resourceID + ".xml");
    }

    private static String getWrapperFolder(eu.openminted.registry.domain.Component component) {
        String ret = "";
        List<ComponentDistributionInfo> distributionInfos = component.getComponentInfo().getDistributionInfos();
        // Prepare Galaxy wrapper generation&copying.
        if (Utils.isDocker(distributionInfos)) { // Docker-packaged components
            ret = "omtdDocker/";
        } else if (Utils.isWebService(distributionInfos)) {  // WS-packaged components
            ret = "omtdDocker/";
        } else { // UIMA/GATE components
            String framework = component.getComponentInfo().getComponentCreationInfo().getFramework().value();
            if (framework.equals(FrameworkEnum.UIMA.value())) {
                ret = "omtdUIMA/";

            } else if (framework.equals(FrameworkEnum.GATE.value())) {
                ret = "omtdGATE/";
            }
        }
        return ret;
    }

    @Override
    public WorkflowEngineComponent registerTDMComponentToWorkflowEngine(
            eu.openminted.registry.domain.Component componentMeta) {

        WorkflowEngineComponent wec = new WorkflowEngineComponent();

        String resourceID = componentMeta.getComponentInfo().getIdentificationInfo().getResourceIdentifiers().get(0)
                .getValue();
        String resourceName = componentMeta.getComponentInfo().getIdentificationInfo().getResourceNames().get(0)
                .getValue();

        List<ComponentDistributionInfo> distributionInfos = componentMeta.getComponentInfo().getDistributionInfos();
        String galaxyTrgFolder = "";

        // Prepare Galaxy wrapper generation&copying.
        if (Utils.isDocker(distributionInfos)) { // Docker-packaged components
            logger.info("Registering component -> " + "Docker");
            galaxyTrgFolder = "omtdDocker/";
        } else if (Utils.isWebService(distributionInfos)) {  // WS-packaged components
            logger.info("Registering component -> " + "WebService");
            galaxyTrgFolder = "omtdDocker/";
            galaxyWrapperGenerator.setDockerImage(dockerImageProvider.getImage(componentMeta));
        } else { // UIMA/GATE components
            String framework = componentMeta.getComponentInfo().getComponentCreationInfo().getFramework().value();
            logger.info("Registering component -> " + framework);

            if (framework == FrameworkEnum.UIMA.value()) {
                galaxyTrgFolder = "omtdUIMA/";
                galaxyWrapperGenerator.setDockerImage(dockerImageProvider.getImage(componentMeta));

            } else if (framework == FrameworkEnum.GATE.value()) {
                galaxyTrgFolder = "omtdGATE/";
                galaxyWrapperGenerator.setDockerImage(dockerImageProvider.getImage(componentMeta));
            } else {
                logger.info("Registering component -> " + "error");
            }
        }

        // Generate wrapper.
        Tool tool = galaxyWrapperGenerator.generate(componentMeta);

        // Write wrapper.
        File tmpFileForWrapper = writeWrapperToDisk(tool, resourceID);

        String wrapperFinalDest = "";
        // If succeeded copy it to Galaxy machine.
        if (tmpFileForWrapper != null) {
            // Copy over NFS.
            wrapperFinalDest = copyViaNFSToGalaxyToolsFolder(tmpFileForWrapper, galaxyTrgFolder, resourceID);
        }

        wec.setComponentID(tool.getId());
        wec.setComponentVersion(tool.getVersion());
        wec.setName(resourceName);
        wec.setLocation(wrapperFinalDest);

        return wec;
    }

    @Override
    public void deleteTDMComponentFromWorkflowEngine(eu.openminted.registry.domain.Component component) {
        String resourceID = component.getComponentInfo().getIdentificationInfo().getResourceIdentifiers().get(0)
                .getValue();
        String folder = getWrapperFolder(component);
        try {
            Files.deleteIfExists(getWrapperName(folder, resourceID));
        } catch (IOException e) {
            logger.error("Error deleting component", e);
        }
    }

    private File writeWrapperToDisk(Tool tool, String resourceID) {
        String wrapperXML = galaxyToolWrapperWriter.serialize(tool);
        File tmpFileForWrapper = null;
        try {
            tmpFileForWrapper = File.createTempFile("wrapper_" + resourceID, ".xml");
            FileOutputStream fos = new FileOutputStream(tmpFileForWrapper);
            fos.write(wrapperXML.getBytes());
            fos.flush();
            fos.close();

            logger.info("Wrapper tmp:" + tmpFileForWrapper.getAbsolutePath());
        } catch (IOException e) {
            logger.debug(e);
            return null;
        }

        return tmpFileForWrapper;
    }

    private String copyViaNFSToGalaxyToolsFolder(File tmpForWrapper, String trgFolder, String resourceID) {

        try {
            // Create parent folder if not exists.
            File parent = new File(galaxyRootTools + trgFolder);
            if (!parent.exists()) {
                boolean mkdrs = parent.mkdirs();
                logger.info("copyViaNFSToGalaxyToolsFolder -> make parent:" + mkdrs);
            }

            // Copy
            Path src = Paths.get(tmpForWrapper.getAbsolutePath());
            Path trg = getWrapperName(trgFolder, resourceID);
            Files.copy(src, trg, StandardCopyOption.REPLACE_EXISTING);

            return trg.toFile().getAbsolutePath();
        } catch (IOException e) {
            logger.error("Error writing to galaxy NFS folder", e);
        }
        return null;
    }

}
