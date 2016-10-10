package eu.openminted.registry.domain;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlType;

import org.eclipse.persistence.oxm.annotations.XmlPath;

@XmlType(name = "componentInfoType", propOrder = {
    "resourceType",
    "resourceIdentificationInfo",
    "contactInfo",
    "versionInfo",
    "validationInfos",
    "usageInfo",
    "resourceDocumentationInfo",
    "resourceCreationInfo",
    "componentTypes",
    "distributionInfos",
    "inputContentResourceInfo",
    "outputResourceInfo",
    "componentDependencies",
    "componentCreationInfo",
    "componentEvaluationInfo",
    "componentDocumentationInfo"
})
@XmlAccessorType(XmlAccessType.FIELD)
public class ComponentInfo {
  
    private String resourceType = "component";
    
    @XmlElement(name = "identificationInfo")
    private ResourceIdentificationInfo resourceIdentificationInfo;

    private ContactInfo contactInfo;
    
    private VersionInfo versionInfo;
    
    @XmlElementWrapper(name="validationInfos")
    @XmlElement(name="validationInfo")
    private List<ValidationInfo> validationInfos;
    
    private UsageInfo usageInfo;
    
    private ResourceDocumentationInfo resourceDocumentationInfo;
    private ResourceCreationInfo resourceCreationInfo;
    //required
    //TODO this should be made into an enum (use componentType)

    @XmlElementWrapper(name="componentTypes")
    @XmlElement(name="componentType")
    private List<String> componentTypes;

    @XmlElementWrapper(name="distributionInfos")
    @XmlElement(name="componentDistributionInfo")
    private List<ComponentDistributionInfo> distributionInfos;

    private ProcessingResourceInfo inputContentResourceInfo;

    private ProcessingResourceInfo outputResourceInfo;
    
    
    private ComponentDependencies componentDependencies;
    private ComponentCreationInfo componentCreationInfo;
    private ComponentEvaluationInfo componentEvaluationInfo;
    private ComponentDocumentationInfo componentDocumentationInfo;
    
    public ComponentInfo() {
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

	public List<String> getComponentTypes() {
		return componentTypes;
	}

	public void setComponentTypes(List<String> componentTypes) {
		this.componentTypes = componentTypes;
	}

	public List<ComponentDistributionInfo> getDistributionInfos() {
		return distributionInfos;
	}

	public void setDistributionInfos(
			List<ComponentDistributionInfo> distributionInfos) {
		this.distributionInfos = distributionInfos;
	}

	public ProcessingResourceInfo getInputContentResourceInfo() {
		return inputContentResourceInfo;
	}

	public void setInputContentResourceInfo(
			ProcessingResourceInfo inputContentResourceInfo) {
		this.inputContentResourceInfo = inputContentResourceInfo;
	}

	public ProcessingResourceInfo getOutputResourceInfo() {
		return outputResourceInfo;
	}

	public void setOutputResourceInfo(ProcessingResourceInfo outputResourceInfo) {
		this.outputResourceInfo = outputResourceInfo;
	}

	public ComponentDependencies getComponentDependencies() {
		return componentDependencies;
	}

	public void setComponentDependencies(ComponentDependencies componentDependencies) {
		this.componentDependencies = componentDependencies;
	}

	public ComponentCreationInfo getComponentCreationInfo() {
		return componentCreationInfo;
	}

	public void setComponentCreationInfo(ComponentCreationInfo componentCreationInfo) {
		this.componentCreationInfo = componentCreationInfo;
	}

	public ComponentEvaluationInfo getComponentEvaluationInfo() {
		return componentEvaluationInfo;
	}

	public void setComponentEvaluationInfo(
			ComponentEvaluationInfo componentEvaluationInfo) {
		this.componentEvaluationInfo = componentEvaluationInfo;
	}

	public ComponentDocumentationInfo getComponentDocumentationInfo() {
		return componentDocumentationInfo;
	}

	public void setComponentDocumentationInfo(
			ComponentDocumentationInfo componentDocumentationInfo) {
		this.componentDocumentationInfo = componentDocumentationInfo;
	}
    
    
}
