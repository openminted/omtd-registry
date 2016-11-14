
package eu.openminted.registry.domain;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * Base type for metadata header
 * 
 * <p>Java class for metadataHeaderInfoType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="metadataHeaderInfoType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="metadataRecordIdentifier" type="{http://www.meta-share.org/OMTD-SHARE_XMLSchema}metadataIdentifierType"/&gt;
 *         &lt;element name="metadataCreationDate" type="{http://www.w3.org/2001/XMLSchema}date"/&gt;
 *         &lt;element name="metadataCreators" minOccurs="0"&gt;
 *           &lt;complexType&gt;
 *             &lt;complexContent&gt;
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                 &lt;sequence&gt;
 *                   &lt;element name="metadataCreator" type="{http://www.meta-share.org/OMTD-SHARE_XMLSchema}relatedPersonType" maxOccurs="unbounded" minOccurs="0"/&gt;
 *                 &lt;/sequence&gt;
 *               &lt;/restriction&gt;
 *             &lt;/complexContent&gt;
 *           &lt;/complexType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="sourceOfMetadataRecord" minOccurs="0"&gt;
 *           &lt;complexType&gt;
 *             &lt;complexContent&gt;
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                 &lt;sequence&gt;
 *                   &lt;element name="collectedFrom" type="{http://www.meta-share.org/OMTD-SHARE_XMLSchema}relatedRepositoryType"/&gt;
 *                   &lt;element name="sourceMetadataLink" type="{http://www.meta-share.org/OMTD-SHARE_XMLSchema}httpURI"/&gt;
 *                   &lt;element name="relatedMetadataScheme" minOccurs="0"&gt;
 *                     &lt;simpleType&gt;
 *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *                         &lt;maxLength value="500"/&gt;
 *                       &lt;/restriction&gt;
 *                     &lt;/simpleType&gt;
 *                   &lt;/element&gt;
 *                   &lt;element name="originalDataProviderInfo" minOccurs="0"&gt;
 *                     &lt;complexType&gt;
 *                       &lt;complexContent&gt;
 *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                           &lt;sequence&gt;
 *                             &lt;element name="originalDataProviderType"&gt;
 *                               &lt;simpleType&gt;
 *                                 &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *                                   &lt;enumeration value="repository"/&gt;
 *                                   &lt;enumeration value="journal"/&gt;
 *                                   &lt;enumeration value="publisher"/&gt;
 *                                 &lt;/restriction&gt;
 *                               &lt;/simpleType&gt;
 *                             &lt;/element&gt;
 *                             &lt;choice&gt;
 *                               &lt;element name="originalDataProviderRepository" type="{http://www.meta-share.org/OMTD-SHARE_XMLSchema}relatedRepositoryType"/&gt;
 *                               &lt;element name="originalDataProviderJournal" type="{http://www.meta-share.org/OMTD-SHARE_XMLSchema}relatedJournalType"/&gt;
 *                               &lt;element name="originalDataProviderPublisher" type="{http://www.meta-share.org/OMTD-SHARE_XMLSchema}relatedOrganizationType"/&gt;
 *                             &lt;/choice&gt;
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
 *         &lt;element name="metadataLanguages" minOccurs="0"&gt;
 *           &lt;complexType&gt;
 *             &lt;complexContent&gt;
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                 &lt;sequence&gt;
 *                   &lt;element name="metadataLanguage" type="{http://www.meta-share.org/OMTD-SHARE_XMLSchema}languageType" maxOccurs="unbounded" minOccurs="0"/&gt;
 *                 &lt;/sequence&gt;
 *               &lt;/restriction&gt;
 *             &lt;/complexContent&gt;
 *           &lt;/complexType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="metadataLastDateUpdated" type="{http://www.w3.org/2001/XMLSchema}date"/&gt;
 *         &lt;element name="revision" minOccurs="0"&gt;
 *           &lt;simpleType&gt;
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *               &lt;maxLength value="500"/&gt;
 *             &lt;/restriction&gt;
 *           &lt;/simpleType&gt;
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
@XmlType(name = "metadataHeaderInfoType", propOrder = {
    "metadataRecordIdentifier",
    "metadataCreationDate",
    "metadataCreators",
    "sourceOfMetadataRecord",
    "metadataLanguages",
    "metadataLastDateUpdated",
    "revision"
})
public class MetadataHeaderInfo {

    @XmlElement(required = true)
    protected MetadataIdentifier metadataRecordIdentifier;
    @XmlElement(required = true)
    @XmlSchemaType(name = "date")
    protected XMLGregorianCalendar metadataCreationDate;
    @XmlElementWrapper
    @XmlElement(name = "metadataCreator", namespace = "http://www.meta-share.org/OMTD-SHARE_XMLSchema")
    protected List<RelatedPerson> metadataCreators;
    protected SourceOfMetadataRecord sourceOfMetadataRecord;
    @XmlElementWrapper
    @XmlElement(name = "metadataLanguage", namespace = "http://www.meta-share.org/OMTD-SHARE_XMLSchema")
    protected List<Language> metadataLanguages;
    @XmlElement(required = true)
    @XmlSchemaType(name = "date")
    protected XMLGregorianCalendar metadataLastDateUpdated;
    protected String revision;

    /**
     * Gets the value of the metadataRecordIdentifier property.
     * 
     * @return
     *     possible object is
     *     {@link MetadataIdentifier }
     *     
     */
    public MetadataIdentifier getMetadataRecordIdentifier() {
        return metadataRecordIdentifier;
    }

    /**
     * Sets the value of the metadataRecordIdentifier property.
     * 
     * @param value
     *     allowed object is
     *     {@link MetadataIdentifier }
     *     
     */
    public void setMetadataRecordIdentifier(MetadataIdentifier value) {
        this.metadataRecordIdentifier = value;
    }

    /**
     * Gets the value of the metadataCreationDate property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getMetadataCreationDate() {
        return metadataCreationDate;
    }

    /**
     * Sets the value of the metadataCreationDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setMetadataCreationDate(XMLGregorianCalendar value) {
        this.metadataCreationDate = value;
    }

    /**
     * Gets the value of the sourceOfMetadataRecord property.
     * 
     * @return
     *     possible object is
     *     {@link SourceOfMetadataRecord }
     *     
     */
    public SourceOfMetadataRecord getSourceOfMetadataRecord() {
        return sourceOfMetadataRecord;
    }

    /**
     * Sets the value of the sourceOfMetadataRecord property.
     * 
     * @param value
     *     allowed object is
     *     {@link SourceOfMetadataRecord }
     *     
     */
    public void setSourceOfMetadataRecord(SourceOfMetadataRecord value) {
        this.sourceOfMetadataRecord = value;
    }

    /**
     * Gets the value of the metadataLastDateUpdated property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getMetadataLastDateUpdated() {
        return metadataLastDateUpdated;
    }

    /**
     * Sets the value of the metadataLastDateUpdated property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setMetadataLastDateUpdated(XMLGregorianCalendar value) {
        this.metadataLastDateUpdated = value;
    }

    /**
     * Gets the value of the revision property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRevision() {
        return revision;
    }

    /**
     * Sets the value of the revision property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRevision(String value) {
        this.revision = value;
    }

    public List<RelatedPerson> getMetadataCreators() {
        if (metadataCreators == null) {
            metadataCreators = new ArrayList<RelatedPerson>();
        }
        return metadataCreators;
    }

    public void setMetadataCreators(List<RelatedPerson> metadataCreators) {
        this.metadataCreators = metadataCreators;
    }

    public List<Language> getMetadataLanguages() {
        if (metadataLanguages == null) {
            metadataLanguages = new ArrayList<Language>();
        }
        return metadataLanguages;
    }

    public void setMetadataLanguages(List<Language> metadataLanguages) {
        this.metadataLanguages = metadataLanguages;
    }

}
