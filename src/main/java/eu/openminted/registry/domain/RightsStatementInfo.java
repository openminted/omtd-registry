package eu.openminted.registry.domain;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.adapters.XmlAdapter;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

/**
 * Created by stefania on 9/5/16.
 */
public class RightsStatementInfo {

	@XmlJavaTypeAdapter(RightsStatementInfo.RightsStatementNameAdapter.class)
    enum RightsStatementName {

        OPEN_ACCESS("openAccess"),
        CLOSED_ACCESS("closedAccess"),
        EMBARGOED_ACCESS("embargoedAccess"),
        RESTRICTED_ACCESS("restrictedAccess");

        private String value;

        RightsStatementName(String value) {
            this.value = value;
        }

        public String getValue() {
            return value;
        }
        
        public static RightsStatementName forValue(String value) {
            for (RightsStatementName ut: values()) {
                if (ut.getValue().equals(value))
                    return ut;
            }

            return null;
        }
    }

    //required
	@XmlElement(name = "rightsStmtName")
    private RightsStatementName rightsStatementName;
    //required
	@XmlElement(name = "rightsStmtURL")
    private String rightsStatementURL;

    public RightsStatementInfo() {
    }

    public RightsStatementInfo(RightsStatementName rightsStatementName, String rightsStatementURL) {
        this.rightsStatementName = rightsStatementName;
        this.rightsStatementURL = rightsStatementURL;
    }

    public RightsStatementName getRightsStatementName() {
        return rightsStatementName;
    }

    public void setRightsStatementName(RightsStatementName rightsStatementName) {
        this.rightsStatementName = rightsStatementName;
    }

    public String getRightsStatementURL() {
        return rightsStatementURL;
    }

    public void setRightsStatementURL(String rightsStatementURL) {
        this.rightsStatementURL = rightsStatementURL;
    }
    
    public static class RightsStatementNameAdapter extends XmlAdapter<String, RightsStatementInfo.RightsStatementName> {

        @Override
        public String marshal(RightsStatementInfo.RightsStatementName v) throws Exception {
            return v!=null?v.getValue():null;
        }

        @Override
        public RightsStatementInfo.RightsStatementName unmarshal(String v) throws Exception {
            return RightsStatementInfo.RightsStatementName.forValue(v);
        }
    }
}
