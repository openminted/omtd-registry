package eu.openminted.registry.domain;

import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.adapters.XmlAdapter;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

/**
 * Created by stefania on 9/5/16.
 */
public class ForeseenUseInfo {

	@XmlJavaTypeAdapter(ForeseenUseAdapter.class)
    enum ForeseenUse {

        HUMAN_USE("humanUse"),
        NLP_APPLICATIONS("nlpApplications");

        private String value;

        ForeseenUse(String value) {
            this.value = value;
        }

        public String getValue() {
            return value;
        }
        
        public static ForeseenUse forValue(String value) {
            for (ForeseenUse ut: values()) {
                if (ut.getValue().equals(value))
                    return ut;
            }

            return null;
        }
    }

    //required
	@XmlElement(name = "foreseenUse")
    private ForeseenUse foreseenUse;
    //TODO this should be made into an enum (use useNLPSpecific)
    
    @XmlElementWrapper(name = "useNlpApplications")
    @XmlElement(name = "useNLPSpecific")
    private List<String> useNlpApplications;

    public ForeseenUseInfo() {
    }

    public ForeseenUseInfo(ForeseenUse foreseenUse) {
        this.foreseenUse = foreseenUse;
    }

    public ForeseenUseInfo(ForeseenUse foreseenUse, List<String> useNlpApplications) {
        this.foreseenUse = foreseenUse;
        this.useNlpApplications = useNlpApplications;
    }

    public ForeseenUse getForeseenUse() {
        return foreseenUse;
    }

    public void setForeseenUse(ForeseenUse foreseenUse) {
        this.foreseenUse = foreseenUse;
    }

    public List<String> getUseNlpApplications() {
        return useNlpApplications;
    }

    public void setUseNlpApplications(List<String> useNlpApplications) {
        this.useNlpApplications = useNlpApplications;
    }
    
}

class ForeseenUseAdapter extends XmlAdapter<String, ForeseenUseInfo.ForeseenUse> {

    @Override
    public String marshal(ForeseenUseInfo.ForeseenUse v) throws Exception {
        return v!=null?v.getValue():null;
    }

    @Override
    public ForeseenUseInfo.ForeseenUse unmarshal(String v) throws Exception {
        return ForeseenUseInfo.ForeseenUse.forValue(v);
    }
}
