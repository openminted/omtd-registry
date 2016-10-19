
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
 *     &lt;enumeration value="1.0.0"/&gt;
 *     &lt;enumeration value="2.0"/&gt;
 *     &lt;enumeration value="3.0"/&gt;
 *     &lt;enumeration value="4.0"/&gt;
 *   &lt;/restriction&gt;
 * &lt;/simpleType&gt;
 * </pre>
 * 
 */
@XmlType(name = "")
@XmlEnum
public enum VersionEnum {

    @XmlEnumValue("1.0.0")
    V1_0_0("1.0.0"),
    @XmlEnumValue("2.0")
    V2_0("2.0"),
    @XmlEnumValue("3.0")
    V3_0("3.0"),
    @XmlEnumValue("4.0")
    V4_0("4.0");
    private final String value;

    VersionEnum(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static VersionEnum fromValue(String v) {
        for (VersionEnum c: VersionEnum.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
