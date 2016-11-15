package eu.openminted.registry.service;

import eu.openminted.registry.core.domain.Paging;
import eu.openminted.registry.core.domain.Resource;
import eu.openminted.registry.core.service.ResourceService;
import eu.openminted.registry.core.service.SearchService;
import eu.openminted.registry.core.service.ServiceException;
import eu.openminted.registry.domain.Corpus;
import eu.openminted.registry.exception.ResourceNotFoundException;
import eu.openminted.registry.exception.ServerError;
import org.elasticsearch.index.query.BoolQueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;

@RestController
public class CorpusController {


    @Autowired
    ResourceCRUDService<Corpus> corpusService;

    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(ResourceNotFoundException.class)
    @ResponseBody
    ServerError handleBadRequest(HttpServletRequest req, Exception ex) {
        return new ServerError(req.getRequestURL().toString(), ex);
    }

    @RequestMapping(value = "/request/corpus/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Corpus> getCorpus(@PathVariable("id") String id) {
        Corpus component = corpusService.get(id);
        if(component == null)
            throw new ResourceNotFoundException();
        else
            return new ResponseEntity<>(component, HttpStatus.OK);
    }

    @RequestMapping(value = "/request/corpus/", method = RequestMethod.POST, headers = "Accept=application/json")
    public ResponseEntity<String> addCorpus(@RequestBody Corpus corpus) {
        corpusService.add(corpus);
        return new ResponseEntity<>(HttpStatus.OK);
    }


    @RequestMapping(value = "/request/corpus/", method = RequestMethod.POST, headers = "Accept=application/xml")
    public ResponseEntity<String> addCorpusXml(@RequestBody Corpus corpus) {

        corpusService.add(corpus);
        return new ResponseEntity<>(HttpStatus.OK);

    }

    @RequestMapping(value = "/request/corpus/", method = RequestMethod.PUT, headers = "Accept=application/json")
    public ResponseEntity<String> updateCorpus(@RequestBody Corpus corpus) {

        corpusService.update(corpus);
        return new ResponseEntity<>(HttpStatus.OK);

    }

    @RequestMapping(value = "/request/corpus/", method = RequestMethod.DELETE, headers = "Accept=application/json")
    public ResponseEntity<String> deleteCorpus(@RequestBody Corpus corpus) {

        corpusService.delete(corpus);
        return new ResponseEntity<>(HttpStatus.OK);


    }
}