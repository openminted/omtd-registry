package eu.openminted.registry.service.omtd;

import eu.openminted.registry.core.service.ResourceCRUDService;
import eu.openminted.registry.domain.LanguageDescription;
import eu.openminted.registry.service.GenericRestController;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by stefanos on 13/1/2017.
 */
@RestController
@RequestMapping("/request/language")
@Api(value = "/request/language", description = "Operations about OMTD language resources.")
public class LanguageController extends OmtdRestController<LanguageDescription> {

    @Autowired
    LanguageController(ResourceCRUDService<LanguageDescription> service) {
        super(service);
    }
} 
