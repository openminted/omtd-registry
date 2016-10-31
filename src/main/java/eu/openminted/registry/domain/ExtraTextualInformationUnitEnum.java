
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
 *     &lt;enumeration value="word"/&gt;
 *     &lt;enumeration value="lemma"/&gt;
 *     &lt;enumeration value="semantics"/&gt;
 *     &lt;enumeration value="example"/&gt;
 *     &lt;enumeration value="syntax"/&gt;
 *     &lt;enumeration value="lexicalUnit"/&gt;
 *     &lt;enumeration value="other"/&gt;
 *   &lt;/restriction&gt;
 * &lt;/simpleType&gt;
 * </pre>
 * 
 */
@XmlType(name = "")
@XmlEnum
public enum ExtraTextualInformationUnitEnum {

    @XmlEnumValue("word")
    WORD("word"),
    @XmlEnumValue("lemma")
    LEMMA("lemma"),
    @XmlEnumValue("semantics")
    SEMANTICS("semantics"),
    @XmlEnumValue("example")
    EXAMPLE("example"),
    @XmlEnumValue("syntax")
    SYNTAX("syntax"),
    @XmlEnumValue("lexicalUnit")
    LEXICAL_UNIT("lexicalUnit"),
    @XmlEnumValue("other")
    OTHER("other");
    private final String value;

    ExtraTextualInformationUnitEnum(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static ExtraTextualInformationUnitEnum fromValue(String v) {
        for (ExtraTextualInformationUnitEnum c: ExtraTextualInformationUnitEnum.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
