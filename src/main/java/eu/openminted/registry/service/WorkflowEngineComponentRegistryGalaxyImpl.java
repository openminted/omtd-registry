package eu.openminted.registry.service;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.jcraft.jsch.ChannelSftp;
import com.jcraft.jsch.JSch;
import com.jcraft.jsch.Session;

import eu.openminted.registry.domain.ComponentDistributionFormEnum;
import eu.openminted.registry.domain.ComponentDistributionInfo;
import eu.openminted.registry.domain.FrameworkEnum;
import eu.openminted.workflows.galaxytool.Tool;
import eu.openminted.workflows.galaxywrappers.GalaxyToolWrapperWriter;
import eu.openminted.workflows.galaxywrappers.GalaxyWrapperGenerator;

@Component
public class WorkflowEngineComponentRegistryGalaxyImpl implements WorkflowEngineComponentRegistry{

    private static Logger logger = LogManager.getLogger(WorkflowEngineComponentRegistry.class);
    private String galaxyRootTools = "/srv/galaxy/tools/";
    
    @Autowired
    private GalaxyWrapperGenerator galaxyWrapperGenerator;
    
    @Autowired
    private GalaxyToolWrapperWriter galaxyToolWrapperWriter;
    
    //@Autowired
    //private SSH ssh;
    
	@Override
    public void registerTDMComponentToWorkflowEngine(eu.openminted.registry.domain.Component componentMeta){
		
		String trgFolder = "";
		
		// Prepare Galaxy wrapper generation&copying.
        if(isDocker(componentMeta)) { // Docker-packaged components
        	logger.info("Registering:" + "Docker");
        	trgFolder = "omtdDocker";
        }else{ // Non Docker-packaged components 
        	String framework = componentMeta.getComponentInfo().getComponentCreationInfo().getFramework().value();
        	
        	if(framework == FrameworkEnum.UIMA.value()){
        		logger.info("Registering:" + framework);
        		trgFolder = "omtdUIMA";
        		galaxyWrapperGenerator.setDockerImage("TO-DO");
        		
        	}else if(framework == FrameworkEnum.GATE.value()){
        		logger.info("Registering:" + framework);
        		trgFolder = "omtdGATE";
        		galaxyWrapperGenerator.setDockerImage("TO-DO");
        	}else{
        		logger.info("Registering:" + "error");
        	}
        }
        
        // Generate wrapper.
        Tool tool = galaxyWrapperGenerator.generate(componentMeta);
        
        // Write wrapper.
        File tmpFileForWrapper = writeWrapperToDisk(tool);
        
        // If succeeded copy it to Galaxy machine.
        if(tmpFileForWrapper != null){
        	// Copy over SSH.
            //boolean done = ssh.copy(tmpForWrapper.getAbsolutePath(),  galaxyRootTools + trgFolder);
            
            // Copy over NFS.
            copyViaNFSToGalaxyToolsFolder(tmpFileForWrapper, trgFolder);
        }
    }
    
	private File writeWrapperToDisk(Tool tool){
		String wrapperXML = galaxyToolWrapperWriter.serialize(tool);
        File tmpFileForWrapper = null;
        try {
        	tmpFileForWrapper = File.createTempFile("tmp", "");
        	FileOutputStream fos = new FileOutputStream(tmpFileForWrapper);
        	fos.write(wrapperXML.getBytes());
        	fos.flush();
        	fos.close();
		} catch (IOException e) {
			logger.debug(e);
			return null;
		}	
        
        return tmpFileForWrapper;
	}
	
	private void copyViaNFSToGalaxyToolsFolder(File tmpForWrapper, String trgFolder){		
        try {
			Files.copy(Paths.get(tmpForWrapper.getAbsolutePath()), Paths.get(galaxyRootTools + trgFolder), StandardCopyOption.REPLACE_EXISTING);
		} catch (IOException e) {
			logger.debug(e);
		}
	}
	
    private boolean isDocker(eu.openminted.registry.domain.Component component){
    	 ComponentDistributionInfo distributionInfo = component.getComponentInfo().getDistributionInfos().get(0);
         return distributionInfo.getComponentDistributionForm() == ComponentDistributionFormEnum.DOCKER_IMAGE;
    }
    
}
