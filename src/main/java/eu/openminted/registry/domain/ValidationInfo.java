package eu.openminted.registry.domain;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.adapters.XmlAdapter;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

import java.util.List;

/**
 * Created by stefania on 9/5/16.
 */
@XmlAccessorType(XmlAccessType.FIELD)
public class ValidationInfo {

	@XmlJavaTypeAdapter(ValidationTypeAdapter.class)
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
        
        public static ValidationType forValue(String value) {
            for (ValidationType ut: values()) {
                if (ut.getValue().equals(value))
                    return ut;
            }

            return null;
        }
    }

	@XmlJavaTypeAdapter(ValidationModeAdapter.class)
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
        
        public static ValidationMode forValue(String value) {
            for (ValidationMode ut: values()) {
                if (ut.getValue().equals(value))
                    return ut;
            }

            return null;
        }
    }

	@XmlJavaTypeAdapter(ValidationExtentAdapter.class)
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
        
        public static ValidationExtent forValue(String value) {
            for (ValidationExtent ut: values()) {
                if (ut.getValue().equals(value))
                    return ut;
            }

            return null;
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
    
    @XmlElementWrapper(name = "validationReports")
    @XmlElement(name = "hasValidationReport")
    private List<RelatedDocument> validationReports;
    
    @XmlElementWrapper(name = "validationSwComponents")
    @XmlElement(name = "isValidatedBy")
    private List<RelatedResource> validationSwComponents;
    
    @XmlElementWrapper(name = "validators")
    @XmlElement(name = "validator")
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

class ValidationTypeAdapter extends XmlAdapter<String, ValidationInfo.ValidationType> {

    @Override
    public String marshal(ValidationInfo.ValidationType v) throws Exception {
        return v!=null?v.getValue():null;
    }

    @Override
    public ValidationInfo.ValidationType unmarshal(String v) throws Exception {
        return ValidationInfo.ValidationType.forValue(v);
    }
}

class ValidationModeAdapter extends XmlAdapter<String, ValidationInfo.ValidationMode> {

    @Override
    public String marshal(ValidationInfo.ValidationMode v) throws Exception {
        return v!=null?v.getValue():null;
    }

    @Override
    public ValidationInfo.ValidationMode unmarshal(String v) throws Exception {
        return ValidationInfo.ValidationMode.forValue(v);
    }
}

class ValidationExtentAdapter extends XmlAdapter<String, ValidationInfo.ValidationExtent> {

    @Override
    public String marshal(ValidationInfo.ValidationExtent v) throws Exception {
        return v!=null?v.getValue():null;
    }

    @Override
    public ValidationInfo.ValidationExtent unmarshal(String v) throws Exception {
        return ValidationInfo.ValidationExtent.forValue(v);
    }
}
