
package eu.openminted.registry.domain;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlType;


/**
 * Base type for documents (single files) mainly intended for publications
 * 
 * <p>Java class for documentInfoType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="documentInfoType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="documentType"&gt;
 *           &lt;simpleType&gt;
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *               &lt;enumeration value="bibliographicRecordOnly"/&gt;
 *               &lt;enumeration value="abstract"/&gt;
 *               &lt;enumeration value="fullText"/&gt;
 *             &lt;/restriction&gt;
 *           &lt;/simpleType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="publicationType"&gt;
 *           &lt;simpleType&gt;
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *               &lt;maxLength value="30"/&gt;
 *               &lt;enumeration value="article"/&gt;
 *               &lt;enumeration value="bachelorThesis"/&gt;
 *               &lt;enumeration value="masterThesis"/&gt;
 *               &lt;enumeration value="doctoralThesis"/&gt;
 *               &lt;enumeration value="book"/&gt;
 *               &lt;enumeration value="bookPart"/&gt;
 *               &lt;enumeration value="review"/&gt;
 *               &lt;enumeration value="conferenceObject"/&gt;
 *               &lt;enumeration value="lecture"/&gt;
 *               &lt;enumeration value="workingPaper"/&gt;
 *               &lt;enumeration value="prePrint"/&gt;
 *               &lt;enumeration value="report"/&gt;
 *               &lt;enumeration value="annotation"/&gt;
 *               &lt;enumeration value="contributionToPeriodical"/&gt;
 *               &lt;enumeration value="patent"/&gt;
 *               &lt;enumeration value="inProceedings"/&gt;
 *               &lt;enumeration value="booklet"/&gt;
 *               &lt;enumeration value="manual"/&gt;
 *               &lt;enumeration value="techReport"/&gt;
 *               &lt;enumeration value="inCollection"/&gt;
 *               &lt;enumeration value="unpublished"/&gt;
 *               &lt;enumeration value="other"/&gt;
 *             &lt;/restriction&gt;
 *           &lt;/simpleType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="identifiers"&gt;
 *           &lt;complexType&gt;
 *             &lt;complexContent&gt;
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                 &lt;sequence&gt;
 *                   &lt;element name="publicationIdentifier" type="{http://www.meta-share.org/OMTD-SHARE_XMLSchema}publicationIdentifierType" maxOccurs="unbounded"/&gt;
 *                 &lt;/sequence&gt;
 *               &lt;/restriction&gt;
 *             &lt;/complexContent&gt;
 *           &lt;/complexType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="titles"&gt;
 *           &lt;complexType&gt;
 *             &lt;complexContent&gt;
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                 &lt;sequence&gt;
 *                   &lt;element name="title" maxOccurs="unbounded"&gt;
 *                     &lt;complexType&gt;
 *                       &lt;simpleContent&gt;
 *                         &lt;extension base="&lt;http://www.meta-share.org/OMTD-SHARE_XMLSchema&gt;myString"&gt;
 *                           &lt;attribute name="titleType"&gt;
 *                             &lt;simpleType&gt;
 *                               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *                                 &lt;enumeration value="alternativeTitle"/&gt;
 *                                 &lt;enumeration value="subtitle"/&gt;
 *                                 &lt;enumeration value="translatedTitle"/&gt;
 *                                 &lt;enumeration value="other"/&gt;
 *                               &lt;/restriction&gt;
 *                             &lt;/simpleType&gt;
 *                           &lt;/attribute&gt;
 *                         &lt;/extension&gt;
 *                       &lt;/simpleContent&gt;
 *                     &lt;/complexType&gt;
 *                   &lt;/element&gt;
 *                 &lt;/sequence&gt;
 *               &lt;/restriction&gt;
 *             &lt;/complexContent&gt;
 *           &lt;/complexType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="authors" minOccurs="0"&gt;
 *           &lt;complexType&gt;
 *             &lt;complexContent&gt;
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                 &lt;sequence&gt;
 *                   &lt;element name="author" type="{http://www.meta-share.org/OMTD-SHARE_XMLSchema}relatedPersonType" maxOccurs="unbounded" minOccurs="0"/&gt;
 *                 &lt;/sequence&gt;
 *               &lt;/restriction&gt;
 *             &lt;/complexContent&gt;
 *           &lt;/complexType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="contributors" minOccurs="0"&gt;
 *           &lt;complexType&gt;
 *             &lt;complexContent&gt;
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                 &lt;sequence&gt;
 *                   &lt;element name="contributor" maxOccurs="unbounded" minOccurs="0"&gt;
 *                     &lt;complexType&gt;
 *                       &lt;complexContent&gt;
 *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                           &lt;choice&gt;
 *                             &lt;element name="relatedPerson"&gt;
 *                               &lt;complexType&gt;
 *                                 &lt;complexContent&gt;
 *                                   &lt;extension base="{http://www.meta-share.org/OMTD-SHARE_XMLSchema}relatedPersonType"&gt;
 *                                     &lt;attribute name="contributorType"&gt;
 *                                       &lt;simpleType&gt;
 *                                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *                                           &lt;enumeration value="editor"/&gt;
 *                                           &lt;enumeration value="translator"/&gt;
 *                                           &lt;enumeration value="other"/&gt;
 *                                         &lt;/restriction&gt;
 *                                       &lt;/simpleType&gt;
 *                                     &lt;/attribute&gt;
 *                                   &lt;/extension&gt;
 *                                 &lt;/complexContent&gt;
 *                               &lt;/complexType&gt;
 *                             &lt;/element&gt;
 *                             &lt;element name="relatedOrganization"&gt;
 *                               &lt;complexType&gt;
 *                                 &lt;complexContent&gt;
 *                                   &lt;extension base="{http://www.meta-share.org/OMTD-SHARE_XMLSchema}relatedOrganizationType"&gt;
 *                                     &lt;attribute name="contributorType"&gt;
 *                                       &lt;simpleType&gt;
 *                                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *                                           &lt;enumeration value="editor"/&gt;
 *                                           &lt;enumeration value="translator"/&gt;
 *                                           &lt;enumeration value="other"/&gt;
 *                                         &lt;/restriction&gt;
 *                                       &lt;/simpleType&gt;
 *                                     &lt;/attribute&gt;
 *                                   &lt;/extension&gt;
 *                                 &lt;/complexContent&gt;
 *                               &lt;/complexType&gt;
 *                             &lt;/element&gt;
 *                           &lt;/choice&gt;
 *                         &lt;/restriction&gt;
 *                       &lt;/complexContent&gt;
 *                     &lt;/complexType&gt;
 *                   &lt;/element&gt;
 *                 &lt;/sequence&gt;
 *               &lt;/restriction&gt;
 *             &lt;/complexContent&gt;
 *           &lt;/complexType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="publicationDate" type="{http://www.meta-share.org/OMTD-SHARE_XMLSchema}dateType" minOccurs="0"/&gt;
 *         &lt;element ref="{http://www.meta-share.org/OMTD-SHARE_XMLSchema}publisher" minOccurs="0"/&gt;
 *         &lt;element ref="{http://www.meta-share.org/OMTD-SHARE_XMLSchema}journal" minOccurs="0"/&gt;
 *         &lt;element name="inBook" type="{http://www.meta-share.org/OMTD-SHARE_XMLSchema}relatedDocumentInfoType" minOccurs="0"/&gt;
 *         &lt;element name="volume" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="series" minOccurs="0"&gt;
 *           &lt;simpleType&gt;
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *               &lt;maxLength value="200"/&gt;
 *             &lt;/restriction&gt;
 *           &lt;/simpleType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="pages" minOccurs="0"&gt;
 *           &lt;simpleType&gt;
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *               &lt;maxLength value="100"/&gt;
 *             &lt;/restriction&gt;
 *           &lt;/simpleType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="edition" minOccurs="0"&gt;
 *           &lt;simpleType&gt;
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *               &lt;maxLength value="100"/&gt;
 *             &lt;/restriction&gt;
 *           &lt;/simpleType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="conference" minOccurs="0"&gt;
 *           &lt;simpleType&gt;
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *               &lt;maxLength value="300"/&gt;
 *             &lt;/restriction&gt;
 *           &lt;/simpleType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="distributions"&gt;
 *           &lt;complexType&gt;
 *             &lt;complexContent&gt;
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                 &lt;sequence&gt;
 *                   &lt;element ref="{http://www.meta-share.org/OMTD-SHARE_XMLSchema}documentDistributionInfo" maxOccurs="unbounded"/&gt;
 *                 &lt;/sequence&gt;
 *               &lt;/restriction&gt;
 *             &lt;/complexContent&gt;
 *           &lt;/complexType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="documentLanguages" minOccurs="0"&gt;
 *           &lt;complexType&gt;
 *             &lt;complexContent&gt;
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                 &lt;sequence&gt;
 *                   &lt;element name="documentLanguage" type="{http://www.meta-share.org/OMTD-SHARE_XMLSchema}languageType" maxOccurs="unbounded" minOccurs="0"/&gt;
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
 *         &lt;element name="fundingProjects" minOccurs="0"&gt;
 *           &lt;complexType&gt;
 *             &lt;complexContent&gt;
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                 &lt;sequence&gt;
 *                   &lt;element name="fundingProject" type="{http://www.meta-share.org/OMTD-SHARE_XMLSchema}relatedProjectType" maxOccurs="unbounded" minOccurs="0"/&gt;
 *                 &lt;/sequence&gt;
 *               &lt;/restriction&gt;
 *             &lt;/complexContent&gt;
 *           &lt;/complexType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="abstracts" minOccurs="0"&gt;
 *           &lt;complexType&gt;
 *             &lt;complexContent&gt;
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                 &lt;sequence&gt;
 *                   &lt;element name="abstract" maxOccurs="unbounded" minOccurs="0"&gt;
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
 *         &lt;element name="sizes" minOccurs="0"&gt;
 *           &lt;complexType&gt;
 *             &lt;complexContent&gt;
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                 &lt;sequence&gt;
 *                   &lt;element name="sizeInfo" type="{http://www.meta-share.org/OMTD-SHARE_XMLSchema}sizeInfoType" maxOccurs="unbounded" minOccurs="0"/&gt;
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
@XmlType(name = "documentInfoType", propOrder = {
    "documentType",
    "publicationType",
    "identifiers",
    "titles",
    "authors",
    "contributors",
    "publicationDate",
    "publisher",
    "journal",
    "inBook",
    "volume",
    "series",
    "pages",
    "edition",
    "conference",
    "distributions",
    "documentLanguages",
    "subjects",
    "keywords",
    "fundingProjects",
    "abstracts",
    "sizes"
})
public class DocumentInfo {

    @XmlElement(required = true)
    protected DocumentTypeEnum documentType;
    @XmlElement(required = true)
    protected PublicationTypeEnum publicationType;
    @XmlElementWrapper(required = true)
    @XmlElement(name = "publicationIdentifier", namespace = "http://www.meta-share.org/OMTD-SHARE_XMLSchema")
    protected List<PublicationIdentifier> identifiers;
    @XmlElementWrapper(required = true)
    @XmlElement(name = "title", namespace = "http://www.meta-share.org/OMTD-SHARE_XMLSchema")
    protected List<Title> titles;
    @XmlElementWrapper
    @XmlElement(name = "author", namespace = "http://www.meta-share.org/OMTD-SHARE_XMLSchema")
    protected List<RelatedPerson> authors;
    @XmlElementWrapper
    @XmlElement(name = "contributor", namespace = "http://www.meta-share.org/OMTD-SHARE_XMLSchema")
    protected List<Contributor> contributors;
    protected Date publicationDate;
    protected ActorInfo publisher;
    protected RelatedJournal journal;
    protected RelatedDocumentInfo inBook;
    protected String volume;
    protected String series;
    protected String pages;
    protected String edition;
    protected String conference;
    @XmlElementWrapper(required = true)
    @XmlElement(name = "documentDistributionInfo", namespace = "http://www.meta-share.org/OMTD-SHARE_XMLSchema")
    protected List<DocumentDistributionInfo> distributions;
    @XmlElementWrapper
    @XmlElement(name = "documentLanguage", namespace = "http://www.meta-share.org/OMTD-SHARE_XMLSchema")
    protected List<Language> documentLanguages;
    @XmlElementWrapper
    @XmlElement(name = "subject", namespace = "http://www.meta-share.org/OMTD-SHARE_XMLSchema")
    protected List<Subject> subjects;
    @XmlElementWrapper
    @XmlElement(name = "keyword", namespace = "http://www.meta-share.org/OMTD-SHARE_XMLSchema")
    protected List<String> keywords;
    @XmlElementWrapper
    @XmlElement(name = "fundingProject", namespace = "http://www.meta-share.org/OMTD-SHARE_XMLSchema")
    protected List<RelatedProject> fundingProjects;
    @XmlElementWrapper
    @XmlElement(name = "abstract", namespace = "http://www.meta-share.org/OMTD-SHARE_XMLSchema")
    protected List<Abstract> abstracts;
    @XmlElementWrapper
    @XmlElement(name = "sizeInfo", namespace = "http://www.meta-share.org/OMTD-SHARE_XMLSchema")
    protected List<SizeInfo> sizes;

    /**
     * Gets the value of the documentType property.
     * 
     * @return
     *     possible object is
     *     {@link DocumentTypeEnum }
     *     
     */
    public DocumentTypeEnum getDocumentType() {
        return documentType;
    }

    /**
     * Sets the value of the documentType property.
     * 
     * @param value
     *     allowed object is
     *     {@link DocumentTypeEnum }
     *     
     */
    public void setDocumentType(DocumentTypeEnum value) {
        this.documentType = value;
    }

    /**
     * Gets the value of the publicationType property.
     * 
     * @return
     *     possible object is
     *     {@link PublicationTypeEnum }
     *     
     */
    public PublicationTypeEnum getPublicationType() {
        return publicationType;
    }

    /**
     * Sets the value of the publicationType property.
     * 
     * @param value
     *     allowed object is
     *     {@link PublicationTypeEnum }
     *     
     */
    public void setPublicationType(PublicationTypeEnum value) {
        this.publicationType = value;
    }

    /**
     * Gets the value of the publicationDate property.
     * 
     * @return
     *     possible object is
     *     {@link Date }
     *     
     */
    public Date getPublicationDate() {
        return publicationDate;
    }

    /**
     * Sets the value of the publicationDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link Date }
     *     
     */
    public void setPublicationDate(Date value) {
        this.publicationDate = value;
    }

    /**
     * Gets the value of the publisher property.
     * 
     * @return
     *     possible object is
     *     {@link ActorInfo }
     *     
     */
    public ActorInfo getPublisher() {
        return publisher;
    }

    /**
     * Sets the value of the publisher property.
     * 
     * @param value
     *     allowed object is
     *     {@link ActorInfo }
     *     
     */
    public void setPublisher(ActorInfo value) {
        this.publisher = value;
    }

    /**
     * Gets the value of the journal property.
     * 
     * @return
     *     possible object is
     *     {@link RelatedJournal }
     *     
     */
    public RelatedJournal getJournal() {
        return journal;
    }

    /**
     * Sets the value of the journal property.
     * 
     * @param value
     *     allowed object is
     *     {@link RelatedJournal }
     *     
     */
    public void setJournal(RelatedJournal value) {
        this.journal = value;
    }

    /**
     * Gets the value of the inBook property.
     * 
     * @return
     *     possible object is
     *     {@link RelatedDocumentInfo }
     *     
     */
    public RelatedDocumentInfo getInBook() {
        return inBook;
    }

    /**
     * Sets the value of the inBook property.
     * 
     * @param value
     *     allowed object is
     *     {@link RelatedDocumentInfo }
     *     
     */
    public void setInBook(RelatedDocumentInfo value) {
        this.inBook = value;
    }

    /**
     * Gets the value of the volume property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getVolume() {
        return volume;
    }

    /**
     * Sets the value of the volume property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setVolume(String value) {
        this.volume = value;
    }

    /**
     * Gets the value of the series property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSeries() {
        return series;
    }

    /**
     * Sets the value of the series property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSeries(String value) {
        this.series = value;
    }

    /**
     * Gets the value of the pages property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPages() {
        return pages;
    }

    /**
     * Sets the value of the pages property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPages(String value) {
        this.pages = value;
    }

    /**
     * Gets the value of the edition property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getEdition() {
        return edition;
    }

    /**
     * Sets the value of the edition property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setEdition(String value) {
        this.edition = value;
    }

    /**
     * Gets the value of the conference property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getConference() {
        return conference;
    }

    /**
     * Sets the value of the conference property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setConference(String value) {
        this.conference = value;
    }

    public List<PublicationIdentifier> getIdentifiers() {
        if (identifiers == null) {
            identifiers = new ArrayList<PublicationIdentifier>();
        }
        return identifiers;
    }

    public void setIdentifiers(List<PublicationIdentifier> identifiers) {
        this.identifiers = identifiers;
    }

    public List<Title> getTitles() {
        if (titles == null) {
            titles = new ArrayList<Title>();
        }
        return titles;
    }

    public void setTitles(List<Title> titles) {
        this.titles = titles;
    }

    public List<RelatedPerson> getAuthors() {
        if (authors == null) {
            authors = new ArrayList<RelatedPerson>();
        }
        return authors;
    }

    public void setAuthors(List<RelatedPerson> authors) {
        this.authors = authors;
    }

    public List<Contributor> getContributors() {
        if (contributors == null) {
            contributors = new ArrayList<Contributor>();
        }
        return contributors;
    }

    public void setContributors(List<Contributor> contributors) {
        this.contributors = contributors;
    }

    public List<DocumentDistributionInfo> getDistributions() {
        if (distributions == null) {
            distributions = new ArrayList<DocumentDistributionInfo>();
        }
        return distributions;
    }

    public void setDistributions(List<DocumentDistributionInfo> distributions) {
        this.distributions = distributions;
    }

    public List<Language> getDocumentLanguages() {
        if (documentLanguages == null) {
            documentLanguages = new ArrayList<Language>();
        }
        return documentLanguages;
    }

    public void setDocumentLanguages(List<Language> documentLanguages) {
        this.documentLanguages = documentLanguages;
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

    public List<RelatedProject> getFundingProjects() {
        if (fundingProjects == null) {
            fundingProjects = new ArrayList<RelatedProject>();
        }
        return fundingProjects;
    }

    public void setFundingProjects(List<RelatedProject> fundingProjects) {
        this.fundingProjects = fundingProjects;
    }

    public List<Abstract> getAbstracts() {
        if (abstracts == null) {
            abstracts = new ArrayList<Abstract>();
        }
        return abstracts;
    }

    public void setAbstracts(List<Abstract> abstracts) {
        this.abstracts = abstracts;
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

}
