package eu.openminted.registry.domain;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;

/**
 * Created by stefania on 9/5/16.
 */
@XmlAccessorType(XmlAccessType.FIELD)
public class SourceOfMetadataRecord {

    //required
    @XmlElement(name = "collectedFrom")
    private RelatedRepository collectedFrom;
    //required
    @XmlElement(name="sourceMetadataLink")
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
