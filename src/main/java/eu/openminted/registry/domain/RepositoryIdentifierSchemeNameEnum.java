
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
 *     &lt;enumeration value="url"/&gt;
 *     &lt;enumeration value="oai"/&gt;
 *     &lt;enumeration value="opendoar"/&gt;
 *     &lt;enumeration value="re3d"/&gt;
 *     &lt;enumeration value="roar"/&gt;
 *     &lt;enumeration value="other"/&gt;
 *   &lt;/restriction&gt;
 * &lt;/simpleType&gt;
 * </pre>
 * 
 */
@XmlType(name = "")
@XmlEnum
public enum RepositoryIdentifierSchemeNameEnum {

    @XmlEnumValue("doi")
    DOI("doi"),
    @XmlEnumValue("hdl")
    HDL("hdl"),
    @XmlEnumValue("url")
    URL("url"),
    @XmlEnumValue("oai")
    OAI("oai"),
    @XmlEnumValue("opendoar")
    OPENDOAR("opendoar"),
    @XmlEnumValue("re3d")
    RE_3_D("re3d"),
    @XmlEnumValue("roar")
    ROAR("roar"),
    @XmlEnumValue("other")
    OTHER("other");
    private final String value;

    RepositoryIdentifierSchemeNameEnum(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static RepositoryIdentifierSchemeNameEnum fromValue(String v) {
        for (RepositoryIdentifierSchemeNameEnum c: RepositoryIdentifierSchemeNameEnum.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
