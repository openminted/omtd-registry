package eu.openminted.registry.service;

import eu.openminted.registry.core.service.ResourceCRUDService;
import eu.openminted.registry.domain.workflow.WorkflowDefinition;

public interface WorkflowService extends ResourceCRUDService<WorkflowDefinition>  {

    String createWorkflow();

    String updateWorkflow(String openmintedId);

    void deleteWorkflow(String workflowId);
}