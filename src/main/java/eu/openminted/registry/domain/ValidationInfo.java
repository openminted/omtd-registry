
package eu.openminted.registry.domain;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for validationInfoType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="validationInfoType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="validated" type="{http://www.w3.org/2001/XMLSchema}boolean"/&gt;
 *         &lt;element name="validationType" minOccurs="0"&gt;
 *           &lt;simpleType&gt;
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *               &lt;maxLength value="20"/&gt;
 *               &lt;enumeration value="formal"/&gt;
 *               &lt;enumeration value="content"/&gt;
 *             &lt;/restriction&gt;
 *           &lt;/simpleType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="validationMode" type="{http://www.meta-share.org/OMTD-SHARE_XMLSchema}processMode" minOccurs="0"/&gt;
 *         &lt;element name="validationModeDetails" minOccurs="0"&gt;
 *           &lt;simpleType&gt;
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *               &lt;maxLength value="500"/&gt;
 *             &lt;/restriction&gt;
 *           &lt;/simpleType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="validationExtent" minOccurs="0"&gt;
 *           &lt;simpleType&gt;
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *               &lt;maxLength value="20"/&gt;
 *               &lt;enumeration value="full"/&gt;
 *               &lt;enumeration value="partial"/&gt;
 *             &lt;/restriction&gt;
 *           &lt;/simpleType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="validationExtentDetails" minOccurs="0"&gt;
 *           &lt;simpleType&gt;
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *               &lt;maxLength value="500"/&gt;
 *             &lt;/restriction&gt;
 *           &lt;/simpleType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="sizePerValidation" type="{http://www.meta-share.org/OMTD-SHARE_XMLSchema}sizeInfoType" minOccurs="0"/&gt;
 *         &lt;element name="validationReports" minOccurs="0"&gt;
 *           &lt;complexType&gt;
 *             &lt;complexContent&gt;
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                 &lt;sequence&gt;
 *                   &lt;element name="hasValidationReport" type="{http://www.meta-share.org/OMTD-SHARE_XMLSchema}relatedDocumentInfoType" maxOccurs="unbounded" minOccurs="0"/&gt;
 *                 &lt;/sequence&gt;
 *               &lt;/restriction&gt;
 *             &lt;/complexContent&gt;
 *           &lt;/complexType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="validationSwComponents" minOccurs="0"&gt;
 *           &lt;complexType&gt;
 *             &lt;complexContent&gt;
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                 &lt;sequence&gt;
 *                   &lt;element name="isValidatedBy" type="{http://www.meta-share.org/OMTD-SHARE_XMLSchema}relatedResourceType" maxOccurs="unbounded" minOccurs="0"/&gt;
 *                 &lt;/sequence&gt;
 *               &lt;/restriction&gt;
 *             &lt;/complexContent&gt;
 *           &lt;/complexType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="validators" minOccurs="0"&gt;
 *           &lt;complexType&gt;
 *             &lt;complexContent&gt;
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                 &lt;sequence&gt;
 *                   &lt;element name="validator" type="{http://www.meta-share.org/OMTD-SHARE_XMLSchema}actorInfoType" maxOccurs="unbounded" minOccurs="0"/&gt;
 *                 &lt;/sequence&gt;
 *               &lt;/restriction&gt;
 *             &lt;/complexContent&gt;
 *           &lt;/complexType&gt;
 *         &lt;/element&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "validationInfoType", propOrder = {
    "validated",
    "validationType",
    "validationMode",
    "validationModeDetails",
    "validationExtent",
    "validationExtentDetails",
    "sizePerValidation",
    "validationReports",
    "validationSwComponents",
    "validators"
})
public class ValidationInfo {

    protected boolean validated;
    protected ValidationTypeEnum validationType;
    @XmlSchemaType(name = "string")
    protected ProcessMode validationMode;
    protected String validationModeDetails;
    protected ValidationExtentEnum validationExtent;
    protected String validationExtentDetails;
    protected SizeInfo sizePerValidation;
    @XmlElementWrapper
    @XmlElement(name = "hasValidationReport", namespace = "http://www.meta-share.org/OMTD-SHARE_XMLSchema")
    protected List<RelatedDocumentInfo> validationReports;
    @XmlElementWrapper
    @XmlElement(name = "isValidatedBy", namespace = "http://www.meta-share.org/OMTD-SHARE_XMLSchema")
    protected List<RelatedResource> validationSwComponents;
    @XmlElementWrapper
    @XmlElement(name = "validator", namespace = "http://www.meta-share.org/OMTD-SHARE_XMLSchema")
    protected List<ActorInfo> validators;

    /**
     * Gets the value of the validated property.
     * 
     */
    public boolean isValidated() {
        return validated;
    }

    /**
     * Sets the value of the validated property.
     * 
     */
    public void setValidated(boolean value) {
        this.validated = value;
    }

    /**
     * Gets the value of the validationType property.
     * 
     * @return
     *     possible object is
     *     {@link ValidationTypeEnum }
     *     
     */
    public ValidationTypeEnum getValidationType() {
        return validationType;
    }

    /**
     * Sets the value of the validationType property.
     * 
     * @param value
     *     allowed object is
     *     {@link ValidationTypeEnum }
     *     
     */
    public void setValidationType(ValidationTypeEnum value) {
        this.validationType = value;
    }

    /**
     * Gets the value of the validationMode property.
     * 
     * @return
     *     possible object is
     *     {@link ProcessMode }
     *     
     */
    public ProcessMode getValidationMode() {
        return validationMode;
    }

    /**
     * Sets the value of the validationMode property.
     * 
     * @param value
     *     allowed object is
     *     {@link ProcessMode }
     *     
     */
    public void setValidationMode(ProcessMode value) {
        this.validationMode = value;
    }

    /**
     * Gets the value of the validationModeDetails property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getValidationModeDetails() {
        return validationModeDetails;
    }

    /**
     * Sets the value of the validationModeDetails property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setValidationModeDetails(String value) {
        this.validationModeDetails = value;
    }

    /**
     * Gets the value of the validationExtent property.
     * 
     * @return
     *     possible object is
     *     {@link ValidationExtentEnum }
     *     
     */
    public ValidationExtentEnum getValidationExtent() {
        return validationExtent;
    }

    /**
     * Sets the value of the validationExtent property.
     * 
     * @param value
     *     allowed object is
     *     {@link ValidationExtentEnum }
     *     
     */
    public void setValidationExtent(ValidationExtentEnum value) {
        this.validationExtent = value;
    }

    /**
     * Gets the value of the validationExtentDetails property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getValidationExtentDetails() {
        return validationExtentDetails;
    }

    /**
     * Sets the value of the validationExtentDetails property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setValidationExtentDetails(String value) {
        this.validationExtentDetails = value;
    }

    /**
     * Gets the value of the sizePerValidation property.
     * 
     * @return
     *     possible object is
     *     {@link SizeInfo }
     *     
     */
    public SizeInfo getSizePerValidation() {
        return sizePerValidation;
    }

    /**
     * Sets the value of the sizePerValidation property.
     * 
     * @param value
     *     allowed object is
     *     {@link SizeInfo }
     *     
     */
    public void setSizePerValidation(SizeInfo value) {
        this.sizePerValidation = value;
    }

    public List<RelatedDocumentInfo> getValidationReports() {
        if (validationReports == null) {
            validationReports = new ArrayList<RelatedDocumentInfo>();
        }
        return validationReports;
    }

    public void setValidationReports(List<RelatedDocumentInfo> validationReports) {
        this.validationReports = validationReports;
    }

    public List<RelatedResource> getValidationSwComponents() {
        if (validationSwComponents == null) {
            validationSwComponents = new ArrayList<RelatedResource>();
        }
        return validationSwComponents;
    }

    public void setValidationSwComponents(List<RelatedResource> validationSwComponents) {
        this.validationSwComponents = validationSwComponents;
    }

    public List<ActorInfo> getValidators() {
        if (validators == null) {
            validators = new ArrayList<ActorInfo>();
        }
        return validators;
    }

    public void setValidators(List<ActorInfo> validators) {
        this.validators = validators;
    }

}
