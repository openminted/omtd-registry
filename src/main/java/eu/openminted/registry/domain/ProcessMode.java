package eu.openminted.registry.domain;

import javax.xml.bind.annotation.adapters.XmlAdapter;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

/**
 * Created by stefania on 9/5/16.
 */
@XmlJavaTypeAdapter(ProcessModeAdapter.class)
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

    public static ProcessMode forValue(String value) {
        for (ProcessMode ut: values()) {
            if (ut.getValue().equals(value))
                return ut;
        }

        return null;
    }
}

class ProcessModeAdapter extends XmlAdapter<String, ProcessMode> {

    @Override
    public String marshal(ProcessMode v) throws Exception {
        return v!=null?v.getValue():null;
    }

    @Override
    public ProcessMode unmarshal(String v) throws Exception {
        return ProcessMode.forValue(v);
    }
}

