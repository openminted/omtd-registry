package eu.openminted.registry.messages;

import eu.openminted.corpus.CorpusBuildingState;
import eu.openminted.corpus.CorpusStatus;
import eu.openminted.registry.core.domain.Resource;
import eu.openminted.registry.core.service.ParserService;
import eu.openminted.registry.core.service.SearchService;
import eu.openminted.registry.domain.*;
import eu.openminted.registry.service.CorpusBuildingStateServiceImpl;
import eu.openminted.registry.service.DockerService;
import eu.openminted.registry.service.IncompleteCorpusServiceImpl;
import eu.openminted.registry.service.WorkflowEngineComponentRegistry;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

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

@Component("jmsConsumer")
public class JMSConsumer {
    private static Logger logger = LogManager.getLogger(JMSConsumer.class.getName());

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
    WorkflowEngineComponentRegistry TDMComponentReg;
    
    @JmsListener(containerFactory = "jmsQueueListenerContainerFactory", destination = "${jms.corpus.state.topic:corpus.state}")
    public void receiveState(CorpusBuildingState corpusBuildingState) throws JMSException, UnknownHostException {
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
    public void receiveStateTopic(Message message) throws JMSException, UnknownHostException, ExecutionException, InterruptedException {

    	// Get Msg
        String responseBody = ((TextMessage) message).getText();
        JSONObject object = new JSONObject(responseBody);
        Resource resource = new Resource();
        resource.setPayloadFormat("xml");
        resource.setPayload((String) object.get("resource"));

        // Deserialize it to a TDM Component object.
        eu.openminted.registry.domain.Component component = parserPool.deserialize(resource, eu.openminted.registry.domain.Component.class).get();
        // Register it
        TDMComponentReg.registerTDMComponentToWorkflowEngine(component);
        
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

    @JmsListener(containerFactory = "jmsTopicListenerContainerFactory", destination = "${jms.component.update.topic:registry.component.update}")
    public void receiveStateTopicUpdated(Message message) throws JMSException, UnknownHostException, ExecutionException, InterruptedException {

        String responseBody = ((TextMessage) message).getText();
        JSONObject object = new JSONObject(responseBody);

        Resource resource = new Resource();
        resource.setPayloadFormat("xml");
        resource.setPayload((String) object.get("resource"));

        exportDirectory(resource);

    }


    
    private void exportDirectory(Resource resource) throws ExecutionException, InterruptedException {
        eu.openminted.registry.domain.Component component = parserPool.deserialize(resource, eu.openminted.registry.domain.Component.class).get();
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

}

