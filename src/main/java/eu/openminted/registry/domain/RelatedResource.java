package eu.openminted.registry.domain;

import javax.xml.bind.annotation.*;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import java.util.List;

/**
 * Created by stefania on 9/5/16.
 */
@XmlAccessorType(XmlAccessType.FIELD)
public class RelatedResource {

    //one of the 2
    @XmlJavaTypeAdapter(ResourceIdentifierAdapter.class)
    @XmlElementWrapper(name = "resourceIdentifiers")
    @XmlElement(name="resourceIdentifier")
    private List<Identifier<ResourceIdentifierSchema>> resourceIdentifiers;
    
    @XmlElementWrapper(name="resourceNames")
    @XmlElement(name="resourceName")
    private List<LangAttributeField> resourceNames;

    public RelatedResource() {
    }

    public List<Identifier<ResourceIdentifierSchema>> getResourceIdentifiers() {
        return resourceIdentifiers;
    }

    public void setResourceIdentifiers(List<Identifier<ResourceIdentifierSchema>> resourceIdentifiers) {
        this.resourceIdentifiers = resourceIdentifiers;
    }

    public List<LangAttributeField> getResourceNames() {
        return resourceNames;
    }

    public void setResourceNames(List<LangAttributeField> resourceNames) {
        this.resourceNames = resourceNames;
    }
}