package eu.openminted.registry.service;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.util.ISO8601DateFormat;
import eu.openminted.registry.core.domain.FacetFilter;
import eu.openminted.registry.core.domain.Browsing;
import eu.openminted.registry.core.domain.Resource;
import eu.openminted.registry.core.service.*;
import eu.openminted.registry.domain.operation.Operation;
import org.apache.log4j.Logger;
import org.mitre.openid.connect.model.OIDCAuthenticationToken;
import org.springframework.context.annotation.Primary;
import org.springframework.security.access.prepost.PostAuthorize;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.net.UnknownHostException;
import java.util.Date;
import java.util.UUID;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

/**
 * Created by stefanos on 30/6/2017.
 */
@Service("operationService")
@Primary
public class OperationServiceImpl extends AbstractGenericService<Operation> implements ResourceCRUDService<Operation>{

    private static final String OPERATION_ID = "operation_id";

    private Logger logger = Logger.getLogger(OperationServiceImpl.class);
    
    private ObjectMapper mapper;

    public OperationServiceImpl() {
        super(Operation.class);
        mapper = new ObjectMapper();
    	mapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
    	mapper.setDateFormat(new ISO8601DateFormat());
    }

    @Override
    @PostAuthorize("returnObject.person==authentication.sub")
    public Operation get(String id) {
        return getOperation(id);
    }

    @Override
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public Browsing getAll(FacetFilter filter) {
        filter.setBrowseBy(getBrowseBy());
        return getResults(filter);
    }

    @Override
    public Browsing getMy(FacetFilter filter) {
        OIDCAuthenticationToken authentication = (OIDCAuthenticationToken) SecurityContextHolder.getContext().getAuthentication();
        filter.addFilter("personIdentifier",authentication.getSub());
        return getResults(filter);
    }

    @Override
    public void add(Operation operation) {    	
      //  String insertionId = UUID.randomUUID().toString();
      //  resource.setId(insertionId);
      //  OIDCAuthenticationToken authentication = (OIDCAuthenticationToken) SecurityContextHolder.getContext().getAuthentication();
      //  resource.setPerson(authentication.getSub());
        logger.info("Adding Operation :: " + operation.toString());
        Resource resourceDb = new Resource();
        try {
            String serialized = mapper.writeValueAsString(operation);
        	logger.info(serialized);
        	resourceDb.setCreationDate(new Date());            
            resourceDb.setModificationDate(new Date());
            resourceDb.setPayloadFormat("json");            	
            resourceDb.setResourceType(getResourceType());         
            resourceDb.setVersion("not_set");         
            resourceDb.setId(operation.getId());        
            resourceDb.setPayload(serialized);
        } catch (JsonProcessingException e) {
            logger.info("serializer exception",e);
            throw new ServiceException(e);
        }
        try {
        	String serialized = parserPool.deserialize(resourceDb, ParserService.ParserServiceTypes.JSON).get();        	            
        	logger.info("Add resource in DB" + serialized);
        	resourceService.addResource(resourceDb);
        }catch(Exception e){
	    	logger.info("add operation",e);	    	
	    }
        
    }

    @Override
    public void update(Operation operation){
        logger.info("Updating Operation :: " + operation.toString());
        Resource resourceDb;
        SearchService.KeyValue kv = new SearchService.KeyValue(
                OPERATION_ID,
                operation.getId()
        );
        try {
            resourceDb = searchService.searchId(getResourceType(), kv);  
            		//resourceService.getResource(getResourceType(), operation.getId()); 
            		
             //Resource resourceDb = new Resource();
            if (resourceDb == null) {
                throw new ServiceException(getResourceType() + " with key " + kv.toString()  + " does not exists");
            } else {
                String serialized = mapper.writeValueAsString(resourceDb);
                		// parserPool.deserialize(resourceDb, ParserService.ParserServiceTypes.JSON).get();
                logger.info("OLD ResourceDB serialized:\n " + serialized);
                
                
                serialized = mapper.writeValueAsString(operation);
                resourceDb.setModificationDate(new Date());
                resourceDb.setPayloadFormat("json");
                resourceDb.setPayload(serialized);
                // Add creationDate as the searchService returns a subset of the actual
                // resource in registry without creation and modification dates.
                // if missing error.
                resourceDb.setCreationDate(new Date());
                
                serialized = parserPool.deserialize(resourceDb, ParserService.ParserServiceTypes.JSON).get();
                logger.info("NEW ResourceDB serialized:\n " + serialized);
                
                resourceService.updateResource(resourceDb);
                
            }
        } catch (IOException | ExecutionException | InterruptedException   e) { //| | JsonProcessingException | UnknownHostException  |
            logger.fatal("operation update fatal error", e);
            throw new ServiceException(e);
        }
    }
    
    public Operation getOperation(String id) {
         Operation operation;
         try {
             SearchService.KeyValue kv = new SearchService.KeyValue(OPERATION_ID,id);
             operation = parserPool.serialize(searchService.searchId(getResourceType(), kv),typeParameterClass).get();
         } catch (UnknownHostException | ExecutionException | InterruptedException e) {
             logger.fatal("operation get fatal error", e);
             throw new ServiceException(e);
         }
         return operation;
     }

    @Override
    public void delete(Operation operation) {
        Resource resourceDb;
        try {
            SearchService.KeyValue kv = new SearchService.KeyValue(
                    OPERATION_ID,
                    operation.getId()
            );
            resourceDb = searchService.searchId(getResourceType(), kv);
            if (resourceDb == null) {
                throw new ServiceException(getResourceType() + " does not exists");
            } else {
                resourceService.deleteResource(operation.getId());
            }
        } catch (UnknownHostException e) {
            logger.fatal(e);
            throw new ServiceException(e);
        }
    }

    @Override
    public String getResourceType() {
        return "operation";
    }
}
