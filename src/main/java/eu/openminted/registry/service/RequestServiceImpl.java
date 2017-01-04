package eu.openminted.registry.service;

import com.google.common.collect.Lists;
import eu.openminted.registry.core.domain.Occurencies;
import eu.openminted.registry.core.domain.Paging;
import eu.openminted.registry.core.domain.Resource;
import eu.openminted.registry.core.service.SearchService;
import eu.openminted.registry.core.service.ServiceException;
import eu.openminted.registry.domain.*;
import org.apache.log4j.Logger;
import org.elasticsearch.index.query.BoolQueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.net.UnknownHostException;
import java.util.*;

@Service("requestService")
public class RequestServiceImpl implements RequestService {

    @Autowired
    SearchService searchService;

    private Logger logger = Logger.getLogger(RequestServiceImpl.class);

    private static Map<String, String> labels = new LinkedHashMap<>();
    private static String[] facets = new String[]{"resourceType","language", "mediatype", "rights", "mimetype", "dataformatspecific",
            "license"};

    static {
        labels.put("resourceType", "Resource Type");
        labels.put("license", "License");
        labels.put("language", "Language");
        labels.put("mediatype", "Media Type");
        labels.put("rights", "Rights");
        labels.put("mimetype", "Mime Type");
        labels.put("dataformatspecific", "Data format specific");
    }

    public ResponseEntity<String> getResponseByFiltersElastic(String keyword, String[] resourceType, String[] language,
                                                              String[] mediaType, String[] rights, String[] mimeType,
                                                              String[] dataFormatSpecific, String[] license,
                                                              int from, int to) {

        ResponseEntity<String> responseEntity = null;

        Result result = new Result();
        result.setComponents(new ArrayList<>());
        result.setCorpora(new ArrayList<>());

        BoolQueryBuilder qBuilder = new BoolQueryBuilder();


        int totalNumber = 0;
        for (int i = 0; i < resourceType.length; i++) {
            qBuilder.must(QueryBuilders.termQuery("resourceType", resourceType[i]));
        }
        for (int i = 0; i < language.length; i++) {
            qBuilder.must(QueryBuilders.termQuery("language", language[i]));
        }
        for (int i = 0; i < mediaType.length; i++) {
            qBuilder.must(QueryBuilders.termQuery("mediatype", mediaType[i]));
        }
        for (int i = 0; i < rights.length; i++) {
            qBuilder.must(QueryBuilders.termQuery("rights", rights[i]));
        }
        for (int i = 0; i < mimeType.length; i++) {
            qBuilder.must(QueryBuilders.termQuery("mimetype", mimeType[i]));
        }
        for (int i = 0; i < dataFormatSpecific.length; i++) {
            qBuilder.must(QueryBuilders.termQuery("dataFormatSpecific", dataFormatSpecific[i]));
        }
        for (int i = 0; i < license.length; i++) {
            qBuilder.must(QueryBuilders.termQuery("license", license[i]));
        }
        if (!keyword.equals("")) {
            qBuilder.must(QueryBuilders.matchQuery("payload", keyword));
        } else {
            qBuilder.must(QueryBuilders.matchAllQuery());
        }
        Occurencies overall = new Occurencies();

        try {
            Paging paging = null;
            int quantity = 10;
            if (to == -1) {
                //quantity = 10
                to = from + 10;
            } else {
                quantity = to - from;
            }

            paging = searchService.search("resourceTypes", qBuilder, from, quantity, facets);

            if (paging != null) {
                List<Order<Corpus>> corpora = new ArrayList<>();
                List<Order<Component>> components = new ArrayList<>();
                int pos = 0;
                for(Object resourceObj :  paging.getResults()) {
                    Resource resource = (Resource) resourceObj;
                    if("corpus".equals(resource.getResourceType())) {
                        Corpus temp = Utils.serialize(resource, Corpus.class);
                        corpora.add(new Order<>(pos,temp));
                    } else if ("component".equals(resource.getResourceType())) {
                        Component temp = Utils.serialize(resource, Component.class);
                        components.add(new Order<>(pos,temp));
                    }
                    pos++;
                }
                result.setComponents(components);
                result.setCorpora(corpora);
            }

            totalNumber += paging.getTotal();

            overall = paging.getOccurencies();

        } catch (ServiceException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }

        List<Facet> facetsCollection = new ArrayList<>();

        for (String label : labels.keySet()) {
        //for (Map.Entry<String, Map<String, Integer>> pair : overall.getValues().entrySet()) {
            Facet singleFacet = new Facet();

            singleFacet.setField(label + "");
            singleFacet.setLabel(labels.get(label));

            List<Value> values = new ArrayList<>();
            Map<String, Integer> subMap = overall.getValues().get(label);
            for (Map.Entry<String, Integer> pair2 : subMap.entrySet()) {
                Value value = new Value();

                value.setValue(pair2.getKey() + "");
                value.setCount(Integer.parseInt(pair2.getValue() + ""));

                values.add(value);
            }

            Collections.sort(values);
            Collections.reverse(values);
            singleFacet.setValues(values);

            if (singleFacet.getValues().size() > 0)
                facetsCollection.add(singleFacet);
        }

        Browsing browsing = new Browsing(totalNumber, from, from + result.getTotal(), result, facetsCollection);
        return new ResponseEntity<>(Utils.objToJson(browsing), HttpStatus.OK);

    }

}
