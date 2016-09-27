package eu.openminted.registry.domain;

import javax.xml.bind.annotation.adapters.XmlAdapter;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

/**
 * @author Steve
 *
 */
@XmlJavaTypeAdapter(LinguisticInformationAdapter.class)
public enum LinguisticInformation {

	ACCENTUATION("accentuation"),
	LEMMA("lemma"),
	LEMMA_MULTIWORDUNITS("lemma-MultiWordUnits"),
	LEMMA_VARIANTS("lemma-Variants"),
	LEMMA_ABBREVIATIONS("lemma-Abbreviations"),
	LEMMA_COMPOUNDS("lemma-Compounds"),
	LEMMA_CLITICFORMS("lemma-CliticForms"),
	PARTOFSPEECH("partOfSpeech"),
	MORPHO_FEATURES("morpho-Features"),
	MORPHO_CASE("morpho-Case"),
	MORPHO_GENDER("morpho-Gender"),
	MORPHO_NUMBER("morpho-Number"),
	MORPHO_DEGREE("morpho-Degree"),
	MORPHO_IRREGULARFORMS("morpho-IrregularForms"),
	MORPHO_MOOD("morpho-Mood"),
	MORPHO_TENSE("morpho-Tense"),
	MORPHO_PERSON("morpho-Person"),
	MORPHO_ASPECT("morpho-Aspect"),
	MORPHO_VOICE("morpho-Voice"),
	MORPHO_AUXILIARY("morpho-Auxiliary"),
	MORPHO_INFLECTION("morpho-Inflection"),
	MORPHO_REFLEXIVITY("morpho-Reflexivity"),
	SYNTAX_SUBCATFRAME("syntax-SubcatFrame"),
	SEMANTICS_TRAITS("semantics-Traits"),
	SEMANTICS_SEMANTICCLASS("semantics-SemanticClass"),
	SEMANTICS_CROSSREFERENCES("semantics-CrossReferences"),
	SEMANTICS_RELATIONS("semantics-Relations"),
	SEMANTICS_RELATIONS_HYPONYMS("semantics-Relations-Hyponyms"),
	SEMANTICS_RELATIONS_HYPERONYMS("semantics-Relations-Hyperonyms"),
	SEMANTICS_RELATIONS_SYNONYMS("semantics-Relations-Synonyms"),
	SEMANTICS_RELATIONS_ANTONYMS("semantics-Relations-Antonyms"),
	SEMANTICS_RELATIONS_TROPONYMS("semantics-Relations-Troponyms"),
	SEMANTICS_RELATIONS_MERONYMS("semantics-Relations-Meronyms"),
	USAGE_FREQUENCY("usage-Frequency"),
	USAGE_REGISTER("usage-Register"),
	USAGE_COLLOCATIONS("usage-Collocations"),
	USAGE_EXAMPLES("usage-Examples"),
	USAGE_NOTES("usage-Notes"),
	DEFINITIONGLOSS("definition/gloss"),
	TRANSLATIONEQUIVALENT("translationEquivalent"),
	PHONETICS_TRANSCRIPTION("phonetics-Transcription"),
	SEMANTICS_DOMAIN("semantics-Domain"),
	SEMANTICS_EVENTTYPE("semantics-EventType"),
	SEMANTICS_SEMANTICROLES("semantics-SemanticRoles"),
	STATISTICALPROPERTIES("statisticalProperties"),
	MORPHO_DERIVATION("morpho-Derivation"),
	SEMANTICS_QUALIASTRUCTURE("semantics-QualiaStructure"),
	SYNTACTICOSEMANTICLINKS("syntacticoSemanticLinks"),
	OTHER("other");

	private String value;

	LinguisticInformation(String value) {
		this.value = value;
	}

	public String getValue() {
		return value;
	}

	public static LinguisticInformation forValue(
			String value) {
		for (LinguisticInformation ut : values()) {
			if (ut.getValue().equals(value))
				return ut;
		}
		return null;
	}

}

class LinguisticInformationAdapter extends
		XmlAdapter<String, LinguisticInformation> {

	@Override
	public String marshal(LinguisticInformation v)
			throws Exception {
		return v != null ? v.getValue() : null;
	}

	@Override
	public LinguisticInformation unmarshal(String v)
			throws Exception {
		return LinguisticInformation.forValue(v);
	}
}
