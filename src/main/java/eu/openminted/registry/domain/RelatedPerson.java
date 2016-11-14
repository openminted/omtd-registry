
package eu.openminted.registry.domain;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlType;


/**
 * Base type for related persons; choice between person names and person identifiers
 * 
 * <p>Java class for relatedPersonType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="relatedPersonType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;choice&gt;
 *         &lt;element name="personNames"&gt;
 *           &lt;complexType&gt;
 *             &lt;complexContent&gt;
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                 &lt;sequence&gt;
 *                   &lt;element name="personName" maxOccurs="unbounded"&gt;
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
 *         &lt;element name="personIdentifiers"&gt;
 *           &lt;complexType&gt;
 *             &lt;complexContent&gt;
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                 &lt;sequence&gt;
 *                   &lt;element name="personIdentifier" type="{http://www.meta-share.org/OMTD-SHARE_XMLSchema}personIdentifierType" maxOccurs="unbounded"/&gt;
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
@XmlType(name = "relatedPersonType", propOrder = {
    "personNames","personIdentifiers"
})
public class RelatedPerson {

    // @XmlElements({
    //     @XmlElement(name = "personNames", type = PersonNames.class),
    //     @XmlElement(name = "personIdentifiers", type = PersonIdentifiers.class)
    // })
    // protected Object personNamesOrPersonIdentifiers;

    @XmlElementWrapper
    @XmlElement(name = "personName", namespace = "http://www.meta-share.org/OMTD-SHARE_XMLSchema")
    protected List<PersonName> personNames;

    @XmlElementWrapper
    @XmlElement(name = "personIdentifier", namespace = "http://www.meta-share.org/OMTD-SHARE_XMLSchema")
    protected List<PersonIdentifier> personIdentifiers;
    
    public List<PersonName> getPersonNames() {
        if (personNames == null) {
            personNames = new ArrayList<PersonName>();
        }
        return personNames;
    }

    public void setPersonNames(List<PersonName> personNames) {
        this.personNames = personNames;
    }
    
    public List<PersonIdentifier> getPersonIdentifiers() {
        if (personIdentifiers == null) {
            personIdentifiers = new ArrayList<PersonIdentifier>();
        }
        return personIdentifiers;
    }

    public void setPersonIdentifiers(List<PersonIdentifier> personIdentifiers) {
        this.personIdentifiers = personIdentifiers;
    }

}
