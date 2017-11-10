package eu.openminted.registry.messages;

import eu.openminted.corpus.CorpusBuildingState;
import eu.openminted.corpus.CorpusStatus;
import eu.openminted.registry.core.domain.Resource;
import eu.openminted.registry.core.service.ParserService;
import eu.openminted.registry.core.service.SearchService;
import eu.openminted.registry.domain.Corpus;
import eu.openminted.registry.service.CorpusBuildingStateServiceImpl;
import eu.openminted.registry.service.IncompleteCorpusServiceImpl;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

import javax.jms.JMSException;
import javax.jms.Message;
import java.net.UnknownHostException;

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

    @JmsListener(containerFactory = "jmsTopicListenerContainerFactory", destination = "${jms.corpus.state.topic:registry.component.create}")
    public void receiveState(Message message) throws JMSException, UnknownHostException {
        String responseBody = ((TextMessage) message).getText();
        JSONObject jsonObject = new JSONObject(responseBody);
        log.info(responseBody +" is here!");
    }

}

