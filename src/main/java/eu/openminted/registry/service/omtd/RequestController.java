package eu.openminted.registry.service.omtd;

import eu.openminted.registry.core.domain.Browsing;
import eu.openminted.registry.core.domain.FacetFilter;
import eu.openminted.registry.core.service.ResourceService;
import eu.openminted.registry.service.RequestService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import springfox.documentation.service.MediaTypes;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@Api(description = "Search service that searches all OMTD related indices.")
public class RequestController {

    @Autowired
    ResourceService resourceService;

    @Autowired
    RequestService requestService;

    @ApiOperation(value = "Returns all OMTD resources.")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "keyword", value = "Keyword for search refine", dataType = "string", paramType = "query"),
            @ApiImplicitParam(name = "from", value = "From paging", dataType = "string", paramType = "query"),
            @ApiImplicitParam(name = "quantity", value = "Quantity of resources to be fetched", dataType = "string", paramType = "query"),
            @ApiImplicitParam(name = "order", value = "asc|desc", dataType = "string", paramType = "query", defaultValue = "asc"),
            @ApiImplicitParam(name = "orderField", value = "The facet that it is going to be ordered", dataType = "string", paramType = "query")
    })
    @RequestMapping(value = "/request", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<Browsing> getResourceTypeByFilters(@RequestParam(required = false) Map<String,Object> allRequestParams) {

        FacetFilter facetFilter = new FacetFilter();
        facetFilter.setKeyword(allRequestParams.get("keyword") != null ? (String)allRequestParams.remove("keyword") : "");
        facetFilter.setFrom(allRequestParams.get("from") != null ? Integer.parseInt((String)allRequestParams.remove("from")) : 0);
        facetFilter.setQuantity(allRequestParams.get("quantity") != null ? Integer.parseInt((String)allRequestParams.remove("quantity")) : 10);
        facetFilter.setFilter(allRequestParams);
        Map<String,Object> sort = new HashMap<>();
        Map<String,Object> order = new HashMap<>();
        String orderDirection = allRequestParams.get("order") != null ? (String)allRequestParams.remove("order") : "asc";
        String orderField = allRequestParams.get("orderField") != null ? (String)allRequestParams.remove("orderField") : null;
        if (orderField != null) {
            order.put("order",orderDirection);
            sort.put(orderField, order);
            facetFilter.setOrderBy(sort);
        }
        Browsing browsing = requestService.getResponseByFiltersElastic(facetFilter);
        return new ResponseEntity<>(browsing, HttpStatus.OK);

    }

    @ApiOperation(value = "Returns all OMTD resources grouped by a facet.")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "keyword", value = "Keyword for search refine", dataType = "string", paramType = "query"),
            @ApiImplicitParam(name = "from", value = "From paging", dataType = "string", paramType = "query"),
            @ApiImplicitParam(name = "quantity", value = "Quantity of resources to be fetched", dataType = "string", paramType = "query"),
            @ApiImplicitParam(name = "group", value = "The facet that is going to be used as a group.", dataType = "string", paramType = "query"),
    })
    @RequestMapping(value = "/request/grouped", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<Map<String,List<?>>> getResourceTypeByFiltersGrouped(@RequestParam Map<String,Object> allRequestParams) {

        FacetFilter facetFilter = new FacetFilter();
        facetFilter.setKeyword(allRequestParams.get("keyword") != null ? (String)allRequestParams.remove("keyword") : "");
        facetFilter.setFrom(allRequestParams.get("from") != null ? Integer.parseInt((String)allRequestParams.remove("from")) : 0);
        facetFilter.setQuantity(allRequestParams.get("quantity") != null ? Integer.parseInt((String)allRequestParams.remove("quantity")) : 10);
        String groupBy = allRequestParams.get("group") != null ? (String)allRequestParams.remove("group") : "";
        facetFilter.setFilter(allRequestParams);
        Map<String,List<?>> browsing = requestService.getResourceGroupedElastic(facetFilter,groupBy);
        return new ResponseEntity<>(browsing, HttpStatus.OK);

    }

}
