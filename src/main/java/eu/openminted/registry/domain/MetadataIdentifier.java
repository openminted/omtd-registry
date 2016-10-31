
package eu.openminted.registry.domain;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.XmlValue;


/**
 * Base type for identifier schemes for metadata records
 * 
 * <p>Java class for metadataIdentifierType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="metadataIdentifierType"&gt;
 *   &lt;simpleContent&gt;
 *     &lt;extension base="&lt;http://www.w3.org/2001/XMLSchema&gt;string"&gt;
 *       &lt;attribute name="metadataIdentifierSchemeName" use="required"&gt;
 *         &lt;simpleType&gt;
 *           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *             &lt;enumeration value="hdl"/&gt;
 *             &lt;enumeration value="purl"/&gt;
 *             &lt;enumeration value="url"/&gt;
 *             &lt;enumeration value="urn"/&gt;
 *             &lt;enumeration value="other"/&gt;
 *           &lt;/restriction&gt;
 *         &lt;/simpleType&gt;
 *       &lt;/attribute&gt;
 *       &lt;attribute name="schemeURI" type="{http://www.w3.org/2001/XMLSchema}anyURI" /&gt;
 *     &lt;/extension&gt;
 *   &lt;/simpleContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "metadataIdentifierType", propOrder = {
    "value"
})
public class MetadataIdentifier {

    @XmlValue
    protected String value;
    @XmlAttribute(name = "metadataIdentifierSchemeName", required = true)
    protected MetadataIdentifierSchemeNameEnum metadataIdentifierSchemeName;
    @XmlAttribute(name = "schemeURI")
    @XmlSchemaType(name = "anyURI")
    protected String schemeURI;

    /**
     * Gets the value of the value property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getValue() {
        return value;
    }

    /**
     * Sets the value of the value property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setValue(String value) {
        this.value = value;
    }

    /**
     * Gets the value of the metadataIdentifierSchemeName property.
     * 
     * @return
     *     possible object is
     *     {@link MetadataIdentifierSchemeNameEnum }
     *     
     */
    public MetadataIdentifierSchemeNameEnum getMetadataIdentifierSchemeName() {
        return metadataIdentifierSchemeName;
    }

    /**
     * Sets the value of the metadataIdentifierSchemeName property.
     * 
     * @param value
     *     allowed object is
     *     {@link MetadataIdentifierSchemeNameEnum }
     *     
     */
    public void setMetadataIdentifierSchemeName(MetadataIdentifierSchemeNameEnum value) {
        this.metadataIdentifierSchemeName = value;
    }

    /**
     * Gets the value of the schemeURI property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSchemeURI() {
        return schemeURI;
    }

    /**
     * Sets the value of the schemeURI property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSchemeURI(String value) {
        this.schemeURI = value;
    }

}
