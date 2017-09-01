package eu.openminted.registry.service;

import eu.openminted.corpus.CorpusBuildingState;
import eu.openminted.registry.core.service.ResourceCRUDService;
import eu.openminted.registry.domain.Corpus;

import java.io.InputStream;
import java.util.List;

/**
 * Created by antleb on 1/19/17.
 */
public interface CorpusBuildingStatusService {

    List<CorpusBuildingState> getAggregate(String id);

}
