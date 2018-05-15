package eu.openminted.registry.service.requests;

public class ProjectStateChangeMessage {

    private long projectId;
    private String projectName;

    private String projectPreviousState;
    private String projectState;

    public ProjectStateChangeMessage()
    {
        // Nothing to do
    }

    public long getProjectId()
    {
        return projectId;
    }

    public void setProjectId(long aProjectId)
    {
        projectId = aProjectId;
    }

    public String getProjectName()
    {
        return projectName;
    }

    public void setProjectName(String aProjectName)
    {
        projectName = aProjectName;
    }

    public String getProjectPreviousState()
    {
        return projectPreviousState;
    }

    public void setProjectPreviousState(String aProjectPreviousState)
    {
        projectPreviousState = aProjectPreviousState;
    }

    public String getProjectState()
    {
        return projectState;
    }

    public void setProjectState(String aProjectState)
    {
        projectState = aProjectState;
    }
}
