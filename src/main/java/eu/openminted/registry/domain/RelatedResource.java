
package eu.openminted.registry.domain;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlType;


/**
 * Base type for related resources; choice between resource names and identifiers
 * 
 * <p>Java class for relatedResourceType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="relatedResourceType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;choice&gt;
 *         &lt;element name="resourceIdentifiers"&gt;
 *           &lt;complexType&gt;
 *             &lt;complexContent&gt;
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                 &lt;sequence&gt;
 *                   &lt;element name="resourceIdentifier" type="{http://www.meta-share.org/OMTD-SHARE_XMLSchema}resourceIdentifierType" maxOccurs="unbounded"/&gt;
 *                 &lt;/sequence&gt;
 *               &lt;/restriction&gt;
 *             &lt;/complexContent&gt;
 *           &lt;/complexType&gt;
 *         &lt;/element&gt;
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
 *       &lt;/choice&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "relatedResourceType", propOrder = {
    "resourceIdentifiers","resourceNames"
})
public class RelatedResource {

//    @XmlElements({
//        @XmlElement(name = "resourceIdentifiers", type = ResourceIdentifiers.class),
//        @XmlElement(name = "resourceNames", type = ResourceNames.class)
//    })
//    protected Object resourceIdentifiersOrResourceNames;

    @XmlElementWrapper
    @XmlElement(name = "resourceIdentifier", namespace = "http://www.meta-share.org/OMTD-SHARE_XMLSchema")
    protected List<ResourceIdentifier> resourceIdentifiers;

    @XmlElementWrapper
    @XmlElement(name = "resourceName", namespace = "http://www.meta-share.org/OMTD-SHARE_XMLSchema")
    protected List<ResourceName> resourceNames;
    
    public List<ResourceIdentifier> getResourceIdentifiers() {
        if (resourceIdentifiers == null) {
        	resourceIdentifiers = new ArrayList<ResourceIdentifier>();
        }
        return resourceIdentifiers;
    }

    public void setResourceIdentifiers(List<ResourceIdentifier> resourceIdentifiers) {
        this.resourceIdentifiers = resourceIdentifiers;
    }
    
    public List<ResourceName> getResourceNames() {
        if (resourceNames == null) {
        	resourceNames = new ArrayList<ResourceName>();
        }
        return resourceNames;
    }

    public void setResourceNames(List<ResourceName> resourceNames) {
        this.resourceNames = resourceNames;
    }


}
