package eu.openminted.registry.domain;

/**
 * Created by stefania on 9/5/16.
 */
public enum MediaType {

    TEXT("text"),
    AUDIO("audio"),
    VIDEO("video"),
    IMAGE("image"),
    TEXT_NUMERICAL("textNumerical");

    private String value;

    MediaType(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
