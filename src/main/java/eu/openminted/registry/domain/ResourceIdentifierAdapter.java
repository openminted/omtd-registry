package eu.openminted.registry.domain;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlValue;
import javax.xml.bind.annotation.adapters.XmlAdapter;

/**
 * Created by antleb on 8/9/2016.
 */
class ResourceIdentifierAdapter extends XmlAdapter<ResourceIdentifierAdapter.ResIdentifier, Identifier<ResourceIdentifierSchema>> {
    @Override
    public Identifier<ResourceIdentifierSchema> unmarshal(ResIdentifier v) throws Exception {
        return new Identifier<>(
                ResourceIdentifierSchema.forValue(v.schema),
                v.id, v.url);
    }

    @Override
    public ResIdentifier marshal(Identifier<ResourceIdentifierSchema> v) throws Exception {
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
