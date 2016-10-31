
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
 *     &lt;enumeration value="terms"/&gt;
 *     &lt;enumeration value="entries"/&gt;
 *     &lt;enumeration value="turns"/&gt;
 *     &lt;enumeration value="utterances"/&gt;
 *     &lt;enumeration value="articles"/&gt;
 *     &lt;enumeration value="files"/&gt;
 *     &lt;enumeration value="items"/&gt;
 *     &lt;enumeration value="seconds"/&gt;
 *     &lt;enumeration value="elements"/&gt;
 *     &lt;enumeration value="units"/&gt;
 *     &lt;enumeration value="minutes"/&gt;
 *     &lt;enumeration value="hours"/&gt;
 *     &lt;enumeration value="texts"/&gt;
 *     &lt;enumeration value="sentences"/&gt;
 *     &lt;enumeration value="bytes"/&gt;
 *     &lt;enumeration value="tokens"/&gt;
 *     &lt;enumeration value="words"/&gt;
 *     &lt;enumeration value="keywords"/&gt;
 *     &lt;enumeration value="idiomaticExpressions"/&gt;
 *     &lt;enumeration value="triples"/&gt;
 *     &lt;enumeration value="neologisms"/&gt;
 *     &lt;enumeration value="multiWordUnits"/&gt;
 *     &lt;enumeration value="expressions"/&gt;
 *     &lt;enumeration value="synsets"/&gt;
 *     &lt;enumeration value="classes"/&gt;
 *     &lt;enumeration value="concepts"/&gt;
 *     &lt;enumeration value="lexicalTypes"/&gt;
 *     &lt;enumeration value="phoneticUnits"/&gt;
 *     &lt;enumeration value="syntacticUnits"/&gt;
 *     &lt;enumeration value="semanticUnits"/&gt;
 *     &lt;enumeration value="predicates"/&gt;
 *     &lt;enumeration value="phonemes"/&gt;
 *     &lt;enumeration value="diphones"/&gt;
 *     &lt;enumeration value="T-HPairs"/&gt;
 *     &lt;enumeration value="syllables"/&gt;
 *     &lt;enumeration value="frames"/&gt;
 *     &lt;enumeration value="images"/&gt;
 *     &lt;enumeration value="kb"/&gt;
 *     &lt;enumeration value="mb"/&gt;
 *     &lt;enumeration value="gb"/&gt;
 *     &lt;enumeration value="rb"/&gt;
 *     &lt;enumeration value="shots"/&gt;
 *     &lt;enumeration value="unigrams"/&gt;
 *     &lt;enumeration value="bigrams"/&gt;
 *     &lt;enumeration value="trigrams"/&gt;
 *     &lt;enumeration value="4-grams"/&gt;
 *     &lt;enumeration value="5-grams"/&gt;
 *     &lt;enumeration value="rules"/&gt;
 *     &lt;enumeration value="questions"/&gt;
 *     &lt;enumeration value="other"/&gt;
 *   &lt;/restriction&gt;
 * &lt;/simpleType&gt;
 * </pre>
 * 
 */
@XmlType(name = "")
@XmlEnum
public enum SizeUnitEnum {

    @XmlEnumValue("terms")
    TERMS("terms"),
    @XmlEnumValue("entries")
    ENTRIES("entries"),
    @XmlEnumValue("turns")
    TURNS("turns"),
    @XmlEnumValue("utterances")
    UTTERANCES("utterances"),
    @XmlEnumValue("articles")
    ARTICLES("articles"),
    @XmlEnumValue("files")
    FILES("files"),
    @XmlEnumValue("items")
    ITEMS("items"),
    @XmlEnumValue("seconds")
    SECONDS("seconds"),
    @XmlEnumValue("elements")
    ELEMENTS("elements"),
    @XmlEnumValue("units")
    UNITS("units"),
    @XmlEnumValue("minutes")
    MINUTES("minutes"),
    @XmlEnumValue("hours")
    HOURS("hours"),
    @XmlEnumValue("texts")
    TEXTS("texts"),
    @XmlEnumValue("sentences")
    SENTENCES("sentences"),
    @XmlEnumValue("bytes")
    BYTES("bytes"),
    @XmlEnumValue("tokens")
    TOKENS("tokens"),
    @XmlEnumValue("words")
    WORDS("words"),
    @XmlEnumValue("keywords")
    KEYWORDS("keywords"),
    @XmlEnumValue("idiomaticExpressions")
    IDIOMATIC_EXPRESSIONS("idiomaticExpressions"),
    @XmlEnumValue("triples")
    TRIPLES("triples"),
    @XmlEnumValue("neologisms")
    NEOLOGISMS("neologisms"),
    @XmlEnumValue("multiWordUnits")
    MULTI_WORD_UNITS("multiWordUnits"),
    @XmlEnumValue("expressions")
    EXPRESSIONS("expressions"),
    @XmlEnumValue("synsets")
    SYNSETS("synsets"),
    @XmlEnumValue("classes")
    CLASSES("classes"),
    @XmlEnumValue("concepts")
    CONCEPTS("concepts"),
    @XmlEnumValue("lexicalTypes")
    LEXICAL_TYPES("lexicalTypes"),
    @XmlEnumValue("phoneticUnits")
    PHONETIC_UNITS("phoneticUnits"),
    @XmlEnumValue("syntacticUnits")
    SYNTACTIC_UNITS("syntacticUnits"),
    @XmlEnumValue("semanticUnits")
    SEMANTIC_UNITS("semanticUnits"),
    @XmlEnumValue("predicates")
    PREDICATES("predicates"),
    @XmlEnumValue("phonemes")
    PHONEMES("phonemes"),
    @XmlEnumValue("diphones")
    DIPHONES("diphones"),
    @XmlEnumValue("T-HPairs")
    T_H_PAIRS("T-HPairs"),
    @XmlEnumValue("syllables")
    SYLLABLES("syllables"),
    @XmlEnumValue("frames")
    FRAMES("frames"),
    @XmlEnumValue("images")
    IMAGES("images"),
    @XmlEnumValue("kb")
    KB("kb"),
    @XmlEnumValue("mb")
    MB("mb"),
    @XmlEnumValue("gb")
    GB("gb"),
    @XmlEnumValue("rb")
    RB("rb"),
    @XmlEnumValue("shots")
    SHOTS("shots"),
    @XmlEnumValue("unigrams")
    UNIGRAMS("unigrams"),
    @XmlEnumValue("bigrams")
    BIGRAMS("bigrams"),
    @XmlEnumValue("trigrams")
    TRIGRAMS("trigrams"),
    @XmlEnumValue("4-grams")
    V4_GRAMS("4-grams"),
    @XmlEnumValue("5-grams")
    V5_GRAMS("5-grams"),
    @XmlEnumValue("rules")
    RULES("rules"),
    @XmlEnumValue("questions")
    QUESTIONS("questions"),
    @XmlEnumValue("other")
    OTHER("other");
    private final String value;

    SizeUnitEnum(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static SizeUnitEnum fromValue(String v) {
        for (SizeUnitEnum c: SizeUnitEnum.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
