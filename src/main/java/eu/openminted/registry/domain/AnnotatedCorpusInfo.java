package eu.openminted.registry.domain;

import org.eclipse.persistence.oxm.annotations.XmlPath;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;

import java.util.List;

/**
 * Created by stefania on 9/5/16.
 */
@XmlAccessorType(XmlAccessType.FIELD)
public class AnnotatedCorpusInfo {

    // required
    private final String corpusSubtype = "annotatedCorpus";
    //required
    @XmlPath("ms:corpusMediaParts/ms:corpusTextParts/ms:corpusTextPartInfo")
    //@XmlElementWrapper(name = "corpusMediaParts/corpusTextParts")
    //@XmlElement(name = "corpusTextPartInfo")
    private List<CorpusTextPartInfo> corpusTextParts;
    //required
    @XmlPath("ms:corpusMediaParts/ms:annotations/ms:annotationInfo")
    //@XmlElementWrapper(name = "corpusMediaParts/annotations")
    //@XmlElement(name = "annotationInfo")
    private List<AnnotationInfo> annotations;

    public AnnotatedCorpusInfo() {
    }

    public AnnotatedCorpusInfo(List<CorpusTextPartInfo> corpusTextParts, List<AnnotationInfo> annotations) {
        this.corpusTextParts = corpusTextParts;
        this.annotations = annotations;
    }

    public List<CorpusTextPartInfo> getCorpusTextParts() {
        return corpusTextParts;
    }

    public void setCorpusTextParts(List<CorpusTextPartInfo> corpusTextParts) {
        this.corpusTextParts = corpusTextParts;
    }

    public List<AnnotationInfo> getAnnotations() {
        return annotations;
    }

    public void setAnnotations(List<AnnotationInfo> annotations) {
        this.annotations = annotations;
    }

    public String getCorpusSubtype() {
        return corpusSubtype;
    }
}
