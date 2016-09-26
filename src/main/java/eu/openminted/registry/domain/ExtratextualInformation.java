package eu.openminted.registry.domain;

import javax.xml.bind.annotation.adapters.XmlAdapter;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

/**
 * 
 * @author Steve
 *
 */
@XmlJavaTypeAdapter(ExtratextualInformationAdapter.class)
public enum ExtratextualInformation {
	
	IMAGES("images"),
	VIDEOS("videos"),
	SOUND_RECORDINGS("soundRecordings"),
	OTHER("other");
	
	private String value;
	
	ExtratextualInformation(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public static ExtratextualInformation forValue(String value) {
        for (ExtratextualInformation ut: values()) {
            if (ut.getValue().equals(value))
                return ut;
        }

        return null;
    }
}

class ExtratextualInformationAdapter extends XmlAdapter<String, ExtratextualInformation> {

    @Override
    public String marshal(ExtratextualInformation v) throws Exception {
        return v!=null?v.getValue():null;
    }

    @Override
    public ExtratextualInformation unmarshal(String v) throws Exception {
        return ExtratextualInformation.forValue(v);
    }
}
