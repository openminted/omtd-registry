package eu.openminted.registry.controllers.other;

import eu.openminted.registry.core.exception.ResourceNotFoundException;
import eu.openminted.registry.core.service.ResourceCRUDService;
import eu.openminted.registry.domain.workflow.WorkflowDefinition;
import eu.openminted.registry.service.WorkflowService;
import io.swagger.annotations.Api;
import org.mitre.openid.connect.model.OIDCAuthenticationToken;
import org.mitre.openid.connect.model.UserInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PostAuthorize;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by stefanos on 10/7/2017.
 */

@RestController
@RequestMapping({"/request/workflow"})
@Api(value = "/request/workflow", description = "Operations about Galaxy workflows.", tags="Galaxy Workflows")
public class WorkflowDefinitionController extends OtherRestController<WorkflowDefinition> {

    WorkflowService workflowService;

    @Autowired
    WorkflowDefinitionController(ResourceCRUDService<WorkflowDefinition,OIDCAuthenticationToken> service) {
        super(service);
        this.workflowService = (WorkflowService) service;
    }

    @RequestMapping(value = "create", method = RequestMethod.GET)
    @PreAuthorize("hasRole('ROLE_USER')")
    public ResponseEntity<WorkflowDefinition> createWorkflow(Authentication authentication) {
        System.out.println(authentication);
        return ResponseEntity.ok(workflowService.createWorkflow());
    }

    @RequestMapping(value = "update/{workflowId}", method = {RequestMethod.GET, RequestMethod.POST})
    @PreAuthorize("hasRole('ROLE_USER')")
    @PostAuthorize("hasRole('ROLE_ADMIN') or returnObject.body.personIdentifier==principal['sub']")
    public ResponseEntity<WorkflowDefinition> updateWorkflow(@PathVariable("workflowId") String workflowID) throws ResourceNotFoundException {
        return ResponseEntity.ok(workflowService.updateWorkflow(workflowID));
    }

    @RequestMapping(value = "restore/{workflowId}", method = {RequestMethod.GET, RequestMethod.POST})
    @PreAuthorize("hasRole('ROLE_USER')")
    @PostAuthorize("hasRole('ROLE_ADMIN') or returnObject.body.personIdentifier==principal['sub']")
    public ResponseEntity<WorkflowDefinition> restoreWorkflow(@PathVariable("workflowId") String workflowID) throws ResourceNotFoundException {
        return ResponseEntity.ok(workflowService.restoreWorkflow(workflowID));
    }

    @RequestMapping(value = "deleteEditor/{workflowId}", method = RequestMethod.DELETE)
    @PreAuthorize("hasRole('ROLE_USER')")
    public ResponseEntity<String> deleteFromEditor(@PathVariable("workflowId") String workflowID) throws ResourceNotFoundException {
        return ResponseEntity.ok(workflowService.deleteWorkflow(workflowID));
    }

    @RequestMapping(value = "deleteAll", method = RequestMethod.DELETE)
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public ResponseEntity<List<String>> deleteAll() {
        return ResponseEntity.ok(workflowService.deleteAll());
    }

}
