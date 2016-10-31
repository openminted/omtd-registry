
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
 *     &lt;enumeration value="wordnet"/&gt;
 *     &lt;enumeration value="wordlist"/&gt;
 *     &lt;enumeration value="morphologicalLexicon"/&gt;
 *     &lt;enumeration value="other"/&gt;
 *   &lt;/restriction&gt;
 * &lt;/simpleType&gt;
 * </pre>
 * 
 */
@XmlType(name = "")
@XmlEnum
public enum CompatibleLexiconTypeEnum {


    /**
     * Value for compatibleLexiconType; to be used for grammars that are compatible with wordnets
     * 
     */
    @XmlEnumValue("wordnet")
    WORDNET("wordnet"),

    /**
     * Value for compatibleLexiconType; to be used for grammars that need wordlists for their operation
     * 
     */
    @XmlEnumValue("wordlist")
    WORDLIST("wordlist"),

    /**
     * Value for compatibleLexiconType; to be used for grammars that need lexica with morphological information for their operation
     * 
     */
    @XmlEnumValue("morphologicalLexicon")
    MORPHOLOGICAL_LEXICON("morphologicalLexicon"),
    @XmlEnumValue("other")
    OTHER("other");
    private final String value;

    CompatibleLexiconTypeEnum(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static CompatibleLexiconTypeEnum fromValue(String v) {
        for (CompatibleLexiconTypeEnum c: CompatibleLexiconTypeEnum.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
