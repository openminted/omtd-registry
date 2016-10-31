
package eu.openminted.registry.domain;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for resourceDocumentationInfoType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="resourceDocumentationInfoType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="mustBeCitedWith" type="{http://www.meta-share.org/OMTD-SHARE_XMLSchema}relatedDocumentInfoType" minOccurs="0"/&gt;
 *         &lt;element name="documentationPublications" minOccurs="0"&gt;
 *           &lt;complexType&gt;
 *             &lt;complexContent&gt;
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                 &lt;sequence&gt;
 *                   &lt;element name="isDocumentedIn" type="{http://www.meta-share.org/OMTD-SHARE_XMLSchema}relatedDocumentInfoType" maxOccurs="unbounded"/&gt;
 *                 &lt;/sequence&gt;
 *               &lt;/restriction&gt;
 *             &lt;/complexContent&gt;
 *           &lt;/complexType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="samplesLocations" minOccurs="0"&gt;
 *           &lt;complexType&gt;
 *             &lt;complexContent&gt;
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                 &lt;sequence&gt;
 *                   &lt;element name="samplesLocation" type="{http://www.meta-share.org/OMTD-SHARE_XMLSchema}httpURI" maxOccurs="unbounded" minOccurs="0"/&gt;
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
@XmlType(name = "resourceDocumentationInfoType", propOrder = {
    "mustBeCitedWith",
    "documentationPublications",
    "samplesLocations"
})
public class ResourceDocumentationInfo {

    protected RelatedDocumentInfo mustBeCitedWith;
    @XmlElementWrapper
    @XmlElement(name = "isDocumentedIn", namespace = "http://www.meta-share.org/OMTD-SHARE_XMLSchema")
    protected List<RelatedDocumentInfo> documentationPublications;
    @XmlElementWrapper
    @XmlElement(name = "samplesLocation", namespace = "http://www.meta-share.org/OMTD-SHARE_XMLSchema")
    protected List<String> samplesLocations;

    /**
     * Gets the value of the mustBeCitedWith property.
     * 
     * @return
     *     possible object is
     *     {@link RelatedDocumentInfo }
     *     
     */
    public RelatedDocumentInfo getMustBeCitedWith() {
        return mustBeCitedWith;
    }

    /**
     * Sets the value of the mustBeCitedWith property.
     * 
     * @param value
     *     allowed object is
     *     {@link RelatedDocumentInfo }
     *     
     */
    public void setMustBeCitedWith(RelatedDocumentInfo value) {
        this.mustBeCitedWith = value;
    }

    public List<RelatedDocumentInfo> getDocumentationPublications() {
        if (documentationPublications == null) {
            documentationPublications = new ArrayList<RelatedDocumentInfo>();
        }
        return documentationPublications;
    }

    public void setDocumentationPublications(List<RelatedDocumentInfo> documentationPublications) {
        this.documentationPublications = documentationPublications;
    }

    public List<String> getSamplesLocations() {
        if (samplesLocations == null) {
            samplesLocations = new ArrayList<String>();
        }
        return samplesLocations;
    }

    public void setSamplesLocations(List<String> samplesLocations) {
        this.samplesLocations = samplesLocations;
    }

}
