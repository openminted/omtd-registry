package eu.openminted.registry.controllers.requests;

public class DocumentStateChangeMessage {

    private long projectId;
    private String projectName;

    private long documentId;
    private String documentName;

    private String documentPreviousState;
    private String documentState;

    public DocumentStateChangeMessage()
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

    public long getDocumentId()
    {
        return documentId;
    }

    public void setDocumentId(long aDocumentId)
    {
        documentId = aDocumentId;
    }

    public String getDocumentName()
    {
        return documentName;
    }

    public void setDocumentName(String aDocumentName)
    {
        documentName = aDocumentName;
    }

    public String getDocumentPreviousState()
    {
        return documentPreviousState;
    }

    public void setDocumentPreviousState(String aDocumentPreviousState)
    {
        documentPreviousState = aDocumentPreviousState;
    }

    public String getDocumentState()
    {
        return documentState;
    }

    public void setDocumentState(String aDocumentState)
    {
        documentState = aDocumentState;
    }
}
