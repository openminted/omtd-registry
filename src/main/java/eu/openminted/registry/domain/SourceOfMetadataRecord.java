
package eu.openminted.registry.domain;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for anonymous complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="collectedFrom" type="{http://www.meta-share.org/OMTD-SHARE_XMLSchema}relatedRepositoryType"/&gt;
 *         &lt;element name="sourceMetadataLink" type="{http://www.meta-share.org/OMTD-SHARE_XMLSchema}httpURI"/&gt;
 *         &lt;element name="relatedMetadataScheme" minOccurs="0"&gt;
 *           &lt;simpleType&gt;
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *               &lt;maxLength value="500"/&gt;
 *             &lt;/restriction&gt;
 *           &lt;/simpleType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="originalDataProviderInfo" minOccurs="0"&gt;
 *           &lt;complexType&gt;
 *             &lt;complexContent&gt;
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                 &lt;sequence&gt;
 *                   &lt;element name="originalDataProviderType"&gt;
 *                     &lt;simpleType&gt;
 *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *                         &lt;enumeration value="repository"/&gt;
 *                         &lt;enumeration value="journal"/&gt;
 *                         &lt;enumeration value="publisher"/&gt;
 *                       &lt;/restriction&gt;
 *                     &lt;/simpleType&gt;
 *                   &lt;/element&gt;
 *                   &lt;choice&gt;
 *                     &lt;element name="originalDataProviderRepository" type="{http://www.meta-share.org/OMTD-SHARE_XMLSchema}relatedRepositoryType"/&gt;
 *                     &lt;element name="originalDataProviderJournal" type="{http://www.meta-share.org/OMTD-SHARE_XMLSchema}relatedJournalType"/&gt;
 *                     &lt;element name="originalDataProviderPublisher" type="{http://www.meta-share.org/OMTD-SHARE_XMLSchema}relatedOrganizationType"/&gt;
 *                   &lt;/choice&gt;
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
@XmlType(name = "", propOrder = {
    "collectedFrom",
    "sourceMetadataLink",
    "relatedMetadataScheme",
    "originalDataProviderInfo"
})
public class SourceOfMetadataRecord {

    @XmlElement(required = true)
    protected RelatedRepository collectedFrom;
    @XmlElement(required = true)
    @XmlSchemaType(name = "anyURI")
    protected String sourceMetadataLink;
    protected String relatedMetadataScheme;
    protected OriginalDataProviderInfo originalDataProviderInfo;

    /**
     * Gets the value of the collectedFrom property.
     * 
     * @return
     *     possible object is
     *     {@link RelatedRepository }
     *     
     */
    public RelatedRepository getCollectedFrom() {
        return collectedFrom;
    }

    /**
     * Sets the value of the collectedFrom property.
     * 
     * @param value
     *     allowed object is
     *     {@link RelatedRepository }
     *     
     */
    public void setCollectedFrom(RelatedRepository value) {
        this.collectedFrom = value;
    }

    /**
     * Gets the value of the sourceMetadataLink property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSourceMetadataLink() {
        return sourceMetadataLink;
    }

    /**
     * Sets the value of the sourceMetadataLink property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSourceMetadataLink(String value) {
        this.sourceMetadataLink = value;
    }

    /**
     * Gets the value of the relatedMetadataScheme property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRelatedMetadataScheme() {
        return relatedMetadataScheme;
    }

    /**
     * Sets the value of the relatedMetadataScheme property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRelatedMetadataScheme(String value) {
        this.relatedMetadataScheme = value;
    }

    /**
     * Gets the value of the originalDataProviderInfo property.
     * 
     * @return
     *     possible object is
     *     {@link OriginalDataProviderInfo }
     *     
     */
    public OriginalDataProviderInfo getOriginalDataProviderInfo() {
        return originalDataProviderInfo;
    }

    /**
     * Sets the value of the originalDataProviderInfo property.
     * 
     * @param value
     *     allowed object is
     *     {@link OriginalDataProviderInfo }
     *     
     */
    public void setOriginalDataProviderInfo(OriginalDataProviderInfo value) {
        this.originalDataProviderInfo = value;
    }

}
