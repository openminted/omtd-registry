
package eu.openminted.registry.domain;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for personInfoType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="personInfoType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;choice&gt;
 *           &lt;sequence&gt;
 *             &lt;element name="surnames"&gt;
 *               &lt;complexType&gt;
 *                 &lt;complexContent&gt;
 *                   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                     &lt;sequence&gt;
 *                       &lt;element name="surname" maxOccurs="unbounded"&gt;
 *                         &lt;complexType&gt;
 *                           &lt;simpleContent&gt;
 *                             &lt;restriction base="&lt;http://www.meta-share.org/OMTD-SHARE_XMLSchema&gt;myString"&gt;
 *                             &lt;/restriction&gt;
 *                           &lt;/simpleContent&gt;
 *                         &lt;/complexType&gt;
 *                       &lt;/element&gt;
 *                     &lt;/sequence&gt;
 *                   &lt;/restriction&gt;
 *                 &lt;/complexContent&gt;
 *               &lt;/complexType&gt;
 *             &lt;/element&gt;
 *             &lt;element name="givenNames" minOccurs="0"&gt;
 *               &lt;complexType&gt;
 *                 &lt;complexContent&gt;
 *                   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                     &lt;sequence&gt;
 *                       &lt;element name="givenName" maxOccurs="unbounded" minOccurs="0"&gt;
 *                         &lt;complexType&gt;
 *                           &lt;simpleContent&gt;
 *                             &lt;restriction base="&lt;http://www.meta-share.org/OMTD-SHARE_XMLSchema&gt;myString"&gt;
 *                             &lt;/restriction&gt;
 *                           &lt;/simpleContent&gt;
 *                         &lt;/complexType&gt;
 *                       &lt;/element&gt;
 *                     &lt;/sequence&gt;
 *                   &lt;/restriction&gt;
 *                 &lt;/complexContent&gt;
 *               &lt;/complexType&gt;
 *             &lt;/element&gt;
 *           &lt;/sequence&gt;
 *           &lt;element name="names"&gt;
 *             &lt;complexType&gt;
 *               &lt;complexContent&gt;
 *                 &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                   &lt;sequence&gt;
 *                     &lt;element name="name" maxOccurs="unbounded"&gt;
 *                       &lt;complexType&gt;
 *                         &lt;simpleContent&gt;
 *                           &lt;restriction base="&lt;http://www.meta-share.org/OMTD-SHARE_XMLSchema&gt;myString"&gt;
 *                           &lt;/restriction&gt;
 *                         &lt;/simpleContent&gt;
 *                       &lt;/complexType&gt;
 *                     &lt;/element&gt;
 *                   &lt;/sequence&gt;
 *                 &lt;/restriction&gt;
 *               &lt;/complexContent&gt;
 *             &lt;/complexType&gt;
 *           &lt;/element&gt;
 *         &lt;/choice&gt;
 *         &lt;element name="personIdentifiers" minOccurs="0"&gt;
 *           &lt;complexType&gt;
 *             &lt;complexContent&gt;
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                 &lt;sequence&gt;
 *                   &lt;element name="personIdentifier" type="{http://www.meta-share.org/OMTD-SHARE_XMLSchema}personIdentifierType" maxOccurs="unbounded" minOccurs="0"/&gt;
 *                 &lt;/sequence&gt;
 *               &lt;/restriction&gt;
 *             &lt;/complexContent&gt;
 *           &lt;/complexType&gt;
 *         &lt;/element&gt;
 *         &lt;element ref="{http://www.meta-share.org/OMTD-SHARE_XMLSchema}sex" minOccurs="0"/&gt;
 *         &lt;element ref="{http://www.meta-share.org/OMTD-SHARE_XMLSchema}communicationInfo"/&gt;
 *         &lt;element name="affiliations" minOccurs="0"&gt;
 *           &lt;complexType&gt;
 *             &lt;complexContent&gt;
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                 &lt;sequence&gt;
 *                   &lt;element name="affiliation" maxOccurs="unbounded" minOccurs="0"&gt;
 *                     &lt;complexType&gt;
 *                       &lt;complexContent&gt;
 *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                           &lt;sequence&gt;
 *                             &lt;element name="position" minOccurs="0"&gt;
 *                               &lt;simpleType&gt;
 *                                 &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *                                   &lt;maxLength value="100"/&gt;
 *                                 &lt;/restriction&gt;
 *                               &lt;/simpleType&gt;
 *                             &lt;/element&gt;
 *                             &lt;element name="affiliatedOrganization" type="{http://www.meta-share.org/OMTD-SHARE_XMLSchema}relatedOrganizationType" minOccurs="0"/&gt;
 *                           &lt;/sequence&gt;
 *                         &lt;/restriction&gt;
 *                       &lt;/complexContent&gt;
 *                     &lt;/complexType&gt;
 *                   &lt;/element&gt;
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
@XmlType(name = "personInfoType", propOrder = {
    "surnames","givenNames","names",
    "personIdentifiers",
    "sex",
    "communicationInfo",
    "affiliations"
})
public class PersonInfo {

    // @XmlElements({
    //     @XmlElement(name = "surnames", type = Surnames.class),
    //     @XmlElement(name = "givenNames", type = GivenNames.class),
    //     @XmlElement(name = "names", type = Names.class)
    // })
    // protected List<Object> surnamesAndGivenNamesOrNames;


    @XmlElementWrapper
    @XmlElement(name = "surname", namespace = "http://www.meta-share.org/OMTD-SHARE_XMLSchema")
    protected List<Surname> surnames;

    @XmlElementWrapper
    @XmlElement(name = "givenName", namespace = "http://www.meta-share.org/OMTD-SHARE_XMLSchema")
    protected List<GivenName> givenNames;

    @XmlElementWrapper
    @XmlElement(name = "name", namespace = "http://www.meta-share.org/OMTD-SHARE_XMLSchema")
    protected List<Name> names;


    @XmlElementWrapper
    @XmlElement(name = "personIdentifier", namespace = "http://www.meta-share.org/OMTD-SHARE_XMLSchema")
    protected List<PersonIdentifier> personIdentifiers;
    protected SexEnum sex;
    @XmlElement(required = true)
    protected CommunicationInfo communicationInfo;
    @XmlElementWrapper
    @XmlElement(name = "affiliation", namespace = "http://www.meta-share.org/OMTD-SHARE_XMLSchema")
    protected List<Affiliation> affiliations;

    /**
     * The gender of a person related to or participating in the resource
     * 
     * @return
     *     possible object is
     *     {@link SexEnum }
     *     
     */
    public SexEnum getSex() {
        return sex;
    }

    /**
     * Sets the value of the sex property.
     * 
     * @param value
     *     allowed object is
     *     {@link SexEnum }
     *     
     */
    public void setSex(SexEnum value) {
        this.sex = value;
    }

    /**
     * Groups information on communication details of a person or an organization
     * 
     * @return
     *     possible object is
     *     {@link CommunicationInfo }
     *     
     */
    public CommunicationInfo getCommunicationInfo() {
        return communicationInfo;
    }

    /**
     * Sets the value of the communicationInfo property.
     * 
     * @param value
     *     allowed object is
     *     {@link CommunicationInfo }
     *     
     */
    public void setCommunicationInfo(CommunicationInfo value) {
        this.communicationInfo = value;
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

    public List<Affiliation> getAffiliations() {
        if (affiliations == null) {
            affiliations = new ArrayList<Affiliation>();
        }
        return affiliations;
    }

    public void setAffiliations(List<Affiliation> affiliations) {
        this.affiliations = affiliations;
    }


    public List<Name> getNames() {
        if (names == null) {
            names = new ArrayList<>();
        }
        return names;
    }

    public void setNames(List<Name> names) {
        this.names = names;
    }

    public List<Surname> getSurnames() {
        if (surnames == null) {
            surnames = new ArrayList<Surname>();
        }
        return surnames;
    }

    public void setSurnames(List<Surname> surnames) {
        this.surnames = surnames;
    }

    public List<GivenName> getGivenNames() {
        if (givenNames == null) {
            givenNames = new ArrayList<GivenName>();
        }
        return givenNames;
    }

    public void setGivenNames(List<GivenName> givenNames) {
        this.givenNames = givenNames;
    }

}
