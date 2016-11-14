package eu.openminted.registry.service;

import java.net.UnknownHostException;
import java.util.Date;

import org.elasticsearch.index.query.BoolQueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import eu.openminted.registry.core.domain.Paging;
import eu.openminted.registry.core.domain.Resource;
import eu.openminted.registry.core.service.ResourceService;
import eu.openminted.registry.core.service.SearchService;
import eu.openminted.registry.core.service.ServiceException;
import eu.openminted.registry.domain.Corpus;

@RestController
public class CorpusController {


	   @Autowired
	   ResourceService resourceService;
	   
	   @Autowired 
	   SearchService searchService;
	  
	    @RequestMapping(value = "/request/corpus/{id}", method = RequestMethod.GET, headers = "Accept=application/json")  
	    public ResponseEntity<String> getCorpus(@PathVariable("id") String id) {  
	    	
	    	ResponseEntity<String> responseEntity;
	    	Paging paging = null;
			BoolQueryBuilder qBuilder = new BoolQueryBuilder();

			qBuilder.must(QueryBuilders.termsQuery("omtdid",id));

			try {
				paging = searchService.searchElastic("component", qBuilder, 0, 0, new String[0]);
			} catch (ServiceException e) {
				return new ResponseEntity<String>("",HttpStatus.INTERNAL_SERVER_ERROR);
			}
	    	
	    	Corpus corpus = new Corpus();
	    	
	    	if(paging.getResults().size()!=0){//resource found
	    		
	    		Resource resource = (Resource) paging.getResults().get(0);
	    		corpus = Utils.serialize((Resource) paging.getResults().get(0), Corpus.class);
			       if(corpus == null){
			    	   return new ResponseEntity<String>("Error serializing corpus",HttpStatus.INTERNAL_SERVER_ERROR);
			       }
	    	}else{//resource not found
	    		return new ResponseEntity<String>("",HttpStatus.NOT_FOUND);
	    	}
	    	
	    	responseEntity = new ResponseEntity<String>(Utils.objToJson(corpus),HttpStatus.ACCEPTED);

	    	return responseEntity;
	    } 
	    
	    @RequestMapping(value = "/request/corpus/", method = RequestMethod.POST, headers = "Accept=application/json")  
	    public ResponseEntity<String> addCorpus(@RequestBody Corpus corpus) {  
	    	
	    	ResponseEntity<String> responseEntity;
	    	Paging paging = null;
	    	
	    	Resource resource = new Resource();
	    	
	    	String serialized = new String();
	    	serialized = Utils.unserialize(corpus,Corpus.class);
	    	
	    	if(!serialized.equals("failed")){
	    		resource.setPayload(serialized);
	    	}else{
	    		responseEntity = new ResponseEntity<String>("{\"message\":\"Failed\"}", HttpStatus.INTERNAL_SERVER_ERROR);
	    		return responseEntity;
	    	}
	    	
	    	resource.setCreationDate(new Date());
	    	resource.setModificationDate(new Date());
	    	resource.setPayloadFormat("xml");
	    	resource.setResourceType("corpora");
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
	    
}