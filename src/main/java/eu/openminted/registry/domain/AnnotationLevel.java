package eu.openminted.registry.domain;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlValue;

/**
 * Created by stefania on 9/5/16.
 */
@XmlAccessorType(XmlAccessType.FIELD)
public class AnnotationLevel {

    //TODO this should be made into an enum (use annotationLevel from ResourceCommon.xsd)
    @XmlValue
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
