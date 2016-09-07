package eu.openminted.registry.domain;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.adapters.XmlAdapter;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import java.util.Enumeration;
import java.util.List;

import static eu.openminted.registry.domain.ComponentDistributionInfo.ComponentDistributionMedium.EXECUTABLE_CODE;
import static eu.openminted.registry.domain.ComponentDistributionInfo.ComponentDistributionMedium.SOURCE_CODE;
import static eu.openminted.registry.domain.ComponentDistributionInfo.ComponentDistributionMedium.WEB_SERVICE;

/**
 * Created by stefania on 9/5/16.
 */
public class LicenseInfo {

    @XmlJavaTypeAdapter(LicenceAdapter.class)
    enum License {
        CC_BY("CC-BY"),
        CC_BY_NC("CC-BY-NC"),
        CC_BY_NC_ND("CC-BY-NC-ND"),
        CC_BY_NC_SA("CC-BY-NC-SA"),
        CC_BY_ND("CC-BY-ND"),
        CC_BY_SA("CC-BY-SA"),
        CC_ZERO("CC-ZERO"),
        PDDL("PDDL"),
        ODC_BY("ODC-BY"),
        ODBL("ODbL"),
        MS_NORED("MS-NoReD"),
        MS_NORED_FF("MS-NoReD-FF"),
        MS_NORED_ND("MS-NoReD-ND"),
        MS_NORED_ND_FF("MS-NoReD-ND-FF"),
        MS_NC_NORED("MS-NC-NoReD"),
        MS_NC_NORED_FF("MS-NC-NoReD-FF"),
        MS_NC_NORED_ND("MS-NC-NoReD-ND"),
        MS_NC_NORED_ND_FF("MS-NC-NoReD-ND-FF"),
        ELRA_END_USER("ELRA_END_USER"),
        ELRA_EVALUATION("ELRA_EVALUATION"),
        ELRA_VAR("ELRA_VAR"),
        CLARIN_PUB("CLARIN_PUB"),
        CLARIN_ACA("CLARIN_ACA"),
        CLARIN_ACA_NC("CLARIN_ACA-NC"),
        CLARIN_RES("CLARIN_RES"),
        AGPL("AGPL"),
        APACHE_LICENSE_2_0("ApacheLicence_2.0"),
        BSD_4_CLAUSE("BSD_4-clause"),
        BSD_3_CLAUSE("BSD_3-clause"),
        FREE_BSD("FreeBSD"),
        GFDL("GFDL"),
        GPL("GPL"),
        LGPL("LGPL"),
        MIT("MIT"),
        PRONCETON_WORDNET("Princeton_Wordnet"),
        PROPRIETARY("proprietary"),
        UNDER_NEGOTIATION   ("underNegotiation"),
        NON_STANDARD_LICENSE_TERMS("nonStandardLicenceTerms");

        private String value;

        private License(String value) {
            this.value = value;
        }

        public String getValue() {
            return value;
        }

        public static License forValue(String value) {
            for (License l:License.values()) {
                if (l.getValue().equals(value))
                    return l;
            }

            return null;
        }
    }

    enum Version {

        ONE("1.0.0"),
        TWO("2.0"),
        THREE("3.0"),
        FOUR("4.0");

        private String value;

        Version(String value) {
            this.value = value;
        }

        public String getValue() {
            return value;
        }
    }

    enum ConditionsOfUse {

        ATTRIBUTION("attribution"),
        NON_COMMERCIAL_USE("nonCommercialUse"),
        COMMERCIAL_USE("commercialUse"),
        SHARE_ALIKE("shareAlike"),
        NO_DERIVATIVE("noDerivatives"),
        NO_REDISTRIBUTION("noRedistribution"),
        EVALUATION_USE("evaluationUse"),
        RESEARCH("research"),
        LANGUAGE_ENGINEERING_RESEARCH("languageEngineeringResearch"),
        EDUCATION("education"),
        INFORM_LICENSOR("informLicensor"),
        REDEPOSIT("redeposit"),
        COMPENSATE("compensate"),
        PERSONAL_DATA_INCLUDED("personalDataIncluded"),
        SENSITIVE_DATA_INCLUDED("sensitiveDataIncluded"),
        REQUEST_PLAN("requestPlan"),
        SPATIAL_CONSTRAINT("spatialConstraint"),
        USER_IDENTIFIED("userIdentified"),
        ACADEMIC_USERS("academicUsers"),
        COMMERCIAL_USERS("commercialUsers"),
        MEMBERS_OF_GROUP("membersOfGroup"),
        OTHER("other");

        private String value;

        ConditionsOfUse(String value) {
            this.value = value;
        }

        public String getValue() {
            return value;
        }
    }

    //required
    @XmlElement(name="licence")
    private License license;
    private Version version;
    private List<String> nonStandardLicenceNames;
    private String nonStandardLicenceTermsURL;
    private List<String> nonStandaradLicenceTermsTexts;
    private List<ConditionsOfUse> conditionsOfUseList;

    public LicenseInfo() {
    }

    public LicenseInfo(License license) {
        this.license = license;
    }

    public LicenseInfo(License license, Version version, List<String> nonStandardLicenceNames, String nonStandardLicenceTermsURL,
                       List<String> nonStandaradLicenceTermsTexts, List<ConditionsOfUse> conditionsOfUseList) {
        this.license = license;
        this.version = version;
        this.nonStandardLicenceNames = nonStandardLicenceNames;
        this.nonStandardLicenceTermsURL = nonStandardLicenceTermsURL;
        this.nonStandaradLicenceTermsTexts = nonStandaradLicenceTermsTexts;
        this.conditionsOfUseList = conditionsOfUseList;
    }

    public License getLicense() {
        return license;
    }

    public void setLicense(License license) {
        this.license = license;
    }

    public Version getVersion() {
        return version;
    }

    public void setVersion(Version version) {
        this.version = version;
    }

    public List<String> getNonStandardLicenceNames() {
        return nonStandardLicenceNames;
    }

    public void setNonStandardLicenceNames(List<String> nonStandardLicenceNames) {
        this.nonStandardLicenceNames = nonStandardLicenceNames;
    }

    public String getNonStandardLicenceTermsURL() {
        return nonStandardLicenceTermsURL;
    }

    public void setNonStandardLicenceTermsURL(String nonStandardLicenceTermsURL) {
        this.nonStandardLicenceTermsURL = nonStandardLicenceTermsURL;
    }

    public List<String> getNonStandaradLicenceTermsTexts() {
        return nonStandaradLicenceTermsTexts;
    }

    public void setNonStandaradLicenceTermsTexts(List<String> nonStandaradLicenceTermsTexts) {
        this.nonStandaradLicenceTermsTexts = nonStandaradLicenceTermsTexts;
    }

    public List<ConditionsOfUse> getConditionsOfUseList() {
        return conditionsOfUseList;
    }

    public void setConditionsOfUseList(List<ConditionsOfUse> conditionsOfUseList) {
        this.conditionsOfUseList = conditionsOfUseList;
    }
}

class LicenceAdapter extends XmlAdapter<String, LicenseInfo.License> {

    @Override
    public String marshal(LicenseInfo.License v) throws Exception {
        return v.getValue();
    }

    @Override
    public LicenseInfo.License unmarshal(String v) throws Exception {
        return LicenseInfo.License.forValue(v);
    }
}