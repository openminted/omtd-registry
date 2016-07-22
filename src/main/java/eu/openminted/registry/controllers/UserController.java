package eu.openminted.registry.controllers;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import eu.openminted.registry.core.domain.Resource;
import eu.openminted.registry.core.domain.User;
import eu.openminted.registry.core.service.ResourceService;
import eu.openminted.registry.core.service.ServiceException;

@RestController
public class UserController {


	   @Autowired
	   ResourceService resourceService;
	  
	    @RequestMapping(value = "/login", method = RequestMethod.GET, headers = "Accept=application/json")  
	    public ResponseEntity<String> getUser(@RequestBody User user) {  
	    	
	    	ResponseEntity<String> responseEntity;
	    		responseEntity = new ResponseEntity<String>(HttpStatus.NOT_FOUND);

	    	return responseEntity;
	    } 
	    
	    @RequestMapping(value = "/register", method = RequestMethod.POST, headers = "Accept=application/json")  
	    public ResponseEntity<String> addUser(@RequestBody User user) {  
	    	ResponseEntity<String> responseEntity = null;
	    	
	    	Resource resource = new Resource();
	    	resource.setCreationDate(new Date());
	    	resource.setModificationDate(new Date());
	    	String serialized = new String();
	    	serialized = eu.openminted.registry.core.controllers.Utils.objToJson(user);
	    	
	    	if(!serialized.equals("failed")){
	    		resource.setPayload(serialized);
	    	}else{
	    		responseEntity = new ResponseEntity<String>("{\"message\":\"FAiled\"}", HttpStatus.INTERNAL_SERVER_ERROR);
	    	}
	    	
	    	resource.setPayloadFormat("json");
	    	resource.setResourceType("user");
	    	resource.setVersion("not_set");
	    	try {
				resourceService.addResource(resource);
				responseEntity = new ResponseEntity<String>("{\"message\":\"All good\"}", HttpStatus.ACCEPTED);
			} catch (ServiceException e) {
				responseEntity = new ResponseEntity<String>("{\"message\":\""+e.getMessage()+"\"}", HttpStatus.INTERNAL_SERVER_ERROR);
			}
	    	
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
