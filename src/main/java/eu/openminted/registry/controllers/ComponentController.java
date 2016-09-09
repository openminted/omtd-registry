package eu.openminted.registry.controllers;

import java.io.StringReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

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
import eu.openminted.registry.domain.Language;
import eu.openminted.registry.domain.ObjectFactory;
import eu.openminted.registry.domain.Result;
import eu.openminted.registry.domain.User;
import eu.openminted.registry.domain.Utils;

@RestController
public class ComponentController {


	   @Autowired
	   ResourceService resourceService;
	   
	   @Autowired 
	   SearchService searchService;
	  
	    @RequestMapping(value = "/request/component/{id}", method = RequestMethod.GET, headers = "Accept=application/json")  
	    public ResponseEntity<String> getResourceType(@PathVariable("id") String id) {  
	    	
	        ResponseEntity<String> responseEntity;
	        Paging paging = null;
	        
	        try {
	        	paging = searchService.search("component", "omtdId any "+id, 0, 0, new String[0]);
		    } catch (ServiceException e) {
		    	return new ResponseEntity<String>("",HttpStatus.INTERNAL_SERVER_ERROR);
		    }
	        
	        Component component;
	        
	        if(paging.getResults().size()==1){//resource found
		       component = Utils.serializeComponent((Resource) paging.getResults().get(0));
		       if(component == null){
		    	   return new ResponseEntity<String>("Error serializing component",HttpStatus.INTERNAL_SERVER_ERROR);
		       }
	        }else{//resource not found
	         return new ResponseEntity<String>("",HttpStatus.NOT_FOUND);
	        }
	        
	        responseEntity = new ResponseEntity<String>(Utils.objToJson(component),HttpStatus.ACCEPTED);

	        return responseEntity;
	       }
	    } 
