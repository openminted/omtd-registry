package eu.openminted.registry.controllers.omtd;

import eu.openminted.registry.domain.Corpus;
import eu.openminted.registry.controllers.GenericRestController;
import eu.openminted.registry.service.IncompleteCorpusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/request/incompleteCorpus")
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