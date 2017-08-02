package eu.openminted.registry.messaging;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.TextMessage;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.support.converter.MappingJackson2MessageConverter;
import org.springframework.jms.support.converter.SimpleMessageConverter;
import org.springframework.stereotype.Component;

import eu.openminted.messageservice.connector.MessagesHandler;
//import eu.openminted.messageservice.messages.GSON;
import com.google.gson.Gson;
import eu.openminted.messageservice.messages.WorkflowExecutionStatusMessage;
import eu.openminted.registry.service.OperationServiceImpl;

@Component
public class OperationHandler implements MessagesHandler {

	static final Logger logger = Logger.getLogger(OperationHandler.class);

	@Autowired
	OperationServiceImpl operationService;
	
		
	@Override
	public void handleMessage(Message msg) {
		
		try{
			
			if (msg instanceof TextMessage) {
				TextMessage textMessage = (TextMessage) msg;
				logger.info("text message:" + textMessage.getText());
				Gson gson = new Gson();
				WorkflowExecutionStatusMessage staff = gson.fromJson(textMessage.getText(), WorkflowExecutionStatusMessage.class);
				logger.info("Sending message - workflow execution :: " + staff.getWorkflowExecutionID() );
				logger.info("Sending message - status :: " + staff.getWorkflowStatus() );
			      
				//logger.info("get property workflowExecution::" + textMessage.getStringProperty("workflowExecutionID"));
				//MappingJackson2MessageConverter mapping = new MappingJackson2MessageConverter(); 
				//Operation operation = mapping.fromMessage(msg);
				//logger.info("Object " + operation.toString());
			}
			else {
				logger.info("Handling a non text message :: ");;
			
			}
		}catch(JMSException e){
	    	logger.info(e.getMessage());	    	
	    }
	}

}
