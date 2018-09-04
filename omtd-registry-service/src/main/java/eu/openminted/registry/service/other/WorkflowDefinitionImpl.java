package eu.openminted.registry.service.other;


import com.github.jmchilton.blend4j.galaxy.GalaxyInstance;
import com.github.jmchilton.blend4j.galaxy.beans.Workflow;
import eu.openminted.registry.core.domain.Resource;
import eu.openminted.registry.core.exception.ResourceNotFoundException;
import eu.openminted.registry.core.service.SearchService;
import eu.openminted.registry.core.service.ServiceException;
import eu.openminted.registry.domain.workflow.WorkflowDefinition;
import eu.openminted.registry.service.WorkflowService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.mitre.openid.connect.model.OIDCAuthenticationToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.ExecutionException;

/**
 * Created by stefanos on 30/6/2017.
 */
@Service("WorkflowService")
@Primary
public class WorkflowDefinitionImpl extends OtherGenericService<WorkflowDefinition> implements WorkflowService {

    private static final String WORKFLOW_ID = "openminted_id";

    private Logger logger = LogManager.getLogger(WorkflowDefinitionImpl.class);

    @Autowired(required = false)
    @Qualifier("galaxyInstanceFactory")
    private GalaxyInstance galaxyEditorInstance;

    @Autowired(required = false)
    @Qualifier("galaxyExecutorInstanceFactory")
    private GalaxyInstance galaxyExecutorInstance;

    public WorkflowDefinitionImpl() {
        super(WorkflowDefinition.class);
    }

    @Override
    String getResourceId() {
        return WORKFLOW_ID;
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
        internalWorkflow.setOmtdId(UUID.randomUUID().toString());
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
        logger.info("Restore workflow from workflow with id " + workflow.getOmtdId());
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
