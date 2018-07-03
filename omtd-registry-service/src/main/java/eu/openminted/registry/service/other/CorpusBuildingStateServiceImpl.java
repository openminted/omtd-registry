package eu.openminted.registry.service.other;


import eu.openminted.corpus.CorpusBuildingState;
import eu.openminted.registry.core.domain.*;
import eu.openminted.registry.core.service.*;
import eu.openminted.registry.service.CorpusBuildingStatusService;
import eu.openminted.registry.service.omtd.OmtdGenericService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.mitre.openid.connect.model.OIDCAuthenticationToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.net.UnknownHostException;
import java.util.*;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

/**
 * Created by me :) on 30/8/2017.
 */
@Service("corpusBuildingStateService")
@Primary
public class CorpusBuildingStateServiceImpl extends AbstractGenericService<CorpusBuildingState> implements
        ResourceCRUDService<CorpusBuildingState>, CorpusBuildingStatusService {

    private static final String CORPUS_ID = "corpus_id";
    private static final String[] CONNECTORS = {"CORE", "OpenAIRE"};
    @Autowired
    ResourceTypeService resourceTypeService;
    private Logger logger = LogManager.getLogger(OmtdGenericService.class);

    public CorpusBuildingStateServiceImpl() {
        super(CorpusBuildingState.class);
    }

    @Override
//    @PostAuthorize("returnObject!=null?returnObject.token==authentication.sub:true")
    public CorpusBuildingState get(String id) {
        CorpusBuildingState resource;
        try {
            SearchService.KeyValue kv = new SearchService.KeyValue(CORPUS_ID, id);
            resource = parserPool.deserialize(searchService.searchId(getResourceType(), kv), typeParameterClass).get();
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
        OIDCAuthenticationToken authentication = (OIDCAuthenticationToken) SecurityContextHolder.getContext()
                .getAuthentication();
        filter.addFilter("token", authentication.getSub());
        return getResults(filter);
    }

    @Override
    public CorpusBuildingState add(CorpusBuildingState resource) {
//        OIDCAuthenticationToken authentication = (OIDCAuthenticationToken) SecurityContextHolder.getContext()
// .getAuthentication();
//        resource.setToken(authentication.getSub());
        Resource resourceDb = new Resource();
        Future<String> serialized = parserPool.serialize(resource, ParserService.ParserServiceTypes.JSON);
        try {
            resourceDb.setCreationDate(new Date());
            resourceDb.setModificationDate(new Date());
            resourceDb.setPayloadFormat("json");
            resourceDb.setResourceType(resourceType);
            resourceDb.setVersion("not_set");
            resourceDb.setId(resource.getId());
            resourceDb.setPayload(serialized.get());
            resourceService.addResource(resourceDb);
            return resource;
        } catch (InterruptedException | ExecutionException e) {
            throw new ServiceException(e);
        }

    }

    @Override
    public CorpusBuildingState update(CorpusBuildingState resources) {
        CorpusBuildingState previous;
        Resource $resource;
        SearchService.KeyValue kv = new SearchService.KeyValue(
                CORPUS_ID,
                resources.getId()
        );
        try {
            $resource = searchService.searchId(getResourceType(), kv);
            previous = parserPool.deserialize($resource, typeParameterClass).get();
            Resource resource = new Resource();
            if ($resource == null) {
                throw new ServiceException(getResourceType() + " does not exists");
            } else {
                if (resources.getTotalHits() == null) resources.setTotalHits(previous.getTotalHits());
                if (resources.getTotalRejected() == null) resources.setTotalRejected(previous.getTotalRejected());
                if (resources.getMetadataProgress() == null)
                    resources.setMetadataProgress(previous.getMetadataProgress());
                if (resources.getFulltextProgress() == null)
                    resources.setFulltextProgress(previous.getFulltextProgress());
                String serialized = parserPool.serialize(resources, ParserService.ParserServiceTypes.JSON).get();
                if (!serialized.equals("failed")) {
                    resource.setPayload(serialized);
                } else {
                    throw new ServiceException("Serialization failed");
                }
                resource = $resource;
                //resource.setModificationDate(new Date());
                resource.setCreationDate(new Date());
                resource.setPayloadFormat("json");
                resource.setId($resource.getId());
                resource.setPayload(serialized);
                resourceService.updateResource(resource);
            }
        } catch (UnknownHostException | ExecutionException | InterruptedException e) {
            logger.fatal("corpusBuildingState update fatal error", e);
            throw new ServiceException(e);
        }
        return resources;
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

    @Override
    public List<CorpusBuildingState> getAggregate(String id) {
        List<CorpusBuildingState> resource = new ArrayList<>();
        for (String connector : CONNECTORS) {
            try {
                SearchService.KeyValue kv = new SearchService.KeyValue(CORPUS_ID, id + "@" + connector);
                logger.info("Searching for '" + id + "@" + connector + "' to elastic");
                Resource state = searchService.searchId(getResourceType(), kv);

                if (state != null)
                    resource.add(parserPool.deserialize(state, typeParameterClass).get());

            } catch (UnknownHostException | ExecutionException | InterruptedException e) {
                logger.fatal("corpusBuildingState get fatal error", e);
                throw new ServiceException(e);
            }
        }
        return resource;
    }
}
