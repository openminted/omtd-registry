package eu.openminted.registry.controllers.omtd;

import eu.openminted.registry.domain.Component;
import eu.openminted.registry.service.ValidateInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/request/application")
public class ApplicationController extends OmtdRestController<Component>{

    @Autowired
    ApplicationController(@Qualifier("applicationService")ValidateInterface<Component> service) {
        super(service);
    }
}
