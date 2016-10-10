package eu.openminted.registry.domain;

/**
 * Created by stefania on 9/5/16.
 */
public class AnnotationsInfo extends CorpusSubTypeSpecificInfo {

    //required
    private RelatedResource rawCorpus;
    //required
    private AnnotationInfo annotationInfo;

    public AnnotationsInfo() {
    }

    public AnnotationsInfo(RelatedResource rawCorpus, AnnotationInfo annotationInfo) {
        this.rawCorpus = rawCorpus;
        this.annotationInfo = annotationInfo;
    }

    public RelatedResource getRawCorpus() {
        return rawCorpus;
    }

    public void setRawCorpus(RelatedResource rawCorpus) {
        this.rawCorpus = rawCorpus;
    }

    public AnnotationInfo getAnnotationInfo() {
        return annotationInfo;
    }

    public void setAnnotationInfo(AnnotationInfo annotationInfo) {
        this.annotationInfo = annotationInfo;
    }
}