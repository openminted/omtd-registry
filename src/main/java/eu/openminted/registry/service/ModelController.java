package eu.openminted.registry.service;

import eu.openminted.registry.domain.Model;
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
@RequestMapping("/request/model")
public class ModelController {

    @Autowired
    ResourceCRUDService<Model> modelService;

    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(ResourceNotFoundException.class)
    @ResponseBody
    ServerError handleBadRequest(HttpServletRequest req, Exception ex) {
        return new ServerError(req.getRequestURL().toString(), ex);
    }

    @RequestMapping(value = "{id}", method = RequestMethod.GET, produces = "application/json; charset=utf-8")
    public ResponseEntity<Model> getModel(@PathVariable("id") String id) {
        Model model = modelService.get(id);
        if(model == null)
            throw new ResourceNotFoundException();
        else
            return new ResponseEntity<>(model, HttpStatus.OK);

    }

    @RequestMapping(method = RequestMethod.POST, headers = "Accept=application/json; charset=utf-8")
    public ResponseEntity<String> addModelJson(@RequestBody Model model) {

        modelService.add(model);
        return new ResponseEntity<>(HttpStatus.OK);

    }

    @RequestMapping(method = RequestMethod.POST, headers = "Accept=application/xml; charset=utf-8")
    public ResponseEntity<String> addModelXml(@RequestBody Model model) {

        modelService.add(model);
        return new ResponseEntity<>(HttpStatus.OK);

    }

    @RequestMapping(method = RequestMethod.PUT, headers = "Accept=application/json; charset=utf-8")
    public ResponseEntity<String> updateModel(@RequestBody Model model) {

        modelService.update(model);
        return new ResponseEntity<>(HttpStatus.OK);

    }

    @RequestMapping(method = RequestMethod.DELETE, headers = "Accept=application/json; charset=utf-8")
    public ResponseEntity<String> deleteModel(@RequestBody Model model) {

        modelService.delete(model);
        return new ResponseEntity<>(HttpStatus.OK);

    }
} 

