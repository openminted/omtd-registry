
package eu.openminted.registry.domain;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
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
 *         &lt;element name="originalDataProviderType"&gt;
 *           &lt;simpleType&gt;
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *               &lt;enumeration value="repository"/&gt;
 *               &lt;enumeration value="journal"/&gt;
 *               &lt;enumeration value="publisher"/&gt;
 *             &lt;/restriction&gt;
 *           &lt;/simpleType&gt;
 *         &lt;/element&gt;
 *         &lt;choice&gt;
 *           &lt;element name="originalDataProviderRepository" type="{http://www.meta-share.org/OMTD-SHARE_XMLSchema}relatedRepositoryType"/&gt;
 *           &lt;element name="originalDataProviderJournal" type="{http://www.meta-share.org/OMTD-SHARE_XMLSchema}relatedJournalType"/&gt;
 *           &lt;element name="originalDataProviderPublisher" type="{http://www.meta-share.org/OMTD-SHARE_XMLSchema}relatedOrganizationType"/&gt;
 *         &lt;/choice&gt;
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
    "originalDataProviderType",
    "originalDataProviderRepository","originalDataProviderJournal","originalDataProviderPublisher"
})
public class OriginalDataProviderInfo {

    @XmlElement(required = true)
    protected OriginalDataProviderTypeEnum originalDataProviderType;
    // @XmlElements({
    //     @XmlElement(name = "originalDataProviderRepository", type = RelatedRepository.class),
    //     @XmlElement(name = "originalDataProviderJournal", type = RelatedJournal.class),
    //     @XmlElement(name = "originalDataProviderPublisher", type = RelatedOrganization.class)
    // })
    // protected Object originalDataProviderRepositoryOrOriginalDataProviderJournalOrOriginalDataProviderPublisher;

    
    protected RelatedRepository originalDataProviderRepository;
    protected RelatedJournal originalDataProviderJournal;
    protected RelatedOrganization originalDataProviderPublisher;

    /**
     * Gets the value of the originalDataProviderType property.
     * 
     * @return
     *     possible object is
     *     {@link OriginalDataProviderTypeEnum }
     *     
     */
    public OriginalDataProviderTypeEnum getOriginalDataProviderType() {
        return originalDataProviderType;
    }

    /**
     * Sets the value of the originalDataProviderType property.
     * 
     * @param value
     *     allowed object is
     *     {@link OriginalDataProviderTypeEnum }
     *     
     */
    public void setOriginalDataProviderType(OriginalDataProviderTypeEnum value) {
        this.originalDataProviderType = value;
    }

	public RelatedRepository getOriginalDataProviderRepository() {
		return originalDataProviderRepository;
	}

	public void setOriginalDataProviderRepository(
			RelatedRepository originalDataProviderRepository) {
		this.originalDataProviderRepository = originalDataProviderRepository;
	}

	public RelatedJournal getOriginalDataProviderJournal() {
		return originalDataProviderJournal;
	}

	public void setOriginalDataProviderJournal(
			RelatedJournal originalDataProviderJournal) {
		this.originalDataProviderJournal = originalDataProviderJournal;
	}

	public RelatedOrganization getOriginalDataProviderPublisher() {
		return originalDataProviderPublisher;
	}

	public void setOriginalDataProviderPublisher(
			RelatedOrganization originalDataProviderPublisher) {
		this.originalDataProviderPublisher = originalDataProviderPublisher;
	}
    
}
