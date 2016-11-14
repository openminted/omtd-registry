
package eu.openminted.registry.domain;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for corpusMetadataRecord element declaration.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;element name="corpusMetadataRecord"&gt;
 *   &lt;complexType&gt;
 *     &lt;complexContent&gt;
 *       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *         &lt;sequence&gt;
 *           &lt;element ref="{http://www.meta-share.org/OMTD-SHARE_XMLSchema}metadataHeaderInfo"/&gt;
 *           &lt;element ref="{http://www.meta-share.org/OMTD-SHARE_XMLSchema}corpusInfo"/&gt;
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
    "corpusInfo"
})
@XmlRootElement(name = "corpusMetadataRecord")
public class Corpus {

    @XmlElement(required = true)
    protected MetadataHeaderInfo metadataHeaderInfo;
    @XmlElement(required = true)
    protected CorpusInfo corpusInfo;

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
     * Gets the value of the corpusInfo property.
     * 
     * @return
     *     possible object is
     *     {@link CorpusInfo }
     *     
     */
    public CorpusInfo getCorpusInfo() {
        return corpusInfo;
    }

    /**
     * Sets the value of the corpusInfo property.
     * 
     * @param value
     *     allowed object is
     *     {@link CorpusInfo }
     *     
     */
    public void setCorpusInfo(CorpusInfo value) {
        this.corpusInfo = value;
    }

}
