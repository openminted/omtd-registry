package eu.openminted.registry.domain;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import java.util.List;

/**
 * Created by stefania on 9/5/16.
 */
@XmlAccessorType(XmlAccessType.FIELD)
public class ResourceIdentificationInfo {

    //required
    @XmlElementWrapper(name = "resourceNames")
    @XmlElement(name = "resourceName")
    private List<LangAttributeField> resourceNames;
    //required
    @XmlElementWrapper(name = "descriptions")
    @XmlElement(name = "description")
    private List<LangAttributeField> descriptions;
    @XmlElementWrapper(name = "resourceShortNames")
    @XmlElement(name = "resourceShortName")
    private List<LangAttributeField> resourceShortNames;
    //required
    @XmlJavaTypeAdapter(ResourceIdentifierAdapter.class)
    @XmlElementWrapper(name = "identifiers")
    @XmlElement(name="identifier")
    private List<Identifier<ResourceIdentifierSchema>> resourceIdentifiers;

    public ResourceIdentificationInfo() {
    }

    public ResourceIdentificationInfo(List<LangAttributeField> resourceNames, List<LangAttributeField> descriptions, List<LangAttributeField> resourceShortNames,
                                      List<Identifier<ResourceIdentifierSchema>> resourceIdentifiers) {
        this.resourceNames = resourceNames;
        this.descriptions = descriptions;
        this.resourceShortNames = resourceShortNames;
        this.resourceIdentifiers = resourceIdentifiers;
    }

    public List<LangAttributeField> getResourceNames() {
        return resourceNames;
    }

    public void setResourceNames(List<LangAttributeField> resourceNames) {
        this.resourceNames = resourceNames;
    }

    public List<LangAttributeField> getDescriptions() {
        return descriptions;
    }

    public void setDescriptions(List<LangAttributeField> descriptions) {
        this.descriptions = descriptions;
    }

    public List<LangAttributeField> getResourceShortNames() {
        return resourceShortNames;
    }

    public void setResourceShortNames(List<LangAttributeField> resourceShortNames) {
        this.resourceShortNames = resourceShortNames;
    }

    public List<Identifier<ResourceIdentifierSchema>> getResourceIdentifiers() {
        return resourceIdentifiers;
    }

    public void setResourceIdentifiers(List<Identifier<ResourceIdentifierSchema>> resourceIdentifiers) {
        this.resourceIdentifiers = resourceIdentifiers;
    }
}

