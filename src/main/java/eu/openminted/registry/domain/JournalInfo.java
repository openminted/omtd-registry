
package eu.openminted.registry.domain;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlType;


/**
 * Base type for journals
 * 
 * <p>Java class for journalInfoType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="journalInfoType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="identifiers"&gt;
 *           &lt;complexType&gt;
 *             &lt;complexContent&gt;
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                 &lt;sequence&gt;
 *                   &lt;element name="journalIdentifier" type="{http://www.meta-share.org/OMTD-SHARE_XMLSchema}journalIdentifierType" maxOccurs="unbounded"/&gt;
 *                 &lt;/sequence&gt;
 *               &lt;/restriction&gt;
 *             &lt;/complexContent&gt;
 *           &lt;/complexType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="journalTitles"&gt;
 *           &lt;complexType&gt;
 *             &lt;complexContent&gt;
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                 &lt;sequence&gt;
 *                   &lt;element name="journalTitle" maxOccurs="unbounded"&gt;
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
 *         &lt;element ref="{http://www.meta-share.org/OMTD-SHARE_XMLSchema}publisher" minOccurs="0"/&gt;
 *         &lt;element name="languages" minOccurs="0"&gt;
 *           &lt;complexType&gt;
 *             &lt;complexContent&gt;
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                 &lt;sequence&gt;
 *                   &lt;element name="journalLanguage" type="{http://www.meta-share.org/OMTD-SHARE_XMLSchema}languageType" maxOccurs="unbounded" minOccurs="0"/&gt;
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
 *         &lt;element name="rights" minOccurs="0"&gt;
 *           &lt;complexType&gt;
 *             &lt;complexContent&gt;
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                 &lt;sequence&gt;
 *                   &lt;element ref="{http://www.meta-share.org/OMTD-SHARE_XMLSchema}rightsInfo" maxOccurs="unbounded" minOccurs="0"/&gt;
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
@XmlType(name = "journalInfoType", propOrder = {
    "identifiers",
    "journalTitles",
    "publisher",
    "languages",
    "subjects",
    "rights"
})
public class JournalInfo {

    @XmlElementWrapper(required = true)
    @XmlElement(name = "journalIdentifier", namespace = "http://www.meta-share.org/OMTD-SHARE_XMLSchema")
    protected List<JournalIdentifier> identifiers;
    @XmlElementWrapper(required = true)
    @XmlElement(name = "journalTitle", namespace = "http://www.meta-share.org/OMTD-SHARE_XMLSchema")
    protected List<JournalTitle> journalTitles;
    protected ActorInfo publisher;
    @XmlElementWrapper
    @XmlElement(name = "journalLanguage", namespace = "http://www.meta-share.org/OMTD-SHARE_XMLSchema")
    protected List<Language> languages;
    @XmlElementWrapper
    @XmlElement(name = "subject", namespace = "http://www.meta-share.org/OMTD-SHARE_XMLSchema")
    protected List<Subject> subjects;
    @XmlElementWrapper
    @XmlElement(name = "rightsInfo", namespace = "http://www.meta-share.org/OMTD-SHARE_XMLSchema")
    protected List<RightsInfo> rights;

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

    public List<JournalIdentifier> getIdentifiers() {
        if (identifiers == null) {
            identifiers = new ArrayList<JournalIdentifier>();
        }
        return identifiers;
    }

    public void setIdentifiers(List<JournalIdentifier> identifiers) {
        this.identifiers = identifiers;
    }

    public List<JournalTitle> getJournalTitles() {
        if (journalTitles == null) {
            journalTitles = new ArrayList<JournalTitle>();
        }
        return journalTitles;
    }

    public void setJournalTitles(List<JournalTitle> journalTitles) {
        this.journalTitles = journalTitles;
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

    public List<Subject> getSubjects() {
        if (subjects == null) {
            subjects = new ArrayList<Subject>();
        }
        return subjects;
    }

    public void setSubjects(List<Subject> subjects) {
        this.subjects = subjects;
    }

    public List<RightsInfo> getRights() {
        if (rights == null) {
            rights = new ArrayList<RightsInfo>();
        }
        return rights;
    }

    public void setRights(List<RightsInfo> rights) {
        this.rights = rights;
    }

}
