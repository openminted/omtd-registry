
package eu.openminted.registry.domain;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for anonymous complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element ref="{http://www.meta-share.org/OMTD-SHARE_XMLSchema}typesystem"/&gt;
 *         &lt;element name="tagsets" minOccurs="0"&gt;
 *           &lt;complexType&gt;
 *             &lt;complexContent&gt;
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                 &lt;sequence&gt;
 *                   &lt;element ref="{http://www.meta-share.org/OMTD-SHARE_XMLSchema}tagset" maxOccurs="unbounded" minOccurs="0"/&gt;
 *                 &lt;/sequence&gt;
 *               &lt;/restriction&gt;
 *             &lt;/complexContent&gt;
 *           &lt;/complexType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="annotationResources" minOccurs="0"&gt;
 *           &lt;complexType&gt;
 *             &lt;complexContent&gt;
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                 &lt;sequence&gt;
 *                   &lt;element ref="{http://www.meta-share.org/OMTD-SHARE_XMLSchema}annotationResource" maxOccurs="unbounded" minOccurs="0"/&gt;
 *                 &lt;/sequence&gt;
 *               &lt;/restriction&gt;
 *             &lt;/complexContent&gt;
 *           &lt;/complexType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="softwareLibraries" minOccurs="0"&gt;
 *           &lt;complexType&gt;
 *             &lt;complexContent&gt;
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                 &lt;sequence&gt;
 *                   &lt;element name="requiresSoftware" type="{http://www.w3.org/2001/XMLSchema}string" maxOccurs="unbounded" minOccurs="0"/&gt;
 *                 &lt;/sequence&gt;
 *               &lt;/restriction&gt;
 *             &lt;/complexContent&gt;
 *           &lt;/complexType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="requiresHardware" maxOccurs="unbounded" minOccurs="0"&gt;
 *           &lt;simpleType&gt;
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *               &lt;maxLength value="100"/&gt;
 *               &lt;enumeration value="graphicCard"/&gt;
 *               &lt;enumeration value="microphone"/&gt;
 *               &lt;enumeration value="ocrSystem"/&gt;
 *               &lt;enumeration value="specialHardwareEquipment"/&gt;
 *               &lt;enumeration value="none"/&gt;
 *               &lt;enumeration value="other"/&gt;
 *             &lt;/restriction&gt;
 *           &lt;/simpleType&gt;
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
@XmlType(name = "", propOrder = {
    "typesystem",
    "tagsets",
    "annotationResources",
    "softwareLibraries",
    "requiresHardware"
})
public class ComponentDependencies {

    @XmlElement(required = true)
    protected RelatedResource typesystem;
    @XmlElementWrapper
    @XmlElement(name = "tagset", namespace = "http://www.meta-share.org/OMTD-SHARE_XMLSchema")
    protected List<RelatedResource> tagsets;
    @XmlElementWrapper
    @XmlElement(name = "annotationResource", namespace = "http://www.meta-share.org/OMTD-SHARE_XMLSchema")
    protected List<RelatedResource> annotationResources;
    @XmlElementWrapper
    @XmlElement(name = "requiresSoftware", namespace = "http://www.meta-share.org/OMTD-SHARE_XMLSchema")
    protected List<String> softwareLibraries;
    protected List<RequiresHardwareEnum> requiresHardware;

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
     * Gets the value of the requiresHardware property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the requiresHardware property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getRequiresHardware().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link RequiresHardwareEnum }
     * 
     * 
     */
    public List<RequiresHardwareEnum> getRequiresHardware() {
        if (requiresHardware == null) {
            requiresHardware = new ArrayList<RequiresHardwareEnum>();
        }
        return this.requiresHardware;
    }

    public List<RelatedResource> getTagsets() {
        if (tagsets == null) {
            tagsets = new ArrayList<RelatedResource>();
        }
        return tagsets;
    }

    public void setTagsets(List<RelatedResource> tagsets) {
        this.tagsets = tagsets;
    }

    public List<RelatedResource> getAnnotationResources() {
        if (annotationResources == null) {
            annotationResources = new ArrayList<RelatedResource>();
        }
        return annotationResources;
    }

    public void setAnnotationResources(List<RelatedResource> annotationResources) {
        this.annotationResources = annotationResources;
    }

    public List<String> getSoftwareLibraries() {
        if (softwareLibraries == null) {
            softwareLibraries = new ArrayList<String>();
        }
        return softwareLibraries;
    }

    public void setSoftwareLibraries(List<String> softwareLibraries) {
        this.softwareLibraries = softwareLibraries;
    }

}
