
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
 *     &lt;enumeration value="orcid"/&gt;
 *     &lt;enumeration value="isni"/&gt;
 *     &lt;enumeration value="researcherId"/&gt;
 *     &lt;enumeration value="scopusId"/&gt;
 *     &lt;enumeration value="other"/&gt;
 *   &lt;/restriction&gt;
 * &lt;/simpleType&gt;
 * </pre>
 * 
 */
@XmlType(name = "")
@XmlEnum
public enum PersonIdentifierSchemeNameEnum {

    @XmlEnumValue("orcid")
    ORCID("orcid"),
    @XmlEnumValue("isni")
    ISNI("isni"),
    @XmlEnumValue("researcherId")
    RESEARCHER_ID("researcherId"),
    @XmlEnumValue("scopusId")
    SCOPUS_ID("scopusId"),
    @XmlEnumValue("other")
    OTHER("other");
    private final String value;

    PersonIdentifierSchemeNameEnum(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static PersonIdentifierSchemeNameEnum fromValue(String v) {
        for (PersonIdentifierSchemeNameEnum c: PersonIdentifierSchemeNameEnum.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
