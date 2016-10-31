
package eu.openminted.registry.domain;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
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
 *         &lt;element ref="{http://www.meta-share.org/OMTD-SHARE_XMLSchema}languageDescriptionTextInfo"/&gt;
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
    "languageDescriptionTextInfo"
})
public class LanguageDescriptionMediaType {

    @XmlElement(required = true)
    protected LanguageDescriptionTextInfo languageDescriptionTextInfo;

    /**
     * Gets the value of the languageDescriptionTextInfo property.
     * 
     * @return
     *     possible object is
     *     {@link LanguageDescriptionTextInfo }
     *     
     */
    public LanguageDescriptionTextInfo getLanguageDescriptionTextInfo() {
        return languageDescriptionTextInfo;
    }

    /**
     * Sets the value of the languageDescriptionTextInfo property.
     * 
     * @param value
     *     allowed object is
     *     {@link LanguageDescriptionTextInfo }
     *     
     */
    public void setLanguageDescriptionTextInfo(LanguageDescriptionTextInfo value) {
        this.languageDescriptionTextInfo = value;
    }

}
