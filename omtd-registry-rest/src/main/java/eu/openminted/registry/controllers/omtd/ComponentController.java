package eu.openminted.registry.controllers.omtd;

import eu.openminted.registry.domain.Component;
import eu.openminted.registry.service.ValidateInterface;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/request/component")
@Api(value = "/request/component", description = "Operations about OMTD Components.", tags="Components")
public class ComponentController extends OmtdRestController<Component>{

    private ValidateInterface<Component> validateInterface;

    @Autowired
    ComponentController(@Qualifier("componentService") ValidateInterface<Component> service) {
        super(service);
        validateInterface = service;
    }
}
