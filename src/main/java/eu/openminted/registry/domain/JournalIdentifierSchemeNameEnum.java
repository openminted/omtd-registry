
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
 *     &lt;enumeration value="doi"/&gt;
 *     &lt;enumeration value="hdl"/&gt;
 *     &lt;enumeration value="issn"/&gt;
 *     &lt;enumeration value="other"/&gt;
 *   &lt;/restriction&gt;
 * &lt;/simpleType&gt;
 * </pre>
 * 
 */
@XmlType(name = "")
@XmlEnum
public enum JournalIdentifierSchemeNameEnum {

    @XmlEnumValue("doi")
    DOI("doi"),
    @XmlEnumValue("hdl")
    HDL("hdl"),
    @XmlEnumValue("issn")
    ISSN("issn"),
    @XmlEnumValue("other")
    OTHER("other");
    private final String value;

    JournalIdentifierSchemeNameEnum(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static JournalIdentifierSchemeNameEnum fromValue(String v) {
        for (JournalIdentifierSchemeNameEnum c: JournalIdentifierSchemeNameEnum.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
