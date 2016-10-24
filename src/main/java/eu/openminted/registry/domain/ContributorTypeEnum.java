
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
 *     &lt;enumeration value="editor"/&gt;
 *     &lt;enumeration value="translator"/&gt;
 *     &lt;enumeration value="other"/&gt;
 *   &lt;/restriction&gt;
 * &lt;/simpleType&gt;
 * </pre>
 * 
 */
@XmlType(name = "")
@XmlEnum
public enum ContributorTypeEnum {

    @XmlEnumValue("editor")
    EDITOR("editor"),
    @XmlEnumValue("translator")
    TRANSLATOR("translator"),
    @XmlEnumValue("other")
    OTHER("other");
    private final String value;

    ContributorTypeEnum(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static ContributorTypeEnum fromValue(String v) {
        for (ContributorTypeEnum c: ContributorTypeEnum.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
