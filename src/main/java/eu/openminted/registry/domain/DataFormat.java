
package eu.openminted.registry.domain;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;


/**
 * Specifies the format that is used since often the mime type will not be sufficient for machine processing; NOTE: normally the format should be represented as a combination of the mimetype (e.g. application/xml) and some name and link to the documentation about the supplementary conventions used (e.g xces, alvisED etc.)
 * 
 * <p>Java class for dataFormat element declaration.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;element name="dataFormat"&gt;
 *   &lt;complexType&gt;
 *     &lt;complexContent&gt;
 *       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *         &lt;sequence&gt;
 *           &lt;element ref="{http://www.meta-share.org/OMTD-SHARE_XMLSchema}mimeType"/&gt;
 *           &lt;element name="dataFormatSpecific" minOccurs="0"&gt;
 *             &lt;simpleType&gt;
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *                 &lt;maxLength value="100"/&gt;
 *                 &lt;enumeration value="aclAnthology"/&gt;
 *                 &lt;enumeration value="alvisEnrichedDocument"/&gt;
 *                 &lt;enumeration value="bnc"/&gt;
 *                 &lt;enumeration value="bioNLP"/&gt;
 *                 &lt;enumeration value="bioNLP; format-variant=ST2013a1_a2"/&gt;
 *                 &lt;enumeration value="cadixeJSON"/&gt;
 *                 &lt;enumeration value="conll2000"/&gt;
 *                 &lt;enumeration value="conll2002"/&gt;
 *                 &lt;enumeration value="conll2006"/&gt;
 *                 &lt;enumeration value="conll2007"/&gt;
 *                 &lt;enumeration value="conll2009"/&gt;
 *                 &lt;enumeration value="conll2012"/&gt;
 *                 &lt;enumeration value="dataSift"/&gt;
 *                 &lt;enumeration value="factoredTagLem"/&gt;
 *                 &lt;enumeration value="gate"/&gt;
 *                 &lt;enumeration value="genia"/&gt;
 *                 &lt;enumeration value="graf"/&gt;
 *                 &lt;enumeration value="html5Microdata"/&gt;
 *                 &lt;enumeration value="i2b2"/&gt;
 *                 &lt;enumeration value="imsCwb"/&gt;
 *                 &lt;enumeration value="jdbc"/&gt;
 *                 &lt;enumeration value="keaCorpus"/&gt;
 *                 &lt;enumeration value="lll"/&gt;
 *                 &lt;enumeration value="lll"/&gt;
 *                 &lt;enumeration value="lll"/&gt;
 *                 &lt;enumeration value="lll"/&gt;
 *                 &lt;enumeration value="lll"/&gt;
 *                 &lt;enumeration value="lll"/&gt;
 *                 &lt;enumeration value="negraExport"/&gt;
 *                 &lt;enumeration value="ptb; format-variant=chunked"/&gt;
 *                 &lt;enumeration value="ptb; format-variant=combined"/&gt;
 *                 &lt;enumeration value="pml"/&gt;
 *                 &lt;enumeration value="relp"/&gt;
 *                 &lt;enumeration value="aimedCorpus"/&gt;
 *                 &lt;enumeration value="tiger"/&gt;
 *                 &lt;enumeration value="tupp-dz"/&gt;
 *                 &lt;enumeration value="twitter"/&gt;
 *                 &lt;enumeration value="xces; format-variant=ilsp"/&gt;
 *                 &lt;enumeration value="web1t"/&gt;
 *                 &lt;enumeration value="uimaCASDump"/&gt;
 *                 &lt;enumeration value="uimaBinaryCas"/&gt;
 *               &lt;/restriction&gt;
 *             &lt;/simpleType&gt;
 *           &lt;/element&gt;
 *           &lt;element name="documentationURL" type="{http://www.w3.org/2001/XMLSchema}anyURI" minOccurs="0"/&gt;
 *         &lt;/sequence&gt;
 *       &lt;/restriction&gt;
 *     &lt;/complexContent&gt;
 *   &lt;/complexType&gt;
 * &lt;/element&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "mimeType",
    "dataFormatSpecific",
    "documentationURL"
})
@XmlRootElement(name = "dataFormat")
public class DataFormat {

    @XmlElement(required = true)
    protected MimeTypeEnum mimeType;
    protected DataFormatSpecificEnum dataFormatSpecific;
    @XmlSchemaType(name = "anyURI")
    protected String documentationURL;

    /**
     * Gets the value of the mimeType property.
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
     * Gets the value of the dataFormatSpecific property.
     * 
     * @return
     *     possible object is
     *     {@link DataFormatSpecificEnum }
     *     
     */
    public DataFormatSpecificEnum getDataFormatSpecific() {
        return dataFormatSpecific;
    }

    /**
     * Sets the value of the dataFormatSpecific property.
     * 
     * @param value
     *     allowed object is
     *     {@link DataFormatSpecificEnum }
     *     
     */
    public void setDataFormatSpecific(DataFormatSpecificEnum value) {
        this.dataFormatSpecific = value;
    }

    /**
     * Gets the value of the documentationURL property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDocumentationURL() {
        return documentationURL;
    }

    /**
     * Sets the value of the documentationURL property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDocumentationURL(String value) {
        this.documentationURL = value;
    }

}
