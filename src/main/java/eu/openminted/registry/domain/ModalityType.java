package eu.openminted.registry.domain;

/**
 * Created by stefania on 9/5/16.
 */
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
}
