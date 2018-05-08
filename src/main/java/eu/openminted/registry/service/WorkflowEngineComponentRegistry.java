package eu.openminted.registry.service;

import eu.openminted.registry.domain.Component;

public interface WorkflowEngineComponentRegistry {

	WorkflowEngineComponent registerTDMComponentToWorkflowEngine(Component component);

	void deleteTDMComponentFromWorkflowEngine(Component component);
}
