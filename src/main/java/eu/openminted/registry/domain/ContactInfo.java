
package eu.openminted.registry.domain;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for contactInfoType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="contactInfoType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;choice&gt;
 *           &lt;element name="contactEmail" type="{http://www.meta-share.org/OMTD-SHARE_XMLSchema}emailAddress"/&gt;
 *           &lt;element name="landingPage" type="{http://www.meta-share.org/OMTD-SHARE_XMLSchema}httpURI"/&gt;
 *         &lt;/choice&gt;
 *         &lt;element name="contactPersons" minOccurs="0"&gt;
 *           &lt;complexType&gt;
 *             &lt;complexContent&gt;
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                 &lt;sequence&gt;
 *                   &lt;element name="contactPerson" type="{http://www.meta-share.org/OMTD-SHARE_XMLSchema}relatedPersonType" maxOccurs="unbounded" minOccurs="0"/&gt;
 *                 &lt;/sequence&gt;
 *               &lt;/restriction&gt;
 *             &lt;/complexContent&gt;
 *           &lt;/complexType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="contactGroups" minOccurs="0"&gt;
 *           &lt;complexType&gt;
 *             &lt;complexContent&gt;
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                 &lt;sequence&gt;
 *                   &lt;element name="contactGroup" type="{http://www.meta-share.org/OMTD-SHARE_XMLSchema}relatedGroupType" maxOccurs="unbounded" minOccurs="0"/&gt;
 *                 &lt;/sequence&gt;
 *               &lt;/restriction&gt;
 *             &lt;/complexContent&gt;
 *           &lt;/complexType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="mailingLists" minOccurs="0"&gt;
 *           &lt;complexType&gt;
 *             &lt;complexContent&gt;
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                 &lt;sequence&gt;
 *                   &lt;element name="mailingListInfo" type="{http://www.meta-share.org/OMTD-SHARE_XMLSchema}mailingListInfoType" maxOccurs="unbounded" minOccurs="0"/&gt;
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
@XmlType(name = "contactInfoType", propOrder = {
    "contactEmail","landingPage",
    "contactPersons",
    "contactGroups",
    "mailingLists"
})
public class ContactInfo {

//    @XmlElementRefs({
//        @XmlElementRef(name = "contactEmail", namespace = "http://www.meta-share.org/OMTD-SHARE_XMLSchema", type = JAXBElement.class, required = false),
//        @XmlElementRef(name = "landingPage", namespace = "http://www.meta-share.org/OMTD-SHARE_XMLSchema", type = JAXBElement.class, required = false)
//    })
//    protected JAXBElement<String> contactEmailOrLandingPage;
    
    protected String contactEmail;
    
    protected String landingPage;
    
    @XmlElementWrapper
    @XmlElement(name = "contactPerson", namespace = "http://www.meta-share.org/OMTD-SHARE_XMLSchema")
    protected List<RelatedPerson> contactPersons;
    @XmlElementWrapper
    @XmlElement(name = "contactGroup", namespace = "http://www.meta-share.org/OMTD-SHARE_XMLSchema")
    protected List<RelatedGroup> contactGroups;
    @XmlElementWrapper
    @XmlElement(name = "mailingListInfo", namespace = "http://www.meta-share.org/OMTD-SHARE_XMLSchema")
    protected List<MailingListInfo> mailingLists;
    
    

    public String getContactEmail() {
		return contactEmail;
	}

	public void setContactEmail(String contactEmail) {
		this.contactEmail = contactEmail;
	}

	public String getLandingPage() {
		return landingPage;
	}

	public void setLandingPage(String landingPage) {
		this.landingPage = landingPage;
	}

	public List<RelatedPerson> getContactPersons() {
        if (contactPersons == null) {
            contactPersons = new ArrayList<RelatedPerson>();
        }
        return contactPersons;
    }

    public void setContactPersons(List<RelatedPerson> contactPersons) {
        this.contactPersons = contactPersons;
    }

    public List<RelatedGroup> getContactGroups() {
        if (contactGroups == null) {
            contactGroups = new ArrayList<RelatedGroup>();
        }
        return contactGroups;
    }

    public void setContactGroups(List<RelatedGroup> contactGroups) {
        this.contactGroups = contactGroups;
    }

    public List<MailingListInfo> getMailingLists() {
        if (mailingLists == null) {
            mailingLists = new ArrayList<MailingListInfo>();
        }
        return mailingLists;
    }

    public void setMailingLists(List<MailingListInfo> mailingLists) {
        this.mailingLists = mailingLists;
    }

}
