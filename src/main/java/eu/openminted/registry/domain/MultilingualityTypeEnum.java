
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
 *     &lt;enumeration value="parallel"/&gt;
 *     &lt;enumeration value="comparable"/&gt;
 *     &lt;enumeration value="multilingualSingleText"/&gt;
 *     &lt;enumeration value="originalTranslationsInSameText"/&gt;
 *     &lt;enumeration value="other"/&gt;
 *   &lt;/restriction&gt;
 * &lt;/simpleType&gt;
 * </pre>
 * 
 */
@XmlType(name = "")
@XmlEnum
public enum MultilingualityTypeEnum {

    @XmlEnumValue("parallel")
    PARALLEL("parallel"),
    @XmlEnumValue("comparable")
    COMPARABLE("comparable"),

    /**
     * For corpora including single texts that contain multiple language excerpts; e.g. european parliament discussions
     * 
     */
    @XmlEnumValue("multilingualSingleText")
    MULTILINGUAL_SINGLE_TEXT("multilingualSingleText"),
    @XmlEnumValue("originalTranslationsInSameText")
    ORIGINAL_TRANSLATIONS_IN_SAME_TEXT("originalTranslationsInSameText"),
    @XmlEnumValue("other")
    OTHER("other");
    private final String value;

    MultilingualityTypeEnum(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static MultilingualityTypeEnum fromValue(String v) {
        for (MultilingualityTypeEnum c: MultilingualityTypeEnum.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
