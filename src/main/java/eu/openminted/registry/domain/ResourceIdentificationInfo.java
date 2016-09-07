package eu.openminted.registry.domain;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlValue;
import javax.xml.bind.annotation.adapters.XmlAdapter;
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
    private List<String> resourceNames;
    //required
    @XmlElementWrapper(name = "descriptions")
    @XmlElement(name = "description")
    private List<String> descriptions;
    @XmlElementWrapper(name = "resourceShortNames")
    @XmlElement(name = "resourceShortName")
    private List<String> resourceShortNames;
    //required
    @XmlJavaTypeAdapter(ResourceIdentifierAdapter.class)
    @XmlElementWrapper(name = "identifiers")
    @XmlElement(name="identifier")
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

class ResourceIdentifierAdapter extends XmlAdapter<ResourceIdentifierAdapter.ResIdentifier, Identifier<ResourceIdentifierSchema>> {
    @Override
    public eu.openminted.registry.domain.Identifier<ResourceIdentifierSchema> unmarshal(ResIdentifier v) throws Exception {
        return new eu.openminted.registry.domain.Identifier<>(
                ResourceIdentifierSchema.valueOf(v.schema.toUpperCase()),
                v.id, v.url);
    }

    @Override
    public ResIdentifier marshal(eu.openminted.registry.domain.Identifier<ResourceIdentifierSchema> v) throws Exception {
        return new ResIdentifier(v.getId(), v.getSchema().getValue(), v.getUrl());
    }

    public static class ResIdentifier {
        @XmlValue
        private String id;
        @XmlAttribute(name="resourceIdentifierSchemeName")
        private String schema;
        @XmlAttribute(name="schemeURI")
        private String url;

        public ResIdentifier() {
        }

        public ResIdentifier(String id, String schema, String url) {
            this.id = id;
            this.schema = schema;
            this.url = url;
        }
    }
}