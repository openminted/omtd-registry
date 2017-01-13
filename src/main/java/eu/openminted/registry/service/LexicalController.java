package eu.openminted.registry.service;

import eu.openminted.registry.domain.Lexical;
import eu.openminted.registry.exception.ResourceNotFoundException;
import eu.openminted.registry.exception.ServerError;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by stefanos on 13/1/2017.
 */
@RestController
@RequestMapping("/request/lexical")
public class LexicalController {

    @Autowired
    ResourceCRUDService<Lexical> lexicalService;

    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(ResourceNotFoundException.class)
    @ResponseBody
    ServerError handleBadRequest(HttpServletRequest req, Exception ex) {
        return new ServerError(req.getRequestURL().toString(), ex);
    }

    @RequestMapping(value = "{id}", method = RequestMethod.GET, produces = "application/json; charset=utf-8")
    public ResponseEntity<Lexical> getLexical(@PathVariable("id") String id) {
        Lexical lexical = lexicalService.get(id);
        if(lexical == null)
            throw new ResourceNotFoundException();
        else
            return new ResponseEntity<>(lexical, HttpStatus.OK);

    }

    @RequestMapping(method = RequestMethod.POST, headers = "Accept=application/json; charset=utf-8")
    public ResponseEntity<String> addLexicalJson(@RequestBody Lexical lexical) {

        lexicalService.add(lexical);
        return new ResponseEntity<>(HttpStatus.OK);

    }

    @RequestMapping(method = RequestMethod.POST, headers = "Accept=application/xml; charset=utf-8")
    public ResponseEntity<String> addLexicalXml(@RequestBody Lexical lexical) {

        lexicalService.add(lexical);
        return new ResponseEntity<>(HttpStatus.OK);

    }

    @RequestMapping(method = RequestMethod.PUT, headers = "Accept=application/json; charset=utf-8")
    public ResponseEntity<String> updateLexical(@RequestBody Lexical lexical) {

        lexicalService.update(lexical);
        return new ResponseEntity<>(HttpStatus.OK);

    }

    @RequestMapping(method = RequestMethod.DELETE, headers = "Accept=application/json; charset=utf-8")
    public ResponseEntity<String> deleteLexical(@RequestBody Lexical lexical) {

        lexicalService.delete(lexical);
        return new ResponseEntity<>(HttpStatus.OK);

    }
} 
