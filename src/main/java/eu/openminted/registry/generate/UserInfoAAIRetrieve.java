package eu.openminted.registry.generate;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.apache.log4j.Logger;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;

@org.springframework.stereotype.Component
public class UserInfoAAIRetrieve {

	@Autowired
  	private RestTemplate restTemplate;
	
	@Autowired
	private HttpEntity<String> request;
	
	@Value("${aaiservice.url}")
	private String aaiServiceUrl;
	
	private Logger logger = Logger.getLogger(UserInfoAAIRetrieve.class.getName());
	
	public int getCoId(String userId) throws JsonParseException, JsonMappingException, IOException {
	
		logger.info("Running Retrieving COmanage id");
	 
		String serviceUri = aaiServiceUrl + "co_people.json?search.identifier={userId}";	
		
		Map<String, String> params = new HashMap<String, String>();
		params.put("userId", userId);
        
	
		ResponseEntity<String> response = restTemplate.exchange(serviceUri, HttpMethod.GET, request, String.class, params);
		//{"ResponseType":"CoPeople","Version":"1.0","CoPeople":[{"Version":"1.0","Id":124,"CoId":2,"Status":"Active","Created":"2017-05-22 11:54:45","Modified":"2017-05-25 10:17:46","Revision":5,"Deleted":false,"ActorIdentifier":"627f00fdf06c18817b27226533b532042db9405395f1c2ec77a3cdab01a1f40d@openminted.eu"}]}
	
		String responseStr = response.getBody();
		//logger.info("String response:: " + responseStr);
		
		JSONObject responseJson = new JSONObject(responseStr);
		JSONArray copeopleArray = responseJson.getJSONArray("CoPeople");
		JSONObject copeople  = copeopleArray.getJSONObject(0);
		//logger.info("CoID is " + copeople.getInt("Id"));
		
		return copeople.getInt("Id");
	}
	
	public String getEmail(int userCoId) throws JsonParseException, JsonMappingException, IOException {
		
		logger.info("Running Retrieving email from COmanage id");
	 
		String serviceUri = aaiServiceUrl + "email_addresses.json?copersonid={userCoId}";
		
		Map<String, String> params = new HashMap<String, String>();
		params.put("userCoId", Integer.toString(userCoId));
        
	
		ResponseEntity<String> response = restTemplate.exchange(serviceUri, HttpMethod.GET, request, String.class, params);
     	//{"ResponseType":"EmailAddresses","Version":"1.0","EmailAddresses":[{"Version":"1.0","Id":147,"Mail":"kgkirtzou@imis.athena-innovation.gr","Type":"official","Verified":false,"Person":{"Type":"CO","Id":124},"Created":"2017-05-22 11:54:45","Modified":"2017-05-22 11:54:45","Revision":0,"Deleted":false,"ActorIdentifier":"627f00fdf06c18817b27226533b532042db9405395f1c2ec77a3cdab01a1f40d@openminted.eu"}]}
		
		String responseStr = response.getBody();
		//logger.info("String response:: " + responseStr);
		
		JSONObject responseJson = new JSONObject(responseStr);
		JSONArray coemailArray = responseJson.getJSONArray("EmailAddresses");
		JSONObject coemail  = coemailArray.getJSONObject(0);
		//logger.info("Email is " + coemail.getString("Mail"));
		
		return coemail.getString("Mail");
	}
	
	public String getSurname(int userCoId) throws JsonParseException, JsonMappingException, IOException {
		
		logger.info("Running Retrieving Surname from COmanage id");
	 
		String serviceUri =  aaiServiceUrl + "names.json?copersonid={userCoId}" ;
		
		Map<String, String> params = new HashMap<String, String>();
		params.put("userCoId", Integer.toString(userCoId));
        
	
		ResponseEntity<String> response = restTemplate.exchange(serviceUri, HttpMethod.GET, request, String.class, params);
     	// {"ResponseType":"Names","Version":"1.0","Names":[{"Version":"1.0","Id":153,"Given":"Katerina","Family":"Gkirtzou","Type":"official","Language":"","Person":{"Type":"CO","Id":124},"PrimaryName":true,"Created":"2017-05-22 11:54:45","Modified":"2017-05-22 11:54:45","Revision":0,"Deleted":false,"ActorIdentifier":"627f00fdf06c18817b27226533b532042db9405395f1c2ec77a3cdab01a1f40d@openminted.eu"}]}
		
		String responseStr = response.getBody();
		//logger.info("String response:: " + responseStr);
		
		JSONObject responseJson = new JSONObject(responseStr);
		JSONArray nameArray = responseJson.getJSONArray("Names");
		JSONObject name  = nameArray.getJSONObject(0);
		//logger.info("Surname is " + name.getString("Family"));
		
		return name.getString("Family");
	}

    public String getGivenName(int userCoId) throws JsonParseException, JsonMappingException, IOException {
		
		logger.info("Running Retrieving Name from COmanage id");
	 
		String serviceUri = aaiServiceUrl + "names.json?copersonid={userCoId}" ;
		
		Map<String, String> params = new HashMap<String, String>();
		params.put("userCoId", Integer.toString(userCoId));
        
	
		ResponseEntity<String> response = restTemplate.exchange(serviceUri, HttpMethod.GET, request, String.class, params);
     	// {"ResponseType":"Names","Version":"1.0","Names":[{"Version":"1.0","Id":153,"Given":"Katerina","Family":"Gkirtzou","Type":"official","Language":"","Person":{"Type":"CO","Id":124},"PrimaryName":true,"Created":"2017-05-22 11:54:45","Modified":"2017-05-22 11:54:45","Revision":0,"Deleted":false,"ActorIdentifier":"627f00fdf06c18817b27226533b532042db9405395f1c2ec77a3cdab01a1f40d@openminted.eu"}]}
		
		String responseStr = response.getBody();
		//logger.info("String response:: " + responseStr);
		
		JSONObject responseJson = new JSONObject(responseStr);
		JSONArray nameArray = responseJson.getJSONArray("Names");
		JSONObject name  = nameArray.getJSONObject(0);
		//logger.info("Name is " + name.getString("Given"));
		
		return name.getString("Given");
	}
	
}
