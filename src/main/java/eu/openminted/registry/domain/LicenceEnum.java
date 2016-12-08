
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
 *     &lt;enumeration value="CC-BY"/&gt;
 *     &lt;enumeration value="CC-BY-NC"/&gt;
 *     &lt;enumeration value="CC-BY-NC-ND"/&gt;
 *     &lt;enumeration value="CC-BY-NC-SA"/&gt;
 *     &lt;enumeration value="CC-BY-ND"/&gt;
 *     &lt;enumeration value="CC-BY-SA"/&gt;
 *     &lt;enumeration value="CC-ZERO"/&gt;
 *     &lt;enumeration value="PDDL"/&gt;
 *     &lt;enumeration value="ODC-BY"/&gt;
 *     &lt;enumeration value="ODbL"/&gt;
 *     &lt;enumeration value="MS-NoReD"/&gt;
 *     &lt;enumeration value="MS-NoReD-FF"/&gt;
 *     &lt;enumeration value="MS-NoReD-ND"/&gt;
 *     &lt;enumeration value="MS-NoReD-ND-FF"/&gt;
 *     &lt;enumeration value="MS-NC-NoReD"/&gt;
 *     &lt;enumeration value="MS-NC-NoReD-FF"/&gt;
 *     &lt;enumeration value="MS-NC-NoReD-ND"/&gt;
 *     &lt;enumeration value="MS-NC-NoReD-ND-FF"/&gt;
 *     &lt;enumeration value="ELRA_END_USER"/&gt;
 *     &lt;enumeration value="ELRA_EVALUATION"/&gt;
 *     &lt;enumeration value="ELRA_VAR"/&gt;
 *     &lt;enumeration value="CLARIN_PUB"/&gt;
 *     &lt;enumeration value="CLARIN_ACA"/&gt;
 *     &lt;enumeration value="CLARIN_ACA-NC"/&gt;
 *     &lt;enumeration value="CLARIN_RES"/&gt;
 *     &lt;enumeration value="AGPL"/&gt;
 *     &lt;enumeration value="ApacheLicence_2.0"/&gt;
 *     &lt;enumeration value="BSD_4-clause"/&gt;
 *     &lt;enumeration value="BSD_3-clause"/&gt;
 *     &lt;enumeration value="FreeBSD"/&gt;
 *     &lt;enumeration value="GFDL"/&gt;
 *     &lt;enumeration value="GPL"/&gt;
 *     &lt;enumeration value="LGPL"/&gt;
 *     &lt;enumeration value="MIT"/&gt;
 *     &lt;enumeration value="Princeton_Wordnet"/&gt;
 *     &lt;enumeration value="EPL"/&gt;
 *     &lt;enumeration value="proprietary"/&gt;
 *     &lt;enumeration value="underNegotiation"/&gt;
 *     &lt;enumeration value="nonStandardLicenceTerms"/&gt;
 *   &lt;/restriction&gt;
 * &lt;/simpleType&gt;
 * </pre>
 * 
 */
@XmlType(name = "")
@XmlEnum
public enum LicenceEnum {

    @XmlEnumValue("CC-BY")
    CC_BY("CC-BY"),
    @XmlEnumValue("CC-BY-NC")
    CC_BY_NC("CC-BY-NC"),
    @XmlEnumValue("CC-BY-NC-ND")
    CC_BY_NC_ND("CC-BY-NC-ND"),
    @XmlEnumValue("CC-BY-NC-SA")
    CC_BY_NC_SA("CC-BY-NC-SA"),
    @XmlEnumValue("CC-BY-ND")
    CC_BY_ND("CC-BY-ND"),
    @XmlEnumValue("CC-BY-SA")
    CC_BY_SA("CC-BY-SA"),
    @XmlEnumValue("CC-ZERO")
    CC_ZERO("CC-ZERO"),
    PDDL("PDDL"),
    @XmlEnumValue("ODC-BY")
    ODC_BY("ODC-BY"),
    @XmlEnumValue("ODbL")
    O_DB_L("ODbL"),
    @XmlEnumValue("MS-NoReD")
    MS_NO_RE_D("MS-NoReD"),
    @XmlEnumValue("MS-NoReD-FF")
    MS_NO_RE_D_FF("MS-NoReD-FF"),
    @XmlEnumValue("MS-NoReD-ND")
    MS_NO_RE_D_ND("MS-NoReD-ND"),
    @XmlEnumValue("MS-NoReD-ND-FF")
    MS_NO_RE_D_ND_FF("MS-NoReD-ND-FF"),
    @XmlEnumValue("MS-NC-NoReD")
    MS_NC_NO_RE_D("MS-NC-NoReD"),
    @XmlEnumValue("MS-NC-NoReD-FF")
    MS_NC_NO_RE_D_FF("MS-NC-NoReD-FF"),
    @XmlEnumValue("MS-NC-NoReD-ND")
    MS_NC_NO_RE_D_ND("MS-NC-NoReD-ND"),
    @XmlEnumValue("MS-NC-NoReD-ND-FF")
    MS_NC_NO_RE_D_ND_FF("MS-NC-NoReD-ND-FF"),
    ELRA_END_USER("ELRA_END_USER"),
    ELRA_EVALUATION("ELRA_EVALUATION"),
    ELRA_VAR("ELRA_VAR"),
    CLARIN_PUB("CLARIN_PUB"),
    CLARIN_ACA("CLARIN_ACA"),
    @XmlEnumValue("CLARIN_ACA-NC")
    CLARIN_ACA_NC("CLARIN_ACA-NC"),
    CLARIN_RES("CLARIN_RES"),
    AGPL("AGPL"),
    @XmlEnumValue("ApacheLicence_2.0")
    APACHELICENCE_2_0("ApacheLicence_2.0"),
    @XmlEnumValue("BSD_4-clause")
    BSD_4_CLAUSE("BSD_4-clause"),
    @XmlEnumValue("BSD_3-clause")
    BSD_3_CLAUSE("BSD_3-clause"),
    @XmlEnumValue("FreeBSD")
    FREE_BSD("FreeBSD"),
    GFDL("GFDL"),
    GPL("GPL"),
    LGPL("LGPL"),
    MIT("MIT"),
    @XmlEnumValue("Princeton_Wordnet")
    PRINCETON_WORDNET("Princeton_Wordnet"),
    EPL("EPL"),
    @XmlEnumValue("proprietary")
    PROPRIETARY("proprietary"),
    @XmlEnumValue("underNegotiation")
    UNDER_NEGOTIATION("underNegotiation"),
    @XmlEnumValue("nonStandardLicenceTerms")
    NON_STANDARD_LICENCE_TERMS("nonStandardLicenceTerms");
    private final String value;

    LicenceEnum(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static LicenceEnum fromValue(String v) {
        for (LicenceEnum c: LicenceEnum.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
