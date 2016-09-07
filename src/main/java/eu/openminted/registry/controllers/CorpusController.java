package eu.openminted.registry.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import eu.openminted.registry.core.domain.Paging;
import eu.openminted.registry.core.domain.Resource;
import eu.openminted.registry.core.service.ResourceService;
import eu.openminted.registry.core.service.SearchService;
import eu.openminted.registry.core.service.ServiceException;
import eu.openminted.registry.domain.Corpus;
import eu.openminted.registry.domain.Utils;

@RestController
public class CorpusController {


	   @Autowired
	   ResourceService resourceService;
	   
	   @Autowired 
	   SearchService searchService;
	  
	    @RequestMapping(value = "/request/corpus/{id}", method = RequestMethod.GET, headers = "Accept=application/json")  
	    public ResponseEntity<String> getResourceType(@PathVariable("resourceType") String resourceType, @PathVariable("id") String id) {  
	    	
	    	ResponseEntity<String> responseEntity;
	    	Paging paging = null;
	    	
	    	try {
				paging = searchService.search("corpus", "omtdId any "+id, 0, 0, new String[0]);
			} catch (ServiceException e) {
				return new ResponseEntity<String>("",HttpStatus.INTERNAL_SERVER_ERROR);
			}
	    	
	    	Corpus corpus = new Corpus();
	    	
	    	if(paging.getResults().size()==1){//resource found
	    		
	    		Resource resource = (Resource) paging.getResults().get(0);
//	    		^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^
//	    		////////////SERIALIZE IT//////////////////
//	    		^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^
	    		
	    	}else{//resource not found
	    		return new ResponseEntity<String>("",HttpStatus.NOT_FOUND);
	    	}
	    	
	    	responseEntity = new ResponseEntity<String>(Utils.objToJson(corpus),HttpStatus.ACCEPTED);

	    	return responseEntity;
	    } 
	    
}