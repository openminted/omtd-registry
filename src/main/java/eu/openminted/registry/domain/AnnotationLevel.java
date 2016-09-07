package eu.openminted.registry.domain;

/**
 * Created by stefania on 9/5/16.
 */
public class AnnotationLevel {

    //TODO this should be made into an enum (use annotationLevel from ResourceCommon.xsd)
    private String annotationLevel;

    public AnnotationLevel() {
    }

    public AnnotationLevel(String annotationLevel) {
        this.annotationLevel = annotationLevel;
    }

    public String getAnnotationLevel() {
        return annotationLevel;
    }

    public void setAnnotationLevel(String annotationLevel) {
        this.annotationLevel = annotationLevel;
    }
}
