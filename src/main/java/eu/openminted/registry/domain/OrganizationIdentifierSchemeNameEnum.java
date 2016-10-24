
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
 *     &lt;enumeration value="isni"/&gt;
 *     &lt;enumeration value="fundref"/&gt;
 *     &lt;enumeration value="other"/&gt;
 *   &lt;/restriction&gt;
 * &lt;/simpleType&gt;
 * </pre>
 * 
 */
@XmlType(name = "")
@XmlEnum
public enum OrganizationIdentifierSchemeNameEnum {

    @XmlEnumValue("isni")
    ISNI("isni"),
    @XmlEnumValue("fundref")
    FUNDREF("fundref"),
    @XmlEnumValue("other")
    OTHER("other");
    private final String value;

    OrganizationIdentifierSchemeNameEnum(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static OrganizationIdentifierSchemeNameEnum fromValue(String v) {
        for (OrganizationIdentifierSchemeNameEnum c: OrganizationIdentifierSchemeNameEnum.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
