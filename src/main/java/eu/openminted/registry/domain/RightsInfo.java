package eu.openminted.registry.domain;

import java.util.List;

/**
 * Created by stefania on 9/5/16.
 */
public class RightsInfo {

    //either only RightsStatementInfo which will be required, or List<LicenseInfo> is required and RightsStatementInfo is optional
    private List<LicenseInfo> licenseInfos;
    private RightsStatementInfo rightsStatementInfo;

    public RightsInfo() {
    }

    public RightsInfo(RightsStatementInfo rightsStatementInfo) {
        this.rightsStatementInfo = rightsStatementInfo;
    }

    public RightsInfo(List<LicenseInfo> licenseInfos) {
        this.licenseInfos = licenseInfos;
    }

    public RightsInfo(List<LicenseInfo> licenseInfos, RightsStatementInfo rightsStatementInfo) {
        this.licenseInfos = licenseInfos;
        this.rightsStatementInfo = rightsStatementInfo;
    }

    public List<LicenseInfo> getLicenseInfos() {
        return licenseInfos;
    }

    public void setLicenseInfos(List<LicenseInfo> licenseInfos) {
        this.licenseInfos = licenseInfos;
    }

    public RightsStatementInfo getRightsStatementInfo() {
        return rightsStatementInfo;
    }

    public void setRightsStatementInfo(RightsStatementInfo rightsStatementInfo) {
        this.rightsStatementInfo = rightsStatementInfo;
    }
}
