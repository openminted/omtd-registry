
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
 *     &lt;enumeration value="openAccess"/&gt;
 *     &lt;enumeration value="closedAccess"/&gt;
 *     &lt;enumeration value="embargoedAccess"/&gt;
 *     &lt;enumeration value="restrictedAccess"/&gt;
 *   &lt;/restriction&gt;
 * &lt;/simpleType&gt;
 * </pre>
 * 
 */
@XmlType(name = "")
@XmlEnum
public enum RightsStmtNameEnum {


    /**
     * info:eu-repo/semantics/openAccess
     * 
     */
    @XmlEnumValue("openAccess")
    OPEN_ACCESS("openAccess"),

    /**
     * info:eu-repo/semantics/closedAccess
     * 
     */
    @XmlEnumValue("closedAccess")
    CLOSED_ACCESS("closedAccess"),

    /**
     * info:eu-repo/semantics/embargoedAccess
     * 
     */
    @XmlEnumValue("embargoedAccess")
    EMBARGOED_ACCESS("embargoedAccess"),

    /**
     * info:eu-repo/semantics/restrictedAccess
     * 
     */
    @XmlEnumValue("restrictedAccess")
    RESTRICTED_ACCESS("restrictedAccess");
    private final String value;

    RightsStmtNameEnum(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static RightsStmtNameEnum fromValue(String v) {
        for (RightsStmtNameEnum c: RightsStmtNameEnum.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
