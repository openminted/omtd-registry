package eu.openminted.registry.messages;

import eu.openminted.registry.core.exception.ResourceNotFoundException;
import eu.openminted.registry.core.service.ParserService;
import eu.openminted.registry.core.service.ParserService.ParserServiceTypes;
import eu.openminted.registry.core.service.ResourceCRUDService;
import eu.openminted.registry.domain.LanguageDescription;
import eu.openminted.registry.domain.Lexical;
import eu.openminted.registry.domain.ProcessingResourceTypeEnum;
import eu.openminted.registry.domain.operation.Corpus;
import eu.openminted.registry.domain.operation.Date;
import eu.openminted.registry.domain.operation.Error;
import eu.openminted.registry.domain.operation.Operation;
import eu.openminted.registry.generate.AnnotatedCorpusMetadataGenerate;
import eu.openminted.registry.generate.LanguageConceptualResourceMetadataGenerate;
import eu.openminted.registry.generate.LanguageDescriptionMetadataGenerate;
import eu.openminted.registry.mail.JavaMailer;
import eu.openminted.registry.service.aai.UserInfoAAIRetrieve;
import eu.openminted.registry.service.omtd.OmtdGenericService;
import eu.openminted.registry.service.other.OperationServiceImpl;
import eu.openminted.workflow.api.ExecutionStatus;
import eu.openminted.workflow.api.WorkflowExecutionStatusMessage;
import org.apache.commons.lang3.tuple.Pair;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.Future;


@Component
public class OperationHandler {

    private static final Logger logger = LogManager.getLogger(OperationHandler.class);

    @Value("${registry.host}")
    private String registryHost;

    @Autowired
    @Qualifier("operationService")
    private ResourceCRUDService<Operation> operationService;

    @Autowired
    private AnnotatedCorpusMetadataGenerate corpusMetadataGenerator;

    @Autowired
    @Qualifier("corpusService")
    private  OmtdGenericService<eu.openminted.registry.domain.Corpus> corpusService;
    
    @Autowired
    private LanguageConceptualResourceMetadataGenerate lexicalMetadataGenerator;
    
    @Autowired
    @Qualifier("lexicalService")
    private OmtdGenericService<Lexical> lexicalService;
    
    @Autowired
    @Qualifier("languageService")
    private  OmtdGenericService<LanguageDescription> languageDescriptionService;
    
    @Autowired
    private LanguageDescriptionMetadataGenerate languageMetadataGenerator;
    
    @Autowired
    @Qualifier("applicationService")
	private OmtdGenericService<eu.openminted.registry.domain.Component> applicationService;


    @Autowired
    protected UserInfoAAIRetrieve aaiUserInfoRetriever;

    @Autowired
    public ParserService parserPool;

    @Autowired
    private JavaMailer javaMailer;

    @JmsListener(containerFactory = "jmsQueueListenerContainerFactory", destination = "${jms.workflows.execution:workflows.execution}")
    public void handleOperation(WorkflowExecutionStatusMessage workflowExeMsg) throws Exception {
        synchronized (OperationServiceImpl.class) {
            logger.info("Operation Handler with " + operationService);
            String workflowMsg = parserPool.serialize(workflowExeMsg,ParserServiceTypes.JSON).get();
            logger.info("Received the message " + workflowMsg);
            if (workflowExeMsg.getWorkflowStatus() == null) {
                throw new NullPointerException("No status is set to WorkflowExecutionStatusMessage");
            }

            // Set a workflow experiment for execution, ie create a new operation document
            if (workflowExeMsg.getWorkflowStatus().equalsIgnoreCase(ExecutionStatus.Status.PENDING.toString())) {
                logger.info("Ignoring and waiting PENDING for operation with id " + workflowExeMsg.getWorkflowExecutionID());
                //casePending(workflowExeMsg); 
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
    /*
     * Function to be used only for testing reasons. 
     */
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

    private void caseFinished(WorkflowExecutionStatusMessage workflowExeMsg) throws IOException, ResourceNotFoundException, NullPointerException {

        if (workflowExeMsg.getWorkflowExecutionID() == null || workflowExeMsg.getResultingCorpusID() == null) {
            logger.debug("Missing elements in WorkflowExecutionStatusMessage for status " + ExecutionStatus.Status.FINISHED.toString());
            throw new NullPointerException("Missing elements in WorkflowExecutionStatusMessage for status " + ExecutionStatus.Status.FINISHED.toString());
        }
     
        // Get operation object from registry
        Operation operation = operationService.get(workflowExeMsg.getWorkflowExecutionID());
        logger.debug("Retrieve operation " + operation.getId() + " to update to " + workflowExeMsg.getWorkflowStatus());
        
        // Update operation
        operation.setStatus(ExecutionStatus.Status.FINISHED.toString());
        Date date = operation.getDate();
        date.setFinished(new java.util.Date());
        operation.setDate(date);

        Corpus operationCorpus = operation.getCorpus();
                      
        logger.debug("Retrieving workflow metadata " + operation.getComponent());
        eu.openminted.registry.domain.Component workflowMeta =  (eu.openminted.registry.domain.Component) applicationService.get(operation.getComponent());
        if (workflowMeta == null) {
        	logger.debug("Invalid workflow in operation, throw exception <" + operation.getComponent() + ">");
        	throw new NullPointerException("Invalid workflow in operation <" + operation.getComponent() + ">");
        }
                
        // Check what output resource is produced
        String outputOmtdId = null; 
		if (workflowMeta.getComponentInfo().getOutputResourceInfo() != null) {
        	if (workflowMeta.getComponentInfo().getOutputResourceInfo().getProcessingResourceType().equals(ProcessingResourceTypeEnum.LANGUAGE_DESCRIPTION)) {
        		// Generate output language description metadata
        		logger.info("Generating metadata for language description from experiment " + workflowExeMsg.getWorkflowExecutionID());
        		eu.openminted.registry.domain.LanguageDescription outputLanguageMeta = languageMetadataGenerator.generateLanguageDescriptionMetadata(operationCorpus.getInput(),
        				operation.getComponent(), operation.getPerson(), workflowExeMsg.getResultingCorpusID());
        		// Add output ld metadata to registry
        	    logger.info("Adding output language description to registry");
        	    languageDescriptionService.add(outputLanguageMeta);
        	    
        	    // Get output omtd id
        	    outputOmtdId = outputLanguageMeta.getMetadataHeaderInfo().getMetadataRecordIdentifier().getValue();
        		
        	} else if (workflowMeta.getComponentInfo().getOutputResourceInfo().getProcessingResourceType().equals(ProcessingResourceTypeEnum.LEXICAL_CONCEPTUAL_RESOURCE)) {        		
        		// Generate output lcr metadata
        		logger.info("Generating metadata for lexical/conceptual resource from experiment " + workflowExeMsg.getWorkflowExecutionID());
        		eu.openminted.registry.domain.Lexical outputLexicalMeta = lexicalMetadataGenerator.generateLanguageConceptualResourceMetadata(operationCorpus.getInput(),
        				operation.getComponent(), operation.getPerson(), workflowExeMsg.getResultingCorpusID());
        	    // Add output lrc metadata to registry
        	    logger.info("Adding output lexical/conceptual resource to registry");
        	    lexicalService.add(outputLexicalMeta);
        	    
        	    // Get output omtd id
        	    outputOmtdId = outputLexicalMeta.getMetadataHeaderInfo().getMetadataRecordIdentifier().getValue();
        	} else {
        		// By default it generates an annotated corpus
        		// Generate output corpus metadata
        		logger.info("Generating metadata for annotated corpus from experiment " + workflowExeMsg.getWorkflowExecutionID());
        		eu.openminted.registry.domain.Corpus outputCorpusMeta = corpusMetadataGenerator.generateAnnotatedCorpusMetadata(operationCorpus.getInput(),
        				operation.getComponent(), operation.getPerson(), workflowExeMsg.getResultingCorpusID());
        	    // Add output corpus metadata to registry
        	    logger.info("Adding output corpus to registry");
        	    corpusService.add(outputCorpusMeta);
        	    
        	    // Get output omtd id
        	    outputOmtdId = outputCorpusMeta.getMetadataHeaderInfo().getMetadataRecordIdentifier().getValue();

        	}
		} else {
    		// By default it generates an annotated corpus
			// Generate output corpus metadata
    		logger.info("Generating metadata for annotated corpus from experiment " + workflowExeMsg.getWorkflowExecutionID());
    		eu.openminted.registry.domain.Corpus outputCorpusMeta = corpusMetadataGenerator.generateAnnotatedCorpusMetadata(operationCorpus.getInput(),
    				operation.getComponent(), operation.getPerson(), workflowExeMsg.getResultingCorpusID());
    	    // Add output corpus metadata to registry
    	    logger.info("Adding output corpus to registry");
    	    corpusService.add(outputCorpusMeta);
    	    
    	    // Get output omtd id
    	    outputOmtdId = outputCorpusMeta.getMetadataHeaderInfo().getMetadataRecordIdentifier().getValue();
		}
			

		logger.debug("Output resource id :: " + outputOmtdId);
        operationCorpus.setOutput(outputOmtdId);
        operation.setCorpus(operationCorpus);      

        // Update operation to registry
        Future<String> operationString = parserPool.serialize(operation, ParserServiceTypes.JSON);
        logger.info("Update Operation " + operation.getId() + " to status " + workflowExeMsg.getWorkflowStatus().toUpperCase());
        operationService.update(operation);
        int coId = 0;
        try {
            coId = aaiUserInfoRetriever.getCoId( operation.getPerson());
            Pair<String, String> userNames = aaiUserInfoRetriever.getSurnameGivenName(coId);
            String surname = userNames.getKey();
            String givenName =  userNames.getValue();
            String email = aaiUserInfoRetriever.getEmail(coId);
            javaMailer.sendEmail(
                    email,
                    "[OpenMinTeD] the application execution has finished",
                    "Dear "+ givenName+ " "+surname+",\n" +
                            "\n" +
                            "  The application "+workflowMeta.getComponentInfo().getIdentificationInfo().getResourceNames().get(0)+" you executed in OpenMinTeD has been successfully completed with output\" "+outputOmtdId+" \".\n" +
                            " For more details, visit the <a href=\""+registryHost+"\">OpenMinTeD</a> site.\n" +
                            "\n" +
                            "Best regards,\n" +
                            "The OpenMinTeD team");
            logger.debug("Sent mail to " + email);
        } catch (IOException e) {
            logger.error("Could not send mail " + e.getMessage());
        }
    }

    private void caseFailed(WorkflowExecutionStatusMessage workflowExeMsg) throws ResourceNotFoundException {
        if (workflowExeMsg.getWorkflowExecutionID() == null || workflowExeMsg.getError() == null) {
            throw new NullPointerException("Missing elements in WorkflowExecutionStatusMessage for status " + ExecutionStatus.Status.FAILED.toString());
        }


        // Get operation object from registry
        Operation operation = operationService.get(workflowExeMsg.getWorkflowExecutionID());

        eu.openminted.registry.domain.Component workflowMeta =  (eu.openminted.registry.domain.Component) applicationService.get(operation.getComponent());
        if (workflowMeta == null) {
            logger.debug("Invalid workflow in operation, throw exception <" + operation.getComponent() + ">");
            throw new NullPointerException("Invalid workflow in operation <" + operation.getComponent() + ">");
        }

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


        int coId = 0;
        try {
            coId = aaiUserInfoRetriever.getCoId( operation.getPerson());
            Pair<String, String> userNames = aaiUserInfoRetriever.getSurnameGivenName(coId);
            String surname = userNames.getKey();
            String givenName =  userNames.getValue();
            String email = aaiUserInfoRetriever.getEmail(coId);
            javaMailer.sendEmail(
                    email,
                    "[OpenMinTeD] the application execution has failed",
                    "Dear "+ surname+",\n" +
                            "\n" +
                            " The application "+workflowMeta.getComponentInfo().getIdentificationInfo().getResourceNames().get(0)+" you executed in OpenMinTeD has failed." +
                            "\n For more details, visit the <a href=\"...\">OpenMinTeD</a> site.\n" +
                            "\n" +
                            "Best regards,\n" +
                            "The OpenMinTeD team");
            logger.debug("Sent mail to " + email);
        } catch (IOException e) {
            logger.error("Could not send mail " + e.getMessage());
        }

    }


}
