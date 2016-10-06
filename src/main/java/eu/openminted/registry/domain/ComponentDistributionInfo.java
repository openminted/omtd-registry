package eu.openminted.registry.domain;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.XmlAdapter;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import javax.xml.datatype.XMLGregorianCalendar;

import java.util.List;

import static eu.openminted.registry.domain.ComponentDistributionInfo.ComponentDistributionMedium.EXECUTABLE_CODE;
import static eu.openminted.registry.domain.ComponentDistributionInfo.ComponentDistributionMedium.SOURCE_CODE;
import static eu.openminted.registry.domain.ComponentDistributionInfo.ComponentDistributionMedium.WEB_SERVICE;

/**
 * Created by stefania on 9/5/16.
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "componentDistributionInfoType", propOrder = {
	    "componentDistributionMedium",
	    "downloadURLs",
	    "accessURLs",
	    "mavenId",
	    "webServiceType",
	    "operatingSystem",
	    "rightsInfo",
	    "copyrightStatements",
	    "attributionTexts",
	    "rightsHolders",
	    "availabilityStartDate",
	    "availabilityEndDate",
	    "fee",
	    "userTypes"
	})
public class ComponentDistributionInfo {

    @XmlJavaTypeAdapter(ComponentDistributionMediumAdapter.class)
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

    @XmlJavaTypeAdapter(WebServiceTypeAdapter.class)
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
        
        public static WebServiceType forValue(String value) {
            for (WebServiceType os: WebServiceType.values()) {
                if (os.getValue().equals(value))
                    return os;
            }

            return null;
        }
    }
    @XmlJavaTypeAdapter(OperatingSystemAdapter.class)
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

        public static OperatingSystem forValue(String value) {
            for (OperatingSystem os: OperatingSystem.values()) {
                if (os.getValue().equals(value))
                    return os;
            }

            return null;
        }
    }

    //required
    @XmlElement(name="componentDistributionMedium")
    private ComponentDistributionMedium componentDistributionMedium;

    @XmlElementWrapper(name="downloadURLs")
    @XmlElement(name="downloadURL")
    private List<String> downloadURLs;
    @XmlElementWrapper(name="accessURLs")
    @XmlElement(name="accessURL")
    private List<String> accessURLs;
    private String mavenId;
    private WebServiceType webServiceType;
    
    private List<OperatingSystem> operatingSystem;
    //required
    @XmlElement(name="rightsInfo")
    private RightsInfo rightsInfo;
    
    @XmlElementWrapper(name="copyrightStatements")
    @XmlElement(name="copyrightStatement")
    private List<LangAttributeField> copyrightStatements;
    
    @XmlElementWrapper(name="attributionTexts")
    @XmlElement(name="attributionText")
    private List<LangAttributeField> attributionTexts;
    @XmlElementWrapper(name="rightsHolders")
    @XmlElement(name="rightsHolder")
    private List<ActorInfo> rightsHolders;
    @XmlElementWrapper(name="userTypes")
    @XmlElement(name="userType")
    private List<UserType> userTypes;
    private XMLGregorianCalendar availabilityStartDate;
    private XMLGregorianCalendar availabilityEndDate;
    private String fee;

    public ComponentDistributionInfo() {
    }

    public ComponentDistributionInfo(ComponentDistributionMedium componentDistributionMedium, RightsInfo rightsInfo) {
        this.componentDistributionMedium = componentDistributionMedium;
        this.rightsInfo = rightsInfo;
    }

    public ComponentDistributionInfo(ComponentDistributionMedium componentDistributionMedium, List<String> downloadURLs,
                                     List<String> accessURLs, String mavenId, WebServiceType webServiceType,
                                     List<OperatingSystem> operatingSystem, RightsInfo rightsInfo, List<LangAttributeField> copyrightStatements,
                                     List<LangAttributeField> attributionTexts, List<ActorInfo> rightsHolders, XMLGregorianCalendar availabilityStartDate,
                                     XMLGregorianCalendar availabilityEndDate, String fee, List<UserType> userTypes) {
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

    public List<OperatingSystem> getOperatingSystem() {
        return operatingSystem;
    }

    public void setOperatingSystem(List<OperatingSystem> operatingSystem) {
        this.operatingSystem = operatingSystem;
    }

    public RightsInfo getRightsInfo() {
        return rightsInfo;
    }

    public void setRightsInfo(RightsInfo rightsInfo) {
        this.rightsInfo = rightsInfo;
    }

    public List<LangAttributeField> getCopyrightStatements() {
        return copyrightStatements;
    }

    public void setCopyrightStatements(List<LangAttributeField> copyrightStatements) {
        this.copyrightStatements = copyrightStatements;
    }

    public List<LangAttributeField> getAttributionTexts() {
        return attributionTexts;
    }

    public void setAttributionTexts(List<LangAttributeField> attributionTexts) {
        this.attributionTexts = attributionTexts;
    }

    public List<ActorInfo> getRightsHolders() {
        return rightsHolders;
    }

    public void setRightsHolders(List<ActorInfo> rightsHolders) {
        this.rightsHolders = rightsHolders;
    }

    public XMLGregorianCalendar getAvailabilityStartDate() {
        return availabilityStartDate;
    }

    public void setAvailabilityStartDate(XMLGregorianCalendar availabilityStartDate) {
        this.availabilityStartDate = availabilityStartDate;
    }

    public XMLGregorianCalendar getAvailabilityEndDate() {
        return availabilityEndDate;
    }

    public void setAvailabilityEndDate(XMLGregorianCalendar availabilityEndDate) {
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

class ComponentDistributionMediumAdapter extends XmlAdapter<String, ComponentDistributionInfo.ComponentDistributionMedium> {

    @Override
    public String marshal(ComponentDistributionInfo.ComponentDistributionMedium v) throws Exception {
        return v.getValue();
    }

    @Override
    public ComponentDistributionInfo.ComponentDistributionMedium unmarshal(String v) throws Exception {
        if ("webService".equals(v)) {
            return WEB_SERVICE;
        } else if ("sourceCode".equals(v)) {
            return SOURCE_CODE;
        } else if ("executableCode".equals(v)) {
            return EXECUTABLE_CODE;
        }

        return null;
    }
}

class OperatingSystemAdapter extends XmlAdapter<String, ComponentDistributionInfo.OperatingSystem> {

    @Override
    public String marshal(ComponentDistributionInfo.OperatingSystem v) throws Exception {
        return v!=null?v.getValue():null;
    }

    @Override
    public ComponentDistributionInfo.OperatingSystem unmarshal(String v) throws Exception {
        return ComponentDistributionInfo.OperatingSystem.forValue(v);
    }
}

class WebServiceTypeAdapter extends XmlAdapter<String, ComponentDistributionInfo.WebServiceType> {

    @Override
    public String marshal(ComponentDistributionInfo.WebServiceType v) throws Exception {
        return v!=null?v.getValue():null;
    }

    @Override
    public ComponentDistributionInfo.WebServiceType unmarshal(String v) throws Exception {
        return ComponentDistributionInfo.WebServiceType.forValue(v);
    }
}