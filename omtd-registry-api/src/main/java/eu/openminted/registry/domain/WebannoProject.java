package eu.openminted.registry.domain;

public class WebannoProject {

    private String project_name;

    public WebannoProject() {
    }

    public WebannoProject(String project_name) {
        this.project_name = project_name;
    }

    public String getProject_name() {
        return project_name;
    }

    public void setProject_name(String project_name) {
        this.project_name = project_name;
    }
}
