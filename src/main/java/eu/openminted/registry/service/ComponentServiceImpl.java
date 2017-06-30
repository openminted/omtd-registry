package eu.openminted.registry.service;

import eu.openminted.registry.domain.Component;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service("componentService")
@Primary
public class ComponentServiceImpl extends AbstractGenericService<Component>{

    private static final List<String> FACETS;

    static {
        List<String> facets = new ArrayList<>();
        facets.add("language");
        facets.add("mediaType");
        facets.add("licence");
        facets.add("rights");
        facets.add("mimeType");
        facets.add("dataFormatSpecific");
        facets.add("componentType");
        facets.add("componentDistributionForm");
        facets.add("application");
        FACETS = Collections.unmodifiableList(facets);
    }

    public ComponentServiceImpl() {
        super(Component.class);
    }

    @Override
    public String getResourceType() {
        return "component";
    }

    @Override
    public List<String> getFacets() {
        return FACETS;
    }


}
