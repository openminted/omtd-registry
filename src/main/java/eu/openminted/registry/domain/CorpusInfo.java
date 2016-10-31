
package eu.openminted.registry.domain;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for corpusInfoType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="corpusInfoType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="resourceType" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
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
 *         &lt;element name="distributionInfos"&gt;
 *           &lt;complexType&gt;
 *             &lt;complexContent&gt;
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                 &lt;sequence&gt;
 *                   &lt;element ref="{http://www.meta-share.org/OMTD-SHARE_XMLSchema}datasetDistributionInfo" maxOccurs="unbounded"/&gt;
 *                 &lt;/sequence&gt;
 *               &lt;/restriction&gt;
 *             &lt;/complexContent&gt;
 *           &lt;/complexType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="corpusSubtypeSpecificInfo"&gt;
 *           &lt;complexType&gt;
 *             &lt;complexContent&gt;
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                 &lt;choice&gt;
 *                   &lt;element ref="{http://www.meta-share.org/OMTD-SHARE_XMLSchema}rawCorpusInfo"/&gt;
 *                   &lt;element ref="{http://www.meta-share.org/OMTD-SHARE_XMLSchema}annotatedCorpusInfo"/&gt;
 *                   &lt;element ref="{http://www.meta-share.org/OMTD-SHARE_XMLSchema}annotationsInfo"/&gt;
 *                 &lt;/choice&gt;
 *               &lt;/restriction&gt;
 *             &lt;/complexContent&gt;
 *           &lt;/complexType&gt;
 *         &lt;/element&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "corpusInfoType", propOrder = {
    "resourceType",
    "identificationInfo",
    "contactInfo",
    "versionInfo",
    "validationInfos",
    "usageInfo",
    "resourceDocumentationInfo",
    "resourceCreationInfo",
    "distributionInfos",
    "corpusSubtypeSpecificInfo"
})
public class CorpusInfo {

    @XmlElement(required = true)
    protected String resourceType;
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
    @XmlElement(name = "datasetDistributionInfo", namespace = "http://www.meta-share.org/OMTD-SHARE_XMLSchema")
    protected List<DatasetDistributionInfo> distributionInfos;
    @XmlElement(required = true)
    protected CorpusSubtypeSpecificInfo corpusSubtypeSpecificInfo;

    /**
     * Gets the value of the resourceType property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getResourceType() {
        return resourceType;
    }

    /**
     * Sets the value of the resourceType property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setResourceType(String value) {
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
     * Gets the value of the corpusSubtypeSpecificInfo property.
     * 
     * @return
     *     possible object is
     *     {@link CorpusSubtypeSpecificInfo }
     *     
     */
    public CorpusSubtypeSpecificInfo getCorpusSubtypeSpecificInfo() {
        return corpusSubtypeSpecificInfo;
    }

    /**
     * Sets the value of the corpusSubtypeSpecificInfo property.
     * 
     * @param value
     *     allowed object is
     *     {@link CorpusSubtypeSpecificInfo }
     *     
     */
    public void setCorpusSubtypeSpecificInfo(CorpusSubtypeSpecificInfo value) {
        this.corpusSubtypeSpecificInfo = value;
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

    public List<DatasetDistributionInfo> getDistributionInfos() {
        if (distributionInfos == null) {
            distributionInfos = new ArrayList<DatasetDistributionInfo>();
        }
        return distributionInfos;
    }

    public void setDistributionInfos(List<DatasetDistributionInfo> distributionInfos) {
        this.distributionInfos = distributionInfos;
    }

}
