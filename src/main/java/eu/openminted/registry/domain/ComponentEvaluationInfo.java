package eu.openminted.registry.domain;

import java.util.List;

/**
 * Created by stefania on 9/5/16.
 */
public class ComponentEvaluationInfo {

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
    }

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
    }

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
    }

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
    }

    //required
    private boolean evaluated;
    private List<EvaluationLevel> evaluationLevels;
    private List<EvaluationType> evaluationTypes;
    private List<EvaluationCriterion> evaluationCriteria;
    private List<EvaluationMeasure> evaluationMeasures;
    private List<RelatedDocument> evaluationReports;
    private List<RelatedResource> evaluationSwComponents;
    private String evaluationDetails;
    private List<ActorInfo> evaluators;

    public ComponentEvaluationInfo() {
    }

    public ComponentEvaluationInfo(boolean evaluated) {
        this.evaluated = evaluated;
    }

    public ComponentEvaluationInfo(boolean evaluated, List<EvaluationLevel> evaluationLevels, List<EvaluationType> evaluationTypes,
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

    public boolean isEvaluated() {
        return evaluated;
    }

    public void setEvaluated(boolean evaluated) {
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
}
