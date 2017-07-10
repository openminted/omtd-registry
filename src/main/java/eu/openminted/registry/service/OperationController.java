package eu.openminted.registry.service;

import eu.openminted.registry.core.service.ResourceCRUDService;
import eu.openminted.registry.domain.operation.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
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
}
