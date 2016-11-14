
package eu.openminted.registry.domain;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for licenceInfoType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="licenceInfoType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="licence"&gt;
 *           &lt;simpleType&gt;
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *               &lt;maxLength value="100"/&gt;
 *               &lt;enumeration value="CC-BY"/&gt;
 *               &lt;enumeration value="CC-BY-NC"/&gt;
 *               &lt;enumeration value="CC-BY-NC-ND"/&gt;
 *               &lt;enumeration value="CC-BY-NC-SA"/&gt;
 *               &lt;enumeration value="CC-BY-ND"/&gt;
 *               &lt;enumeration value="CC-BY-SA"/&gt;
 *               &lt;enumeration value="CC-ZERO"/&gt;
 *               &lt;enumeration value="PDDL"/&gt;
 *               &lt;enumeration value="ODC-BY"/&gt;
 *               &lt;enumeration value="ODbL"/&gt;
 *               &lt;enumeration value="MS-NoReD"/&gt;
 *               &lt;enumeration value="MS-NoReD-FF"/&gt;
 *               &lt;enumeration value="MS-NoReD-ND"/&gt;
 *               &lt;enumeration value="MS-NoReD-ND-FF"/&gt;
 *               &lt;enumeration value="MS-NC-NoReD"/&gt;
 *               &lt;enumeration value="MS-NC-NoReD-FF"/&gt;
 *               &lt;enumeration value="MS-NC-NoReD-ND"/&gt;
 *               &lt;enumeration value="MS-NC-NoReD-ND-FF"/&gt;
 *               &lt;enumeration value="ELRA_END_USER"/&gt;
 *               &lt;enumeration value="ELRA_EVALUATION"/&gt;
 *               &lt;enumeration value="ELRA_VAR"/&gt;
 *               &lt;enumeration value="CLARIN_PUB"/&gt;
 *               &lt;enumeration value="CLARIN_ACA"/&gt;
 *               &lt;enumeration value="CLARIN_ACA-NC"/&gt;
 *               &lt;enumeration value="CLARIN_RES"/&gt;
 *               &lt;enumeration value="AGPL"/&gt;
 *               &lt;enumeration value="ApacheLicence_2.0"/&gt;
 *               &lt;enumeration value="BSD_4-clause"/&gt;
 *               &lt;enumeration value="BSD_3-clause"/&gt;
 *               &lt;enumeration value="FreeBSD"/&gt;
 *               &lt;enumeration value="GFDL"/&gt;
 *               &lt;enumeration value="GPL"/&gt;
 *               &lt;enumeration value="LGPL"/&gt;
 *               &lt;enumeration value="MIT"/&gt;
 *               &lt;enumeration value="Princeton_Wordnet"/&gt;
 *               &lt;enumeration value="proprietary"/&gt;
 *               &lt;enumeration value="underNegotiation"/&gt;
 *               &lt;enumeration value="nonStandardLicenceTerms"/&gt;
 *             &lt;/restriction&gt;
 *           &lt;/simpleType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="version" minOccurs="0"&gt;
 *           &lt;simpleType&gt;
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *               &lt;enumeration value="1.0.0"/&gt;
 *               &lt;enumeration value="2.0"/&gt;
 *               &lt;enumeration value="3.0"/&gt;
 *               &lt;enumeration value="4.0"/&gt;
 *             &lt;/restriction&gt;
 *           &lt;/simpleType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="nonStandardLicenceName" maxOccurs="unbounded" minOccurs="0"&gt;
 *           &lt;complexType&gt;
 *             &lt;simpleContent&gt;
 *               &lt;restriction base="&lt;http://www.meta-share.org/OMTD-SHARE_XMLSchema&gt;myString"&gt;
 *               &lt;/restriction&gt;
 *             &lt;/simpleContent&gt;
 *           &lt;/complexType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="nonStandardLicenceTermsURL" type="{http://www.meta-share.org/OMTD-SHARE_XMLSchema}httpURI" minOccurs="0"/&gt;
 *         &lt;element name="nonStandaradLicenceTermsText" maxOccurs="unbounded" minOccurs="0"&gt;
 *           &lt;complexType&gt;
 *             &lt;simpleContent&gt;
 *               &lt;restriction base="&lt;http://www.meta-share.org/OMTD-SHARE_XMLSchema&gt;myString"&gt;
 *               &lt;/restriction&gt;
 *             &lt;/simpleContent&gt;
 *           &lt;/complexType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="conditionsOfUse" maxOccurs="unbounded" minOccurs="0"&gt;
 *           &lt;simpleType&gt;
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *               &lt;maxLength value="100"/&gt;
 *               &lt;enumeration value="attribution"/&gt;
 *               &lt;enumeration value="nonCommercialUse"/&gt;
 *               &lt;enumeration value="commercialUse"/&gt;
 *               &lt;enumeration value="shareAlike"/&gt;
 *               &lt;enumeration value="noDerivatives"/&gt;
 *               &lt;enumeration value="noRedistribution"/&gt;
 *               &lt;enumeration value="evaluationUse"/&gt;
 *               &lt;enumeration value="research"/&gt;
 *               &lt;enumeration value="languageEngineeringResearch"/&gt;
 *               &lt;enumeration value="education"/&gt;
 *               &lt;enumeration value="informLicensor"/&gt;
 *               &lt;enumeration value="redeposit"/&gt;
 *               &lt;enumeration value="compensate"/&gt;
 *               &lt;enumeration value="personalDataIncluded"/&gt;
 *               &lt;enumeration value="sensitiveDataIncluded"/&gt;
 *               &lt;enumeration value="requestPlan"/&gt;
 *               &lt;enumeration value="spatialConstraint"/&gt;
 *               &lt;enumeration value="userIdentified"/&gt;
 *               &lt;enumeration value="academicUsers"/&gt;
 *               &lt;enumeration value="commercialUsers"/&gt;
 *               &lt;enumeration value="membersOfGroup"/&gt;
 *               &lt;enumeration value="other"/&gt;
 *             &lt;/restriction&gt;
 *           &lt;/simpleType&gt;
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
@XmlType(name = "licenceInfoType", propOrder = {
    "licence",
    "version",
    "nonStandardLicenceName",
    "nonStandardLicenceTermsURL",
    "nonStandaradLicenceTermsText",
    "conditionsOfUse"
})
public class LicenceInfo {

    @XmlElement(required = true)
    protected LicenceEnum licence;
    protected VersionEnum version;
    protected List<NonStandardLicenceName> nonStandardLicenceName;
    @XmlSchemaType(name = "anyURI")
    protected String nonStandardLicenceTermsURL;
    protected List<NonStandaradLicenceTermsText> nonStandaradLicenceTermsText;
    protected List<ConditionsOfUseEnum> conditionsOfUse;

    /**
     * Gets the value of the licence property.
     * 
     * @return
     *     possible object is
     *     {@link LicenceEnum }
     *     
     */
    public LicenceEnum getLicence() {
        return licence;
    }

    /**
     * Sets the value of the licence property.
     * 
     * @param value
     *     allowed object is
     *     {@link LicenceEnum }
     *     
     */
    public void setLicence(LicenceEnum value) {
        this.licence = value;
    }

    /**
     * Gets the value of the version property.
     * 
     * @return
     *     possible object is
     *     {@link VersionEnum }
     *     
     */
    public VersionEnum getVersion() {
        return version;
    }

    /**
     * Sets the value of the version property.
     * 
     * @param value
     *     allowed object is
     *     {@link VersionEnum }
     *     
     */
    public void setVersion(VersionEnum value) {
        this.version = value;
    }

    /**
     * Gets the value of the nonStandardLicenceName property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the nonStandardLicenceName property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getNonStandardLicenceName().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link NonStandardLicenceName }
     * 
     * 
     */
    public List<NonStandardLicenceName> getNonStandardLicenceName() {
        if (nonStandardLicenceName == null) {
            nonStandardLicenceName = new ArrayList<NonStandardLicenceName>();
        }
        return this.nonStandardLicenceName;
    }

    /**
     * Gets the value of the nonStandardLicenceTermsURL property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNonStandardLicenceTermsURL() {
        return nonStandardLicenceTermsURL;
    }

    /**
     * Sets the value of the nonStandardLicenceTermsURL property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNonStandardLicenceTermsURL(String value) {
        this.nonStandardLicenceTermsURL = value;
    }

    /**
     * Gets the value of the nonStandaradLicenceTermsText property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the nonStandaradLicenceTermsText property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getNonStandaradLicenceTermsText().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link NonStandaradLicenceTermsText }
     * 
     * 
     */
    public List<NonStandaradLicenceTermsText> getNonStandaradLicenceTermsText() {
        if (nonStandaradLicenceTermsText == null) {
            nonStandaradLicenceTermsText = new ArrayList<NonStandaradLicenceTermsText>();
        }
        return this.nonStandaradLicenceTermsText;
    }

    /**
     * Gets the value of the conditionsOfUse property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the conditionsOfUse property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getConditionsOfUse().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ConditionsOfUseEnum }
     * 
     * 
     */
    public List<ConditionsOfUseEnum> getConditionsOfUse() {
        if (conditionsOfUse == null) {
            conditionsOfUse = new ArrayList<ConditionsOfUseEnum>();
        }
        return this.conditionsOfUse;
    }

}
