
package eu.openminted.registry.domain;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * Base type for actors/agents; choice between person and organization
 * 
 * <p>Java class for actorInfoType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="actorInfoType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;choice&gt;
 *         &lt;element name="relatedPerson" type="{http://www.meta-share.org/OMTD-SHARE_XMLSchema}relatedPersonType"/&gt;
 *         &lt;element name="relatedOrganization" type="{http://www.meta-share.org/OMTD-SHARE_XMLSchema}relatedOrganizationType"/&gt;
 *       &lt;/choice&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "actorInfoType", propOrder = {
    "relatedPerson","relatedOrganization"
})
public class ActorInfo {

    // @XmlElements({
    //     @XmlElement(name = "relatedPerson", type = RelatedPerson.class),
    //     @XmlElement(name = "relatedOrganization", type = RelatedOrganization.class)
    // })
    // protected Object relatedPersonOrRelatedOrganization;

    protected RelatedPerson relatedPerson;
    protected RelatedOrganization relatedOrganization;
	public RelatedPerson getRelatedPerson() {
		return relatedPerson;
	}
	public void setRelatedPerson(RelatedPerson relatedPerson) {
		this.relatedPerson = relatedPerson;
	}
	public RelatedOrganization getRelatedOrganization() {
		return relatedOrganization;
	}
	public void setRelatedOrganization(RelatedOrganization relatedOrganization) {
		this.relatedOrganization = relatedOrganization;
	}
    
    
}
