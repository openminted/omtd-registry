package eu.openminted.registry.domain;

import org.eclipse.persistence.oxm.annotations.XmlPath;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import java.util.List;

/**
 * Created by stefania on 9/5/16.
 */
@XmlAccessorType(XmlAccessType.FIELD)
public class RawCorpusInfo {

    // required
    private final String corpusSubtype = "rawCorpus";
    //required
    @XmlPath("ms:corpusMediaPartsType/ms:corpusTextParts/ms:corpusTextPartInfo")
    private List<CorpusTextPartInfo> corpusTextParts;

    public RawCorpusInfo() {
    }

    public RawCorpusInfo(List<CorpusTextPartInfo> corpusTextParts) {
        this.corpusTextParts = corpusTextParts;
    }

    public List<CorpusTextPartInfo> getCorpusTextParts() {
        return corpusTextParts;
    }

    public void setCorpusTextParts(List<CorpusTextPartInfo> corpusTextParts) {
        this.corpusTextParts = corpusTextParts;
    }

    public String getCorpusSubtype() {
        return corpusSubtype;
    }
}
