package eu.openminted.registry.messages;

import com.fasterxml.jackson.databind.ObjectMapper;
import eu.openminted.corpus.CorpusBuildingState;
import eu.openminted.registry.service.CorpusBuildingStateServiceImpl;
import org.apache.activemq.ActiveMQConnectionFactory;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationCredentialsNotFoundException;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.jms.*;
import java.io.IOException;

@Component("jmsConsumer")
public class JMSConsumer implements ExceptionListener, MessageListener {
    private static Logger log = Logger.getLogger(JMSConsumer.class.getName());

    @org.springframework.beans.factory.annotation.Value("${jms.content.corpus.topic}")
    private String topicName;

    @org.springframework.beans.factory.annotation.Value("${jms.host}")
    private String jmsHost;


//    @Autowired
    private ActiveMQConnectionFactory connectionFactory;

    @Autowired
    CorpusBuildingStateServiceImpl corpusBuildingStateService;

    @PostConstruct
    public void init() {
        connectionFactory =  new ActiveMQConnectionFactory(jmsHost);
        connectionFactory.setConnectionIDPrefix("omtd-registry");
    }

    private Connection connection;

    private Session session;

    public void listen() {
        try {
            // Create a Connection
            connection = connectionFactory.createConnection();
//            connection = new ActiveMQConnectionFactory(jmsHost).createConnection();
            connection.setExceptionListener(this);

            // Set unique clientID to connection prior to connect
            connection.setClientID(Integer.toString(this.hashCode()));
            connection.start();


            // Create a Session
            session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);

            // Create the Topic
            Topic topic = session.createTopic(topicName);

            // Create a TopicSubscriber from the Session to the Topic
            TopicSubscriber subscriber = session.createDurableSubscriber(topic, "SUBSCRIBER");
            subscriber.setMessageListener(this);

        } catch (Exception e) {
            log.error("Caught Exception: " + e);
        }
    }

    public synchronized void onException(JMSException ex) {
        log.error("JMS Exception occurred.  Shutting down client.");

        try {
            session.close();
            connection.close();
        } catch (JMSException e) {
            log.error("JMS Exception occurred while shutting down client.", e);
        }
    }

    @Override
    public void onMessage(Message message) {
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

