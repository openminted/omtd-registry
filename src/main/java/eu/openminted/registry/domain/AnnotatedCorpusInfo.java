package eu.openminted.registry.domain;

import java.util.List;

/**
 * Created by stefania on 9/5/16.
 */
public class AnnotatedCorpusInfo extends CorpusSubTypeSpecificInfo {

    //required
    private List<CorpusTextPartInfo> corpusTextParts;
    //required
    private List<AnnotationInfo> annotations;

    public AnnotatedCorpusInfo() {
        super("annotatedCorpus");
    }

    public AnnotatedCorpusInfo(List<CorpusTextPartInfo> corpusTextParts, List<AnnotationInfo> annotations) {
        super("annotatedCorpus");
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
}
