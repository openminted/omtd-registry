package eu.openminted.registry.service;

import eu.openminted.registry.core.domain.Browsing;
import eu.openminted.registry.core.domain.Facet;
import eu.openminted.registry.core.domain.FacetFilter;
import eu.openminted.registry.core.domain.Value;
import eu.openminted.registry.core.service.AbstractGenericService;
import eu.openminted.registry.core.service.SearchService;
import eu.openminted.registry.core.service.ServiceException;
import eu.openminted.registry.domain.BaseMetadataRecord;
import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;
import javax.annotation.PostConstruct;
import java.io.IOException;
import java.util.*;

@Service("requestService")
public class RequestServiceImpl extends AbstractGenericService implements RequestService {

    @Autowired
    SearchService searchService;

    final private static Logger logger = Logger.getLogger(RequestServiceImpl.class);

    final private static String RESOURCE_ALIAS = "resourceTypes";

    final private static String[] MAPPING_FILES = {"languageId","regionId","scriptId","variantId","licence","mimeType"};

    private Map<String,Properties> mappings;

    public RequestServiceImpl() {
        super(BaseMetadataRecord.class);
    }

    @PostConstruct
    public void loadMappings() throws IOException {
        mappings = new HashMap<>();
        for(String file : MAPPING_FILES) {
            Properties properties = new Properties();
            String filename = "/eu/openminted/registry/maps/" + file + ".properties";
            org.springframework.core.io.Resource resource = new ClassPathResource(filename);
            properties.load(resource.getInputStream());
            mappings.put(file,properties);
        }

    }

    @SuppressWarnings("unchecked")
    public Browsing getResponseByFiltersElastic(FacetFilter filter) {
        filter.addFilter("public",true);
        filter.setBrowseBy(getBrowseBy());
        Browsing<BaseMetadataRecord> ret = getResults(filter);
        createLabels(ret);
        return ret;
    }

    @SuppressWarnings("unchecked")
    public Map<String,List<?>> getResourceGroupedElastic(FacetFilter filter, String category) throws ServiceException {
        filter.addFilter("public",true);
        return getResultsGrouped(filter,category);
    }

    @Override
    public String getResourceType() {
        return RESOURCE_ALIAS;
    }


    private String getLanguageLabel(String language) {
        String[] split = language.toUpperCase().split("-");
        System.out.println(Arrays.toString(split));
        StringBuilder label = new StringBuilder();
        String languageId = split.length > 0 ? split[0] : null;
        String scriptId = split.length > 1 ? split[1] : null;
        String regionId = split.length > 2 ? split[2] : null;
        String variantId = split.length > 3 ? split[3] : null;
        if(languageId != null) {
            label.append(mappings.get("languageId").getProperty(languageId));
        }
        if(scriptId != null && scriptId.length() == 4) {
            label.append("-");
            label.append(mappings.get("scriptId").getProperty(scriptId));
        } else {
            regionId = scriptId;
        }
        if(regionId != null && scriptId.length() == 2) {
            label.append("-");
            label.append(mappings.get("regionId").getProperty(regionId));
        } else {
            variantId = regionId;
        }
        if(variantId != null) {
            label.append("-");
            label.append(mappings.get("variantId").getProperty(variantId));
        }
        return label.length() != 0 ? label.toString() : language;
    }

    static private String sanitize(String value) {
        return value.replaceAll("[-!$%^&*()_+|~=`{}\\[\\]:\";'<>?,.\\/]","_").toUpperCase();
    }

    private void createLabels(Browsing<BaseMetadataRecord> browsing) {
        for (Facet facet : browsing.getFacets()) {
            System.out.println(facet.getField());
            for(Value value : facet.getValues()) {
                switch (facet.getField()) {
                    case "language" : value.setLabel(getLanguageLabel(value.getValue())); break;
                    case "mimeType" : value.setLabel(mappings.get("mimeType").getProperty(sanitize(value.getValue())));break;
                    case "licence" : value.setLabel(mappings.get("licence").getProperty(sanitize(value.getValue()))); break;
                    default : value.setLabel(StringUtils.capitalize(value.getValue()));
                }
            }
        }
    }

}
