package eu.openminted.registry.domain;

/**
 * Created by stefania on 9/5/16.
 */
public class OriginalDataProviderInfo {

    enum OriginalDataProviderType {

        REPOSITORY("repository"),
        JOURNAL("journal"),
        PUBLISHER("publisher");

        private String value;

        OriginalDataProviderType(String value) {
            this.value = value;
        }

        public String getValue() {
            return value;
        }
    }

    //required
    private OriginalDataProviderType originalDataProviderType;

    //one of the 3
    private RelatedRepository relatedRepository;
    private RelatedJournal relatedJournal;
    private RelatedOrganization relatedOrganization;

    public OriginalDataProviderInfo() {
    }

    public OriginalDataProviderInfo(OriginalDataProviderType originalDataProviderType, RelatedRepository relatedRepository) {
        this.originalDataProviderType = originalDataProviderType;
        this.relatedRepository = relatedRepository;
    }

    public OriginalDataProviderInfo(OriginalDataProviderType originalDataProviderType, RelatedJournal relatedJournal) {
        this.originalDataProviderType = originalDataProviderType;
        this.relatedJournal = relatedJournal;
    }

    public OriginalDataProviderInfo(OriginalDataProviderType originalDataProviderType, RelatedOrganization relatedOrganization) {
        this.originalDataProviderType = originalDataProviderType;
        this.relatedOrganization = relatedOrganization;
    }

    public OriginalDataProviderType getOriginalDataProviderType() {
        return originalDataProviderType;
    }

    public void setOriginalDataProviderType(OriginalDataProviderType originalDataProviderType) {
        this.originalDataProviderType = originalDataProviderType;
    }

    public RelatedRepository getRelatedRepository() {
        return relatedRepository;
    }

    public void setRelatedRepository(RelatedRepository relatedRepository) {
        this.relatedRepository = relatedRepository;
    }

    public RelatedJournal getRelatedJournal() {
        return relatedJournal;
    }

    public void setRelatedJournal(RelatedJournal relatedJournal) {
        this.relatedJournal = relatedJournal;
    }

    public RelatedOrganization getRelatedOrganization() {
        return relatedOrganization;
    }

    public void setRelatedOrganization(RelatedOrganization relatedOrganization) {
        this.relatedOrganization = relatedOrganization;
    }
}
