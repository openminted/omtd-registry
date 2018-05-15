package eu.openminted.registry.service.requests;

public class AnnotationStateChangeMessage {

    private long projectId;
    private String projectName;

    private long documentId;
    private String documentName;

    private String annotationUser;

    private String annotationPreviousState;
    private String annotationState;

    public AnnotationStateChangeMessage()
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

    public String getAnnotationPreviousState()
    {
        return annotationPreviousState;
    }

    public void setAnnotationPreviousState(String aAnnotationPreviousState)
    {
        annotationPreviousState = aAnnotationPreviousState;
    }

    public String getAnnotationState()
    {
        return annotationState;
    }

    public void setAnnotationState(String aAnnotationState)
    {
        annotationState = aAnnotationState;
    }

    public String getAnnotationUser()
    {
        return annotationUser;
    }

    public void setAnnotationUser(String aAnnotationUser)
    {
        annotationUser = aAnnotationUser;
    }

}
