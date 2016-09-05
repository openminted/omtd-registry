package eu.openminted.registry.domain;

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
    }

    //one of the 2
    private String documentUnstructured;
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
