
package eu.openminted.registry.domain;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for componentEvaluationInfoType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="componentEvaluationInfoType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="evaluated" type="{http://www.w3.org/2001/XMLSchema}boolean"/&gt;
 *         &lt;element name="evaluationLevels" minOccurs="0"&gt;
 *           &lt;complexType&gt;
 *             &lt;complexContent&gt;
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                 &lt;sequence&gt;
 *                   &lt;element name="evaluationLevel" maxOccurs="unbounded" minOccurs="0"&gt;
 *                     &lt;simpleType&gt;
 *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *                         &lt;maxLength value="30"/&gt;
 *                         &lt;enumeration value="technological"/&gt;
 *                         &lt;enumeration value="usage"/&gt;
 *                         &lt;enumeration value="impact"/&gt;
 *                         &lt;enumeration value="diagnostic"/&gt;
 *                       &lt;/restriction&gt;
 *                     &lt;/simpleType&gt;
 *                   &lt;/element&gt;
 *                 &lt;/sequence&gt;
 *               &lt;/restriction&gt;
 *             &lt;/complexContent&gt;
 *           &lt;/complexType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="evaluationTypes" minOccurs="0"&gt;
 *           &lt;complexType&gt;
 *             &lt;complexContent&gt;
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                 &lt;sequence&gt;
 *                   &lt;element name="evaluationType" maxOccurs="unbounded" minOccurs="0"&gt;
 *                     &lt;simpleType&gt;
 *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *                         &lt;maxLength value="20"/&gt;
 *                         &lt;enumeration value="glassBox"/&gt;
 *                         &lt;enumeration value="blackBox"/&gt;
 *                       &lt;/restriction&gt;
 *                     &lt;/simpleType&gt;
 *                   &lt;/element&gt;
 *                 &lt;/sequence&gt;
 *               &lt;/restriction&gt;
 *             &lt;/complexContent&gt;
 *           &lt;/complexType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="evaluationCriteria" minOccurs="0"&gt;
 *           &lt;complexType&gt;
 *             &lt;complexContent&gt;
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                 &lt;sequence&gt;
 *                   &lt;element name="evaluationCriterion" maxOccurs="unbounded" minOccurs="0"&gt;
 *                     &lt;simpleType&gt;
 *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *                         &lt;maxLength value="30"/&gt;
 *                         &lt;enumeration value="extrinsic"/&gt;
 *                         &lt;enumeration value="intrinsic"/&gt;
 *                       &lt;/restriction&gt;
 *                     &lt;/simpleType&gt;
 *                   &lt;/element&gt;
 *                 &lt;/sequence&gt;
 *               &lt;/restriction&gt;
 *             &lt;/complexContent&gt;
 *           &lt;/complexType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="evaluationMeasures" minOccurs="0"&gt;
 *           &lt;complexType&gt;
 *             &lt;complexContent&gt;
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                 &lt;sequence&gt;
 *                   &lt;element name="evaluationMeasure" maxOccurs="unbounded" minOccurs="0"&gt;
 *                     &lt;simpleType&gt;
 *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *                         &lt;maxLength value="30"/&gt;
 *                         &lt;enumeration value="human"/&gt;
 *                         &lt;enumeration value="automatic"/&gt;
 *                       &lt;/restriction&gt;
 *                     &lt;/simpleType&gt;
 *                   &lt;/element&gt;
 *                 &lt;/sequence&gt;
 *               &lt;/restriction&gt;
 *             &lt;/complexContent&gt;
 *           &lt;/complexType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="evaluationReports" minOccurs="0"&gt;
 *           &lt;complexType&gt;
 *             &lt;complexContent&gt;
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                 &lt;sequence&gt;
 *                   &lt;element name="hasEvaluationReport" type="{http://www.meta-share.org/OMTD-SHARE_XMLSchema}relatedDocumentInfoType" maxOccurs="unbounded" minOccurs="0"/&gt;
 *                 &lt;/sequence&gt;
 *               &lt;/restriction&gt;
 *             &lt;/complexContent&gt;
 *           &lt;/complexType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="evaluationSwComponents" minOccurs="0"&gt;
 *           &lt;complexType&gt;
 *             &lt;complexContent&gt;
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                 &lt;sequence&gt;
 *                   &lt;element name="isEvaluatedBy" type="{http://www.meta-share.org/OMTD-SHARE_XMLSchema}relatedResourceType" maxOccurs="unbounded" minOccurs="0"/&gt;
 *                 &lt;/sequence&gt;
 *               &lt;/restriction&gt;
 *             &lt;/complexContent&gt;
 *           &lt;/complexType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="evaluationDetails" minOccurs="0"&gt;
 *           &lt;simpleType&gt;
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *               &lt;maxLength value="500"/&gt;
 *             &lt;/restriction&gt;
 *           &lt;/simpleType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="evaluators" minOccurs="0"&gt;
 *           &lt;complexType&gt;
 *             &lt;complexContent&gt;
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                 &lt;sequence&gt;
 *                   &lt;element name="evaluator" type="{http://www.meta-share.org/OMTD-SHARE_XMLSchema}actorInfoType" maxOccurs="unbounded" minOccurs="0"/&gt;
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
@XmlType(name = "componentEvaluationInfoType", propOrder = {
    "evaluated",
    "evaluationLevels",
    "evaluationTypes",
    "evaluationCriteria",
    "evaluationMeasures",
    "evaluationReports",
    "evaluationSwComponents",
    "evaluationDetails",
    "evaluators"
})
public class ComponentEvaluationInfo {

    protected boolean evaluated;
    @XmlElementWrapper
    @XmlElement(name = "evaluationLevel", namespace = "http://www.meta-share.org/OMTD-SHARE_XMLSchema")
    protected List<EvaluationLevelEnum> evaluationLevels;
    @XmlElementWrapper
    @XmlElement(name = "evaluationType", namespace = "http://www.meta-share.org/OMTD-SHARE_XMLSchema")
    protected List<EvaluationTypeEnum> evaluationTypes;
    @XmlElementWrapper
    @XmlElement(name = "evaluationCriterion", namespace = "http://www.meta-share.org/OMTD-SHARE_XMLSchema")
    protected List<EvaluationCriterionEnum> evaluationCriteria;
    @XmlElementWrapper
    @XmlElement(name = "evaluationMeasure", namespace = "http://www.meta-share.org/OMTD-SHARE_XMLSchema")
    protected List<EvaluationMeasureEnum> evaluationMeasures;
    @XmlElementWrapper
    @XmlElement(name = "hasEvaluationReport", namespace = "http://www.meta-share.org/OMTD-SHARE_XMLSchema")
    protected List<RelatedDocumentInfo> evaluationReports;
    @XmlElementWrapper
    @XmlElement(name = "isEvaluatedBy", namespace = "http://www.meta-share.org/OMTD-SHARE_XMLSchema")
    protected List<RelatedResource> evaluationSwComponents;
    protected String evaluationDetails;
    @XmlElementWrapper
    @XmlElement(name = "evaluator", namespace = "http://www.meta-share.org/OMTD-SHARE_XMLSchema")
    protected List<ActorInfo> evaluators;

    /**
     * Gets the value of the evaluated property.
     * 
     */
    public boolean isEvaluated() {
        return evaluated;
    }

    /**
     * Sets the value of the evaluated property.
     * 
     */
    public void setEvaluated(boolean value) {
        this.evaluated = value;
    }

    /**
     * Gets the value of the evaluationDetails property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getEvaluationDetails() {
        return evaluationDetails;
    }

    /**
     * Sets the value of the evaluationDetails property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setEvaluationDetails(String value) {
        this.evaluationDetails = value;
    }

    public List<EvaluationLevelEnum> getEvaluationLevels() {
        if (evaluationLevels == null) {
            evaluationLevels = new ArrayList<EvaluationLevelEnum>();
        }
        return evaluationLevels;
    }

    public void setEvaluationLevels(List<EvaluationLevelEnum> evaluationLevels) {
        this.evaluationLevels = evaluationLevels;
    }

    public List<EvaluationTypeEnum> getEvaluationTypes() {
        if (evaluationTypes == null) {
            evaluationTypes = new ArrayList<EvaluationTypeEnum>();
        }
        return evaluationTypes;
    }

    public void setEvaluationTypes(List<EvaluationTypeEnum> evaluationTypes) {
        this.evaluationTypes = evaluationTypes;
    }

    public List<EvaluationCriterionEnum> getEvaluationCriteria() {
        if (evaluationCriteria == null) {
            evaluationCriteria = new ArrayList<EvaluationCriterionEnum>();
        }
        return evaluationCriteria;
    }

    public void setEvaluationCriteria(List<EvaluationCriterionEnum> evaluationCriteria) {
        this.evaluationCriteria = evaluationCriteria;
    }

    public List<EvaluationMeasureEnum> getEvaluationMeasures() {
        if (evaluationMeasures == null) {
            evaluationMeasures = new ArrayList<EvaluationMeasureEnum>();
        }
        return evaluationMeasures;
    }

    public void setEvaluationMeasures(List<EvaluationMeasureEnum> evaluationMeasures) {
        this.evaluationMeasures = evaluationMeasures;
    }

    public List<RelatedDocumentInfo> getEvaluationReports() {
        if (evaluationReports == null) {
            evaluationReports = new ArrayList<RelatedDocumentInfo>();
        }
        return evaluationReports;
    }

    public void setEvaluationReports(List<RelatedDocumentInfo> evaluationReports) {
        this.evaluationReports = evaluationReports;
    }

    public List<RelatedResource> getEvaluationSwComponents() {
        if (evaluationSwComponents == null) {
            evaluationSwComponents = new ArrayList<RelatedResource>();
        }
        return evaluationSwComponents;
    }

    public void setEvaluationSwComponents(List<RelatedResource> evaluationSwComponents) {
        this.evaluationSwComponents = evaluationSwComponents;
    }

    public List<ActorInfo> getEvaluators() {
        if (evaluators == null) {
            evaluators = new ArrayList<ActorInfo>();
        }
        return evaluators;
    }

    public void setEvaluators(List<ActorInfo> evaluators) {
        this.evaluators = evaluators;
    }

}
