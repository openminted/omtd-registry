package eu.openminted.registry.service.other;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.util.ISO8601DateFormat;
import eu.openminted.registry.core.domain.Browsing;
import eu.openminted.registry.core.domain.FacetFilter;
import eu.openminted.registry.core.domain.Resource;
import eu.openminted.registry.core.service.AbstractGenericService;
import eu.openminted.registry.core.service.ResourceCRUDService;
import eu.openminted.registry.core.service.SearchService;
import eu.openminted.registry.core.service.ServiceException;
import eu.openminted.registry.domain.base.ResourceIdentifier;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.mitre.openid.connect.model.OIDCAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;

import java.io.IOException;
import java.net.UnknownHostException;
import java.util.concurrent.ExecutionException;

abstract class OtherGenericService<T extends ResourceIdentifier> extends AbstractGenericService<T>
        implements ResourceCRUDService<T, OIDCAuthenticationToken> {

    OtherGenericService(Class<T> typeParameterClass) {
        super(typeParameterClass);
        mapper = new ObjectMapper();
        mapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
        mapper.setDateFormat(new ISO8601DateFormat());
    }

    protected ObjectMapper mapper;

    private Logger logger = LogManager.getLogger(OtherGenericService.class);

    abstract String getResourceId();

    public T get(String id) {
        T operation;
        logger.debug("Getting operation with id " + id);
        try {
            SearchService.KeyValue kv = new SearchService.KeyValue(getResourceId(), id);
            Resource resource = searchService.searchId(getResourceType(), kv);
            if(resource == null)
                return null;
            operation = parserPool.deserialize(resource, typeParameterClass);
        } catch (UnknownHostException e) {
            logger.fatal("operation get fatal error", e);
            throw new ServiceException(e);
        }
        return operation;
    }

//    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public Browsing<T> getAll(FacetFilter filter, OIDCAuthenticationToken auth) {
        filter.setBrowseBy(getBrowseBy());
        return  getResults(filter);
    }

    public Browsing<T> getMy(FacetFilter filter, OIDCAuthenticationToken auth) {
        OIDCAuthenticationToken authentication = (OIDCAuthenticationToken) SecurityContextHolder.getContext()
                .getAuthentication();
        filter.addFilter("personIdentifier", authentication.getSub());
        return getResults(filter);
    }

    public T add(T operation, OIDCAuthenticationToken auth) {

        Resource resourceDb = new Resource();
        try {
            String serialized = mapper.writeValueAsString(operation);
            resourceDb.setPayloadFormat("json");
            resourceDb.setResourceType(resourceType);
            resourceDb.setVersion("not_set");
            resourceDb.setId(operation.getOmtdId());
            resourceDb.setPayload(serialized);
            resourceService.addResource(resourceDb);
            return operation;
        } catch (JsonProcessingException e) {
            logger.info("add operation", e);
            throw new ServiceException(e);
        }
    }

    public T update(T operation, OIDCAuthenticationToken auth) {

        Resource resourceDb;
        SearchService.KeyValue kv = new SearchService.KeyValue(
                getResourceId(),
                operation.getOmtdId()
        );
        try {
            resourceDb = searchService.searchId(getResourceType(), kv);
            if (resourceDb == null) {
                throw new ServiceException(getResourceType() + " with key " + kv.toString() + " does not exists");
            } else {
                String serialized = mapper.writeValueAsString(operation);
                resourceDb.setPayload(serialized);
                resourceDb.setPayloadFormat("json");
                resourceDb.setPayload(serialized);
                resourceService.updateResource(resourceDb);
                return operation;
            }
        } catch (IOException e) { //| ExecutionException | InterruptedException   e) { //| | JsonProcessingException
            // | UnknownHostException  |
            logger.fatal("operation update fatal error", e);
            throw new ServiceException(e);
        }
    }

    public void delete(T operation) {
        Resource resourceDb;
        try {
            SearchService.KeyValue kv = new SearchService.KeyValue(
                    getResourceId(),
                    operation.getOmtdId()
            );
            resourceDb = searchService.searchId(getResourceType(), kv);
            if (resourceDb == null) {
                throw new ServiceException(getResourceType() + " does not exists");
            } else {
                resourceService.deleteResource(operation.getOmtdId());
            }
        } catch (UnknownHostException e) {
            logger.fatal(e);
            throw new ServiceException(e);
        }
    }
}
