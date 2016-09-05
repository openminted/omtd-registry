package eu.openminted.registry.domain;

import java.util.List;

/**
 * Created by stefania on 9/5/16.
 */
public class ResourceDocumentationInfo {

    private RelatedDocument mustBeCitedWith;
    private List<RelatedDocument> documentationPublications;
    private List<String> samplesLocations;

    public ResourceDocumentationInfo() {
    }

    public ResourceDocumentationInfo(RelatedDocument mustBeCitedWith, List<RelatedDocument> documentationPublications,
                                     List<String> samplesLocations) {
        this.mustBeCitedWith = mustBeCitedWith;
        this.documentationPublications = documentationPublications;
        this.samplesLocations = samplesLocations;
    }

    public RelatedDocument getMustBeCitedWith() {
        return mustBeCitedWith;
    }

    public void setMustBeCitedWith(RelatedDocument mustBeCitedWith) {
        this.mustBeCitedWith = mustBeCitedWith;
    }

    public List<RelatedDocument> getDocumentationPublications() {
        return documentationPublications;
    }

    public void setDocumentationPublications(List<RelatedDocument> documentationPublications) {
        this.documentationPublications = documentationPublications;
    }

    public List<String> getSamplesLocations() {
        return samplesLocations;
    }

    public void setSamplesLocations(List<String> samplesLocations) {
        this.samplesLocations = samplesLocations;
    }
}
