package eu.openminted.registry.domain;

/**
 * Created by stefania on 9/5/16.
 */
public class RightsStatementInfo {

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
    }

    //required
    private RightsStatementName rightsStatementName;
    //required
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
}
