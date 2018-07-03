package eu.openminted.registry.service.hotfix;

import eu.openminted.registry.core.configuration.ElasticConfiguration;
import eu.openminted.registry.core.domain.*;
import eu.openminted.registry.core.service.*;
import org.apache.commons.beanutils.PropertyUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.elasticsearch.action.search.*;
import org.elasticsearch.client.Client;
import org.elasticsearch.index.query.BoolQueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.aggregations.AggregationBuilders;
import org.elasticsearch.search.aggregations.bucket.terms.Terms;
import org.elasticsearch.search.sort.SortOrder;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.*;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

abstract public class AbstractPublicUsersGenericService<T> extends AbstractGenericService<T> {

    final private static Logger logger = LogManager.getLogger(AbstractPublicUsersGenericService.class);
    @Autowired
    ResourceTypeService resourceTypeService;
    @Autowired
    private ElasticConfiguration elastic;
    private Map<String, ResourceType> resourceTypeCache = new HashMap<>();

    public AbstractPublicUsersGenericService(Class<T> typeParameterClass) {
        super(typeParameterClass);
    }

    @Deprecated
    private static BoolQueryBuilder createQueryBuilder(FacetFilter filter, String user) {
        BoolQueryBuilder qBuilder = new BoolQueryBuilder();
        if (!filter.getKeyword().equals("")) {
            qBuilder.must(QueryBuilders.matchQuery("searchableArea", filter.getKeyword()));
        } else {
            qBuilder.must(QueryBuilders.matchAllQuery());
        }
        if (!user.equals("ROLE_ADMIN")) {
            BoolQueryBuilder userQueryBuilder = new BoolQueryBuilder();
            userQueryBuilder.should(QueryBuilders.termQuery("public", true));
            userQueryBuilder.should(QueryBuilders.termQuery("personIdentifier", user));
            qBuilder.must(userQueryBuilder);
        }
        for (Map.Entry<String, Object> filterSet : filter.getFilter().entrySet()) {
            qBuilder.must(QueryBuilders.termQuery(filterSet.getKey(), filterSet.getValue()));
        }
        return qBuilder;
    }

    @Deprecated
    public Browsing getResponseByFiltersAndUserElastic(FacetFilter filter, String user) {
        Client client = elastic.client();
        filter.setResourceType(getResourceType());
        filter.setBrowseBy(getBrowseBy());
        logger.info("Personalized logger for " + user);
        Paging paging;
        int quantity = filter.getQuantity();
        BoolQueryBuilder qBuilder = createQueryBuilder(filter, user);
        logger.trace(qBuilder.toString());
        SearchRequestBuilder search = client.prepareSearch(filter.getResourceType()).
                setSearchType(SearchType.DFS_QUERY_THEN_FETCH)
                .setQuery(qBuilder)
                .setFrom(filter.getFrom()).setSize(quantity).setExplain(false);

        if (filter.getOrderBy() != null) {
            for (Map.Entry<String, Object> order : filter.getOrderBy().entrySet()) {
                Map op = (Map) order.getValue();
                search.addSort(order.getKey(), SortOrder.fromString(op.get("order").toString()));
            }
        }

        for (String browseBy : filter.getBrowseBy()) {
            search.addAggregation(AggregationBuilders.terms("by_" + browseBy).field(browseBy));
        }
        SearchResponse response = search.execute().actionGet();

        List<Resource> results = new ArrayList<>();
        quantity = Math.min(quantity, (int) response.getHits().getHits().length);
        for (int i = 0; i < quantity; ++i) {
            Resource res = new Resource();
            for (String value : Arrays.asList("id", "resourceType", "payload", "payloadFormat", "version")) {
                try {
                    if (!value.equals("resourceType"))
                        PropertyUtils.setProperty(res, value, response.getHits().getAt(i).getSource().get(value)
                                .toString());
                    else {
                        String resourceType = response.getHits().getAt(i).getSource().get(value).toString();
                        if (resourceTypeCache.get(resourceType) == null)
                            resourceTypeCache.put(resourceType, resourceTypeService.getResourceType(resourceType));
                        res.setResourceType(resourceTypeCache.get(resourceType));
                    }
                } catch (Exception e) {
                    break;
                }
            }
            results.add(res);
        }

        Map<String, Map<String, Integer>> values = new HashMap<>();
        Occurrences occurrences = new Occurrences();
        if (!filter.getBrowseBy().isEmpty()) {

            for (String browseBy : filter.getBrowseBy()) {
                Map<String, Integer> subMap = new HashMap<>();
                Terms terms = response.getAggregations().get("by_" + browseBy);
                for (Terms.Bucket bucket : terms.getBuckets()) {
                    subMap.put(bucket.getKeyAsString(), Integer.parseInt(bucket.getDocCount() + ""));
                }
                values.put(browseBy, subMap);
            }
            occurrences.setValues(values);

        }
        if (response.getHits().getTotalHits() == 0) {
            paging = new Paging(0, 0, 0, new ArrayList<>(), new Occurrences());
        } else {
            if (filter.getQuantity() == 0) {
                filter.setQuantity(filter.getFrom() + quantity);
            }

            paging = new Paging((int) response.getHits().getTotalHits(), filter.getFrom(),
                    filter.getFrom() + results.size(), results, occurrences);
        }

        return getTempResults(paging, filter);
    }

    @Deprecated
    protected Browsing<T> getTempResults(Paging paging, FacetFilter filter) {
        List<T> result = new ArrayList<>();
        List<Future<T>> futureResults;
        Browsing<T> browsing;
        Occurrences overall;
        List<Facet> facetsCollection;
        try {
            futureResults = new ArrayList<>(paging.getResults().size());
            for (Object res : paging.getResults()) {
                Resource resource = (Resource) res;
                futureResults.add(parserPool.deserialize(resource, typeParameterClass));
            }
            overall = paging.getOccurrences();
            facetsCollection = createFacetCollection(overall);
            for (Future<T> res : futureResults) {
                result.add(res.get());
            }
        } catch (InterruptedException | ExecutionException e) {
            logger.fatal(e);
            e.printStackTrace();
            throw new ServiceException(e);
        }
        browsing = new Browsing<>(paging.getTotal(), filter.getFrom(), filter.getFrom() + result.size(), result,
                facetsCollection);
        return browsing;
    }

}
