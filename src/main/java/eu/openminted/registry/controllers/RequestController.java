package eu.openminted.registry.controllers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import eu.openminted.registry.core.domain.Paging;
import eu.openminted.registry.core.service.ResourceService;
import eu.openminted.registry.domain.Browsing;
import eu.openminted.registry.domain.Component;
import eu.openminted.registry.domain.Corpus;
import eu.openminted.registry.domain.Language;
import eu.openminted.registry.domain.Result;
import eu.openminted.registry.domain.User;
import eu.openminted.registry.domain.Utils;

@RestController
public class RequestController {


	   @Autowired
	   ResourceService resourceService;
	  
	    @RequestMapping(value = "/request/{resourceType}/", method = RequestMethod.GET, headers = "Accept=application/json")  
	    public ResponseEntity<String> getResourceType(@PathVariable("resourceType") String resourceType) {  
	    	
	    	ResponseEntity<String> responseEntity;
	    	
	    	User user = new User();
	    	user.setAffiliation("Athena Research Center");
	    	user.setId(15);
	    	user.setUsername("test1");
	    	user.setEmail("test1@gmail.com");
	    	user.setJoin_date("20-07-2016");
	    	user.setName("John1");
	    	user.setSurname("Diplas1");
	    	user.setPassword("********");
	    	ArrayList<String> roles = new ArrayList<>();
	    	roles.add("admin");
	    	user.setRoles(roles);
	    	
	    	User user2 = new User();
	    	user2.setAffiliation("Athena Research Center");
	    	user2.setId(15);
	    	user2.setUsername("test2");
	    	user2.setEmail("test2@gmail.com");
	    	user2.setJoin_date("21-07-2016");
	    	user2.setName("John2");
	    	user2.setSurname("Diplas2");
	    	user2.setPassword("********");
	    	ArrayList<String> roles2 = new ArrayList<>();
	    	roles2.add("admin");
	    	user2.setRoles(roles);
	    	User user3 = new User();
	    	user3.setAffiliation("Athena Research Center");
	    	user3.setId(15);
	    	user3.setUsername("test3");
	    	user3.setEmail("test3@gmail.com");
	    	user3.setJoin_date("22-07-2016");
	    	user3.setName("John3");
	    	user3.setSurname("Diplas3");
	    	user3.setPassword("********");
	    	ArrayList<String> roles3 = new ArrayList<>();
	    	roles3.add("admin");
	    	user3.setRoles(roles);
	    	
	    	ArrayList<User> users = new ArrayList<>();
	    	users.add(user);
	    	users.add(user2);
	    	users.add(user3);
	    	
	    	
	    	Paging paging = new Paging(users.size(), 0, users.size(), users, null);
	    	responseEntity = new ResponseEntity<String>(Utils.objToJson(paging),HttpStatus.ACCEPTED);

	    	return responseEntity;
	    } 
	    
//	    @RequestMapping(value = "/request/{resourceType}/",params = {"from"} ,method = RequestMethod.GET, headers = "Accept=application/json")  
//	    public ResponseEntity<String> getResourceType(@PathVariable("resourceType") String resourceType, @RequestParam(value = "from") int from) {  
//	    	ResponseEntity<String> responseEntity;
//	    	
//	    	User user = new User();
//	    	user.setAffiliation("Athena Research Center");
//	    	user.setId(15);
//	    	user.setUsername("test1");
//	    	user.setEmail("test1@gmail.com");
//	    	user.setJoin_date("20-07-2016");
//	    	user.setName("John1");
//	    	user.setSurname("Diplas1");
//	    	user.setPassword("********");
//	    	ArrayList<String> roles = new ArrayList<>();
//	    	roles.add("admin");
//	    	user.setRoles(roles);
//	    	
//	    	User user2 = new User();
//	    	user2.setAffiliation("Athena Research Center");
//	    	user2.setId(15);
//	    	user2.setUsername("test2");
//	    	user2.setEmail("test2@gmail.com");
//	    	user2.setJoin_date("21-07-2016");
//	    	user2.setName("John2");
//	    	user2.setSurname("Diplas2");
//	    	user2.setPassword("********");
//	    	ArrayList<String> roles2 = new ArrayList<>();
//	    	roles2.add("admin");
//	    	user2.setRoles(roles);
//	    	
//	    	User user3 = new User();
//	    	user3.setAffiliation("Athena Research Center");
//	    	user3.setId(15);
//	    	user3.setUsername("test3");
//	    	user3.setEmail("test3@gmail.com");
//	    	user3.setJoin_date("22-07-2016");
//	    	user3.setName("John3");
//	    	user3.setSurname("Diplas3");
//	    	user3.setPassword("********");
//	    	ArrayList<String> roles3 = new ArrayList<>();
//	    	roles3.add("admin");
//	    	user3.setRoles(roles);
//	    	
//	    	ArrayList<User> users = new ArrayList<>();
//	    	users.add(user);
//	    	users.add(user2);
//	    	
//	    	
//	    	Paging paging = new Paging(users.size(), from, users.size(), users, null);
//	    	responseEntity = new ResponseEntity<String>(Utils.objToJson(paging),HttpStatus.ACCEPTED);
//
//	    	return responseEntity;
//	    } 
//	    
//	    @RequestMapping(value = "/request/{resourceType}/",params = {"from","to"} ,method = RequestMethod.GET, headers = "Accept=application/json")  
//	    public ResponseEntity<String> getResourceType(@PathVariable("resourceType") String resourceType, @RequestParam(value = "from") int from , @RequestParam(value = "to") int to) {  
//	    	
//	    	ResponseEntity<String> responseEntity;
//	    	
//	    	User user = new User();
//	    	user.setAffiliation("Athena Research Center");
//	    	user.setId(15);
//	    	user.setUsername("test1");
//	    	user.setEmail("test1@gmail.com");
//	    	user.setJoin_date("20-07-2016");
//	    	user.setName("John1");
//	    	user.setSurname("Diplas1");
//	    	user.setPassword("********");
//	    	ArrayList<String> roles = new ArrayList<>();
//	    	roles.add("admin");
//	    	user.setRoles(roles);
//	    	
//	    	User user2 = new User();
//	    	user2.setAffiliation("Athena Research Center");
//	    	user2.setId(15);
//	    	user2.setUsername("test2");
//	    	user2.setEmail("test2@gmail.com");
//	    	user2.setJoin_date("21-07-2016");
//	    	user2.setName("John2");
//	    	user2.setSurname("Diplas2");
//	    	user2.setPassword("********");
//	    	ArrayList<String> roles2 = new ArrayList<>();
//	    	roles2.add("admin");
//	    	user2.setRoles(roles);
//	    	
//	    	User user3 = new User();
//	    	user3.setAffiliation("Athena Research Center");
//	    	user3.setId(15);
//	    	user3.setUsername("test3");
//	    	user3.setEmail("test3@gmail.com");
//	    	user3.setJoin_date("22-07-2016");
//	    	user3.setName("John3");
//	    	user3.setSurname("Diplas3");
//	    	user3.setPassword("********");
//	    	ArrayList<String> roles3 = new ArrayList<>();
//	    	roles3.add("admin");
//	    	user3.setRoles(roles);
//	    	
//	    	ArrayList<User> users = new ArrayList<>();
//	    	users.add(user);
//	    	
//	    	
//	    	Paging paging = new Paging(users.size(), from, to, users, null);
//	    	responseEntity = new ResponseEntity<String>(Utils.objToJson(paging),HttpStatus.ACCEPTED);
//
//	    	return responseEntity;
//	    } 
//	    
//	    @RequestMapping(value = "/request/{resourceType}/",params = {"q","f"} ,method = RequestMethod.GET, headers = "Accept=application/json")  
//	    public ResponseEntity<String> getResourceType(@PathVariable("resourceType") String resourceType, @RequestParam(value = "q") String query , @RequestParam(value = "f") String[] filters) {  
//   	
//	    	ResponseEntity<String> responseEntity;
//	    	
//	    	User user = new User();
//	    	user.setAffiliation("Athena Research Center");
//	    	user.setId(15);
//	    	user.setUsername("test1");
//	    	user.setEmail("test1@gmail.com");
//	    	user.setJoin_date("20-07-2016");
//	    	user.setName("John1");
//	    	user.setSurname("Diplas1");
//	    	user.setPassword("********");
//	    	ArrayList<String> roles = new ArrayList<>();
//	    	roles.add("admin");
//	    	user.setRoles(roles);
//	    	
//	    	User user2 = new User();
//	    	user2.setAffiliation("Athena Research Center");
//	    	user2.setId(15);
//	    	user2.setUsername("test2");
//	    	user2.setEmail("test2@gmail.com");
//	    	user2.setJoin_date("21-07-2016");
//	    	user2.setName("John2");
//	    	user2.setSurname("Diplas2");
//	    	user2.setPassword("********");
//	    	ArrayList<String> roles2 = new ArrayList<>();
//	    	roles2.add("admin");
//	    	user2.setRoles(roles);
//	    	
//	    	User user3 = new User();
//	    	user3.setAffiliation("Athena Research Center");
//	    	user3.setId(15);
//	    	user3.setUsername("test3");
//	    	user3.setEmail("test3@gmail.com");
//	    	user3.setJoin_date("22-07-2016");
//	    	user3.setName("John3");
//	    	user3.setSurname("Diplas3");
//	    	user3.setPassword("********");
//	    	ArrayList<String> roles3 = new ArrayList<>();
//	    	roles3.add("admin");
//	    	user3.setRoles(roles);
//	    	
//	    	ArrayList<User> users = new ArrayList<>();
//	    	users.add(user);
//	    	
//	    	
//	    	Paging paging = new Paging(users.size(), 0, users.size(), users, null);
//	    	responseEntity = new ResponseEntity<String>(Utils.objToJson(paging),HttpStatus.ACCEPTED);
//
//	    	return responseEntity;
//	    } 

	    @RequestMapping(value = "/request/",method = RequestMethod.GET, headers = "Accept=application/json")  
	    public ResponseEntity<String> getResourceType() {  
	    	ResponseEntity<String> responseEntity;
	    	
	    	Component component = new Component();
	    	component.setLocation("unknown");
	    	component.setName("Example name");
	    	component.setType("dev op");
	    	component.setVersion(10);
	    	
	    	Corpus corpus = new Corpus();
	    	corpus.setCountry("Greece");
	    	corpus.setLocation("eu");
	    	corpus.setName("Corpus A");
	    	corpus.setNo_pub(15);
	    	
	    	Language language = new Language();
	    	language.setCountry("English");
	    	language.setLocation("eu");
	    	language.setName("Eng");
	    	language.setUsage("Corpus");
	    	
	    	Result result1 = new Result();
	    	Result result2 = new Result();
	    	Result result3 = new Result();
	    	
	    	result1.setType("component");
	    	result1.setResult(component);
	    	
	    	result2.setType("corpus");
	    	result2.setResult(corpus);
	    	
	    	result3.setType("language");
	    	result3.setResult(language);

	    	List<Result> results = new ArrayList<Result>();
	 
	    	results.add(result1);
	    	results.add(result2);
	    	results.add(result3);
	    	
	    	Browsing browsing = new Browsing(results.size(), 0, results.size(), results, null);
	    	responseEntity = new ResponseEntity<String>(Utils.objToJson(browsing),HttpStatus.ACCEPTED);

	    	return responseEntity;
	    } 
	    
	    @RequestMapping(value = "/request/",params = {"from"} ,method = RequestMethod.GET, headers = "Accept=application/json")  
	    public ResponseEntity<String> getResourceType(@RequestParam(value = "from") int from) {  
	    	ResponseEntity<String> responseEntity;
	    	
	    	Component component = new Component();
	    	component.setLocation("unknown");
	    	component.setName("Example name");
	    	component.setType("dev op");
	    	component.setVersion(10);
	    	
	    	Corpus corpus = new Corpus();
	    	corpus.setCountry("Greece");
	    	corpus.setLocation("eu");
	    	corpus.setName("Corpus A");
	    	corpus.setNo_pub(15);
	    	
	    	Language language = new Language();
	    	language.setCountry("English");
	    	language.setLocation("eu");
	    	language.setName("Eng");
	    	language.setUsage("Corpus");
	    	
	    	Result result1 = new Result();
	    	Result result2 = new Result();
	    	Result result3 = new Result();
	    	
	    	result1.setType("component");
	    	result1.setResult(component);
	    	
	    	result2.setType("corpus");
	    	result2.setResult(corpus);
	    	
	    	result3.setType("language");
	    	result3.setResult(language);

	    	List<Result> results = new ArrayList<Result>();
	 
	    	results.add(result1);
	    	results.add(result2);
	    	results.add(result3);
	    	
	    	Browsing browsing = new Browsing(results.size(), from, results.size(), results, null);
	    	responseEntity = new ResponseEntity<String>(Utils.objToJson(browsing),HttpStatus.ACCEPTED);

	    	return responseEntity;
	    } 
	    
	    @RequestMapping(value = "/request/",params = {"from","to"} ,method = RequestMethod.GET, headers = "Accept=application/json")  
	    public ResponseEntity<String> getResourceType(@RequestParam(value = "from") int from , @RequestParam(value = "to") int to) {  
	    	
	    	ResponseEntity<String> responseEntity;

	    	Component component = new Component();
	    	component.setLocation("unknown");
	    	component.setName("Example name");
	    	component.setType("dev op");
	    	component.setVersion(10);
	    	
	    	Corpus corpus = new Corpus();
	    	corpus.setCountry("Greece");
	    	corpus.setLocation("eu");
	    	corpus.setName("Corpus A");
	    	corpus.setNo_pub(15);
	    	
	    	Language language = new Language();
	    	language.setCountry("English");
	    	language.setLocation("eu");
	    	language.setName("Eng");
	    	language.setUsage("Corpus");
	    	
	    	Result result1 = new Result();
	    	Result result2 = new Result();
	    	Result result3 = new Result();
	    	
	    	result1.setType("component");
	    	result1.setResult(component);
	    	
	    	result2.setType("corpus");
	    	result2.setResult(corpus);
	    	
	    	result3.setType("language");
	    	result3.setResult(language);

	    	List<Result> results = new ArrayList<Result>();
	 
	    	results.add(result1);
	    	results.add(result2);
	    	results.add(result3);
	    	
	    	Browsing browsing = new Browsing(results.size(), from, to, results, null);
	    	responseEntity = new ResponseEntity<String>(Utils.objToJson(browsing),HttpStatus.ACCEPTED);

	    	return responseEntity;
	    } 
	    
	    @RequestMapping(value = "/request/",params = {"q","f"} ,method = RequestMethod.GET, headers = "Accept=application/json")  
	    public ResponseEntity<String> getResourceType(@RequestParam(value = "q") String query , @RequestParam(value = "f") String[] filters) {  
   	
	    	ResponseEntity<String> responseEntity;
	    	
	    	Component component = new Component();
	    	component.setLocation("unknown");
	    	component.setName("Example name");
	    	component.setType("dev op");
	    	component.setVersion(10);
	    	
	    	Corpus corpus = new Corpus();
	    	corpus.setCountry("Greece");
	    	corpus.setLocation("eu");
	    	corpus.setName("Corpus A");
	    	corpus.setNo_pub(15);
	    	
	    	Language language = new Language();
	    	language.setCountry("English");
	    	language.setLocation("eu");
	    	language.setName("Eng");
	    	language.setUsage("Corpus");
	    	
	    	Result result1 = new Result();
	    	Result result2 = new Result();
	    	Result result3 = new Result();
	    	
	    	result1.setType("component");
	    	result1.setResult(component);
	    	
	    	result2.setType("corpus");
	    	result2.setResult(corpus);
	    	
	    	result3.setType("language");
	    	result3.setResult(language);

	    	List<Result> results = new ArrayList<Result>();
	 
	    	results.add(result1);
	    	results.add(result2);
	    	results.add(result3);
	    	
	    	Browsing browsing = new Browsing(results.size(), 0, results.size(), results, null);
	    	responseEntity = new ResponseEntity<String>(Utils.objToJson(browsing),HttpStatus.ACCEPTED);

	    	return responseEntity;
	    } 

	    
}
