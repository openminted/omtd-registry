
package eu.openminted.registry.domain;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.XmlValue;


/**
 * Base type for identifier schemes for resources (corpora, lexical/conceptual resources etc.)
 * 
 * <p>Java class for resourceIdentifierType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="resourceIdentifierType"&gt;
 *   &lt;simpleContent&gt;
 *     &lt;extension base="&lt;http://www.w3.org/2001/XMLSchema&gt;string"&gt;
 *       &lt;attribute name="resourceIdentifierSchemeName" use="required"&gt;
 *         &lt;simpleType&gt;
 *           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *             &lt;enumeration value="doi"/&gt;
 *             &lt;enumeration value="islrn"/&gt;
 *             &lt;enumeration value="hdl"/&gt;
 *             &lt;enumeration value="ark"/&gt;
 *             &lt;enumeration value="arXiv"/&gt;
 *             &lt;enumeration value="bibcode"/&gt;
 *             &lt;enumeration value="ean13"/&gt;
 *             &lt;enumeration value="eissn"/&gt;
 *             &lt;enumeration value="isbn"/&gt;
 *             &lt;enumeration value="issn"/&gt;
 *             &lt;enumeration value="istc"/&gt;
 *             &lt;enumeration value="lissn"/&gt;
 *             &lt;enumeration value="lsid"/&gt;
 *             &lt;enumeration value="purl"/&gt;
 *             &lt;enumeration value="upc"/&gt;
 *             &lt;enumeration value="url"/&gt;
 *             &lt;enumeration value="urn"/&gt;
 *             &lt;enumeration value="fct"/&gt;
 *             &lt;enumeration value="oai"/&gt;
 *             &lt;enumeration value="pmc"/&gt;
 *             &lt;enumeration value="pmid"/&gt;
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
@XmlType(name = "resourceIdentifierType", propOrder = {
    "value"
})
public class ResourceIdentifier {

    @XmlValue
    protected String value;
    @XmlAttribute(name = "resourceIdentifierSchemeName", required = true)
    protected ResourceIdentifierSchemeNameEnum resourceIdentifierSchemeName;
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
     * Gets the value of the resourceIdentifierSchemeName property.
     * 
     * @return
     *     possible object is
     *     {@link ResourceIdentifierSchemeNameEnum }
     *     
     */
    public ResourceIdentifierSchemeNameEnum getResourceIdentifierSchemeName() {
        return resourceIdentifierSchemeName;
    }

    /**
     * Sets the value of the resourceIdentifierSchemeName property.
     * 
     * @param value
     *     allowed object is
     *     {@link ResourceIdentifierSchemeNameEnum }
     *     
     */
    public void setResourceIdentifierSchemeName(ResourceIdentifierSchemeNameEnum value) {
        this.resourceIdentifierSchemeName = value;
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
