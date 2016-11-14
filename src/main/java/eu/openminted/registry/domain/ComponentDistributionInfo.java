
package eu.openminted.registry.domain;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Java class for componentDistributionInfoType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="componentDistributionInfoType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="componentDistributionMedium"&gt;
 *           &lt;simpleType&gt;
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *               &lt;enumeration value="webService"/&gt;
 *               &lt;enumeration value="sourceCode"/&gt;
 *               &lt;enumeration value="executableCode"/&gt;
 *             &lt;/restriction&gt;
 *           &lt;/simpleType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="downloadURLs" minOccurs="0"&gt;
 *           &lt;complexType&gt;
 *             &lt;complexContent&gt;
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                 &lt;sequence&gt;
 *                   &lt;element ref="{http://www.meta-share.org/OMTD-SHARE_XMLSchema}downloadURL" maxOccurs="unbounded" minOccurs="0"/&gt;
 *                 &lt;/sequence&gt;
 *               &lt;/restriction&gt;
 *             &lt;/complexContent&gt;
 *           &lt;/complexType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="accessURLs" minOccurs="0"&gt;
 *           &lt;complexType&gt;
 *             &lt;complexContent&gt;
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                 &lt;sequence&gt;
 *                   &lt;element ref="{http://www.meta-share.org/OMTD-SHARE_XMLSchema}accessURL" maxOccurs="unbounded" minOccurs="0"/&gt;
 *                 &lt;/sequence&gt;
 *               &lt;/restriction&gt;
 *             &lt;/complexContent&gt;
 *           &lt;/complexType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="mavenID" type="{http://www.w3.org/2001/XMLSchema}anyType" minOccurs="0"/&gt;
 *         &lt;element name="webServiceType" minOccurs="0"&gt;
 *           &lt;simpleType&gt;
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *               &lt;enumeration value="SOAP"/&gt;
 *               &lt;enumeration value="REST"/&gt;
 *               &lt;enumeration value="other"/&gt;
 *             &lt;/restriction&gt;
 *           &lt;/simpleType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="operatingSystem" maxOccurs="unbounded" minOccurs="0"&gt;
 *           &lt;simpleType&gt;
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *               &lt;maxLength value="50"/&gt;
 *               &lt;enumeration value="os-independent"/&gt;
 *               &lt;enumeration value="windows"/&gt;
 *               &lt;enumeration value="linux"/&gt;
 *               &lt;enumeration value="unix"/&gt;
 *               &lt;enumeration value="mac-OS"/&gt;
 *               &lt;enumeration value="googleChromeOS"/&gt;
 *               &lt;enumeration value="iOS"/&gt;
 *               &lt;enumeration value="android"/&gt;
 *               &lt;enumeration value="other"/&gt;
 *               &lt;enumeration value=""/&gt;
 *             &lt;/restriction&gt;
 *           &lt;/simpleType&gt;
 *         &lt;/element&gt;
 *         &lt;element ref="{http://www.meta-share.org/OMTD-SHARE_XMLSchema}rightsInfo"/&gt;
 *         &lt;element name="copyrightStatements" minOccurs="0"&gt;
 *           &lt;complexType&gt;
 *             &lt;complexContent&gt;
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                 &lt;sequence&gt;
 *                   &lt;element ref="{http://www.meta-share.org/OMTD-SHARE_XMLSchema}copyrightStatement" maxOccurs="unbounded" minOccurs="0"/&gt;
 *                 &lt;/sequence&gt;
 *               &lt;/restriction&gt;
 *             &lt;/complexContent&gt;
 *           &lt;/complexType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="attributionTexts" minOccurs="0"&gt;
 *           &lt;complexType&gt;
 *             &lt;complexContent&gt;
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                 &lt;sequence&gt;
 *                   &lt;element ref="{http://www.meta-share.org/OMTD-SHARE_XMLSchema}attributionText" maxOccurs="unbounded" minOccurs="0"/&gt;
 *                 &lt;/sequence&gt;
 *               &lt;/restriction&gt;
 *             &lt;/complexContent&gt;
 *           &lt;/complexType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="rightsHolders" minOccurs="0"&gt;
 *           &lt;complexType&gt;
 *             &lt;complexContent&gt;
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                 &lt;sequence&gt;
 *                   &lt;element ref="{http://www.meta-share.org/OMTD-SHARE_XMLSchema}rightsHolder" maxOccurs="unbounded" minOccurs="0"/&gt;
 *                 &lt;/sequence&gt;
 *               &lt;/restriction&gt;
 *             &lt;/complexContent&gt;
 *           &lt;/complexType&gt;
 *         &lt;/element&gt;
 *         &lt;element ref="{http://www.meta-share.org/OMTD-SHARE_XMLSchema}availabilityStartDate" minOccurs="0"/&gt;
 *         &lt;element ref="{http://www.meta-share.org/OMTD-SHARE_XMLSchema}availabilityEndDate" minOccurs="0"/&gt;
 *         &lt;element ref="{http://www.meta-share.org/OMTD-SHARE_XMLSchema}fee" minOccurs="0"/&gt;
 *         &lt;element name="userTypes" minOccurs="0"&gt;
 *           &lt;complexType&gt;
 *             &lt;complexContent&gt;
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                 &lt;sequence&gt;
 *                   &lt;element ref="{http://www.meta-share.org/OMTD-SHARE_XMLSchema}userType" maxOccurs="unbounded" minOccurs="0"/&gt;
 *                 &lt;/sequence&gt;
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
@XmlType(name = "componentDistributionInfoType", propOrder = {
    "componentDistributionMedium",
    "downloadURLs",
    "accessURLs",
    "mavenID",
    "webServiceType",
    "operatingSystem",
    "rightsInfo",
    "copyrightStatements",
    "attributionTexts",
    "rightsHolders",
    "availabilityStartDate",
    "availabilityEndDate",
    "fee",
    "userTypes"
})
public class ComponentDistributionInfo {

    @XmlElement(required = true)
    protected ComponentDistributionMediumEnum componentDistributionMedium;
    @XmlElementWrapper
    @XmlElement(name = "downloadURL", namespace = "http://www.meta-share.org/OMTD-SHARE_XMLSchema")
    protected List<String> downloadURLs;
    @XmlElementWrapper
    @XmlElement(name = "accessURL", namespace = "http://www.meta-share.org/OMTD-SHARE_XMLSchema")
    protected List<String> accessURLs;
    protected Object mavenID;
    protected WebServiceTypeEnum webServiceType;
    protected List<OperatingSystemEnum> operatingSystem;

    protected RightsInfo rightsInfo;
    @XmlElementWrapper
    @XmlElement(name = "copyrightStatement", namespace = "http://www.meta-share.org/OMTD-SHARE_XMLSchema")
    protected List<CopyrightStatement> copyrightStatements;
    @XmlElementWrapper
    @XmlElement(name = "attributionText", namespace = "http://www.meta-share.org/OMTD-SHARE_XMLSchema")
    protected List<AttributionText> attributionTexts;
    @XmlElementWrapper
    @XmlElement(name = "rightsHolder", namespace = "http://www.meta-share.org/OMTD-SHARE_XMLSchema")
    protected List<ActorInfo> rightsHolders;
    @XmlSchemaType(name = "date")
    protected XMLGregorianCalendar availabilityStartDate;
    @XmlSchemaType(name = "date")
    protected XMLGregorianCalendar availabilityEndDate;
    protected String fee;
    @XmlElementWrapper
    @XmlElement(name = "userType", namespace = "http://www.meta-share.org/OMTD-SHARE_XMLSchema")
    protected List<UserTypeEnum> userTypes;

    /**
     * Gets the value of the componentDistributionMedium property.
     * 
     * @return
     *     possible object is
     *     {@link ComponentDistributionMediumEnum }
     *     
     */
    public ComponentDistributionMediumEnum getComponentDistributionMedium() {
        return componentDistributionMedium;
    }

    /**
     * Sets the value of the componentDistributionMedium property.
     * 
     * @param value
     *     allowed object is
     *     {@link ComponentDistributionMediumEnum }
     *     
     */
    public void setComponentDistributionMedium(ComponentDistributionMediumEnum value) {
        this.componentDistributionMedium = value;
    }

    /**
     * Gets the value of the mavenID property.
     * 
     * @return
     *     possible object is
     *     {@link Object }
     *     
     */
    public Object getMavenID() {
        return mavenID;
    }

    /**
     * Sets the value of the mavenID property.
     * 
     * @param value
     *     allowed object is
     *     {@link Object }
     *     
     */
    public void setMavenID(Object value) {
        this.mavenID = value;
    }

    /**
     * Gets the value of the webServiceType property.
     * 
     * @return
     *     possible object is
     *     {@link WebServiceTypeEnum }
     *     
     */
    public WebServiceTypeEnum getWebServiceType() {
        return webServiceType;
    }

    /**
     * Sets the value of the webServiceType property.
     * 
     * @param value
     *     allowed object is
     *     {@link WebServiceTypeEnum }
     *     
     */
    public void setWebServiceType(WebServiceTypeEnum value) {
        this.webServiceType = value;
    }

    /**
     * Gets the value of the operatingSystem property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the operatingSystem property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getOperatingSystem().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link OperatingSystemEnum }
     * 
     * 
     */
    public List<OperatingSystemEnum> getOperatingSystem() {
        if (operatingSystem == null) {
            operatingSystem = new ArrayList<OperatingSystemEnum>();
        }
        return this.operatingSystem;
    }

    /**
     * Specifies the start date of availability of a resource - only for cases where a resource is available for a restricted time period.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getAvailabilityStartDate() {
        return availabilityStartDate;
    }

    /**
     * Sets the value of the availabilityStartDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setAvailabilityStartDate(XMLGregorianCalendar value) {
        this.availabilityStartDate = value;
    }

    /**
     * Specifies the end date of availability of a resource - only for cases where a resource is available for a restricted time period.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getAvailabilityEndDate() {
        return availabilityEndDate;
    }

    /**
     * Sets the value of the availabilityEndDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setAvailabilityEndDate(XMLGregorianCalendar value) {
        this.availabilityEndDate = value;
    }

    /**
     * Specifies the costs that are required to access the resource, a fragment of the resource or to use a component
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFee() {
        return fee;
    }

    /**
     * Sets the value of the fee property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFee(String value) {
        this.fee = value;
    }

    public List<String> getDownloadURLs() {
        if (downloadURLs == null) {
            downloadURLs = new ArrayList<String>();
        }
        return downloadURLs;
    }

    public void setDownloadURLs(List<String> downloadURLs) {
        this.downloadURLs = downloadURLs;
    }

    public List<String> getAccessURLs() {
        if (accessURLs == null) {
            accessURLs = new ArrayList<String>();
        }
        return accessURLs;
    }

    public void setAccessURLs(List<String> accessURLs) {
        this.accessURLs = accessURLs;
    }

    public RightsInfo getRightsInfo() {
        return rightsInfo;
    }

    public void setRightsInfo(RightsInfo rightsInfo) {
        this.rightsInfo = rightsInfo;
    }

    public List<CopyrightStatement> getCopyrightStatements() {
        if (copyrightStatements == null) {
            copyrightStatements = new ArrayList<CopyrightStatement>();
        }
        return copyrightStatements;
    }

    public void setCopyrightStatements(List<CopyrightStatement> copyrightStatements) {
        this.copyrightStatements = copyrightStatements;
    }

    public List<AttributionText> getAttributionTexts() {
        if (attributionTexts == null) {
            attributionTexts = new ArrayList<AttributionText>();
        }
        return attributionTexts;
    }

    public void setAttributionTexts(List<AttributionText> attributionTexts) {
        this.attributionTexts = attributionTexts;
    }

    public List<ActorInfo> getRightsHolders() {
        if (rightsHolders == null) {
            rightsHolders = new ArrayList<ActorInfo>();
        }
        return rightsHolders;
    }

    public void setRightsHolders(List<ActorInfo> rightsHolders) {
        this.rightsHolders = rightsHolders;
    }

    public List<UserTypeEnum> getUserTypes() {
        if (userTypes == null) {
            userTypes = new ArrayList<UserTypeEnum>();
        }
        return userTypes;
    }

    public void setUserTypes(List<UserTypeEnum> userTypes) {
        this.userTypes = userTypes;
    }

}
