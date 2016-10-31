
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
 *     &lt;maxLength value="50"/&gt;
 *     &lt;enumeration value="academic"/&gt;
 *     &lt;enumeration value="commercial"/&gt;
 *     &lt;enumeration value="membersOfGroup"/&gt;
 *   &lt;/restriction&gt;
 * &lt;/simpleType&gt;
 * </pre>
 * 
 */
@XmlType(name = "")
@XmlEnum
public enum UserTypeEnum {


    /**
     * For academic institutions
     * 
     */
    @XmlEnumValue("academic")
    ACADEMIC("academic"),

    /**
     * For commercial institutions
     * 
     */
    @XmlEnumValue("commercial")
    COMMERCIAL("commercial"),

    /**
     * For members of particular groups (e.g. META-SHARE, CLARIN, ELRA etc.)
     * 
     */
    @XmlEnumValue("membersOfGroup")
    MEMBERS_OF_GROUP("membersOfGroup");
    private final String value;

    UserTypeEnum(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static UserTypeEnum fromValue(String v) {
        for (UserTypeEnum c: UserTypeEnum.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
