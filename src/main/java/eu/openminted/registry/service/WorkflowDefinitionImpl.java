package eu.openminted.registry.service;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.util.ISO8601DateFormat;
import com.github.jmchilton.blend4j.galaxy.GalaxyInstance;
import com.github.jmchilton.blend4j.galaxy.beans.Workflow;
import eu.openminted.registry.core.domain.Browsing;
import eu.openminted.registry.core.domain.FacetFilter;
import eu.openminted.registry.core.domain.Resource;
import eu.openminted.registry.core.service.AbstractGenericService;
import eu.openminted.registry.core.service.SearchService;
import eu.openminted.registry.core.service.ServiceException;
import eu.openminted.registry.domain.workflow.WorkflowDefinition;
import org.apache.log4j.Logger;
import org.mitre.openid.connect.model.OIDCAuthenticationToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.security.access.prepost.PostAuthorize;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.net.UnknownHostException;
import java.util.Date;
import java.util.UUID;
import java.util.concurrent.ExecutionException;

/**
 * Created by stefanos on 30/6/2017.
 */
@Service("WorkflowService")
@Primary
public class WorkflowDefinitionImpl extends AbstractGenericService<WorkflowDefinition> implements WorkflowService {

    private static final String WORKFLOW_ID = "workflow_id";

    private Logger logger = Logger.getLogger(WorkflowDefinitionImpl.class);

    private ObjectMapper mapper;

    @Autowired
    private GalaxyInstance galaxyInstance;

    public WorkflowDefinitionImpl() {
        super(WorkflowDefinition.class);
        mapper = new ObjectMapper();
        mapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
        mapper.setDateFormat(new ISO8601DateFormat());
    }

    @Override
    @PreAuthorize("hasRole('ROLE_USER')")
    @PostAuthorize("returnObject.personIdentifier==authentication.sub")
    public WorkflowDefinition get(String id) {
        WorkflowDefinition workflow;
        try {
            SearchService.KeyValue kv = new SearchService.KeyValue(WORKFLOW_ID, id);
            workflow = parserPool.serialize(searchService.searchId(getResourceType(), kv), typeParameterClass).get();
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
        OIDCAuthenticationToken authentication = (OIDCAuthenticationToken) SecurityContextHolder.getContext().getAuthentication();
        filter.addFilter("personIdentifier", authentication.getSub());
        return getResults(filter);
    }

    @Override
    public void add(WorkflowDefinition Workflow) {

        Resource resourceDb = new Resource();
        try {
            String serialized = mapper.writeValueAsString(Workflow);
            resourceDb.setPayloadFormat("json");
            resourceDb.setResourceType(getResourceType());
            resourceDb.setVersion("not_set");
            resourceDb.setId(Workflow.getWorkflowId());
            resourceDb.setPayload(serialized);
        } catch (JsonProcessingException e) {
            logger.info("serializer exception", e);
            throw new ServiceException(e);
        }
        try {
            resourceService.addResource(resourceDb);
        } catch (Exception e) {
            logger.info("add Workflow", e);
        }

    }

    @Override
    public void update(WorkflowDefinition Workflow) {

        Resource resourceDb;
        SearchService.KeyValue kv = new SearchService.KeyValue(
                WORKFLOW_ID,
                Workflow.getWorkflowId()
        );
        try {
            resourceDb = searchService.searchId(getResourceType(), kv);
            if (resourceDb == null) {
                throw new ServiceException(getResourceType() + " with key " + kv.toString() + " does not exists");
            } else {
                String serialized = mapper.writeValueAsString(Workflow);
                //parserPool.deserialize(resourceDb, ParserService.ParserServiceTypes.JSON).get();
                resourceDb.setPayloadFormat("json");
                resourceDb.setPayload(serialized);
                resourceService.updateResource(resourceDb);

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
                    Workflow.getWorkflowId()
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
    public String createWorkflow() {
        OIDCAuthenticationToken authentication = (OIDCAuthenticationToken) SecurityContextHolder.getContext().getAuthentication();
        String workflowName = authentication.getSub() + " " +UUID.randomUUID().toString();
        Workflow workflow = galaxyInstance.getWorkflowsClient().createWorkflow(workflowName);
        WorkflowDefinition internalWorkflow = new WorkflowDefinition();
        internalWorkflow.setWorkflowId(workflow.getId());
        internalWorkflow.setCreationDate(new Date());
        internalWorkflow.setModificationDate(new Date());
        internalWorkflow.setWorkflowName(workflowName);
        internalWorkflow.setWorkflowDefinition("{\"name\": \"" + workflowName + "\", \"steps\": {}, \"annotation\": \"\"}");
        internalWorkflow.setOpenmintedId(UUID.randomUUID().toString());
        internalWorkflow.setPersonIdentifier(authentication.getSub());
        add(internalWorkflow);
        return workflow.getId();
    }

    @Override
    public String updateWorkflow(String openmintedId) {
        WorkflowDefinition workflowDefinition = get(openmintedId);
        String definition = galaxyInstance.getWorkflowsClient().exportWorkflow(workflowDefinition.getWorkflowId());
        workflowDefinition.setWorkflowDefinition(definition);
        update(workflowDefinition);
        return "https://dev.openminted.eu/home";
    }

    @Override
    public void deleteWorkflow(String workflowId) {
        galaxyInstance.getWorkflowsClient().deleteWorkflow(workflowId);
    }

}
