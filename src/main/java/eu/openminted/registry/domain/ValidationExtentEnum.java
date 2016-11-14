
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
 *     &lt;enumeration value="full"/&gt;
 *     &lt;enumeration value="partial"/&gt;
 *   &lt;/restriction&gt;
 * &lt;/simpleType&gt;
 * </pre>
 * 
 */
@XmlType(name = "")
@XmlEnum
public enum ValidationExtentEnum {

    @XmlEnumValue("full")
    FULL("full"),
    @XmlEnumValue("partial")
    PARTIAL("partial");
    private final String value;

    ValidationExtentEnum(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static ValidationExtentEnum fromValue(String v) {
        for (ValidationExtentEnum c: ValidationExtentEnum.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
