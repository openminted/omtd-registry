package eu.openminted.registry.service.other;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.util.ISO8601DateFormat;
import com.github.jmchilton.blend4j.galaxy.GalaxyInstance;
import com.github.jmchilton.blend4j.galaxy.beans.Workflow;
import eu.openminted.registry.core.domain.*;
import eu.openminted.registry.core.exception.ResourceNotFoundException;
import eu.openminted.registry.core.service.*;
import eu.openminted.registry.domain.workflow.WorkflowDefinition;
import eu.openminted.registry.service.WorkflowService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.mitre.openid.connect.model.OIDCAuthenticationToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.net.UnknownHostException;
import java.util.*;
import java.util.concurrent.ExecutionException;

/**
 * Created by stefanos on 30/6/2017.
 */
@Service("WorkflowService")
@Primary
public class WorkflowDefinitionImpl extends AbstractGenericService<WorkflowDefinition> implements WorkflowService {

    private static final String WORKFLOW_ID = "openminted_id";

    private Logger logger = LogManager.getLogger(WorkflowDefinitionImpl.class);

    private ObjectMapper mapper;

    @Autowired(required = false)
    @Qualifier("galaxyInstanceFactory")
    private GalaxyInstance galaxyEditorInstance;

    @Autowired(required = false)
    @Qualifier("galaxyExecutorInstanceFactory")
    private GalaxyInstance galaxyExecutorInstance;

    public WorkflowDefinitionImpl() {
        super(WorkflowDefinition.class);
        mapper = new ObjectMapper();
        mapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
        mapper.setDateFormat(new ISO8601DateFormat());
    }

    @Override
//    @PreAuthorize("hasRole('ROLE_USER')")
//    @PostAuthorize("hasRole('ROLE_ADMIN') or returnObject.personIdentifier==principal['sub']")
    public WorkflowDefinition get(String id) {
        WorkflowDefinition workflow;
        try {
            SearchService.KeyValue kv = new SearchService.KeyValue(WORKFLOW_ID, id);
            Resource workflowRes = searchService.searchId(getResourceType(), kv);
            if (workflowRes == null) {
                return null;
            }
            workflow = parserPool.deserialize(workflowRes, typeParameterClass).get();
        } catch (UnknownHostException | ExecutionException | InterruptedException e) {
            logger.fatal("Workflow get fatal error", e);
            throw new ServiceException(e);
        }
        return workflow;
    }

    @Override
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public Browsing getAll(FacetFilter filter) {
        filter.setBrowseBy(getBrowseBy());
        return getResults(filter);
    }

    @Override
    public Browsing getMy(FacetFilter filter) {
        OIDCAuthenticationToken authentication = (OIDCAuthenticationToken) SecurityContextHolder.getContext()
                .getAuthentication();
        filter.addFilter("personIdentifier", authentication.getSub());
        return getResults(filter);
    }

    @Override
    public WorkflowDefinition add(WorkflowDefinition workflow) {

        Resource resourceDb = new Resource();
        try {
            workflow.setCreationDate(new Date());
            workflow.setModificationDate(new Date());
            String serialized = mapper.writeValueAsString(workflow);
            resourceDb.setPayloadFormat("json");
            resourceDb.setResourceType(resourceType);
            resourceDb.setVersion("not_set");
            resourceDb.setId(workflow.getOpenmintedId());
            resourceDb.setPayload(serialized);
            resourceService.addResource(resourceDb);
            return workflow;
        } catch (JsonProcessingException e) {
            logger.info("serializer exception", e);
            throw new ServiceException(e);
        }
    }

    @Override
    public WorkflowDefinition update(WorkflowDefinition workflow) {

        Resource resourceDb;
        SearchService.KeyValue kv = new SearchService.KeyValue(
                WORKFLOW_ID,
                workflow.getOpenmintedId()
        );
        try {
            resourceDb = searchService.searchId(getResourceType(), kv);
            if (resourceDb == null) {
                throw new ServiceException(getResourceType() + " with key " + kv.toString() + " does not exists");
            } else {
                workflow.setModificationDate(new Date());
                String serialized = mapper.writeValueAsString(workflow);
                //parserPool.deserialize(resourceDb, ParserService.ParserServiceTypes.JSON).get();
                resourceDb.setPayloadFormat("json");
                resourceDb.setPayload(serialized);
                resourceService.updateResource(resourceDb);
                return workflow;
            }
        } catch (IOException e) {
            logger.fatal("Workflow update fatal error", e);
            throw new ServiceException(e);
        }
    }

    @Override
    public void delete(WorkflowDefinition Workflow) {
        Resource resourceDb;
        try {
            SearchService.KeyValue kv = new SearchService.KeyValue(
                    WORKFLOW_ID,
                    Workflow.getOpenmintedId()
            );
            resourceDb = searchService.searchId(getResourceType(), kv);
            if (resourceDb == null) {
                throw new ServiceException(getResourceType() + " does not exists");
            } else {
                resourceService.deleteResource(Workflow.getWorkflowId());
            }
        } catch (UnknownHostException e) {
            logger.fatal(e);
            throw new ServiceException(e);
        }
    }

    @Override
    public String getResourceType() {
        return "workflow";
    }


    @Override
    public WorkflowDefinition createWorkflow() {
        OIDCAuthenticationToken authentication = (OIDCAuthenticationToken) SecurityContextHolder.getContext()
                .getAuthentication();
        String sub = authentication.getSub().split("@")[0];
        String workflowName = sub + "-" + UUID.randomUUID().toString();
        logger.info("Created a new workflow with name " + workflowName);
        Workflow workflow = galaxyEditorInstance.getWorkflowsClient().createWorkflow(workflowName);
        WorkflowDefinition internalWorkflow = new WorkflowDefinition();
        internalWorkflow.setWorkflowId(workflow.getId());
        internalWorkflow.setWorkflowName(workflowName);
        internalWorkflow.setWorkflowDefinition("{\"name\": \"" + workflowName + "\", \"steps\": {}, \"annotation\": " +
                "\"\"}");
        internalWorkflow.setOpenmintedId(UUID.randomUUID().toString());
        internalWorkflow.setPersonIdentifier(authentication.getSub());
        add(internalWorkflow);
        return internalWorkflow;
    }

    @Override
    public WorkflowDefinition updateWorkflow(String omtdId) throws ResourceNotFoundException {
        WorkflowDefinition workflowDefinition = get(omtdId);
        //EXPORT WORKFLOW FROM EDITOR
        String definition = galaxyEditorInstance.getWorkflowsClient().exportWorkflow(workflowDefinition.getWorkflowId
                ());
        //DELETE WORKFLOW FROM EDITOR
        deleteEditorWorkflow(workflowDefinition.getWorkflowId());
        workflowDefinition.setWorkflowId(null);
        //IMPORT WORKFLOW TO EXECUTOR IF EXISTS DELETE IT
        if (workflowDefinition.getExecutorId() != null) {
            deleteExecutorWorkflow(workflowDefinition.getExecutorId());
            workflowDefinition.setExecutorId(null);
        }
        Workflow executorWorkflow = galaxyExecutorInstance.getWorkflowsClient().importWorkflow(definition);
        workflowDefinition.setExecutorId(executorWorkflow.getId());
        workflowDefinition.setWorkflowDefinition(definition);
        //UPDATE WORKFLOW DEFINITION
        update(workflowDefinition);
        return workflowDefinition;
    }

    @Override
    public String deleteWorkflow(String omtdId) throws ResourceNotFoundException {
        WorkflowDefinition workflow = get(omtdId);
        logger.info("Delete workflow from workflow with id " + workflow.getWorkflowId());
        if (workflow.getWorkflowId() == null) {
            throw new ServiceException("Workflow with omtdid : " + omtdId + "does not exist");
        }
        String workflowId = workflow.getWorkflowId();
        if (workflow.getWorkflowId() != null) {
            galaxyEditorInstance.getWorkflowsClient().deleteWorkflow(workflowId);
            workflow.setWorkflowId(null);
            update(workflow);
            logger.info("Editor workflow with id " + workflowId + " was deleted.");
        } else {
            logger.info("No workflow to delete in workflow definition " + omtdId);
        }
        return workflowId;
    }

    @Override
    public WorkflowDefinition restoreWorkflow(String omtdId) throws ResourceNotFoundException {
        WorkflowDefinition workflow = get(omtdId);
        logger.info("Restore workflow from workflow with id " + workflow.getOpenmintedId());
        if (workflow.getWorkflowId() == null) {
            Workflow galaxyWorkflow = galaxyEditorInstance.getWorkflowsClient().importWorkflow(workflow
                    .getWorkflowDefinition());
            workflow.setWorkflowId(galaxyWorkflow.getId());
            update(workflow);
            logger.debug("Workflow with ID" + omtdId + " already exists in galaxy editor");
        }
        return workflow;
    }

    private String deleteEditorWorkflow(String workflowId) {
        galaxyEditorInstance.getWorkflowsClient().deleteWorkflow(workflowId);
        return workflowId;
    }

    private String deleteExecutorWorkflow(String workflowId) {
        galaxyExecutorInstance.getWorkflowsClient().deleteWorkflow(workflowId);
        return workflowId;
    }

    @Override
    public List<String> deleteAll() {
        List<String> ret = new ArrayList<>();
        List<Workflow> workflows = galaxyEditorInstance.getWorkflowsClient().getWorkflows();
        for (Workflow workflow : workflows) {
            ret.add(deleteEditorWorkflow(workflow.getId()));
        }
        return ret;
    }
}
