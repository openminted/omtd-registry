
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
 *     &lt;enumeration value="corpus"/&gt;
 *     &lt;enumeration value="document"/&gt;
 *     &lt;enumeration value="userInputText"/&gt;
 *     &lt;enumeration value="lexicalConceptualResource"/&gt;
 *     &lt;enumeration value="languageDescription"/&gt;
 *   &lt;/restriction&gt;
 * &lt;/simpleType&gt;
 * </pre>
 * 
 */
@XmlType(name = "")
@XmlEnum
public enum ResourceTypeEnum {

    @XmlEnumValue("corpus")
    CORPUS("corpus"),
    @XmlEnumValue("document")
    DOCUMENT("document"),
    @XmlEnumValue("userInputText")
    USER_INPUT_TEXT("userInputText"),
    @XmlEnumValue("lexicalConceptualResource")
    LEXICAL_CONCEPTUAL_RESOURCE("lexicalConceptualResource"),
    @XmlEnumValue("languageDescription")
    LANGUAGE_DESCRIPTION("languageDescription");
    private final String value;

    ResourceTypeEnum(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static ResourceTypeEnum fromValue(String v) {
        for (ResourceTypeEnum c: ResourceTypeEnum.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
