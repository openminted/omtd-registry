package eu.openminted.registry.service.util;

import eu.openminted.registry.core.service.ResourceCRUDService;
import eu.openminted.registry.domain.operation.Operation;
import eu.openminted.registry.service.GenericRestController;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by stefanos on 10/7/2017.
 */

@RestController
@RequestMapping({"operation", "/request/operation"})
@Api(value = "Operations about workflow execution operations.")
public class OperationController extends GenericRestController<Operation> {

    @Autowired
    OperationController(ResourceCRUDService<Operation> service) {
        super(service);
    }
}
