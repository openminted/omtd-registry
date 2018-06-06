package eu.openminted.registry.controllers.tools;

import eu.openminted.registry.core.service.RestoreService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import springfox.documentation.annotations.ApiIgnore;

@RestController
@Api(hidden = true)
@ApiIgnore
public class RestoreController {

    @Autowired
    RestoreService restoreService;


    @RequestMapping(value = "/restore/", method = RequestMethod.POST)
    @ResponseBody
//    @PreAuthorize("hasRole('ROLE_USER')")
    public void restoreAll(@RequestParam("datafile") MultipartFile file ) {
        restoreService.restoreDataFromZip(file);
    }

}
