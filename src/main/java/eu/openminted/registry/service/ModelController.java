package eu.openminted.registry.service;

import eu.openminted.registry.domain.Model;
import eu.openminted.registry.exception.ResourceNotFoundException;
import eu.openminted.registry.exception.ServerError;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.Base64;

/**
 * Created by stefanos on 13/1/2017.
 */
@RestController
@RequestMapping("/request/model")
public class ModelController {

    @Autowired
    ResourceCRUDService<Model> modelService;

    @RequestMapping(value = "{id}", method = RequestMethod.GET, produces = "application/json; charset=utf-8")
    public ResponseEntity<Model> getModel(@PathVariable("id") String id) {
        String id_decoded = new String(Base64.getDecoder().decode(id));
        Model model = modelService.get(id_decoded);
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

