package eu.openminted.registry.domain;

/**
 * A class used to represent a publication inside a Corpus.
 *
 * @author spyroukostas
 */

public class PublicationInfo {

    private String id;
    private String title;
    private String archiveId;
    private boolean hasAbstract = false;
    private boolean hasFulltext = false;
    private boolean hasMetadata = false;
    private boolean hasAnnotations = false;
    private String abstract_path;
    private String fulltext_path;
    private String metadata_path;
    private String annotations_path;

    public PublicationInfo() {

    }

    public PublicationInfo(String id, String archiveId) {
        this.id = id;
        this.title = id;
        this.archiveId = archiveId;
    }

    public PublicationInfo(String id, String title, String archiveId) {
        this.id = id;
        this.title = title;
        this.archiveId = archiveId;
    }

    public PublicationInfo(String id, String title, String archiveId, boolean hasAbstract,
                           boolean hasFulltext, boolean hasMetadata, boolean hasAnnotations) {
        this.id = id;
        this.title = title;
        this.archiveId = archiveId;
        this.hasAbstract = hasAbstract;
        this.hasFulltext = hasFulltext;
        this.hasMetadata = hasMetadata;
        this.hasAnnotations = hasAnnotations;
    }

    public PublicationInfo(String id, String title, String archiveId, boolean hasAbstract,
                           boolean hasFulltext, boolean hasMetadata, boolean hasAnnotations,
                           String abstract_path, String fulltext_path, String metadata_path,
                           String annotations_path) {
        this.id = id;
        this.title = title;
        this.archiveId = archiveId;
        this.hasAbstract = hasAbstract;
        this.hasFulltext = hasFulltext;
        this.hasMetadata = hasMetadata;
        this.hasAnnotations = hasAnnotations;
        this.abstract_path = abstract_path;
        this.fulltext_path = fulltext_path;
        this.metadata_path = metadata_path;
        this.annotations_path = annotations_path;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getArchiveId() {
        return archiveId;
    }

    public void setArchiveId(String archiveId) {
        this.archiveId = archiveId;
    }

    public boolean isHasFulltext() {
        return hasFulltext;
    }

    public void setHasFulltext(boolean hasFulltext) {
        this.hasFulltext = hasFulltext;
    }

    public boolean isHasAbstract() {
        return hasAbstract;
    }

    public void setHasAbstract(boolean hasAbstract) {
        this.hasAbstract = hasAbstract;
    }

    public boolean isHasMetadata() {
        return hasMetadata;
    }

    public void setHasMetadata(boolean hasMetadata) {
        this.hasMetadata = hasMetadata;
    }

    public boolean isHasAnnotations() {
        return hasAnnotations;
    }

    public void setHasAnnotations(boolean hasAnnotations) {
        this.hasAnnotations = hasAnnotations;
    }

    public String getAbstract_path() {
        return abstract_path;
    }

    public void setAbstract_path(String abstract_path) {
        this.abstract_path = abstract_path;
    }

    public String getFulltext_path() {
        return fulltext_path;
    }

    public void setFulltext_path(String fulltext_path) {
        this.fulltext_path = fulltext_path;
    }

    public String getMetadata_path() {
        return metadata_path;
    }

    public void setMetadata_path(String metadata_path) {
        this.metadata_path = metadata_path;
    }

    public String getAnnotations_path() {
        return annotations_path;
    }

    public void setAnnotations_path(String annotations_path) {
        this.annotations_path = annotations_path;
    }

}
