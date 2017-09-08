package eu.openminted.registry.messages;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.TextMessage;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import eu.openminted.messageservice.connector.MessagesHandler;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.util.ISO8601DateFormat;
//import eu.openminted.messageservice.messages.GSON;
import com.google.gson.Gson;
import eu.openminted.messageservice.messages.WorkflowExecutionStatusMessage;
import eu.openminted.registry.domain.operation.Corpus;
import eu.openminted.registry.domain.operation.Date;
import eu.openminted.registry.domain.operation.Operation;
import eu.openminted.registry.service.OperationServiceImpl;

@Component
public class OperationHandler implements MessagesHandler {

	static final Logger logger = Logger.getLogger(OperationHandler.class);

	@Autowired
	private OperationServiceImpl operationService;
	
	static private String[] workflowExecutionStatus = {
	        "PENDING",
	        "RUNNING",
	        "PAUSED",
	        "FINISHED",
	        "CANCELED",
	        "FAILED"
	};
		
	@Override
	public void handleMessage(Message msg) {
		
		try{
			
			if (msg instanceof TextMessage) {
				// Extract message as text 
				TextMessage textMessage = (TextMessage) msg;
				logger.info("text message:" + textMessage.getText());
				
				// Transform text message to message object (aka WorkflowExecutionStatusMessage)
				Gson gson = new Gson();
				WorkflowExecutionStatusMessage workflowExecutionMsg = gson.fromJson(textMessage.getText(), WorkflowExecutionStatusMessage.class);
				logger.info("Received message :: " + workflowExecutionMsg.toString() );
			
				// Generate appropriate Operation object
				
				// Set a workflow experiment for execution, ie create a new operation document
				if (workflowExecutionMsg.getWorkflowStatus().equalsIgnoreCase(workflowExecutionStatus[0])) {
					Operation operation = new Operation();
					// Operation ID
					operation.setId(workflowExecutionMsg.getWorkflowExecutionID());
					// TODO discard Job in next version
					operation.setJob(workflowExecutionMsg.getWorkflowExecutionID());
					// Set Status
					operation.setStatus(workflowExecutionMsg.getWorkflowStatus().toUpperCase());
					// Set User ID
					operation.setPerson(workflowExecutionMsg.getUserID());
					// Set Workflow ID
					operation.setComponent(workflowExecutionMsg.getWorkflowID());					
					
					// Create corpus
					Corpus corpus = new Corpus();
					// Input corpus ID
					corpus.setInput(workflowExecutionMsg.getCorpusID());
					// Set corpus
					operation.setCorpus(corpus);
					
					// Create date
					Date date = new Date();
					// Submitted Data
					date.setSubmitted(new java.util.Date());
					// TODO discard Date.started in next version
					date.setStarted(new java.util.Date());
					// Set date
					operation.setDate(date);
					
					// Add operation to registry
					operationService.add(operation);
					logger.info("Operation inserted successfully");
				}
				// Set a workflow experiment to started, ie update an operation document
				else if (workflowExecutionMsg.getWorkflowStatus().equalsIgnoreCase(workflowExecutionStatus[1])) {											
					// Get operation object from registry
					Operation operation = operationService.getOperation(workflowExecutionMsg.getWorkflowExecutionID());
									
					// Update status
					operation.setStatus(workflowExecutionMsg.getWorkflowStatus().toUpperCase());
					
					// Update date
					Date date = operation.getDate();
					// Set started date
					date.setStarted(new java.util.Date());
					operation.setDate(date);
																			
					// Update operation to registry				
					operationService.update(operation);
					logger.info("Operation updated to " + workflowExecutionMsg.getWorkflowStatus() + " successfully");
					
				} 	
				// Set a workflow experiment to finished, ie update an operation document
				else if (workflowExecutionMsg.getWorkflowStatus().equalsIgnoreCase(workflowExecutionStatus[3])) {											
					// Get operation object from registry
					Operation operation = operationService.getOperation(workflowExecutionMsg.getWorkflowExecutionID());
														
					// Update status
					operation.setStatus(workflowExecutionMsg.getWorkflowStatus().toUpperCase());
					
					// Update date
					Date date = operation.getDate();
					// Set finished date
					date.setFinished(new java.util.Date());
					operation.setDate(date);
					
					// Update corpus
					Corpus corpus = operation.getCorpus();
					
					corpus.setOutput(workflowExecutionMsg.getResultingCorpusID());
					operation.setCorpus(corpus);
															
					logger.info("Operation to finished" + operation.toString());
					// Update operation to registry				
					operationService.update(operation);
					logger.info("Operation updated to " + workflowExecutionMsg.getWorkflowStatus() + " successfully");
					
				}
				else {
					// Get operation object from registry
					Operation operation = operationService.getOperation(workflowExecutionMsg.getWorkflowExecutionID());
														
					// Update status
					operation.setStatus(workflowExecutionMsg.getWorkflowStatus().toUpperCase());
					logger.info("Operation to finished" + operation.toString());
					// Update operation to registry				
					operationService.update(operation);
					logger.info("Operation updated to " + workflowExecutionMsg.getWorkflowStatus() + " successfully");
					
				}
					
			}
			else {
				logger.info("Handling a non text message :: " + msg.toString());;
			
			}
		}catch(JMSException e){
	    	logger.info(e.getMessage());	    	
	    }
		catch(Exception e){
	    	logger.info(e.getMessage());	    	
	    }
	}

}
