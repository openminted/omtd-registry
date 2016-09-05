package eu.openminted.registry.domain;

import java.util.List;

/**
 * Created by stefania on 9/5/16.
 */
public class RelatedProject {

    //one of the two
    private List<String> projectNames;
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
