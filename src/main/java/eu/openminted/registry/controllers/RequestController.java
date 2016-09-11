package eu.openminted.registry.controllers;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
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

import eu.openminted.registry.core.domain.Occurencies;
import eu.openminted.registry.core.domain.Paging;
import eu.openminted.registry.core.domain.Resource;
import eu.openminted.registry.core.service.ResourceService;
import eu.openminted.registry.core.service.SearchService;
import eu.openminted.registry.core.service.ServiceException;
import eu.openminted.registry.domain.Browsing;
import eu.openminted.registry.domain.Component;
import eu.openminted.registry.domain.Corpus;
import eu.openminted.registry.domain.Facet;
import eu.openminted.registry.domain.Language;
import eu.openminted.registry.domain.Result;
import eu.openminted.registry.domain.User;
import eu.openminted.registry.domain.Utils;
import eu.openminted.registry.domain.Value;

@RestController
public class RequestController {


	   @Autowired
	   ResourceService resourceService;
	   
	   @Autowired 
	   SearchService searchService;
	  
//	    @RequestMapping(value = "/request/{resourceType}/", method = RequestMethod.GET, headers = "Accept=application/json")  
//	    public ResponseEntity<String> getResourceType(@PathVariable("resourceType") String resourceType) {  
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
//	    	users.add(user3);
//	    	
//	    	
//	    	Paging paging = new Paging(users.size(), 0, users.size(), users, null);
//	    	responseEntity = new ResponseEntity<String>(Utils.objToJson(paging),HttpStatus.ACCEPTED);
//
//	    	return responseEntity;
//	    } 
//	    
//	    
//	    
////	    @RequestMapping(value = "/request/{resourceType}/",params = {"from"} ,method = RequestMethod.GET, headers = "Accept=application/json")  
////	    public ResponseEntity<String> getResourceType(@PathVariable("resourceType") String resourceType, @RequestParam(value = "from") int from) {  
////	    	ResponseEntity<String> responseEntity;
////	    	
////	    	User user = new User();
////	    	user.setAffiliation("Athena Research Center");
////	    	user.setId(15);
////	    	user.setUsername("test1");
////	    	user.setEmail("test1@gmail.com");
////	    	user.setJoin_date("20-07-2016");
////	    	user.setName("John1");
////	    	user.setSurname("Diplas1");
////	    	user.setPassword("********");
////	    	ArrayList<String> roles = new ArrayList<>();
////	    	roles.add("admin");
////	    	user.setRoles(roles);
////	    	
////	    	User user2 = new User();
////	    	user2.setAffiliation("Athena Research Center");
////	    	user2.setId(15);
////	    	user2.setUsername("test2");
////	    	user2.setEmail("test2@gmail.com");
////	    	user2.setJoin_date("21-07-2016");
////	    	user2.setName("John2");
////	    	user2.setSurname("Diplas2");
////	    	user2.setPassword("********");
////	    	ArrayList<String> roles2 = new ArrayList<>();
////	    	roles2.add("admin");
////	    	user2.setRoles(roles);
////	    	
////	    	User user3 = new User();
////	    	user3.setAffiliation("Athena Research Center");
////	    	user3.setId(15);
////	    	user3.setUsername("test3");
////	    	user3.setEmail("test3@gmail.com");
////	    	user3.setJoin_date("22-07-2016");
////	    	user3.setName("John3");
////	    	user3.setSurname("Diplas3");
////	    	user3.setPassword("********");
////	    	ArrayList<String> roles3 = new ArrayList<>();
////	    	roles3.add("admin");
////	    	user3.setRoles(roles);
////	    	
////	    	ArrayList<User> users = new ArrayList<>();
////	    	users.add(user);
////	    	users.add(user2);
////	    	
////	    	
////	    	Paging paging = new Paging(users.size(), from, users.size(), users, null);
////	    	responseEntity = new ResponseEntity<String>(Utils.objToJson(paging),HttpStatus.ACCEPTED);
////
////	    	return responseEntity;
////	    } 
////	    
////	    @RequestMapping(value = "/request/{resourceType}/",params = {"from","to"} ,method = RequestMethod.GET, headers = "Accept=application/json")  
////	    public ResponseEntity<String> getResourceType(@PathVariable("resourceType") String resourceType, @RequestParam(value = "from") int from , @RequestParam(value = "to") int to) {  
////	    	
////	    	ResponseEntity<String> responseEntity;
////	    	
////	    	User user = new User();
////	    	user.setAffiliation("Athena Research Center");
////	    	user.setId(15);
////	    	user.setUsername("test1");
////	    	user.setEmail("test1@gmail.com");
////	    	user.setJoin_date("20-07-2016");
////	    	user.setName("John1");
////	    	user.setSurname("Diplas1");
////	    	user.setPassword("********");
////	    	ArrayList<String> roles = new ArrayList<>();
////	    	roles.add("admin");
////	    	user.setRoles(roles);
////	    	
////	    	User user2 = new User();
////	    	user2.setAffiliation("Athena Research Center");
////	    	user2.setId(15);
////	    	user2.setUsername("test2");
////	    	user2.setEmail("test2@gmail.com");
////	    	user2.setJoin_date("21-07-2016");
////	    	user2.setName("John2");
////	    	user2.setSurname("Diplas2");
////	    	user2.setPassword("********");
////	    	ArrayList<String> roles2 = new ArrayList<>();
////	    	roles2.add("admin");
////	    	user2.setRoles(roles);
////	    	
////	    	User user3 = new User();
////	    	user3.setAffiliation("Athena Research Center");
////	    	user3.setId(15);
////	    	user3.setUsername("test3");
////	    	user3.setEmail("test3@gmail.com");
////	    	user3.setJoin_date("22-07-2016");
////	    	user3.setName("John3");
////	    	user3.setSurname("Diplas3");
////	    	user3.setPassword("********");
////	    	ArrayList<String> roles3 = new ArrayList<>();
////	    	roles3.add("admin");
////	    	user3.setRoles(roles);
////	    	
////	    	ArrayList<User> users = new ArrayList<>();
////	    	users.add(user);
////	    	
////	    	
////	    	Paging paging = new Paging(users.size(), from, to, users, null);
////	    	responseEntity = new ResponseEntity<String>(Utils.objToJson(paging),HttpStatus.ACCEPTED);
////
////	    	return responseEntity;
////	    } 
////	    
////	    @RequestMapping(value = "/request/{resourceType}/",params = {"q","f"} ,method = RequestMethod.GET, headers = "Accept=application/json")  
////	    public ResponseEntity<String> getResourceType(@PathVariable("resourceType") String resourceType, @RequestParam(value = "q") String query , @RequestParam(value = "f") String[] filters) {  
////   	
////	    	ResponseEntity<String> responseEntity;
////	    	
////	    	User user = new User();
////	    	user.setAffiliation("Athena Research Center");
////	    	user.setId(15);
////	    	user.setUsername("test1");
////	    	user.setEmail("test1@gmail.com");
////	    	user.setJoin_date("20-07-2016");
////	    	user.setName("John1");
////	    	user.setSurname("Diplas1");
////	    	user.setPassword("********");
////	    	ArrayList<String> roles = new ArrayList<>();
////	    	roles.add("admin");
////	    	user.setRoles(roles);
////	    	
////	    	User user2 = new User();
////	    	user2.setAffiliation("Athena Research Center");
////	    	user2.setId(15);
////	    	user2.setUsername("test2");
////	    	user2.setEmail("test2@gmail.com");
////	    	user2.setJoin_date("21-07-2016");
////	    	user2.setName("John2");
////	    	user2.setSurname("Diplas2");
////	    	user2.setPassword("********");
////	    	ArrayList<String> roles2 = new ArrayList<>();
////	    	roles2.add("admin");
////	    	user2.setRoles(roles);
////	    	
////	    	User user3 = new User();
////	    	user3.setAffiliation("Athena Research Center");
////	    	user3.setId(15);
////	    	user3.setUsername("test3");
////	    	user3.setEmail("test3@gmail.com");
////	    	user3.setJoin_date("22-07-2016");
////	    	user3.setName("John3");
////	    	user3.setSurname("Diplas3");
////	    	user3.setPassword("********");
////	    	ArrayList<String> roles3 = new ArrayList<>();
////	    	roles3.add("admin");
////	    	user3.setRoles(roles);
////	    	
////	    	ArrayList<User> users = new ArrayList<>();
////	    	users.add(user);
////	    	
////	    	
////	    	Paging paging = new Paging(users.size(), 0, users.size(), users, null);
////	    	responseEntity = new ResponseEntity<String>(Utils.objToJson(paging),HttpStatus.ACCEPTED);
////
////	    	return responseEntity;
////	    } 
//
//	    @RequestMapping(value = "/request/",method = RequestMethod.GET, headers = "Accept=application/json")  
//	    public ResponseEntity<String> getResourceType() {  
//	    	ResponseEntity<String> responseEntity;
//	    	
//	    	Component component = new Component();
////	    	component.setLocation("unknown");
////	    	component.setName("Example name");
////	    	component.setType("dev op");
////	    	component.setVersion(10);
//	    	
//	    	Corpus corpus = new Corpus();
////	    	corpus.setCountry("Greece");
////	    	corpus.setLocation("eu");
////	    	corpus.setName("Corpus A");
////	    	corpus.setNo_pub(15);
//	    	
//	    	Language language = new Language();
////	    	language.setCountry("English");
////	    	language.setLocation("eu");
////	    	language.setName("Eng");
////	    	language.setUsage("Corpus");
//	    	
//	    	Result result1 = new Result();
//	    	Result result2 = new Result();
//	    	Result result3 = new Result();
//	    	
////	    	result1.setType("component");
////	    	result1.setResult(component);
////	    	
////	    	result2.setType("corpus");
////	    	result2.setResult(corpus);
////	    	
////	    	result3.setType("language");
////	    	result3.setResult(language);
//
//	    	List<Result> results = new ArrayList<Result>();
//	 
//	    	results.add(result1);
//	    	results.add(result2);
//	    	results.add(result3);
//	    	
//	    	Browsing browsing = new Browsing(results.size(), 0, results.size(), results, null);
//	    	responseEntity = new ResponseEntity<String>(Utils.objToJson(browsing),HttpStatus.ACCEPTED);
//
//	    	return responseEntity;
//	    } 
//	    
//	    @RequestMapping(value = "/request/",params = {"from"} ,method = RequestMethod.GET, headers = "Accept=application/json")  
//	    public ResponseEntity<String> getResourceType(@RequestParam(value = "from") int from) {  
//	    	ResponseEntity<String> responseEntity;
//	    	
//	    	Component component = new Component();
////	    	component.setLocation("unknown");
////	    	component.setName("Example name");
////	    	component.setType("dev op");
////	    	component.setVersion(10);
//	    	
//	    	Corpus corpus = new Corpus();
////	    	corpus.setCountry("Greece");
////	    	corpus.setLocation("eu");
////	    	corpus.setName("Corpus A");
////	    	corpus.setNo_pub(15);
//	    	
//	    	Language language = new Language();
////	    	language.setCountry("English");
////	    	language.setLocation("eu");
////	    	language.setName("Eng");
////	    	language.setUsage("Corpus");
//	    	
////	    	Result result1 = new Result();
////	    	Result result2 = new Result();
////	    	Result result3 = new Result();
////	    	
////	    	result1.setType("component");
////	    	result1.setResult(component);
////	    	
////	    	result2.setType("corpus");
////	    	result2.setResult(corpus);
////	    	
////	    	result3.setType("language");
////	    	result3.setResult(language);
//
//	    	List<Result> results = new ArrayList<Result>();
//	 
////	    	results.add(result1);
////	    	results.add(result2);
////	    	results.add(result3);
//	    	
//	    	Browsing browsing = new Browsing(results.size(), from, results.size(), results, null);
//	    	responseEntity = new ResponseEntity<String>(Utils.objToJson(browsing),HttpStatus.ACCEPTED);
//
//	    	return responseEntity;
//	    } 
//	    
//	    @RequestMapping(value = "/request/",params = {"from","to"} ,method = RequestMethod.GET, headers = "Accept=application/json")  
//	    public ResponseEntity<String> getResourceType(@RequestParam(value = "from") int from , @RequestParam(value = "to") int to) {  
//	    	
//	    	ResponseEntity<String> responseEntity;
//
//	    	Component component = new Component();
////	    	component.setLocation("unknown");
////	    	component.setName("Example name");
////	    	component.setType("dev op");
////	    	component.setVersion(10);
//	    	
//	    	Corpus corpus = new Corpus();
////	    	corpus.setCountry("Greece");
////	    	corpus.setLocation("eu");
////	    	corpus.setName("Corpus A");
////	    	corpus.setNo_pub(15);
//	    	
//	    	Language language = new Language();
////	    	language.setCountry("English");
////	    	language.setLocation("eu");
////	    	language.setName("Eng");
////	    	language.setUsage("Corpus");
//	    	
//	    	Result result1 = new Result();
//	    	Result result2 = new Result();
//	    	Result result3 = new Result();
//	    	
////	    	result1.setType("component");
////	    	result1.setResult(component);
////	    	
////	    	result2.setType("corpus");
////	    	result2.setResult(corpus);
////	    	
////	    	result3.setType("language");
////	    	result3.setResult(language);
//
//	    	List<Result> results = new ArrayList<Result>();
//	 
//	    	results.add(result1);
//	    	results.add(result2);
//	    	results.add(result3);
//	    	
//	    	Browsing browsing = new Browsing(results.size(), from, to, results, null);
//	    	responseEntity = new ResponseEntity<String>(Utils.objToJson(browsing),HttpStatus.ACCEPTED);
//
//	    	return responseEntity;
//	    } 
//	    
//	    @RequestMapping(value = "/request/",params = {"q","f"} ,method = RequestMethod.GET, headers = "Accept=application/json")  
//	    public ResponseEntity<String> getResourceType(@RequestParam(value = "q") String query , @RequestParam(value = "f") String[] filters) {  
//   	
//	    	ResponseEntity<String> responseEntity;
//	    	
//	    	Component component = new Component();
////	    	component.setLocation("unknown");
////	    	component.setName("Example name");
////	    	component.setType("dev op");
////	    	component.setVersion(10);
//	    	
//	    	Corpus corpus = new Corpus();
////	    	corpus.setCountry("Greece");
////	    	corpus.setLocation("eu");
////	    	corpus.setName("Corpus A");
////	    	corpus.setNo_pub(15);
//	    	
//	    	Language language = new Language();
////	    	language.setCountry("English");
////	    	language.setLocation("eu");
////	    	language.setName("Eng");
////	    	language.setUsage("Corpus");
//	    	
//	    	Result result1 = new Result();
//	    	Result result2 = new Result();
//	    	Result result3 = new Result();
//	    	
////	    	result1.setType("component");
////	    	result1.setResult(component);
////	    	
////	    	result2.setType("corpus");
////	    	result2.setResult(corpus);
////	    	
////	    	result3.setType("language");
////	    	result3.setResult(language);
//
//	    	List<Result> results = new ArrayList<Result>();
//	 
//	    	results.add(result1);
//	    	results.add(result2);
//	    	results.add(result3);
//	    	
//	    	Browsing browsing = new Browsing(results.size(), 0, results.size(), results, null);
//	    	responseEntity = new ResponseEntity<String>(Utils.objToJson(browsing),HttpStatus.ACCEPTED);
//
//	    	return responseEntity;
//	    } 
//	    
//	    @RequestMapping(value = "/request/",params = {"q"} ,method = RequestMethod.GET, headers = "Accept=application/json")  
//	    public ResponseEntity<String> getResourceTypeByQuery(@RequestParam(value = "q") String query) {  
//   	
//	    	ResponseEntity<String> responseEntity;
//	    	
//	    	Component component = new Component();
////	    	component.setLocation("unknown");
////	    	component.setName("Example name");
////	    	component.setType("dev op");
////	    	component.setVersion(10);
//	    	
//	    	Corpus corpus = new Corpus();
////	    	corpus.setCountry("Greece");
////	    	corpus.setLocation("eu");
////	    	corpus.setName("Corpus A");
////	    	corpus.setNo_pub(15);
//	    	
//	    	Language language = new Language();
////	    	language.setCountry("English");
////	    	language.setLocation("eu");
////	    	language.setName("Eng");
////	    	language.setUsage("Corpus");
//	    	
//	    	Result result1 = new Result();
//	    	Result result2 = new Result();
//	    	Result result3 = new Result();
//	    	
////	    	result1.setType("component");
////	    	result1.setResult(component);
////	    	
////	    	result2.setType("corpus");
////	    	result2.setResult(corpus);
////	    	
////	    	result3.setType("language");
////	    	result3.setResult(language);
//
//	    	List<Result> results = new ArrayList<Result>();
//	 
//	    	results.add(result1);
//	    	results.add(result2);
//	    	results.add(result3);
//	    	
//	    	Browsing browsing = new Browsing(results.size(), 0, results.size(), results, null);
//	    	responseEntity = new ResponseEntity<String>(Utils.objToJson(browsing),HttpStatus.ACCEPTED);
//
//	    	return responseEntity;
//	    } 

	    @RequestMapping(value = "/request/"/*,params = {"keyword","resourceType","language","mediaType","rights","mimeType","dataFormatSpecific","license"}*/ ,method = RequestMethod.GET, headers = "Accept=application/json")  
	    public ResponseEntity<String> getResourceTypeByFilters(@RequestParam(value = "keyword" , required=false ,defaultValue = "") String keyword, @RequestParam(value = "resourceType", required=false ,defaultValue = "") String[] resourceType, @RequestParam(value = "language", required=false ,defaultValue = "") String[] language, @RequestParam(value = "mediaType", required=false ,defaultValue = "") String[] mediaType, @RequestParam(value = "rights", required=false ,defaultValue = "") String[] rights, @RequestParam(value = "mimeType", required=false ,defaultValue = "") String[] mimeType, @RequestParam(value = "dataFormatSpecific", required=false ,defaultValue = "") String[] dataFormatSpecific, @RequestParam(value = "license", required=false ,defaultValue = "") String[] license,@RequestParam(value = "from" , required=false ,defaultValue = "0") int from,@RequestParam(value = "to" , required=false ,defaultValue = "0") int to  ) {  
   	
	    	ResponseEntity<String> responseEntity;
	    	Result result = new Result();
	    	result.setComponents(new ArrayList<Component>());
	    	result.setCorpora(new ArrayList<Corpus>());
	    	
	    	int totalNumber = 0;
	    	String cqlQuery = "*";
	    	if(!keyword.equals("")){
	    		cqlQuery = keyword;
	    	}
	    	for(int i=0;i<resourceType.length;i++){
	    		if(i==0){
	    			cqlQuery = cqlQuery.concat(" AND (");
	    		}
	    		if(i!=resourceType.length-1){
	    			cqlQuery = cqlQuery.concat("resourceType any "+ resourceType[i] + " OR ");
	    		}else{
	    			cqlQuery = cqlQuery.concat("resourceType any "+ resourceType[i] + ")");
	    		}
	    	}
	    	for(int i=0;i<language.length;i++){
	    		if(i==0){
	    			cqlQuery = cqlQuery.concat(" AND (");
	    		}
	    		if(i!=language.length-1){
	    			cqlQuery = cqlQuery.concat("language any "+ language[i] + " OR ");
	    		}else{
	    			cqlQuery = cqlQuery.concat("language any "+ language[i] + ")");
	    		}
	    	}
	    	for(int i=0;i<mediaType.length;i++){
	    		if(i==0){
	    			cqlQuery = cqlQuery.concat(" AND (");
	    		}
	    		if(i!=mediaType.length-1){
	    			cqlQuery = cqlQuery.concat("mediaType any "+ mediaType[i] + " OR ");
	    		}else{
	    			cqlQuery = cqlQuery.concat("mediaType any "+ mediaType[i] + ")");
	    		}
	    	}
	    	for(int i=0;i<rights.length;i++){
	    		if(i==0){
	    			cqlQuery = cqlQuery.concat(" AND (");
	    		}
	    		if(i!=rights.length-1){
	    			cqlQuery = cqlQuery.concat("rights any "+ rights[i] + " OR ");
	    		}else{
	    			cqlQuery = cqlQuery.concat("rights any "+ rights[i] + ")");
	    		}
	    	}
	    	for(int i=0;i<mimeType.length;i++){
	    		if(i==0){
	    			cqlQuery = cqlQuery.concat(" AND (");
	    		}
	    		if(i!=mimeType.length-1){
	    			cqlQuery = cqlQuery.concat("mimeType any "+ mimeType[i] + " OR ");
	    		}else{
	    			cqlQuery = cqlQuery.concat("mimeType any "+ mimeType[i] + ")");
	    		}
	    	}
	    	for(int i=0;i<dataFormatSpecific.length;i++){
	    		if(i==0){
	    			cqlQuery = cqlQuery.concat(" AND (");
	    		}
	    		if(i!=dataFormatSpecific.length-1){
	    			cqlQuery = cqlQuery.concat("dataFormatSpecific any "+ dataFormatSpecific[i] + " OR ");
	    		}else{
	    			cqlQuery = cqlQuery.concat("dataFormatSpecific any "+ dataFormatSpecific[i] + ")");
	    		}
	    	}
	    	for(int i=0;i<license.length;i++){
	    		if(i==0){
	    			cqlQuery = cqlQuery.concat(" AND (");
	    		}
	    		if(i!=license.length-1){
	    			cqlQuery = cqlQuery.concat("license any "+ license[i] + " OR ");
	    		}else{
	    			cqlQuery = cqlQuery.concat("license any "+ license[i] + ")");
	    		}
	    	}
	    	String[] facets = new String[6];
//	    	facets[0] = "resourceType";
	    	
	    	facets[0] = "language";
	    	facets[1] = "mediatype";
	    	facets[2] = "rights";
	    	facets[3] = "mimetype";
	    	facets[4] = "dataformatspecific";
	    	facets[5] = "license";
	    	Occurencies overall = new Occurencies();

	    	try {
	    		for(int j=0;j<1;j++){
	    			String resourceTypeForSearch = "";
	    			if(j==0){
	    				resourceTypeForSearch = "component";
	    			}else if(j==1){
	    				resourceTypeForSearch = "corpora";
	    			}else if(j==2){
	    				resourceTypeForSearch = "lexical";
	    			}else{
	    				resourceTypeForSearch = "language";
	    			}
					Paging paging = searchService.search(resourceTypeForSearch, cqlQuery, from, to, facets);
					
					if(j==0){
						ArrayList<Component> components = new ArrayList<Component>();
						for(int i=0;i<10 && i < paging.getResults().size();i++){
							Resource resource = (Resource) paging.getResults().get(i);
							components.add(Utils.serializeComponent(resource));
						}
						result.setComponents(components);
					}else if(j==1){
						ArrayList<Corpus> corpora = new ArrayList<Corpus>();
						for(int i=0;i<paging.getTotal();i++){
							Resource resource = (Resource) paging.getResults().get(i);
							corpora.add(Utils.serializeCorpus(resource));
						}
						result.setCorpora(corpora);
					}
					
					totalNumber += paging.getTotal();
					
					if(j==0){
						overall = paging.getOccurencies();
					}else{
						Iterator it = paging.getOccurencies().getValues().entrySet().iterator();
						while(it.hasNext()){
							 Map.Entry pair = (Map.Entry)it.next();
							 Map<String,Integer> subMap = paging.getOccurencies().getValues().get(pair.getKey());
							 Iterator it2 = subMap.entrySet().iterator();
							 while(it2.hasNext()){
								 Map.Entry pair2 = (Map.Entry) it2.next();
								 Map<String,Integer> subMap2 = overall.getValues().get(pair.getKey());
								 if(subMap2.containsKey(pair2.getKey())){
									 subMap2.replace(pair2.getKey()+"", subMap2.get(pair2.getKey()) + subMap.get(pair2.getKey()));
								 }else{
									 subMap2.put(pair2.getKey()+"", subMap.get(pair2.getKey()));
								 }
								 overall.getValues().replace(pair.getKey()+"",subMap2);
							 }
						}
					}
	    		}
			} catch (ServiceException e) {
				new ResponseEntity<String>("",HttpStatus.INTERNAL_SERVER_ERROR);
			}
	    	
	    	List<Facet> facetsCollection = new ArrayList<Facet>();
	    	Iterator it = overall.getValues().entrySet().iterator();
	    	while(it.hasNext()){
	    		 Facet singleFacet = new Facet();
	    		 Map.Entry pair = (Map.Entry)it.next();
	    		 singleFacet.setField(pair.getKey()+"");
	    		 singleFacet.setLabel(pair.getKey()+"");
	    		 List<Value> values = new ArrayList<Value>();
	    		 Map<String,Integer> subMap = overall.getValues().get(pair.getKey());
	    		 Iterator it2 = subMap.entrySet().iterator();
				 while(it2.hasNext()){
					 Map.Entry pair2 = (Map.Entry) it2.next();
					 Value value = new Value();
					 value.setValue(pair2.getKey()+"");
					 value.setCount(Integer.parseInt(pair2.getValue()+""));
					 values.add(value);
				 }
				 Collections.sort(values);
	    		 singleFacet.setValues(values);
	    		 facetsCollection.add(singleFacet);
	    	}
	    	
	    	Browsing browsing = new Browsing(totalNumber, from, from+10, result, facetsCollection );
	    	responseEntity = new ResponseEntity<String>(Utils.objToJson(browsing),HttpStatus.ACCEPTED);

	    	return responseEntity;
	    } 
	    
}
