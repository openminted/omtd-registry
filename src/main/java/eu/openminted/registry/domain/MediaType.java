package eu.openminted.registry.domain;

import javax.xml.bind.annotation.adapters.XmlAdapter;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

/**
 * Created by stefania on 9/5/16.
 */

@XmlJavaTypeAdapter(MediaTypeAdapter.class)
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

    public static MediaType forValue(String value) {
        for (MediaType ut: values()) {
            if (ut.getValue().equals(value))
                return ut;
        }

        return null;
    }
}

class MediaTypeAdapter extends XmlAdapter<String, MediaType> {

    @Override
    public String marshal(MediaType v) throws Exception {
        return v!=null?v.getValue():null;
    }

    @Override
    public MediaType unmarshal(String v) throws Exception {
        return MediaType.forValue(v);
    }
}

