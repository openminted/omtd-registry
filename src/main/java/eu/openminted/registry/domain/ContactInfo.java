package eu.openminted.registry.domain;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import java.util.List;

/**
 * Created by stefania on 9/5/16.
 */
@XmlAccessorType(XmlAccessType.FIELD)
public class ContactInfo {

    //one of the 2
    @XmlElement(name="contactEmail")
    private String contactEmail;
    @XmlElement(name="landingPage")
    private String landingPage;

    @XmlElementWrapper(name = "contactPersons")
    @XmlElement(name="contactPerson")
    private List<RelatedPerson> contactPersons;
    
    @XmlElementWrapper(name = "contactGroups")
    @XmlElement(name="contactGroup")
    private List<RelatedGroup> contactGroups;
    
    @XmlElementWrapper(name = "mailingLists")
    @XmlElement(name="mailingList")
    private List<MailingListInfo> mailingLists;

    public ContactInfo() {
    }

    public ContactInfo(String contactEmail, String landingPage, List<RelatedPerson> contactPersons,
                       List<RelatedGroup> contactGroups, List<MailingListInfo> mailingLists) {
        this.contactEmail = contactEmail;
        this.landingPage = landingPage;
        this.contactPersons = contactPersons;
        this.contactGroups = contactGroups;
        this.mailingLists = mailingLists;
    }

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
        return contactPersons;
    }

    public void setContactPersons(List<RelatedPerson> contactPersons) {
        this.contactPersons = contactPersons;
    }

    public List<RelatedGroup> getContactGroups() {
        return contactGroups;
    }

    public void setContactGroups(List<RelatedGroup> contactGroups) {
        this.contactGroups = contactGroups;
    }

    public List<MailingListInfo> getMailingLists() {
        return mailingLists;
    }

    public void setMailingLists(List<MailingListInfo> mailingLists) {
        this.mailingLists = mailingLists;
    }
}
