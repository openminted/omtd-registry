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

    private static Map<String, String> labels = new HashMap<>();
    private static String[] facets = new String[]{"language", "mediatype", "rights", "mimetype",
            "dataformatspecific", "license", "resourceType"};

    static {
        labels.put("language", "Language");
        labels.put("mediatype", "Media Type");
        labels.put("rights", "Rights");
        labels.put("mimetype", "Mime Type");
        labels.put("dataformatspecific", "Data format specific");
        labels.put("license", "License");
        labels.put("resourcetype", "Resource Type");
    }

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
            @RequestParam(value = "license", required = false, defaultValue = "") String[] license,
            @RequestParam(value = "from", required = false, defaultValue = "0") int from,
            @RequestParam(value = "to", required = false, defaultValue = "-1") int to) {

        return requestService.getResponseByFiltersElastic(keyword, resourceType, language, mediaType, rights, mimeType, dataFormatSpecific, license, from, to);

    }


}
