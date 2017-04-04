package eu.openminted.registry.service;

import eu.openminted.registry.core.service.ResourceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class RequestController {

    @Autowired
    ResourceService resourceService;

    @Autowired
    RequestService requestService;


    @RequestMapping(value = "/request", method = RequestMethod.GET, produces = "application/json; charset=utf-8")
    public ResponseEntity<String> getResourceTypeByFilters(
            @RequestParam(value = "keyword", required = false, defaultValue = "") String keyword,
            @RequestParam(value = "resourceType", required = false, defaultValue = "") String[] resourceType,
            @RequestParam(value = "language", required = false, defaultValue = "") String[] language,
            @RequestParam(value = "mediatype", required = false, defaultValue = "") String[] mediaType,
            @RequestParam(value = "rights", required = false, defaultValue = "") String[] rights,
            @RequestParam(value = "mimetype", required = false, defaultValue = "") String[] mimeType,
            @RequestParam(value = "dataFormatSpecific", required = false, defaultValue = "") String[]
					dataFormatSpecific,
            @RequestParam(value = "advanced", required = false, defaultValue = "true") boolean advanced,
            @RequestParam(value = "license", required = false, defaultValue = "") String[] license,
            @RequestParam(value = "from", required = false, defaultValue = "0") int from,
            @RequestParam(value = "to", required = false, defaultValue = "-1") int to) {

        //ResponseE

        return requestService.getResponseByFiltersElastic(keyword, resourceType, language, mediaType, rights, mimeType, dataFormatSpecific, license, advanced, from, to);

    }


}
