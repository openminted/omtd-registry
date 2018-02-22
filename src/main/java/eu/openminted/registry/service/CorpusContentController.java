package eu.openminted.registry.service;


import eu.openminted.registry.domain.CorpusContent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by spyroukostas on 7-Feb-2018.
 */
@RestController
@RequestMapping("/request/corpuscontent")
public class CorpusContentController {

    final private CorpusContentService corpusContentService;

    @Autowired
    CorpusContentController(CorpusContentService content) {
        this.corpusContentService = content;
    }

    @RequestMapping(path = "/getCorpusContent", method = RequestMethod.GET)
    public CorpusContent getCorpusContent(@RequestParam(value="corpusId") String corpusId) {
        return corpusContentService.getCorpusContent(corpusId);
    }
}
