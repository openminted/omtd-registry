
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
 *     &lt;enumeration value="formal"/&gt;
 *     &lt;enumeration value="content"/&gt;
 *   &lt;/restriction&gt;
 * &lt;/simpleType&gt;
 * </pre>
 * 
 */
@XmlType(name = "")
@XmlEnum
public enum ValidationTypeEnum {

    @XmlEnumValue("formal")
    FORMAL("formal"),
    @XmlEnumValue("content")
    CONTENT("content");
    private final String value;

    ValidationTypeEnum(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static ValidationTypeEnum fromValue(String v) {
        for (ValidationTypeEnum c: ValidationTypeEnum.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
