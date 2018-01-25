//package eu.openminted.registry.service.messages;
//
//import com.google.gson.Gson;
//import eu.openminted.messageservice.connector.MessagesHandler;
//import eu.openminted.messageservice.messages.WorkflowExecutionStatusMessage;
//import eu.openminted.registry.core.service.ParserService;
//import eu.openminted.registry.core.service.ParserService.ParserServiceTypes;
//import eu.openminted.registry.domain.operation.Corpus;
//import eu.openminted.registry.domain.operation.Date;
//import eu.openminted.registry.domain.operation.Error;
//import eu.openminted.registry.domain.operation.Operation;
//import eu.openminted.registry.service.generate.AnnotatedCorpusMetadataGenerate;
//import eu.openminted.registry.service.omtd.CorpusServiceImpl;
//import eu.openminted.registry.service.OperationServiceImpl;
//import eu.openminted.workflow.api.ExecutionStatus;
//import org.apache.logging.log4j.Logger;
//import org.apache.logging.log4j.LogManager;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Component;
//
//import javax.jms.JMSException;
//import javax.jms.Message;
//import javax.jms.TextMessage;
//
//import java.util.List;
//import java.util.concurrent.Future;
//
//
//@Component
//public class OperationHandler implements MessagesHandler {
//
//	private static final Logger logger = LogManager.getLogger(OperationHandler.class);
//
//	@Autowired
//	private OperationServiceImpl operationService;
//
//	@Autowired
//	private AnnotatedCorpusMetadataGenerate corpusMetadataGenerator;
//
//	@Autowired
//	private CorpusServiceImpl corpusService;
//
//	@Autowired
//	public ParserService parserPool;
//
//	@Override
//	public void handleMessage(Message msg) {
//
//		try{
//
//			if (msg instanceof TextMessage) {
//				// Extract message as text
//				TextMessage textMessage = (TextMessage) msg;
//				logger.info("text message:" + textMessage.getText());
//
//				// Transform text message to message object (aka WorkflowExecutionStatusMessage)
//				Gson gson = new Gson();
//				WorkflowExecutionStatusMessage workflowExeMsg = gson.fromJson(textMessage.getText(), WorkflowExecutionStatusMessage.class);
//				if(workflowExeMsg.getWorkflowStatus() == null) {
//					throw new NullPointerException("No status is set to WorkflowExecutionStatusMessage");
//				}
//
//
//				// Set a workflow experiment for execution, ie create a new operation document
//				if (workflowExeMsg.getWorkflowStatus().equalsIgnoreCase(ExecutionStatus.Status.PENDING.toString())) {
//					if(workflowExeMsg.getWorkflowExecutionID() == null || workflowExeMsg.getUserID() == null ||
//							workflowExeMsg.getWorkflowID() == null || workflowExeMsg.getCorpusID() == null) {
//						throw new NullPointerException("Missing elements in WorkflowExecutionStatusMessage for status " + ExecutionStatus.Status.PENDING.toString());
//					}
//
//					Operation operation = new Operation();
//					operation.setId(workflowExeMsg.getWorkflowExecutionID());
//					operation.setStatus(ExecutionStatus.Status.PENDING.toString());
//					operation.setPerson(workflowExeMsg.getUserID());
//					operation.setComponent(workflowExeMsg.getWorkflowID());
//
//					// Create corpus
//					Corpus operationCorpus = new Corpus();
//					operationCorpus.setInput(workflowExeMsg.getCorpusID());
//					operation.setCorpus(operationCorpus);
//
//					// Create date
//					Date date = new Date();
//					date.setSubmitted(new java.util.Date());
//					operation.setDate(date);
//
//					// Add operation to registry
//					Future<String> operationString = parserPool.deserialize(operation, ParserServiceTypes.JSON);
//					logger.info("Insert Operation " + operationString.get());
//					operationService.add(operation);
//				}
//				// Set a workflow experiment to started, ie update an operation document
//				else if (workflowExeMsg.getWorkflowStatus().equalsIgnoreCase(ExecutionStatus.Status.RUNNING.toString())) {
//					if(workflowExeMsg.getWorkflowExecutionID() == null) {
//						throw new NullPointerException("Missing elements in WorkflowExecutionStatusMessage for status " + ExecutionStatus.Status.RUNNING.toString());
//					}
//					// Get operation object from registry
//					Operation operation = operationService.getOperation(workflowExeMsg.getWorkflowExecutionID());
//
//					// Update operation
//					operation.setStatus(ExecutionStatus.Status.RUNNING.toString());
//					Date date = operation.getDate();
//					date.setStarted(new java.util.Date());
//					operation.setDate(date);
//
//					// Update operation to registry
//					Future<String> operationString = parserPool.deserialize(operation, ParserServiceTypes.JSON);
//					logger.info("Update Operation " + operation.getId() + " to status " + workflowExeMsg.getWorkflowStatus().toUpperCase());
//					operationService.update(operation);
//				}
//				// Set a workflow experiment to finished, ie update an operation document, create ouput corpus metadata
//				else if (workflowExeMsg.getWorkflowStatus().equalsIgnoreCase(ExecutionStatus.Status.FINISHED.toString())) {
//					if(workflowExeMsg.getWorkflowExecutionID() == null || workflowExeMsg.getResultingCorpusID() == null) {
//						throw new NullPointerException("Missing elements in WorkflowExecutionStatusMessage for status " + ExecutionStatus.Status.FINISHED.toString());
//					}
//					// Get operation object from registry
//					Operation operation = operationService.getOperation(workflowExeMsg.getWorkflowExecutionID());
//
//					// Update operation
//					operation.setStatus(ExecutionStatus.Status.FINISHED.toString());
//					Date date = operation.getDate();
//					date.setFinished(new java.util.Date());
//					operation.setDate(date);
//
//					Corpus operationCorpus = operation.getCorpus();
//
//					// Generate output corpus metadata
//					logger.info("Generating metadata for annotated corpus from experiment " + workflowExeMsg.getWorkflowExecutionID());
//					eu.openminted.registry.domain.Corpus outputCorpusMeta = corpusMetadataGenerator.generateAnnotatedCorpusMetadata(operationCorpus.getInput(),
//							operation.getComponent(), operation.getPerson(), workflowExeMsg.getResultingCorpusID());
//
//
//					String outputCorpusOmtdId = outputCorpusMeta.getMetadataHeaderInfo().getMetadataRecordIdentifier().getValue();
//					logger.info("Output corpus id :: " + outputCorpusOmtdId);
//					operationCorpus.setOutput(outputCorpusOmtdId);
//					operation.setCorpus(operationCorpus);
//
//					// Add output corpus metadata to registry
//					corpusService.add(outputCorpusMeta);
//
//
//
//					// Update operation to registry
//					Future<String> operationString = parserPool.deserialize(operation, ParserServiceTypes.JSON);
//					logger.info("Update Operation " + operation.getId() + " to status " + workflowExeMsg.getWorkflowStatus().toUpperCase());
//					operationService.update(operation);
//				}
//				else if (workflowExeMsg.getWorkflowStatus().equalsIgnoreCase(ExecutionStatus.Status.FAILED.toString())) {
//					if(workflowExeMsg.getWorkflowExecutionID() == null || workflowExeMsg.getError() == null) {
//						throw new NullPointerException("Missing elements in WorkflowExecutionStatusMessage for status " + ExecutionStatus.Status.FAILED.toString());
//					}
//					// Get operation object from registry
//					Operation operation = operationService.getOperation(workflowExeMsg.getWorkflowExecutionID());
//
//					// Update status
//					operation.setStatus(workflowExeMsg.getWorkflowStatus().toUpperCase());
//
//					// Update Error
//					if (workflowExeMsg.getError() != null) {
//
//						List<Error> my_errors = operation.getErrors();
//
//						Error my_new_error = new Error();
//						my_new_error.setMessage(workflowExeMsg.getError());
//						my_new_error.setTimestamp(new java.util.Date());
//						my_errors.add(my_new_error);
//
//						operation.setErrors(my_errors);
//					}
//
//					// Update operation to registry
//					Future<String> operationString = parserPool.deserialize(operation, ParserServiceTypes.JSON);
//					logger.info("Update Operation " + operation.getId() + " to status " + workflowExeMsg.getWorkflowStatus().toUpperCase());
//					operationService.update(operation);
//				}
//				// Set a workflow experiment to resumed, failed, paused, ie update an operation document
//				else {
//					if(workflowExeMsg.getWorkflowExecutionID() == null) {
//						throw new NullPointerException("Missing elements in WorkflowExecutionStatusMessage for status " + workflowExeMsg.getWorkflowStatus().toUpperCase());
//					}
//					// Get operation object from registry
//					Operation operation = operationService.getOperation(workflowExeMsg.getWorkflowExecutionID());
//
//					// Update status
//					operation.setStatus(workflowExeMsg.getWorkflowStatus().toUpperCase());
//
//					// Update operation to registry
//					Future<String> operationString = parserPool.deserialize(operation, ParserServiceTypes.JSON);
//					logger.info("Update Operation " + operation.getId() + " to status " + workflowExeMsg.getWorkflowStatus().toUpperCase());
//					operationService.update(operation);
//				}
//
//			}
//			else {
//				logger.info("Handling a non text message :: " + msg.toString());;
//
//			}
//		}catch(JMSException e){
//	    	logger.info(e.getMessage());
//	    }
//		catch(Exception e){
//	    	logger.info(e);
//	    }
//	}
//
//
//
//}
