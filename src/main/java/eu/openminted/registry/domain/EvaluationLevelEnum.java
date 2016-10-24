
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
 *     &lt;enumeration value="technological"/&gt;
 *     &lt;enumeration value="usage"/&gt;
 *     &lt;enumeration value="impact"/&gt;
 *     &lt;enumeration value="diagnostic"/&gt;
 *   &lt;/restriction&gt;
 * &lt;/simpleType&gt;
 * </pre>
 * 
 */
@XmlType(name = "")
@XmlEnum
public enum EvaluationLevelEnum {

    @XmlEnumValue("technological")
    TECHNOLOGICAL("technological"),
    @XmlEnumValue("usage")
    USAGE("usage"),
    @XmlEnumValue("impact")
    IMPACT("impact"),
    @XmlEnumValue("diagnostic")
    DIAGNOSTIC("diagnostic");
    private final String value;

    EvaluationLevelEnum(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static EvaluationLevelEnum fromValue(String v) {
        for (EvaluationLevelEnum c: EvaluationLevelEnum.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
