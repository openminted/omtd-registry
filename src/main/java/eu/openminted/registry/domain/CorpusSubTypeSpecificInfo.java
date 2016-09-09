package eu.openminted.registry.domain;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;

/**
 * Created by stefania on 9/5/16.
 */
@XmlAccessorType(XmlAccessType.FIELD)
public class CorpusSubTypeSpecificInfo {

    // one of three
    private AnnotatedCorpusInfo annotatedCorpusInfo;
    private RawCorpusInfo rawCorpusInfo;
    private AnnotationInfo annotationInfo;

    public CorpusSubTypeSpecificInfo() {
    }

    public AnnotatedCorpusInfo getAnnotatedCorpusInfo() {
        return annotatedCorpusInfo;
    }

    public void setAnnotatedCorpusInfo(AnnotatedCorpusInfo annotatedCorpusInfo) {
        this.annotatedCorpusInfo = annotatedCorpusInfo;
    }

    public RawCorpusInfo getRawCorpusInfo() {
        return rawCorpusInfo;
    }

    public void setRawCorpusInfo(RawCorpusInfo rawCorpusInfo) {
        this.rawCorpusInfo = rawCorpusInfo;
    }

    public AnnotationInfo getAnnotationInfo() {
        return annotationInfo;
    }

    public void setAnnotationInfo(AnnotationInfo annotationInfo) {
        this.annotationInfo = annotationInfo;
    }
}
