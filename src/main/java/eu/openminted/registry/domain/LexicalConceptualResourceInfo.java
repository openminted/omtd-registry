package eu.openminted.registry.domain;

import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlType;

import org.eclipse.persistence.oxm.annotations.XmlPath;

@XmlType(propOrder = { "resourceType","identificationInfo", "contactInfo",
		"versionInfo", "validationInfos", "usageInfo",
		"resourceDocumentationInfo", "resourceCreationInfo",
		"distributionInfos", "lexicalConceptualResourceType",
		"lexicalConceptualResourceEncodingInfo", "lexicalConceptualResourceMediaType"})
public class LexicalConceptualResourceInfo {

	// required
	private String resourceType;

	// required
	// @XmlElement(name = "identificationInfo", required = true)

	private ResourceIdentificationInfo identificationInfo;

	// required
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

	private LexicalConceptualResourceType lexicalConceptualResourceType;

	private LexicalConceptualResourceEncodingInfo lexicalConceptualResourceEncodingInfo;

	@XmlPath("ms:lexicalConceptualResourceMediaType/ms:lexicalConceptualResourceTextInfo")
	private LexicalConceptualResourceMediaType lexicalConceptualResourceMediaType;

	public LexicalConceptualResourceInfo() {
		// TODO Auto-generated constructor stub
	}

	public LexicalConceptualResourceInfo(
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
		this.setIdentificationInfo(resourceIdentificationInfo);
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

	public void setResourceCreationInfo(
			ResourceCreationInfo resourceCreationInfo) {
		this.resourceCreationInfo = resourceCreationInfo;
	}

	public List<DatasetDistributionInfo> getDistributionInfos() {
		return distributionInfos;
	}

	public void setDistributionInfos(
			List<DatasetDistributionInfo> distributionInfos) {
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

	public ResourceIdentificationInfo getIdentificationInfo() {
		return identificationInfo;
	}

	public void setIdentificationInfo(ResourceIdentificationInfo identificationInfo) {
		this.identificationInfo = identificationInfo;
	}

	public String getResourceType() {
		return resourceType;
	}

	public void setResourceType(String resourceType) {
		this.resourceType = resourceType;
	}

}
