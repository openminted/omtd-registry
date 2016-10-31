
package eu.openminted.registry.domain;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for lcrMetadataRecord element declaration.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;element name="lcrMetadataRecord"&gt;
 *   &lt;complexType&gt;
 *     &lt;complexContent&gt;
 *       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *         &lt;sequence&gt;
 *           &lt;element ref="{http://www.meta-share.org/OMTD-SHARE_XMLSchema}metadataHeaderInfo"/&gt;
 *           &lt;element ref="{http://www.meta-share.org/OMTD-SHARE_XMLSchema}lexicalConceptualResourceInfo"/&gt;
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
    "metadataHeaderInfo",
    "lexicalConceptualResourceInfo"
})
@XmlRootElement(name = "lcrMetadataRecord")
public class Lexical {

    @XmlElement(required = true)
    protected MetadataHeaderInfo metadataHeaderInfo;
    @XmlElement(required = true)
    protected LexicalConceptualResourceInfo lexicalConceptualResourceInfo;

    /**
     * Gets the value of the metadataHeaderInfo property.
     * 
     * @return
     *     possible object is
     *     {@link MetadataHeaderInfo }
     *     
     */
    public MetadataHeaderInfo getMetadataHeaderInfo() {
        return metadataHeaderInfo;
    }

    /**
     * Sets the value of the metadataHeaderInfo property.
     * 
     * @param value
     *     allowed object is
     *     {@link MetadataHeaderInfo }
     *     
     */
    public void setMetadataHeaderInfo(MetadataHeaderInfo value) {
        this.metadataHeaderInfo = value;
    }

    /**
     * Gets the value of the lexicalConceptualResourceInfo property.
     * 
     * @return
     *     possible object is
     *     {@link LexicalConceptualResourceInfo }
     *     
     */
    public LexicalConceptualResourceInfo getLexicalConceptualResourceInfo() {
        return lexicalConceptualResourceInfo;
    }

    /**
     * Sets the value of the lexicalConceptualResourceInfo property.
     * 
     * @param value
     *     allowed object is
     *     {@link LexicalConceptualResourceInfo }
     *     
     */
    public void setLexicalConceptualResourceInfo(LexicalConceptualResourceInfo value) {
        this.lexicalConceptualResourceInfo = value;
    }

}
