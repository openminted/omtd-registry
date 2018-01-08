package eu.openminted.registry.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
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
