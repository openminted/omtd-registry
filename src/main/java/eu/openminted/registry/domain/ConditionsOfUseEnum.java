
package eu.openminted.registry.domain;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for null.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType&gt;
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *     &lt;maxLength value="100"/&gt;
 *     &lt;enumeration value="attribution"/&gt;
 *     &lt;enumeration value="nonCommercialUse"/&gt;
 *     &lt;enumeration value="commercialUse"/&gt;
 *     &lt;enumeration value="shareAlike"/&gt;
 *     &lt;enumeration value="noDerivatives"/&gt;
 *     &lt;enumeration value="noRedistribution"/&gt;
 *     &lt;enumeration value="evaluationUse"/&gt;
 *     &lt;enumeration value="research"/&gt;
 *     &lt;enumeration value="languageEngineeringResearch"/&gt;
 *     &lt;enumeration value="education"/&gt;
 *     &lt;enumeration value="informLicensor"/&gt;
 *     &lt;enumeration value="redeposit"/&gt;
 *     &lt;enumeration value="compensate"/&gt;
 *     &lt;enumeration value="personalDataIncluded"/&gt;
 *     &lt;enumeration value="sensitiveDataIncluded"/&gt;
 *     &lt;enumeration value="requestPlan"/&gt;
 *     &lt;enumeration value="spatialConstraint"/&gt;
 *     &lt;enumeration value="userIdentified"/&gt;
 *     &lt;enumeration value="academicUsers"/&gt;
 *     &lt;enumeration value="commercialUsers"/&gt;
 *     &lt;enumeration value="membersOfGroup"/&gt;
 *     &lt;enumeration value="other"/&gt;
 *   &lt;/restriction&gt;
 * &lt;/simpleType&gt;
 * </pre>
 * 
 */
@XmlType(name = "")
@XmlEnum
public enum ConditionsOfUseEnum {

    @XmlEnumValue("attribution")
    ATTRIBUTION("attribution"),
    @XmlEnumValue("nonCommercialUse")
    NON_COMMERCIAL_USE("nonCommercialUse"),
    @XmlEnumValue("commercialUse")
    COMMERCIAL_USE("commercialUse"),
    @XmlEnumValue("shareAlike")
    SHARE_ALIKE("shareAlike"),
    @XmlEnumValue("noDerivatives")
    NO_DERIVATIVES("noDerivatives"),
    @XmlEnumValue("noRedistribution")
    NO_REDISTRIBUTION("noRedistribution"),
    @XmlEnumValue("evaluationUse")
    EVALUATION_USE("evaluationUse"),
    @XmlEnumValue("research")
    RESEARCH("research"),
    @XmlEnumValue("languageEngineeringResearch")
    LANGUAGE_ENGINEERING_RESEARCH("languageEngineeringResearch"),
    @XmlEnumValue("education")
    EDUCATION("education"),
    @XmlEnumValue("informLicensor")
    INFORM_LICENSOR("informLicensor"),
    @XmlEnumValue("redeposit")
    REDEPOSIT("redeposit"),
    @XmlEnumValue("compensate")
    COMPENSATE("compensate"),
    @XmlEnumValue("personalDataIncluded")
    PERSONAL_DATA_INCLUDED("personalDataIncluded"),
    @XmlEnumValue("sensitiveDataIncluded")
    SENSITIVE_DATA_INCLUDED("sensitiveDataIncluded"),
    @XmlEnumValue("requestPlan")
    REQUEST_PLAN("requestPlan"),
    @XmlEnumValue("spatialConstraint")
    SPATIAL_CONSTRAINT("spatialConstraint"),
    @XmlEnumValue("userIdentified")
    USER_IDENTIFIED("userIdentified"),
    @XmlEnumValue("academicUsers")
    ACADEMIC_USERS("academicUsers"),
    @XmlEnumValue("commercialUsers")
    COMMERCIAL_USERS("commercialUsers"),
    @XmlEnumValue("membersOfGroup")
    MEMBERS_OF_GROUP("membersOfGroup"),
    @XmlEnumValue("other")
    OTHER("other");
    private final String value;

    ConditionsOfUseEnum(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static ConditionsOfUseEnum fromValue(String v) {
        for (ConditionsOfUseEnum c: ConditionsOfUseEnum.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
