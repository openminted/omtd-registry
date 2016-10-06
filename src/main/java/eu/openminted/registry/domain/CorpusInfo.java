package eu.openminted.registry.domain;

import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlType;

@XmlType(propOrder = {
	    "resourceType",
	    "resourceIdentificationInfo",
	    "contactInfo",
	    "versionInfo",
	    "validationInfos",
	    "usageInfo",
	    "resourceDocumentationInfo",
	    "resourceCreationInfo",
	    "distributionInfos",
	    "corpusSubTypeSpecificInfo"
	})
public class CorpusInfo {

    private String resourceType = "corpus";
  
    @XmlElement(name = "identificationInfo")
    private ResourceIdentificationInfo resourceIdentificationInfo;
    
    private ContactInfo contactInfo;
   
    private VersionInfo versionInfo;
    
    @XmlElementWrapper(name = "validationInfos")
    @XmlElement(name = "validationInfo")
    private List<ValidationInfo> validationInfos;
    
    private UsageInfo usageInfo;
    
    private ResourceDocumentationInfo resourceDocumentationInfo;
    
    private ResourceCreationInfo resourceCreationInfo;

    @XmlElementWrapper(name = "distributionInfos")
    @XmlElement(name = "datasetDistributionInfo")
    private List<DatasetDistributionInfo> distributionInfos;

    @XmlElement(name = "corpusSubtypeSpecificInfo")
    private CorpusSubTypeSpecificInfo corpusSubTypeSpecificInfo;
    
    public CorpusInfo() {
		// TODO Auto-generated constructor stub
	}

	public String getResourceType() {
		return resourceType;
	}

	public void setResourceType(String resourceType) {
		this.resourceType = resourceType;
	}

	public ResourceIdentificationInfo getResourceIdentificationInfo() {
		return resourceIdentificationInfo;
	}

	public void setResourceIdentificationInfo(
			ResourceIdentificationInfo resourceIdentificationInfo) {
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

	public void setResourceDocumentationInfo(
			ResourceDocumentationInfo resourceDocumentationInfo) {
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

	public void setCorpusSubTypeSpecificInfo(
			CorpusSubTypeSpecificInfo corpusSubTypeSpecificInfo) {
		this.corpusSubTypeSpecificInfo = corpusSubTypeSpecificInfo;
	}
    
    
}
