
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
 *     &lt;enumeration value="webExecutable"/&gt;
 *     &lt;enumeration value="paperCopy"/&gt;
 *     &lt;enumeration value="hardDisk"/&gt;
 *     &lt;enumeration value="bluRay"/&gt;
 *     &lt;enumeration value="DVD-R"/&gt;
 *     &lt;enumeration value="CD-ROM"/&gt;
 *     &lt;enumeration value="downloadable"/&gt;
 *     &lt;enumeration value="accessibleThroughInterface"/&gt;
 *     &lt;enumeration value="other"/&gt;
 *   &lt;/restriction&gt;
 * &lt;/simpleType&gt;
 * </pre>
 * 
 */
@XmlType(name = "")
@XmlEnum
public enum DistributionMediumEnum {

    @XmlEnumValue("webExecutable")
    WEB_EXECUTABLE("webExecutable"),
    @XmlEnumValue("paperCopy")
    PAPER_COPY("paperCopy"),
    @XmlEnumValue("hardDisk")
    HARD_DISK("hardDisk"),
    @XmlEnumValue("bluRay")
    BLU_RAY("bluRay"),
    @XmlEnumValue("DVD-R")
    DVD_R("DVD-R"),
    @XmlEnumValue("CD-ROM")
    CD_ROM("CD-ROM"),
    @XmlEnumValue("downloadable")
    DOWNLOADABLE("downloadable"),
    @XmlEnumValue("accessibleThroughInterface")
    ACCESSIBLE_THROUGH_INTERFACE("accessibleThroughInterface"),
    @XmlEnumValue("other")
    OTHER("other");
    private final String value;

    DistributionMediumEnum(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static DistributionMediumEnum fromValue(String v) {
        for (DistributionMediumEnum c: DistributionMediumEnum.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
