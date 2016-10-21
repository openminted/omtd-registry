
package eu.openminted.registry.domain;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for characterEncodingInfoType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="characterEncodingInfoType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element ref="{http://www.meta-share.org/OMTD-SHARE_XMLSchema}characterEncoding"/&gt;
 *         &lt;element name="sizePerCharacterEncoding" type="{http://www.meta-share.org/OMTD-SHARE_XMLSchema}sizeInfoType" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "characterEncodingInfoType", propOrder = {
    "characterEncoding",
    "sizePerCharacterEncoding"
})
public class CharacterEncodingInfo {

    @XmlElement(required = true)
    protected CharacterEncodingEnum characterEncoding;
    protected SizeInfo sizePerCharacterEncoding;

    /**
     * Gets the value of the characterEncoding property.
     * 
     * @return
     *     possible object is
     *     {@link CharacterEncodingEnum }
     *     
     */
    public CharacterEncodingEnum getCharacterEncoding() {
        return characterEncoding;
    }

    /**
     * Sets the value of the characterEncoding property.
     * 
     * @param value
     *     allowed object is
     *     {@link CharacterEncodingEnum }
     *     
     */
    public void setCharacterEncoding(CharacterEncodingEnum value) {
        this.characterEncoding = value;
    }

    /**
     * Gets the value of the sizePerCharacterEncoding property.
     * 
     * @return
     *     possible object is
     *     {@link SizeInfo }
     *     
     */
    public SizeInfo getSizePerCharacterEncoding() {
        return sizePerCharacterEncoding;
    }

    /**
     * Sets the value of the sizePerCharacterEncoding property.
     * 
     * @param value
     *     allowed object is
     *     {@link SizeInfo }
     *     
     */
    public void setSizePerCharacterEncoding(SizeInfo value) {
        this.sizePerCharacterEncoding = value;
    }

}
