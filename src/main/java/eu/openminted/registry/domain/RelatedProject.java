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
public class RelatedProject {

    //one of the two
	@XmlElementWrapper(name = "projectNames")
    @XmlElement(name="projectName")
    private List<String> projectNames;
	
	@XmlElementWrapper(name = "projectIdentifiers")
    @XmlElement(name="projectIdentifier")
    private List<ProjectIdentifier> projectIdentifiers;

    public RelatedProject() {
    }

    public List<String> getProjectNames() {
        return projectNames;
    }

    public void setProjectNames(List<String> projectNames) {
        this.projectNames = projectNames;
    }

    public List<ProjectIdentifier> getProjectIdentifiers() {
        return projectIdentifiers;
    }

    public void setProjectIdentifiers(List<ProjectIdentifier> projectIdentifiers) {
        this.projectIdentifiers = projectIdentifiers;
    }
}
