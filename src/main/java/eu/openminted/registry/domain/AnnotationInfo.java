package eu.openminted.registry.domain;

import java.util.List;

/**
 * Created by stefania on 9/5/16.
 */
public class AnnotationInfo {

    //required
    private AnnotationLevel annotationLevel;
    private boolean annotationStandoff;
    private DataFormat dataFormat;
    private RelatedResource typeSystem;
    private RelatedResource tagSet;
    private String theoreticModel;
    private List<RelatedDocument> guidelinesDocumentedIn;
    private ProcessMode annotationMode;
    private String annotationModeDetails;
    private List<RelatedResource> isAnnotatedBy;
    private DateCombinationType annotationDate;
    private SizeInfo sizePerAnnotation;
    private String interannotatorAgreement;
    private String intraannotatorAgreement;
    private List<ActorInfo> annotators;

    public AnnotationInfo() {
    }

    public AnnotationInfo(AnnotationLevel annotationLevel) {
        this.annotationLevel = annotationLevel;
    }

    public AnnotationInfo(AnnotationLevel annotationLevel, boolean annotationStandoff, DataFormat dataFormat, RelatedResource typeSystem, RelatedResource tagSet, String theoreticModel, List<RelatedDocument> guidelinesDocumentedIn, ProcessMode annotationMode, String annotationModeDetails, List<RelatedResource> isAnnotatedBy, DateCombinationType annotationDate, SizeInfo sizePerAnnotation, String interannotatorAgreement, String intraannotatorAgreement, List<ActorInfo> annotators) {
        this.annotationLevel = annotationLevel;
        this.annotationStandoff = annotationStandoff;
        this.dataFormat = dataFormat;
        this.typeSystem = typeSystem;
        this.tagSet = tagSet;
        this.theoreticModel = theoreticModel;
        this.guidelinesDocumentedIn = guidelinesDocumentedIn;
        this.annotationMode = annotationMode;
        this.annotationModeDetails = annotationModeDetails;
        this.isAnnotatedBy = isAnnotatedBy;
        this.annotationDate = annotationDate;
        this.sizePerAnnotation = sizePerAnnotation;
        this.interannotatorAgreement = interannotatorAgreement;
        this.intraannotatorAgreement = intraannotatorAgreement;
        this.annotators = annotators;
    }

    public AnnotationLevel getAnnotationLevel() {
        return annotationLevel;
    }

    public void setAnnotationLevel(AnnotationLevel annotationLevel) {
        this.annotationLevel = annotationLevel;
    }

    public boolean isAnnotationStandoff() {
        return annotationStandoff;
    }

    public void setAnnotationStandoff(boolean annotationStandoff) {
        this.annotationStandoff = annotationStandoff;
    }

    public DataFormat getDataFormat() {
        return dataFormat;
    }

    public void setDataFormat(DataFormat dataFormat) {
        this.dataFormat = dataFormat;
    }

    public RelatedResource getTypeSystem() {
        return typeSystem;
    }

    public void setTypeSystem(RelatedResource typeSystem) {
        this.typeSystem = typeSystem;
    }

    public RelatedResource getTagSet() {
        return tagSet;
    }

    public void setTagSet(RelatedResource tagSet) {
        this.tagSet = tagSet;
    }

    public String getTheoreticModel() {
        return theoreticModel;
    }

    public void setTheoreticModel(String theoreticModel) {
        this.theoreticModel = theoreticModel;
    }

    public List<RelatedDocument> getGuidelinesDocumentedIn() {
        return guidelinesDocumentedIn;
    }

    public void setGuidelinesDocumentedIn(List<RelatedDocument> guidelinesDocumentedIn) {
        this.guidelinesDocumentedIn = guidelinesDocumentedIn;
    }

    public ProcessMode getAnnotationMode() {
        return annotationMode;
    }

    public void setAnnotationMode(ProcessMode annotationMode) {
        this.annotationMode = annotationMode;
    }

    public String getAnnotationModeDetails() {
        return annotationModeDetails;
    }

    public void setAnnotationModeDetails(String annotationModeDetails) {
        this.annotationModeDetails = annotationModeDetails;
    }

    public List<RelatedResource> getIsAnnotatedBy() {
        return isAnnotatedBy;
    }

    public void setIsAnnotatedBy(List<RelatedResource> isAnnotatedBy) {
        this.isAnnotatedBy = isAnnotatedBy;
    }

    public DateCombinationType getAnnotationDate() {
        return annotationDate;
    }

    public void setAnnotationDate(DateCombinationType annotationDate) {
        this.annotationDate = annotationDate;
    }

    public SizeInfo getSizePerAnnotation() {
        return sizePerAnnotation;
    }

    public void setSizePerAnnotation(SizeInfo sizePerAnnotation) {
        this.sizePerAnnotation = sizePerAnnotation;
    }

    public String getInterannotatorAgreement() {
        return interannotatorAgreement;
    }

    public void setInterannotatorAgreement(String interannotatorAgreement) {
        this.interannotatorAgreement = interannotatorAgreement;
    }

    public String getIntraannotatorAgreement() {
        return intraannotatorAgreement;
    }

    public void setIntraannotatorAgreement(String intraannotatorAgreement) {
        this.intraannotatorAgreement = intraannotatorAgreement;
    }

    public List<ActorInfo> getAnnotators() {
        return annotators;
    }

    public void setAnnotators(List<ActorInfo> annotators) {
        this.annotators = annotators;
    }
}
