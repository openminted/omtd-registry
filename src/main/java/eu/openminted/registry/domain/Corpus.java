package eu.openminted.registry.domain;

import org.eclipse.persistence.oxm.annotations.XmlPath;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

/**
 * Created by stefania on 9/5/16.
 */
@XmlRootElement(name = "corpusMetadataRecord", namespace = "http://www.meta-share.org/OMTD-SHARE_XMLSchema")
public class Corpus {

    //required
    @XmlElement(name = "metadataHeaderInfo", required = true)
    private MetadataHeaderInfo metadataHeaderInfo;
    //required
    @XmlPath("corpusInfo/resourceType/text()")
    private final String resourceType = "corpus";
    //required
    @XmlPath("ms:corpusInfo/ms:identificationInfo")
    private ResourceIdentificationInfo resourceIdentificationInfo;
    //required
    @XmlPath("ms:corpusInfo/ms:contactInfo")
    private ContactInfo contactInfo;
    @XmlPath("ms:corpusInfo/ms:versionInfo")
    private VersionInfo versionInfo;
    @XmlElementWrapper(name="validationInfos")
    @XmlElement(name="validationInfo")
    private List<ValidationInfo> validationInfos;
    private UsageInfo usageInfo;
    private ResourceDocumentationInfo resourceDocumentationInfo;
    private ResourceCreationInfo resourceCreationInfo;
    //required
    @XmlPath("ms:corpusInfo/ms:distributionInfos/ms:datasetDistributionInfo")
    private List<DatasetDistributionInfo> distributionInfos;
    //required (either RawCorpusInfo, AnnotatedCorpusInfo, or AnnotationsInfo)
    @XmlPath("ms:corpusInfo/ms:corpusSubtypeSpecificInfo")
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
