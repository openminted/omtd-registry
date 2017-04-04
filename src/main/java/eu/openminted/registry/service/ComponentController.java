package eu.openminted.registry.service;

import eu.openminted.registry.domain.Component;
import eu.openminted.registry.exception.ResourceNotFoundException;
import eu.openminted.registry.exception.ServerError;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.Base64;

@RestController
@RequestMapping("/request/component")
public class ComponentController {

    @Autowired
    ResourceCRUDService<Component> componentService;

    @RequestMapping(value = "{id}", method = RequestMethod.GET, produces = "application/json; charset=utf-8")
    public ResponseEntity<Component> getComponent(@PathVariable("id") String id) {
        String id_decoded = new String(Base64.getDecoder().decode(id));
        Component component = componentService.get(id_decoded);
        if(component == null)
            throw new ResourceNotFoundException();
        else
            return new ResponseEntity<>(component, HttpStatus.OK);

    }

    @RequestMapping(method = RequestMethod.POST, headers = "Accept=application/json; charset=utf-8")
    public ResponseEntity<String> addComponentJson(@RequestBody Component component) {

        componentService.add(component);
        return new ResponseEntity<>(HttpStatus.OK);

    }

    @RequestMapping(method = RequestMethod.POST, headers = "Accept=application/xml; charset=utf-8")
    public ResponseEntity<String> addComponentXml(@RequestBody Component component) {

        componentService.add(component);
        return new ResponseEntity<>(HttpStatus.OK);

    }

    @RequestMapping(method = RequestMethod.PUT, headers = "Accept=application/json; charset=utf-8")
    public ResponseEntity<String> updateComponent(@RequestBody Component component) {

        componentService.update(component);
        return new ResponseEntity<>(HttpStatus.OK);

    }

    @RequestMapping(method = RequestMethod.DELETE, headers = "Accept=application/json; charset=utf-8")
    public ResponseEntity<String> deleteComponent(@RequestBody Component component) {

        componentService.delete(component);
        return new ResponseEntity<>(HttpStatus.OK);

    }
} 
