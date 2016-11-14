
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
 *     &lt;maxLength value="30"/&gt;
 *     &lt;enumeration value="extrinsic"/&gt;
 *     &lt;enumeration value="intrinsic"/&gt;
 *   &lt;/restriction&gt;
 * &lt;/simpleType&gt;
 * </pre>
 * 
 */
@XmlType(name = "")
@XmlEnum
public enum EvaluationCriterionEnum {

    @XmlEnumValue("extrinsic")
    EXTRINSIC("extrinsic"),
    @XmlEnumValue("intrinsic")
    INTRINSIC("intrinsic");
    private final String value;

    EvaluationCriterionEnum(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static EvaluationCriterionEnum fromValue(String v) {
        for (EvaluationCriterionEnum c: EvaluationCriterionEnum.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
