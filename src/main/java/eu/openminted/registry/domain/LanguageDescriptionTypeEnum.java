
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
 *     &lt;enumeration value="grammar"/&gt;
 *     &lt;enumeration value="other"/&gt;
 *   &lt;/restriction&gt;
 * &lt;/simpleType&gt;
 * </pre>
 * 
 */
@XmlType(name = "")
@XmlEnum
public enum LanguageDescriptionTypeEnum {


    /**
     * Value for languageDescriptionType; to be used for resources describing the morphological, syntactic etc. system (or part therof) of a language
     * 
     */
    @XmlEnumValue("grammar")
    GRAMMAR("grammar"),
    @XmlEnumValue("other")
    OTHER("other");
    private final String value;

    LanguageDescriptionTypeEnum(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static LanguageDescriptionTypeEnum fromValue(String v) {
        for (LanguageDescriptionTypeEnum c: LanguageDescriptionTypeEnum.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
