package eu.openminted.registry.generate;


import java.io.IOException;
import java.util.HashMap;
import java.util.Map;



import org.apache.log4j.Logger;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.PropertySource;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.AnnotationConfigContextLoader;
import org.springframework.beans.factory.FactoryBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import org.apache.commons.codec.binary.Base64;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;



//@ActiveProfiles("test")
//@RunWith(SpringJUnit4ClassRunner.class)
//@SpringBootConfiguration
//@PropertySource("classpath:/test.properties")
//@ContextConfiguration(classes=RestTemplateBeanConfig.class)//, loader=AnnotationConfigContextLoader.class)
public class TestRetrieveUserInfoAAI {
	static final Logger logger = Logger.getLogger(TestRetrieveUserInfoAAI.class.getName());

	@Autowired
	private UserInfoAAIRetrieve aaiRetriever;
	
	//@Test
	public void testBasic() throws JsonParseException, JsonMappingException, IOException {
		
	
		logger.info("Running Retrieving User info");
		String userId = "0931731143127784@openminted.eu"; 

		int coId = aaiRetriever.getCoId(userId);
        logger.info("User has coId " + coId);
	
        String email = aaiRetriever.getEmail(coId);
        logger.info("User has email " + email);
        
        String surname = aaiRetriever.getSurname(coId);
        logger.info("User has surname " + surname);

        String givenname = aaiRetriever.getGivenName(coId);
        logger.info("User has name " + givenname);

      
	}
}
