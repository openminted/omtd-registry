
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
 *     &lt;enumeration value="alternativeTitle"/&gt;
 *     &lt;enumeration value="subtitle"/&gt;
 *     &lt;enumeration value="translatedTitle"/&gt;
 *     &lt;enumeration value="other"/&gt;
 *   &lt;/restriction&gt;
 * &lt;/simpleType&gt;
 * </pre>
 * 
 */
@XmlType(name = "")
@XmlEnum
public enum TitleTypeEnum {

    @XmlEnumValue("alternativeTitle")
    ALTERNATIVE_TITLE("alternativeTitle"),
    @XmlEnumValue("subtitle")
    SUBTITLE("subtitle"),
    @XmlEnumValue("translatedTitle")
    TRANSLATED_TITLE("translatedTitle"),
    @XmlEnumValue("other")
    OTHER("other");
    private final String value;

    TitleTypeEnum(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static TitleTypeEnum fromValue(String v) {
        for (TitleTypeEnum c: TitleTypeEnum.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
