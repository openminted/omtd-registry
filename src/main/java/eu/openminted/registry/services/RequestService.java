package eu.openminted.registry.services;

import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.elasticsearch.index.query.BoolQueryBuilder;
import org.elasticsearch.index.query.QueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import eu.openminted.registry.core.domain.Occurencies;
import eu.openminted.registry.core.domain.Paging;
import eu.openminted.registry.core.domain.Resource;
import eu.openminted.registry.core.service.SearchService;
import eu.openminted.registry.core.service.ServiceException;
import eu.openminted.registry.domain.Browsing;
import eu.openminted.registry.domain.Component;
import eu.openminted.registry.domain.Corpus;
import eu.openminted.registry.domain.Facet;
import eu.openminted.registry.domain.Result;
import eu.openminted.registry.domain.Utils;
import eu.openminted.registry.domain.Value;

@Service("requestService")
public class RequestService {

	@Autowired
	SearchService searchService;
	

	private static Map<String, String> labels = new HashMap<>();
	private static String[] facets = new String[] { "language", "mediatype", "rights", "mimetype", "dataformatspecific",
			"licence", "resourcetype" };

	static {
		labels.put("language", "Language");
		labels.put("mediatype", "Media Type");
		labels.put("rights", "Rights");
		labels.put("mimetype", "Mime Type");
		labels.put("dataformatspecific", "Data format specific");
		labels.put("licence", "Licence");
		labels.put("resourcetype", "Resource Type");
	}

	public ResponseEntity<String> getResponseByFilters(String keyword, String[] resourceType, String[] language,
			String[] mediaType, String[] rights, String[] mimeType, String[] dataFormatSpecific, String[] license,
			int from, int to) {

		ResponseEntity<String> responseEntity = null;

		Result result = new Result();
		result.setComponents(new ArrayList<Component>());
		result.setCorpora(new ArrayList<Corpus>());

		int totalNumber = 0;
		String cqlQuery = "*";
		if (!keyword.equals("")) {
			cqlQuery = keyword;
		}
		for (int i = 0; i < resourceType.length; i++) {
			if (i == 0) {
				cqlQuery = cqlQuery.concat(" AND (");
			}
			if (i != resourceType.length - 1) {
				cqlQuery = cqlQuery.concat("resourceType any " + resourceType[i] + " OR ");
			} else {
				cqlQuery = cqlQuery.concat("resourceType any " + resourceType[i] + ")");
			}
		}
		for (int i = 0; i < language.length; i++) {
			if (i == 0) {
				cqlQuery = cqlQuery.concat(" AND (");
			}
			if (i != language.length - 1) {
				cqlQuery = cqlQuery.concat("language any " + language[i] + " OR ");
			} else {
				cqlQuery = cqlQuery.concat("language any " + language[i] + ")");
			}
		}
		for (int i = 0; i < mediaType.length; i++) {
			if (i == 0) {
				cqlQuery = cqlQuery.concat(" AND (");
			}
			if (i != mediaType.length - 1) {
				cqlQuery = cqlQuery.concat("mediaType any " + mediaType[i] + " OR ");
			} else {
				cqlQuery = cqlQuery.concat("mediaType any " + mediaType[i] + ")");
			}
		}
		for (int i = 0; i < rights.length; i++) {
			if (i == 0) {
				cqlQuery = cqlQuery.concat(" AND (");
			}
			if (i != rights.length - 1) {
				cqlQuery = cqlQuery.concat("rights any " + rights[i] + " OR ");
			} else {
				cqlQuery = cqlQuery.concat("rights any " + rights[i] + ")");
			}
		}
		for (int i = 0; i < mimeType.length; i++) {
			if (i == 0) {
				cqlQuery = cqlQuery.concat(" AND (");
			}
			if (i != mimeType.length - 1) {
				cqlQuery = cqlQuery.concat("mimeType any " + mimeType[i] + " OR ");
			} else {
				cqlQuery = cqlQuery.concat("mimeType any " + mimeType[i] + ")");
			}
		}
		for (int i = 0; i < dataFormatSpecific.length; i++) {
			if (i == 0) {
				cqlQuery = cqlQuery.concat(" AND (");
			}
			if (i != dataFormatSpecific.length - 1) {
				cqlQuery = cqlQuery.concat("dataFormatSpecific any " + dataFormatSpecific[i] + " OR ");
			} else {
				cqlQuery = cqlQuery.concat("dataFormatSpecific any " + dataFormatSpecific[i] + ")");
			}
		}
		for (int i = 0; i < license.length; i++) {
			if (i == 0) {
				cqlQuery = cqlQuery.concat(" AND (");
			}
			if (i != license.length - 1) {
				cqlQuery = cqlQuery.concat("licence any " + license[i] + " OR ");
			} else {
				cqlQuery = cqlQuery.concat("licence any " + license[i] + ")");
			}
		}

		Occurencies overall = new Occurencies();

		try {
			for (int j = 0; j < 2; j++) {
				String resourceTypeForSearch = "";
				if (j == 0) {
					resourceTypeForSearch = "component";
				} else if (j == 1) {
					resourceTypeForSearch = "corpora";
				} else if (j == 2) {
					resourceTypeForSearch = "lexical";
				} else {
					resourceTypeForSearch = "language";
				}
				Paging paging = null;
				int quantity = 10;
				if(to==-1){
					//quantity = 10
					to = from + 10;
				}else{
					quantity = to - from;
				}
				if (quantity % 2 != 0) {
					if (j == 0)
						paging = searchService.search(resourceTypeForSearch, cqlQuery, from, (quantity / 2) + 1, facets);
					else {
						paging = searchService.search(resourceTypeForSearch, cqlQuery, from, quantity / 2, facets);
					}
				} else {
					paging = searchService.search(resourceTypeForSearch, cqlQuery, from, quantity / 2, facets);
				}
				// Paging paging = searchService.search(resourceTypeForSearch,
				// cqlQuery, from, to/2, facets);

				if (j == 0) {
					ArrayList<Component> components = new ArrayList<Component>();
					for (int i = 0; i < 10 && i < paging.getResults().size(); i++) {
						Resource resource = (Resource) paging.getResults().get(i);
						components.add(Utils.serialize(resource, Component.class));
					}
					result.setComponents(components);
				} else if (j == 1) {
					ArrayList<Corpus> corpora = new ArrayList<Corpus>();
					for (int i = 0; i < paging.getResults().size(); i++) {
						Resource resource = (Resource) paging.getResults().get(i);
						corpora.add(Utils.serialize(resource,Corpus.class));
					}
					result.setCorpora(corpora);
				}

				totalNumber += paging.getTotal();

				if (j == 0) {
					overall = paging.getOccurencies();
				} else {
					for (Map.Entry<String, Map<String, Integer>> pair : paging.getOccurencies().getValues().entrySet()) {
						Map<String, Integer> subMap = pair.getValue(); // paging.getOccurencies().getValues().get(pair.getKey());

						for (Map.Entry<String, Integer> stringIntegerEntry : subMap.entrySet()) {
							Map.Entry pair2 = (Map.Entry) stringIntegerEntry;
							Map<String, Integer> subMap2 = overall.getValues().get(pair.getKey());

							if (subMap2.containsKey(pair2.getKey())) {
								subMap2.replace(pair2.getKey() + "",subMap2.get(pair2.getKey()) + subMap.get(pair2.getKey()));
							} else {
								subMap2.put(pair2.getKey() + "", subMap.get(pair2.getKey()));
							}
							overall.getValues().replace(pair.getKey() + "", subMap2);
						}
					}
				}
			}
		} catch (ServiceException e) {
			return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}

		List<Facet> facetsCollection = new ArrayList<Facet>();

		for (Map.Entry<String, Map<String, Integer>> pair : overall.getValues().entrySet()) {
			Facet singleFacet = new Facet();

			singleFacet.setField(pair.getKey() + "");
			singleFacet.setLabel(labels.get(pair.getKey()));

			List<Value> values = new ArrayList<Value>();
			Map<String, Integer> subMap = overall.getValues().get(pair.getKey());

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
		//TODO na gurnaw to swsto "to"
		Browsing browsing = new Browsing(totalNumber, from, to, result, facetsCollection);

		return new ResponseEntity<String>(Utils.objToJson(browsing), HttpStatus.OK);

	}
	
	
	public ResponseEntity<String> getResponseByFiltersElastic(String keyword, String[] resourceType, String[] language,
			String[] mediaType, String[] rights, String[] mimeType, String[] dataFormatSpecific, String[] license,
			int from, int to) {

		ResponseEntity<String> responseEntity = null;

		Result result = new Result();
		result.setComponents(new ArrayList<Component>());
		result.setCorpora(new ArrayList<Corpus>());

		BoolQueryBuilder qBuilder = new BoolQueryBuilder();
		
		
		int totalNumber = 0;
		String cqlQuery = "*";
		if (!keyword.equals("")) {
			cqlQuery = keyword;
		}
		for (int i = 0; i < resourceType.length; i++) {
			qBuilder.must(QueryBuilders.termQuery("resourceType", resourceType[i]));
		}
		for (int i = 0; i < language.length; i++) {
			qBuilder.must(QueryBuilders.termQuery("language", language[i]));
		}
		for (int i = 0; i < mediaType.length; i++) {
			qBuilder.must(QueryBuilders.termQuery("mediaType", mediaType[i]));
		}
		for (int i = 0; i < rights.length; i++) {
			qBuilder.must(QueryBuilders.termQuery("rights", rights[i]));
		}
		for (int i = 0; i < mimeType.length; i++) {
			qBuilder.must(QueryBuilders.termQuery("mimeType", mimeType[i]));
		}
		for (int i = 0; i < dataFormatSpecific.length; i++) {
			qBuilder.must(QueryBuilders.termQuery("dataFormatSpecific", dataFormatSpecific[i]));
		}
		for (int i = 0; i < license.length; i++) {
			qBuilder.must(QueryBuilders.termQuery("licence", license[i]));
		}
		qBuilder.queryName("*"); //<------------edw einai pou prepei na mpei to keyword MALLON
		Occurencies overall = new Occurencies();
		
		try {
				Paging paging = null;
				int quantity = 10;
				if(to==-1){
					//quantity = 10
					to = from + 10;
				}else{
					quantity = to - from;
				}
				
				paging = searchService.searchElastic("resourceTypes", qBuilder, from, quantity, facets);
					
				// Paging paging = searchService.search(resourceTypeForSearch,
				// cqlQuery, from, to/2, facets);
				if(paging!=null){
					for(int j=0;j<paging.getResults().size();j++){
						Resource resourceTemp = (Resource) paging.getResults().get(j);
						if(resourceTemp.getResourceType().equals("component")){
							ArrayList<Component> components = new ArrayList<Component>();
							for (int i = 0; i < 10 && i < paging.getResults().size(); i++) {
								Resource resource = (Resource) paging.getResults().get(i);
								components.add(Utils.serialize(resource, Component.class));
							}
							result.setComponents(components);
						}else if(resourceTemp.getResourceType().equals("corpus")){
							ArrayList<Corpus> corpora = new ArrayList<Corpus>();
							for (int i = 0; i < paging.getResults().size(); i++) {
								Resource resource = (Resource) paging.getResults().get(i);
								corpora.add(Utils.serialize(resource,Corpus.class));
							}
							result.setCorpora(corpora);
						}
					}
				}
				
				totalNumber += paging.getTotal();

				overall = paging.getOccurencies();
				
		} catch (ServiceException e) {
			return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		} catch (UnknownHostException e) {
			e.printStackTrace();
		}

		List<Facet> facetsCollection = new ArrayList<Facet>();

		for (Map.Entry<String, Map<String, Integer>> pair : overall.getValues().entrySet()) {
			Facet singleFacet = new Facet();

			singleFacet.setField(pair.getKey() + "");
			singleFacet.setLabel(labels.get(pair.getKey()));

			List<Value> values = new ArrayList<Value>();
			Map<String, Integer> subMap = overall.getValues().get(pair.getKey());

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
		//TODO na gurnaw to swsto "to"
		Browsing browsing = new Browsing(totalNumber, from, from + totalNumber, result, facetsCollection);

		return new ResponseEntity<String>(Utils.objToJson(browsing), HttpStatus.OK);

	}

}
