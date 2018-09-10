package eu.openminted.registry.service.messages;

import eu.openminted.registry.core.domain.Resource;
import eu.openminted.registry.core.service.*;
import eu.openminted.registry.domain.Corpus;
import eu.openminted.registry.domain.connector.CorpusBuildingState;
import eu.openminted.registry.service.IncompleteCorpusService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.mitre.openid.connect.model.OIDCAuthenticationToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

import java.net.UnknownHostException;

@Component("jmsConsumer")
public class JMSConsumer {
    private static Logger logger = LogManager.getLogger(JMSConsumer.class);

    @Autowired
    private SearchService searchService;

    @Autowired
    @Qualifier("corpusBuildingStateService")
    private ResourceCRUDService<CorpusBuildingState, OIDCAuthenticationToken> corpusBuildingStateService;

    @Autowired
    private IncompleteCorpusService incompleteCorpusService;

    @JmsListener(containerFactory = "jmsQueueListenerContainerFactory", destination = "${jms.corpus.state" +
            ".topic:corpus.state}")
    public void receiveState(CorpusBuildingState corpusBuildingState) throws UnknownHostException {
        try {
            logger.info("State of corpus building: " + corpusBuildingState);
            SearchService.KeyValue kv = new SearchService.KeyValue("corpus_id", corpusBuildingState.getOmtdId());
            Resource resource = searchService.searchId("corpusbuildingstate", kv);
            if (resource == null) {
                corpusBuildingStateService.add(corpusBuildingState,null);
            } else {
                corpusBuildingStateService.update(corpusBuildingState,null);
            }
            if (corpusBuildingState.getCurrentStatus().equals(CorpusBuildingState.CurrentStatus.CREATED)) {
                String corpusId = corpusBuildingState.getOmtdId().split("@")[0];
                Corpus incompleteCorpus = incompleteCorpusService.get(corpusId);
                if (incompleteCorpus != null) {
                    incompleteCorpusService.move(corpusId);
                }
            }
        } catch (Exception e) {
            logger.error("Error in moving corpus", e);
            throw new ServiceException(e);
        }
    }
}

