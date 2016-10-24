
package eu.openminted.registry.domain;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for languageInfoType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="languageInfoType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element ref="{http://www.meta-share.org/OMTD-SHARE_XMLSchema}language"/&gt;
 *         &lt;element name="sizePerLanguage" type="{http://www.meta-share.org/OMTD-SHARE_XMLSchema}sizeInfoType" minOccurs="0"/&gt;
 *         &lt;element name="languageVarieties" minOccurs="0"&gt;
 *           &lt;complexType&gt;
 *             &lt;complexContent&gt;
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                 &lt;sequence&gt;
 *                   &lt;element ref="{http://www.meta-share.org/OMTD-SHARE_XMLSchema}languageVarietyInfo" maxOccurs="unbounded" minOccurs="0"/&gt;
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
@XmlType(name = "languageInfoType", propOrder = {
    "language",
    "sizePerLanguage",
    "languageVarieties"
})
public class LanguageInfo {

    @XmlElement(required = true)
    protected Language language;
    protected SizeInfo sizePerLanguage;
    @XmlElementWrapper
    @XmlElement(name = "languageVarietyInfo", namespace = "http://www.meta-share.org/OMTD-SHARE_XMLSchema")
    protected List<LanguageVarietyInfo> languageVarieties;

    /**
     * The identifier of the language that is included in the resource or supported by the tool/service, according to the IETF BCP47 guidelines
     * 
     * @return
     *     possible object is
     *     {@link Language }
     *     
     */
    public Language getLanguage() {
        return language;
    }

    /**
     * Sets the value of the language property.
     * 
     * @param value
     *     allowed object is
     *     {@link Language }
     *     
     */
    public void setLanguage(Language value) {
        this.language = value;
    }

    /**
     * Gets the value of the sizePerLanguage property.
     * 
     * @return
     *     possible object is
     *     {@link SizeInfo }
     *     
     */
    public SizeInfo getSizePerLanguage() {
        return sizePerLanguage;
    }

    /**
     * Sets the value of the sizePerLanguage property.
     * 
     * @param value
     *     allowed object is
     *     {@link SizeInfo }
     *     
     */
    public void setSizePerLanguage(SizeInfo value) {
        this.sizePerLanguage = value;
    }

    public List<LanguageVarietyInfo> getLanguageVarieties() {
        if (languageVarieties == null) {
            languageVarieties = new ArrayList<LanguageVarietyInfo>();
        }
        return languageVarieties;
    }

    public void setLanguageVarieties(List<LanguageVarietyInfo> languageVarieties) {
        this.languageVarieties = languageVarieties;
    }

}
