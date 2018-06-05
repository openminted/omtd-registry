package eu.openminted.registry.service.listener;

import eu.openminted.registry.core.service.ParserService;
import eu.openminted.registry.core.service.ResourceCRUDService;
import eu.openminted.registry.domain.*;
import eu.openminted.registry.service.WorkflowEngineComponentRegistry;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.concurrent.ExecutionException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Aspect
@org.springframework.stereotype.Component
public class ComponentListener {

    private static Logger logger = LogManager.getLogger(ComponentListener.class);

    @Value("${maven.data.path:#{'/media/maven-data'}}")
    private String mavenDataPath;


    @Value("${docker.data.path:#{'/media/docker-data'}}")
    private String dockerDataPath;

    @Autowired
    private  ParserService parserPool;

    @Autowired
    private WorkflowEngineComponentRegistry workflowEngineComponentReg;



    @Autowired
    @Qualifier("applicationService")
    private ResourceCRUDService<Component> applicationService;

    @After("(execution (* eu.openminted.registry.service.omtd.ComponentServiceImpl.add(eu.openminted.registry.domain.Component)) || " +
            "execution (* eu.openminted.registry.service.omtd.ComponentServiceImpl.update(eu.openminted.registry.domain.Component))) && args(component)")
    public Component addComponentListener(Component component) throws ExecutionException, InterruptedException {
        // Register it to workflow engine.
        workflowEngineComponentReg.registerTDMComponentToWorkflowEngine(component);
        exportDirectory(component);
        return component;
    }

    @After("execution (* eu.openminted.registry.service.omtd.ComponentServiceImpl.delete(eu.openminted.registry.domain.Component)) && args(component)")
    public Component deleteComponentListener(Component component) {
        // Register it to workflow engine.
        logger.info("Deleting component");
        workflowEngineComponentReg.deleteTDMComponentFromWorkflowEngine(component);
        return component;
    }

    private void exportDirectory(Component component) throws ExecutionException, InterruptedException {
        ResourceIdentifier resourceIdentifier = component.getComponentInfo().getIdentificationInfo().getResourceIdentifiers().get(0);
        ComponentDistributionInfo distributionInfo = component.getComponentInfo().getDistributionInfos().get(0);

        String filePath = "";

        if (resourceIdentifier.getResourceIdentifierSchemeName() == ResourceIdentifierSchemeNameEnum.MAVEN) {
            Pattern pattern = Pattern.compile("mvn:([\\w\\._-]+):([\\w\\._-]+):([\\.\\w_-]+)");
            Matcher matcher = pattern.matcher(resourceIdentifier.getValue());
            matcher.find();

            String groupId = matcher.group(1);
            String artifactId = matcher.group(2);
            String version = matcher.group(3);
            filePath = mavenDataPath+"/"+groupId+"/"+artifactId+"/"+version+"/";

            logger.info("Found maven component, saving @ "+ filePath);
        }else if(distributionInfo.getComponentDistributionForm() == ComponentDistributionFormEnum.DOCKER_IMAGE) {
            filePath = dockerDataPath+"/";
            logger.info("Found docker component, saving @ "+ filePath);
        }else {
            return ;
        }

        File f = new File(filePath);

        if(!f.exists()) {
            try{
                if(f.mkdirs()) {
//                    logger.info("Directory Created");
                } else {
//                    logger.info("Directory is not created");
                }
            } catch(Exception e){
                logger.error("Error creating directory " +filePath+" component", e);
            }
        }

        f = new File(filePath+component.getMetadataHeaderInfo().getMetadataRecordIdentifier().getValue()+".xml");

        try {
            FileWriter fw = new FileWriter(f.getAbsolutePath());
            BufferedWriter bw = new BufferedWriter(fw);
            bw.write(parserPool.serialize(component, ParserService.ParserServiceTypes.XML).get());

            bw.close();
            fw.close();
        } catch (IOException e) {
            logger.error("Error writting in maven component's directory", e);
        }
    }


}
