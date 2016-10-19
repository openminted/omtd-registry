
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
 *     &lt;enumeration value="repository"/&gt;
 *     &lt;enumeration value="journal"/&gt;
 *     &lt;enumeration value="publisher"/&gt;
 *   &lt;/restriction&gt;
 * &lt;/simpleType&gt;
 * </pre>
 * 
 */
@XmlType(name = "")
@XmlEnum
public enum OriginalDataProviderTypeEnum {

    @XmlEnumValue("repository")
    REPOSITORY("repository"),
    @XmlEnumValue("journal")
    JOURNAL("journal"),
    @XmlEnumValue("publisher")
    PUBLISHER("publisher");
    private final String value;

    OriginalDataProviderTypeEnum(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static OriginalDataProviderTypeEnum fromValue(String v) {
        for (OriginalDataProviderTypeEnum c: OriginalDataProviderTypeEnum.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
