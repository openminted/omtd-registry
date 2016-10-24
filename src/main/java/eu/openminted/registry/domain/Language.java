
package eu.openminted.registry.domain;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;


/**
 * The container for the language elements (i.e. identifier according to BCP47 guidelines and all the elements that produce this id)
 * 
 * <p>Java class for languageType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="languageType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="languageTag"&gt;
 *           &lt;simpleType&gt;
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *               &lt;maxLength value="100"/&gt;
 *             &lt;/restriction&gt;
 *           &lt;/simpleType&gt;
 *         &lt;/element&gt;
 *         &lt;sequence minOccurs="0"&gt;
 *           &lt;element name="languageId" type="{http://www.meta-share.org/OMTD-SHARE_XMLSchema}languageIdType"/&gt;
 *           &lt;element name="scriptId" type="{http://www.meta-share.org/OMTD-SHARE_XMLSchema}scriptIdType" minOccurs="0"/&gt;
 *           &lt;element name="regiontId" type="{http://www.meta-share.org/OMTD-SHARE_XMLSchema}regionIdType" minOccurs="0"/&gt;
 *           &lt;element name="variantId" type="{http://www.meta-share.org/OMTD-SHARE_XMLSchema}variantIdType" minOccurs="0"/&gt;
 *         &lt;/sequence&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "languageType", propOrder = {
    "languageTag",
    "languageId",
    "scriptId",
    "regiontId",
    "variantId"
})
public class Language {

    @XmlElement(required = true)
    protected String languageTag;
    protected String languageId;
    @XmlSchemaType(name = "string")
    protected ScriptIdType scriptId;
    @XmlSchemaType(name = "string")
    protected RegionIdType regiontId;
    @XmlSchemaType(name = "string")
    protected VariantIdType variantId;

    /**
     * Gets the value of the languageTag property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLanguageTag() {
        return languageTag;
    }

    /**
     * Sets the value of the languageTag property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLanguageTag(String value) {
        this.languageTag = value;
    }

    /**
     * Gets the value of the languageId property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLanguageId() {
        return languageId;
    }

    /**
     * Sets the value of the languageId property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLanguageId(String value) {
        this.languageId = value;
    }

    /**
     * Gets the value of the scriptId property.
     * 
     * @return
     *     possible object is
     *     {@link ScriptIdType }
     *     
     */
    public ScriptIdType getScriptId() {
        return scriptId;
    }

    /**
     * Sets the value of the scriptId property.
     * 
     * @param value
     *     allowed object is
     *     {@link ScriptIdType }
     *     
     */
    public void setScriptId(ScriptIdType value) {
        this.scriptId = value;
    }

    /**
     * Gets the value of the regiontId property.
     * 
     * @return
     *     possible object is
     *     {@link RegionIdType }
     *     
     */
    public RegionIdType getRegiontId() {
        return regiontId;
    }

    /**
     * Sets the value of the regiontId property.
     * 
     * @param value
     *     allowed object is
     *     {@link RegionIdType }
     *     
     */
    public void setRegiontId(RegionIdType value) {
        this.regiontId = value;
    }

    /**
     * Gets the value of the variantId property.
     * 
     * @return
     *     possible object is
     *     {@link VariantIdType }
     *     
     */
    public VariantIdType getVariantId() {
        return variantId;
    }

    /**
     * Sets the value of the variantId property.
     * 
     * @param value
     *     allowed object is
     *     {@link VariantIdType }
     *     
     */
    public void setVariantId(VariantIdType value) {
        this.variantId = value;
    }

}
