package eu.openminted.registry.controllers.omtd;

import eu.openminted.registry.domain.Corpus;
import eu.openminted.registry.controllers.GenericRestController;
import eu.openminted.registry.service.IncompleteCorpusService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import springfox.documentation.annotations.ApiIgnore;

@RestController
@RequestMapping("/request/incompleteCorpus")
@Api(value = "/request/incompleteCorpus", description = "Operations about OMTD Incomplete corpora.", hidden = true)
@ApiIgnore
public class IncompleteCorpusController extends GenericRestController<Corpus> {

    final private IncompleteCorpusService corpusService;

    @Autowired
    IncompleteCorpusController(IncompleteCorpusService service) {
        super(service);
        this.corpusService = service;
    }

    @RequestMapping(value = "/move/{id}", method = RequestMethod.GET, produces = "application/json; charset=utf-8")
    public void move(@PathVariable("id") String corpusId) {
        corpusService.move(corpusId);
    }
}