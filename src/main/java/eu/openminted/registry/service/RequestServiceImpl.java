package eu.openminted.registry.service;

import eu.openminted.registry.core.domain.Browsing;
import eu.openminted.registry.core.domain.FacetFilter;
import eu.openminted.registry.core.service.AbstractGenericService;
import eu.openminted.registry.core.service.SearchService;
import eu.openminted.registry.core.service.ServiceException;
import eu.openminted.registry.domain.BaseMetadataRecord;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service("requestService")
public class RequestServiceImpl extends AbstractGenericService implements RequestService {

    @Autowired
    SearchService searchService;

    final private static Logger logger = Logger.getLogger(RequestServiceImpl.class);

    final private static String RESOURCE_ALIAS = "resourceTypes";

    public RequestServiceImpl() {
        super(BaseMetadataRecord.class);
    }


    public Browsing getResponseByFiltersElastic(FacetFilter filter) {
        filter.addFilter("public",true);
        filter.setBrowseBy(getBrowseBy());
        return getResults(filter);
    }

    public Map<String,List<?>> getResourceGroupedElastic(FacetFilter filter, String category) throws ServiceException {
        filter.addFilter("public",true);
        return getResultsGrouped(filter,category);
    }

    @Override
    public String getResourceType() {
        return RESOURCE_ALIAS;
    }

}
