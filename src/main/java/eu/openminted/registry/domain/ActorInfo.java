package eu.openminted.registry.domain;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;

/**
 * Created by stefania on 9/5/16.
 */
@XmlAccessorType(XmlAccessType.FIELD)
public class ActorInfo {

    //one of the 2
    @XmlElement(name="relatedPerson")
    private RelatedPerson relatedPerson;
    @XmlElement(name="relatedOrganization")
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
