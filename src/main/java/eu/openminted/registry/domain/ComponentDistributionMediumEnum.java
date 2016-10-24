
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
 *     &lt;enumeration value="webService"/&gt;
 *     &lt;enumeration value="sourceCode"/&gt;
 *     &lt;enumeration value="executableCode"/&gt;
 *   &lt;/restriction&gt;
 * &lt;/simpleType&gt;
 * </pre>
 * 
 */
@XmlType(name = "")
@XmlEnum
public enum ComponentDistributionMediumEnum {

    @XmlEnumValue("webService")
    WEB_SERVICE("webService"),
    @XmlEnumValue("sourceCode")
    SOURCE_CODE("sourceCode"),
    @XmlEnumValue("executableCode")
    EXECUTABLE_CODE("executableCode");
    private final String value;

    ComponentDistributionMediumEnum(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static ComponentDistributionMediumEnum fromValue(String v) {
        for (ComponentDistributionMediumEnum c: ComponentDistributionMediumEnum.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
