
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
 * <p>Java class for annotationInfoType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="annotationInfoType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element ref="{http://www.meta-share.org/OMTD-SHARE_XMLSchema}annotationLevel"/&gt;
 *         &lt;element name="annotationStandoff" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/&gt;
 *         &lt;element ref="{http://www.meta-share.org/OMTD-SHARE_XMLSchema}dataFormat" minOccurs="0"/&gt;
 *         &lt;element ref="{http://www.meta-share.org/OMTD-SHARE_XMLSchema}typesystem" minOccurs="0"/&gt;
 *         &lt;element ref="{http://www.meta-share.org/OMTD-SHARE_XMLSchema}tagset" minOccurs="0"/&gt;
 *         &lt;element ref="{http://www.meta-share.org/OMTD-SHARE_XMLSchema}theoreticModel" minOccurs="0"/&gt;
 *         &lt;element name="guidelinesDocumentedIn" type="{http://www.meta-share.org/OMTD-SHARE_XMLSchema}relatedDocumentInfoType" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;element name="annotationMode" type="{http://www.meta-share.org/OMTD-SHARE_XMLSchema}processMode" minOccurs="0"/&gt;
 *         &lt;element name="annotationModeDetails" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="isAnnotatedBy" type="{http://www.meta-share.org/OMTD-SHARE_XMLSchema}relatedResourceType" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;element name="annotationDate" type="{http://www.meta-share.org/OMTD-SHARE_XMLSchema}dateCombinationType" minOccurs="0"/&gt;
 *         &lt;element name="sizePerAnnotation" type="{http://www.meta-share.org/OMTD-SHARE_XMLSchema}sizeInfoType" minOccurs="0"/&gt;
 *         &lt;element name="interannotatorAgreement" minOccurs="0"&gt;
 *           &lt;simpleType&gt;
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *               &lt;maxLength value="1000"/&gt;
 *             &lt;/restriction&gt;
 *           &lt;/simpleType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="intraannotatorAgreement" minOccurs="0"&gt;
 *           &lt;simpleType&gt;
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *               &lt;maxLength value="1000"/&gt;
 *             &lt;/restriction&gt;
 *           &lt;/simpleType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="annotators" minOccurs="0"&gt;
 *           &lt;complexType&gt;
 *             &lt;complexContent&gt;
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                 &lt;sequence&gt;
 *                   &lt;element name="annotator" type="{http://www.meta-share.org/OMTD-SHARE_XMLSchema}actorInfoType" maxOccurs="unbounded" minOccurs="0"/&gt;
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
@XmlType(name = "annotationInfoType", propOrder = {
    "annotationLevel",
    "annotationStandoff",
    "dataFormat",
    "typesystem",
    "tagset",
    "theoreticModel",
    "guidelinesDocumentedIn",
    "annotationMode",
    "annotationModeDetails",
    "isAnnotatedBy",
    "annotationDate",
    "sizePerAnnotation",
    "interannotatorAgreement",
    "intraannotatorAgreement",
    "annotators"
})
public class AnnotationInfo {

    @XmlElement(required = true)
    protected AnnotationLevelEnum annotationLevel;
    protected Boolean annotationStandoff;
    protected DataFormat dataFormat;
    protected RelatedResource typesystem;
    protected RelatedResource tagset;
    protected String theoreticModel;
    protected List<RelatedDocumentInfo> guidelinesDocumentedIn;
    @XmlSchemaType(name = "string")
    protected ProcessMode annotationMode;
    protected String annotationModeDetails;
    protected List<RelatedResource> isAnnotatedBy;
    protected DateCombination annotationDate;
    protected SizeInfo sizePerAnnotation;
    protected String interannotatorAgreement;
    protected String intraannotatorAgreement;
    @XmlElementWrapper
    @XmlElement(name = "annotator", namespace = "http://www.meta-share.org/OMTD-SHARE_XMLSchema")
    protected List<ActorInfo> annotators;

    /**
     * Gets the value of the annotationLevel property.
     * 
     * @return
     *     possible object is
     *     {@link AnnotationLevelEnum }
     *     
     */
    public AnnotationLevelEnum getAnnotationLevel() {
        return annotationLevel;
    }

    /**
     * Sets the value of the annotationLevel property.
     * 
     * @param value
     *     allowed object is
     *     {@link AnnotationLevelEnum }
     *     
     */
    public void setAnnotationLevel(AnnotationLevelEnum value) {
        this.annotationLevel = value;
    }

    /**
     * Gets the value of the annotationStandoff property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isAnnotationStandoff() {
        return annotationStandoff;
    }

    /**
     * Sets the value of the annotationStandoff property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setAnnotationStandoff(Boolean value) {
        this.annotationStandoff = value;
    }

    /**
     * Gets the value of the dataFormat property.
     * 
     * @return
     *     possible object is
     *     {@link DataFormat }
     *     
     */
    public DataFormat getDataFormat() {
        return dataFormat;
    }

    /**
     * Sets the value of the dataFormat property.
     * 
     * @param value
     *     allowed object is
     *     {@link DataFormat }
     *     
     */
    public void setDataFormat(DataFormat value) {
        this.dataFormat = value;
    }

    /**
     * Gets the value of the typesystem property.
     * 
     * @return
     *     possible object is
     *     {@link RelatedResource }
     *     
     */
    public RelatedResource getTypesystem() {
        return typesystem;
    }

    /**
     * Sets the value of the typesystem property.
     * 
     * @param value
     *     allowed object is
     *     {@link RelatedResource }
     *     
     */
    public void setTypesystem(RelatedResource value) {
        this.typesystem = value;
    }

    /**
     * An identifier to the tagset used in the annotation of the resource or used by the tool/service
     * 
     * @return
     *     possible object is
     *     {@link RelatedResource }
     *     
     */
    public RelatedResource getTagset() {
        return tagset;
    }

    /**
     * Sets the value of the tagset property.
     * 
     * @param value
     *     allowed object is
     *     {@link RelatedResource }
     *     
     */
    public void setTagset(RelatedResource value) {
        this.tagset = value;
    }

    /**
     * Gets the value of the theoreticModel property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTheoreticModel() {
        return theoreticModel;
    }

    /**
     * Sets the value of the theoreticModel property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTheoreticModel(String value) {
        this.theoreticModel = value;
    }

    /**
     * Gets the value of the guidelinesDocumentedIn property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the guidelinesDocumentedIn property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getGuidelinesDocumentedIn().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link RelatedDocumentInfo }
     * 
     * 
     */
    public List<RelatedDocumentInfo> getGuidelinesDocumentedIn() {
        if (guidelinesDocumentedIn == null) {
            guidelinesDocumentedIn = new ArrayList<RelatedDocumentInfo>();
        }
        return this.guidelinesDocumentedIn;
    }

    /**
     * Gets the value of the annotationMode property.
     * 
     * @return
     *     possible object is
     *     {@link ProcessMode }
     *     
     */
    public ProcessMode getAnnotationMode() {
        return annotationMode;
    }

    /**
     * Sets the value of the annotationMode property.
     * 
     * @param value
     *     allowed object is
     *     {@link ProcessMode }
     *     
     */
    public void setAnnotationMode(ProcessMode value) {
        this.annotationMode = value;
    }

    /**
     * Gets the value of the annotationModeDetails property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAnnotationModeDetails() {
        return annotationModeDetails;
    }

    /**
     * Sets the value of the annotationModeDetails property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAnnotationModeDetails(String value) {
        this.annotationModeDetails = value;
    }

    /**
     * Gets the value of the isAnnotatedBy property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the isAnnotatedBy property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getIsAnnotatedBy().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link RelatedResource }
     * 
     * 
     */
    public List<RelatedResource> getIsAnnotatedBy() {
        if (isAnnotatedBy == null) {
            isAnnotatedBy = new ArrayList<RelatedResource>();
        }
        return this.isAnnotatedBy;
    }

    /**
     * Gets the value of the annotationDate property.
     * 
     * @return
     *     possible object is
     *     {@link DateCombination }
     *     
     */
    public DateCombination getAnnotationDate() {
        return annotationDate;
    }

    /**
     * Sets the value of the annotationDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link DateCombination }
     *     
     */
    public void setAnnotationDate(DateCombination value) {
        this.annotationDate = value;
    }

    /**
     * Gets the value of the sizePerAnnotation property.
     * 
     * @return
     *     possible object is
     *     {@link SizeInfo }
     *     
     */
    public SizeInfo getSizePerAnnotation() {
        return sizePerAnnotation;
    }

    /**
     * Sets the value of the sizePerAnnotation property.
     * 
     * @param value
     *     allowed object is
     *     {@link SizeInfo }
     *     
     */
    public void setSizePerAnnotation(SizeInfo value) {
        this.sizePerAnnotation = value;
    }

    /**
     * Gets the value of the interannotatorAgreement property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getInterannotatorAgreement() {
        return interannotatorAgreement;
    }

    /**
     * Sets the value of the interannotatorAgreement property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setInterannotatorAgreement(String value) {
        this.interannotatorAgreement = value;
    }

    /**
     * Gets the value of the intraannotatorAgreement property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIntraannotatorAgreement() {
        return intraannotatorAgreement;
    }

    /**
     * Sets the value of the intraannotatorAgreement property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIntraannotatorAgreement(String value) {
        this.intraannotatorAgreement = value;
    }

    public List<ActorInfo> getAnnotators() {
        if (annotators == null) {
            annotators = new ArrayList<ActorInfo>();
        }
        return annotators;
    }

    public void setAnnotators(List<ActorInfo> annotators) {
        this.annotators = annotators;
    }

}
