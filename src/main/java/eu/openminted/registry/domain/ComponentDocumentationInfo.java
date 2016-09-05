package eu.openminted.registry.domain;

/**
 * Created by stefania on 9/5/16.
 */
public class ComponentDocumentationInfo {

    private String onLineHelpURL;
    private RelatedDocument hasManual;
    private String issueTracker;

    public ComponentDocumentationInfo() {
    }

    public ComponentDocumentationInfo(String onLineHelpURL, RelatedDocument hasManual, String issueTracker) {
        this.onLineHelpURL = onLineHelpURL;
        this.hasManual = hasManual;
        this.issueTracker = issueTracker;
    }

    public String getOnLineHelpURL() {
        return onLineHelpURL;
    }

    public void setOnLineHelpURL(String onLineHelpURL) {
        this.onLineHelpURL = onLineHelpURL;
    }

    public RelatedDocument getHasManual() {
        return hasManual;
    }

    public void setHasManual(RelatedDocument hasManual) {
        this.hasManual = hasManual;
    }

    public String getIssueTracker() {
        return issueTracker;
    }

    public void setIssueTracker(String issueTracker) {
        this.issueTracker = issueTracker;
    }
}
