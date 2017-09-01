package eu.openminted.registry.service;


import eu.openminted.corpus.CorpusBuildingState;
import eu.openminted.registry.core.domain.Browsing;
import eu.openminted.registry.core.domain.FacetFilter;
import eu.openminted.registry.core.domain.Resource;
import eu.openminted.registry.core.service.*;
import org.apache.log4j.Logger;
import org.mitre.openid.connect.model.OIDCAuthenticationToken;
import org.springframework.context.annotation.Primary;
import org.springframework.security.access.prepost.PostAuthorize;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.net.UnknownHostException;
import java.util.Date;
import java.util.UUID;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

/**
 * Created by me :) on 30/8/2017.
 */
@Component("corpusBuildingStateService")
@Primary
public class CorpusBuildingStateServiceImpl extends AbstractGenericService<CorpusBuildingState> implements ResourceCRUDService<CorpusBuildingState>{

    private static final String CORPUS_ID = "id";

    private Logger logger = Logger.getLogger(OmtdGenericService.class);

    public CorpusBuildingStateServiceImpl() {
        super(CorpusBuildingState.class);
    }

    @Override
    @PostAuthorize("returnObject!=null?returnObject.token==authentication.sub:true")
    public CorpusBuildingState get(String id) {
        CorpusBuildingState resource;
        try {
            SearchService.KeyValue kv = new SearchService.KeyValue(CORPUS_ID,id);
            resource = parserPool.serialize(searchService.searchId(getResourceType(), kv),typeParameterClass).get();
        } catch (UnknownHostException | ExecutionException | InterruptedException e) {
            logger.fatal("corpusBuildingState get fatal error", e);
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
        filter.addFilter("token",authentication.getSub());
        return getResults(filter);
    }

    @Override
    public void add(CorpusBuildingState resource) {
//        OIDCAuthenticationToken authentication = (OIDCAuthenticationToken) SecurityContextHolder.getContext().getAuthentication();
//        resource.setToken(authentication.getSub());
        Resource resourceDb = new Resource();
        Future<String> serialized = parserPool.deserialize(resource, ParserService.ParserServiceTypes.JSON);
        try {
            resourceDb.setCreationDate(new Date());
            resourceDb.setModificationDate(new Date());
            resourceDb.setPayloadFormat("json");
            resourceDb.setResourceType(getResourceType());
            resourceDb.setVersion("not_set");
            resourceDb.setId(resource.getId());
            resourceDb.setPayload(serialized.get());
        } catch (InterruptedException | ExecutionException e) {
            throw new ServiceException(e);
        }
        resourceService.addResource(resourceDb);
    }

    @Override
    public void update(CorpusBuildingState resources) {
        Resource $resource;
        SearchService.KeyValue kv = new SearchService.KeyValue(
                CORPUS_ID,
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
            logger.fatal("corpusBuildingState update fatal error", e);
            throw new ServiceException(e);
        }
    }

    @Override
    public void delete(CorpusBuildingState resource) {
        Resource resource1;
        try {
            SearchService.KeyValue kv = new SearchService.KeyValue(
                    CORPUS_ID,
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
        return "corpusbuildingstate";
    }
}
