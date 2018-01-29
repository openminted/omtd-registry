package eu.openminted.registry.service;

import eu.openminted.registry.core.service.ResourceCRUDService;
import eu.openminted.registry.core.service.ServiceException;
import eu.openminted.registry.domain.workflow.WorkflowDefinition;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;

/**
 * Created by stefanos on 10/7/2017.
 */

@RestController
@RequestMapping({"workflow", "/request/workflow"})
public class WorkflowDefinitionController extends GenericRestController<WorkflowDefinition>{

    WorkflowService workflowService = null;

    @Autowired
    WorkflowDefinitionController(ResourceCRUDService<WorkflowDefinition> service) {
        super(service);
        this.workflowService = (WorkflowService) service;
    }

    @RequestMapping("create")
    @PreAuthorize("hasRole('ROLE_USER')")
    public ResponseEntity<String> createWorkflow() {
        return ResponseEntity.ok(workflowService.createWorkflow());
    }

    @RequestMapping("update/{workflowId}")
    @PreAuthorize("hasRole('ROLE_USER')")
    public ResponseEntity<String> updateWorkflow(@PathVariable("workflowId") String workflowID) {
        return ResponseEntity.ok(workflowService.updateWorkflow(workflowID));
    }
}
