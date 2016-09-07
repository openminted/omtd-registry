package eu.openminted.registry.domain;

import java.util.List;

/**
 * Created by stefania on 9/5/16.
 */
public class RelatedGroup {

    private List<String> groupNames;
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
