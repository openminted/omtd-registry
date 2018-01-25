package eu.openminted.registry.controllers.omtd;

import eu.openminted.registry.core.service.ServiceException;
import eu.openminted.registry.domain.Component;
import eu.openminted.registry.controllers.GenericRestController;
import eu.openminted.registry.service.ValidateInterface;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.io.StringWriter;
import java.net.URL;
import java.net.URLConnection;

@RestController
@RequestMapping("/request/component")
@Api(value = "/request/component", description = "Operations about OMTD components.")
public class ComponentController extends OmtdRestController<Component> {

    @Autowired
    ComponentController(@Qualifier("componentService") ValidateInterface<Component> service) {
        super(service);
    }
}
