package eu.openminted.registry.service.omtd;

import eu.openminted.registry.core.service.ResourceCRUDService;
import eu.openminted.registry.domain.Lexical;
import eu.openminted.registry.service.GenericRestController;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by stefanos on 13/1/2017.
 */
@RestController
@RequestMapping("/request/lexical")
@Api(value = "/request/lexical", description = "Operations about OMTD lexical conceptual resources.")
public class LexicalController extends OmtdRestController<Lexical> {

    @Autowired
    LexicalController(ResourceCRUDService<Lexical> service) {
        super(service);
    }
} 
