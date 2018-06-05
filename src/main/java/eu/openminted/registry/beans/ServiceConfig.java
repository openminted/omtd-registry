package eu.openminted.registry.beans;

import eu.openminted.registry.domain.ObjectFactory;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;

@Configuration
@ComponentScan({"eu.openminted.registry.core","eu.openminted.registry.service"})
public class ServiceConfig {


    @Bean(name = "restTemplate")
    RestTemplate restTemplate() {
        RestTemplateBuilder builder = new RestTemplateBuilder();
        return builder.build();
    }

    @Bean
    JAXBContext omtdJAXBContext() throws JAXBException {
        return JAXBContext.newInstance(ObjectFactory.class);
    }

}
