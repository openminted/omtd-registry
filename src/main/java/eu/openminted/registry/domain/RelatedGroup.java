package eu.openminted.registry.domain;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;

/**
 * Created by stefania on 9/5/16.
 */
@XmlAccessorType(XmlAccessType.FIELD)
public class RelatedGroup {

	@XmlElementWrapper(name = "groupNames")
    @XmlElement(name="groupName")
    private List<String> groupNames;
	
	@XmlElement(name="relatedOrganization")
    private RelatedOrganization relatedOrganization;

    public RelatedGroup() {
    }

    public RelatedGroup(List<String> groupNames, RelatedOrganization relatedOrganization) {
        this.groupNames = groupNames;
        this.relatedOrganization = relatedOrganization;
    }

    public List<String> getGroupNames() {
        return groupNames;
    }

    public void setGroupNames(List<String> groupNames) {
        this.groupNames = groupNames;
    }

    public RelatedOrganization getRelatedOrganization() {
        return relatedOrganization;
    }

    public void setRelatedOrganization(RelatedOrganization relatedOrganization) {
        this.relatedOrganization = relatedOrganization;
    }
}
