package eu.openminted.registry.service;

import eu.openminted.registry.core.service.ResourceService;
import eu.openminted.registry.core.service.SearchService;
import eu.openminted.registry.domain.Component;

import eu.openminted.registry.exception.ResourceNotFoundException;
import eu.openminted.registry.exception.ServerError;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@RestController
public class ComponentController {


    @Autowired
    ResourceCRUDService<Component> componentService;

    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(ResourceNotFoundException.class)
    @ResponseBody ServerError handleBadRequest(HttpServletRequest req, Exception ex) {
        return new ServerError(req.getRequestURL().toString(), ex);
    }

    @RequestMapping(value = "/request/component/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Component> getComponent(@PathVariable("id") String id) {
        Component component = componentService.get(id);
        if(component == null)
            throw new ResourceNotFoundException();
        else
            return new ResponseEntity<>(component, HttpStatus.OK);

    }

    @RequestMapping(value = "/request/component/", method = RequestMethod.POST, headers = "Accept=application/json")
    public ResponseEntity<String> addComponentJson(@RequestBody Component component) {

        componentService.add(component);
        return new ResponseEntity<>(HttpStatus.OK);

    }

    @RequestMapping(value = "/request/component/", method = RequestMethod.POST, headers = "Accept=application/xml")
    public ResponseEntity<String> addComponentXml(@RequestBody Component component) {

        componentService.add(component);
        return new ResponseEntity<>(HttpStatus.OK);

    }

    @RequestMapping(value = "/request/component/", method = RequestMethod.PUT, headers = "Accept=application/json")
    public ResponseEntity<String> updateComponent(@RequestBody Component component) {

        componentService.update(component);
        return new ResponseEntity<>(HttpStatus.OK);

    }

    @RequestMapping(value = "/request/component/", method = RequestMethod.DELETE, headers = "Accept=application/json")
    public ResponseEntity<String> deleteComponent(@RequestBody Component component) {

        componentService.delete(component);
        return new ResponseEntity<>(HttpStatus.OK);

    }
} 
