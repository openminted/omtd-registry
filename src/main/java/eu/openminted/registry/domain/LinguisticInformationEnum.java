
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
 *     &lt;enumeration value="accentuation"/&gt;
 *     &lt;enumeration value="lemma"/&gt;
 *     &lt;enumeration value="lemma-MultiWordUnits"/&gt;
 *     &lt;enumeration value="lemma-Variants"/&gt;
 *     &lt;enumeration value="lemma-Abbreviations"/&gt;
 *     &lt;enumeration value="lemma-Compounds"/&gt;
 *     &lt;enumeration value="lemma-CliticForms"/&gt;
 *     &lt;enumeration value="partOfSpeech"/&gt;
 *     &lt;enumeration value="morpho-Features"/&gt;
 *     &lt;enumeration value="morpho-Case"/&gt;
 *     &lt;enumeration value="morpho-Gender"/&gt;
 *     &lt;enumeration value="morpho-Number"/&gt;
 *     &lt;enumeration value="morpho-Degree"/&gt;
 *     &lt;enumeration value="morpho-IrregularForms"/&gt;
 *     &lt;enumeration value="morpho-Mood"/&gt;
 *     &lt;enumeration value="morpho-Tense"/&gt;
 *     &lt;enumeration value="morpho-Person"/&gt;
 *     &lt;enumeration value="morpho-Aspect"/&gt;
 *     &lt;enumeration value="morpho-Voice"/&gt;
 *     &lt;enumeration value="morpho-Auxiliary"/&gt;
 *     &lt;enumeration value="morpho-Inflection"/&gt;
 *     &lt;enumeration value="morpho-Reflexivity"/&gt;
 *     &lt;enumeration value="syntax-SubcatFrame"/&gt;
 *     &lt;enumeration value="semantics-Traits"/&gt;
 *     &lt;enumeration value="semantics-SemanticClass"/&gt;
 *     &lt;enumeration value="semantics-CrossReferences"/&gt;
 *     &lt;enumeration value="semantics-Relations"/&gt;
 *     &lt;enumeration value="semantics-Relations-Hyponyms"/&gt;
 *     &lt;enumeration value="semantics-Relations-Hyperonyms"/&gt;
 *     &lt;enumeration value="semantics-Relations-Synonyms"/&gt;
 *     &lt;enumeration value="semantics-Relations-Antonyms"/&gt;
 *     &lt;enumeration value="semantics-Relations-Troponyms"/&gt;
 *     &lt;enumeration value="semantics-Relations-Meronyms"/&gt;
 *     &lt;enumeration value="usage-Frequency"/&gt;
 *     &lt;enumeration value="usage-Register"/&gt;
 *     &lt;enumeration value="usage-Collocations"/&gt;
 *     &lt;enumeration value="usage-Examples"/&gt;
 *     &lt;enumeration value="usage-Notes"/&gt;
 *     &lt;enumeration value="definition/gloss"/&gt;
 *     &lt;enumeration value="translationEquivalent"/&gt;
 *     &lt;enumeration value="phonetics-Transcription"/&gt;
 *     &lt;enumeration value="semantics-Domain"/&gt;
 *     &lt;enumeration value="semantics-EventType"/&gt;
 *     &lt;enumeration value="semantics-SemanticRoles"/&gt;
 *     &lt;enumeration value="statisticalProperties"/&gt;
 *     &lt;enumeration value="morpho-Derivation"/&gt;
 *     &lt;enumeration value="semantics-QualiaStructure"/&gt;
 *     &lt;enumeration value="syntacticoSemanticLinks"/&gt;
 *     &lt;enumeration value="other"/&gt;
 *   &lt;/restriction&gt;
 * &lt;/simpleType&gt;
 * </pre>
 * 
 */
@XmlType(name = "")
@XmlEnum
public enum LinguisticInformationEnum {

    @XmlEnumValue("accentuation")
    ACCENTUATION("accentuation"),
    @XmlEnumValue("lemma")
    LEMMA("lemma"),
    @XmlEnumValue("lemma-MultiWordUnits")
    LEMMA_MULTI_WORD_UNITS("lemma-MultiWordUnits"),
    @XmlEnumValue("lemma-Variants")
    LEMMA_VARIANTS("lemma-Variants"),
    @XmlEnumValue("lemma-Abbreviations")
    LEMMA_ABBREVIATIONS("lemma-Abbreviations"),
    @XmlEnumValue("lemma-Compounds")
    LEMMA_COMPOUNDS("lemma-Compounds"),
    @XmlEnumValue("lemma-CliticForms")
    LEMMA_CLITIC_FORMS("lemma-CliticForms"),
    @XmlEnumValue("partOfSpeech")
    PART_OF_SPEECH("partOfSpeech"),
    @XmlEnumValue("morpho-Features")
    MORPHO_FEATURES("morpho-Features"),
    @XmlEnumValue("morpho-Case")
    MORPHO_CASE("morpho-Case"),
    @XmlEnumValue("morpho-Gender")
    MORPHO_GENDER("morpho-Gender"),
    @XmlEnumValue("morpho-Number")
    MORPHO_NUMBER("morpho-Number"),
    @XmlEnumValue("morpho-Degree")
    MORPHO_DEGREE("morpho-Degree"),
    @XmlEnumValue("morpho-IrregularForms")
    MORPHO_IRREGULAR_FORMS("morpho-IrregularForms"),
    @XmlEnumValue("morpho-Mood")
    MORPHO_MOOD("morpho-Mood"),
    @XmlEnumValue("morpho-Tense")
    MORPHO_TENSE("morpho-Tense"),
    @XmlEnumValue("morpho-Person")
    MORPHO_PERSON("morpho-Person"),
    @XmlEnumValue("morpho-Aspect")
    MORPHO_ASPECT("morpho-Aspect"),
    @XmlEnumValue("morpho-Voice")
    MORPHO_VOICE("morpho-Voice"),
    @XmlEnumValue("morpho-Auxiliary")
    MORPHO_AUXILIARY("morpho-Auxiliary"),
    @XmlEnumValue("morpho-Inflection")
    MORPHO_INFLECTION("morpho-Inflection"),
    @XmlEnumValue("morpho-Reflexivity")
    MORPHO_REFLEXIVITY("morpho-Reflexivity"),
    @XmlEnumValue("syntax-SubcatFrame")
    SYNTAX_SUBCAT_FRAME("syntax-SubcatFrame"),
    @XmlEnumValue("semantics-Traits")
    SEMANTICS_TRAITS("semantics-Traits"),
    @XmlEnumValue("semantics-SemanticClass")
    SEMANTICS_SEMANTIC_CLASS("semantics-SemanticClass"),
    @XmlEnumValue("semantics-CrossReferences")
    SEMANTICS_CROSS_REFERENCES("semantics-CrossReferences"),
    @XmlEnumValue("semantics-Relations")
    SEMANTICS_RELATIONS("semantics-Relations"),
    @XmlEnumValue("semantics-Relations-Hyponyms")
    SEMANTICS_RELATIONS_HYPONYMS("semantics-Relations-Hyponyms"),
    @XmlEnumValue("semantics-Relations-Hyperonyms")
    SEMANTICS_RELATIONS_HYPERONYMS("semantics-Relations-Hyperonyms"),
    @XmlEnumValue("semantics-Relations-Synonyms")
    SEMANTICS_RELATIONS_SYNONYMS("semantics-Relations-Synonyms"),
    @XmlEnumValue("semantics-Relations-Antonyms")
    SEMANTICS_RELATIONS_ANTONYMS("semantics-Relations-Antonyms"),
    @XmlEnumValue("semantics-Relations-Troponyms")
    SEMANTICS_RELATIONS_TROPONYMS("semantics-Relations-Troponyms"),
    @XmlEnumValue("semantics-Relations-Meronyms")
    SEMANTICS_RELATIONS_MERONYMS("semantics-Relations-Meronyms"),
    @XmlEnumValue("usage-Frequency")
    USAGE_FREQUENCY("usage-Frequency"),
    @XmlEnumValue("usage-Register")
    USAGE_REGISTER("usage-Register"),
    @XmlEnumValue("usage-Collocations")
    USAGE_COLLOCATIONS("usage-Collocations"),
    @XmlEnumValue("usage-Examples")
    USAGE_EXAMPLES("usage-Examples"),
    @XmlEnumValue("usage-Notes")
    USAGE_NOTES("usage-Notes"),
    @XmlEnumValue("definition/gloss")
    DEFINITION_GLOSS("definition/gloss"),
    @XmlEnumValue("translationEquivalent")
    TRANSLATION_EQUIVALENT("translationEquivalent"),
    @XmlEnumValue("phonetics-Transcription")
    PHONETICS_TRANSCRIPTION("phonetics-Transcription"),
    @XmlEnumValue("semantics-Domain")
    SEMANTICS_DOMAIN("semantics-Domain"),
    @XmlEnumValue("semantics-EventType")
    SEMANTICS_EVENT_TYPE("semantics-EventType"),
    @XmlEnumValue("semantics-SemanticRoles")
    SEMANTICS_SEMANTIC_ROLES("semantics-SemanticRoles"),
    @XmlEnumValue("statisticalProperties")
    STATISTICAL_PROPERTIES("statisticalProperties"),
    @XmlEnumValue("morpho-Derivation")
    MORPHO_DERIVATION("morpho-Derivation"),
    @XmlEnumValue("semantics-QualiaStructure")
    SEMANTICS_QUALIA_STRUCTURE("semantics-QualiaStructure"),
    @XmlEnumValue("syntacticoSemanticLinks")
    SYNTACTICO_SEMANTIC_LINKS("syntacticoSemanticLinks"),
    @XmlEnumValue("other")
    OTHER("other");
    private final String value;

    LinguisticInformationEnum(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static LinguisticInformationEnum fromValue(String v) {
        for (LinguisticInformationEnum c: LinguisticInformationEnum.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
