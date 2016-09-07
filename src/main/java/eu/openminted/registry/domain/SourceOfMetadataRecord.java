package eu.openminted.registry.domain;

/**
 * Created by stefania on 9/5/16.
 */
public class SourceOfMetadataRecord {

    //required
    private RelatedRepository collectedFrom;
    //required
    private String sourceMetadataLink;
    private String relatedMetadataScheme;
    private OriginalDataProviderInfo originalDataProviderInfo;

    public SourceOfMetadataRecord() {
    }

    public SourceOfMetadataRecord(RelatedRepository collectedFrom, String sourceMetadataLink, String relatedMetadataScheme,
                                  OriginalDataProviderInfo originalDataProviderInfo) {
        this.collectedFrom = collectedFrom;
        this.sourceMetadataLink = sourceMetadataLink;
        this.relatedMetadataScheme = relatedMetadataScheme;
        this.originalDataProviderInfo = originalDataProviderInfo;
    }

    public RelatedRepository getCollectedFrom() {
        return collectedFrom;
    }

    public void setCollectedFrom(RelatedRepository collectedFrom) {
        this.collectedFrom = collectedFrom;
    }

    public String getSourceMetadataLink() {
        return sourceMetadataLink;
    }

    public void setSourceMetadataLink(String sourceMetadataLink) {
        this.sourceMetadataLink = sourceMetadataLink;
    }

    public String getRelatedMetadataScheme() {
        return relatedMetadataScheme;
    }

    public void setRelatedMetadataScheme(String relatedMetadataScheme) {
        this.relatedMetadataScheme = relatedMetadataScheme;
    }

    public OriginalDataProviderInfo getOriginalDataProviderInfo() {
        return originalDataProviderInfo;
    }

    public void setOriginalDataProviderInfo(OriginalDataProviderInfo originalDataProviderInfo) {
        this.originalDataProviderInfo = originalDataProviderInfo;
    }
}
