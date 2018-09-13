package eu.openminted.registry.messaging;


import eu.openminted.workflow.api.ExecutionStatus;
import eu.openminted.workflow.api.WorkflowExecutionStatusMessage;
import org.apache.activemq.ActiveMQConnectionFactory;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.support.converter.MappingJackson2MessageConverter;
import org.springframework.jms.support.converter.MessageConverter;
import org.springframework.jms.support.converter.MessageType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.AnnotationConfigContextLoader;

import javax.jms.JMSException;
import java.util.UUID;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(loader=AnnotationConfigContextLoader.class)
public class OperationPublisherApp {
	
	static final Logger logger = LogManager.getLogger(OperationPublisherApp.class.getName());
	
	//@Value("${workflows.execution:workflows.execution}")
	private static String ORDER_QUEUE = "workflows.execution.test.katerina";	
 
	
	// @Value("${jms.host}")
    private String jmsHost = "tcp://83.212.101.85:61616"; // dev 
    		//"tcp://83.212.98.33:61616"; // beta 


    @Value("${jms.prefix:omtd-content-connector-service}")
    private String jmsPrefix = "registry";

    @Bean
    public ActiveMQConnectionFactory activeMQConnectionFactory() {
        ActiveMQConnectionFactory connectionFactory = new ActiveMQConnectionFactory();
        connectionFactory.setBrokerURL(jmsHost);
        connectionFactory.setConnectionIDPrefix(jmsPrefix);
        logger.info("ActiveMQConnection Factory created for " + jmsHost);
        return connectionFactory;
    }

    @Bean // Serialize message content to json using TextMessage
    public MessageConverter jacksonJmsMessageConverter() {
        MappingJackson2MessageConverter converter = new MappingJackson2MessageConverter();
        converter.setTargetType(MessageType.TEXT);
        converter.setTypeIdPropertyName("_type");
        return converter;
    }

    private JmsTemplate getJmsTemplate(boolean b) {
    	logger.info("Get JmsTemplate " + jmsHost);
        JmsTemplate template = new JmsTemplate();
        template.setConnectionFactory(activeMQConnectionFactory());
        template.setPubSubDomain(b); //false is for queue
        template.setMessageConverter(jacksonJmsMessageConverter());
        return template;
    }

    @Bean
    public JmsTemplate jmsQueueTemplate(){
        return getJmsTemplate(false);
    }

    @Bean
    public JmsTemplate jmsTopicTemplate(){
        return getJmsTemplate(true);
    }

    public String getJmsPrefix() {
        return jmsPrefix;
    }
	
			
	private static String userID = "0931731143127784@openminted.eu"; //"0931732115452907@openminted.eu"; 
	// omtdid	
	private static String corpusID = "b06ae3a4-375d-438d-8c64-33bd356f99ce"; // raw corpus 
			//"3adef061-f999-4a9c-b8de-68d3e223c4f9"; // Raw Corpus
			// fFrom beta - 
			//"8beb22bf-ce18-4100-a2b6-aa32a5fd31fb"; // Raw Corpus
		
	
			// From dev -- http://83.212.101.85:9200 
	 		//"3adef061-f999-4a9c-b8de-68d3e223c4f9"; // Raw Corpus	  

	
	
	//omtdid
	private static String workflowID = "e6e97879-4970-4dc3-98c8-0500bf724459"; // dev-LanguageDescription-Input-Output
			//"76c33d5d-b85b-4bfc-9430-056844c97184"; //dev-Sentiment-NoInput-NoOutput 
			//"6aecac98-df88-4e70-a873-dfe44f0b5662"; // dev-OntologyEnhancement2-NoInput-NoOutput 
			//"6b17f03e-e550-4a1d-b5cd-d50691ac1867"; // dev-OntologyAcqV2-InCorpus-OutLRC 
			 
			// "8898dbad-cf84-4e57-82bb-6ef3a158aca1"; // OntologyEnhancement-InCorpus-OutLCR 
			// "02149b02-8a92-4321-a987-6dea42e9c7a9" ; // OntologyAcquisition-InCorpus-OutputLCR 
			// "209ea58d-5e1c-47ae-8207-99d2483f4ca8"; // dev-component
			// From dev -- http://83.212.101.85:9200
			
	



  
	
	private static String outputCorpusArchiveId = "outputArchiveId";
	
	@Test
	public void TestPublishMessage() throws JMSException, InterruptedException {
		AbstractApplicationContext context = new AnnotationConfigApplicationContext(OperationPublisherApp.class);
				       		    
		// Connect to jms 
		JmsTemplate jmsQueueTemplate = (JmsTemplate) context.getBean("jmsQueueTemplate");
	
		
		//////////////////
		// Step 1 - A workflow is set to PENDING in the workflow engine      
        WorkflowExecutionStatusMessage msgPended = new WorkflowExecutionStatusMessage();
        String workflowExecutionID = "WFE_ID10";//UUID.randomUUID().toString();  // operation_id
        msgPended.setWorkflowExecutionID(workflowExecutionID);
		msgPended.setWorkflowStatus(ExecutionStatus.Status.PENDING.toString());
		msgPended.setCorpusID(corpusID);
		msgPended.setUserID(userID);
		msgPended.setWorkflowID(workflowID);   
			
		
        // Publish message				
	    logger.info("Sending message - workflow execution :: " + msgPended.getWorkflowStatus() + " to " + ORDER_QUEUE );
        jmsQueueTemplate.convertAndSend(ORDER_QUEUE, msgPended);
              
     
        //////////////////
        // Step 2 - A workflow is set to STARTED in the workflow engine   
        Thread.sleep(2000);
        WorkflowExecutionStatusMessage msgStarted = new WorkflowExecutionStatusMessage(); 
        msgStarted.setWorkflowExecutionID(workflowExecutionID);
        msgStarted.setWorkflowStatus(ExecutionStatus.Status.RUNNING.toString());
                            
		// Publish message
		logger.info("Sending message - workflow execution :: " + msgStarted.getWorkflowStatus() );
		jmsQueueTemplate.convertAndSend(ORDER_QUEUE, msgStarted);
 
		
		 //////////////////
        // Step 3 - A workflow is set to FINISHED in the workflow engine   
        Thread.sleep(2000);
     
        WorkflowExecutionStatusMessage msgFinished = new WorkflowExecutionStatusMessage(); 
        msgFinished.setWorkflowExecutionID(workflowExecutionID);
        msgFinished.setWorkflowStatus(ExecutionStatus.Status.FINISHED.toString());
        msgFinished.setResultingCorpusID(UUID.randomUUID().toString());
                            
    		
		// Publish message
		logger.info("Sending message - workflow execution :: " + msgFinished.getWorkflowStatus());
		jmsQueueTemplate.convertAndSend(ORDER_QUEUE, msgFinished);
 
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
