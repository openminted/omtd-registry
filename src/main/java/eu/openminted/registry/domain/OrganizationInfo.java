
package eu.openminted.registry.domain;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for organizationInfoType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="organizationInfoType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="organizationNames"&gt;
 *           &lt;complexType&gt;
 *             &lt;complexContent&gt;
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                 &lt;sequence&gt;
 *                   &lt;element name="organizationName" maxOccurs="unbounded"&gt;
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
 *         &lt;element name="organizationAlternativeNames" minOccurs="0"&gt;
 *           &lt;complexType&gt;
 *             &lt;complexContent&gt;
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                 &lt;sequence&gt;
 *                   &lt;element name="organizationAlternativeName" maxOccurs="unbounded" minOccurs="0"&gt;
 *                     &lt;complexType&gt;
 *                       &lt;simpleContent&gt;
 *                         &lt;extension base="&lt;http://www.meta-share.org/OMTD-SHARE_XMLSchema&gt;myString"&gt;
 *                           &lt;attribute name="nameType" use="required"&gt;
 *                             &lt;simpleType&gt;
 *                               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *                                 &lt;enumeration value="shortName"/&gt;
 *                                 &lt;enumeration value="alternativeName"/&gt;
 *                                 &lt;enumeration value="translatedName"/&gt;
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
 *         &lt;element name="organizationIdentifiers" minOccurs="0"&gt;
 *           &lt;complexType&gt;
 *             &lt;complexContent&gt;
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                 &lt;sequence&gt;
 *                   &lt;element name="organizationIdentifier" type="{http://www.meta-share.org/OMTD-SHARE_XMLSchema}organizationIdentifierType" maxOccurs="unbounded" minOccurs="0"/&gt;
 *                 &lt;/sequence&gt;
 *               &lt;/restriction&gt;
 *             &lt;/complexContent&gt;
 *           &lt;/complexType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="departmentNames" minOccurs="0"&gt;
 *           &lt;complexType&gt;
 *             &lt;complexContent&gt;
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                 &lt;sequence&gt;
 *                   &lt;element name="departmentName" maxOccurs="unbounded" minOccurs="0"&gt;
 *                     &lt;complexType&gt;
 *                       &lt;simpleContent&gt;
 *                         &lt;extension base="&lt;http://www.meta-share.org/OMTD-SHARE_XMLSchema&gt;myString"&gt;
 *                           &lt;attribute name="nameType"&gt;
 *                             &lt;simpleType&gt;
 *                               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *                                 &lt;enumeration value="shortName"/&gt;
 *                                 &lt;enumeration value="alternativeName"/&gt;
 *                                 &lt;enumeration value="translatedName"/&gt;
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
 *         &lt;element ref="{http://www.meta-share.org/OMTD-SHARE_XMLSchema}communicationInfo"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "organizationInfoType", propOrder = {
    "organizationNames",
    "organizationAlternativeNames",
    "organizationIdentifiers",
    "departmentNames",
    "communicationInfo"
})
public class OrganizationInfo {

    @XmlElementWrapper(required = true)
    @XmlElement(name = "organizationName", namespace = "http://www.meta-share.org/OMTD-SHARE_XMLSchema")
    protected List<OrganizationName> organizationNames;
    @XmlElementWrapper
    @XmlElement(name = "organizationAlternativeName", namespace = "http://www.meta-share.org/OMTD-SHARE_XMLSchema")
    protected List<OrganizationAlternativeName> organizationAlternativeNames;
    @XmlElementWrapper
    @XmlElement(name = "organizationIdentifier", namespace = "http://www.meta-share.org/OMTD-SHARE_XMLSchema")
    protected List<OrganizationIdentifier> organizationIdentifiers;
    @XmlElementWrapper
    @XmlElement(name = "departmentName", namespace = "http://www.meta-share.org/OMTD-SHARE_XMLSchema")
    protected List<DepartmentName> departmentNames;
    @XmlElement(required = true)
    protected CommunicationInfo communicationInfo;

    /**
     * Gets the value of the communicationInfo property.
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

    public List<OrganizationName> getOrganizationNames() {
        if (organizationNames == null) {
            organizationNames = new ArrayList<OrganizationName>();
        }
        return organizationNames;
    }

    public void setOrganizationNames(List<OrganizationName> organizationNames) {
        this.organizationNames = organizationNames;
    }

    public List<OrganizationAlternativeName> getOrganizationAlternativeNames() {
        if (organizationAlternativeNames == null) {
            organizationAlternativeNames = new ArrayList<OrganizationAlternativeName>();
        }
        return organizationAlternativeNames;
    }

    public void setOrganizationAlternativeNames(List<OrganizationAlternativeName> organizationAlternativeNames) {
        this.organizationAlternativeNames = organizationAlternativeNames;
    }

    public List<OrganizationIdentifier> getOrganizationIdentifiers() {
        if (organizationIdentifiers == null) {
            organizationIdentifiers = new ArrayList<OrganizationIdentifier>();
        }
        return organizationIdentifiers;
    }

    public void setOrganizationIdentifiers(List<OrganizationIdentifier> organizationIdentifiers) {
        this.organizationIdentifiers = organizationIdentifiers;
    }

    public List<DepartmentName> getDepartmentNames() {
        if (departmentNames == null) {
            departmentNames = new ArrayList<DepartmentName>();
        }
        return departmentNames;
    }

    public void setDepartmentNames(List<DepartmentName> departmentNames) {
        this.departmentNames = departmentNames;
    }

}
