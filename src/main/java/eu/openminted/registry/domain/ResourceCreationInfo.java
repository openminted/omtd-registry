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
public class ResourceCreationInfo {

    @XmlElementWrapper(name = "resourceCreators")
    @XmlElement(name="resourceCreator")
    private List<ActorInfo> resourceCreators;
    
    @XmlElementWrapper(name = "fundingProjects")
    @XmlElement(name="fundingProject")
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
