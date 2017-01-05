
package eu.openminted.registry.domain;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for componentInfoType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="componentInfoType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="resourceType"&gt;
 *           &lt;simpleType&gt;
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *               &lt;enumeration value="component"/&gt;
 *             &lt;/restriction&gt;
 *           &lt;/simpleType&gt;
 *         &lt;/element&gt;
 *         &lt;element ref="{http://www.meta-share.org/OMTD-SHARE_XMLSchema}identificationInfo"/&gt;
 *         &lt;element ref="{http://www.meta-share.org/OMTD-SHARE_XMLSchema}contactInfo"/&gt;
 *         &lt;element ref="{http://www.meta-share.org/OMTD-SHARE_XMLSchema}versionInfo" minOccurs="0"/&gt;
 *         &lt;element name="validationInfos" minOccurs="0"&gt;
 *           &lt;complexType&gt;
 *             &lt;complexContent&gt;
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                 &lt;sequence&gt;
 *                   &lt;element ref="{http://www.meta-share.org/OMTD-SHARE_XMLSchema}validationInfo" maxOccurs="unbounded" minOccurs="0"/&gt;
 *                 &lt;/sequence&gt;
 *               &lt;/restriction&gt;
 *             &lt;/complexContent&gt;
 *           &lt;/complexType&gt;
 *         &lt;/element&gt;
 *         &lt;element ref="{http://www.meta-share.org/OMTD-SHARE_XMLSchema}usageInfo" minOccurs="0"/&gt;
 *         &lt;element ref="{http://www.meta-share.org/OMTD-SHARE_XMLSchema}resourceDocumentationInfo" minOccurs="0"/&gt;
 *         &lt;element ref="{http://www.meta-share.org/OMTD-SHARE_XMLSchema}resourceCreationInfo" minOccurs="0"/&gt;
 *         &lt;element name="componentTypes"&gt;
 *           &lt;complexType&gt;
 *             &lt;complexContent&gt;
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                 &lt;sequence&gt;
 *                   &lt;element name="componentType" maxOccurs="unbounded"&gt;
 *                     &lt;simpleType&gt;
 *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *                         &lt;maxLength value="100"/&gt;
 *                         &lt;enumeration value="accessComponent"/&gt;
 *                         &lt;enumeration value="reader"/&gt;
 *                         &lt;enumeration value="writer"/&gt;
 *                         &lt;enumeration value="supportComponent"/&gt;
 *                         &lt;enumeration value="visualiser"/&gt;
 *                         &lt;enumeration value="debugger"/&gt;
 *                         &lt;enumeration value="validator"/&gt;
 *                         &lt;enumeration value="viewer"/&gt;
 *                         &lt;enumeration value="corpusViewer"/&gt;
 *                         &lt;enumeration value="lexiconViewer"/&gt;
 *                         &lt;enumeration value="editor"/&gt;
 *                         &lt;enumeration value="mlTrainer"/&gt;
 *                         &lt;enumeration value="mlPredictor"/&gt;
 *                         &lt;enumeration value="featureExtractor"/&gt;
 *                         &lt;enumeration value="dataSplitter"/&gt;
 *                         &lt;enumeration value="dataMerger"/&gt;
 *                         &lt;enumeration value="converter"/&gt;
 *                         &lt;enumeration value="evaluator"/&gt;
 *                         &lt;enumeration value="flowController"/&gt;
 *                         &lt;enumeration value="scriptBasedAnalyser"/&gt;
 *                         &lt;enumeration value="matcher"/&gt;
 *                         &lt;enumeration value="gazeteerBasedMatcher"/&gt;
 *                         &lt;enumeration value="crowdSourcingComponent"/&gt;
 *                         &lt;enumeration value="dataCollector"/&gt;
 *                         &lt;enumeration value="crawler"/&gt;
 *                         &lt;enumeration value="processor"/&gt;
 *                         &lt;enumeration value="annotator"/&gt;
 *                         &lt;enumeration value="segmenter"/&gt;
 *                         &lt;enumeration value="stemmer"/&gt;
 *                         &lt;enumeration value="lemmatizer"/&gt;
 *                         &lt;enumeration value="morphologicalTagger"/&gt;
 *                         &lt;enumeration value="chunker"/&gt;
 *                         &lt;enumeration value="parser"/&gt;
 *                         &lt;enumeration value="coreferenceAnnotator"/&gt;
 *                         &lt;enumeration value="namedEntityRecognizer"/&gt;
 *                         &lt;enumeration value="semanticsAnnotator"/&gt;
 *                         &lt;enumeration value="srlAnnotator"/&gt;
 *                         &lt;enumeration value="readabilityAnnotator"/&gt;
 *                         &lt;enumeration value="aligner"/&gt;
 *                         &lt;enumeration value="generator"/&gt;
 *                         &lt;enumeration value="summarizer"/&gt;
 *                         &lt;enumeration value="simplifier"/&gt;
 *                         &lt;enumeration value="preOrPostProcessingComponent"/&gt;
 *                         &lt;enumeration value="spellingChecker"/&gt;
 *                         &lt;enumeration value="grammarChecker"/&gt;
 *                         &lt;enumeration value="normalizer"/&gt;
 *                         &lt;enumeration value="filters"/&gt;
 *                         &lt;enumeration value="analyzer"/&gt;
 *                         &lt;enumeration value="topicExtractor"/&gt;
 *                         &lt;enumeration value="documentClassifier"/&gt;
 *                         &lt;enumeration value="languageIdentifier"/&gt;
 *                         &lt;enumeration value="sentimentAnalyzer"/&gt;
 *                         &lt;enumeration value="keywordsExtractor"/&gt;
 *                         &lt;enumeration value="termExtractor"/&gt;
 *                         &lt;enumeration value="contradictionDetector"/&gt;
 *                         &lt;enumeration value="eventExtractor"/&gt;
 *                         &lt;enumeration value="persuasiveExpressionMiner"/&gt;
 *                         &lt;enumeration value="informationExtractor"/&gt;
 *                         &lt;enumeration value="lexiconExtractorFromCorpora"/&gt;
 *                         &lt;enumeration value="lexiconExtractorFromLexica"/&gt;
 *                         &lt;enumeration value="wordSenseDisambiguator"/&gt;
 *                         &lt;enumeration value="qualitativeAnalyzer"/&gt;
 *                         &lt;enumeration value="platform"/&gt;
 *                         &lt;enumeration value="infrastructure"/&gt;
 *                         &lt;enumeration value="architecture"/&gt;
 *                         &lt;enumeration value="nlpDevelopmentEnvironment"/&gt;
 *                         &lt;enumeration value="other"/&gt;
 *                       &lt;/restriction&gt;
 *                     &lt;/simpleType&gt;
 *                   &lt;/element&gt;
 *                 &lt;/sequence&gt;
 *               &lt;/restriction&gt;
 *             &lt;/complexContent&gt;
 *           &lt;/complexType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="application" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/&gt;
 *         &lt;element name="distributionInfos"&gt;
 *           &lt;complexType&gt;
 *             &lt;complexContent&gt;
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                 &lt;sequence&gt;
 *                   &lt;element ref="{http://www.meta-share.org/OMTD-SHARE_XMLSchema}componentDistributionInfo" maxOccurs="unbounded"/&gt;
 *                 &lt;/sequence&gt;
 *               &lt;/restriction&gt;
 *             &lt;/complexContent&gt;
 *           &lt;/complexType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="parameterInfos" minOccurs="0"&gt;
 *           &lt;complexType&gt;
 *             &lt;complexContent&gt;
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                 &lt;sequence&gt;
 *                   &lt;element ref="{http://www.meta-share.org/OMTD-SHARE_XMLSchema}parameterInfo" maxOccurs="unbounded" minOccurs="0"/&gt;
 *                 &lt;/sequence&gt;
 *               &lt;/restriction&gt;
 *             &lt;/complexContent&gt;
 *           &lt;/complexType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="inputContentResourceInfo" type="{http://www.meta-share.org/OMTD-SHARE_XMLSchema}processingResourceInfoType" minOccurs="0"/&gt;
 *         &lt;element name="outputResourceInfo" type="{http://www.meta-share.org/OMTD-SHARE_XMLSchema}processingResourceInfoType" minOccurs="0"/&gt;
 *         &lt;element name="componentDependencies" minOccurs="0"&gt;
 *           &lt;complexType&gt;
 *             &lt;complexContent&gt;
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                 &lt;sequence&gt;
 *                   &lt;element ref="{http://www.meta-share.org/OMTD-SHARE_XMLSchema}typesystem"/&gt;
 *                   &lt;element name="tagsets" minOccurs="0"&gt;
 *                     &lt;complexType&gt;
 *                       &lt;complexContent&gt;
 *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                           &lt;sequence&gt;
 *                             &lt;element ref="{http://www.meta-share.org/OMTD-SHARE_XMLSchema}tagset" maxOccurs="unbounded" minOccurs="0"/&gt;
 *                           &lt;/sequence&gt;
 *                         &lt;/restriction&gt;
 *                       &lt;/complexContent&gt;
 *                     &lt;/complexType&gt;
 *                   &lt;/element&gt;
 *                   &lt;element name="annotationResources" minOccurs="0"&gt;
 *                     &lt;complexType&gt;
 *                       &lt;complexContent&gt;
 *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                           &lt;sequence&gt;
 *                             &lt;element ref="{http://www.meta-share.org/OMTD-SHARE_XMLSchema}annotationResource" maxOccurs="unbounded" minOccurs="0"/&gt;
 *                           &lt;/sequence&gt;
 *                         &lt;/restriction&gt;
 *                       &lt;/complexContent&gt;
 *                     &lt;/complexType&gt;
 *                   &lt;/element&gt;
 *                   &lt;element name="softwareLibraries" minOccurs="0"&gt;
 *                     &lt;complexType&gt;
 *                       &lt;complexContent&gt;
 *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                           &lt;sequence&gt;
 *                             &lt;element name="requiresSoftware" type="{http://www.w3.org/2001/XMLSchema}string" maxOccurs="unbounded" minOccurs="0"/&gt;
 *                           &lt;/sequence&gt;
 *                         &lt;/restriction&gt;
 *                       &lt;/complexContent&gt;
 *                     &lt;/complexType&gt;
 *                   &lt;/element&gt;
 *                   &lt;element ref="{http://www.meta-share.org/OMTD-SHARE_XMLSchema}requiresHardware" maxOccurs="unbounded" minOccurs="0"/&gt;
 *                 &lt;/sequence&gt;
 *               &lt;/restriction&gt;
 *             &lt;/complexContent&gt;
 *           &lt;/complexType&gt;
 *         &lt;/element&gt;
 *         &lt;element ref="{http://www.meta-share.org/OMTD-SHARE_XMLSchema}componentCreationInfo" minOccurs="0"/&gt;
 *         &lt;element ref="{http://www.meta-share.org/OMTD-SHARE_XMLSchema}componentEvaluationInfo" minOccurs="0"/&gt;
 *         &lt;element ref="{http://www.meta-share.org/OMTD-SHARE_XMLSchema}componentDocumentationInfo" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "componentInfoType", propOrder = {
    "resourceType",
    "identificationInfo",
    "contactInfo",
    "versionInfo",
    "validationInfos",
    "usageInfo",
    "resourceDocumentationInfo",
    "resourceCreationInfo",
    "componentTypes",
    "application",
    "distributionInfos",
    "parameterInfos",
    "inputContentResourceInfo",
    "outputResourceInfo",
    "componentDependencies",
    "componentCreationInfo",
    "componentEvaluationInfo",
    "componentDocumentationInfo"
})
public class ComponentInfo {

    @XmlElement(required = true)
    protected ResourceTypeEnum resourceType;
    @XmlElement(required = true)
    protected IdentificationInfo identificationInfo;
    @XmlElement(required = true)
    protected ContactInfo contactInfo;
    protected VersionInfo versionInfo;
    @XmlElementWrapper
    @XmlElement(name = "validationInfo", namespace = "http://www.meta-share.org/OMTD-SHARE_XMLSchema")
    protected List<ValidationInfo> validationInfos;
    protected UsageInfo usageInfo;
    protected ResourceDocumentationInfo resourceDocumentationInfo;
    protected ResourceCreationInfo resourceCreationInfo;
    @XmlElementWrapper(required = true)
    @XmlElement(name = "componentType", namespace = "http://www.meta-share.org/OMTD-SHARE_XMLSchema")
    protected List<ComponentTypeEnum> componentTypes;
    protected Boolean application;
    @XmlElementWrapper(required = true)
    @XmlElement(name = "componentDistributionInfo", namespace = "http://www.meta-share.org/OMTD-SHARE_XMLSchema")
    protected List<ComponentDistributionInfo> distributionInfos;
    @XmlElementWrapper
    @XmlElement(name = "parameterInfo", namespace = "http://www.meta-share.org/OMTD-SHARE_XMLSchema")
    protected List<ParameterInfoType> parameterInfos;
    protected ProcessingResourceInfo inputContentResourceInfo;
    protected ProcessingResourceInfo outputResourceInfo;
    protected ComponentDependencies componentDependencies;
    protected ComponentCreationInfo componentCreationInfo;
    protected ComponentEvaluationInfo componentEvaluationInfo;
    protected ComponentDocumentationInfo componentDocumentationInfo;

    /**
     * Gets the value of the resourceType property.
     * 
     * @return
     *     possible object is
     *     {@link ResourceTypeEnum }
     *     
     */
    public ResourceTypeEnum getResourceType() {
        return resourceType;
    }

    /**
     * Sets the value of the resourceType property.
     * 
     * @param value
     *     allowed object is
     *     {@link ResourceTypeEnum }
     *     
     */
    public void setResourceType(ResourceTypeEnum value) {
        this.resourceType = value;
    }

    /**
     * Gets the value of the identificationInfo property.
     * 
     * @return
     *     possible object is
     *     {@link IdentificationInfo }
     *     
     */
    public IdentificationInfo getIdentificationInfo() {
        return identificationInfo;
    }

    /**
     * Sets the value of the identificationInfo property.
     * 
     * @param value
     *     allowed object is
     *     {@link IdentificationInfo }
     *     
     */
    public void setIdentificationInfo(IdentificationInfo value) {
        this.identificationInfo = value;
    }

    /**
     * Gets the value of the contactInfo property.
     * 
     * @return
     *     possible object is
     *     {@link ContactInfo }
     *     
     */
    public ContactInfo getContactInfo() {
        return contactInfo;
    }

    /**
     * Sets the value of the contactInfo property.
     * 
     * @param value
     *     allowed object is
     *     {@link ContactInfo }
     *     
     */
    public void setContactInfo(ContactInfo value) {
        this.contactInfo = value;
    }

    /**
     * Gets the value of the versionInfo property.
     * 
     * @return
     *     possible object is
     *     {@link VersionInfo }
     *     
     */
    public VersionInfo getVersionInfo() {
        return versionInfo;
    }

    /**
     * Sets the value of the versionInfo property.
     * 
     * @param value
     *     allowed object is
     *     {@link VersionInfo }
     *     
     */
    public void setVersionInfo(VersionInfo value) {
        this.versionInfo = value;
    }

    /**
     * Gets the value of the usageInfo property.
     * 
     * @return
     *     possible object is
     *     {@link UsageInfo }
     *     
     */
    public UsageInfo getUsageInfo() {
        return usageInfo;
    }

    /**
     * Sets the value of the usageInfo property.
     * 
     * @param value
     *     allowed object is
     *     {@link UsageInfo }
     *     
     */
    public void setUsageInfo(UsageInfo value) {
        this.usageInfo = value;
    }

    /**
     * Gets the value of the resourceDocumentationInfo property.
     * 
     * @return
     *     possible object is
     *     {@link ResourceDocumentationInfo }
     *     
     */
    public ResourceDocumentationInfo getResourceDocumentationInfo() {
        return resourceDocumentationInfo;
    }

    /**
     * Sets the value of the resourceDocumentationInfo property.
     * 
     * @param value
     *     allowed object is
     *     {@link ResourceDocumentationInfo }
     *     
     */
    public void setResourceDocumentationInfo(ResourceDocumentationInfo value) {
        this.resourceDocumentationInfo = value;
    }

    /**
     * Gets the value of the resourceCreationInfo property.
     * 
     * @return
     *     possible object is
     *     {@link ResourceCreationInfo }
     *     
     */
    public ResourceCreationInfo getResourceCreationInfo() {
        return resourceCreationInfo;
    }

    /**
     * Sets the value of the resourceCreationInfo property.
     * 
     * @param value
     *     allowed object is
     *     {@link ResourceCreationInfo }
     *     
     */
    public void setResourceCreationInfo(ResourceCreationInfo value) {
        this.resourceCreationInfo = value;
    }

    /**
     * Gets the value of the application property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isApplication() {
        return application;
    }

    /**
     * Sets the value of the application property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setApplication(Boolean value) {
        this.application = value;
    }

    /**
     * Gets the value of the inputContentResourceInfo property.
     * 
     * @return
     *     possible object is
     *     {@link ProcessingResourceInfo }
     *     
     */
    public ProcessingResourceInfo getInputContentResourceInfo() {
        return inputContentResourceInfo;
    }

    /**
     * Sets the value of the inputContentResourceInfo property.
     * 
     * @param value
     *     allowed object is
     *     {@link ProcessingResourceInfo }
     *     
     */
    public void setInputContentResourceInfo(ProcessingResourceInfo value) {
        this.inputContentResourceInfo = value;
    }

    /**
     * Gets the value of the outputResourceInfo property.
     * 
     * @return
     *     possible object is
     *     {@link ProcessingResourceInfo }
     *     
     */
    public ProcessingResourceInfo getOutputResourceInfo() {
        return outputResourceInfo;
    }

    /**
     * Sets the value of the outputResourceInfo property.
     * 
     * @param value
     *     allowed object is
     *     {@link ProcessingResourceInfo }
     *     
     */
    public void setOutputResourceInfo(ProcessingResourceInfo value) {
        this.outputResourceInfo = value;
    }

    /**
     * Gets the value of the componentDependencies property.
     * 
     * @return
     *     possible object is
     *     {@link ComponentDependencies }
     *     
     */
    public ComponentDependencies getComponentDependencies() {
        return componentDependencies;
    }

    /**
     * Sets the value of the componentDependencies property.
     * 
     * @param value
     *     allowed object is
     *     {@link ComponentDependencies }
     *     
     */
    public void setComponentDependencies(ComponentDependencies value) {
        this.componentDependencies = value;
    }

    /**
     * Gets the value of the componentCreationInfo property.
     * 
     * @return
     *     possible object is
     *     {@link ComponentCreationInfo }
     *     
     */
    public ComponentCreationInfo getComponentCreationInfo() {
        return componentCreationInfo;
    }

    /**
     * Sets the value of the componentCreationInfo property.
     * 
     * @param value
     *     allowed object is
     *     {@link ComponentCreationInfo }
     *     
     */
    public void setComponentCreationInfo(ComponentCreationInfo value) {
        this.componentCreationInfo = value;
    }

    /**
     * Gets the value of the componentEvaluationInfo property.
     * 
     * @return
     *     possible object is
     *     {@link ComponentEvaluationInfo }
     *     
     */
    public ComponentEvaluationInfo getComponentEvaluationInfo() {
        return componentEvaluationInfo;
    }

    /**
     * Sets the value of the componentEvaluationInfo property.
     * 
     * @param value
     *     allowed object is
     *     {@link ComponentEvaluationInfo }
     *     
     */
    public void setComponentEvaluationInfo(ComponentEvaluationInfo value) {
        this.componentEvaluationInfo = value;
    }

    /**
     * Gets the value of the componentDocumentationInfo property.
     * 
     * @return
     *     possible object is
     *     {@link ComponentDocumentationInfo }
     *     
     */
    public ComponentDocumentationInfo getComponentDocumentationInfo() {
        return componentDocumentationInfo;
    }

    /**
     * Sets the value of the componentDocumentationInfo property.
     * 
     * @param value
     *     allowed object is
     *     {@link ComponentDocumentationInfo }
     *     
     */
    public void setComponentDocumentationInfo(ComponentDocumentationInfo value) {
        this.componentDocumentationInfo = value;
    }

    public List<ValidationInfo> getValidationInfos() {
        if (validationInfos == null) {
            validationInfos = new ArrayList<ValidationInfo>();
        }
        return validationInfos;
    }

    public void setValidationInfos(List<ValidationInfo> validationInfos) {
        this.validationInfos = validationInfos;
    }

    public List<ComponentTypeEnum> getComponentTypes() {
        if (componentTypes == null) {
            componentTypes = new ArrayList<ComponentTypeEnum>();
        }
        return componentTypes;
    }

    public void setComponentTypes(List<ComponentTypeEnum> componentTypes) {
        this.componentTypes = componentTypes;
    }

    public List<ComponentDistributionInfo> getDistributionInfos() {
        if (distributionInfos == null) {
            distributionInfos = new ArrayList<ComponentDistributionInfo>();
        }
        return distributionInfos;
    }

    public void setDistributionInfos(List<ComponentDistributionInfo> distributionInfos) {
        this.distributionInfos = distributionInfos;
    }

    public List<ParameterInfoType> getParameterInfos() {
        if (parameterInfos == null) {
            parameterInfos = new ArrayList<ParameterInfoType>();
        }
        return parameterInfos;
    }

    public void setParameterInfos(List<ParameterInfoType> parameterInfos) {
        this.parameterInfos = parameterInfos;
    }

}
