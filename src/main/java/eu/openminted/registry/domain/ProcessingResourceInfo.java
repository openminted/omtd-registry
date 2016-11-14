
package eu.openminted.registry.domain;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for processingResourceInfoType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="processingResourceInfoType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="resourceTypes"&gt;
 *           &lt;complexType&gt;
 *             &lt;complexContent&gt;
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                 &lt;sequence&gt;
 *                   &lt;element name="resourceType" maxOccurs="unbounded" minOccurs="0"&gt;
 *                     &lt;simpleType&gt;
 *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *                         &lt;maxLength value="30"/&gt;
 *                         &lt;enumeration value="corpus"/&gt;
 *                         &lt;enumeration value="document"/&gt;
 *                         &lt;enumeration value="userInputText"/&gt;
 *                         &lt;enumeration value="lexicalConceptualResource"/&gt;
 *                         &lt;enumeration value="languageDescription"/&gt;
 *                       &lt;/restriction&gt;
 *                     &lt;/simpleType&gt;
 *                   &lt;/element&gt;
 *                 &lt;/sequence&gt;
 *               &lt;/restriction&gt;
 *             &lt;/complexContent&gt;
 *           &lt;/complexType&gt;
 *         &lt;/element&gt;
 *         &lt;element ref="{http://www.meta-share.org/OMTD-SHARE_XMLSchema}mediaType"/&gt;
 *         &lt;element name="languages" minOccurs="0"&gt;
 *           &lt;complexType&gt;
 *             &lt;complexContent&gt;
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                 &lt;sequence&gt;
 *                   &lt;element ref="{http://www.meta-share.org/OMTD-SHARE_XMLSchema}language" maxOccurs="unbounded" minOccurs="0"/&gt;
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
 *         &lt;element name="dataFormats" minOccurs="0"&gt;
 *           &lt;complexType&gt;
 *             &lt;complexContent&gt;
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                 &lt;sequence&gt;
 *                   &lt;element ref="{http://www.meta-share.org/OMTD-SHARE_XMLSchema}dataFormat" maxOccurs="unbounded" minOccurs="0"/&gt;
 *                 &lt;/sequence&gt;
 *               &lt;/restriction&gt;
 *             &lt;/complexContent&gt;
 *           &lt;/complexType&gt;
 *         &lt;/element&gt;
 *         &lt;element ref="{http://www.meta-share.org/OMTD-SHARE_XMLSchema}typesystem" minOccurs="0"/&gt;
 *         &lt;element ref="{http://www.meta-share.org/OMTD-SHARE_XMLSchema}tagset" minOccurs="0"/&gt;
 *         &lt;element name="annotationLevels" minOccurs="0"&gt;
 *           &lt;complexType&gt;
 *             &lt;complexContent&gt;
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                 &lt;sequence&gt;
 *                   &lt;element ref="{http://www.meta-share.org/OMTD-SHARE_XMLSchema}annotationLevel" maxOccurs="unbounded" minOccurs="0"/&gt;
 *                 &lt;/sequence&gt;
 *               &lt;/restriction&gt;
 *             &lt;/complexContent&gt;
 *           &lt;/complexType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="modalityTypes" minOccurs="0"&gt;
 *           &lt;complexType&gt;
 *             &lt;complexContent&gt;
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                 &lt;sequence&gt;
 *                   &lt;element ref="{http://www.meta-share.org/OMTD-SHARE_XMLSchema}modalityType" maxOccurs="unbounded" minOccurs="0"/&gt;
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
 *                   &lt;element ref="{http://www.meta-share.org/OMTD-SHARE_XMLSchema}domain" maxOccurs="unbounded" minOccurs="0"/&gt;
 *                 &lt;/sequence&gt;
 *               &lt;/restriction&gt;
 *             &lt;/complexContent&gt;
 *           &lt;/complexType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="textGenres" minOccurs="0"&gt;
 *           &lt;complexType&gt;
 *             &lt;complexContent&gt;
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                 &lt;sequence&gt;
 *                   &lt;element ref="{http://www.meta-share.org/OMTD-SHARE_XMLSchema}textGenre" maxOccurs="unbounded" minOccurs="0"/&gt;
 *                 &lt;/sequence&gt;
 *               &lt;/restriction&gt;
 *             &lt;/complexContent&gt;
 *           &lt;/complexType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="textTypes" minOccurs="0"&gt;
 *           &lt;complexType&gt;
 *             &lt;complexContent&gt;
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                 &lt;sequence&gt;
 *                   &lt;element ref="{http://www.meta-share.org/OMTD-SHARE_XMLSchema}textType" maxOccurs="unbounded" minOccurs="0"/&gt;
 *                 &lt;/sequence&gt;
 *               &lt;/restriction&gt;
 *             &lt;/complexContent&gt;
 *           &lt;/complexType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="registers" minOccurs="0"&gt;
 *           &lt;complexType&gt;
 *             &lt;complexContent&gt;
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                 &lt;sequence&gt;
 *                   &lt;element ref="{http://www.meta-share.org/OMTD-SHARE_XMLSchema}register" maxOccurs="unbounded" minOccurs="0"/&gt;
 *                 &lt;/sequence&gt;
 *               &lt;/restriction&gt;
 *             &lt;/complexContent&gt;
 *           &lt;/complexType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="subjects" minOccurs="0"&gt;
 *           &lt;complexType&gt;
 *             &lt;complexContent&gt;
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                 &lt;sequence&gt;
 *                   &lt;element ref="{http://www.meta-share.org/OMTD-SHARE_XMLSchema}subject" maxOccurs="unbounded" minOccurs="0"/&gt;
 *                 &lt;/sequence&gt;
 *               &lt;/restriction&gt;
 *             &lt;/complexContent&gt;
 *           &lt;/complexType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="keywords" minOccurs="0"&gt;
 *           &lt;complexType&gt;
 *             &lt;complexContent&gt;
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                 &lt;sequence&gt;
 *                   &lt;element ref="{http://www.meta-share.org/OMTD-SHARE_XMLSchema}keyword" maxOccurs="unbounded" minOccurs="0"/&gt;
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
@XmlType(name = "processingResourceInfoType", propOrder = {
    "resourceTypes",
    "mediaType",
    "languages",
    "characterEncodings",
    "dataFormats",
    "typesystem",
    "tagset",
    "annotationLevels",
    "modalityTypes",
    "domains",
    "textGenres",
    "textTypes",
    "registers",
    "subjects",
    "keywords"
})
public class ProcessingResourceInfo {

    @XmlElementWrapper(required = true)
    @XmlElement(name = "resourceType", namespace = "http://www.meta-share.org/OMTD-SHARE_XMLSchema")
    protected List<ResourceTypeEnum> resourceTypes;
    @XmlElement(required = true)
    protected MediaTypeEnum mediaType;
    @XmlElementWrapper
    @XmlElement(name = "language", namespace = "http://www.meta-share.org/OMTD-SHARE_XMLSchema")
    protected List<Language> languages;
    @XmlElementWrapper
    @XmlElement(name = "characterEncoding", namespace = "http://www.meta-share.org/OMTD-SHARE_XMLSchema")
    protected List<CharacterEncodingEnum> characterEncodings;
    @XmlElementWrapper
    @XmlElement(name = "dataFormat", namespace = "http://www.meta-share.org/OMTD-SHARE_XMLSchema")
    protected List<DataFormat> dataFormats;
    protected RelatedResource typesystem;
    protected RelatedResource tagset;
    @XmlElementWrapper
    @XmlElement(name = "annotationLevel", namespace = "http://www.meta-share.org/OMTD-SHARE_XMLSchema")
    protected List<AnnotationLevelEnum> annotationLevels;
    @XmlElementWrapper
    @XmlElement(name = "modalityType", namespace = "http://www.meta-share.org/OMTD-SHARE_XMLSchema")
    protected List<ModalityTypeEnum> modalityTypes;
    @XmlElementWrapper
    @XmlElement(name = "domain", namespace = "http://www.meta-share.org/OMTD-SHARE_XMLSchema")
    protected List<Domain> domains;
    @XmlElementWrapper
    @XmlElement(name = "textGenre", namespace = "http://www.meta-share.org/OMTD-SHARE_XMLSchema")
    protected List<TextGenre> textGenres;
    @XmlElementWrapper
    @XmlElement(name = "textType", namespace = "http://www.meta-share.org/OMTD-SHARE_XMLSchema")
    protected List<Text> textTypes;
    @XmlElementWrapper
    @XmlElement(name = "register", namespace = "http://www.meta-share.org/OMTD-SHARE_XMLSchema")
    protected List<Register> registers;
    @XmlElementWrapper
    @XmlElement(name = "subject", namespace = "http://www.meta-share.org/OMTD-SHARE_XMLSchema")
    protected List<Subject> subjects;
    @XmlElementWrapper
    @XmlElement(name = "keyword", namespace = "http://www.meta-share.org/OMTD-SHARE_XMLSchema")
    protected List<String> keywords;

    /**
     * Gets the value of the mediaType property.
     * 
     * @return
     *     possible object is
     *     {@link MediaTypeEnum }
     *     
     */
    public MediaTypeEnum getMediaType() {
        return mediaType;
    }

    /**
     * Sets the value of the mediaType property.
     * 
     * @param value
     *     allowed object is
     *     {@link MediaTypeEnum }
     *     
     */
    public void setMediaType(MediaTypeEnum value) {
        this.mediaType = value;
    }

    /**
     * Gets the value of the typesystem property.
     * 
     * @return
     *     possible object is
     *     {@link RelatedResource }
     *     
     */
    public RelatedResource getTypesystem() {
        return typesystem;
    }

    /**
     * Sets the value of the typesystem property.
     * 
     * @param value
     *     allowed object is
     *     {@link RelatedResource }
     *     
     */
    public void setTypesystem(RelatedResource value) {
        this.typesystem = value;
    }

    /**
     * Gets the value of the tagset property.
     * 
     * @return
     *     possible object is
     *     {@link RelatedResource }
     *     
     */
    public RelatedResource getTagset() {
        return tagset;
    }

    /**
     * Sets the value of the tagset property.
     * 
     * @param value
     *     allowed object is
     *     {@link RelatedResource }
     *     
     */
    public void setTagset(RelatedResource value) {
        this.tagset = value;
    }

    public List<ResourceTypeEnum> getResourceTypes() {
        if (resourceTypes == null) {
            resourceTypes = new ArrayList<ResourceTypeEnum>();
        }
        return resourceTypes;
    }

    public void setResourceTypes(List<ResourceTypeEnum> resourceTypes) {
        this.resourceTypes = resourceTypes;
    }

    public List<Language> getLanguages() {
        if (languages == null) {
            languages = new ArrayList<Language>();
        }
        return languages;
    }

    public void setLanguages(List<Language> languages) {
        this.languages = languages;
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

    public List<DataFormat> getDataFormats() {
        if (dataFormats == null) {
            dataFormats = new ArrayList<DataFormat>();
        }
        return dataFormats;
    }

    public void setDataFormats(List<DataFormat> dataFormats) {
        this.dataFormats = dataFormats;
    }

    public List<AnnotationLevelEnum> getAnnotationLevels() {
        if (annotationLevels == null) {
            annotationLevels = new ArrayList<AnnotationLevelEnum>();
        }
        return annotationLevels;
    }

    public void setAnnotationLevels(List<AnnotationLevelEnum> annotationLevels) {
        this.annotationLevels = annotationLevels;
    }

    public List<ModalityTypeEnum> getModalityTypes() {
        if (modalityTypes == null) {
            modalityTypes = new ArrayList<ModalityTypeEnum>();
        }
        return modalityTypes;
    }

    public void setModalityTypes(List<ModalityTypeEnum> modalityTypes) {
        this.modalityTypes = modalityTypes;
    }

    public List<Domain> getDomains() {
        if (domains == null) {
            domains = new ArrayList<Domain>();
        }
        return domains;
    }

    public void setDomains(List<Domain> domains) {
        this.domains = domains;
    }

    public List<TextGenre> getTextGenres() {
        if (textGenres == null) {
            textGenres = new ArrayList<TextGenre>();
        }
        return textGenres;
    }

    public void setTextGenres(List<TextGenre> textGenres) {
        this.textGenres = textGenres;
    }

    public List<Text> getTextTypes() {
        if (textTypes == null) {
            textTypes = new ArrayList<Text>();
        }
        return textTypes;
    }

    public void setTextTypes(List<Text> textTypes) {
        this.textTypes = textTypes;
    }

    public List<Register> getRegisters() {
        if (registers == null) {
            registers = new ArrayList<Register>();
        }
        return registers;
    }

    public void setRegisters(List<Register> registers) {
        this.registers = registers;
    }

    public List<Subject> getSubjects() {
        if (subjects == null) {
            subjects = new ArrayList<Subject>();
        }
        return subjects;
    }

    public void setSubjects(List<Subject> subjects) {
        this.subjects = subjects;
    }

    public List<String> getKeywords() {
        if (keywords == null) {
            keywords = new ArrayList<String>();
        }
        return keywords;
    }

    public void setKeywords(List<String> keywords) {
        this.keywords = keywords;
    }

}
