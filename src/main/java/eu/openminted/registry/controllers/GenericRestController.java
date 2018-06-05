package eu.openminted.registry.controllers;

import eu.openminted.registry.core.domain.Browsing;
import eu.openminted.registry.core.domain.FacetFilter;
import eu.openminted.registry.core.exception.ResourceNotFoundException;
import eu.openminted.registry.core.service.ResourceCRUDService;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by stefanos on 20/6/2017.
 */

public class GenericRestController<T> {

    final protected ResourceCRUDService<T> service;

    private Logger logger = LogManager.getLogger(GenericRestController.class);

    public GenericRestController(ResourceCRUDService service) {
        this.service = service;
    }

    @RequestMapping(value = "{id}", method = RequestMethod.GET, produces = {MediaType.APPLICATION_JSON_UTF8_VALUE, MediaType.APPLICATION_XML_VALUE})
    public ResponseEntity<T> get(@PathVariable("id") String id) throws ResourceNotFoundException {
        String id_decoded = id; //new String(Base64.getDecoder().decode(id));
        T component = service.get(id_decoded);
        if (component == null)
            throw new ResourceNotFoundException();
        else
            return new ResponseEntity<>(component, HttpStatus.OK);

    }

    @RequestMapping(method = RequestMethod.POST, consumes = {MediaType.APPLICATION_JSON_UTF8_VALUE, MediaType.APPLICATION_XML_VALUE})
    public ResponseEntity<T> add(@RequestBody T component) {
        T ret = service.add(component);
        return ResponseEntity.ok(ret);

    }

    @RequestMapping(method = RequestMethod.PUT, consumes = {MediaType.APPLICATION_JSON_UTF8_VALUE, MediaType.APPLICATION_XML_VALUE},
            produces = {MediaType.APPLICATION_JSON_UTF8_VALUE, MediaType.APPLICATION_XML_VALUE})
    public ResponseEntity<T> update(@RequestBody T component) throws ResourceNotFoundException {
        T ret = service.update(component);
        return new ResponseEntity<>(ret,HttpStatus.OK);

    }

    @RequestMapping(method = RequestMethod.DELETE, consumes = {MediaType.APPLICATION_JSON_UTF8_VALUE, MediaType.APPLICATION_XML_VALUE})
    public ResponseEntity<String> delete(@RequestBody T component) throws ResourceNotFoundException {
        service.delete(component);
        return new ResponseEntity<>(HttpStatus.OK);

    }

    @RequestMapping(path = "all", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<Browsing> getAll(@RequestParam(required = false) Map<String,Object> allRequestParams) {
        FacetFilter filter = new FacetFilter();
        filter.setKeyword(allRequestParams.get("keyword") != null ? (String)allRequestParams.remove("keyword") : "");
        filter.setFrom(allRequestParams.get("from") != null ? Integer.parseInt((String)allRequestParams.remove("from")) : 0);
        filter.setQuantity(allRequestParams.get("quantity") != null ? Integer.parseInt((String)allRequestParams.remove("quantity")) : 10);
        Map<String,Object> sort = new HashMap<>();
        Map<String,Object> order = new HashMap<>();
        String orderDirection = allRequestParams.get("order") != null ? (String)allRequestParams.remove("order") : "asc";
        String orderField = allRequestParams.get("orderField") != null ? (String)allRequestParams.remove("orderField") : null;
        if (orderField != null) {
            order.put("order",orderDirection);
            sort.put(orderField, order);
            filter.setOrderBy(sort);
        }
        filter.setFilter(allRequestParams);
        return new ResponseEntity<>(service.getAll(filter), HttpStatus.OK);
    }

    @PreAuthorize("isAuthenticated()")
    @RequestMapping(path = "my", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<Browsing> getMy(@RequestParam(required = false) Map<String,Object> allRequestParams) {
        FacetFilter filter = new FacetFilter();
        filter.setKeyword(allRequestParams.get("keyword") != null ? (String)allRequestParams.remove("keyword") : "");
        filter.setFrom(allRequestParams.get("from") != null ? Integer.parseInt((String)allRequestParams.remove("from")) : 0);
        filter.setQuantity(allRequestParams.get("quantity") != null ? Integer.parseInt((String)allRequestParams.remove("quantity")) : 10);
        Map<String,Object> sort = new HashMap<>();
        Map<String,Object> order = new HashMap<>();
        String orderDirection = allRequestParams.get("order") != null ? (String)allRequestParams.remove("order") : "asc";
        String orderField = allRequestParams.get("orderField") != null ? (String)allRequestParams.remove("orderField") : null;
        if (orderField != null) {
            order.put("order",orderDirection);
            sort.put(orderField, order);
            filter.setOrderBy(sort);
        }
        filter.setFilter(allRequestParams);
        return new ResponseEntity<>(service.getMy(filter), HttpStatus.OK);
    }
}
