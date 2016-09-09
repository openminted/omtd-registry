package eu.openminted.registry.domain;

/**
 * Created by stefania on 9/5/16.
 */
public enum ClassificationScheme implements IdentifierSchema {

    DDC("DDC"),
    UDC("UDC"),
    EURO_VOC("EuroVoc"),
    LCSH("LCSH"),
    DK_5("DK-5"),
    MESH("MeSH"),
    ANC_CLASSIFICATION("ANC_classification"),
    BNC_CLASSIFICATION("BNC_classification"),
    NLK_CLASSIFICATION("NLK_classification"),
    PAROLE_TOPIC_CLASSIFICATION("PAROLE_topicClassification"),
    PAROLE_GENRE_CLASSIFICATION("PAROLE_genreClassification"),
    OTHER("other");

    private String value;

    ClassificationScheme(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public static ClassificationScheme forValue(String value) {
        for (ClassificationScheme ut: values()) {
            if (ut.getValue().equals(value))
                return ut;
        }

        return null;
    }
}