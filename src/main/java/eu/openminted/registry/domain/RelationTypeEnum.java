
package eu.openminted.registry.domain;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for null.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType&gt;
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *     &lt;enumeration value="isPartOf"/&gt;
 *     &lt;enumeration value="isPartWith"/&gt;
 *     &lt;enumeration value="hasPart"/&gt;
 *     &lt;enumeration value="hasOutcome"/&gt;
 *     &lt;enumeration value="isCombinedWith"/&gt;
 *     &lt;enumeration value="requiresLR"/&gt;
 *     &lt;enumeration value="requiresSoftware"/&gt;
 *     &lt;enumeration value="isexactMatch"/&gt;
 *     &lt;enumeration value="isSimilarTo"/&gt;
 *     &lt;enumeration value="isContinuationOf"/&gt;
 *     &lt;enumeration value="isVersionOf"/&gt;
 *     &lt;enumeration value="isSimilarTo"/&gt;
 *     &lt;enumeration value="replaces"/&gt;
 *     &lt;enumeration value="isReplacedWith"/&gt;
 *     &lt;enumeration value="isCreatedBy"/&gt;
 *     &lt;enumeration value="isElicitedBy"/&gt;
 *     &lt;enumeration value="isRecordedBy"/&gt;
 *     &lt;enumeration value="isEditedBy"/&gt;
 *     &lt;enumeration value="isAnalysedBy"/&gt;
 *     &lt;enumeration value="isEvaluatedBy"/&gt;
 *     &lt;enumeration value="isQueriedBy"/&gt;
 *     &lt;enumeration value="isAccessedBy"/&gt;
 *     &lt;enumeration value="isArchivedBy"/&gt;
 *     &lt;enumeration value="isDisplayedBy"/&gt;
 *     &lt;enumeration value="isCompatibleWith"/&gt;
 *   &lt;/restriction&gt;
 * &lt;/simpleType&gt;
 * </pre>
 * 
 */
@XmlType(name = "")
@XmlEnum
public enum RelationTypeEnum {

    @XmlEnumValue("isPartOf")
    IS_PART_OF("isPartOf"),
    @XmlEnumValue("isPartWith")
    IS_PART_WITH("isPartWith"),
    @XmlEnumValue("hasPart")
    HAS_PART("hasPart"),
    @XmlEnumValue("hasOutcome")
    HAS_OUTCOME("hasOutcome"),
    @XmlEnumValue("isCombinedWith")
    IS_COMBINED_WITH("isCombinedWith"),
    @XmlEnumValue("requiresLR")
    REQUIRES_LR("requiresLR"),
    @XmlEnumValue("requiresSoftware")
    REQUIRES_SOFTWARE("requiresSoftware"),
    @XmlEnumValue("isexactMatch")
    ISEXACT_MATCH("isexactMatch"),
    @XmlEnumValue("isSimilarTo")
    IS_SIMILAR_TO("isSimilarTo"),
    @XmlEnumValue("isContinuationOf")
    IS_CONTINUATION_OF("isContinuationOf"),
    @XmlEnumValue("isVersionOf")
    IS_VERSION_OF("isVersionOf"),
    @XmlEnumValue("replaces")
    REPLACES("replaces"),
    @XmlEnumValue("isReplacedWith")
    IS_REPLACED_WITH("isReplacedWith"),
    @XmlEnumValue("isCreatedBy")
    IS_CREATED_BY("isCreatedBy"),
    @XmlEnumValue("isElicitedBy")
    IS_ELICITED_BY("isElicitedBy"),
    @XmlEnumValue("isRecordedBy")
    IS_RECORDED_BY("isRecordedBy"),
    @XmlEnumValue("isEditedBy")
    IS_EDITED_BY("isEditedBy"),
    @XmlEnumValue("isAnalysedBy")
    IS_ANALYSED_BY("isAnalysedBy"),
    @XmlEnumValue("isEvaluatedBy")
    IS_EVALUATED_BY("isEvaluatedBy"),
    @XmlEnumValue("isQueriedBy")
    IS_QUERIED_BY("isQueriedBy"),
    @XmlEnumValue("isAccessedBy")
    IS_ACCESSED_BY("isAccessedBy"),
    @XmlEnumValue("isArchivedBy")
    IS_ARCHIVED_BY("isArchivedBy"),
    @XmlEnumValue("isDisplayedBy")
    IS_DISPLAYED_BY("isDisplayedBy"),
    @XmlEnumValue("isCompatibleWith")
    IS_COMPATIBLE_WITH("isCompatibleWith");
    private final String value;

    RelationTypeEnum(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static RelationTypeEnum fromValue(String v) {
        for (RelationTypeEnum c: RelationTypeEnum.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
