
package eu.openminted.registry.domain;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for componentDocumentationInfoType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="componentDocumentationInfoType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="onLineHelpURL" type="{http://www.meta-share.org/OMTD-SHARE_XMLSchema}httpURI" minOccurs="0"/&gt;
 *         &lt;element name="hasManual" type="{http://www.meta-share.org/OMTD-SHARE_XMLSchema}relatedDocumentInfoType" minOccurs="0"/&gt;
 *         &lt;element name="issueTracker" type="{http://www.meta-share.org/OMTD-SHARE_XMLSchema}httpURI" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "componentDocumentationInfoType", propOrder = {
    "onLineHelpURL",
    "hasManual",
    "issueTracker"
})
public class ComponentDocumentationInfo {

    @XmlSchemaType(name = "anyURI")
    protected String onLineHelpURL;
    protected RelatedDocumentInfo hasManual;
    @XmlSchemaType(name = "anyURI")
    protected String issueTracker;

    /**
     * Gets the value of the onLineHelpURL property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOnLineHelpURL() {
        return onLineHelpURL;
    }

    /**
     * Sets the value of the onLineHelpURL property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOnLineHelpURL(String value) {
        this.onLineHelpURL = value;
    }

    /**
     * Gets the value of the hasManual property.
     * 
     * @return
     *     possible object is
     *     {@link RelatedDocumentInfo }
     *     
     */
    public RelatedDocumentInfo getHasManual() {
        return hasManual;
    }

    /**
     * Sets the value of the hasManual property.
     * 
     * @param value
     *     allowed object is
     *     {@link RelatedDocumentInfo }
     *     
     */
    public void setHasManual(RelatedDocumentInfo value) {
        this.hasManual = value;
    }

    /**
     * Gets the value of the issueTracker property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIssueTracker() {
        return issueTracker;
    }

    /**
     * Sets the value of the issueTracker property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIssueTracker(String value) {
        this.issueTracker = value;
    }

}
