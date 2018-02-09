package eu.openminted.registry.service;

import eu.openminted.registry.core.service.ResourceCRUDService;
import eu.openminted.registry.domain.operation.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by stefanos on 10/7/2017.
 */

@RestController
@RequestMapping({"operation", "/request/operation"})
public class OperationController extends GenericRestController<Operation>{

    @Autowired
    OperationController(ResourceCRUDService<Operation> service) {
        super(service);
    }

    @RequestMapping(value = "executeJob", method = RequestMethod.GET)
    ResponseEntity<String> executeJob(
            @RequestParam(value = "corpusId") String corpusId,
            @RequestParam(value="applicationId") String applicationId) {
        String executionId = ((OperationService) service).executeJob(corpusId,applicationId);
        return ResponseEntity.ok(executionId);
    }

}
