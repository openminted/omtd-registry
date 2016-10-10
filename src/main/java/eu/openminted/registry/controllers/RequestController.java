package eu.openminted.registry.controllers;

import java.util.ArrayList;
import java.util.Collections;
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
import eu.openminted.registry.domain.Result;
import eu.openminted.registry.domain.Utils;
import eu.openminted.registry.domain.Value;
import eu.openminted.registry.services.RequestService;

@RestController
public class RequestController {

	private static Map<String, String> labels = new HashMap<>();
	private static String[] facets = new String[] {"language", "mediatype", "rights", "mimetype", "dataformatspecific", "license", "resourcetype"};

	static {
		labels.put("language", "Language");
		labels.put("mediatype", "Media Type");
		labels.put("rights", "Rights");
		labels.put("mimetype", "Mime Type");
		labels.put("dataformatspecific", "Data format specific");
		labels.put("license", "License");
		labels.put("resourcetype", "Resource Type");
	}

	   @Autowired
	   ResourceService resourceService;
	   
	   @Autowired
	   RequestService requestService;
	  

	    @RequestMapping(value = "/request/"/*,params = {"keyword","resourceType","language","mediaType","rights","mimeType","dataFormatSpecific","license"}*/ ,method = RequestMethod.GET, headers = "Accept=application/json")  
	    public ResponseEntity<String> getResourceTypeByFilters(@RequestParam(value = "keyword" , required=false ,defaultValue = "") String keyword, @RequestParam(value = "resourceType", required=false ,defaultValue = "") String[] resourceType, @RequestParam(value = "language", required=false ,defaultValue = "") String[] language, @RequestParam(value = "mediaType", required=false ,defaultValue = "") String[] mediaType, @RequestParam(value = "rights", required=false ,defaultValue = "") String[] rights, @RequestParam(value = "mimeType", required=false ,defaultValue = "") String[] mimeType, @RequestParam(value = "dataFormatSpecific", required=false ,defaultValue = "") String[] dataFormatSpecific, @RequestParam(value = "license", required=false ,defaultValue = "") String[] license,@RequestParam(value = "from" , required=false ,defaultValue = "0") int from,@RequestParam(value = "to" , required=false ,defaultValue = "-1") int to  ) {

	    	return requestService.getResponseByFilters(keyword, resourceType, language, mediaType, rights, mimeType, dataFormatSpecific, license, from, to);
	   
	    }
	    
	    
}
