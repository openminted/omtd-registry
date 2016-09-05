package eu.openminted.registry.domain;

import java.util.List;

/**
 * Created by stefania on 9/5/16.
 */
public class ActualUseInfo {

    enum ActualUse {

        HUMAN_USE("humanUse"),
        NLP_APPLICATIONS("nlpApplications");

        private String value;

        ActualUse(String value) {
            this.value = value;
        }

        public String getValue() {
            return value;
        }
    }

    //required
    private ActualUse actualUse;
    //TODO this should be made into an enum (use useNLPSpecific)
    private List<String> useNlpApplications;
    private List<RelatedDocument> usageReports;
    private List<RelatedResource> derivedResources;
    private List<RelatedProject> usageProjects;
    private String actualUseDetails;

    public ActualUseInfo() {
    }

    public ActualUseInfo(ActualUse actualUse) {
        this.actualUse = actualUse;
    }

    public ActualUseInfo(ActualUse actualUse, List<String> useNlpApplications, List<RelatedDocument> usageReports,
                         List<RelatedResource> derivedResources, List<RelatedProject> usageProjects, String actualUseDetails) {
        this.actualUse = actualUse;
        this.useNlpApplications = useNlpApplications;
        this.usageReports = usageReports;
        this.derivedResources = derivedResources;
        this.usageProjects = usageProjects;
        this.actualUseDetails = actualUseDetails;
    }

    public ActualUse getActualUse() {
        return actualUse;
    }

    public void setActualUse(ActualUse actualUse) {
        this.actualUse = actualUse;
    }

    public List<String> getUseNlpApplications() {
        return useNlpApplications;
    }

    public void setUseNlpApplications(List<String> useNlpApplications) {
        this.useNlpApplications = useNlpApplications;
    }

    public List<RelatedDocument> getUsageReports() {
        return usageReports;
    }

    public void setUsageReports(List<RelatedDocument> usageReports) {
        this.usageReports = usageReports;
    }

    public List<RelatedResource> getDerivedResources() {
        return derivedResources;
    }

    public void setDerivedResources(List<RelatedResource> derivedResources) {
        this.derivedResources = derivedResources;
    }

    public List<RelatedProject> getUsageProjects() {
        return usageProjects;
    }

    public void setUsageProjects(List<RelatedProject> usageProjects) {
        this.usageProjects = usageProjects;
    }

    public String getActualUseDetails() {
        return actualUseDetails;
    }

    public void setActualUseDetails(String actualUseDetails) {
        this.actualUseDetails = actualUseDetails;
    }
}
