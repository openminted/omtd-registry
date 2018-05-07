package eu.openminted.registry.service.tools;

import eu.openminted.registry.core.domain.FacetFilter;
import eu.openminted.registry.core.service.SearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;

@RestController
public class StatsController {

    @Autowired
    SearchService searchService;

    @RequestMapping(value = "/stats/", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ResponseBody
    public ResponseEntity stats() {

        int applicationNo = 0;
        int componentNo = 0;

        try {
            FacetFilter filter = new FacetFilter("","application",0,1,new HashMap<>(), Arrays.asList(""), null);
            applicationNo = searchService.search(filter).getTotal();
            filter.setResourceType("component");
            componentNo = searchService.search(filter).getTotal();
            return new ResponseEntity<>("{'applications':"+applicationNo + ",'components':"+componentNo+"}", HttpStatus.OK);
        } catch (IOException e) {
            return new ResponseEntity<>(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
