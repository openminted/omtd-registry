package eu.openminted.registry.beans;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class WorkflowConfig {

    private static Logger logger = LogManager.getLogger(WorkflowConfig.class);

    @Value("${workflow.service.host:#{'http://workflow/'}}")
    private String workflowServiceHost;

    @Bean(name = "workflowRestTemplate")
    RestTemplate workflowRestTemplate() {
        RestTemplateBuilder builder = new RestTemplateBuilder();
        builder.rootUri(workflowServiceHost);
        logger.info("Workflow Service Host : " + workflowServiceHost);
        return builder.build();
    }

    public String getWorkflowServiceHost() {
        return workflowServiceHost;
    }
}
