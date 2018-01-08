package eu.openminted.registry.service;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.util.ISO8601DateFormat;
import eu.openminted.registry.core.domain.*;
import eu.openminted.registry.core.service.AbstractGenericService;
import eu.openminted.registry.core.service.ResourceCRUDService;
import eu.openminted.registry.core.service.SearchService;
import eu.openminted.registry.core.service.ServiceException;
import eu.openminted.registry.domain.BaseMetadataRecord;
import eu.openminted.registry.domain.Component;
import eu.openminted.registry.domain.Corpus;
import eu.openminted.registry.domain.FatOperations;
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
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutionException;

/**
 * Created by stefanos on 30/6/2017.
 */
@Service("operationService")
@Primary
public class OperationServiceImpl extends AbstractGenericService<Operation> implements ResourceCRUDService<Operation> {

    private static final String OPERATION_ID = "operation_id";
    private static final String OMTD_ID = "omtdid";

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
        Browsing browsing = getResults(filter);
        return applicationJoinForOperations(browsing);
    }

    @Override
    public Browsing getMy(FacetFilter filter) {
        OIDCAuthenticationToken authentication = (OIDCAuthenticationToken) SecurityContextHolder.getContext().getAuthentication();
        filter.addFilter("personIdentifier", authentication.getSub());
        Browsing browsing = getResults(filter);
        return applicationJoinForOperations(browsing);
    }

    @Override
    public void add(Operation operation) {

        Resource resourceDb = new Resource();
        try {
            String serialized = mapper.writeValueAsString(operation);
            resourceDb.setPayloadFormat("json");
            resourceDb.setResourceType(resourceType);
            resourceDb.setVersion("not_set");
            resourceDb.setId(operation.getId());
            resourceDb.setPayload(serialized);
        } catch (JsonProcessingException e) {
            logger.info("serializer exception", e);
            throw new ServiceException(e);
        }
        try {
            resourceService.addResource(resourceDb);
        } catch (Exception e) {
            logger.info("add operation", e);
        }

    }

    @Override
    public void update(Operation operation) {

        Resource resourceDb;
        SearchService.KeyValue kv = new SearchService.KeyValue(
                OPERATION_ID,
                operation.getId()
        );
        try {
            resourceDb = searchService.searchId(getResourceType(), kv);
            if (resourceDb == null) {
                throw new ServiceException(getResourceType() + " with key " + kv.toString() + " does not exists");
            } else {
                String serialized = mapper.writeValueAsString(operation);
                //parserPool.deserialize(resourceDb, ParserService.ParserServiceTypes.JSON).get();
                resourceDb.setPayloadFormat("json");
                resourceDb.setPayload(serialized);
                resourceService.updateResource(resourceDb);

            }
        } catch (IOException e) { //| ExecutionException | InterruptedException   e) { //| | JsonProcessingException | UnknownHostException  |
            logger.fatal("operation update fatal error", e);
            throw new ServiceException(e);
        }
    }

    public Operation getOperation(String id) {
        Operation operation;
        try {
            SearchService.KeyValue kv = new SearchService.KeyValue(OPERATION_ID, id);
            operation = parserPool.serialize(searchService.searchId(getResourceType(), kv), typeParameterClass).get();
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

    private Browsing applicationJoinForOperations(Browsing browsing) {
        List<FatOperations> operations = new ArrayList<>();
        for(Object op : browsing.getResults()) {
            Operation operation = ((Order<Operation>)op).getResource();
            FatOperations fatOperation = new FatOperations();
            fatOperation.setOperation(operation);
            fatOperation.setResources(resolveOperationResources(operation));
            operations.add(fatOperation);
        }
        browsing.setResults(operations);
        return browsing;
    }

    private Map<String, BaseMetadataRecord> resolveOperationResources(Operation operation) {
        Map<String, BaseMetadataRecord> records = new HashMap<>();
        //Component
        if(operation.getComponent() != null) {
            Component component = resolveIndividualResource(operation.getComponent(), "component", Component.class);
            records.put(operation.getComponent(), component);
        }

        //Corpus input
        if(operation.getCorpus().getInput() != null) {
            Corpus input = resolveIndividualResource(operation.getCorpus().getInput(), "corpus", Corpus.class);
            records.put(operation.getCorpus().getInput(), input);
        }

        //Corpus output
        if(operation.getCorpus().getOutput() != null) {
            Corpus output = resolveIndividualResource(operation.getCorpus().getOutput(), "corpus", Corpus.class);
            records.put(operation.getCorpus().getOutput(), output);
        }

        return records;
    }

    private <T> T resolveIndividualResource(String resourceId, String resourceName, Class<T> resourceType) {
        T output = null;
        try {
            SearchService.KeyValue kv = new SearchService.KeyValue(OMTD_ID, resourceId);
            Resource resource = this.searchService.searchId(resourceName, kv);
            output = parserPool.serialize(resource, resourceType).get();
        } catch (Exception e) {
            logger.error("the resourceType of the operation " + resourceId + " was not found");
        }
        return output;
    }
}
