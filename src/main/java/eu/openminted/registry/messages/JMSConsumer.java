package eu.openminted.registry.messages;

import com.fasterxml.jackson.databind.ObjectMapper;
import eu.openminted.corpus.CorpusBuildingState;
import eu.openminted.corpus.CorpusStatus;
import eu.openminted.registry.core.domain.Facet;
import eu.openminted.registry.core.domain.Resource;
import eu.openminted.registry.core.service.ParserService;
import eu.openminted.registry.core.service.SearchService;
import eu.openminted.registry.core.service.ServiceException;
import eu.openminted.registry.domain.Corpus;
import eu.openminted.registry.service.CorpusBuildingStateServiceImpl;
import org.apache.activemq.ActiveMQConnectionFactory;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.jms.*;
import java.io.IOException;

@Component("jmsConsumer")
public class JMSConsumer { // implementsExceptionListener, MessageListener
    private static Logger log = LogManager.getLogger(JMSConsumer.class.getName());

    @Value("${jms.content.corpus.topic}")
    private String topicName;

    @Value("${jms.host}")
    private String jmsHost;


    @Autowired
    public ParserService parserPool;

    @Autowired
    CorpusBuildingStateServiceImpl corpusBuildingStateService;

    @Autowired
    IncompleteCorpusServiceImpl incompleteCorpusService;

    @JmsListener(containerFactory = "jmsListenerContainerFactory", destination = "test")
    public void receiveMessage(Facet message) throws JMSException {
        log.info(message);
    }



    @JmsListener(containerFactory = "jmsListenerContainerFactory", destination = "${jms.content.corpus.topic}")
    public void onMessage(Message message) {
        log.info(message);
        if (message instanceof TextMessage) {
            try {
                TextMessage textMessage = (TextMessage) message;
                String text = textMessage.getText();
                log.info("Message Received: " + text);
                CorpusBuildingState corpusBuildingState = null;

                try {
                    JMSMessage messageReceived = new ObjectMapper().readValue(text, JMSMessage.class);

                    if (messageReceived.getType().equals(CorpusBuildingState.class.toString())) {
                        corpusBuildingState = new ObjectMapper().readValue(messageReceived.getMessage(), CorpusBuildingState.class);
                        log.info("State of corpus building: " + corpusBuildingState);

                        CorpusBuildingState existingCorpusBuildingState = corpusBuildingStateService.get(corpusBuildingState.getId());

                        System.out.println("\n\nGoing commando existingCorpusBuildingState: " + existingCorpusBuildingState + "\n\n");
                        if (existingCorpusBuildingState != null) {
                            corpusBuildingStateService.update(corpusBuildingState);
                        }
                    }
                } catch (AuthenticationCredentialsNotFoundException e) {
                    if (corpusBuildingState != null)
                        corpusBuildingStateService.add(corpusBuildingState);
                } catch (IOException e) {
                    log.error(e);
                }
            } catch (JMSException e) {
                log.error("Error Receiving Message", e);
            }
        } else {
            log.info("Message Received: " + message);
        }
    }
}

