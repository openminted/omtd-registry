
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
 *     &lt;enumeration value="images"/&gt;
 *     &lt;enumeration value="videos"/&gt;
 *     &lt;enumeration value="soundRecordings"/&gt;
 *     &lt;enumeration value="other"/&gt;
 *   &lt;/restriction&gt;
 * &lt;/simpleType&gt;
 * </pre>
 * 
 */
@XmlType(name = "")
@XmlEnum
public enum ExtratextualInformationEnum {

    @XmlEnumValue("images")
    IMAGES("images"),
    @XmlEnumValue("videos")
    VIDEOS("videos"),
    @XmlEnumValue("soundRecordings")
    SOUND_RECORDINGS("soundRecordings"),
    @XmlEnumValue("other")
    OTHER("other");
    private final String value;

    ExtratextualInformationEnum(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static ExtratextualInformationEnum fromValue(String v) {
        for (ExtratextualInformationEnum c: ExtratextualInformationEnum.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
