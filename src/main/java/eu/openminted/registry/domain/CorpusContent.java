package eu.openminted.registry.domain;

import java.util.List;

/**
 * Class representing a corpus of publications.
 *
 * @author spyroukostas
 */

public class CorpusContent {

    private int totalPublications;
    private String archiveId;
    private List<String> filepaths;
    private List<PublicationInfo> pubInfo = null;

    public CorpusContent() {

    }

    public CorpusContent(String archiveId) {
        this.archiveId = archiveId;
    }

    public String getArchiveId() {
        return archiveId;
    }

    public void setArchiveId(String archiveId) {
        this.archiveId = archiveId;
    }

    public int getTotalPublications() {
        return totalPublications;
    }

    public void setTotalPublications(int totalPublications) {
        this.totalPublications = totalPublications;
    }

    public List<PublicationInfo> getPubInfo() {
        return pubInfo;
    }

    public void setPubInfo(List<PublicationInfo> publications) {
        this.pubInfo = publications;
    }

    public List<String> getFilepaths() {
        return filepaths;
    }

    public void setFilepaths(List<String> filepaths) {
        this.filepaths = filepaths;
    }


}
