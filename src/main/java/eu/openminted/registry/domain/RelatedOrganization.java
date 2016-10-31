
package eu.openminted.registry.domain;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlType;



/**
 * Base type for related organizations; choice between organization names and identifiers
 * 
 * <p>Java class for relatedOrganizationType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="relatedOrganizationType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;choice&gt;
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
 *         &lt;element name="organizationIdentifiers"&gt;
 *           &lt;complexType&gt;
 *             &lt;complexContent&gt;
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                 &lt;sequence&gt;
 *                   &lt;element name="organizationIdentifier" type="{http://www.meta-share.org/OMTD-SHARE_XMLSchema}organizationIdentifierType" maxOccurs="unbounded"/&gt;
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
@XmlType(name = "relatedOrganizationType", propOrder = {
    "organizationNames","organizationIdentifiers"
})
public class RelatedOrganization {

    // @XmlElements({
    //     @XmlElement(name = "organizationNames", type = OrganizationNames.class),
    //     @XmlElement(name = "organizationIdentifiers", type = OrganizationIdentifiers.class)
    // })
    // protected Object organizationNamesOrOrganizationIdentifiers;

    @XmlElementWrapper
    @XmlElement(name = "organizationName", namespace = "http://www.meta-share.org/OMTD-SHARE_XMLSchema")
    protected List<OrganizationName> organizationNames;

    @XmlElementWrapper
    @XmlElement(name = "organizationIdentifier", namespace = "http://www.meta-share.org/OMTD-SHARE_XMLSchema")
    protected List<OrganizationIdentifier> organizationIdentifiers;
    
    public List<OrganizationName> getOrganizationNames() {
        if (organizationNames == null) {
            organizationNames = new ArrayList<OrganizationName>();
        }
        return organizationNames;
    }

    public void setOrganizationNames(List<OrganizationName> organizationNames) {
        this.organizationNames = organizationNames;
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

}
