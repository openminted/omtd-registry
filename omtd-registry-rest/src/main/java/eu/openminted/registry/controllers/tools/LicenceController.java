package eu.openminted.registry.controllers.tools;

import eu.openminted.registry.LicenceService;
import eu.openminted.registry.core.exception.ResourceNotFoundException;
import eu.openminted.registry.domain.licence.Licence;
import eu.openminted.registry.domain.licence.LicenceCompatibility;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/request/licence")
@Api(description = "Compare Licences", tags = "Licence")
public class LicenceController {

    @Autowired
    LicenceService licenceService;

    @RequestMapping(value = "{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public Licence get(@PathVariable("id") String id) {
        return licenceService.get(id);
    }

    @RequestMapping(value = "all", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public List<Licence> getAll() {
        return licenceService.getAll();
    }

    @RequestMapping(value = "all/{category}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public List<Licence> getAll(@PathVariable("category") String category) {
        return licenceService.getAll(category);
    }

    @RequestMapping(value = "compare", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public LicenceCompatibility compare(@RequestParam("l1") String licence1, @RequestParam("l2") String licence2) throws ResourceNotFoundException {
        return licenceService.compare(licence1,licence2);
    }


}