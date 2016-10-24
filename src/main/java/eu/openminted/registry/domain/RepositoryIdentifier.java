
package eu.openminted.registry.domain;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.XmlValue;


/**
 * Base type for identifier schemes for repositories, archives etc.
 * 
 * <p>Java class for repositoryIdentifierType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="repositoryIdentifierType"&gt;
 *   &lt;simpleContent&gt;
 *     &lt;extension base="&lt;http://www.w3.org/2001/XMLSchema&gt;string"&gt;
 *       &lt;attribute name="repositoryIdentifierSchemeName" use="required"&gt;
 *         &lt;simpleType&gt;
 *           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *             &lt;enumeration value="doi"/&gt;
 *             &lt;enumeration value="hdl"/&gt;
 *             &lt;enumeration value="url"/&gt;
 *             &lt;enumeration value="oai"/&gt;
 *             &lt;enumeration value="opendoar"/&gt;
 *             &lt;enumeration value="re3d"/&gt;
 *             &lt;enumeration value="roar"/&gt;
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
@XmlType(name = "repositoryIdentifierType", propOrder = {
    "value"
})
public class RepositoryIdentifier {

    @XmlValue
    protected String value;
    @XmlAttribute(name = "repositoryIdentifierSchemeName", required = true)
    protected RepositoryIdentifierSchemeNameEnum repositoryIdentifierSchemeName;
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
     * Gets the value of the repositoryIdentifierSchemeName property.
     * 
     * @return
     *     possible object is
     *     {@link RepositoryIdentifierSchemeNameEnum }
     *     
     */
    public RepositoryIdentifierSchemeNameEnum getRepositoryIdentifierSchemeName() {
        return repositoryIdentifierSchemeName;
    }

    /**
     * Sets the value of the repositoryIdentifierSchemeName property.
     * 
     * @param value
     *     allowed object is
     *     {@link RepositoryIdentifierSchemeNameEnum }
     *     
     */
    public void setRepositoryIdentifierSchemeName(RepositoryIdentifierSchemeNameEnum value) {
        this.repositoryIdentifierSchemeName = value;
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
