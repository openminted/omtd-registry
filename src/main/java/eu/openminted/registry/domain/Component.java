
package eu.openminted.registry.domain;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for componentMetadataRecord element declaration.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;element name="componentMetadataRecord"&gt;
 *   &lt;complexType&gt;
 *     &lt;complexContent&gt;
 *       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *         &lt;sequence&gt;
 *           &lt;element ref="{http://www.meta-share.org/OMTD-SHARE_XMLSchema}metadataHeaderInfo"/&gt;
 *           &lt;element ref="{http://www.meta-share.org/OMTD-SHARE_XMLSchema}componentInfo"/&gt;
 *         &lt;/sequence&gt;
 *       &lt;/restriction&gt;
 *     &lt;/complexContent&gt;
 *   &lt;/complexType&gt;
 * &lt;/element&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "metadataHeaderInfo",
    "componentInfo"
})
@XmlRootElement(name = "componentMetadataRecord")
public class Component {

    @XmlElement(required = true)
    protected MetadataHeaderInfo metadataHeaderInfo;
    @XmlElement(required = true)
    protected ComponentInfo componentInfo;

    /**
     * Gets the value of the metadataHeaderInfo property.
     * 
     * @return
     *     possible object is
     *     {@link MetadataHeaderInfo }
     *     
     */
    public MetadataHeaderInfo getMetadataHeaderInfo() {
        return metadataHeaderInfo;
    }

    /**
     * Sets the value of the metadataHeaderInfo property.
     * 
     * @param value
     *     allowed object is
     *     {@link MetadataHeaderInfo }
     *     
     */
    public void setMetadataHeaderInfo(MetadataHeaderInfo value) {
        this.metadataHeaderInfo = value;
    }

    /**
     * Gets the value of the componentInfo property.
     * 
     * @return
     *     possible object is
     *     {@link ComponentInfo }
     *     
     */
    public ComponentInfo getComponentInfo() {
        return componentInfo;
    }

    /**
     * Sets the value of the componentInfo property.
     * 
     * @param value
     *     allowed object is
     *     {@link ComponentInfo }
     *     
     */
    public void setComponentInfo(ComponentInfo value) {
        this.componentInfo = value;
    }

}
