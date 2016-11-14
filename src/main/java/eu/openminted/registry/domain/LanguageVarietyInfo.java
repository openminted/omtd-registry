
package eu.openminted.registry.domain;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for languageVarietyInfoType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="languageVarietyInfoType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="languageVarietyType"&gt;
 *           &lt;simpleType&gt;
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *               &lt;maxLength value="20"/&gt;
 *               &lt;enumeration value="dialect"/&gt;
 *               &lt;enumeration value="jargon"/&gt;
 *               &lt;enumeration value="other"/&gt;
 *             &lt;/restriction&gt;
 *           &lt;/simpleType&gt;
 *         &lt;/element&gt;
 *         &lt;element ref="{http://www.meta-share.org/OMTD-SHARE_XMLSchema}languageVarietyName"/&gt;
 *         &lt;element name="sizePerLanguageVariety" type="{http://www.meta-share.org/OMTD-SHARE_XMLSchema}sizeInfoType" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "languageVarietyInfoType", propOrder = {
    "languageVarietyType",
    "languageVarietyName",
    "sizePerLanguageVariety"
})
public class LanguageVarietyInfo {

    @XmlElement(required = true)
    protected LanguageVarietyTypeEnum languageVarietyType;
    @XmlElement(required = true)
    protected String languageVarietyName;
    protected SizeInfo sizePerLanguageVariety;

    /**
     * Gets the value of the languageVarietyType property.
     * 
     * @return
     *     possible object is
     *     {@link LanguageVarietyTypeEnum }
     *     
     */
    public LanguageVarietyTypeEnum getLanguageVarietyType() {
        return languageVarietyType;
    }

    /**
     * Sets the value of the languageVarietyType property.
     * 
     * @param value
     *     allowed object is
     *     {@link LanguageVarietyTypeEnum }
     *     
     */
    public void setLanguageVarietyType(LanguageVarietyTypeEnum value) {
        this.languageVarietyType = value;
    }

    /**
     * The name of the language variety that occurs in the resource or is supported by a tool/service
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLanguageVarietyName() {
        return languageVarietyName;
    }

    /**
     * Sets the value of the languageVarietyName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLanguageVarietyName(String value) {
        this.languageVarietyName = value;
    }

    /**
     * Gets the value of the sizePerLanguageVariety property.
     * 
     * @return
     *     possible object is
     *     {@link SizeInfo }
     *     
     */
    public SizeInfo getSizePerLanguageVariety() {
        return sizePerLanguageVariety;
    }

    /**
     * Sets the value of the sizePerLanguageVariety property.
     * 
     * @param value
     *     allowed object is
     *     {@link SizeInfo }
     *     
     */
    public void setSizePerLanguageVariety(SizeInfo value) {
        this.sizePerLanguageVariety = value;
    }

}
