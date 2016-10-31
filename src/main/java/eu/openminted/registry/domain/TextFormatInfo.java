
package eu.openminted.registry.domain;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for textFormatInfoType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="textFormatInfoType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element ref="{http://www.meta-share.org/OMTD-SHARE_XMLSchema}mimeType"/&gt;
 *         &lt;element name="sizePerTextFormat" type="{http://www.meta-share.org/OMTD-SHARE_XMLSchema}sizeInfoType" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "textFormatInfoType", propOrder = {
    "mimeType",
    "sizePerTextFormat"
})
public class TextFormatInfo {

    @XmlElement(required = true)
    protected MimeTypeEnum mimeType;
    protected SizeInfo sizePerTextFormat;

    /**
     * The mime-type of the resource which is a formalized specifier for the format included or a mime-type that the tool/service accepts, in conformance with the values of the IANA (Internet Assigned Numbers Authority); you can select one of the pre-defined values or add a value, PREFERABLY FROM THE IANA MEDIA MIMETYPE RECOMMENDED VALUES (http://www.iana.org/assignments/media-types/media-types.xhtml)
     * 
     * @return
     *     possible object is
     *     {@link MimeTypeEnum }
     *     
     */
    public MimeTypeEnum getMimeType() {
        return mimeType;
    }

    /**
     * Sets the value of the mimeType property.
     * 
     * @param value
     *     allowed object is
     *     {@link MimeTypeEnum }
     *     
     */
    public void setMimeType(MimeTypeEnum value) {
        this.mimeType = value;
    }

    /**
     * Gets the value of the sizePerTextFormat property.
     * 
     * @return
     *     possible object is
     *     {@link SizeInfo }
     *     
     */
    public SizeInfo getSizePerTextFormat() {
        return sizePerTextFormat;
    }

    /**
     * Sets the value of the sizePerTextFormat property.
     * 
     * @param value
     *     allowed object is
     *     {@link SizeInfo }
     *     
     */
    public void setSizePerTextFormat(SizeInfo value) {
        this.sizePerTextFormat = value;
    }

}
