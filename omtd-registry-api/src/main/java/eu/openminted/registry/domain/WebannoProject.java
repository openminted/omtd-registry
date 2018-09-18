package eu.openminted.registry.domain;

import com.fasterxml.jackson.annotation.JsonProperty;

public class WebannoProject {

    @JsonProperty("project_name")
    private String projectName;

    public WebannoProject() {
    }

    public WebannoProject(String projectName) {
        this.projectName = projectName;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }
}
