package eu.openminted.registry.domain;

import javax.xml.bind.annotation.adapters.XmlAdapter;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

/**
 * 
 * @author Steve
 *
 */
@XmlJavaTypeAdapter(ExtraTextualInformationUnitAdapter.class)
public enum ExtraTextualInformationUnit {
	
	WORD("word"),
	LEMMA("lemma"),
	SEMANTICS("semantics"),
	EXAMPLE("example"),
	SYNTAX("syntax"),
	LEXICALUNIT("lexicalUnit"),
	OTHER("other");
	
	private String value;
	
	ExtraTextualInformationUnit(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public static ExtraTextualInformationUnit forValue(String value) {
        for (ExtraTextualInformationUnit ut: values()) {
            if (ut.getValue().equals(value))
                return ut;
        }

        return null;
    }
}

class ExtraTextualInformationUnitAdapter extends XmlAdapter<String, ExtraTextualInformationUnit> {

    @Override
    public String marshal(ExtraTextualInformationUnit v) throws Exception {
        return v!=null?v.getValue():null;
    }

    @Override
    public ExtraTextualInformationUnit unmarshal(String v) throws Exception {
        return ExtraTextualInformationUnit.forValue(v);
    }
}
