package eu.openminted.registry.domain;

import java.util.Date;
import java.util.List;

/**
 * Created by stefania on 9/5/16.
 */
public class ComponentDistributionInfo {

    enum ComponentDistributionMedium {

        WEB_SERVICE("webService"),
        SOURCE_CODE("sourceCode"),
        EXECUTABLE_CODE("executableCode");

        private String value;

        ComponentDistributionMedium(String value) {
            this.value = value;
        }

        public String getValue() {
            return value;
        }
    }

    enum WebServiceType {

        SOAP("SOAP"),
        REST("REST"),
        OTHER("other");

        private String value;

        WebServiceType(String value) {
            this.value = value;
        }

        public String getValue() {
            return value;
        }
    }

    enum OperatingSystem {

        OS_INDEPENDENT("os-independent"),
        WINDOWS("windows"),
        LINUX("linux"),
        UNIX("unix"),
        MAC_OS("mac-OS"),
        GOOGLE_CHROME_OS("googleChromeOS"),
        IOS("iOS"),
        ANDROID("android"),
        OTHER("other");

        private String value;

        OperatingSystem(String value) {
            this.value = value;
        }

        public String getValue() {
            return value;
        }
    }

    enum UserType {

        ACADEMIC("academic"),
        COMMERCIAL("commercial"),
        MEMBERS_OF_GROUP("membersOfGroup");

        private String value;

        UserType(String value) {
            this.value = value;
        }

        public String getValue() {
            return value;
        }
    }

    //required
    private ComponentDistributionMedium componentDistributionMedium;
    private List<String> downloadURLs;
    private List<String> accessURLs;
    private String mavenId;
    private WebServiceType webServiceType;
    private OperatingSystem operatingSystem;
    //required
    private RightsInfo rightsInfo;
    private List<String> copyrightStatements;
    private List<String> attributionTexts;
    private List<ActorInfo> rightsHolders;
    private Date availabilityStartDate;
    private Date availabilityEndDate;
    private String fee;
    private List<UserType> userTypes;

    public ComponentDistributionInfo() {
    }

    public ComponentDistributionInfo(ComponentDistributionMedium componentDistributionMedium, RightsInfo rightsInfo) {
        this.componentDistributionMedium = componentDistributionMedium;
        this.rightsInfo = rightsInfo;
    }

    public ComponentDistributionInfo(ComponentDistributionMedium componentDistributionMedium, List<String> downloadURLs,
                                     List<String> accessURLs, String mavenId, WebServiceType webServiceType,
                                     OperatingSystem operatingSystem, RightsInfo rightsInfo, List<String> copyrightStatements,
                                     List<String> attributionTexts, List<ActorInfo> rightsHolders, Date availabilityStartDate,
                                     Date availabilityEndDate, String fee, List<UserType> userTypes) {
        this.componentDistributionMedium = componentDistributionMedium;
        this.downloadURLs = downloadURLs;
        this.accessURLs = accessURLs;
        this.mavenId = mavenId;
        this.webServiceType = webServiceType;
        this.operatingSystem = operatingSystem;
        this.rightsInfo = rightsInfo;
        this.copyrightStatements = copyrightStatements;
        this.attributionTexts = attributionTexts;
        this.rightsHolders = rightsHolders;
        this.availabilityStartDate = availabilityStartDate;
        this.availabilityEndDate = availabilityEndDate;
        this.fee = fee;
        this.userTypes = userTypes;
    }

    public ComponentDistributionMedium getComponentDistributionMedium() {
        return componentDistributionMedium;
    }

    public void setComponentDistributionMedium(ComponentDistributionMedium componentDistributionMedium) {
        this.componentDistributionMedium = componentDistributionMedium;
    }

    public List<String> getDownloadURLs() {
        return downloadURLs;
    }

    public void setDownloadURLs(List<String> downloadURLs) {
        this.downloadURLs = downloadURLs;
    }

    public List<String> getAccessURLs() {
        return accessURLs;
    }

    public void setAccessURLs(List<String> accessURLs) {
        this.accessURLs = accessURLs;
    }

    public String getMavenId() {
        return mavenId;
    }

    public void setMavenId(String mavenId) {
        this.mavenId = mavenId;
    }

    public WebServiceType getWebServiceType() {
        return webServiceType;
    }

    public void setWebServiceType(WebServiceType webServiceType) {
        this.webServiceType = webServiceType;
    }

    public OperatingSystem getOperatingSystem() {
        return operatingSystem;
    }

    public void setOperatingSystem(OperatingSystem operatingSystem) {
        this.operatingSystem = operatingSystem;
    }

    public RightsInfo getRightsInfo() {
        return rightsInfo;
    }

    public void setRightsInfo(RightsInfo rightsInfo) {
        this.rightsInfo = rightsInfo;
    }

    public List<String> getCopyrightStatements() {
        return copyrightStatements;
    }

    public void setCopyrightStatements(List<String> copyrightStatements) {
        this.copyrightStatements = copyrightStatements;
    }

    public List<String> getAttributionTexts() {
        return attributionTexts;
    }

    public void setAttributionTexts(List<String> attributionTexts) {
        this.attributionTexts = attributionTexts;
    }

    public List<ActorInfo> getRightsHolders() {
        return rightsHolders;
    }

    public void setRightsHolders(List<ActorInfo> rightsHolders) {
        this.rightsHolders = rightsHolders;
    }

    public Date getAvailabilityStartDate() {
        return availabilityStartDate;
    }

    public void setAvailabilityStartDate(Date availabilityStartDate) {
        this.availabilityStartDate = availabilityStartDate;
    }

    public Date getAvailabilityEndDate() {
        return availabilityEndDate;
    }

    public void setAvailabilityEndDate(Date availabilityEndDate) {
        this.availabilityEndDate = availabilityEndDate;
    }

    public String getFee() {
        return fee;
    }

    public void setFee(String fee) {
        this.fee = fee;
    }

    public List<UserType> getUserTypes() {
        return userTypes;
    }

    public void setUserTypes(List<UserType> userTypes) {
        this.userTypes = userTypes;
    }
}
