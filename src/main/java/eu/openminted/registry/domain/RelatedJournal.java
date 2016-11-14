
package eu.openminted.registry.domain;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlType;


/**
 * Base type for related journals; choice between journal titles and identifiers
 * 
 * <p>Java class for relatedJournalType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="relatedJournalType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;choice&gt;
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
 *         &lt;element name="journalIdentifiers"&gt;
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
 *       &lt;/choice&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "relatedJournalType", propOrder = {
    "journalTitles","journalIdentifiers"
})
public class RelatedJournal {

//    @XmlElements({
//        @XmlElement(name = "journalTitles", type = JournalTitles2 .class),
//        @XmlElement(name = "journalIdentifiers", type = JournalIdentifiers.class)
//    })
//    protected Object journalTitlesOrJournalIdentifiers;

    @XmlElementWrapper()
    @XmlElement(name = "journalTitle", namespace = "http://www.meta-share.org/OMTD-SHARE_XMLSchema")
    protected List<JournalTitle> journalTitles;
    
    @XmlElementWrapper()
    @XmlElement(name = "journalIdentifier", namespace = "http://www.meta-share.org/OMTD-SHARE_XMLSchema")
    protected List<JournalIdentifier> journalIdentifiers;
    
    public List<JournalIdentifier> getJournalIdentifiers() {
        if (journalIdentifiers == null) {
            journalIdentifiers = new ArrayList<JournalIdentifier>();
        }
        return journalIdentifiers;
    }

    public void setJournalIdentifiers(List<JournalIdentifier> journalIdentifiers) {
        this.journalIdentifiers = journalIdentifiers;
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

}
