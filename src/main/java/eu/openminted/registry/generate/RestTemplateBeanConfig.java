package eu.openminted.registry.generate;

import org.apache.commons.codec.binary.Base64;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.web.client.RestTemplate;


@Configuration
@PropertySource(value = { "classpath:application.properties", "classpath:registry.properties"} )
public class RestTemplateBeanConfig {
	static final Logger logger = Logger.getLogger(RestTemplateBeanConfig.class);

	/*
	@Value("${aaiservice.username}")
	private String aaiUserName;
	
	@Value("${aaiservice.password}")
	private String aaiUserPassword;
	
	*/
	@Bean
	public RestTemplate getRestTemplate() {
		logger.info("Creating Rest Template");
		return new RestTemplate();
	}
	
	@Bean
	public HttpEntity<String> getHttpEntity() {		
		String aaiUserName = "56p+B-6YfRch69AM";
		String aaiUserPassword = "SvGV#j_EV3uJz^#^VL&!BCck";
		logger.info("Creating Http Entity with user <" + aaiUserName + "> and password <" + aaiUserPassword + ">");
		
		String plainCreds = aaiUserName + ":" + aaiUserPassword;
		logger.info(plainCreds);
		byte[] plainCredsBytes = plainCreds.getBytes();
		byte[] base64CredsBytes = Base64.encodeBase64(plainCredsBytes);
		String base64Creds = new String(base64CredsBytes);
		
		HttpHeaders headers = new HttpHeaders();
		headers.add("Authorization", "Basic " + base64Creds);
		HttpEntity<String> request = new HttpEntity<String>(headers);
	    
		return(request);
		
	}
	
	@Bean 
	public UserInfoAAIRetrieve UserInfoAAIRetrieve() {
		logger.info("Creating UserInfoAAIRetrieve");
		return new UserInfoAAIRetrieve();
	}
	
}
