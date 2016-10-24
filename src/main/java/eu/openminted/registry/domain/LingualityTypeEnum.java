
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
 *     &lt;enumeration value="monolingual"/&gt;
 *     &lt;enumeration value="bilingual"/&gt;
 *     &lt;enumeration value="multilingual"/&gt;
 *   &lt;/restriction&gt;
 * &lt;/simpleType&gt;
 * </pre>
 * 
 */
@XmlType(name = "")
@XmlEnum
public enum LingualityTypeEnum {

    @XmlEnumValue("monolingual")
    MONOLINGUAL("monolingual"),
    @XmlEnumValue("bilingual")
    BILINGUAL("bilingual"),
    @XmlEnumValue("multilingual")
    MULTILINGUAL("multilingual");
    private final String value;

    LingualityTypeEnum(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static LingualityTypeEnum fromValue(String v) {
        for (LingualityTypeEnum c: LingualityTypeEnum.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
