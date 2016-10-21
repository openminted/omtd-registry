
package eu.openminted.registry.domain;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for processMode.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="processMode"&gt;
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *     &lt;maxLength value="20"/&gt;
 *     &lt;enumeration value="manual"/&gt;
 *     &lt;enumeration value="automatic"/&gt;
 *     &lt;enumeration value="mixed"/&gt;
 *     &lt;enumeration value="interactive"/&gt;
 *   &lt;/restriction&gt;
 * &lt;/simpleType&gt;
 * </pre>
 * 
 */
@XmlType(name = "processMode")
@XmlEnum
public enum ProcessMode {


    /**
     * For processes performed only manually, without automatic means or aids
     * 
     */
    @XmlEnumValue("manual")
    MANUAL("manual"),

    /**
     * For processes performed only with automatic means or aids
     * 
     */
    @XmlEnumValue("automatic")
    AUTOMATIC("automatic"),

    /**
     * For processes performed in a mixed way, using manual and automatic means
     * 
     */
    @XmlEnumValue("mixed")
    MIXED("mixed"),

    /**
     * For processes performed interactively
     * 
     */
    @XmlEnumValue("interactive")
    INTERACTIVE("interactive");
    private final String value;

    ProcessMode(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static ProcessMode fromValue(String v) {
        for (ProcessMode c: ProcessMode.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
