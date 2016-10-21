
package eu.openminted.registry.domain;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for resourceCreationInfoType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="resourceCreationInfoType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="resourceCreators" minOccurs="0"&gt;
 *           &lt;complexType&gt;
 *             &lt;complexContent&gt;
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                 &lt;sequence&gt;
 *                   &lt;element name="resourceCreator" type="{http://www.meta-share.org/OMTD-SHARE_XMLSchema}actorInfoType" maxOccurs="unbounded" minOccurs="0"/&gt;
 *                 &lt;/sequence&gt;
 *               &lt;/restriction&gt;
 *             &lt;/complexContent&gt;
 *           &lt;/complexType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="fundingProjects" minOccurs="0"&gt;
 *           &lt;complexType&gt;
 *             &lt;complexContent&gt;
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                 &lt;sequence&gt;
 *                   &lt;element name="fundingProject" type="{http://www.meta-share.org/OMTD-SHARE_XMLSchema}relatedProjectType" maxOccurs="unbounded" minOccurs="0"/&gt;
 *                 &lt;/sequence&gt;
 *               &lt;/restriction&gt;
 *             &lt;/complexContent&gt;
 *           &lt;/complexType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="creationDate" type="{http://www.meta-share.org/OMTD-SHARE_XMLSchema}dateCombinationType" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "resourceCreationInfoType", propOrder = {
    "resourceCreators",
    "fundingProjects",
    "creationDate"
})
public class ResourceCreationInfo {

    @XmlElementWrapper
    @XmlElement(name = "resourceCreator", namespace = "http://www.meta-share.org/OMTD-SHARE_XMLSchema")
    protected List<ActorInfo> resourceCreators;
    @XmlElementWrapper
    @XmlElement(name = "fundingProject", namespace = "http://www.meta-share.org/OMTD-SHARE_XMLSchema")
    protected List<RelatedProject> fundingProjects;
    protected DateCombination creationDate;

    /**
     * Gets the value of the creationDate property.
     * 
     * @return
     *     possible object is
     *     {@link DateCombination }
     *     
     */
    public DateCombination getCreationDate() {
        return creationDate;
    }

    /**
     * Sets the value of the creationDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link DateCombination }
     *     
     */
    public void setCreationDate(DateCombination value) {
        this.creationDate = value;
    }

    public List<ActorInfo> getResourceCreators() {
        if (resourceCreators == null) {
            resourceCreators = new ArrayList<ActorInfo>();
        }
        return resourceCreators;
    }

    public void setResourceCreators(List<ActorInfo> resourceCreators) {
        this.resourceCreators = resourceCreators;
    }

    public List<RelatedProject> getFundingProjects() {
        if (fundingProjects == null) {
            fundingProjects = new ArrayList<RelatedProject>();
        }
        return fundingProjects;
    }

    public void setFundingProjects(List<RelatedProject> fundingProjects) {
        this.fundingProjects = fundingProjects;
    }

}
