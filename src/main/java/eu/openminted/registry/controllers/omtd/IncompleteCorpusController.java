package eu.openminted.registry.controllers.omtd;

import eu.openminted.registry.domain.Corpus;
import eu.openminted.registry.controllers.GenericRestController;
import eu.openminted.registry.service.IncompleteCorpusService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/request/incompleteCorpus")
@Api(value = "/request/incompleteCorpus", description = "Operations about OMTD incomplete corpora.")
public class IncompleteCorpusController extends OmtdRestController<Corpus> {

    final private IncompleteCorpusService corpusService;

    @Autowired
    IncompleteCorpusController(IncompleteCorpusService service) {
        super(service);
        this.corpusService = service;
    }

    @RequestMapping(value = "/move/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ApiOperation(value = "Moves the corpus from the incomplete corpus index to the corpus index.")
    public void move(@PathVariable("id") String corpusId) {
        corpusService.move(corpusId);
    }
}