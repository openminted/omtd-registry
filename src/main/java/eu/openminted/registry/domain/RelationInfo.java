
package eu.openminted.registry.domain;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for relationInfoType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="relationInfoType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="relationType"&gt;
 *           &lt;simpleType&gt;
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *               &lt;enumeration value="isPartOf"/&gt;
 *               &lt;enumeration value="isPartWith"/&gt;
 *               &lt;enumeration value="hasPart"/&gt;
 *               &lt;enumeration value="hasOutcome"/&gt;
 *               &lt;enumeration value="isCombinedWith"/&gt;
 *               &lt;enumeration value="requiresLR"/&gt;
 *               &lt;enumeration value="requiresSoftware"/&gt;
 *               &lt;enumeration value="isexactMatch"/&gt;
 *               &lt;enumeration value="isSimilarTo"/&gt;
 *               &lt;enumeration value="isContinuationOf"/&gt;
 *               &lt;enumeration value="isVersionOf"/&gt;
 *               &lt;enumeration value="isSimilarTo"/&gt;
 *               &lt;enumeration value="replaces"/&gt;
 *               &lt;enumeration value="isReplacedWith"/&gt;
 *               &lt;enumeration value="isCreatedBy"/&gt;
 *               &lt;enumeration value="isElicitedBy"/&gt;
 *               &lt;enumeration value="isRecordedBy"/&gt;
 *               &lt;enumeration value="isEditedBy"/&gt;
 *               &lt;enumeration value="isAnalysedBy"/&gt;
 *               &lt;enumeration value="isEvaluatedBy"/&gt;
 *               &lt;enumeration value="isQueriedBy"/&gt;
 *               &lt;enumeration value="isAccessedBy"/&gt;
 *               &lt;enumeration value="isArchivedBy"/&gt;
 *               &lt;enumeration value="isDisplayedBy"/&gt;
 *               &lt;enumeration value="isCompatibleWith"/&gt;
 *             &lt;/restriction&gt;
 *           &lt;/simpleType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="relatedResource1" type="{http://www.meta-share.org/OMTD-SHARE_XMLSchema}relatedResourceType"/&gt;
 *         &lt;element name="relatedResources"&gt;
 *           &lt;complexType&gt;
 *             &lt;complexContent&gt;
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                 &lt;sequence&gt;
 *                   &lt;element name="relatedResource2" type="{http://www.meta-share.org/OMTD-SHARE_XMLSchema}relatedResourceType" maxOccurs="unbounded"/&gt;
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
@XmlType(name = "relationInfoType", propOrder = {
    "relationType",
    "relatedResource1",
    "relatedResources"
})
public class RelationInfo {

    @XmlElement(required = true)
    protected RelationTypeEnum relationType;
    @XmlElement(required = true)
    protected RelatedResource relatedResource1;
    @XmlElementWrapper(required = true)
    @XmlElement(name = "relatedResource2", namespace = "http://www.meta-share.org/OMTD-SHARE_XMLSchema")
    protected List<RelatedResource> relatedResources;

    /**
     * Gets the value of the relationType property.
     * 
     * @return
     *     possible object is
     *     {@link RelationTypeEnum }
     *     
     */
    public RelationTypeEnum getRelationType() {
        return relationType;
    }

    /**
     * Sets the value of the relationType property.
     * 
     * @param value
     *     allowed object is
     *     {@link RelationTypeEnum }
     *     
     */
    public void setRelationType(RelationTypeEnum value) {
        this.relationType = value;
    }

    /**
     * Gets the value of the relatedResource1 property.
     * 
     * @return
     *     possible object is
     *     {@link RelatedResource }
     *     
     */
    public RelatedResource getRelatedResource1() {
        return relatedResource1;
    }

    /**
     * Sets the value of the relatedResource1 property.
     * 
     * @param value
     *     allowed object is
     *     {@link RelatedResource }
     *     
     */
    public void setRelatedResource1(RelatedResource value) {
        this.relatedResource1 = value;
    }

    public List<RelatedResource> getRelatedResources() {
        if (relatedResources == null) {
            relatedResources = new ArrayList<RelatedResource>();
        }
        return relatedResources;
    }

    public void setRelatedResources(List<RelatedResource> relatedResources) {
        this.relatedResources = relatedResources;
    }

}
