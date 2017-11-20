package eu.openminted.registry.messages;

import eu.openminted.corpus.CorpusBuildingState;
import eu.openminted.corpus.CorpusStatus;
import eu.openminted.registry.core.domain.Resource;
import eu.openminted.registry.core.service.ParserService;
import eu.openminted.registry.core.service.SearchService;
import eu.openminted.registry.domain.ComponentDistributionFormEnum;
import eu.openminted.registry.domain.ComponentDistributionInfo;
import eu.openminted.registry.domain.Corpus;
import eu.openminted.registry.service.CorpusBuildingStateServiceImpl;
import eu.openminted.registry.service.DockerService;
import eu.openminted.registry.service.IncompleteCorpusServiceImpl;
import org.apache.log4j.Logger;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.TextMessage;
import javax.xml.soap.Text;
import java.net.UnknownHostException;
import java.util.concurrent.ExecutionException;

@Component("jmsConsumer")
public class JMSConsumer {
    private static Logger log = Logger.getLogger(JMSConsumer.class.getName());

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

        log.info("Received component's creation, processing...");

        String responseBody = ((TextMessage) message).getText();
        JSONObject object = new JSONObject(responseBody);

        Resource resource = new Resource();
        resource.setPayloadFormat("xml");
        resource.setPayload((String) object.get("resource"));



        eu.openminted.registry.domain.Component component = parserPool.serialize(resource,eu.openminted.registry.domain.Component.class).get();
        ComponentDistributionInfo distributionInfo = component.getComponentInfo().getDistributionInfos().get(0);
        if (distributionInfo.getComponentLoc().getComponentDistributionForm()== ComponentDistributionFormEnum.DOCKER_IMAGE) {
            String url = distributionInfo.getComponentLoc().getDistributionLocation();
            dockerService.downloadDockerFlow(url);
            String image_id = dockerService.uploadDockerFlow(url);
            dockerService.deleteDockerFlow(url,image_id);
        }

    }

}

