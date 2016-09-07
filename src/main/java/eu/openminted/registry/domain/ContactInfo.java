package eu.openminted.registry.domain;

import java.util.List;

/**
 * Created by stefania on 9/5/16.
 */
public class ContactInfo {

    //one of the 2
    private String contactEmail;
    private String landingPage;

    private List<RelatedPerson> contactPersons;
    private List<RelatedGroup> contactGroups;
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
