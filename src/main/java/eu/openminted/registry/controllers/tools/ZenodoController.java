package eu.openminted.registry.controllers.tools;

import eu.openminted.registry.service.ZenodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/zenodo")
public class ZenodoController {

    @Autowired
    public ZenodoService zenodoService;

    @RequestMapping(path="/publishCorpus/{corpusId}", method = RequestMethod.GET, produces = {MediaType.APPLICATION_JSON_UTF8_VALUE})
    public String publishCorpus(@PathVariable(value="corpusId") String corpusId) {
        return zenodoService.publishCorpus(corpusId);
    }
}
