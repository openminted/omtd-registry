
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
 *     &lt;enumeration value="included"/&gt;
 *     &lt;enumeration value="attached"/&gt;
 *     &lt;enumeration value="compatible"/&gt;
 *     &lt;enumeration value="none"/&gt;
 *   &lt;/restriction&gt;
 * &lt;/simpleType&gt;
 * </pre>
 * 
 */
@XmlType(name = "")
@XmlEnum
public enum RelatedLexiconTypeEnum {


    /**
     * For lexica that are included in the grammar file
     * 
     */
    @XmlEnumValue("included")
    INCLUDED("included"),

    /**
     * for lexica attached to a resource (e.g. as a different file in the same directory, or downloadable from another position); the element attachedLexiconPosition should be used for further information
     * 
     */
    @XmlEnumValue("attached")
    ATTACHED("attached"),

    /**
     * for grammars that can use any lexicon as long as they of a compatible type; the element compatibleLexiconType must be used for further specification
     * 
     */
    @XmlEnumValue("compatible")
    COMPATIBLE("compatible"),
    @XmlEnumValue("none")
    NONE("none");
    private final String value;

    RelatedLexiconTypeEnum(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static RelatedLexiconTypeEnum fromValue(String v) {
        for (RelatedLexiconTypeEnum c: RelatedLexiconTypeEnum.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
