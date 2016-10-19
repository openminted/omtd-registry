
package eu.openminted.registry.domain;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for anonymous complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;choice&gt;
 *         &lt;element name="relatedPerson"&gt;
 *           &lt;complexType&gt;
 *             &lt;complexContent&gt;
 *               &lt;extension base="{http://www.meta-share.org/OMTD-SHARE_XMLSchema}relatedPersonType"&gt;
 *                 &lt;attribute name="contributorType"&gt;
 *                   &lt;simpleType&gt;
 *                     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *                       &lt;enumeration value="editor"/&gt;
 *                       &lt;enumeration value="translator"/&gt;
 *                       &lt;enumeration value="other"/&gt;
 *                     &lt;/restriction&gt;
 *                   &lt;/simpleType&gt;
 *                 &lt;/attribute&gt;
 *               &lt;/extension&gt;
 *             &lt;/complexContent&gt;
 *           &lt;/complexType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="relatedOrganization"&gt;
 *           &lt;complexType&gt;
 *             &lt;complexContent&gt;
 *               &lt;extension base="{http://www.meta-share.org/OMTD-SHARE_XMLSchema}relatedOrganizationType"&gt;
 *                 &lt;attribute name="contributorType"&gt;
 *                   &lt;simpleType&gt;
 *                     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *                       &lt;enumeration value="editor"/&gt;
 *                       &lt;enumeration value="translator"/&gt;
 *                       &lt;enumeration value="other"/&gt;
 *                     &lt;/restriction&gt;
 *                   &lt;/simpleType&gt;
 *                 &lt;/attribute&gt;
 *               &lt;/extension&gt;
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
@XmlType(name = "", propOrder = {
    "relatedPerson","relatedOrganization"
})
public class Contributor {

    // @XmlElements({
    //     @XmlElement(name = "relatedPerson", type = RelatedPerson2 .class),
    //     @XmlElement(name = "relatedOrganization", type = RelatedOrganization2 .class)
    // })
    // protected Object relatedPersonOrRelatedOrganization;


    protected RelatedPerson relatedPerson;

    protected RelatedOrganization relatedOrganization;
    
    public RelatedPerson getRelatedPerson() {
        if (relatedPerson == null) {
            relatedPerson = new RelatedPerson();
        }
        return relatedPerson;
    }

    public void setRelatedPerson(RelatedPerson relatedPerson) {
        this.relatedPerson = relatedPerson;
    }
    
    public RelatedOrganization getRelatedOrganization() {
        if (relatedOrganization == null) {
            relatedOrganization = new RelatedOrganization();
        }
        return relatedOrganization;
    }

    public void setRelatedOrganization(RelatedOrganization relatedOrganization) {
        this.relatedOrganization = relatedOrganization;
    }


}
