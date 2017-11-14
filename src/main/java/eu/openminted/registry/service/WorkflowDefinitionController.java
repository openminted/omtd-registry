package eu.openminted.registry.service;

import eu.openminted.registry.core.service.ResourceCRUDService;
import eu.openminted.registry.domain.operation.Operation;
import eu.openminted.registry.domain.workflow.Workflow;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by stefanos on 10/7/2017.
 */

@RestController
@RequestMapping({"workflow", "/request/workflow"})
public class WorkflowDefinitionController extends GenericRestController<Workflow>{

    @Autowired
    WorkflowDefinitionController(ResourceCRUDService<Workflow> service) {
        super(service);
    }
}
