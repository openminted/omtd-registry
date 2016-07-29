package eu.openminted.registry.controllers;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import eu.openminted.registry.core.controllers.Utils;
import eu.openminted.registry.core.domain.User;
import eu.openminted.registry.core.service.ResourceService;

@RestController
public class UserController {


	   @Autowired
	   ResourceService resourceService;
	  
	    @RequestMapping(value = "/user/login/{username}/{password}", method = RequestMethod.GET, headers = "Accept=application/json")  
	    public ResponseEntity<String> getUser(@PathVariable("username") String username, @PathVariable("password") String password ) {  
	    	
	    	ResponseEntity<String> responseEntity;
	    	User user = new User();
	    	user.setAffiliation("Athena Research Center");
	    	user.setId(15);
	    	user.setUsername(username);
	    	user.setEmail("jdiplas@gmail.com");
	    	user.setJoin_date("20-07-2016");
	    	user.setName("John");
	    	user.setSurname("Diplas");
	    	user.setPassword("********");
	    	ArrayList<String> roles = new ArrayList<>();
	    	roles.add("admin");
	    	user.setRoles(roles);
	    	responseEntity = new ResponseEntity<String>(Utils.objToJson(user),HttpStatus.ACCEPTED);

	    	return responseEntity;
	    } 
	    
	    @RequestMapping(value = "/user/register", method = RequestMethod.POST, headers = "Accept=application/json")  
	    public ResponseEntity<String> addUser(@RequestBody User user) {  
	    	ResponseEntity<String> responseEntity = null;
	    	responseEntity = new ResponseEntity<String>("{\"message\":\"User registered succesfully!\"}", HttpStatus.ACCEPTED);
//	    	Resource resource = new Resource();
//	    	String serialized = new String();
//	    	serialized = eu.openminted.registry.core.controllers.Utils.objToJson(user);
//	    	
//	    	if(!serialized.equals("failed")){
//	    		resource.setPayload(serialized);
//	    	}else{
//	    		responseEntity = new ResponseEntity<String>("{\"message\":\"Failed\"}", HttpStatus.INTERNAL_SERVER_ERROR);
//	    		return responseEntity;
//	    	}
//
//	    	resource.setCreationDate(new Date());
//	    	resource.setModificationDate(new Date());
//	    	resource.setPayloadFormat("json");
//	    	resource.setResourceType("user");
//	    	resource.setVersion("not_set");
//	    	resource.setId("wont be saved");
//	    	resource.setPayloadUrl("not_set");
//	    	
//	    	try {
//	    		
//				resourceService.addResource(resource);
//				responseEntity = new ResponseEntity<String>("{\"message\":\"All good\"}", HttpStatus.ACCEPTED);
//			} catch (ServiceException e) {
//				responseEntity = new ResponseEntity<String>("{\"message\":\""+e.getMessage()+"\"}", HttpStatus.INTERNAL_SERVER_ERROR);
//			}
	    	
	        return responseEntity;  
	    }  
	  
//	    @RequestMapping(value = "/resources", method = RequestMethod.PUT, headers = "Accept=application/json")  
//	    public ResponseEntity<String> updateResource(@RequestBody Resource resource) {
//	    	resource.setModificationDate(new Date());
//	    	ResponseEntity<String> responseEntity = null;
//	    	Resource resourceFinal = null;
//			try {
//				resourceFinal = resourceService.updateResource(resource);
//			} catch (ServiceException e) {
//				responseEntity = new ResponseEntity<String>("{\"error\":\""+e.getMessage()+"\"}", HttpStatus.INTERNAL_SERVER_ERROR);
//			}
//	    	
//	    	
//	    	if(resourceFinal==null){
//	    		responseEntity = new ResponseEntity<String>(Utils.objToJson(resourceFinal), HttpStatus.NO_CONTENT);
//	    	}
//	    	
//	        return   responseEntity;
//	    }  
//	  
//	    @RequestMapping(value = "/resources/{id}", method = RequestMethod.DELETE, headers = "Accept=application/json")  
//	    public void deleteResources(@PathVariable("id") String id) {  
//	        resourceService.deleteResource(id);  
//	    }   
	    

}
