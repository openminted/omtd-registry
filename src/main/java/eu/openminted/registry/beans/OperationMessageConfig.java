package eu.openminted.registry.beans;


//import eu.openminted.registry.service.messages.OperationHandler;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import eu.openminted.messageservice.connector.MessageServiceSubscriber;
import eu.openminted.messageservice.connector.TopicsRegistry;

@Configuration
@PropertySource(value = { "classpath:application.properties", "classpath:registry.properties"} )
public class OperationMessageConfig {

	static final Logger logger = LogManager.getLogger(OperationMessageConfig.class);
	@Value("${jms.host}")
	private String messagesHost;

//	@Autowired
//	private OperationHandler operationHandler;

	@Bean
	public MessageServiceSubscriber messageServiceSubscription() {
		// Connect to Message Service as subscriber
		logger.info("Creating a message service subscription to  ::" + this.messagesHost );
		MessageServiceSubscriber msgServiceSub = new MessageServiceSubscriber(this.messagesHost);

		// Watch topics
		logger.info("Subscribed to topic :: " + TopicsRegistry.workflowsExecution);
		msgServiceSub.addTopic(TopicsRegistry.workflowsExecution);

		// Set topic handler
//		msgServiceSub.setMessagesHandler(this.operationHandler);


		return  msgServiceSub;
	}

}
