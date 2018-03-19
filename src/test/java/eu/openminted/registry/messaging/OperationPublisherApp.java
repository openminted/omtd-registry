package eu.openminted.registry.messaging;

import eu.openminted.workflow.api.ExecutionStatus;
import eu.openminted.workflow.api.WorkflowExecutionStatusMessage;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.jms.core.JmsTemplate;

import javax.jms.JMSException;
import java.util.UUID;


@Configuration

public class OperationPublisherApp {
	
	static final Logger logger = LogManager.getLogger(OperationPublisherApp.class.getName());
	
	private static String DEFAULT_BROKER_URL = "tcp://83.212.101.85:61616";//"tcp://<domain>:<port>";

	//@Value("${workflows.execution:workflows.execution}")
	private static String ORDER_QUEUE = "workflows.execution.test";	
 
    @Bean
    public ActiveMQConnectionFactory connectionFactory(){
        ActiveMQConnectionFactory connectionFactory = new ActiveMQConnectionFactory();
        connectionFactory.setBrokerURL(DEFAULT_BROKER_URL);
        //connectionFactory.setTrustedPackages(Arrays.asList("com.websystique.spring","java.util"));
        return connectionFactory;
    }
     
    @Bean
    public JmsTemplate jmsQueueTemplate(){
        JmsTemplate template = new JmsTemplate();
        template.setConnectionFactory(connectionFactory());
        template.setDefaultDestinationName(ORDER_QUEUE);
        return template;
    }     
	
	@Autowired
	JmsTemplate jmsQueueTemplate;
	
	private static String userID = "0931732115452907@openminted.eu"; //"0931731143127784@openminted.eu";
	// omtdid	
	private static String corpusID = "8ed76a12-5d9c-4fb4-841c-9241f254ac53"; 
			//"1cee8f5c-dda1-46f5-a069-68145f09c684";
			// "6e92743a-8b2f-4e97-9f5b-8da8798181bc"; 
			// "443b8640-8e42-4a31-b481-540107318975"; 
	
	//omtdid
	private static String workflowID = "290676a0-aaec-46d2-898a-0bbbba7a412c";
			//"164d24ce-e9f3-4854-8722-3f9e52ad1bb3"; 
			//"8749e0a5-8823-40c8-971f-a752d8feaece";
			// "18591923-f83f-46a1-9328-d04d8ba6e210";
			//"a739747f-1af0-4c19-a59c-8ee454287d50"; 
			//"c2447f2f-cb62-442a-9e34-127914c60a67";
			// "c163d85f-f730-4bd4-9f69-a6916d3015a3";  
	
	private static String outputCorpusArchiveId = "outputArchiveId";
	
	public static void main(String[] args) throws JMSException, InterruptedException{
        AbstractApplicationContext context = new AnnotationConfigApplicationContext(
        		OperationPublisherApp.class);
  
        // Connect to Message Service
//        logger.info("Creating a message posting service to  ::" + messagesHost );
//		MessageServicePublisher msgServicePub = new MessageServicePublisher(messagesHost);
		            
		//////////////////
		// Step 1 - A workflow is set to PENDING in the workflow engine      
        WorkflowExecutionStatusMessage msgPended = new WorkflowExecutionStatusMessage();
        String workflowExecutionID = "WFE_ID8";//UUID.randomUUID().toString();  // operation_id
        msgPended.setWorkflowExecutionID(workflowExecutionID);
		msgPended.setWorkflowStatus(ExecutionStatus.Status.PENDING.toString());
		msgPended.setCorpusID(corpusID);
		msgPended.setUserID(userID);
		msgPended.setWorkflowID(workflowID);   
			
        // Publish message
		logger.info("Sending message - workflow execution :: " + msgPended.toString() );
		JmsTemplate jmsTemplate = (JmsTemplate) context.getBean("jmsQueueTemplate");
        jmsTemplate.convertAndSend(ORDER_QUEUE, msgPended);
              
   /*  
        //////////////////
        // Step 2 - A workflow is set to STARTED in the workflow engine   
        Thread.sleep(2000);
        WorkflowExecutionStatusMessage msgStarted = new WorkflowExecutionStatusMessage(); 
        msgStarted.setWorkflowExecutionID(workflowExecutionID);
        msgStarted.setWorkflowStatus(ExecutionStatus.Status.RUNNING.toString());
                            
		// Publish message
		logger.info("Sending message - workflow execution :: " + msgStarted.toString() );
		jmsTemplate.convertAndSend(ORDER_QUEUE, msgStarted);
 
		
		 //////////////////
        // Step 3 - A workflow is set to FINISHED in the workflow engine   
        Thread.sleep(2000);
     
        WorkflowExecutionStatusMessage msgFinished = new WorkflowExecutionStatusMessage(); 
        msgFinished.setWorkflowExecutionID(workflowExecutionID);
        msgFinished.setWorkflowStatus(ExecutionStatus.Status.FINISHED.toString());
        msgFinished.setResultingCorpusID(UUID.randomUUID().toString());
                            
    		
		// Publish message
		logger.info("Sending message - workflow execution :: " + msgFinished.toString() );
		jmsTemplate.convertAndSend(ORDER_QUEUE, msgFinished);
 */
	/*	
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
	*/	
        ((AbstractApplicationContext)context).close();
  		
	}
	

}
