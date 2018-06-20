package eu.openminted.registry.service;

import eu.openminted.registry.core.domain.FacetFilter;
import eu.openminted.registry.core.service.ServiceException;
import eu.openminted.registry.core.domain.Browsing;

import java.util.List;
import java.util.Map;


public interface RequestService {

	Browsing getResponseByFiltersElastic(FacetFilter filter) throws ServiceException;

	Browsing getResponseByFiltersAndUserElastic(FacetFilter filter, String user) throws ServiceException;

	Map<String,List<?>> getResourceGroupedElastic(FacetFilter filter, String category) throws ServiceException;

}
