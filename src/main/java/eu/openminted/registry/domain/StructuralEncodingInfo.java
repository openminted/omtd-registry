
package eu.openminted.registry.domain;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for structuralEncodingInfoType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="structuralEncodingInfoType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="structuralEncoding"&gt;
 *           &lt;complexType&gt;
 *             &lt;simpleContent&gt;
 *               &lt;extension base="&lt;http://www.w3.org/2001/XMLSchema&gt;string"&gt;
 *                 &lt;attribute name="schemeName" use="required"&gt;
 *                   &lt;simpleType&gt;
 *                     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *                       &lt;enumeration value="jats"/&gt;
 *                       &lt;enumeration value="teiP5"/&gt;
 *                       &lt;enumeration value="other"/&gt;
 *                     &lt;/restriction&gt;
 *                   &lt;/simpleType&gt;
 *                 &lt;/attribute&gt;
 *                 &lt;attribute name="schemeURI" type="{http://www.w3.org/2001/XMLSchema}anyURI" /&gt;
 *               &lt;/extension&gt;
 *             &lt;/simpleContent&gt;
 *           &lt;/complexType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="sizePerStructuralEncoding" type="{http://www.meta-share.org/OMTD-SHARE_XMLSchema}sizeInfoType" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "structuralEncodingInfoType", propOrder = {
    "structuralEncoding",
    "sizePerStructuralEncoding"
})
public class StructuralEncodingInfo {

    @XmlElement(required = true)
    protected StructuralEncoding structuralEncoding;
    protected SizeInfo sizePerStructuralEncoding;

    /**
     * Gets the value of the structuralEncoding property.
     * 
     * @return
     *     possible object is
     *     {@link StructuralEncoding }
     *     
     */
    public StructuralEncoding getStructuralEncoding() {
        return structuralEncoding;
    }

    /**
     * Sets the value of the structuralEncoding property.
     * 
     * @param value
     *     allowed object is
     *     {@link StructuralEncoding }
     *     
     */
    public void setStructuralEncoding(StructuralEncoding value) {
        this.structuralEncoding = value;
    }

    /**
     * Gets the value of the sizePerStructuralEncoding property.
     * 
     * @return
     *     possible object is
     *     {@link SizeInfo }
     *     
     */
    public SizeInfo getSizePerStructuralEncoding() {
        return sizePerStructuralEncoding;
    }

    /**
     * Sets the value of the sizePerStructuralEncoding property.
     * 
     * @param value
     *     allowed object is
     *     {@link SizeInfo }
     *     
     */
    public void setSizePerStructuralEncoding(SizeInfo value) {
        this.sizePerStructuralEncoding = value;
    }

}
