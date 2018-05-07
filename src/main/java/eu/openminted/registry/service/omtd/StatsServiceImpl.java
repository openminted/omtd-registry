package eu.openminted.registry.service.omtd;

import eu.openminted.registry.core.domain.FacetFilter;
import eu.openminted.registry.core.service.SearchService;
import eu.openminted.registry.domain.Totals;
import eu.openminted.registry.service.StatsService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;

@Service("statsService")
public class StatsServiceImpl implements StatsService{

    private Logger logger = LogManager.getLogger(StatsServiceImpl.class);

    @Value("${content.host}")
    private String contentHost;

    @Autowired
    SearchService searchService;

    @Autowired
    RestTemplate restTemplate;

    @Override
//    @Cacheable("totals")
    public Totals totals() throws IOException {
        int publications = 0;
        int components = 0;
        int applications = 0;

        FacetFilter filter = new FacetFilter("","application",0,1,new HashMap<>(), Arrays.asList(""), null);

        applications = searchService.search(filter).getTotal();

        filter.setResourceType("component");
        components = searchService.search(filter).getTotal();

        JSONObject responseJson = new JSONObject(restTemplate.postForEntity(contentHost+"content/browse/","{\"params\":{}}",null));
        publications = Integer.parseInt(responseJson.get("totalHits").toString());

        return new Totals(publications,components,applications);
    }

}
