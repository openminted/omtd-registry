
package eu.openminted.registry.domain;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * Groups together all information related to raw corpora
 * 
 * <p>Java class for rawCorpusInfoType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="rawCorpusInfoType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="corpusSubtype" type="{http://www.w3.org/2001/XMLSchema}anyType"/&gt;
 *         &lt;element name="corpusMediaPartsType"&gt;
 *           &lt;complexType&gt;
 *             &lt;complexContent&gt;
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                 &lt;sequence&gt;
 *                   &lt;element name="corpusTextParts"&gt;
 *                     &lt;complexType&gt;
 *                       &lt;complexContent&gt;
 *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                           &lt;sequence&gt;
 *                             &lt;element ref="{http://www.meta-share.org/OMTD-SHARE_XMLSchema}corpusTextPartInfo" maxOccurs="unbounded"/&gt;
 *                           &lt;/sequence&gt;
 *                         &lt;/restriction&gt;
 *                       &lt;/complexContent&gt;
 *                     &lt;/complexType&gt;
 *                   &lt;/element&gt;
 *                 &lt;/sequence&gt;
 *               &lt;/restriction&gt;
 *             &lt;/complexContent&gt;
 *           &lt;/complexType&gt;
 *         &lt;/element&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "rawCorpusInfoType", propOrder = {
    "corpusSubtype",
    "corpusMediaPartsType"
})
public class RawCorpusInfo {

    @XmlElement(required = true)
    protected String corpusSubtype;
    @XmlElement(required = true)
    protected CorpusMediaPartsType corpusMediaPartsType;

    /**
     * Gets the value of the corpusSubtype property.
     * 
     * @return
     *     possible object is
     *     {@link Object }
     *     
     */
    public String getCorpusSubtype() {
        return corpusSubtype;
    }

    /**
     * Sets the value of the corpusSubtype property.
     * 
     * @param value
     *     allowed object is
     *     {@link Object }
     *     
     */
    public void setCorpusSubtype(String value) {
        this.corpusSubtype = value;
    }

    /**
     * Gets the value of the corpusMediaPartsType property.
     * 
     * @return
     *     possible object is
     *     {@link CorpusMediaPartsType }
     *     
     */
    public CorpusMediaPartsType getCorpusMediaPartsType() {
        return corpusMediaPartsType;
    }

    /**
     * Sets the value of the corpusMediaPartsType property.
     * 
     * @param value
     *     allowed object is
     *     {@link CorpusMediaPartsType }
     *     
     */
    public void setCorpusMediaPartsType(CorpusMediaPartsType value) {
        this.corpusMediaPartsType = value;
    }

}
