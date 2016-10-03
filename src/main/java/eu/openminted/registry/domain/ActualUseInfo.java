package eu.openminted.registry.domain;

import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.XmlAdapter;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

/**
 * Created by stefania on 9/5/16.
 */

@XmlType(name = "actualUseInfo", propOrder = {
	    "actualUse",
	    "useNlpApplications",
	    "usageReports",
	    "derivedResources",
	    "usageProjects",
	    "actualUseDetails"
	})
public class ActualUseInfo {

	@XmlJavaTypeAdapter(ActualUseAdapter.class)
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
        
        public static ActualUse forValue(String value) {
            for (ActualUse ut: values()) {
                if (ut.getValue().equals(value))
                    return ut;
            }

            return null;
        }
    }

    //required
    private ActualUse actualUse;
    //TODO this should be made into an enum (use useNLPSpecific)
    
    @XmlElementWrapper(name = "useNlpApplication")
    @XmlElement(name = "useNLPSpecific")
    private List<String> useNlpApplications;
    
    @XmlElementWrapper(name = "usageReports")
    @XmlElement(name = "usageReport")
    private List<RelatedDocument> usageReports;
    
    @XmlElementWrapper(name = "derivedResources")
    @XmlElement(name = "derivedResource")
    private List<RelatedResource> derivedResources;
    
    @XmlElementWrapper(name = "usageProjects")
    @XmlElement(name = "usageProject")
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

class ActualUseAdapter extends XmlAdapter<String, ActualUseInfo.ActualUse> {

    @Override
    public String marshal(ActualUseInfo.ActualUse v) throws Exception {
        return v!=null?v.getValue():null;
    }

    @Override
    public ActualUseInfo.ActualUse unmarshal(String v) throws Exception {
        return ActualUseInfo.ActualUse.forValue(v);
    }
}
