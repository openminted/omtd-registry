package eu.openminted.registry.domain;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.XmlAdapter;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

/**
 * Created by stefania on 9/5/16.
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

	@XmlJavaTypeAdapter(EvaluationLevelAdapter.class)
    enum EvaluationLevel {

        TECHNOLOGICAL("technological"),
        USAGE("usage"),
        IMPACT("impact"),
        DIAGNOSTIC("diagnostic");

        private String value;

        EvaluationLevel(String value) {
            this.value = value;
        }

        public String getValue() {
            return value;
        }
        
        public static ComponentEvaluationInfo.EvaluationLevel forValue(String value) {
            for (ComponentEvaluationInfo.EvaluationLevel ut: values()) {
                if (ut.getValue().equals(value))
                    return ut;
            }

            return null;
        }
    }

	@XmlJavaTypeAdapter(EvaluationTypeAdapter.class)
    enum EvaluationType {

        GLASS_BOX("glassBox"),
        BLACK_BOX("blackBox");

        private String value;

        EvaluationType(String value) {
            this.value = value;
        }

        public String getValue() {
            return value;
        }
        
        public static ComponentEvaluationInfo.EvaluationType forValue(String value) {
            for (ComponentEvaluationInfo.EvaluationType ut: values()) {
                if (ut.getValue().equals(value))
                    return ut;
            }

            return null;
        }
    }

	@XmlJavaTypeAdapter(EvaluationCriterionAdapter.class)
    enum EvaluationCriterion {

        EXTRINSIC("extrinsic"),
        INTRINSIC("intrinsic");

        private String value;

        EvaluationCriterion(String value) {
            this.value = value;
        }

        public String getValue() {
            return value;
        }
        
        public static ComponentEvaluationInfo.EvaluationCriterion forValue(String value) {
            for (ComponentEvaluationInfo.EvaluationCriterion ut: values()) {
                if (ut.getValue().equals(value))
                    return ut;
            }

            return null;
        }
    }

	@XmlJavaTypeAdapter(EvaluationMeasureAdapter.class)
    enum EvaluationMeasure {

        HUMAN("human"),
        AUTOMATIC("automatic");

        private String value;

        EvaluationMeasure(String value) {
            this.value = value;
        }

        public String getValue() {
            return value;
        }
        
        public static ComponentEvaluationInfo.EvaluationMeasure forValue(String value) {
            for (ComponentEvaluationInfo.EvaluationMeasure ut: values()) {
                if (ut.getValue().equals(value))
                    return ut;
            }

            return null;
        }
    }

    //required
    private Boolean evaluated;
    @XmlElementWrapper(name="evaluationLevels")
    @XmlElement(name="evaluationLevel")
    private List<EvaluationLevel> evaluationLevels;
    
    @XmlElementWrapper(name="evaluationTypes")
    @XmlElement(name="evaluationType")
    private List<EvaluationType> evaluationTypes;
    
    @XmlElementWrapper(name="evaluationCriteria")
    @XmlElement(name="evaluationCriterion")
    private List<EvaluationCriterion> evaluationCriteria;
    
    @XmlElementWrapper(name="evaluationMeasures")
    @XmlElement(name="evaluationMeasure")
    private List<EvaluationMeasure> evaluationMeasures;
    
    @XmlElementWrapper(name="evaluationReports")
    @XmlElement(name="hasEvaluationReport")
    private List<RelatedDocument> evaluationReports;
    
    @XmlElementWrapper(name="evaluationSwComponents")
    @XmlElement(name="isEvaluatedBy")
    private List<RelatedResource> evaluationSwComponents;
    
    private String evaluationDetails;
    
    @XmlElementWrapper(name="evaluators")
    @XmlElement(name="evaluator")
    private List<ActorInfo> evaluators;

    public ComponentEvaluationInfo() {
    }

    public ComponentEvaluationInfo(boolean evaluated) {
        this.evaluated = evaluated;
    }

    public ComponentEvaluationInfo(Boolean evaluated, List<EvaluationLevel> evaluationLevels, List<EvaluationType> evaluationTypes,
                                   List<EvaluationCriterion> evaluationCriteria, List<EvaluationMeasure> evaluationMeasures,
                                   List<RelatedDocument> evaluationReports, List<RelatedResource> evaluationSwComponents,
                                   String evaluationDetails, List<ActorInfo> evaluators) {
        this.evaluated = evaluated;
        this.evaluationLevels = evaluationLevels;
        this.evaluationTypes = evaluationTypes;
        this.evaluationCriteria = evaluationCriteria;
        this.evaluationMeasures = evaluationMeasures;
        this.evaluationReports = evaluationReports;
        this.evaluationSwComponents = evaluationSwComponents;
        this.evaluationDetails = evaluationDetails;
        this.evaluators = evaluators;
    }

    public Boolean isEvaluated() {
        return evaluated;
    }

    public void setEvaluated(Boolean evaluated) {
        this.evaluated = evaluated;
    }

    public List<EvaluationLevel> getEvaluationLevels() {
        return evaluationLevels;
    }

    public void setEvaluationLevels(List<EvaluationLevel> evaluationLevels) {
        this.evaluationLevels = evaluationLevels;
    }

    public List<EvaluationType> getEvaluationTypes() {
        return evaluationTypes;
    }

    public void setEvaluationTypes(List<EvaluationType> evaluationTypes) {
        this.evaluationTypes = evaluationTypes;
    }

    public List<EvaluationCriterion> getEvaluationCriteria() {
        return evaluationCriteria;
    }

    public void setEvaluationCriteria(List<EvaluationCriterion> evaluationCriteria) {
        this.evaluationCriteria = evaluationCriteria;
    }

    public List<EvaluationMeasure> getEvaluationMeasures() {
        return evaluationMeasures;
    }

    public void setEvaluationMeasures(List<EvaluationMeasure> evaluationMeasures) {
        this.evaluationMeasures = evaluationMeasures;
    }

    public List<RelatedDocument> getEvaluationReports() {
        return evaluationReports;
    }

    public void setEvaluationReports(List<RelatedDocument> evaluationReports) {
        this.evaluationReports = evaluationReports;
    }

    public List<RelatedResource> getEvaluationSwComponents() {
        return evaluationSwComponents;
    }

    public void setEvaluationSwComponents(List<RelatedResource> evaluationSwComponents) {
        this.evaluationSwComponents = evaluationSwComponents;
    }

    public String getEvaluationDetails() {
        return evaluationDetails;
    }

    public void setEvaluationDetails(String evaluationDetails) {
        this.evaluationDetails = evaluationDetails;
    }

    public List<ActorInfo> getEvaluators() {
        return evaluators;
    }

    public void setEvaluators(List<ActorInfo> evaluators) {
        this.evaluators = evaluators;
    }
    
    static class EvaluationLevelAdapter extends XmlAdapter<String, ComponentEvaluationInfo.EvaluationLevel> {

        @Override
        public String marshal(ComponentEvaluationInfo.EvaluationLevel v) throws Exception {
            return v!=null?v.getValue():null;
        }

        @Override
        public ComponentEvaluationInfo.EvaluationLevel unmarshal(String v) throws Exception {
            return ComponentEvaluationInfo.EvaluationLevel.forValue(v);
        }
    }
    
    static class EvaluationTypeAdapter extends XmlAdapter<String, ComponentEvaluationInfo.EvaluationType> {

        @Override
        public String marshal(ComponentEvaluationInfo.EvaluationType v) throws Exception {
            return v!=null?v.getValue():null;
        }

        @Override
        public ComponentEvaluationInfo.EvaluationType unmarshal(String v) throws Exception {
            return ComponentEvaluationInfo.EvaluationType.forValue(v);
        }
    }
    
    static class EvaluationCriterionAdapter extends XmlAdapter<String, ComponentEvaluationInfo.EvaluationCriterion> {

        @Override
        public String marshal(ComponentEvaluationInfo.EvaluationCriterion v) throws Exception {
            return v!=null?v.getValue():null;
        }

        @Override
        public ComponentEvaluationInfo.EvaluationCriterion unmarshal(String v) throws Exception {
            return ComponentEvaluationInfo.EvaluationCriterion.forValue(v);
        }
    }
    
    static class EvaluationMeasureAdapter extends XmlAdapter<String, ComponentEvaluationInfo.EvaluationMeasure> {

        @Override
        public String marshal(ComponentEvaluationInfo.EvaluationMeasure v) throws Exception {
            return v!=null?v.getValue():null;
        }

        @Override
        public ComponentEvaluationInfo.EvaluationMeasure unmarshal(String v) throws Exception {
            return ComponentEvaluationInfo.EvaluationMeasure.forValue(v);
        }
    }
}
