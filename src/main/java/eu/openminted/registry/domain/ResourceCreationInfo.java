package eu.openminted.registry.domain;

import java.util.List;

/**
 * Created by stefania on 9/5/16.
 */
public class ResourceCreationInfo {

    private List<ActorInfo> resourceCreators;
    private List<RelatedProject> fundingProjects;
    private DateCombinationType creationDate;

    public ResourceCreationInfo() {
    }

    public ResourceCreationInfo(List<ActorInfo> resourceCreators, List<RelatedProject> fundingProjects, DateCombinationType creationDate) {
        this.resourceCreators = resourceCreators;
        this.fundingProjects = fundingProjects;
        this.creationDate = creationDate;
    }

    public List<ActorInfo> getResourceCreators() {
        return resourceCreators;
    }

    public void setResourceCreators(List<ActorInfo> resourceCreators) {
        this.resourceCreators = resourceCreators;
    }

    public List<RelatedProject> getFundingProjects() {
        return fundingProjects;
    }

    public void setFundingProjects(List<RelatedProject> fundingProjects) {
        this.fundingProjects = fundingProjects;
    }

    public DateCombinationType getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(DateCombinationType creationDate) {
        this.creationDate = creationDate;
    }
}
