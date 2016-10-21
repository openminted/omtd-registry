
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
 * <p>Java class for creationInfoType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="creationInfoType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="originalSources" minOccurs="0"&gt;
 *           &lt;complexType&gt;
 *             &lt;complexContent&gt;
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                 &lt;sequence&gt;
 *                   &lt;element name="hasOriginalSource" type="{http://www.meta-share.org/OMTD-SHARE_XMLSchema}relatedResourceType" maxOccurs="unbounded" minOccurs="0"/&gt;
 *                 &lt;/sequence&gt;
 *               &lt;/restriction&gt;
 *             &lt;/complexContent&gt;
 *           &lt;/complexType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="creationMode" type="{http://www.meta-share.org/OMTD-SHARE_XMLSchema}processMode" minOccurs="0"/&gt;
 *         &lt;element name="creationModeDetails" minOccurs="0"&gt;
 *           &lt;simpleType&gt;
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *               &lt;maxLength value="200"/&gt;
 *             &lt;/restriction&gt;
 *           &lt;/simpleType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="creationSwComponents" minOccurs="0"&gt;
 *           &lt;complexType&gt;
 *             &lt;complexContent&gt;
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                 &lt;sequence&gt;
 *                   &lt;element name="isCreatedBy" type="{http://www.meta-share.org/OMTD-SHARE_XMLSchema}relatedResourceType" maxOccurs="unbounded" minOccurs="0"/&gt;
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
@XmlType(name = "creationInfoType", propOrder = {
    "originalSources",
    "creationMode",
    "creationModeDetails",
    "creationSwComponents"
})
public class CreationInfo {

    @XmlElementWrapper
    @XmlElement(name = "hasOriginalSource", namespace = "http://www.meta-share.org/OMTD-SHARE_XMLSchema")
    protected List<RelatedResource> originalSources;
    @XmlSchemaType(name = "string")
    protected ProcessMode creationMode;
    protected String creationModeDetails;
    @XmlElementWrapper
    @XmlElement(name = "isCreatedBy", namespace = "http://www.meta-share.org/OMTD-SHARE_XMLSchema")
    protected List<RelatedResource> creationSwComponents;

    /**
     * Gets the value of the creationMode property.
     * 
     * @return
     *     possible object is
     *     {@link ProcessMode }
     *     
     */
    public ProcessMode getCreationMode() {
        return creationMode;
    }

    /**
     * Sets the value of the creationMode property.
     * 
     * @param value
     *     allowed object is
     *     {@link ProcessMode }
     *     
     */
    public void setCreationMode(ProcessMode value) {
        this.creationMode = value;
    }

    /**
     * Gets the value of the creationModeDetails property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCreationModeDetails() {
        return creationModeDetails;
    }

    /**
     * Sets the value of the creationModeDetails property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCreationModeDetails(String value) {
        this.creationModeDetails = value;
    }

    public List<RelatedResource> getOriginalSources() {
        if (originalSources == null) {
            originalSources = new ArrayList<RelatedResource>();
        }
        return originalSources;
    }

    public void setOriginalSources(List<RelatedResource> originalSources) {
        this.originalSources = originalSources;
    }

    public List<RelatedResource> getCreationSwComponents() {
        if (creationSwComponents == null) {
            creationSwComponents = new ArrayList<RelatedResource>();
        }
        return creationSwComponents;
    }

    public void setCreationSwComponents(List<RelatedResource> creationSwComponents) {
        this.creationSwComponents = creationSwComponents;
    }

}
