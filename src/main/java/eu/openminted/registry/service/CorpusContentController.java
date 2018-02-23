package eu.openminted.registry.service;


import eu.openminted.registry.core.domain.Browsing;
import eu.openminted.registry.domain.CorpusContent;
import eu.openminted.registry.domain.PublicationInfo;
import org.hibernate.service.spi.ServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.MediaType;
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

    @RequestMapping(path = "/getCorpusContent", method = RequestMethod.GET, produces = {MediaType.APPLICATION_JSON_UTF8_VALUE})
    public Browsing<PublicationInfo> getCorpusContent(@RequestParam(value="corpusId") String corpusId,
                                     @RequestParam(defaultValue = "0") int from, @RequestParam(defaultValue = "1000") int size) {
        if(size < 0) throw new ServiceException("Size is negative");
        return corpusContentService.getCorpusContent(corpusId, from, size);
    }
}
