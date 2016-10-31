
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
 *     &lt;maxLength value="30"/&gt;
 *     &lt;enumeration value="text"/&gt;
 *     &lt;enumeration value="audio"/&gt;
 *     &lt;enumeration value="video"/&gt;
 *     &lt;enumeration value="image"/&gt;
 *     &lt;enumeration value="textNumerical"/&gt;
 *   &lt;/restriction&gt;
 * &lt;/simpleType&gt;
 * </pre>
 * 
 */
@XmlType(name = "")
@XmlEnum
public enum MediaTypeEnum {

    @XmlEnumValue("text")
    TEXT("text"),
    @XmlEnumValue("audio")
    AUDIO("audio"),
    @XmlEnumValue("video")
    VIDEO("video"),
    @XmlEnumValue("image")
    IMAGE("image"),
    @XmlEnumValue("textNumerical")
    TEXT_NUMERICAL("textNumerical");
    private final String value;

    MediaTypeEnum(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static MediaTypeEnum fromValue(String v) {
        for (MediaTypeEnum c: MediaTypeEnum.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
