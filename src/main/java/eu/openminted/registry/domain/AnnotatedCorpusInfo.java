
package eu.openminted.registry.domain;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * Groups together all information related to annotated corpora
 * 
 * <p>Java class for annotatedCorpusInfoType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="annotatedCorpusInfoType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="corpusSubtype" type="{http://www.w3.org/2001/XMLSchema}anyType"/&gt;
 *         &lt;element name="corpusMediaParts"&gt;
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
 *                   &lt;element name="annotations"&gt;
 *                     &lt;complexType&gt;
 *                       &lt;complexContent&gt;
 *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                           &lt;sequence&gt;
 *                             &lt;element ref="{http://www.meta-share.org/OMTD-SHARE_XMLSchema}annotationInfo" maxOccurs="unbounded"/&gt;
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
@XmlType(name = "annotatedCorpusInfoType", propOrder = {
    "corpusSubtype",
    "corpusMediaParts"
})
public class AnnotatedCorpusInfo {

    @XmlElement(required = true)
    protected String corpusSubtype;
    @XmlElement(required = true)
    protected CorpusMediaParts corpusMediaParts;

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
     * Gets the value of the corpusMediaParts property.
     * 
     * @return
     *     possible object is
     *     {@link CorpusMediaParts }
     *     
     */
    public CorpusMediaParts getCorpusMediaParts() {
        return corpusMediaParts;
    }

    /**
     * Sets the value of the corpusMediaParts property.
     * 
     * @param value
     *     allowed object is
     *     {@link CorpusMediaParts }
     *     
     */
    public void setCorpusMediaParts(CorpusMediaParts value) {
        this.corpusMediaParts = value;
    }

}
