
package eu.openminted.registry.domain;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for identificationInfoType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="identificationInfoType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="resourceNames"&gt;
 *           &lt;complexType&gt;
 *             &lt;complexContent&gt;
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                 &lt;sequence&gt;
 *                   &lt;element name="resourceName" maxOccurs="unbounded"&gt;
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
 *         &lt;element name="descriptions"&gt;
 *           &lt;complexType&gt;
 *             &lt;complexContent&gt;
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                 &lt;sequence&gt;
 *                   &lt;element name="description" maxOccurs="unbounded"&gt;
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
 *         &lt;element name="resourceShortNames" minOccurs="0"&gt;
 *           &lt;complexType&gt;
 *             &lt;complexContent&gt;
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                 &lt;sequence&gt;
 *                   &lt;element name="resourceShortName" maxOccurs="unbounded" minOccurs="0"&gt;
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
 *         &lt;element name="identifiers"&gt;
 *           &lt;complexType&gt;
 *             &lt;complexContent&gt;
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                 &lt;sequence&gt;
 *                   &lt;element name="identifier" type="{http://www.meta-share.org/OMTD-SHARE_XMLSchema}resourceIdentifierType" maxOccurs="unbounded"/&gt;
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
@XmlType(name = "identificationInfoType", propOrder = {
    "resourceNames",
    "descriptions",
    "resourceShortNames",
    "identifiers"
})
public class IdentificationInfo {

    @XmlElementWrapper(required = true)
    @XmlElement(name = "resourceName", namespace = "http://www.meta-share.org/OMTD-SHARE_XMLSchema")
    protected List<ResourceName> resourceNames;
    @XmlElementWrapper(required = true)
    @XmlElement(name = "description", namespace = "http://www.meta-share.org/OMTD-SHARE_XMLSchema")
    protected List<Description> descriptions;
    @XmlElementWrapper
    @XmlElement(name = "resourceShortName", namespace = "http://www.meta-share.org/OMTD-SHARE_XMLSchema")
    protected List<ResourceShortName> resourceShortNames;
    @XmlElementWrapper(required = true)
    @XmlElement(name = "identifier", namespace = "http://www.meta-share.org/OMTD-SHARE_XMLSchema")
    protected List<ResourceIdentifier> identifiers;

    public List<ResourceName> getResourceNames() {
        if (resourceNames == null) {
            resourceNames = new ArrayList<ResourceName>();
        }
        return resourceNames;
    }

    public void setResourceNames(List<ResourceName> resourceNames) {
        this.resourceNames = resourceNames;
    }

    public List<Description> getDescriptions() {
        if (descriptions == null) {
            descriptions = new ArrayList<Description>();
        }
        return descriptions;
    }

    public void setDescriptions(List<Description> descriptions) {
        this.descriptions = descriptions;
    }

    public List<ResourceShortName> getResourceShortNames() {
        if (resourceShortNames == null) {
            resourceShortNames = new ArrayList<ResourceShortName>();
        }
        return resourceShortNames;
    }

    public void setResourceShortNames(List<ResourceShortName> resourceShortNames) {
        this.resourceShortNames = resourceShortNames;
    }

    public List<ResourceIdentifier> getIdentifiers() {
        if (identifiers == null) {
            identifiers = new ArrayList<ResourceIdentifier>();
        }
        return identifiers;
    }

    public void setIdentifiers(List<ResourceIdentifier> identifiers) {
        this.identifiers = identifiers;
    }

}
