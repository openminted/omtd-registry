package eu.openminted.registry.domain;

import javax.xml.bind.annotation.adapters.XmlAdapter;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

@XmlJavaTypeAdapter(LexicalConceptualResourceTypeAdapter.class)
public enum LexicalConceptualResourceType {
	
	WORDLIST("wordList"),
	COMPUTATIONALLEXICON("computationalLexicon"),
	ONTOLOGY("ontology"),
	WORDNET("wordnet"),
	THESAURUS("thesaurus"),
	FRAMENET("framenet"),
	TERMINOLOGICALRESOURCE("terminologicalResource"),
	MACHINEREADABLEDICTIONARY("machineReadableDictionary"),
	LEXICON("lexicon"),
	TYPESYSTEM("typesystem"),
	TAGSET("tagset"),
	MAPPINGOFRESOURCES("mappingOfResources"),
	OTHER("other");
	
	private String value;
	
	LexicalConceptualResourceType(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public static LexicalConceptualResourceType forValue(String value) {
        for (LexicalConceptualResourceType ut: values()) {
            if (ut.getValue().equals(value))
                return ut;
        }

        return null;
    }
}

class LexicalConceptualResourceTypeAdapter extends XmlAdapter<String, LexicalConceptualResourceType> {

    @Override
    public String marshal(LexicalConceptualResourceType v) throws Exception {
        return v!=null?v.getValue():null;
    }

    @Override
    public LexicalConceptualResourceType unmarshal(String v) throws Exception {
        return LexicalConceptualResourceType.forValue(v);
    }
}
