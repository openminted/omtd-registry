package eu.openminted.registry.service.util;

import eu.openminted.registry.core.service.ResourceCRUDService;
import eu.openminted.registry.core.service.ServiceException;
import eu.openminted.registry.domain.workflow.WorkflowDefinition;
import eu.openminted.registry.service.GenericRestController;
import eu.openminted.registry.service.WorkflowService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;

/**
 * Created by stefanos on 10/7/2017.
 */

@RestController
@RequestMapping({"workflow", "/request/workflow"})
@Api(description = "Operations about the workflow definitions.")
public class WorkflowDefinitionController extends GenericRestController<WorkflowDefinition> {

    WorkflowService workflowService = null;

    @Autowired
    WorkflowDefinitionController(ResourceCRUDService<WorkflowDefinition> service) {
        super(service);
        this.workflowService = (WorkflowService) service;
    }


    @ApiOperation(value = "Create a new workflow identifier created in the workflow editor.")
    @RequestMapping(path = "create", method = RequestMethod.GET)
    @PreAuthorize("hasRole('ROLE_USER')")
    public ResponseEntity<String> createWorkflow() {
        return ResponseEntity.ok(workflowService.createWorkflow());
    }


    @ApiOperation(value = "Updates a workflow identifier in the workflow editor.")
    @RequestMapping(path = "update/{workflowId}", method = RequestMethod.GET)
    @PreAuthorize("hasRole('ROLE_USER')")
    public void updateWorkflow(@PathVariable("workflowId") String workflowID, HttpServletResponse response) {
        try {
            response.sendRedirect(workflowService.updateWorkflow(workflowID));
        } catch (Exception e) {
            throw new ServiceException(e);
        }
    }
}
