package eu.openminted.registry.domain;

import java.util.List;

/**
 * Created by stefania on 9/5/16.
 */
public class RawCorpusInfo extends CorpusSubTypeSpecificInfo {

    //required
    private List<CorpusTextPartInfo> corpusTextParts;

    public RawCorpusInfo() {
        super("rawCorpus");
    }

    public RawCorpusInfo(List<CorpusTextPartInfo> corpusTextParts) {
        super("rawCorpus");
        this.corpusTextParts = corpusTextParts;
    }

    public List<CorpusTextPartInfo> getCorpusTextParts() {
        return corpusTextParts;
    }

    public void setCorpusTextParts(List<CorpusTextPartInfo> corpusTextParts) {
        this.corpusTextParts = corpusTextParts;
    }
}
