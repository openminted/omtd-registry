package eu.openminted.registry.domain;

import javax.xml.bind.annotation.adapters.XmlAdapter;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

@XmlJavaTypeAdapter(EncodingLevelAdapter.class)
public enum EncodingLevel {
	
	PHONETICS("phonetics"),
	PHONOLOGY("phonology"),
	SEMANTICS("semantics"),
	MORPHOLOGY("morphology"),
	SYNTAX("syntax"),
	PRAGMATICS("pragmatics"),
	OTHER("other");
	
	private String value;
	
	EncodingLevel(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public static EncodingLevel forValue(String value) {
        for (EncodingLevel ut: values()) {
            if (ut.getValue().equals(value))
                return ut;
        }

        return null;
    }
}

class EncodingLevelAdapter extends XmlAdapter<String, EncodingLevel> {

    @Override
    public String marshal(EncodingLevel v) throws Exception {
        return v!=null?v.getValue():null;
    }

    @Override
    public EncodingLevel unmarshal(String v) throws Exception {
        return EncodingLevel.forValue(v);
    }
}
