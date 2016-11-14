
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
 *     &lt;maxLength value="100"/&gt;
 *     &lt;enumeration value="graphicCard"/&gt;
 *     &lt;enumeration value="microphone"/&gt;
 *     &lt;enumeration value="ocrSystem"/&gt;
 *     &lt;enumeration value="specialHardwareEquipment"/&gt;
 *     &lt;enumeration value="none"/&gt;
 *     &lt;enumeration value="other"/&gt;
 *   &lt;/restriction&gt;
 * &lt;/simpleType&gt;
 * </pre>
 * 
 */
@XmlType(name = "")
@XmlEnum
public enum RequiresHardwareEnum {

    @XmlEnumValue("graphicCard")
    GRAPHIC_CARD("graphicCard"),
    @XmlEnumValue("microphone")
    MICROPHONE("microphone"),
    @XmlEnumValue("ocrSystem")
    OCR_SYSTEM("ocrSystem"),
    @XmlEnumValue("specialHardwareEquipment")
    SPECIAL_HARDWARE_EQUIPMENT("specialHardwareEquipment"),
    @XmlEnumValue("none")
    NONE("none"),
    @XmlEnumValue("other")
    OTHER("other");
    private final String value;

    RequiresHardwareEnum(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static RequiresHardwareEnum fromValue(String v) {
        for (RequiresHardwareEnum c: RequiresHardwareEnum.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
