package eu.openminted.registry.domain;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;

import org.eclipse.persistence.oxm.annotations.XmlPath;

@XmlRootElement(name = "lcrMetadataRecord", namespace = "http://www.meta-share.org/OMTD-SHARE_XMLSchema")
public class LexicalConceptualResource {

	private MetadataHeaderInfo metadataHeaderInfo;
	
	//required
    @XmlPath("ms:lexicalConceptualResourceInfo/resourceType/text()")
    private final String resourceType = "lexicalConceptualResource";

    //required
//    @XmlElement(name = "identificationInfo", required = true)
    @XmlPath("ms:lexicalConceptualResourceInfo/ms:identificationInfo")
    private ResourceIdentificationInfo resourceIdentificationInfo;
    //required
    @XmlPath("ms:lexicalConceptualResourceInfo/ms:contactInfo")
    private ContactInfo contactInfo;
    @XmlPath("ms:lexicalConceptualResourceInfo/ms:versionInfo")
    private VersionInfo versionInfo;
    
    @XmlElementWrapper(name="validationInfos")
    @XmlElement(name="validationInfo")
    private List<ValidationInfo> validationInfos;
    
    private UsageInfo usageInfo;
    private ResourceDocumentationInfo resourceDocumentationInfo;
    private ResourceCreationInfo resourceCreationInfo;
    
    @XmlPath("ms:lexicalConceptualResourceInfo")
    @XmlElementWrapper(name="distributionInfos")
    @XmlElement(name="datasetDistributionInfo")
    private List<DatasetDistributionInfo> distributionInfos;
    
    
    private LexicalConceptualResourceType lexicalConceptualResourceType;
    
    private LexicalConceptualResourceEncodingInfo lexicalConceptualResourceEncodingInfo;
    
    private LexicalConceptualResourceMediaType lexicalConceptualResourceMediaType; 
    
    public LexicalConceptualResource() {
	}

	public LexicalConceptualResource(
			MetadataHeaderInfo metadataHeaderInfo,
			ResourceIdentificationInfo resourceIdentificationInfo,
			ContactInfo contactInfo,
			VersionInfo versionInfo,
			List<ValidationInfo> validationInfos,
			UsageInfo usageInfo,
			ResourceDocumentationInfo resourceDocumentationInfo,
			ResourceCreationInfo resourceCreationInfo,
			List<DatasetDistributionInfo> distributionInfos,
			LexicalConceptualResourceType lexicalConceptualResourceType,
			LexicalConceptualResourceEncodingInfo lexicalConceptualResourceEncodingInfo,
			LexicalConceptualResourceMediaType lexicalConceptualResourceMediaType) {
		super();
		this.metadataHeaderInfo = metadataHeaderInfo;
		this.resourceIdentificationInfo = resourceIdentificationInfo;
		this.contactInfo = contactInfo;
		this.versionInfo = versionInfo;
		this.validationInfos = validationInfos;
		this.usageInfo = usageInfo;
		this.resourceDocumentationInfo = resourceDocumentationInfo;
		this.resourceCreationInfo = resourceCreationInfo;
		this.distributionInfos = distributionInfos;
		this.lexicalConceptualResourceType = lexicalConceptualResourceType;
		this.lexicalConceptualResourceEncodingInfo = lexicalConceptualResourceEncodingInfo;
		this.lexicalConceptualResourceMediaType = lexicalConceptualResourceMediaType;
	}

	public MetadataHeaderInfo getMetadataHeaderInfo() {
		return metadataHeaderInfo;
	}

	public void setMetadataHeaderInfo(MetadataHeaderInfo metadataHeaderInfo) {
		this.metadataHeaderInfo = metadataHeaderInfo;
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

	public LexicalConceptualResourceType getLexicalConceptualResourceType() {
		return lexicalConceptualResourceType;
	}

	public void setLexicalConceptualResourceType(
			LexicalConceptualResourceType lexicalConceptualResourceType) {
		this.lexicalConceptualResourceType = lexicalConceptualResourceType;
	}

	public LexicalConceptualResourceEncodingInfo getLexicalConceptualResourceEncodingInfo() {
		return lexicalConceptualResourceEncodingInfo;
	}

	public void setLexicalConceptualResourceEncodingInfo(
			LexicalConceptualResourceEncodingInfo lexicalConceptualResourceEncodingInfo) {
		this.lexicalConceptualResourceEncodingInfo = lexicalConceptualResourceEncodingInfo;
	}

	public LexicalConceptualResourceMediaType getLexicalConceptualResourceMediaType() {
		return lexicalConceptualResourceMediaType;
	}

	public void setLexicalConceptualResourceMediaType(
			LexicalConceptualResourceMediaType lexicalConceptualResourceMediaType) {
		this.lexicalConceptualResourceMediaType = lexicalConceptualResourceMediaType;
	}

	public String getResourceType() {
		return resourceType;
	}
    
    
}
