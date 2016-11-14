
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
 *     &lt;enumeration value="dialect"/&gt;
 *     &lt;enumeration value="jargon"/&gt;
 *     &lt;enumeration value="other"/&gt;
 *   &lt;/restriction&gt;
 * &lt;/simpleType&gt;
 * </pre>
 * 
 */
@XmlType(name = "")
@XmlEnum
public enum LanguageVarietyTypeEnum {

    @XmlEnumValue("dialect")
    DIALECT("dialect"),
    @XmlEnumValue("jargon")
    JARGON("jargon"),
    @XmlEnumValue("other")
    OTHER("other");
    private final String value;

    LanguageVarietyTypeEnum(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static LanguageVarietyTypeEnum fromValue(String v) {
        for (LanguageVarietyTypeEnum c: LanguageVarietyTypeEnum.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
