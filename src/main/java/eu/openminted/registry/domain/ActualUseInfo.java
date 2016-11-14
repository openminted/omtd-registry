
package eu.openminted.registry.domain;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for actualUseInfoType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="actualUseInfoType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="actualUse"&gt;
 *           &lt;simpleType&gt;
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *               &lt;maxLength value="30"/&gt;
 *               &lt;enumeration value="humanUse"/&gt;
 *               &lt;enumeration value="nlpApplications"/&gt;
 *             &lt;/restriction&gt;
 *           &lt;/simpleType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="useNlpApplications" minOccurs="0"&gt;
 *           &lt;complexType&gt;
 *             &lt;complexContent&gt;
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                 &lt;sequence&gt;
 *                   &lt;element ref="{http://www.meta-share.org/OMTD-SHARE_XMLSchema}useNLPSpecific" maxOccurs="unbounded" minOccurs="0"/&gt;
 *                 &lt;/sequence&gt;
 *               &lt;/restriction&gt;
 *             &lt;/complexContent&gt;
 *           &lt;/complexType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="usageReports" minOccurs="0"&gt;
 *           &lt;complexType&gt;
 *             &lt;complexContent&gt;
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                 &lt;sequence&gt;
 *                   &lt;element name="usageReport" type="{http://www.meta-share.org/OMTD-SHARE_XMLSchema}relatedDocumentInfoType" maxOccurs="unbounded" minOccurs="0"/&gt;
 *                 &lt;/sequence&gt;
 *               &lt;/restriction&gt;
 *             &lt;/complexContent&gt;
 *           &lt;/complexType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="derivedResources" minOccurs="0"&gt;
 *           &lt;complexType&gt;
 *             &lt;complexContent&gt;
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                 &lt;sequence&gt;
 *                   &lt;element name="derivedResource" type="{http://www.meta-share.org/OMTD-SHARE_XMLSchema}relatedResourceType" maxOccurs="unbounded" minOccurs="0"/&gt;
 *                 &lt;/sequence&gt;
 *               &lt;/restriction&gt;
 *             &lt;/complexContent&gt;
 *           &lt;/complexType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="usageProjects" minOccurs="0"&gt;
 *           &lt;complexType&gt;
 *             &lt;complexContent&gt;
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                 &lt;sequence&gt;
 *                   &lt;element name="usageProject" type="{http://www.meta-share.org/OMTD-SHARE_XMLSchema}relatedProjectType" maxOccurs="unbounded" minOccurs="0"/&gt;
 *                 &lt;/sequence&gt;
 *               &lt;/restriction&gt;
 *             &lt;/complexContent&gt;
 *           &lt;/complexType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="actualUseDetails" minOccurs="0"&gt;
 *           &lt;simpleType&gt;
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *               &lt;maxLength value="250"/&gt;
 *             &lt;/restriction&gt;
 *           &lt;/simpleType&gt;
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
@XmlType(name = "actualUseInfoType", propOrder = {
    "actualUse",
    "useNlpApplications",
    "usageReports",
    "derivedResources",
    "usageProjects",
    "actualUseDetails"
})
public class ActualUseInfo {

    @XmlElement(required = true)
    protected ActualUseEnum actualUse;
    @XmlElementWrapper
    @XmlElement(name = "useNLPSpecific", namespace = "http://www.meta-share.org/OMTD-SHARE_XMLSchema")
    protected List<UseNLPSpecificEnum> useNlpApplications;
    @XmlElementWrapper
    @XmlElement(name = "usageReport", namespace = "http://www.meta-share.org/OMTD-SHARE_XMLSchema")
    protected List<RelatedDocumentInfo> usageReports;
    @XmlElementWrapper
    @XmlElement(name = "derivedResource", namespace = "http://www.meta-share.org/OMTD-SHARE_XMLSchema")
    protected List<RelatedResource> derivedResources;
    @XmlElementWrapper
    @XmlElement(name = "usageProject", namespace = "http://www.meta-share.org/OMTD-SHARE_XMLSchema")
    protected List<RelatedProject> usageProjects;
    protected String actualUseDetails;

    /**
     * Gets the value of the actualUse property.
     * 
     * @return
     *     possible object is
     *     {@link ActualUseEnum }
     *     
     */
    public ActualUseEnum getActualUse() {
        return actualUse;
    }

    /**
     * Sets the value of the actualUse property.
     * 
     * @param value
     *     allowed object is
     *     {@link ActualUseEnum }
     *     
     */
    public void setActualUse(ActualUseEnum value) {
        this.actualUse = value;
    }

    /**
     * Gets the value of the actualUseDetails property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getActualUseDetails() {
        return actualUseDetails;
    }

    /**
     * Sets the value of the actualUseDetails property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setActualUseDetails(String value) {
        this.actualUseDetails = value;
    }

    public List<UseNLPSpecificEnum> getUseNlpApplications() {
        if (useNlpApplications == null) {
            useNlpApplications = new ArrayList<UseNLPSpecificEnum>();
        }
        return useNlpApplications;
    }

    public void setUseNlpApplications(List<UseNLPSpecificEnum> useNlpApplications) {
        this.useNlpApplications = useNlpApplications;
    }

    public List<RelatedDocumentInfo> getUsageReports() {
        if (usageReports == null) {
            usageReports = new ArrayList<RelatedDocumentInfo>();
        }
        return usageReports;
    }

    public void setUsageReports(List<RelatedDocumentInfo> usageReports) {
        this.usageReports = usageReports;
    }

    public List<RelatedResource> getDerivedResources() {
        if (derivedResources == null) {
            derivedResources = new ArrayList<RelatedResource>();
        }
        return derivedResources;
    }

    public void setDerivedResources(List<RelatedResource> derivedResources) {
        this.derivedResources = derivedResources;
    }

    public List<RelatedProject> getUsageProjects() {
        if (usageProjects == null) {
            usageProjects = new ArrayList<RelatedProject>();
        }
        return usageProjects;
    }

    public void setUsageProjects(List<RelatedProject> usageProjects) {
        this.usageProjects = usageProjects;
    }

}
