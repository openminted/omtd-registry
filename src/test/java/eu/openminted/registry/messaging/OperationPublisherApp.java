package eu.openminted.registry.messaging;

import eu.openminted.registry.core.configuration.JmsConfiguration;
import eu.openminted.workflow.api.ExecutionStatus;
import eu.openminted.workflow.api.WorkflowExecutionStatusMessage;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.jms.config.DefaultJmsListenerContainerFactory;
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
    private String jmsHost = "tcp://83.212.101.85:61616";

    //@Value("${jms.prefix}")
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
	
			
	private static String userID = "0931732115452907@openminted.eu"; //"0931731143127784@openminted.eu";
	// omtdid	
	private static String corpusID = "8ed76a12-5d9c-4fb4-841c-9241f254ac53"; 
			//"1cee8f5c-dda1-46f5-a069-68145f09c684";
			// "6e92743a-8b2f-4e97-9f5b-8da8798181bc"; 
			// "443b8640-8e42-4a31-b481-540107318975"; 
	
	//omtdid
	private static String workflowID = "290676a0-aaec-46d2-898a-0bbbba7a412c" ; // ITrainerOfMachineLearningModels-InCorpus-OutCorpus
	// // TrainerOfMachineLearningModels-In-Out



  
	
	private static String outputCorpusArchiveId = "outputArchiveId";
	
	@Test
	public void TestPublishMessage() throws JMSException, InterruptedException {
		AbstractApplicationContext context = new AnnotationConfigApplicationContext(OperationPublisherApp.class);
				       		    
		// Connect to jms 
		JmsTemplate jmsQueueTemplate = (JmsTemplate) context.getBean("jmsQueueTemplate");
		
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
	    logger.info("Sending message - workflow execution :: " + msgPended.getWorkflowStatus() + " to " + ORDER_QUEUE );
        jmsQueueTemplate.convertAndSend(ORDER_QUEUE, msgPended);
              
     
        //////////////////
        // Step 2 - A workflow is set to STARTED in the workflow engine   
        Thread.sleep(2000);
        WorkflowExecutionStatusMessage msgStarted = new WorkflowExecutionStatusMessage(); 
        msgStarted.setWorkflowExecutionID(workflowExecutionID);
        msgStarted.setWorkflowStatus(ExecutionStatus.Status.RUNNING.toString());
                            
		// Publish message
		logger.info("Sending message - workflow execution :: " + msgStarted.toString() );
		jmsQueueTemplate.convertAndSend(ORDER_QUEUE, msgStarted);
 
		
		 //////////////////
        // Step 3 - A workflow is set to FINISHED in the workflow engine   
        Thread.sleep(2000);
     
        WorkflowExecutionStatusMessage msgFinished = new WorkflowExecutionStatusMessage(); 
        msgFinished.setWorkflowExecutionID(workflowExecutionID);
        msgFinished.setWorkflowStatus(ExecutionStatus.Status.FINISHED.toString());
        msgFinished.setResultingCorpusID(UUID.randomUUID().toString());
                            
    		
		// Publish message
		logger.info("Sending message - workflow execution :: " + msgFinished.toString() );
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
