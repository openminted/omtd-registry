package eu.openminted.registry.domain;

import java.util.List;

/**
 * Created by stefania on 9/5/16.
 */
public class Corpus {

    //required
    private MetadataHeaderInfo metadataHeaderInfo;
    //required
    private final String resourceType = "corpus";
    //required
    private ResourceIdentificationInfo resourceIdentificationInfo;
    //required
    private ContactInfo contactInfo;
    private VersionInfo versionInfo;
    private List<ValidationInfo> validationInfos;
    private UsageInfo usageInfo;
    private ResourceDocumentationInfo resourceDocumentationInfo;
    private ResourceCreationInfo resourceCreationInfo;
    //required
    private List<DatasetDistributionInfo> distributionInfos;
    //required (either RawCorpusInfo, AnnotatedCorpusInfo, or AnnotationsInfo)
    private CorpusSubTypeSpecificInfo corpusSubTypeSpecificInfo;

    public Corpus() {
    }

    public Corpus(MetadataHeaderInfo metadataHeaderInfo, ResourceIdentificationInfo resourceIdentificationInfo,
                  ContactInfo contactInfo, List<DatasetDistributionInfo> distributionInfos,
                  CorpusSubTypeSpecificInfo corpusSubTypeSpecificInfo) {
        this.metadataHeaderInfo = metadataHeaderInfo;
        this.resourceIdentificationInfo = resourceIdentificationInfo;
        this.contactInfo = contactInfo;
        this.distributionInfos = distributionInfos;
        this.corpusSubTypeSpecificInfo = corpusSubTypeSpecificInfo;
    }

    public Corpus(MetadataHeaderInfo metadataHeaderInfo, ResourceIdentificationInfo resourceIdentificationInfo,
                  ContactInfo contactInfo, VersionInfo versionInfo, List<ValidationInfo> validationInfos,
                  UsageInfo usageInfo, ResourceDocumentationInfo resourceDocumentationInfo, ResourceCreationInfo resourceCreationInfo,
                  List<DatasetDistributionInfo> distributionInfos, CorpusSubTypeSpecificInfo corpusSubTypeSpecificInfo) {
        this.metadataHeaderInfo = metadataHeaderInfo;
        this.resourceIdentificationInfo = resourceIdentificationInfo;
        this.contactInfo = contactInfo;
        this.versionInfo = versionInfo;
        this.validationInfos = validationInfos;
        this.usageInfo = usageInfo;
        this.resourceDocumentationInfo = resourceDocumentationInfo;
        this.resourceCreationInfo = resourceCreationInfo;
        this.distributionInfos = distributionInfos;
        this.corpusSubTypeSpecificInfo = corpusSubTypeSpecificInfo;
    }

    public MetadataHeaderInfo getMetadataHeaderInfo() {
        return metadataHeaderInfo;
    }

    public void setMetadataHeaderInfo(MetadataHeaderInfo metadataHeaderInfo) {
        this.metadataHeaderInfo = metadataHeaderInfo;
    }

    public String getResourceType() {
        return resourceType;
    }

    public ResourceIdentificationInfo getResourceIdentificationInfo() {
        return resourceIdentificationInfo;
    }

    public void setResourceIdentificationInfo(ResourceIdentificationInfo resourceIdentificationInfo) {
        this.resourceIdentificationInfo = resourceIdentificationInfo;
    }

    public ContactInfo getContactInfo() {
        return contactInfo;
    }

    public void setContactInfo(ContactInfo contactInfo) {
        this.contactInfo = contactInfo;
    }

    public VersionInfo getVersionInfo() {
        return versionInfo;
    }

    public void setVersionInfo(VersionInfo versionInfo) {
        this.versionInfo = versionInfo;
    }

    public List<ValidationInfo> getValidationInfos() {
        return validationInfos;
    }

    public void setValidationInfos(List<ValidationInfo> validationInfos) {
        this.validationInfos = validationInfos;
    }

    public UsageInfo getUsageInfo() {
        return usageInfo;
    }

    public void setUsageInfo(UsageInfo usageInfo) {
        this.usageInfo = usageInfo;
    }

    public ResourceDocumentationInfo getResourceDocumentationInfo() {
        return resourceDocumentationInfo;
    }

    public void setResourceDocumentationInfo(ResourceDocumentationInfo resourceDocumentationInfo) {
        this.resourceDocumentationInfo = resourceDocumentationInfo;
    }

    public ResourceCreationInfo getResourceCreationInfo() {
        return resourceCreationInfo;
    }

    public void setResourceCreationInfo(ResourceCreationInfo resourceCreationInfo) {
        this.resourceCreationInfo = resourceCreationInfo;
    }

    public List<DatasetDistributionInfo> getDistributionInfos() {
        return distributionInfos;
    }

    public void setDistributionInfos(List<DatasetDistributionInfo> distributionInfos) {
        this.distributionInfos = distributionInfos;
    }

    public CorpusSubTypeSpecificInfo getCorpusSubTypeSpecificInfo() {
        return corpusSubTypeSpecificInfo;
    }

    public void setCorpusSubTypeSpecificInfo(CorpusSubTypeSpecificInfo corpusSubTypeSpecificInfo) {
        this.corpusSubTypeSpecificInfo = corpusSubTypeSpecificInfo;
    }
}
