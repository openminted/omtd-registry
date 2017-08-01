package eu.openminted.registry.messaging;

import javax.jms.Message;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;

import eu.openminted.messageservice.connector.MessagesHandler;

@Component
public class OperationHandler implements MessagesHandler {

	static final Logger logger = Logger.getLogger(OperationHandler.class);

	@Override
	public void handleMessage(Message msg) {
	
		// TODO Auto-generated method stub
		logger.info("Handling message :: " + msg);;
	}

}
