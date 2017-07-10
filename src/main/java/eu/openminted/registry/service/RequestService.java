package eu.openminted.registry.service;

import eu.openminted.registry.core.domain.FacetFilter;
import eu.openminted.registry.core.service.ServiceException;
import eu.openminted.registry.core.domain.Browsing;


public interface RequestService {

	Browsing getResponseByFiltersElastic(FacetFilter filter) throws ServiceException;

}
