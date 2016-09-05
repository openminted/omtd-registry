package eu.openminted.registry.domain;

/**
 * Created by stefania on 9/5/16.
 */
public enum ResourceIdentifierSchema implements IdentifierSchema {

    DOI("doi"),
    ISLRN("islrn"),
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

    ResourceIdentifierSchema(String value) {
        this.value = value;
    }

    @Override
    public String getValue() {
        return value;
    }
}