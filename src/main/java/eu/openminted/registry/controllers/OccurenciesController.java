package eu.openminted.registry.controllers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import eu.openminted.registry.core.controllers.Utils;
import eu.openminted.registry.core.domain.Occurencies;
import eu.openminted.registry.core.domain.Paging;
import eu.openminted.registry.core.domain.User;
import eu.openminted.registry.core.service.ResourceService;

@RestController
public class OccurenciesController {


	   @Autowired
	   ResourceService resourceService;
	  
	    @RequestMapping(value = "/occurencies/{resourceType}/", method = RequestMethod.GET, headers = "Accept=application/json")  
	    public ResponseEntity<String> getResourceType(@PathVariable("resourceType") String resourceType) {  
	    	
	    	ResponseEntity<String> responseEntity;
	    	Map<String,Map<String,String>> overallValues = new HashMap<String,Map<String,String>>();
	    	for(int y=0;y<2;y++){
	    		Map<String,String> values = new HashMap<String,String>();
	    		for(int i=0;i<5;i++){
	    			values.put("testName"+i, "testValue"+i);
		    	}
	    		overallValues.put("testCategory"+y, values);
	    	}
	    	Occurencies occurencies = new Occurencies();
	    	occurencies.setResourceType(resourceType);
	    	occurencies.setValues(overallValues);
	    	
	    	responseEntity = new ResponseEntity<String>(Utils.objToJson(occurencies),HttpStatus.ACCEPTED);

	    	return responseEntity;
	    } 
	    
	    @RequestMapping(value = "/occurencies/", method = RequestMethod.GET, headers = "Accept=application/json")  
	    public ResponseEntity<String> getOccurencies() {  
	    	
	    	ResponseEntity<String> responseEntity;
	    	ArrayList<Occurencies> occurencies = new ArrayList<Occurencies>();
	    	for(int j=0;j<3;j++){
		    	Map<String,Map<String,String>> overallValues = new HashMap<String,Map<String,String>>();
		    	for(int y=0;y<2;y++){
		    		Map<String,String> values = new HashMap<String,String>();
		    		for(int i=0;i<5;i++){
		    			values.put("testName"+i, "testValue"+i);
			    	}
		    		overallValues.put("testCategory"+y, values);
		    	}
		    	Occurencies occurencie = new Occurencies();
		    	occurencie.setResourceType("resource type "+j);
		    	occurencie.setValues(overallValues);
		    	occurencies.add(occurencie);
	    	}	    	
	    	responseEntity = new ResponseEntity<String>(Utils.objToJson(occurencies),HttpStatus.ACCEPTED);


	    	return responseEntity;
	    } 

}
