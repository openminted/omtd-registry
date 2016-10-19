
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
 *     &lt;enumeration value="os-independent"/&gt;
 *     &lt;enumeration value="windows"/&gt;
 *     &lt;enumeration value="linux"/&gt;
 *     &lt;enumeration value="unix"/&gt;
 *     &lt;enumeration value="mac-OS"/&gt;
 *     &lt;enumeration value="googleChromeOS"/&gt;
 *     &lt;enumeration value="iOS"/&gt;
 *     &lt;enumeration value="android"/&gt;
 *     &lt;enumeration value="other"/&gt;
 *     &lt;enumeration value=""/&gt;
 *   &lt;/restriction&gt;
 * &lt;/simpleType&gt;
 * </pre>
 * 
 */
@XmlType(name = "")
@XmlEnum
public enum OperatingSystemEnum {

    @XmlEnumValue("os-independent")
    OS_INDEPENDENT("os-independent"),
    @XmlEnumValue("windows")
    WINDOWS("windows"),
    @XmlEnumValue("linux")
    LINUX("linux"),
    @XmlEnumValue("unix")
    UNIX("unix"),
    @XmlEnumValue("mac-OS")
    MAC_OS("mac-OS"),
    @XmlEnumValue("googleChromeOS")
    GOOGLE_CHROME_OS("googleChromeOS"),
    @XmlEnumValue("iOS")
    I_OS("iOS"),
    @XmlEnumValue("android")
    ANDROID("android"),
    @XmlEnumValue("other")
    OTHER("other"),
    @XmlEnumValue("")
    BLANK("");
    private final String value;

    OperatingSystemEnum(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static OperatingSystemEnum fromValue(String v) {
        for (OperatingSystemEnum c: OperatingSystemEnum.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
