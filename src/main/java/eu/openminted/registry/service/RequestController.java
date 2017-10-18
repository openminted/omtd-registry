package eu.openminted.registry.service;

import eu.openminted.registry.core.domain.Browsing;
import eu.openminted.registry.core.domain.FacetFilter;
import eu.openminted.registry.core.service.ResourceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class RequestController {

    @Autowired
    ResourceService resourceService;

    @Autowired
    RequestService requestService;


    @RequestMapping(value = "/request", method = RequestMethod.GET, produces = "application/json; charset=utf-8")
    public ResponseEntity<Browsing> getResourceTypeByFilters(@RequestParam Map<String,Object> allRequestParams) {

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

    @RequestMapping(value = "/request/grouped", method = RequestMethod.GET, produces = "application/json; charset=utf-8")
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
