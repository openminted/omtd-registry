
package eu.openminted.registry.domain;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for annotationsInfoType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="annotationsInfoType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="corpusSubtype" type="{http://www.w3.org/2001/XMLSchema}anyType"/&gt;
 *         &lt;element name="rawCorpus" type="{http://www.meta-share.org/OMTD-SHARE_XMLSchema}relatedResourceType"/&gt;
 *         &lt;element ref="{http://www.meta-share.org/OMTD-SHARE_XMLSchema}annotationInfo"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "annotationsInfoType", propOrder = {
    "corpusSubtype",
    "rawCorpus",
    "annotationInfo"
})
public class AnnotationsInfo {

    @XmlElement(required = true)
    protected Object corpusSubtype;
    @XmlElement(required = true)
    protected RelatedResource rawCorpus;
    @XmlElement(required = true)
    protected AnnotationInfo annotationInfo;

    /**
     * Gets the value of the corpusSubtype property.
     * 
     * @return
     *     possible object is
     *     {@link Object }
     *     
     */
    public Object getCorpusSubtype() {
        return corpusSubtype;
    }

    /**
     * Sets the value of the corpusSubtype property.
     * 
     * @param value
     *     allowed object is
     *     {@link Object }
     *     
     */
    public void setCorpusSubtype(Object value) {
        this.corpusSubtype = value;
    }

    /**
     * Gets the value of the rawCorpus property.
     * 
     * @return
     *     possible object is
     *     {@link RelatedResource }
     *     
     */
    public RelatedResource getRawCorpus() {
        return rawCorpus;
    }

    /**
     * Sets the value of the rawCorpus property.
     * 
     * @param value
     *     allowed object is
     *     {@link RelatedResource }
     *     
     */
    public void setRawCorpus(RelatedResource value) {
        this.rawCorpus = value;
    }

    /**
     * Gets the value of the annotationInfo property.
     * 
     * @return
     *     possible object is
     *     {@link AnnotationInfo }
     *     
     */
    public AnnotationInfo getAnnotationInfo() {
        return annotationInfo;
    }

    /**
     * Sets the value of the annotationInfo property.
     * 
     * @param value
     *     allowed object is
     *     {@link AnnotationInfo }
     *     
     */
    public void setAnnotationInfo(AnnotationInfo value) {
        this.annotationInfo = value;
    }

}
