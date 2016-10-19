
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
 *     &lt;enumeration value="phonetics"/&gt;
 *     &lt;enumeration value="phonology"/&gt;
 *     &lt;enumeration value="semantics"/&gt;
 *     &lt;enumeration value="morphology"/&gt;
 *     &lt;enumeration value="syntax"/&gt;
 *     &lt;enumeration value="pragmatics"/&gt;
 *     &lt;enumeration value="other"/&gt;
 *   &lt;/restriction&gt;
 * &lt;/simpleType&gt;
 * </pre>
 * 
 */
@XmlType(name = "")
@XmlEnum
public enum EncodingLevelEnum {

    @XmlEnumValue("phonetics")
    PHONETICS("phonetics"),
    @XmlEnumValue("phonology")
    PHONOLOGY("phonology"),
    @XmlEnumValue("semantics")
    SEMANTICS("semantics"),
    @XmlEnumValue("morphology")
    MORPHOLOGY("morphology"),
    @XmlEnumValue("syntax")
    SYNTAX("syntax"),
    @XmlEnumValue("pragmatics")
    PRAGMATICS("pragmatics"),
    @XmlEnumValue("other")
    OTHER("other");
    private final String value;

    EncodingLevelEnum(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static EncodingLevelEnum fromValue(String v) {
        for (EncodingLevelEnum c: EncodingLevelEnum.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
