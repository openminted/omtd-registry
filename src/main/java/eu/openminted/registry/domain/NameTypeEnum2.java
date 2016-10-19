
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
 *     &lt;enumeration value="shortName"/&gt;
 *     &lt;enumeration value="alternativeName"/&gt;
 *     &lt;enumeration value="translatedName"/&gt;
 *   &lt;/restriction&gt;
 * &lt;/simpleType&gt;
 * </pre>
 * 
 */
@XmlType(name = "")
@XmlEnum
public enum NameTypeEnum2 {

    @XmlEnumValue("shortName")
    SHORT_NAME("shortName"),
    @XmlEnumValue("alternativeName")
    ALTERNATIVE_NAME("alternativeName"),
    @XmlEnumValue("translatedName")
    TRANSLATED_NAME("translatedName");
    private final String value;

    NameTypeEnum2(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static NameTypeEnum2 fromValue(String v) {
        for (NameTypeEnum2 c: NameTypeEnum2 .values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
