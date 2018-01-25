package eu.openminted.registry.controllers.restore;

import eu.openminted.registry.core.service.RestoreService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
public class RestoreController {

    @Autowired
    RestoreService restoreService;


    @RequestMapping(value = "/restore/", method = RequestMethod.POST)
    @ResponseBody
    @ApiOperation(value = "Restores all resources that were produced by the dump service.")
//    @PreAuthorize("hasRole('ROLE_USER')")
    public void restoreAll(@RequestParam("datafile") MultipartFile file ) {
        restoreService.restoreDataFromZip(file);
    }

}
