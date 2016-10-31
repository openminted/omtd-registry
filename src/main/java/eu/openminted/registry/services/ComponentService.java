package eu.openminted.registry.services;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import eu.openminted.registry.core.domain.Paging;
import eu.openminted.registry.core.domain.Resource;
import eu.openminted.registry.core.service.ResourceService;
import eu.openminted.registry.core.service.SearchService;
import eu.openminted.registry.core.service.ServiceException;
import eu.openminted.registry.domain.Component;
import eu.openminted.registry.domain.Utils;

@Service("componentService")
public class ComponentService {

	@Autowired
	SearchService searchService;
	
	@Autowired
	ResourceService resourceService;
	
	 public ResponseEntity<String> addComponent(Component component){
		   
		 ResponseEntity<String> responseEntity;
	    	Paging paging = null;
	    			        
		    try {
		        paging = searchService.search("component", "omtdid any "+component.getMetadataHeaderInfo().getMetadataRecordIdentifier().getValue(), 0, 0, new String[0]);
			} catch (ServiceException e) {
			    return new ResponseEntity<String>("",HttpStatus.INTERNAL_SERVER_ERROR);
			}
	    	
		    if(paging.getResults().size()!=0){
		    	responseEntity = new ResponseEntity<String>("{\"message\":\"Component already exists!\"}", HttpStatus.INTERNAL_SERVER_ERROR);
	    		return responseEntity;
		    }
		    
	    	Resource resource = new Resource();
	    	
	    	String serialized = new String();
	    	serialized = Utils.unserialize(component, Component.class);
	    	
	    	if(!serialized.equals("failed")){
	    		resource.setPayload(serialized);
	    	}else{
	    		responseEntity = new ResponseEntity<String>("{\"message\":\"Failed\"}", HttpStatus.INTERNAL_SERVER_ERROR);
	    		return responseEntity;
	    	}
	    	
	    	resource.setCreationDate(new Date());
	    	resource.setModificationDate(new Date());
	    	resource.setPayloadFormat("xml");
	    	resource.setResourceType("component");
	    	resource.setVersion("not_set");
	    	resource.setId("wont be saved");
	    
	    	try {
				resourceService.addResource(resource);
				responseEntity = new ResponseEntity<String>("", HttpStatus.ACCEPTED);
			} catch (ServiceException e) {
				responseEntity = new ResponseEntity<String>("{\"message\":\""+e.getMessage()+"\"}", HttpStatus.INTERNAL_SERVER_ERROR);
			}
	    	
	    	return responseEntity;
	 }
	 
	 public ResponseEntity<String> updateComponent(Component component){
		   
		 	ResponseEntity<String> responseEntity;
	     	Paging paging = null;
	    	
	    	Resource resource = new Resource();
	    	
	    	try {
				paging = searchService.search("component", "omtdid any "+component.getMetadataHeaderInfo().getMetadataRecordIdentifier().getValue(), 0, 0, new String[0]);
			} catch (ServiceException e) {
				responseEntity = new ResponseEntity<String>("{\"message\":\""+e.getMessage()+"\"}", HttpStatus.FORBIDDEN);
				return responseEntity;
			}
	    	
	    	
	    	if(paging.getResults().size()==0){
	    		responseEntity = new ResponseEntity<String>("{\"message\":\"component not found\"}", HttpStatus.INTERNAL_SERVER_ERROR);
	    		return responseEntity;
	    	}else{
	    		String serialized = new String();
		    	serialized = Utils.unserialize(component, Component.class);
		    	
		    	if(!serialized.equals("failed")){
		    		resource.setPayload(serialized);
		    	}else{
		    		responseEntity = new ResponseEntity<String>("{\"message\":\"serialization failed\"}", HttpStatus.INTERNAL_SERVER_ERROR);
		    		return responseEntity;
		    	}
	    		
		    	resource = (Resource) paging.getResults().get(0);
		    	resource.setPayloadFormat("xml");
		    	resource.setPayload(serialized);
		    	
		    	try {
					resourceService.updateResource(resource);
				} catch (ServiceException e) {
					responseEntity = new ResponseEntity<String>("{\"message\":\""+e.getMessage()+"\"}", HttpStatus.INTERNAL_SERVER_ERROR);
		    		return responseEntity;
				}
		    	responseEntity = new ResponseEntity<String>("", HttpStatus.ACCEPTED);
	    	}
	    	
	    	return responseEntity;
	 }
	 
	 public ResponseEntity<String> deleteComponent(Component component){
		   
		 	ResponseEntity<String> responseEntity;
	     	Paging paging = null;
	    	
	    	Resource resource = new Resource();
	    	
	    	try {
				paging = searchService.search("component", "omtdid any "+component.getMetadataHeaderInfo().getMetadataRecordIdentifier().getValue(), 0, 0, new String[0]);
			} catch (ServiceException e) {
				responseEntity = new ResponseEntity<String>("", HttpStatus.FORBIDDEN);
				return responseEntity;
			}
	    	
	    	if(paging.getResults().size()==0){
	    		responseEntity = new ResponseEntity<String>("{\"message\":\"component not found\"}", HttpStatus.INTERNAL_SERVER_ERROR);
	    		return responseEntity;
	    	}else{
	    		
		    	resource = (Resource) paging.getResults().get(0);
		
				resourceService.deleteResource(resource.getId());
				
		    	responseEntity = new ResponseEntity<String>("", HttpStatus.ACCEPTED);
	    	}
	    	
	    	return responseEntity;
	 }
	
	
}
