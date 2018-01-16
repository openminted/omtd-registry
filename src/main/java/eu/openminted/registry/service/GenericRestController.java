package eu.openminted.registry.service;

import eu.openminted.registry.core.domain.Browsing;
import eu.openminted.registry.core.domain.FacetFilter;
import eu.openminted.registry.core.exception.ResourceNotFoundException;
import eu.openminted.registry.core.exception.ServerError;
import eu.openminted.registry.core.service.ResourceCRUDService;
import eu.openminted.registry.core.service.ServiceException;
import eu.openminted.registry.domain.Component;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.io.IOUtils;
import org.apache.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.io.StringWriter;
import java.net.URL;
import java.net.URLConnection;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by stefanos on 20/6/2017.
 */
public class GenericRestController<T> {

    final protected ResourceCRUDService<T> service;

    private Logger logger = Logger.getLogger(GenericRestController.class);

    @SuppressWarnings("unchecked")
    public GenericRestController(ResourceCRUDService<T> service) {
        this.service = service;
    }

    @ApiOperation(value = "Returns the resource described by it's id.")
    @RequestMapping(value = "{id}", method = RequestMethod.GET, produces = "application/json; charset=utf-8")
    public ResponseEntity<T> getResource(@PathVariable("id") String id) {
        String id_decoded = id; //new String(Base64.getDecoder().decode(id));
        T component = service.get(id_decoded);
        if (component == null)
            throw new ResourceNotFoundException();
        else
            return new ResponseEntity<>(component, HttpStatus.OK);

    }

    @ApiOperation(value = "Create a new resource.")
    @RequestMapping(method = RequestMethod.POST,
            consumes = MediaType.APPLICATION_JSON_UTF8_VALUE,
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<String> addResourceJSON(@RequestBody T component) {
        service.add(component);
        return new ResponseEntity<>(HttpStatus.OK);

    }

    @ApiOperation(value = "Create a new resource.")
    @RequestMapping(method = RequestMethod.POST,
            consumes = MediaType.APPLICATION_XML_VALUE,
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<String> addResourceXML(@RequestBody T component) {
        service.add(component);
        return new ResponseEntity<>(HttpStatus.OK);

    }

    @ApiOperation(value = "Update an existing resource.")
    @RequestMapping(method = RequestMethod.PUT,
            consumes = {MediaType.APPLICATION_JSON_UTF8_VALUE,MediaType.APPLICATION_XML_VALUE},
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<T> updateResource(@RequestBody T component) {
        service.update(component);
        return new ResponseEntity<>(component,HttpStatus.OK);

    }

    @ApiOperation(value = "Delete an existing resource.")
    @RequestMapping(method = RequestMethod.DELETE,
            consumes = {MediaType.APPLICATION_JSON_UTF8_VALUE,MediaType.APPLICATION_XML_VALUE},
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<String> deleteResource(@RequestBody T component) {
        service.delete(component);
        return new ResponseEntity<>(HttpStatus.OK);

    }

    @ApiOperation(value = "Returns all resources of a specific resource type.")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "keyword", value = "Keyword for search refine", dataType = "string", paramType = "query"),
            @ApiImplicitParam(name = "from", value = "From paging", dataType = "string", paramType = "query"),
            @ApiImplicitParam(name = "quantity", value = "Quantity of resources to be fetched", dataType = "string", paramType = "query"),
            @ApiImplicitParam(name = "order", value = "asc|desc", dataType = "string", paramType = "query", defaultValue = "asc"),
            @ApiImplicitParam(name = "orderField", value = "The facet that it is going to be ordered", dataType = "string", paramType = "query")
    })
    @RequestMapping(path = "all", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<Browsing> getAllResources(@RequestParam(required = false) Map<String,Object> allRequestParams) {
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

    @ApiOperation(value = "Returns user's resources of a specific resource type.")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "keyword", value = "Keyword for search refine", dataType = "string", paramType = "query"),
            @ApiImplicitParam(name = "from", value = "From paging", dataType = "string", paramType = "query"),
            @ApiImplicitParam(name = "quantity", value = "Quantity of resources to be fetched", dataType = "string", paramType = "query"),
            @ApiImplicitParam(name = "order", value = "asc|desc", dataType = "string", paramType = "query", defaultValue = "asc"),
            @ApiImplicitParam(name = "orderField", value = "The facet that it is going to be ordered", dataType = "string", paramType = "query")
    })
    @PreAuthorize("isAuthenticated()")
    @RequestMapping(path = "my", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<Browsing> getMyResources(@RequestParam(required = false) Map<String,Object> allRequestParams) {
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

    @ResponseStatus(HttpStatus.FORBIDDEN)
    @ExceptionHandler(AccessDeniedException.class)
    @ResponseBody
    ServerError securityException(HttpServletRequest req, Exception ex) {
        return new ServerError(req.getRequestURL().toString(),ex);
    }
}
