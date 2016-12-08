
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
 *     &lt;enumeration value="UIMA"/&gt;
 *     &lt;enumeration value="GATE"/&gt;
 *     &lt;enumeration value="AlvisNLP"/&gt;
 *     &lt;enumeration value="other"/&gt;
 *   &lt;/restriction&gt;
 * &lt;/simpleType&gt;
 * </pre>
 * 
 */
@XmlType(name = "")
@XmlEnum
public enum FrameworkEnum {

    UIMA("UIMA"),
    GATE("GATE"),
    @XmlEnumValue("AlvisNLP")
    ALVIS_NLP("AlvisNLP"),
    @XmlEnumValue("other")
    OTHER("other");
    private final String value;

    FrameworkEnum(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static FrameworkEnum fromValue(String v) {
        for (FrameworkEnum c: FrameworkEnum.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
