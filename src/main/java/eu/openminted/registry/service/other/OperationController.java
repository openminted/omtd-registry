package eu.openminted.registry.service.other;

import eu.openminted.registry.core.service.ResourceCRUDService;
import eu.openminted.registry.domain.operation.Operation;
import eu.openminted.registry.service.GenericRestController;
import eu.openminted.registry.service.OperationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by stefanos on 10/7/2017.
 */

@RestController
@RequestMapping({"operation", "/request/operation"})
public class OperationController extends OtherRestController<Operation> {

    @Autowired
    OperationController(ResourceCRUDService<Operation> service) {
        super(service);
    }

    @RequestMapping(value = "executeJob", method = RequestMethod.GET)
    @PreAuthorize("isAuthenticated()")
    ResponseEntity<String> executeJob(
            @RequestParam(value = "corpusId") String corpusId,
            @RequestParam(value="applicationId") String applicationId) {
        String executionId = ((OperationService) service).executeJob(corpusId,applicationId);
        return ResponseEntity.ok(executionId);
    }

}
