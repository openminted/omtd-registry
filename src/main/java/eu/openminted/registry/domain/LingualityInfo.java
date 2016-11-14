
package eu.openminted.registry.domain;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for lingualityInfoType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="lingualityInfoType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="lingualityType"&gt;
 *           &lt;simpleType&gt;
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *               &lt;maxLength value="20"/&gt;
 *               &lt;enumeration value="monolingual"/&gt;
 *               &lt;enumeration value="bilingual"/&gt;
 *               &lt;enumeration value="multilingual"/&gt;
 *             &lt;/restriction&gt;
 *           &lt;/simpleType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="multilingualityType" minOccurs="0"&gt;
 *           &lt;simpleType&gt;
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *               &lt;maxLength value="30"/&gt;
 *               &lt;enumeration value="parallel"/&gt;
 *               &lt;enumeration value="comparable"/&gt;
 *               &lt;enumeration value="multilingualSingleText"/&gt;
 *               &lt;enumeration value="originalTranslationsInSameText"/&gt;
 *               &lt;enumeration value="other"/&gt;
 *             &lt;/restriction&gt;
 *           &lt;/simpleType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="multilingualityTypeDetails" minOccurs="0"&gt;
 *           &lt;simpleType&gt;
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *               &lt;maxLength value="512"/&gt;
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
@XmlType(name = "lingualityInfoType", propOrder = {
    "lingualityType",
    "multilingualityType",
    "multilingualityTypeDetails"
})
public class LingualityInfo {

    @XmlElement(required = true)
    protected LingualityTypeEnum lingualityType;
    protected MultilingualityTypeEnum multilingualityType;
    protected String multilingualityTypeDetails;

    /**
     * Gets the value of the lingualityType property.
     * 
     * @return
     *     possible object is
     *     {@link LingualityTypeEnum }
     *     
     */
    public LingualityTypeEnum getLingualityType() {
        return lingualityType;
    }

    /**
     * Sets the value of the lingualityType property.
     * 
     * @param value
     *     allowed object is
     *     {@link LingualityTypeEnum }
     *     
     */
    public void setLingualityType(LingualityTypeEnum value) {
        this.lingualityType = value;
    }

    /**
     * Gets the value of the multilingualityType property.
     * 
     * @return
     *     possible object is
     *     {@link MultilingualityTypeEnum }
     *     
     */
    public MultilingualityTypeEnum getMultilingualityType() {
        return multilingualityType;
    }

    /**
     * Sets the value of the multilingualityType property.
     * 
     * @param value
     *     allowed object is
     *     {@link MultilingualityTypeEnum }
     *     
     */
    public void setMultilingualityType(MultilingualityTypeEnum value) {
        this.multilingualityType = value;
    }

    /**
     * Gets the value of the multilingualityTypeDetails property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMultilingualityTypeDetails() {
        return multilingualityTypeDetails;
    }

    /**
     * Sets the value of the multilingualityTypeDetails property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMultilingualityTypeDetails(String value) {
        this.multilingualityTypeDetails = value;
    }

}
