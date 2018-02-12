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
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
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
    private static Logger log = LogManager.getLogger(JMSConsumer.class.getName());

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

    @JmsListener(containerFactory = "jmsQueueListenerContainerFactory", destination = "${jms.corpus.state.topic:corpus.state}")
    public void receiveState(CorpusBuildingState corpusBuildingState) throws JMSException, UnknownHostException {
        log.info("State of corpus building: " + corpusBuildingState);
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

        String responseBody = ((TextMessage) message).getText();
        JSONObject object = new JSONObject(responseBody);

        Resource resource = new Resource();
        resource.setPayloadFormat("xml");
        resource.setPayload((String) object.get("resource"));



        eu.openminted.registry.domain.Component component = parserPool.deserialize(resource,eu.openminted.registry.domain.Component.class).get();
        ComponentDistributionInfo distributionInfo = component.getComponentInfo().getDistributionInfos().get(0);
        if(distributionInfo.getComponentDistributionForm() == ComponentDistributionFormEnum.DOCKER_IMAGE) {
            String url = distributionInfo.getDistributionLocation();
            dockerService.downloadDockerFlow(url);
            String image_id = dockerService.uploadDockerFlow(url);
            dockerService.deleteDockerFlow(url,image_id);
        }

        mavenExportDirectory(resource);
    }

    @JmsListener(containerFactory = "jmsTopicListenerContainerFactory", destination = "${jms.component.update.topic:registry.component.update}")
    public void receiveStateTopicUpdated(Message message) throws JMSException, UnknownHostException, ExecutionException, InterruptedException {

        String responseBody = ((TextMessage) message).getText();
        JSONObject object = new JSONObject(responseBody);

        Resource resource = new Resource();
        resource.setPayloadFormat("xml");
        resource.setPayload((String) object.get("resource"));

        mavenExportDirectory(resource);

    }

    private void mavenExportDirectory(Resource resource) throws ExecutionException, InterruptedException {
        eu.openminted.registry.domain.Component component = parserPool.deserialize(resource, eu.openminted.registry.domain.Component.class).get();
        ResourceIdentifier resourceIdentifier = component.getComponentInfo().getIdentificationInfo().getResourceIdentifiers().get(0);

        if (resourceIdentifier.getResourceIdentifierSchemeName() == ResourceIdentifierSchemeNameEnum.MAVEN) {

            Pattern pattern = Pattern.compile("mvn:([\\w\\._-]+):([\\w\\._-]+):([\\.\\w_-]+)");
            Matcher matcher = pattern.matcher(resourceIdentifier.getValue());
            matcher.find();

            String groupId = matcher.group(1);
            String artifactId = matcher.group(2);
            String version = matcher.group(3);

            File f = new File("/media/maven-data/"+groupId+"/"+artifactId+"/"+version+"/");

            if(!f.exists()) {
                try{
                    if(f.mkdirs()) {
                        System.out.println("Directory Created");
                    } else {
                        System.out.println("Directory is not created");
                    }
                } catch(Exception e){
                    //  Demo purposes only.  Do NOT do this in real code.  EVER.
                    //  It squashes exceptions ...
                    e.printStackTrace();
                }
            }

            f = new File("/media/maven-data/"+groupId+"/"+artifactId+"/"+version+"/"+component.getMetadataHeaderInfo().getMetadataRecordIdentifier().getValue()+".xml");

            try {
                FileWriter fw = new FileWriter(f.getAbsolutePath());
                BufferedWriter bw = new BufferedWriter(fw);
                bw.write(resource.getPayload());

                bw.close();
                fw.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

}

