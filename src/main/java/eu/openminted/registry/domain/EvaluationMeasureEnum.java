
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
 *     &lt;enumeration value="human"/&gt;
 *     &lt;enumeration value="automatic"/&gt;
 *   &lt;/restriction&gt;
 * &lt;/simpleType&gt;
 * </pre>
 * 
 */
@XmlType(name = "")
@XmlEnum
public enum EvaluationMeasureEnum {

    @XmlEnumValue("human")
    HUMAN("human"),
    @XmlEnumValue("automatic")
    AUTOMATIC("automatic");
    private final String value;

    EvaluationMeasureEnum(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static EvaluationMeasureEnum fromValue(String v) {
        for (EvaluationMeasureEnum c: EvaluationMeasureEnum.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
