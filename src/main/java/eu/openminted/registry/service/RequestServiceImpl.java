package eu.openminted.registry.service;

import com.google.common.collect.Lists;
import eu.openminted.registry.core.domain.*;
import eu.openminted.registry.core.service.AbstractGenericService;
import eu.openminted.registry.core.service.SearchService;
import eu.openminted.registry.core.service.ServiceException;
import eu.openminted.registry.domain.*;
import org.apache.log4j.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.net.UnknownHostException;
import java.util.*;

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

    @Override
    public String getResourceType() {
        return RESOURCE_ALIAS;
    }

}
