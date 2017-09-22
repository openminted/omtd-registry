package eu.openminted.registry.messages;

import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Future;

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
import eu.openminted.registry.core.service.ParserService;
import eu.openminted.registry.core.service.ParserService.ParserServiceTypes;
import eu.openminted.registry.domain.ResourceIdentifier;
import eu.openminted.registry.domain.ResourceIdentifierSchemeNameEnum;
import eu.openminted.registry.domain.operation.Corpus;
import eu.openminted.registry.domain.operation.Date;
import eu.openminted.registry.domain.operation.Operation;
import eu.openminted.registry.generate.AnnotatedCorpusMetadataGenerate;
import eu.openminted.registry.service.CorpusServiceImpl;
import eu.openminted.registry.service.OperationServiceImpl;

@Component
public class OperationHandler implements MessagesHandler {

	static final Logger logger = Logger.getLogger(OperationHandler.class);

	@Autowired
	private OperationServiceImpl operationService;
	
	@Autowired
	private AnnotatedCorpusMetadataGenerate corpusMetadataGenerator;
	
	@Autowired
	private CorpusServiceImpl corpusService;
	
	static private String[] workflowExecutionStatus = {
	        "PENDING",
	        "RUNNING",
	        "PAUSED",
	        "FINISHED",
	        "CANCELED",
	        "FAILED"
	};
	
	@Autowired
	public ParserService parserPool;
		
	@Override
	public void handleMessage(Message msg) {
		
		try{
			
			if (msg instanceof TextMessage) {
				// Extract message as text 
				TextMessage textMessage = (TextMessage) msg;
				logger.info("text message:" + textMessage.getText());
				
				// Transform text message to message object (aka WorkflowExecutionStatusMessage)
				Gson gson = new Gson();		
				WorkflowExecutionStatusMessage workflowExeMsg = gson.fromJson(textMessage.getText(), WorkflowExecutionStatusMessage.class);
											
				// Set a workflow experiment for execution, ie create a new operation document
				if (workflowExeMsg.getWorkflowStatus().equalsIgnoreCase(OperationStatus.PENDING.toString())) {
					if(workflowExeMsg.getWorkflowExecutionID() == null || workflowExeMsg.getUserID() == null ||
							workflowExeMsg.getWorkflowID() == null || workflowExeMsg.getCorpusID() == null) {
						throw new Exception("Missing elements in WorkflowExecutionStatusMessage for status " + workflowExecutionStatus[0]);
					}

					Operation operation = new Operation();
					operation.setId(workflowExeMsg.getWorkflowExecutionID());
					// TODO discard Job in next version
					operation.setJob(workflowExeMsg.getWorkflowExecutionID());
					operation.setStatus(OperationStatus.PENDING.toString());
					operation.setPerson(workflowExeMsg.getUserID());
					operation.setComponent(workflowExeMsg.getWorkflowID());					
					
					// Create corpus
					Corpus operationCorpus = new Corpus();
					operationCorpus.setInput(workflowExeMsg.getCorpusID());
					operation.setCorpus(operationCorpus);
					
					// Create date
					Date date = new Date();
					date.setSubmitted(new java.util.Date());
					// TODO discard Date.started in next version
					date.setStarted(new java.util.Date());
					operation.setDate(date);
					
					// Add operation to registry
					Future<String> operationString = parserPool.deserialize(operation, ParserServiceTypes.JSON);
					logger.info("Inserting Operation " + operationString.get());					
					operationService.add(operation);
				    
				}
				// Set a workflow experiment to started, ie update an operation document
				else if (workflowExeMsg.getWorkflowStatus().equalsIgnoreCase(OperationStatus.RUNNING.toString())) {		
					if(workflowExeMsg.getWorkflowExecutionID() == null) {
						throw new Exception("Missing elements in WorkflowExecutionStatusMessage for status " + workflowExecutionStatus[1]);
					}
					// Get operation object from registry
					Operation operation = operationService.getOperation(workflowExeMsg.getWorkflowExecutionID());
							
					// Update operation 
					operation.setStatus(OperationStatus.RUNNING.toString());
					Date date = operation.getDate();
					date.setStarted(new java.util.Date());
					operation.setDate(date);
																			
					// Update operation to registry		
					Future<String> operationString = parserPool.deserialize(operation, ParserServiceTypes.JSON);
					logger.info("Update Operation " + operationString.get());				
					operationService.update(operation);
						
				} 	
				// Set a workflow experiment to finished, ie update an operation document, create ouput corpus metadata
				else if (workflowExeMsg.getWorkflowStatus().equalsIgnoreCase(OperationStatus.FINISHED.toString())) {		
					if(workflowExeMsg.getWorkflowExecutionID() == null || workflowExeMsg.getResultingCorpusID() == null) {
						throw new Exception("Missing elements in WorkflowExecutionStatusMessage for status " + workflowExecutionStatus[0]);
					}
					// Get operation object from registry
					Operation operation = operationService.getOperation(workflowExeMsg.getWorkflowExecutionID());							
														
					// Update operation 
					operation.setStatus(OperationStatus.FINISHED.toString());
					Date date = operation.getDate();
					date.setFinished(new java.util.Date());
					operation.setDate(date);
					
					Corpus operationCorpus = operation.getCorpus();
					// Generate output corpus metadata
					logger.info("Generating metadata for annotated corpus from experiment " + workflowExeMsg.getWorkflowExecutionID());
					eu.openminted.registry.domain.Corpus outputCorpusMeta = corpusMetadataGenerator.generateAnnotatedCorpusMetadata(operationCorpus.getInput(), 
							operation.getComponent(), operation.getPerson(), workflowExeMsg.getResultingCorpusID());
										
					String outputCorpusOmtdId = outputCorpusMeta.getMetadataHeaderInfo().getMetadataRecordIdentifier().getValue(); 
					logger.debug("Output corpus id :: " + outputCorpusOmtdId);
				    operationCorpus.setOutput(outputCorpusOmtdId);
					operation.setCorpus(operationCorpus);
					
					// Add ouput corpus metadata to registry 
				//	Future<String> serialized = parserPool.deserialize(outputCorpusMeta, ParserService.ParserServiceTypes.XML);
				//	logger.debug("Output corpus metadata xml format::\n" + serialized.get());
					corpusService.add(outputCorpusMeta);
					// TODO email user
					
															
					// Update operation to registry			
					Future<String> operationString = parserPool.deserialize(operation, ParserServiceTypes.JSON);
					logger.info("Update Operation " + operationString.get());					
					operationService.update(operation);
						
				}
				// Set a workflow experiment to resumed, failed, paused, ie update an operation document
				else {
					// Get operation object from registry
					Operation operation = operationService.getOperation(workflowExeMsg.getWorkflowExecutionID());
														
					// Update status
					operation.setStatus(workflowExeMsg.getWorkflowStatus().toUpperCase());
					
					// Update operation to registry		
					Future<String> operationString = parserPool.deserialize(operation, ParserServiceTypes.JSON);
					logger.info("Update Operation " + operationString.get());								
					operationService.update(operation);
							
				}
					
			}
			else {
				logger.info("Handling a non text message :: " + msg.toString());;
			
			}
		}catch(JMSException e){
	    	logger.info(e.getMessage());	    	
	    }
		catch(Exception e){
	    	logger.info(e);	    	
	    }
	}
	
	

}
