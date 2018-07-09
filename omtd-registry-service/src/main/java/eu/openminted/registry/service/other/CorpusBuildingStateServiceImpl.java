package eu.openminted.registry.service.other;


import eu.openminted.registry.core.domain.Resource;
import eu.openminted.registry.core.service.ResourceCRUDService;
import eu.openminted.registry.core.service.ResourceTypeService;
import eu.openminted.registry.core.service.SearchService;
import eu.openminted.registry.core.service.ServiceException;
import eu.openminted.registry.domain.connector.CorpusBuildingState;
import eu.openminted.registry.service.CorpusBuildingStatusService;
import eu.openminted.registry.service.omtd.OmtdGenericService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;

/**
 * Created by me :) on 30/8/2017.
 */
@Service("corpusBuildingStateService")
@Primary
public class CorpusBuildingStateServiceImpl extends OtherGenericService<CorpusBuildingState> implements
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
    String getResourceId() {
        return CORPUS_ID;
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
