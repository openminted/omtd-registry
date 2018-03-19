package eu.openminted.registry.beans.security;

import org.apache.commons.codec.binary.Base64;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.web.client.RestTemplate;


@Configuration
@PropertySource(value = { "classpath:application.properties", "classpath:registry.properties"} )
@ComponentScan("eu.openminted.registry.service.aai")
public class UserInfoAAIConfig {
	static final Logger logger = LogManager.getLogger(UserInfoAAIConfig.class);

	
	@Value("${aaiservice.username}")
	private String aaiUserName;
	
	@Value("${aaiservice.password}")
	private String aaiUserPassword;
	
	
	@Bean
	@Qualifier("aaiRestTemplate")
	public RestTemplate getRestTemplate() {
		logger.info("Creating Rest Template");
		return new RestTemplate();
	}
	
	@Bean
	public HttpEntity<String> getHttpEntity() {				
		logger.info("Creating Http Entity with user <" + aaiUserName + "> and password <" + aaiUserPassword + ">");
		
		String plainCreds = aaiUserName + ":" + aaiUserPassword;
		//logger.info(plainCreds);
		byte[] plainCredsBytes = plainCreds.getBytes();
		byte[] base64CredsBytes = Base64.encodeBase64(plainCredsBytes);
		String base64Creds = new String(base64CredsBytes);
		
		HttpHeaders headers = new HttpHeaders();
		headers.add("Authorization", "Basic " + base64Creds);
		HttpEntity<String> request = new HttpEntity<String>(headers);
	    
		return(request);
		
	}

}
