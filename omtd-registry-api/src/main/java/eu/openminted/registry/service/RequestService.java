package eu.openminted.registry.service;

import eu.openminted.registry.core.domain.FacetFilter;
import eu.openminted.registry.core.service.ServiceException;
import eu.openminted.registry.core.domain.Browsing;
import eu.openminted.registry.domain.BaseMetadataRecord;

import java.util.List;
import java.util.Map;


public interface RequestService {

	Browsing<BaseMetadataRecord> getResponseByFiltersElastic(FacetFilter filter) throws ServiceException;

	Browsing<BaseMetadataRecord> getResponseByFiltersAndUserElastic(FacetFilter filter, String user) throws ServiceException;

	Map<String,List<BaseMetadataRecord>> getResourceGroupedElastic(FacetFilter filter, String category) throws ServiceException;

}
