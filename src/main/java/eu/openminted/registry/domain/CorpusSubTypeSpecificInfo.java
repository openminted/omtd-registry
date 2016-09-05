package eu.openminted.registry.domain;

/**
 * Created by stefania on 9/5/16.
 */
public class CorpusSubTypeSpecificInfo {

    private String corpusSubtype;

    public CorpusSubTypeSpecificInfo() {
    }

    public CorpusSubTypeSpecificInfo(String corpusSubtype) {
        this.corpusSubtype = corpusSubtype;
    }

    public String getCorpusSubtype() {
        return corpusSubtype;
    }

    public void setCorpusSubtype(String corpusSubtype) {
        this.corpusSubtype = corpusSubtype;
    }
}
