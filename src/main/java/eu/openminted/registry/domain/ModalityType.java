package eu.openminted.registry.domain;

import javax.xml.bind.annotation.adapters.XmlAdapter;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

/**
 * Created by stefania on 9/5/16.
 */
@XmlJavaTypeAdapter(ModalityTypeAdapter.class)
public enum ModalityType {

    BODY_GESTURE("bodyGesture"),
    FACIAL_EXPRESSION("facialExpression"),
    VOICE("voice"),
    COMBINATION_OF_MODALITIES("combinationOfModalities"),
    SIGN_LANGUAGE("signLanguage"),
    SPOKEN_LANGUAGE("spokenLanguage"),
    WRITTEN_LANGUAGE("writtenLanguage"),
    OTHER("other");

    private String value;

    ModalityType(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public static ModalityType forValue(String value) {
        for (ModalityType ut: values()) {
            if (ut.getValue().equals(value))
                return ut;
        }

        return null;
    }
}

class ModalityTypeAdapter extends XmlAdapter<String, ModalityType> {

    @Override
    public String marshal(ModalityType v) throws Exception {
        return v!=null?v.getValue():null;
    }

    @Override
    public ModalityType unmarshal(String v) throws Exception {
        return ModalityType.forValue(v);
    }
}

