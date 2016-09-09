package eu.openminted.registry.domain;

import javax.xml.bind.annotation.adapters.XmlAdapter;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

/**
 * Created by stefania on 9/5/16.
 */
public class SizeInfo {

    @XmlJavaTypeAdapter(SizeUnitAdapter.class)
    enum SizeUnit {

        TERMS("terms"),
        ENTRIES("entries"),
        TURNS("turns"),
        UTTERANCES("utterances"),
        ARTICLES("articles"),
        FILES("files"),
        ITEMS("items"),
        SECONDS("seconds"),
        ELEMENTS("elements"),
        UNITS("units"),
        MINUTES("minutes"),
        HOURS("hours"),
        TEXTS("texts"),
        SENTENCES("sentences"),
        BYTES("bytes"),
        TOKENS("tokens"),
        WORDS("words"),
        KEYWORDS("keywords"),
        IDIOMATIC_EXPRESSIONS("idiomaticExpressions"),
        TRIPLES("triples"),
        NEOLOGISMS("neologisms"),
        MULTI_WORD_UNITS("multiWordUnits"),
        EXPRESSIONS("expressions"),
        SYNSETS("synsets"),
        CLASSES("classes"),
        CONCEPTS("concepts"),
        LEXICAL_TYPES("lexicalTypes"),
        PHONETIC_UNITS("phoneticUnits"),
        SYNTACTIC_UNITS("syntacticUnits"),
        SEMANTIC_UNITS("semanticUnits"),
        PREDICATES("predicates"),
        PHONEMES("phonemes"),
        DIPHONES("diphones"),
        T_H_PAIRS("T-HPairs"),
        SYLLABLES("syllables"),
        FRAMES("frames"),
        IMAGES("images"),
        KB("kb"),
        MB("mb"),
        GB("gb"),
        RB("rb"),
        SHOTS("shots"),
        UNIGRAMS("unigrams"),
        BIGRAMS("bigrams"),
        TRIGRAMS("trigrams"),
        FOUR_GRAMS("4-grams"),
        FIVE_GRAMS("5-grams"),
        RULES("rules"),
        QUESTIONS("questions"),
        OTHER("other");

        private String value;

        SizeUnit(String value) {
            this.value = value;
        }

        public String getValue() {
            return value;
        }

        public static SizeUnit forValue(String value) {
            for (SizeUnit ut: values()) {
                if (ut.getValue().equals(value))
                    return ut;
            }

            return null;
        }
    }

    //required
    private String size;
    //required
    private SizeUnit sizeUnit;

    public SizeInfo() {
    }

    public SizeInfo(String size, SizeUnit sizeUnit) {
        this.size = size;
        this.sizeUnit = sizeUnit;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public SizeUnit getSizeUnit() {
        return sizeUnit;
    }

    public void setSizeUnit(SizeUnit sizeUnit) {
        this.sizeUnit = sizeUnit;
    }
}

class SizeUnitAdapter extends XmlAdapter<String, SizeInfo.SizeUnit> {

    @Override
    public String marshal(SizeInfo.SizeUnit v) throws Exception {
        return v!=null?v.getValue():null;
    }

    @Override
    public SizeInfo.SizeUnit unmarshal(String v) throws Exception {
        return SizeInfo.SizeUnit.forValue(v);
    }
}