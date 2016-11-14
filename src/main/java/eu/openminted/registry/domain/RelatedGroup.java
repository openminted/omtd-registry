
package eu.openminted.registry.domain;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlType;


/**
 * Base type for related groups; group name and choice between organization names and identifiers
 * 
 * <p>Java class for relatedGroupType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="relatedGroupType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="groupNames"&gt;
 *           &lt;complexType&gt;
 *             &lt;complexContent&gt;
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                 &lt;sequence&gt;
 *                   &lt;element name="groupName" maxOccurs="unbounded"&gt;
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
 *         &lt;element name="relatedOrganization" type="{http://www.meta-share.org/OMTD-SHARE_XMLSchema}relatedOrganizationType"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "relatedGroupType", propOrder = {
    "groupNames",
    "relatedOrganization"
})
public class RelatedGroup {

    @XmlElementWrapper(required = true)
    @XmlElement(name = "groupName", namespace = "http://www.meta-share.org/OMTD-SHARE_XMLSchema")
    protected List<GroupName> groupNames;
    @XmlElement(required = true)
    protected RelatedOrganization relatedOrganization;

    /**
     * Gets the value of the relatedOrganization property.
     * 
     * @return
     *     possible object is
     *     {@link RelatedOrganization }
     *     
     */
    public RelatedOrganization getRelatedOrganization() {
        return relatedOrganization;
    }

    /**
     * Sets the value of the relatedOrganization property.
     * 
     * @param value
     *     allowed object is
     *     {@link RelatedOrganization }
     *     
     */
    public void setRelatedOrganization(RelatedOrganization value) {
        this.relatedOrganization = value;
    }

    public List<GroupName> getGroupNames() {
        if (groupNames == null) {
            groupNames = new ArrayList<GroupName>();
        }
        return groupNames;
    }

    public void setGroupNames(List<GroupName> groupNames) {
        this.groupNames = groupNames;
    }

}
