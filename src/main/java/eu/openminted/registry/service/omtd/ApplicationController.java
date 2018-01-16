package eu.openminted.registry.service.omtd;

import eu.openminted.registry.core.service.ResourceCRUDService;
import eu.openminted.registry.domain.Component;
import eu.openminted.registry.service.GenericRestController;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/request/application")
@Api(value = "/request/application", description = "Operations about OMTD applications.")
public class ApplicationController extends OmtdRestController<Component> {

    @Autowired
    ApplicationController(@Qualifier("applicationService")ResourceCRUDService<Component> service) {
        super(service);
    }
}
