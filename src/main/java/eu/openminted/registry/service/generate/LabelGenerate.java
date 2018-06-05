package eu.openminted.registry.service.generate;

import eu.openminted.registry.core.domain.Browsing;
import eu.openminted.registry.core.domain.Facet;
import eu.openminted.registry.core.domain.Value;
import eu.openminted.registry.domain.BaseMetadataRecord;
import org.apache.commons.lang.StringUtils;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

@Component
public class LabelGenerate {

    final private static String[] MAPPING_FILES = {"languageId","regionId","scriptId","variantId","licence","ontology"};

    private Map<String,Properties> mappings;

    LabelGenerate() throws IOException {
        mappings = new HashMap<>();
        for(String file : MAPPING_FILES) {
            Properties properties = new Properties();
            String filename = "/eu/openminted/registry/maps/" + file + ".properties";
            org.springframework.core.io.Resource resource = new ClassPathResource(filename);
            properties.load(resource.getInputStream());
            mappings.put(file,properties);
        }
    }

    private String getLanguageLabel(String language) {
        String[] split = language.toUpperCase().split("-");
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
        value = value.replaceAll("([a-z])([A-Z])","$1_$2");
        return value.replaceAll("[-!$%^&*()_+|~=`{}\\[\\]:\";'<>?,./]","_").toUpperCase();
    }

    static private String capitalize(String value) {
        if(StringUtils.isAllUpperCase(value)) {
            return value;
        } else {
            return StringUtils.capitalize(value.replaceAll("(.)([A-Z])","$1 $2"));
        }
    }

    public void createLabels(Browsing<BaseMetadataRecord> browsing) {
        for (Facet facet : browsing.getFacets()) {
            for(Value value : facet.getValues()) {
                switch (facet.getField()) {
                    case "language" : value.setLabel(getLanguageLabel(value.getValue())); break;
                    case "licence" : value.setLabel(mappings.get("licence").getProperty(sanitize(value.getValue()))); break;
                    case "function" :
                    case "annotationType" :
                    case "dataFormat" : value.setLabel(mappings.get("ontology").getProperty(sanitize(value.getValue()))); break;
                    default : value.setLabel(capitalize(value.getValue()));
                }
            }
        }
    }
}