package eu.openminted.registry.controllers;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import eu.openminted.registry.core.domain.Paging;
import eu.openminted.registry.core.domain.Resource;
import eu.openminted.registry.core.service.ResourceService;
import eu.openminted.registry.core.service.SearchService;
import eu.openminted.registry.core.service.ServiceException;
import eu.openminted.registry.domain.User;
import eu.openminted.registry.domain.Utils;

@RestController
public class UserController {

	   @Autowired
	   ResourceService resourceService;

	   @Autowired
	   SearchService searchService; 

		private Logger logger = Logger.getLogger(UserController.class);
	  
	    @RequestMapping(value = "/user/login/{username}/{password}", method = RequestMethod.GET, headers = "Accept=application/json")  
	    public ResponseEntity<String> getUser(@PathVariable("username") String username, @PathVariable("password") String password ) {  
	    	Paging paging = null;
	    	ResponseEntity<String> responseEntity;
	    	try {
				paging = searchService.search("user", "username any "+username, 0, 0, new String[0]);
			} catch (ServiceException e) {
				responseEntity = new ResponseEntity<String>("", HttpStatus.FORBIDDEN);
				return responseEntity;
			}
	    	
	    	if(paging.getTotal()==1){
	    		Resource resource = (Resource) paging.getResults().get(0);
	    		ObjectMapper objectMapper = new ObjectMapper();
	    		try {
					User user = objectMapper.readValue(resource.getPayload(), User.class);
					if(user.getPassword().equals(password)){
						user.setPassword("******");
						responseEntity = new ResponseEntity<String>(Utils.objToJson(user),HttpStatus.ACCEPTED);
					}else{
						responseEntity = new ResponseEntity<String>("", HttpStatus.FORBIDDEN);
					}
	    		} catch (JsonParseException e) {
					responseEntity = new ResponseEntity<String>(e.getMessage(), HttpStatus.FORBIDDEN);
				} catch (JsonMappingException e) {
					responseEntity = new ResponseEntity<String>(e.getMessage(), HttpStatus.FORBIDDEN);
				} catch (IOException e) {
					responseEntity = new ResponseEntity<String>(e.getMessage(), HttpStatus.FORBIDDEN);
				}
	    		
	    		return responseEntity;
	    	}else{
	    		responseEntity = new ResponseEntity<String>("Multiple entries +" + Utils.objToJson(paging), HttpStatus.FORBIDDEN);
	    	}
	    	
//	    	User user = new User();
//	    	user.setAffiliation("Athena Research Center");
//	    	user.setId(15);
//	    	user.setUsername(username);
//	    	user.setEmail("jdiplas@gmail.com");
//	    	user.setJoin_date("20-07-2016");
//	    	user.setName("John");
//	    	user.setSurname("Diplas");
//	    	user.setPassword("********");
//	    	ArrayList<String> roles = new ArrayList<>();
//	    	roles.add("admin");
//	    	user.setRoles(roles);
//	    	responseEntity = new ResponseEntity<String>(Utils.objToJson(user),HttpStatus.ACCEPTED);

	    	return responseEntity;
	    } 
	    
	    @RequestMapping(value = "/user/register", method = RequestMethod.POST, headers = "Accept=application/json")  
	    public ResponseEntity<String> addUser(@RequestBody User user) {  
	    	ResponseEntity<String> responseEntity = null;

	    	Paging paging = null;
	    	try {
				paging = searchService.search("user", "username any "+user.getUsername(), 0, 0, new String[0]);
			} catch (ServiceException e) {
				responseEntity = new ResponseEntity<String>("{\"message\":\""+e.getMessage()+"\"}", HttpStatus.INTERNAL_SERVER_ERROR);
				return responseEntity;
			}
	    	
	    	if(paging.getTotal()!=0){
	    		responseEntity = new ResponseEntity<String>("{\"message\":\"username already taken.\"}", HttpStatus.INTERNAL_SERVER_ERROR);
				return responseEntity;
	    	}
	    	
	    	
	    	Resource resource = new Resource();
	    	String serialized = new String();
	    	serialized = Utils.objToJson(user);
	    	
	    	if(!serialized.equals("failed")){
	    		resource.setPayload(serialized);
	    	}else{
	    		responseEntity = new ResponseEntity<String>("{\"message\":\"Failed\"}", HttpStatus.INTERNAL_SERVER_ERROR);
	    		return responseEntity;
	    	}

	    	resource.setCreationDate(new Date());
	    	resource.setModificationDate(new Date());
	    	resource.setPayloadFormat("json");
	    	resource.setResourceType("user");
	    	resource.setVersion("not_set");
	    	resource.setId("wont be saved");
	    	resource.setPayloadUrl("not_set");

	    	try {
				resourceService.addResource(resource);
				responseEntity = new ResponseEntity<String>("{\"message\":\"All good\"}", HttpStatus.ACCEPTED);
			} catch (ServiceException e) {

				logger.error("Error saving user", e);
				responseEntity = new ResponseEntity<String>("{\"message\":\""+e.getMessage()+"\"}", HttpStatus.INTERNAL_SERVER_ERROR);
			}

			return responseEntity;
	    }  
	  
	    @RequestMapping(value = "/user/edit", method = RequestMethod.POST, headers = "Accept=application/json")  
	    public ResponseEntity<String> updateUser(@RequestBody User user) {
	    	ResponseEntity<String> responseEntity = null;
	    	Resource resourceFinal = null;
			Resource resource = new Resource();
			Paging paging = null;
			
			try {
				paging = searchService.search("user", "username any "+user.getUsername(), 0, 0, new String[0]);
			} catch (ServiceException e1) {
				return new ResponseEntity<String>("failed", HttpStatus.INTERNAL_SERVER_ERROR);
			}
	    	
			if(paging.getResults().size()==1){
	    		resource = (Resource) paging.getResults().get(0);
	    		resource = resourceService.getResource("user", resource.getId());
	    		resource.setPayload(Utils.objToJson(user));
			}else{
	    		return new ResponseEntity<String>("failed", HttpStatus.INTERNAL_SERVER_ERROR);
	    	}
			resourceFinal = resource;
			try{
				resourceService.deleteResource(resource.getId());
				resourceFinal = resourceService.addResource(resourceFinal);
			} catch (ServiceException e) {
				responseEntity = new ResponseEntity<String>("{\"error\":\""+e.getMessage()+"\"}", HttpStatus.INTERNAL_SERVER_ERROR);
			}
			
	    	
	    	if(resourceFinal==null){
	    		responseEntity = new ResponseEntity<String>(Utils.objToJson(resourceFinal), HttpStatus.NO_CONTENT);
	    	}
	    	responseEntity = new ResponseEntity<String>(Utils.objToJson(user), HttpStatus.ACCEPTED);
	        return   responseEntity;
	    }  
//	  
//	    @RequestMapping(value = "/resources/{id}", method = RequestMethod.DELETE, headers = "Accept=application/json")  
//	    public void deleteResources(@PathVariable("id") String id) {  
//	        resourceService.deleteResource(id);  
//	    }   
	    

}
