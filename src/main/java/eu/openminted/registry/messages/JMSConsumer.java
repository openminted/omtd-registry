package eu.openminted.registry.messages;

import com.github.jmchilton.blend4j.galaxy.GalaxyInstance;
import eu.openminted.corpus.CorpusBuildingState;
import eu.openminted.corpus.CorpusStatus;
import eu.openminted.registry.core.domain.Resource;
import eu.openminted.registry.core.domain.jms.BaseResourceJms;
import eu.openminted.registry.core.domain.jms.ResourceJmsCreated;
import eu.openminted.registry.core.domain.jms.ResourceJmsUpdated;
import eu.openminted.registry.core.service.ParserService;
import eu.openminted.registry.core.service.SearchService;
import eu.openminted.registry.domain.*;
import eu.openminted.registry.generate.WorkflowGenerate;
import eu.openminted.registry.service.*;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jms.annotation.JmsListener;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.TextMessage;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.net.UnknownHostException;
import java.util.concurrent.ExecutionException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@org.springframework.stereotype.Component("jmsConsumer")
public class JMSConsumer {
    private static Logger logger = LogManager.getLogger(JMSConsumer.class);

    @Value("${maven.data.path:#{'/media/maven-data'}}")
    private String mavenDataPath;


    @Value("${docker.data.path:#{'/media/docker-data'}}")
    private String dockerDataPath;
    
    @Autowired
    public SearchService searchService;

    @Autowired
    public ParserService parserPool;

    @Autowired
    CorpusBuildingStateServiceImpl corpusBuildingStateService;

    @Autowired
    IncompleteCorpusServiceImpl incompleteCorpusService;

    @Autowired
    DockerService dockerService;

    @Autowired
    WorkflowEngineComponentRegistry workflowEngineComponentReg;

    @Autowired
    WorkflowGenerate workflowGenerate;

    @Autowired(required = false)
    @Qualifier("galaxyExecutorInstanceFactory")
    private GalaxyInstance galaxyExecutorInstance;

    @JmsListener(containerFactory = "jmsQueueListenerContainerFactory", destination = "${jms.corpus.state.topic:corpus.state}")
    public void receiveState(CorpusBuildingState corpusBuildingState) throws UnknownHostException {
        logger.info("State of corpus building: " + corpusBuildingState);
        SearchService.KeyValue kv = new SearchService.KeyValue("corpus_id", corpusBuildingState.getId());
        Resource resource = searchService.searchId("corpusbuildingstate", kv);
        if (resource == null) {
            corpusBuildingStateService.add(corpusBuildingState);
        } else {
            corpusBuildingStateService.update(corpusBuildingState);
        }
        if (corpusBuildingState.getCurrentStatus().equalsIgnoreCase(CorpusStatus.CREATED.toString())) {
            String corpusId = corpusBuildingState.getId().split("@")[0];
            Corpus incompletedCorpus = incompleteCorpusService.get(corpusId);
            if (incompletedCorpus != null) {
                incompleteCorpusService.move(corpusId);
            }
        }
    }

    @JmsListener(containerFactory = "jmsTopicListenerContainerFactory", destination = "${jms.component.create.topic:registry.component.create}")
    public void receiveStateTopic(ResourceJmsCreated componentResource) throws ExecutionException, InterruptedException {

        Resource resource = fromJMS(componentResource);
        Component component = parserPool.deserialize(resource, Component.class).get();
        // Register it to workflow engine.
        workflowEngineComponentReg.registerTDMComponentToWorkflowEngine(component);

        // We do need the following ant more
        /*
        ComponentDistributionInfo distributionInfo = component.getComponentInfo().getDistributionInfos().get(0);
        if(distributionInfo.getComponentDistributionForm() == ComponentDistributionFormEnum.DOCKER_IMAGE) {
            String url = distributionInfo.getDistributionLocation();
            dockerService.downloadDockerFlow(url);
            String image_id = dockerService.uploadDockerFlow(url);
            dockerService.deleteDockerFlow(url,image_id);
        }

        exportDirectory(resource);
        */
    }

    @JmsListener(containerFactory = "jmsTopicListenerContainerFactory", destination = "${jms.application.create.topic:registry.application.create}")
    public void receiveApplicationTopic(ResourceJmsCreated resourceApplication) throws ExecutionException, InterruptedException {

        Resource resource = fromJMS(resourceApplication);
        // Deserialize it to a TDM Component object.
        Component application = parserPool.deserialize(resource, Component.class).get();
        // Register it to workflow engine.
        WorkflowEngineComponent wec = workflowEngineComponentReg.registerTDMComponentToWorkflowEngine(application);
        String workflowDefinition = workflowGenerate.generateResource(wec);
        galaxyExecutorInstance.getWorkflowsClient().importWorkflow(workflowDefinition);

    }

    @JmsListener(containerFactory = "jmsTopicListenerContainerFactory", destination = "${jms.component.update.topic:registry.component.update}")
    public void receiveStateTopicUpdated(ResourceJmsUpdated message) throws ExecutionException, InterruptedException {
        Resource resource = fromJMS(message);
        exportDirectory(resource);
    }



    private void exportDirectory(Resource resource) throws ExecutionException, InterruptedException {
        Component component = parserPool.deserialize(resource, Component.class).get();
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
            bw.write(resource.getPayload());

            bw.close();
            fw.close();
        } catch (IOException e) {
            logger.error("Error writting in maven component's directory", e);
        }
    }


    private static Resource fromJMS(BaseResourceJms resourcejms) {
        Resource resource = new Resource();
        resource.setPayload(resourcejms.getResource());
        resource.setPayloadFormat(resourcejms.getPayloadFormat());
        return resource;
    }
}

