package eu.openminted.registry.service.omtd;

import eu.openminted.registry.core.domain.FacetFilter;
import eu.openminted.registry.core.service.SearchService;
import eu.openminted.registry.core.service.ServiceException;
import eu.openminted.registry.domain.Totals;
import eu.openminted.registry.service.StatsService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.http.*;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpServerErrorException;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;

@Service("statsService")
public class StatsServiceImpl implements StatsService {

    private final String redis_prefix = "totals:id:";
    @Autowired
    SearchService searchService;
    @Autowired
    RestTemplate restTemplate;

    private Logger logger = LogManager.getLogger(StatsServiceImpl.class);

    @Value("${content.host}")
    private String contentHost;

    @Autowired
    private RedisTemplate<String, Totals> template;

    @Override
    public Totals totals() throws IOException {
        Totals totals = getContent();
        if (totals != null)
            return totals;


        int publications = 0;
        int components_public = 0;
        int applications_public = 0;
        int components_private = 0;
        int applications_private = 0;

        FacetFilter filter = new FacetFilter("", "application", 0, 10000, new HashMap<>(), Arrays.asList(""), null);
        filter.addFilter("public",true);

        applications_public = searchService.search(filter).getTotal();

        filter.getFilter().replace("public",false);

        applications_private = searchService.search(filter).getTotal();


        filter.setResourceType("component");
        components_private = searchService.search(filter).getTotal();


        filter.getFilter().replace("public",true);

        components_public = searchService.search(filter).getTotal();


        try {

            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.APPLICATION_JSON);
            HttpEntity<String> entity = new HttpEntity<>("{\"params\":{}}", headers);

            JSONObject responseJson = new JSONObject(restTemplate.postForEntity(contentHost + "content/browse/",
                    entity, String.class).getBody());
            publications = Integer.parseInt(responseJson.get("totalHits").toString());
            Totals toReturn = new Totals(publications, components_public, applications_public, components_private, applications_private);
            addContent(toReturn);

            return toReturn;
        } catch (HttpServerErrorException ex) {
            logger.error("Request on " + contentHost + " failed", ex);
            throw new ServiceException(ex.getMessage());
        }

    }

    @Scheduled(fixedDelay = 5*60*1000)//5mins
    @Override
    public void scheduled(){
        logger.info("Checking for totals");
        try {
            totals();
        } catch (IOException e) {
            logger.warn("Failed to execute scheduled task for totals",e);
        }
    }


    private void addContent(Totals totals) {
        String key = redis_prefix + "stats";
        if (!template.hasKey(key)) {
            template.opsForList().leftPush(key, totals);
            template.expire(key, 10, TimeUnit.MINUTES);
        }

    }


    private Totals getContent() {
        String key = redis_prefix + "stats";
        if (template.hasKey(key)) {
            Totals totals = template.opsForList().rightPop(key);
            template.opsForList().leftPush(key, totals);
            return totals;
        } else {
            return null;
        }
    }

}
