package eu.openminted.registry.service;

import eu.openminted.registry.domain.LanguageDescription;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by stefanos on 13/1/2017.
 */
@Service("languageService")
@Primary
public class LanguageServiceImpl extends AbstractGenericService<LanguageDescription>{

    private static final List<String> FACETS;

    static {
        List<String> facets = new ArrayList<>();
        facets.add("language");
        facets.add("mediaType");
        facets.add("licence");
        facets.add("rights");
        facets.add("mimeType");
        facets.add("dataFormatSpecific");
        FACETS = Collections.unmodifiableList(facets);
    }

    public LanguageServiceImpl() {
        super(LanguageDescription.class);
    }

    @Override
    public String getResourceType() {
        return "language";
    }

    @Override
    public List<String> getFacets() {
        return FACETS;
    }
}
