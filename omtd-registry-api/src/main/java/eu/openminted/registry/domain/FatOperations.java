package eu.openminted.registry.domain;

import eu.openminted.registry.domain.operation.Operation;

import java.util.Map;

public class FatOperations {

    private Operation operation;
    private Map<String, BaseMetadataRecord> resources;

    public FatOperations() {
    }

    public FatOperations(Operation operation, Map<String, BaseMetadataRecord> resources) {
        this.operation = operation;
        this.resources = resources;
    }

    public Operation getOperation() {
        return operation;
    }

    public void setOperation(Operation operation) {
        this.operation = operation;
    }

    public Map<String, BaseMetadataRecord> getResources() {
        return resources;
    }

    public void setResources(Map<String, BaseMetadataRecord> resources) {
        this.resources = resources;
    }
}