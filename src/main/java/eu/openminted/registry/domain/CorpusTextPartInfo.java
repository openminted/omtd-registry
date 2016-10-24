
package eu.openminted.registry.domain;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for corpusTextPartInfoType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="corpusTextPartInfoType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="mediaType" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element ref="{http://www.meta-share.org/OMTD-SHARE_XMLSchema}lingualityInfo"/&gt;
 *         &lt;element name="languages"&gt;
 *           &lt;complexType&gt;
 *             &lt;complexContent&gt;
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                 &lt;sequence&gt;
 *                   &lt;element ref="{http://www.meta-share.org/OMTD-SHARE_XMLSchema}languageInfo" maxOccurs="unbounded"/&gt;
 *                 &lt;/sequence&gt;
 *               &lt;/restriction&gt;
 *             &lt;/complexContent&gt;
 *           &lt;/complexType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="modalities" minOccurs="0"&gt;
 *           &lt;complexType&gt;
 *             &lt;complexContent&gt;
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                 &lt;sequence&gt;
 *                   &lt;element ref="{http://www.meta-share.org/OMTD-SHARE_XMLSchema}modalityInfo" maxOccurs="unbounded" minOccurs="0"/&gt;
 *                 &lt;/sequence&gt;
 *               &lt;/restriction&gt;
 *             &lt;/complexContent&gt;
 *           &lt;/complexType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="sizes"&gt;
 *           &lt;complexType&gt;
 *             &lt;complexContent&gt;
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                 &lt;sequence&gt;
 *                   &lt;element ref="{http://www.meta-share.org/OMTD-SHARE_XMLSchema}sizeInfo" maxOccurs="unbounded"/&gt;
 *                 &lt;/sequence&gt;
 *               &lt;/restriction&gt;
 *             &lt;/complexContent&gt;
 *           &lt;/complexType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="textFormats" minOccurs="0"&gt;
 *           &lt;complexType&gt;
 *             &lt;complexContent&gt;
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                 &lt;sequence&gt;
 *                   &lt;element ref="{http://www.meta-share.org/OMTD-SHARE_XMLSchema}textFormatInfo" maxOccurs="unbounded" minOccurs="0"/&gt;
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
 *                   &lt;element ref="{http://www.meta-share.org/OMTD-SHARE_XMLSchema}characterEncodingInfo" maxOccurs="unbounded" minOccurs="0"/&gt;
 *                 &lt;/sequence&gt;
 *               &lt;/restriction&gt;
 *             &lt;/complexContent&gt;
 *           &lt;/complexType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="domains" minOccurs="0"&gt;
 *           &lt;complexType&gt;
 *             &lt;complexContent&gt;
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                 &lt;sequence&gt;
 *                   &lt;element ref="{http://www.meta-share.org/OMTD-SHARE_XMLSchema}domainInfo" maxOccurs="unbounded" minOccurs="0"/&gt;
 *                 &lt;/sequence&gt;
 *               &lt;/restriction&gt;
 *             &lt;/complexContent&gt;
 *           &lt;/complexType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="textClassifications" minOccurs="0"&gt;
 *           &lt;complexType&gt;
 *             &lt;complexContent&gt;
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                 &lt;sequence&gt;
 *                   &lt;element ref="{http://www.meta-share.org/OMTD-SHARE_XMLSchema}textClassificationInfo" maxOccurs="unbounded" minOccurs="0"/&gt;
 *                 &lt;/sequence&gt;
 *               &lt;/restriction&gt;
 *             &lt;/complexContent&gt;
 *           &lt;/complexType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="timeClassifications" minOccurs="0"&gt;
 *           &lt;complexType&gt;
 *             &lt;complexContent&gt;
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                 &lt;sequence&gt;
 *                   &lt;element ref="{http://www.meta-share.org/OMTD-SHARE_XMLSchema}timeCoverageInfo" maxOccurs="unbounded" minOccurs="0"/&gt;
 *                 &lt;/sequence&gt;
 *               &lt;/restriction&gt;
 *             &lt;/complexContent&gt;
 *           &lt;/complexType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="geographicClassifications" minOccurs="0"&gt;
 *           &lt;complexType&gt;
 *             &lt;complexContent&gt;
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                 &lt;sequence&gt;
 *                   &lt;element ref="{http://www.meta-share.org/OMTD-SHARE_XMLSchema}geographicCoverageInfo" maxOccurs="unbounded" minOccurs="0"/&gt;
 *                 &lt;/sequence&gt;
 *               &lt;/restriction&gt;
 *             &lt;/complexContent&gt;
 *           &lt;/complexType&gt;
 *         &lt;/element&gt;
 *         &lt;element ref="{http://www.meta-share.org/OMTD-SHARE_XMLSchema}creationInfo" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "corpusTextPartInfoType", propOrder = {
    "mediaType",
    "lingualityInfo",
    "languages",
    "modalities",
    "sizes",
    "textFormats",
    "characterEncodings",
    "domains",
    "textClassifications",
    "timeClassifications",
    "geographicClassifications",
    "creationInfo"
})
public class CorpusTextPartInfo {

    @XmlElement(required = true)
    protected String mediaType;
    @XmlElement(required = true)
    protected LingualityInfo lingualityInfo;
    @XmlElementWrapper(required = true)
    @XmlElement(name = "languageInfo", namespace = "http://www.meta-share.org/OMTD-SHARE_XMLSchema")
    protected List<LanguageInfo> languages;
    @XmlElementWrapper
    @XmlElement(name = "modalityInfo", namespace = "http://www.meta-share.org/OMTD-SHARE_XMLSchema")
    protected List<ModalityInfo> modalities;
    @XmlElementWrapper(required = true)
    @XmlElement(name = "sizeInfo", namespace = "http://www.meta-share.org/OMTD-SHARE_XMLSchema")
    protected List<SizeInfo> sizes;
    @XmlElementWrapper
    @XmlElement(name = "textFormatInfo", namespace = "http://www.meta-share.org/OMTD-SHARE_XMLSchema")
    protected List<TextFormatInfo> textFormats;
    @XmlElementWrapper
    @XmlElement(name = "characterEncodingInfo", namespace = "http://www.meta-share.org/OMTD-SHARE_XMLSchema")
    protected List<CharacterEncodingInfo> characterEncodings;
    @XmlElementWrapper
    @XmlElement(name = "domainInfo", namespace = "http://www.meta-share.org/OMTD-SHARE_XMLSchema")
    protected List<DomainInfoType> domains;
    @XmlElementWrapper
    @XmlElement(name = "textClassificationInfo", namespace = "http://www.meta-share.org/OMTD-SHARE_XMLSchema")
    protected List<TextClassificationInfo> textClassifications;
    @XmlElementWrapper
    @XmlElement(name = "timeCoverageInfo", namespace = "http://www.meta-share.org/OMTD-SHARE_XMLSchema")
    protected List<TimeCoverageInfo> timeClassifications;
    @XmlElementWrapper
    @XmlElement(name = "geographicCoverageInfo", namespace = "http://www.meta-share.org/OMTD-SHARE_XMLSchema")
    protected List<GeographicCoverageInfo> geographicClassifications;
    protected CreationInfo creationInfo;

    /**
     * Gets the value of the mediaType property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMediaType() {
        return mediaType;
    }

    /**
     * Sets the value of the mediaType property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMediaType(String value) {
        this.mediaType = value;
    }

    /**
     * Groups information on the number of languages of the resource part and of the way they are combined to each other
     * 
     * @return
     *     possible object is
     *     {@link LingualityInfo }
     *     
     */
    public LingualityInfo getLingualityInfo() {
        return lingualityInfo;
    }

    /**
     * Sets the value of the lingualityInfo property.
     * 
     * @param value
     *     allowed object is
     *     {@link LingualityInfo }
     *     
     */
    public void setLingualityInfo(LingualityInfo value) {
        this.lingualityInfo = value;
    }

    /**
     * Groups together information on the resource creation (e.g. for corpora, selection of texts/audio files/ video files etc.; for lexica, construction of lemma list etc.)
     * 
     * @return
     *     possible object is
     *     {@link CreationInfo }
     *     
     */
    public CreationInfo getCreationInfo() {
        return creationInfo;
    }

    /**
     * Sets the value of the creationInfo property.
     * 
     * @param value
     *     allowed object is
     *     {@link CreationInfo }
     *     
     */
    public void setCreationInfo(CreationInfo value) {
        this.creationInfo = value;
    }

    public List<LanguageInfo> getLanguages() {
        if (languages == null) {
            languages = new ArrayList<LanguageInfo>();
        }
        return languages;
    }

    public void setLanguages(List<LanguageInfo> languages) {
        this.languages = languages;
    }

    public List<ModalityInfo> getModalities() {
        if (modalities == null) {
            modalities = new ArrayList<ModalityInfo>();
        }
        return modalities;
    }

    public void setModalities(List<ModalityInfo> modalities) {
        this.modalities = modalities;
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

    public List<TextFormatInfo> getTextFormats() {
        if (textFormats == null) {
            textFormats = new ArrayList<TextFormatInfo>();
        }
        return textFormats;
    }

    public void setTextFormats(List<TextFormatInfo> textFormats) {
        this.textFormats = textFormats;
    }

    public List<CharacterEncodingInfo> getCharacterEncodings() {
        if (characterEncodings == null) {
            characterEncodings = new ArrayList<CharacterEncodingInfo>();
        }
        return characterEncodings;
    }

    public void setCharacterEncodings(List<CharacterEncodingInfo> characterEncodings) {
        this.characterEncodings = characterEncodings;
    }

    public List<DomainInfoType> getDomains() {
        if (domains == null) {
            domains = new ArrayList<DomainInfoType>();
        }
        return domains;
    }

    public void setDomains(List<DomainInfoType> domains) {
        this.domains = domains;
    }

    public List<TextClassificationInfo> getTextClassifications() {
        if (textClassifications == null) {
            textClassifications = new ArrayList<TextClassificationInfo>();
        }
        return textClassifications;
    }

    public void setTextClassifications(List<TextClassificationInfo> textClassifications) {
        this.textClassifications = textClassifications;
    }

    public List<TimeCoverageInfo> getTimeClassifications() {
        if (timeClassifications == null) {
            timeClassifications = new ArrayList<TimeCoverageInfo>();
        }
        return timeClassifications;
    }

    public void setTimeClassifications(List<TimeCoverageInfo> timeClassifications) {
        this.timeClassifications = timeClassifications;
    }

    public List<GeographicCoverageInfo> getGeographicClassifications() {
        if (geographicClassifications == null) {
            geographicClassifications = new ArrayList<GeographicCoverageInfo>();
        }
        return geographicClassifications;
    }

    public void setGeographicClassifications(List<GeographicCoverageInfo> geographicClassifications) {
        this.geographicClassifications = geographicClassifications;
    }

}
