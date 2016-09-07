package eu.openminted.registry.domain;

/**
 * Created by stefania on 9/5/16.
 */
public class ActorInfo {

    //one of the 2
    private RelatedPerson relatedPerson;
    private RelatedOrganization relatedOrganization;

    public ActorInfo() {
    }

    public ActorInfo(RelatedPerson relatedPerson) {
        this.relatedPerson = relatedPerson;
    }

    public ActorInfo(RelatedOrganization relatedOrganization) {
        this.relatedOrganization = relatedOrganization;
    }

    public RelatedPerson getRelatedPerson() {
        return relatedPerson;
    }

    public void setRelatedPerson(RelatedPerson relatedPerson) {
        this.relatedPerson = relatedPerson;
    }

    public RelatedOrganization getRelatedOrganization() {
        return relatedOrganization;
    }

    public void setRelatedOrganization(RelatedOrganization relatedOrganization) {
        this.relatedOrganization = relatedOrganization;
    }
}
