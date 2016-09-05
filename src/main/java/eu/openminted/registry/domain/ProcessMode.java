package eu.openminted.registry.domain;

/**
 * Created by stefania on 9/5/16.
 */
public enum ProcessMode {

    MANUAL("manual"),
    AUTOMATIC("automatic"),
    MIXED("mixed"),
    INTERACTIVE("interactive");

    private String value;

    ProcessMode(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
