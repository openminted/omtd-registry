
package eu.openminted.registry.domain;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.XmlValue;


/**
 * Specifies the type of the text according to a text type classification
 * 
 * <p>Java class for textType element declaration.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;element name="textType"&gt;
 *   &lt;complexType&gt;
 *     &lt;simpleContent&gt;
 *       &lt;extension base="&lt;http://www.w3.org/2001/XMLSchema&gt;string"&gt;
 *         &lt;attribute name="classificationSchemeName" use="required" type="{http://www.meta-share.org/OMTD-SHARE_XMLSchema}classificationSchemeName" /&gt;
 *         &lt;attribute name="schemeURI" type="{http://www.w3.org/2001/XMLSchema}anyURI" /&gt;
 *       &lt;/extension&gt;
 *     &lt;/simpleContent&gt;
 *   &lt;/complexType&gt;
 * &lt;/element&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "value"
})
@XmlRootElement(name = "textType")
public class Text {

    @XmlValue
    protected String value;
    @XmlAttribute(name = "classificationSchemeName", required = true)
    protected ClassificationSchemeName classificationSchemeName;
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
     * Gets the value of the classificationSchemeName property.
     * 
     * @return
     *     possible object is
     *     {@link ClassificationSchemeName }
     *     
     */
    public ClassificationSchemeName getClassificationSchemeName() {
        return classificationSchemeName;
    }

    /**
     * Sets the value of the classificationSchemeName property.
     * 
     * @param value
     *     allowed object is
     *     {@link ClassificationSchemeName }
     *     
     */
    public void setClassificationSchemeName(ClassificationSchemeName value) {
        this.classificationSchemeName = value;
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
