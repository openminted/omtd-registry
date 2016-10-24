
package eu.openminted.registry.domain;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * Base type for annotated documents (single files); combination of raw publication (with link to it) and the annotated file
 * 
 * <p>Java class for annotatedDocumentInfoType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="annotatedDocumentInfoType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="rawPublication" type="{http://www.meta-share.org/OMTD-SHARE_XMLSchema}relatedDocumentInfoType"/&gt;
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
@XmlType(name = "annotatedDocumentInfoType", propOrder = {
    "rawPublication",
    "annotationInfo"
})
public class AnnotatedDocumentInfo {

    @XmlElement(required = true)
    protected RelatedDocumentInfo rawPublication;
    @XmlElement(required = true)
    protected AnnotationInfo annotationInfo;

    /**
     * Gets the value of the rawPublication property.
     * 
     * @return
     *     possible object is
     *     {@link RelatedDocumentInfo }
     *     
     */
    public RelatedDocumentInfo getRawPublication() {
        return rawPublication;
    }

    /**
     * Sets the value of the rawPublication property.
     * 
     * @param value
     *     allowed object is
     *     {@link RelatedDocumentInfo }
     *     
     */
    public void setRawPublication(RelatedDocumentInfo value) {
        this.rawPublication = value;
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
