package eu.openminted.registry.messages;

import eu.openminted.registry.core.exception.ResourceNotFoundException;
import eu.openminted.registry.core.service.ParserService;
import eu.openminted.registry.core.service.ParserService.ParserServiceTypes;
import eu.openminted.registry.core.service.ResourceCRUDService;
import eu.openminted.registry.domain.operation.Corpus;
import eu.openminted.registry.domain.operation.Date;
import eu.openminted.registry.domain.operation.Error;
import eu.openminted.registry.domain.operation.Operation;
import eu.openminted.registry.generate.AnnotatedCorpusMetadataGenerate;
import eu.openminted.registry.service.CorpusServiceImpl;
import eu.openminted.registry.service.OperationService;
import eu.openminted.registry.service.OperationServiceImpl;
import eu.openminted.workflow.api.ExecutionStatus;
import eu.openminted.workflow.api.WorkflowExecutionStatusMessage;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.Future;


@Component
public class OperationHandler {

    private static final Logger logger = LogManager.getLogger(OperationHandler.class);

    @Autowired
    private ResourceCRUDService<Operation> operationService;

    @Autowired
    private AnnotatedCorpusMetadataGenerate corpusMetadataGenerator;

    @Autowired
    private CorpusServiceImpl corpusService;

    @Autowired
    public ParserService parserPool;

    @JmsListener(containerFactory = "jmsQueueListenerContainerFactory", destination = "${jms.workflows.execution:workflows.execution.test.katerina}")
    public void handleOperation(WorkflowExecutionStatusMessage workflowExeMsg) throws IOException, ResourceNotFoundException {
        synchronized (OperationServiceImpl.class) {
            logger.info("Operation Handler with " + operationService);
            System.out.println("Received the message " + workflowExeMsg.toString());
            if (workflowExeMsg.getWorkflowStatus() == null) {
                throw new NullPointerException("No status is set to WorkflowExecutionStatusMessage");
            }

            // Set a workflow experiment for execution, ie create a new operation document
            if (workflowExeMsg.getWorkflowStatus().equalsIgnoreCase(ExecutionStatus.Status.PENDING.toString())) {
                //logger.info("Ignoring and waiting PENDING for operation with id " + workflowExeMsg.getWorkflowExecutionID());
                casePending(workflowExeMsg); 
            }
            // Set a workflow experiment to started, ie update an operation document
            else if (workflowExeMsg.getWorkflowStatus().equalsIgnoreCase(ExecutionStatus.Status.RUNNING.toString())) {
                caseRunning(workflowExeMsg);
            }
            // Set a workflow experiment to finished, ie update an operation document, create output metadata
            else if (workflowExeMsg.getWorkflowStatus().equalsIgnoreCase(ExecutionStatus.Status.FINISHED.toString())) {
                caseFinished(workflowExeMsg);               
            }
            // Set a workflow experiment to failed, ie update an operation document
            else if (workflowExeMsg.getWorkflowStatus().equalsIgnoreCase(ExecutionStatus.Status.FAILED.toString())) {
                caseFailed(workflowExeMsg);
            }
            // Set a workflow experiment to resumed, failed, paused, ie update an operation document
            else {
                if (workflowExeMsg.getWorkflowExecutionID() == null) {
                    throw new NullPointerException("Missing elements in WorkflowExecutionStatusMessage for status " + workflowExeMsg.getWorkflowStatus().toUpperCase());
                }
                // Get operation object from registry
                Operation operation = operationService.get(workflowExeMsg.getWorkflowExecutionID());

                // Update status
                operation.setStatus(workflowExeMsg.getWorkflowStatus().toUpperCase());

                // Update operation to registry
                Future<String> operationString = parserPool.serialize(operation, ParserServiceTypes.JSON);
                logger.info("Update Operation " + operation.getId() + " to status " + workflowExeMsg.getWorkflowStatus().toUpperCase());
                operationService.update(operation);
            }
        }
    }
    
    private void casePending(WorkflowExecutionStatusMessage workflowExeMsg) {
    	if (workflowExeMsg.getWorkflowExecutionID() == null) {
    		throw new NullPointerException("Missing elements in WorkflowExecutionStatusMessage for status " + ExecutionStatus.Status.PENDING.toString());
        }
    	Operation operation = new Operation();
    	// Id
    	operation.setId(workflowExeMsg.getWorkflowExecutionID());
    	// Status
    	operation.setStatus(ExecutionStatus.Status.PENDING.toString());
    	// Date of submitted
    	Date date = new Date();
    	date.setSubmitted(new java.util.Date());
    	operation.setDate(date);
    	// Input Corpus
    	Corpus operationCorpus = new Corpus();
    	operationCorpus.setInput(workflowExeMsg.getCorpusID());
    	operation.setCorpus(operationCorpus);
    	// Component
    	operation.setComponent(workflowExeMsg.getWorkflowID());
    	// User
    	operation.setPerson(workflowExeMsg.getUserID());
    	
    	Future<String> operationString = parserPool.serialize(operation, ParserServiceTypes.JSON);
    	logger.info("Add Operation " + operation.getId() + " to status " + workflowExeMsg.getWorkflowStatus().toUpperCase());
    	operationService.add(operation);
    	
    }

    private void caseRunning(WorkflowExecutionStatusMessage workflowExeMsg) throws ResourceNotFoundException {
        if (workflowExeMsg.getWorkflowExecutionID() == null) {
            throw new NullPointerException("Missing elements in WorkflowExecutionStatusMessage for status " + ExecutionStatus.Status.RUNNING.toString());
        }
        // Get operation object from registry

        Operation operation = operationService.get(workflowExeMsg.getWorkflowExecutionID());

        // Update operation
        operation.setStatus(ExecutionStatus.Status.RUNNING.toString());
        Date date = operation.getDate();
        date.setStarted(new java.util.Date());
        operation.setDate(date);

        // Update operation to registry
        Future<String> operationString = parserPool.serialize(operation, ParserServiceTypes.JSON);
        logger.info("Update Operation " + operation.getId() + " to status " + workflowExeMsg.getWorkflowStatus().toUpperCase());
        operationService.update(operation);
    }

    private void caseFinished(WorkflowExecutionStatusMessage workflowExeMsg) throws IOException, ResourceNotFoundException {
        if (workflowExeMsg.getWorkflowExecutionID() == null || workflowExeMsg.getResultingCorpusID() == null) {
            throw new NullPointerException("Missing elements in WorkflowExecutionStatusMessage for status " + ExecutionStatus.Status.FINISHED.toString());
        }
        // Get operation object from registry
        Operation operation = operationService.get(workflowExeMsg.getWorkflowExecutionID());

        // Update operation
        operation.setStatus(ExecutionStatus.Status.FINISHED.toString());
        Date date = operation.getDate();
        date.setFinished(new java.util.Date());
        operation.setDate(date);

        Corpus operationCorpus = operation.getCorpus();

        //TODO add service for other types of outputs, eg language/conceptual resource and language description
        // Generate output corpus metadata
        logger.info("Generating metadata for annotated corpus from experiment " + workflowExeMsg.getWorkflowExecutionID());
        eu.openminted.registry.domain.Corpus outputCorpusMeta = corpusMetadataGenerator.generateAnnotatedCorpusMetadata(operationCorpus.getInput(),
                operation.getComponent(), operation.getPerson(), workflowExeMsg.getResultingCorpusID());


        String outputCorpusOmtdId = outputCorpusMeta.getMetadataHeaderInfo().getMetadataRecordIdentifier().getValue();
        logger.info("Output corpus id :: " + outputCorpusOmtdId);
        operationCorpus.setOutput(outputCorpusOmtdId);
        operation.setCorpus(operationCorpus);

        // Add output corpus metadata to registry
        logger.info("Adding output corpus to registry");
        corpusService.add(outputCorpusMeta);

        // Update operation to registry
        Future<String> operationString = parserPool.serialize(operation, ParserServiceTypes.JSON);
        logger.info("Update Operation " + operation.getId() + " to status " + workflowExeMsg.getWorkflowStatus().toUpperCase());
        operationService.update(operation);
    }

    private void caseFailed(WorkflowExecutionStatusMessage workflowExeMsg) throws ResourceNotFoundException {
        if (workflowExeMsg.getWorkflowExecutionID() == null || workflowExeMsg.getError() == null) {
            throw new NullPointerException("Missing elements in WorkflowExecutionStatusMessage for status " + ExecutionStatus.Status.FAILED.toString());
        }
        // Get operation object from registry
        Operation operation = operationService.get(workflowExeMsg.getWorkflowExecutionID());

        // Update status
        operation.setStatus(workflowExeMsg.getWorkflowStatus().toUpperCase());

        // Update Error
        if (workflowExeMsg.getError() != null) {

            List<Error> my_errors = operation.getErrors();

            Error my_new_error = new Error();
            my_new_error.setMessage(workflowExeMsg.getError());
            my_new_error.setTimestamp(new java.util.Date());
            my_errors.add(my_new_error);

            operation.setErrors(my_errors);
        }

        // Update operation to registry
        Future<String> operationString = parserPool.serialize(operation, ParserServiceTypes.JSON);
        logger.info("Update Operation " + operation.getId() + " to status " + workflowExeMsg.getWorkflowStatus().toUpperCase());
        operationService.update(operation);
    }

}
