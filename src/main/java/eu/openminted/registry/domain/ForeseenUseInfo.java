package eu.openminted.registry.domain;

import java.util.List;

/**
 * Created by stefania on 9/5/16.
 */
public class ForeseenUseInfo {

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
    }

    //required
    private ForeseenUse foreseenUse;
    //TODO this should be made into an enum (use useNLPSpecific)
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
