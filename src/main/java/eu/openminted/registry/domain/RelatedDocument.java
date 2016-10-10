package eu.openminted.registry.domain;

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
public class RelatedDocument {

    enum PublicationIdentifierSchema implements IdentifierSchema {

        DOI("doi"),
        HDL("hdl"),
        ARK("ark"),
        ARXIV("arXiv"),
        BIBCODE("bibcode"),
        EAN13("ean13"),
        EISSN("eissn"),
        ISBN("isbn"),
        ISSN("issn"),
        ISTC("istc"),
        LISSN("lissn"),
        LSID("lsid"),
        PURL("purl"),
        UPC("upc"),
        URL("url"),
        URN("urn"),
        FCT("fct"),
        OAI("oai"),
        PMC("pmc"),
        PMID("pmid"),
        OTHER("other");

        private String value;

        PublicationIdentifierSchema(String value) {
            this.value = value;
        }

        @Override
        public String getValue() {
            return value;
        }

        public static PublicationIdentifierSchema forValue(String value) {
            for (PublicationIdentifierSchema ut: values()) {
                if (ut.getValue().equals(value))
                    return ut;
            }

            return null;
        }
    }

    //one of the 2
    private String documentUnstructured;
    @XmlElementWrapper(name = "publicationIdentifiers")
    @XmlElement(name = "publicationIdentifier")
    @XmlJavaTypeAdapter(PublicationIdentifierSchemaAdapter.class)
    private List<Identifier<PublicationIdentifierSchema>> publicationIdentifiers;

    public RelatedDocument() {
    }

    public RelatedDocument(String documentUnstructured) {
        this.documentUnstructured = documentUnstructured;
    }

    public RelatedDocument(List<Identifier<PublicationIdentifierSchema>> publicationIdentifiers) {
        this.publicationIdentifiers = publicationIdentifiers;
    }

    public String getDocumentUnstructured() {
        return documentUnstructured;
    }

    public void setDocumentUnstructured(String documentUnstructured) {
        this.documentUnstructured = documentUnstructured;
    }

    public List<Identifier<PublicationIdentifierSchema>> getPublicationIdentifiers() {
        return publicationIdentifiers;
    }

    public void setPublicationIdentifiers(List<Identifier<PublicationIdentifierSchema>> publicationIdentifiers) {
        this.publicationIdentifiers = publicationIdentifiers;
    }
}

class PublicationIdentifierSchemaAdapter extends XmlAdapter<PublicationIdentifierSchemaAdapter.SIPdentifier, Identifier<RelatedDocument.PublicationIdentifierSchema>> {
    @Override
    public Identifier<RelatedDocument.PublicationIdentifierSchema> unmarshal(SIPdentifier v) throws Exception {
        return new Identifier<>(RelatedDocument.PublicationIdentifierSchema.forValue(v.schema), v.id, v.url);
    }

    @Override
    public SIPdentifier marshal(eu.openminted.registry.domain.Identifier<RelatedDocument.PublicationIdentifierSchema> v) throws Exception {
        return new SIPdentifier(v.getId(), v.getSchema().getValue(), v.getUrl());
    }

    public static class SIPdentifier {
        @XmlValue
        private String id;
        @XmlAttribute(name = "publicationIdentifierSchemeName")
        private String schema;
        @XmlAttribute(name = "schemeURI")
        private String url;

        public SIPdentifier() {
        }

        public SIPdentifier(String id, String schema, String url) {
            this.id = id;
            this.schema = schema;
            this.url = url;
        }
    }
}