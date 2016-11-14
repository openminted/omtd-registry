
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
 *     &lt;enumeration value="wordList"/&gt;
 *     &lt;enumeration value="computationalLexicon"/&gt;
 *     &lt;enumeration value="ontology"/&gt;
 *     &lt;enumeration value="wordnet"/&gt;
 *     &lt;enumeration value="thesaurus"/&gt;
 *     &lt;enumeration value="framenet"/&gt;
 *     &lt;enumeration value="terminologicalResource"/&gt;
 *     &lt;enumeration value="machineReadableDictionary"/&gt;
 *     &lt;enumeration value="lexicon"/&gt;
 *     &lt;enumeration value="typesystem"/&gt;
 *     &lt;enumeration value="tagset"/&gt;
 *     &lt;enumeration value="mappingOfResources"/&gt;
 *     &lt;enumeration value="other"/&gt;
 *   &lt;/restriction&gt;
 * &lt;/simpleType&gt;
 * </pre>
 * 
 */
@XmlType(name = "")
@XmlEnum
public enum LexicalConceptualResourceTypeEnum {

    @XmlEnumValue("wordList")
    WORD_LIST("wordList"),
    @XmlEnumValue("computationalLexicon")
    COMPUTATIONAL_LEXICON("computationalLexicon"),
    @XmlEnumValue("ontology")
    ONTOLOGY("ontology"),
    @XmlEnumValue("wordnet")
    WORDNET("wordnet"),
    @XmlEnumValue("thesaurus")
    THESAURUS("thesaurus"),
    @XmlEnumValue("framenet")
    FRAMENET("framenet"),
    @XmlEnumValue("terminologicalResource")
    TERMINOLOGICAL_RESOURCE("terminologicalResource"),
    @XmlEnumValue("machineReadableDictionary")
    MACHINE_READABLE_DICTIONARY("machineReadableDictionary"),
    @XmlEnumValue("lexicon")
    LEXICON("lexicon"),
    @XmlEnumValue("typesystem")
    TYPESYSTEM("typesystem"),
    @XmlEnumValue("tagset")
    TAGSET("tagset"),
    @XmlEnumValue("mappingOfResources")
    MAPPING_OF_RESOURCES("mappingOfResources"),
    @XmlEnumValue("other")
    OTHER("other");
    private final String value;

    LexicalConceptualResourceTypeEnum(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static LexicalConceptualResourceTypeEnum fromValue(String v) {
        for (LexicalConceptualResourceTypeEnum c: LexicalConceptualResourceTypeEnum.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
