package eu.openminted.registry.domain;

import javax.xml.bind.annotation.adapters.XmlAdapter;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

/**
 * @author Steve
 *
 */
@XmlJavaTypeAdapter(LinguisticInformationAdapter.class)
public enum LinguisticInformation {

	ACCENTUATION("accentuation"), LEMMA("lemma"), LEMMA_MULTIWORDUNITS(
			"lemma-multiwordunits"), LEMMA_VARIANTS("lemma-variants"), LEMMA_ABBREVIATIONS(
			"lemma-abbreviations"), LEMMA_COMPOUNDS("lemma-compounds"), LEMMA_CLITICFORMS(
			"lemma-cliticforms"), PARTOFSPEECH("partofspeech"), MORPHO_FEATURES(
			"morpho-features"), MORPHO_CASE("morpho-case"), MORPHO_GENDER(
			"morpho-gender"), MORPHO_NUMBER("morpho-number"), MORPHO_DEGREE(
			"morpho-degree"), MORPHO_IRREGULARFORMS("morpho-irregularforms"), MORPHO_MOOD(
			"morpho-mood"), MORPHO_TENSE("morpho-tense"), MORPHO_PERSON(
			"morpho-person"), MORPHO_ASPECT("morpho-aspect"), MORPHO_VOICE(
			"morpho-voice"), MORPHO_AUXILIARY("morpho-auxiliary"), MORPHO_INFLECTION(
			"morpho-inflection"), MORPHO_REFLEXIVITY("morpho-reflexivity"), SYNTAX_SUBCATFRAME(
			"syntax-subcatframe"), SEMANTICS_TRAITS("semantics-traits"), SEMANTICS_SEMANTICCLASS(
			"semantics-semanticclass"), SEMANTICS_CROSSREFERENCES(
			"semantics-crossreferences"), SEMANTICS_RELATIONS(
			"semantics-relations"), SEMANTICS_RELATIONS_HYPONYMS(
			"semantics-relations-hyponyms"), SEMANTICS_RELATIONS_HYPERONYMS(
			"semantics-relations-hyperonyms"), SEMANTICS_RELATIONS_SYNONYMS(
			"semantics-relations-synonyms"), SEMANTICS_RELATIONS_ANTONYMS(
			"semantics-relations-antonyms"), SEMANTICS_RELATIONS_TROPONYMS(
			"semantics-relations-troponyms"), SEMANTICS_RELATIONS_MERONYMS(
			"semantics-relations-meronyms"), USAGE_FREQUENCY("usage-frequency"), USAGE_REGISTER(
			"usage-register"), USAGE_COLLOCATIONS("usage-collocations"), USAGE_EXAMPLES(
			"usage-examples"), USAGE_NOTES("usage-notes"), DEFINITION_GLOSS(
			"definition/gloss"), TRANSLATIONEQUIVALENT("translationequivalent"), PHONETICS_TRANSCRIPTION(
			"phonetics-transcription"), SEMANTICS_DOMAIN("semantics-domain"), SEMANTICS_EVENTTYPE(
			"semantics-eventtype"), SEMANTICS_SEMANTICROLES(
			"semantics-semanticroles"), STATISTICALPROPERTIES(
			"statisticalproperties"), MORPHO_DERIVATION("morpho-derivation"), SEMANTICS_QUALIASTRUCTURE(
			"semantics-qualiastructure"), SYNTACTICOSEMANTICLINKS(
			"syntacticosemanticlinks"), OTHER("other");

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
