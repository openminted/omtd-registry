
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
 *     &lt;maxLength value="20"/&gt;
 *     &lt;enumeration value="glassBox"/&gt;
 *     &lt;enumeration value="blackBox"/&gt;
 *   &lt;/restriction&gt;
 * &lt;/simpleType&gt;
 * </pre>
 * 
 */
@XmlType(name = "")
@XmlEnum
public enum EvaluationTypeEnum {

    @XmlEnumValue("glassBox")
    GLASS_BOX("glassBox"),
    @XmlEnumValue("blackBox")
    BLACK_BOX("blackBox");
    private final String value;

    EvaluationTypeEnum(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static EvaluationTypeEnum fromValue(String v) {
        for (EvaluationTypeEnum c: EvaluationTypeEnum.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
