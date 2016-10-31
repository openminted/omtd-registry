
package eu.openminted.registry.domain;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for projectInfoType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="projectInfoType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="projectNames"&gt;
 *           &lt;complexType&gt;
 *             &lt;complexContent&gt;
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                 &lt;sequence&gt;
 *                   &lt;element name="projectName" maxOccurs="unbounded"&gt;
 *                     &lt;complexType&gt;
 *                       &lt;simpleContent&gt;
 *                         &lt;restriction base="&lt;http://www.meta-share.org/OMTD-SHARE_XMLSchema&gt;myString"&gt;
 *                         &lt;/restriction&gt;
 *                       &lt;/simpleContent&gt;
 *                     &lt;/complexType&gt;
 *                   &lt;/element&gt;
 *                 &lt;/sequence&gt;
 *               &lt;/restriction&gt;
 *             &lt;/complexContent&gt;
 *           &lt;/complexType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="projectShortNames" minOccurs="0"&gt;
 *           &lt;complexType&gt;
 *             &lt;complexContent&gt;
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                 &lt;sequence&gt;
 *                   &lt;element name="projectShortName" maxOccurs="unbounded" minOccurs="0"&gt;
 *                     &lt;complexType&gt;
 *                       &lt;simpleContent&gt;
 *                         &lt;restriction base="&lt;http://www.meta-share.org/OMTD-SHARE_XMLSchema&gt;myString"&gt;
 *                         &lt;/restriction&gt;
 *                       &lt;/simpleContent&gt;
 *                     &lt;/complexType&gt;
 *                   &lt;/element&gt;
 *                 &lt;/sequence&gt;
 *               &lt;/restriction&gt;
 *             &lt;/complexContent&gt;
 *           &lt;/complexType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="projectIdentifiers"&gt;
 *           &lt;complexType&gt;
 *             &lt;complexContent&gt;
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                 &lt;sequence&gt;
 *                   &lt;element name="projectIdentifier" type="{http://www.meta-share.org/OMTD-SHARE_XMLSchema}projectIdentifierType" maxOccurs="unbounded"/&gt;
 *                 &lt;/sequence&gt;
 *               &lt;/restriction&gt;
 *             &lt;/complexContent&gt;
 *           &lt;/complexType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="webpages" minOccurs="0"&gt;
 *           &lt;complexType&gt;
 *             &lt;complexContent&gt;
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                 &lt;sequence&gt;
 *                   &lt;element name="webpage" type="{http://www.meta-share.org/OMTD-SHARE_XMLSchema}httpURI" maxOccurs="unbounded" minOccurs="0"/&gt;
 *                 &lt;/sequence&gt;
 *               &lt;/restriction&gt;
 *             &lt;/complexContent&gt;
 *           &lt;/complexType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="fundingTypes" minOccurs="0"&gt;
 *           &lt;complexType&gt;
 *             &lt;complexContent&gt;
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                 &lt;sequence&gt;
 *                   &lt;element name="fundingType" maxOccurs="unbounded" minOccurs="0"&gt;
 *                     &lt;simpleType&gt;
 *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *                         &lt;maxLength value="30"/&gt;
 *                         &lt;enumeration value="other"/&gt;
 *                         &lt;enumeration value="ownFunds"/&gt;
 *                         &lt;enumeration value="nationalFunds"/&gt;
 *                         &lt;enumeration value="euFunds"/&gt;
 *                       &lt;/restriction&gt;
 *                     &lt;/simpleType&gt;
 *                   &lt;/element&gt;
 *                 &lt;/sequence&gt;
 *               &lt;/restriction&gt;
 *             &lt;/complexContent&gt;
 *           &lt;/complexType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="funders" minOccurs="0"&gt;
 *           &lt;complexType&gt;
 *             &lt;complexContent&gt;
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                 &lt;sequence&gt;
 *                   &lt;element name="funder" type="{http://www.meta-share.org/OMTD-SHARE_XMLSchema}relatedOrganizationType" maxOccurs="unbounded" minOccurs="0"/&gt;
 *                 &lt;/sequence&gt;
 *               &lt;/restriction&gt;
 *             &lt;/complexContent&gt;
 *           &lt;/complexType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="fundingProgramme" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="jurisdiction" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="fundingCountries" minOccurs="0"&gt;
 *           &lt;complexType&gt;
 *             &lt;complexContent&gt;
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                 &lt;sequence&gt;
 *                   &lt;element name="fundingCountry" type="{http://www.meta-share.org/OMTD-SHARE_XMLSchema}regionIdType" maxOccurs="unbounded" minOccurs="0"/&gt;
 *                 &lt;/sequence&gt;
 *               &lt;/restriction&gt;
 *             &lt;/complexContent&gt;
 *           &lt;/complexType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="projectDates" type="{http://www.meta-share.org/OMTD-SHARE_XMLSchema}dateCombinationType" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "projectInfoType", propOrder = {
    "projectNames",
    "projectShortNames",
    "projectIdentifiers",
    "webpages",
    "fundingTypes",
    "funders",
    "fundingProgramme",
    "jurisdiction",
    "fundingCountries",
    "projectDates"
})
public class ProjectInfo {

    @XmlElementWrapper(required = true)
    @XmlElement(name = "projectName", namespace = "http://www.meta-share.org/OMTD-SHARE_XMLSchema")
    protected List<ProjectName> projectNames;
    @XmlElementWrapper
    @XmlElement(name = "projectShortName", namespace = "http://www.meta-share.org/OMTD-SHARE_XMLSchema")
    protected List<ProjectShortName> projectShortNames;
    @XmlElementWrapper(required = true)
    @XmlElement(name = "projectIdentifier", namespace = "http://www.meta-share.org/OMTD-SHARE_XMLSchema")
    protected List<ProjectIdentifier> projectIdentifiers;
    @XmlElementWrapper
    @XmlElement(name = "webpage", namespace = "http://www.meta-share.org/OMTD-SHARE_XMLSchema")
    protected List<String> webpages;
    @XmlElementWrapper
    @XmlElement(name = "fundingType", namespace = "http://www.meta-share.org/OMTD-SHARE_XMLSchema")
    protected List<FundingTypeEnum> fundingTypes;
    @XmlElementWrapper
    @XmlElement(name = "funder", namespace = "http://www.meta-share.org/OMTD-SHARE_XMLSchema")
    protected List<RelatedOrganization> funders;
    protected String fundingProgramme;
    protected String jurisdiction;
    @XmlElementWrapper
    @XmlElement(name = "fundingCountry", namespace = "http://www.meta-share.org/OMTD-SHARE_XMLSchema")
    protected List<RegionIdType> fundingCountries;
    protected DateCombination projectDates;

    /**
     * Gets the value of the fundingProgramme property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFundingProgramme() {
        return fundingProgramme;
    }

    /**
     * Sets the value of the fundingProgramme property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFundingProgramme(String value) {
        this.fundingProgramme = value;
    }

    /**
     * Gets the value of the jurisdiction property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getJurisdiction() {
        return jurisdiction;
    }

    /**
     * Sets the value of the jurisdiction property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setJurisdiction(String value) {
        this.jurisdiction = value;
    }

    /**
     * Gets the value of the projectDates property.
     * 
     * @return
     *     possible object is
     *     {@link DateCombination }
     *     
     */
    public DateCombination getProjectDates() {
        return projectDates;
    }

    /**
     * Sets the value of the projectDates property.
     * 
     * @param value
     *     allowed object is
     *     {@link DateCombination }
     *     
     */
    public void setProjectDates(DateCombination value) {
        this.projectDates = value;
    }

    public List<ProjectName> getProjectNames() {
        if (projectNames == null) {
            projectNames = new ArrayList<ProjectName>();
        }
        return projectNames;
    }

    public void setProjectNames(List<ProjectName> projectNames) {
        this.projectNames = projectNames;
    }

    public List<ProjectShortName> getProjectShortNames() {
        if (projectShortNames == null) {
            projectShortNames = new ArrayList<ProjectShortName>();
        }
        return projectShortNames;
    }

    public void setProjectShortNames(List<ProjectShortName> projectShortNames) {
        this.projectShortNames = projectShortNames;
    }

    public List<ProjectIdentifier> getProjectIdentifiers() {
        if (projectIdentifiers == null) {
            projectIdentifiers = new ArrayList<ProjectIdentifier>();
        }
        return projectIdentifiers;
    }

    public void setProjectIdentifiers(List<ProjectIdentifier> projectIdentifiers) {
        this.projectIdentifiers = projectIdentifiers;
    }

    public List<String> getWebpages() {
        if (webpages == null) {
            webpages = new ArrayList<String>();
        }
        return webpages;
    }

    public void setWebpages(List<String> webpages) {
        this.webpages = webpages;
    }

    public List<FundingTypeEnum> getFundingTypes() {
        if (fundingTypes == null) {
            fundingTypes = new ArrayList<FundingTypeEnum>();
        }
        return fundingTypes;
    }

    public void setFundingTypes(List<FundingTypeEnum> fundingTypes) {
        this.fundingTypes = fundingTypes;
    }

    public List<RelatedOrganization> getFunders() {
        if (funders == null) {
            funders = new ArrayList<RelatedOrganization>();
        }
        return funders;
    }

    public void setFunders(List<RelatedOrganization> funders) {
        this.funders = funders;
    }

    public List<RegionIdType> getFundingCountries() {
        if (fundingCountries == null) {
            fundingCountries = new ArrayList<RegionIdType>();
        }
        return fundingCountries;
    }

    public void setFundingCountries(List<RegionIdType> fundingCountries) {
        this.fundingCountries = fundingCountries;
    }

}
