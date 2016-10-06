package eu.openminted.registry.domain;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlValue;
import javax.xml.bind.annotation.adapters.XmlAdapter;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

/**
 * Created by stefania on 9/5/16.
 */
@XmlAccessorType(XmlAccessType.FIELD)
public class DomainInfo {

    //required
    @XmlJavaTypeAdapter(ClassificationSchemeIdentifierAdapter.class)
    private Identifier<ClassificationScheme> domain;
    private SizeInfo sizePerDomain;

    public DomainInfo() {
    }

    public DomainInfo(Identifier<ClassificationScheme> domain) {
        this.domain = domain;
    }

    public DomainInfo(Identifier<ClassificationScheme> domain, SizeInfo sizePerDomain) {
        this.domain = domain;
        this.sizePerDomain = sizePerDomain;
    }

    public Identifier<ClassificationScheme> getDomain() {
        return domain;
    }

    public void setDomain(Identifier<ClassificationScheme> domain) {
        this.domain = domain;
    }

    public SizeInfo getSizePerDomain() {
        return sizePerDomain;
    }

    public void setSizePerDomain(SizeInfo sizePerDomain) {
        this.sizePerDomain = sizePerDomain;
    }
}

class ClassificationSchemeIdentifierAdapter extends XmlAdapter<ClassificationSchemeIdentifierAdapter.ClassificationSchemeIdentifier, Identifier<ClassificationScheme>> {
    @Override
    public Identifier<ClassificationScheme> unmarshal(ClassificationSchemeIdentifier v) throws Exception {
        return new Identifier<>(ClassificationScheme.forValue(v.schema), v.id, v.url);
    }

    @Override
    public ClassificationSchemeIdentifier marshal(Identifier<ClassificationScheme> v) throws Exception {
        return (v==null) ? null : new ClassificationSchemeIdentifier(v.getId(), v.getSchema().getValue(), v.getUrl());
    }

    public static class ClassificationSchemeIdentifier {
        @XmlValue
        private String id;
        @XmlAttribute(name="classificationSchemeName")
        private String schema;
        @XmlAttribute(name="schemeURI")
        private String url;

        public ClassificationSchemeIdentifier() {
        }

        public ClassificationSchemeIdentifier(String id, String schema, String url) {
            this.id = id;
            this.schema = schema;
            this.url = url;
        }
    }
}