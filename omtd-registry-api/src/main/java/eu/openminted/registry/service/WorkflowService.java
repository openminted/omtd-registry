package eu.openminted.registry.service;

import eu.openminted.registry.core.exception.ResourceNotFoundException;
import eu.openminted.registry.core.service.ResourceCRUDService;
import eu.openminted.registry.domain.workflow.WorkflowDefinition;

import java.util.List;

public interface WorkflowService extends ResourceCRUDService<WorkflowDefinition>  {

    /**
     * Create a new empty workflow.
     * @return the workflow id (not omtd id).
     */
    WorkflowDefinition createWorkflow();


    /**
     * Restores a workflow that has been deleted by the update operation.
     * The definition is taken from the registry.
     * @param omtdId the id to be restored.
     * @return the workflow id (not omtd id).
     */
    WorkflowDefinition restoreWorkflow(String omtdId) throws ResourceNotFoundException;

    /**
     * Saves the workflow in the editor, updates the workflow definition
     * deletes the workflow from the editor and creates a new workflow in the executor
     * with the definition taken from the registry.
     * @param omtdId of the galaxy workflow.
     * @return the workflowDefinition.
     */
    WorkflowDefinition updateWorkflow(String omtdId) throws ResourceNotFoundException;

    /**
     * Delete a workflow.
     * @param omtdId
     * @return the deleted omtdId
     */
    String deleteWorkflow(String omtdId) throws ResourceNotFoundException;

    /**
     * Deletes all workflows.
     * @return a list of all the workflow ids deleted.
     */
    List<String> deleteAll();
}