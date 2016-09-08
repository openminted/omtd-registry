package eu.openminted.registry.domain;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import java.util.List;

/**
 * Created by stefania on 9/5/16.
 */
@XmlAccessorType(XmlAccessType.FIELD)
public class ValidationInfo {

    enum ValidationType {

        FORMAL("formal"),
        CONTENT("content");

        private String value;

        ValidationType(String value) {
            this.value = value;
        }

        public String getValue() {
            return value;
        }
    }

    enum ValidationMode {

        MANUAL("manual"),
        AUTOMATIC("automatic"),
        MIXED("mixed"),
        INTERACTIVE("interactive");

        private String value;

        ValidationMode(String value) {
            this.value = value;
        }

        public String getValue() {
            return value;
        }
    }

    enum ValidationExtent {

        FORMAL("full"),
        CONTENT("partial");

        private String value;

        ValidationExtent(String value) {
            this.value = value;
        }

        public String getValue() {
            return value;
        }
    }

    //required
    private boolean validated;
    private ValidationType validationType;
    private ValidationMode validationMode;
    private String validationModeDetails;
    private ValidationExtent validationExtent;
    private String validationExtentDetails;
    private SizeInfo sizePerValidation;
    private List<RelatedDocument> validationReports;
    private List<RelatedResource> validationSwComponents;
    private List<ActorInfo> validators;

    public ValidationInfo() {
    }

    public ValidationInfo(boolean validated) {
        this.validated = validated;
    }

    public ValidationInfo(boolean validated, ValidationType validationType, ValidationMode validationMode,
                          String validationModeDetails, ValidationExtent validationExtent, String validationExtentDetails,
                          SizeInfo sizePerValidation, List<RelatedDocument> validationReports,
                          List<RelatedResource> validationSwComponents, List<ActorInfo> validators) {
        this.validated = validated;
        this.validationType = validationType;
        this.validationMode = validationMode;
        this.validationModeDetails = validationModeDetails;
        this.validationExtent = validationExtent;
        this.validationExtentDetails = validationExtentDetails;
        this.sizePerValidation = sizePerValidation;
        this.validationReports = validationReports;
        this.validationSwComponents = validationSwComponents;
        this.validators = validators;
    }

    public boolean isValidated() {
        return validated;
    }

    public void setValidated(boolean validated) {
        this.validated = validated;
    }

    public ValidationType getValidationType() {
        return validationType;
    }

    public void setValidationType(ValidationType validationType) {
        this.validationType = validationType;
    }

    public ValidationMode getValidationMode() {
        return validationMode;
    }

    public void setValidationMode(ValidationMode validationMode) {
        this.validationMode = validationMode;
    }

    public String getValidationModeDetails() {
        return validationModeDetails;
    }

    public void setValidationModeDetails(String validationModeDetails) {
        this.validationModeDetails = validationModeDetails;
    }

    public ValidationExtent getValidationExtent() {
        return validationExtent;
    }

    public void setValidationExtent(ValidationExtent validationExtent) {
        this.validationExtent = validationExtent;
    }

    public String getValidationExtentDetails() {
        return validationExtentDetails;
    }

    public void setValidationExtentDetails(String validationExtentDetails) {
        this.validationExtentDetails = validationExtentDetails;
    }

    public SizeInfo getSizePerValidation() {
        return sizePerValidation;
    }

    public void setSizePerValidation(SizeInfo sizePerValidation) {
        this.sizePerValidation = sizePerValidation;
    }

    public List<RelatedDocument> getValidationReports() {
        return validationReports;
    }

    public void setValidationReports(List<RelatedDocument> validationReports) {
        this.validationReports = validationReports;
    }

    public List<RelatedResource> getValidationSwComponents() {
        return validationSwComponents;
    }

    public void setValidationSwComponents(List<RelatedResource> validationSwComponents) {
        this.validationSwComponents = validationSwComponents;
    }

    public List<ActorInfo> getValidators() {
        return validators;
    }

    public void setValidators(List<ActorInfo> validators) {
        this.validators = validators;
    }
}
