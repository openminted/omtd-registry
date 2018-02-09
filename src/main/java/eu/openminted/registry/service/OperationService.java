package eu.openminted.registry.service;

import eu.openminted.registry.core.service.ResourceCRUDService;
import eu.openminted.registry.domain.operation.Operation;

public interface OperationService extends ResourceCRUDService<Operation> {

    String executeJob(String corpusId,String applicationId);

}
