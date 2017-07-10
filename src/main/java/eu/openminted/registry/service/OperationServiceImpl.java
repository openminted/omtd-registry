package eu.openminted.registry.service;


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

    private static final String OPERATION_ID = "id";

    private Logger logger = Logger.getLogger(OmtdGenericService.class);

    public OperationServiceImpl() {
        super(Operation.class);
    }

    @Override
    @PostAuthorize("returnObject.person==authentication.sub")
    public Operation get(String id) {
        Operation resource;
        try {
            SearchService.KeyValue kv = new SearchService.KeyValue(OPERATION_ID,id);
            resource = parserPool.serialize(searchService.searchId(getResourceType(), kv),typeParameterClass).get();
        } catch (UnknownHostException | ExecutionException | InterruptedException e) {
            logger.fatal("operation get fatal error", e);
            throw new ServiceException(e);
        }
        return resource;
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
    public void add(Operation resource) {
        String insertionId = UUID.randomUUID().toString();
        resource.setId(insertionId);
        OIDCAuthenticationToken authentication = (OIDCAuthenticationToken) SecurityContextHolder.getContext().getAuthentication();
        resource.setPerson(authentication.getSub());
        Resource resourceDb = new Resource();
        Future<String> serialized = parserPool.deserialize(resource, ParserService.ParserServiceTypes.JSON);
        try {
            resourceDb.setCreationDate(new Date());
            resourceDb.setModificationDate(new Date());
            resourceDb.setPayloadFormat("json");
            resourceDb.setResourceType(getResourceType());
            resourceDb.setVersion("not_set");
            resourceDb.setId(insertionId);
            resourceDb.setPayload(serialized.get());
        } catch (InterruptedException | ExecutionException e) {
            throw new ServiceException(e);
        }
        resourceService.addResource(resourceDb);
    }

    @Override
    public void update(Operation resources) {
        Resource $resource;
        SearchService.KeyValue kv = new SearchService.KeyValue(
                OPERATION_ID,
                resources.getId()
        );
        try {
            $resource = searchService.searchId(getResourceType(), kv);
            Resource resource = new Resource();
            if ($resource == null) {
                throw new ServiceException(getResourceType() + " does not exists");
            } else {
                String serialized = parserPool.deserialize(resources, ParserService.ParserServiceTypes.JSON).get();
                if (!serialized.equals("failed")) {
                    resource.setPayload(serialized);
                } else {
                    throw new ServiceException("Serialization failed");
                }
                resource = $resource;
                resource.setPayloadFormat("json");
                resource.setPayload(serialized);
                resourceService.updateResource(resource);
            }
        } catch (UnknownHostException | ExecutionException | InterruptedException e) {
            logger.fatal("operation update fatal error", e);
            throw new ServiceException(e);
        }
    }

    @Override
    public void delete(Operation resource) {
        Resource resource1;
        try {
            SearchService.KeyValue kv = new SearchService.KeyValue(
                    OPERATION_ID,
                    resource.getId()
            );
            resource1 = searchService.searchId(getResourceType(), kv);
            if (resource1 == null) {
                throw new ServiceException(getResourceType() + " does not exists");
            } else {
                resourceService.deleteResource(resource.getId());
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
