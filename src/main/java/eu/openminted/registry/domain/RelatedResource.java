package eu.openminted.registry.domain;

import java.util.List;

/**
 * Created by stefania on 9/5/16.
 */
public class RelatedResource {

    //one of the 2
    private List<Identifier<ResourceIdentifierSchema>> resourceIdentifiers;
    private List<String> resourceNames;

    public RelatedResource() {
    }

    public List<Identifier<ResourceIdentifierSchema>> getResourceIdentifiers() {
        return resourceIdentifiers;
    }

    public void setResourceIdentifiers(List<Identifier<ResourceIdentifierSchema>> resourceIdentifiers) {
        this.resourceIdentifiers = resourceIdentifiers;
    }

    public List<String> getResourceNames() {
        return resourceNames;
    }

    public void setResourceNames(List<String> resourceNames) {
        this.resourceNames = resourceNames;
    }
}
