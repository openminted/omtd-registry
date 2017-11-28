package eu.openminted.registry.messaging;

import java.util.UUID;

import javax.jms.JMSException;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.AbstractApplicationContext;

import eu.openminted.messageservice.connector.MessageServicePublisher;
import eu.openminted.messageservice.connector.TopicsRegistry;
import eu.openminted.messageservice.messages.WorkflowExecutionStatusMessage;
import eu.openminted.workflow.api.ExecutionStatus;


@Configuration
//@PropertySource(value = { "classpath:application.properties", "classpath:registry.properties"} )
public class OperationPublisherApp {
	
	static final Logger logger = Logger.getLogger(OperationPublisherApp.class);
	
	//@Value("${jms.host}")
	private static String messagesHost = "tcp://<domain>:<port>";
	
	private static String topic = TopicsRegistry.workflowsExecution;
	
	private static String userID = "0931731143127784@openminted.eu";
	private static String corpusID = "OMTD_Demo_Dataset4"; // omtdid	
	private static String workflowID =  "DemoWF4Metabolites"; // "DemoWF3SSHNER";  //omtdid
	
	private static String outputCorpusArchiveId = "outputArchiveId";
	
	public static void main(String[] args) throws JMSException, InterruptedException{
        AbstractApplicationContext context = new AnnotationConfigApplicationContext(
        		OperationPublisherApp.class);
  
        // Connect to Message Service
        logger.info("Creating a message posting service to  ::" + messagesHost );
		MessageServicePublisher msgServicePub = new MessageServicePublisher(messagesHost); 
		            
		//////////////////
		// Step 1 - A workflow is set to PENDING in the workflow engine      
        WorkflowExecutionStatusMessage msgPended = new WorkflowExecutionStatusMessage(); 
        String workflowExecutionID = "WFE_ID_foo";//UUID.randomUUID().toString();
        msgPended.setWorkflowExecutionID(workflowExecutionID);
		msgPended.setWorkflowStatus(ExecutionStatus.Status.PENDING.toString());
		msgPended.setCorpusID(corpusID);
		msgPended.setUserID(userID);
		msgPended.setWorkflowID(workflowID);   
			
        // Publish message
		logger.info("Sending message - workflow execution :: " + msgPended.toString() );
        msgServicePub.publishMessage(topic, msgPended);
              
        //////////////////
        // Step 2 - A workflow is set to STARTED in the workflow engine   
        Thread.sleep(20000);
        WorkflowExecutionStatusMessage msgStarted = new WorkflowExecutionStatusMessage(); 
        msgStarted.setWorkflowExecutionID(workflowExecutionID);
        msgStarted.setWorkflowStatus(ExecutionStatus.Status.RUNNING.toString());
                            
		// Publish message
		logger.info("Sending message - workflow execution :: " + msgStarted.toString() );
		msgServicePub.publishMessage(topic, msgStarted);
 
		
		 //////////////////
        // Step 3 - A workflow is set to FINISHED in the workflow engine   
        Thread.sleep(20000);
     
        WorkflowExecutionStatusMessage msgFinished = new WorkflowExecutionStatusMessage(); 
        msgFinished.setWorkflowExecutionID(workflowExecutionID);
        msgFinished.setWorkflowStatus(ExecutionStatus.Status.FINISHED.toString());
        msgFinished.setResultingCorpusID(UUID.randomUUID().toString());
                            
		// Publish message
		logger.info("Sending message - workflow execution :: " + msgFinished.toString() );
		msgServicePub.publishMessage(topic, msgFinished);
 
		
		 //////////////////
        // Step 4 - A workflow is set to other states in the workflow engine   
        Thread.sleep(20000);
        
        WorkflowExecutionStatusMessage msgFailed = new WorkflowExecutionStatusMessage(); 
        msgFailed.setWorkflowExecutionID(workflowExecutionID);
        msgFailed.setWorkflowStatus(ExecutionStatus.Status.FAILED.toString());
        msgFailed.setError("An severe error occuried!");
                            
		// Publish message
		logger.info("Sending message - workflow execution :: " + msgFailed.toString() );
		
		msgServicePub.publishMessage(topic, msgFailed);
		
        ((AbstractApplicationContext)context).close();
  		
	}
	

}
