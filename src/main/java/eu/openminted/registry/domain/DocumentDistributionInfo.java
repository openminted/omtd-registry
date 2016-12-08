
package eu.openminted.registry.domain;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlElements;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Java class for documentDistributionInfoType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="documentDistributionInfoType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="distributionMediums"&gt;
 *           &lt;complexType&gt;
 *             &lt;complexContent&gt;
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                 &lt;sequence&gt;
 *                   &lt;element ref="{http://www.meta-share.org/OMTD-SHARE_XMLSchema}distributionMedium" maxOccurs="unbounded"/&gt;
 *                 &lt;/sequence&gt;
 *               &lt;/restriction&gt;
 *             &lt;/complexContent&gt;
 *           &lt;/complexType&gt;
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
 *         &lt;element name="fullText" minOccurs="0"&gt;
 *           &lt;complexType&gt;
 *             &lt;simpleContent&gt;
 *               &lt;restriction base="&lt;http://www.meta-share.org/OMTD-SHARE_XMLSchema&gt;myString"&gt;
 *               &lt;/restriction&gt;
 *             &lt;/simpleContent&gt;
 *           &lt;/complexType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="mimeTypes" minOccurs="0"&gt;
 *           &lt;complexType&gt;
 *             &lt;complexContent&gt;
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                 &lt;sequence&gt;
 *                   &lt;element ref="{http://www.meta-share.org/OMTD-SHARE_XMLSchema}mimeType" maxOccurs="unbounded" minOccurs="0"/&gt;
 *                 &lt;/sequence&gt;
 *               &lt;/restriction&gt;
 *             &lt;/complexContent&gt;
 *           &lt;/complexType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="characterEncodings" minOccurs="0"&gt;
 *           &lt;complexType&gt;
 *             &lt;complexContent&gt;
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                 &lt;sequence&gt;
 *                   &lt;element ref="{http://www.meta-share.org/OMTD-SHARE_XMLSchema}characterEncoding" maxOccurs="unbounded" minOccurs="0"/&gt;
 *                 &lt;/sequence&gt;
 *               &lt;/restriction&gt;
 *             &lt;/complexContent&gt;
 *           &lt;/complexType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="sizes" minOccurs="0"&gt;
 *           &lt;complexType&gt;
 *             &lt;complexContent&gt;
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                 &lt;sequence&gt;
 *                   &lt;element ref="{http://www.meta-share.org/OMTD-SHARE_XMLSchema}sizeInfo" maxOccurs="unbounded" minOccurs="0"/&gt;
 *                 &lt;/sequence&gt;
 *               &lt;/restriction&gt;
 *             &lt;/complexContent&gt;
 *           &lt;/complexType&gt;
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
@XmlType(name = "documentDistributionInfoType", propOrder = {
    "distributionMediums",
    "downloadURLs",
    "accessURLs",
    "fullText",
    "mimeTypes",
    "characterEncodings",
    "sizes",
    "rightsInfo",
    "copyrightStatements",
    "attributionTexts",
    "rightsHolders",
    "availabilityStartDate",
    "availabilityEndDate",
    "fee",
    "userTypes"
})
public class DocumentDistributionInfo {

    @XmlElementWrapper(required = true)
    @XmlElement(name = "distributionMedium", namespace = "http://www.meta-share.org/OMTD-SHARE_XMLSchema")
    protected List<DistributionMediumEnum> distributionMediums;
    @XmlElementWrapper
    @XmlElement(name = "downloadURL", namespace = "http://www.meta-share.org/OMTD-SHARE_XMLSchema")
    protected List<String> downloadURLs;
    @XmlElementWrapper
    @XmlElement(name = "accessURL", namespace = "http://www.meta-share.org/OMTD-SHARE_XMLSchema")
    protected List<String> accessURLs;
    protected FullText fullText;
    @XmlElementWrapper
    @XmlElement(name = "mimeType", namespace = "http://www.meta-share.org/OMTD-SHARE_XMLSchema")
    protected List<MimeTypeEnum> mimeTypes;
    @XmlElementWrapper
    @XmlElement(name = "characterEncoding", namespace = "http://www.meta-share.org/OMTD-SHARE_XMLSchema")
    protected List<CharacterEncodingEnum> characterEncodings;
    @XmlElementWrapper
    @XmlElement(name = "sizeInfo", namespace = "http://www.meta-share.org/OMTD-SHARE_XMLSchema")
    protected List<SizeInfo> sizes;
    @XmlElementWrapper(required = true)
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
     * Gets the value of the fullText property.
     * 
     * @return
     *     possible object is
     *     {@link FullText }
     *     
     */
    public FullText getFullText() {
        return fullText;
    }

    /**
     * Sets the value of the fullText property.
     * 
     * @param value
     *     allowed object is
     *     {@link FullText }
     *     
     */
    public void setFullText(FullText value) {
        this.fullText = value;
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

    public List<DistributionMediumEnum> getDistributionMediums() {
        if (distributionMediums == null) {
            distributionMediums = new ArrayList<DistributionMediumEnum>();
        }
        return distributionMediums;
    }

    public void setDistributionMediums(List<DistributionMediumEnum> distributionMediums) {
        this.distributionMediums = distributionMediums;
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

    public List<MimeTypeEnum> getMimeTypes() {
        if (mimeTypes == null) {
            mimeTypes = new ArrayList<MimeTypeEnum>();
        }
        return mimeTypes;
    }

    public void setMimeTypes(List<MimeTypeEnum> mimeTypes) {
        this.mimeTypes = mimeTypes;
    }

    public List<CharacterEncodingEnum> getCharacterEncodings() {
        if (characterEncodings == null) {
            characterEncodings = new ArrayList<CharacterEncodingEnum>();
        }
        return characterEncodings;
    }

    public void setCharacterEncodings(List<CharacterEncodingEnum> characterEncodings) {
        this.characterEncodings = characterEncodings;
    }

    public List<SizeInfo> getSizes() {
        if (sizes == null) {
            sizes = new ArrayList<SizeInfo>();
        }
        return sizes;
    }

    public void setSizes(List<SizeInfo> sizes) {
        this.sizes = sizes;
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
