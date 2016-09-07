package eu.openminted.registry.domain;

import java.util.List;

/**
 * Created by stefania on 9/5/16.
 */
public class ResourceIdentificationInfo {

    //required
    private List<String> resourceNames;
    //required
    private List<String> descriptions;
    private List<String> resourceShortNames;
    //required
    private List<Identifier<ResourceIdentifierSchema>> resourceIdentifiers;

    public ResourceIdentificationInfo() {
    }

    public ResourceIdentificationInfo(List<String> resourceNames, List<String> descriptions, List<String> resourceShortNames,
                                      List<Identifier<ResourceIdentifierSchema>> resourceIdentifiers) {
        this.resourceNames = resourceNames;
        this.descriptions = descriptions;
        this.resourceShortNames = resourceShortNames;
        this.resourceIdentifiers = resourceIdentifiers;
    }

    public List<String> getResourceNames() {
        return resourceNames;
    }

    public void setResourceNames(List<String> resourceNames) {
        this.resourceNames = resourceNames;
    }

    public List<String> getDescriptions() {
        return descriptions;
    }

    public void setDescriptions(List<String> descriptions) {
        this.descriptions = descriptions;
    }

    public List<String> getResourceShortNames() {
        return resourceShortNames;
    }

    public void setResourceShortNames(List<String> resourceShortNames) {
        this.resourceShortNames = resourceShortNames;
    }

    public List<Identifier<ResourceIdentifierSchema>> getResourceIdentifiers() {
        return resourceIdentifiers;
    }

    public void setResourceIdentifiers(List<Identifier<ResourceIdentifierSchema>> resourceIdentifiers) {
        this.resourceIdentifiers = resourceIdentifiers;
    }
}
