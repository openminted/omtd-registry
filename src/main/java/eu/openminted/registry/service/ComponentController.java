package eu.openminted.registry.service;

import eu.openminted.registry.core.domain.Paging;
import eu.openminted.registry.core.domain.Resource;
import eu.openminted.registry.core.service.ResourceService;
import eu.openminted.registry.core.service.SearchService;
import eu.openminted.registry.core.service.ServiceException;
import eu.openminted.registry.domain.Component;
import org.elasticsearch.index.query.BoolQueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class ComponentController {


	   @Autowired
	   ResourceService resourceService;

	   @Autowired
	   SearchService searchService;

	   @Autowired
	   ComponentService componentService;
	  
	    @RequestMapping(value = "/request/component/{id}", method = RequestMethod.GET, headers = "Accept=application/json")  
	    public ResponseEntity<String> getComponent(@PathVariable("id") String id) {  
	    	
	        ResponseEntity<String> responseEntity;
	        Paging paging = null;
			BoolQueryBuilder qBuilder = new BoolQueryBuilder();

			qBuilder.must(QueryBuilders.termsQuery("omtdid",id));

	        try {
	        	paging = searchService.searchElastic("component", qBuilder, 0, 0, new String[0]);
		    } catch (ServiceException e) {
		    	return new ResponseEntity<String>("",HttpStatus.INTERNAL_SERVER_ERROR);
		    }
	        
	        Component component;
	        

	        if(paging.getResults().size()==1){//resource found
		       component = Utils.serialize((Resource) paging.getResults().get(0),Component.class);

		       if(component == null){
		    	   return new ResponseEntity<String>("Error serializing component",HttpStatus.INTERNAL_SERVER_ERROR);
		       }
	        }else{//resource not found
	         return new ResponseEntity<String>("",HttpStatus.NOT_FOUND);
	        }
	        
	        responseEntity = new ResponseEntity<String>(Utils.objToJson(component),HttpStatus.ACCEPTED);

	        return responseEntity;
	       }
	    
	    @RequestMapping(value = "/request/component/", method = RequestMethod.POST, headers = "Accept=application/json")  
	    public ResponseEntity<String> addComponentJson(@RequestBody Component component) {  

	    	return componentService.addComponent(component);
	    
	    } 
	    
	    @RequestMapping(value = "/request/component/", method = RequestMethod.POST, headers = "Accept=application/xml")  
	    public ResponseEntity<String> addComponentXml(@RequestBody Component component) {  

	    	return componentService.addComponent(component);
	    
	    } 
	    
	    @RequestMapping(value = "/request/component/", method = RequestMethod.PUT, headers = "Accept=application/json")  
	    public ResponseEntity<String> updateComponent(@RequestBody Component component) {  

	    	return componentService.updateComponent(component);
	    
	    } 
	    
	    @RequestMapping(value = "/request/component/", method = RequestMethod.DELETE, headers = "Accept=application/json")  
	    public ResponseEntity<String> deleteComponent(@RequestBody Component component) {  

	    	return componentService.deleteComponent(component);
	    
	    } 
} 
