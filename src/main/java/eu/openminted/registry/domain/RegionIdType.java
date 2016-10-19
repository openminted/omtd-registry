
package eu.openminted.registry.domain;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for regionIdType.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="regionIdType"&gt;
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *     &lt;enumeration value="AA"/&gt;
 *     &lt;enumeration value="AC"/&gt;
 *     &lt;enumeration value="AD"/&gt;
 *     &lt;enumeration value="AE"/&gt;
 *     &lt;enumeration value="AF"/&gt;
 *     &lt;enumeration value="AG"/&gt;
 *     &lt;enumeration value="AI"/&gt;
 *     &lt;enumeration value="AL"/&gt;
 *     &lt;enumeration value="AM"/&gt;
 *     &lt;enumeration value="AO"/&gt;
 *     &lt;enumeration value="AQ"/&gt;
 *     &lt;enumeration value="AR"/&gt;
 *     &lt;enumeration value="AS"/&gt;
 *     &lt;enumeration value="AT"/&gt;
 *     &lt;enumeration value="AU"/&gt;
 *     &lt;enumeration value="AW"/&gt;
 *     &lt;enumeration value="AX"/&gt;
 *     &lt;enumeration value="AZ"/&gt;
 *     &lt;enumeration value="BA"/&gt;
 *     &lt;enumeration value="BB"/&gt;
 *     &lt;enumeration value="BD"/&gt;
 *     &lt;enumeration value="BE"/&gt;
 *     &lt;enumeration value="BF"/&gt;
 *     &lt;enumeration value="BG"/&gt;
 *     &lt;enumeration value="BH"/&gt;
 *     &lt;enumeration value="BI"/&gt;
 *     &lt;enumeration value="BJ"/&gt;
 *     &lt;enumeration value="BL"/&gt;
 *     &lt;enumeration value="BM"/&gt;
 *     &lt;enumeration value="BN"/&gt;
 *     &lt;enumeration value="BO"/&gt;
 *     &lt;enumeration value="BQ"/&gt;
 *     &lt;enumeration value="BR"/&gt;
 *     &lt;enumeration value="BS"/&gt;
 *     &lt;enumeration value="BT"/&gt;
 *     &lt;enumeration value="BV"/&gt;
 *     &lt;enumeration value="BW"/&gt;
 *     &lt;enumeration value="BY"/&gt;
 *     &lt;enumeration value="BZ"/&gt;
 *     &lt;enumeration value="CA"/&gt;
 *     &lt;enumeration value="CC"/&gt;
 *     &lt;enumeration value="CD"/&gt;
 *     &lt;enumeration value="CF"/&gt;
 *     &lt;enumeration value="CG"/&gt;
 *     &lt;enumeration value="CH"/&gt;
 *     &lt;enumeration value="CI"/&gt;
 *     &lt;enumeration value="CK"/&gt;
 *     &lt;enumeration value="CL"/&gt;
 *     &lt;enumeration value="CM"/&gt;
 *     &lt;enumeration value="CN"/&gt;
 *     &lt;enumeration value="CO"/&gt;
 *     &lt;enumeration value="CP"/&gt;
 *     &lt;enumeration value="CR"/&gt;
 *     &lt;enumeration value="CU"/&gt;
 *     &lt;enumeration value="CV"/&gt;
 *     &lt;enumeration value="CW"/&gt;
 *     &lt;enumeration value="CX"/&gt;
 *     &lt;enumeration value="CY"/&gt;
 *     &lt;enumeration value="CZ"/&gt;
 *     &lt;enumeration value="DE"/&gt;
 *     &lt;enumeration value="DG"/&gt;
 *     &lt;enumeration value="DJ"/&gt;
 *     &lt;enumeration value="DK"/&gt;
 *     &lt;enumeration value="DM"/&gt;
 *     &lt;enumeration value="DO"/&gt;
 *     &lt;enumeration value="DZ"/&gt;
 *     &lt;enumeration value="EA"/&gt;
 *     &lt;enumeration value="EC"/&gt;
 *     &lt;enumeration value="EE"/&gt;
 *     &lt;enumeration value="EG"/&gt;
 *     &lt;enumeration value="EH"/&gt;
 *     &lt;enumeration value="ER"/&gt;
 *     &lt;enumeration value="ES"/&gt;
 *     &lt;enumeration value="ET"/&gt;
 *     &lt;enumeration value="EU"/&gt;
 *     &lt;enumeration value="FI"/&gt;
 *     &lt;enumeration value="FJ"/&gt;
 *     &lt;enumeration value="FK"/&gt;
 *     &lt;enumeration value="FM"/&gt;
 *     &lt;enumeration value="FO"/&gt;
 *     &lt;enumeration value="FR"/&gt;
 *     &lt;enumeration value="GA"/&gt;
 *     &lt;enumeration value="GB"/&gt;
 *     &lt;enumeration value="GD"/&gt;
 *     &lt;enumeration value="GE"/&gt;
 *     &lt;enumeration value="GF"/&gt;
 *     &lt;enumeration value="GG"/&gt;
 *     &lt;enumeration value="GH"/&gt;
 *     &lt;enumeration value="GI"/&gt;
 *     &lt;enumeration value="GL"/&gt;
 *     &lt;enumeration value="GM"/&gt;
 *     &lt;enumeration value="GN"/&gt;
 *     &lt;enumeration value="GP"/&gt;
 *     &lt;enumeration value="GQ"/&gt;
 *     &lt;enumeration value="GR"/&gt;
 *     &lt;enumeration value="GS"/&gt;
 *     &lt;enumeration value="GT"/&gt;
 *     &lt;enumeration value="GU"/&gt;
 *     &lt;enumeration value="GW"/&gt;
 *     &lt;enumeration value="GY"/&gt;
 *     &lt;enumeration value="HK"/&gt;
 *     &lt;enumeration value="HM"/&gt;
 *     &lt;enumeration value="HN"/&gt;
 *     &lt;enumeration value="HR"/&gt;
 *     &lt;enumeration value="HT"/&gt;
 *     &lt;enumeration value="HU"/&gt;
 *     &lt;enumeration value="IC"/&gt;
 *     &lt;enumeration value="ID"/&gt;
 *     &lt;enumeration value="IE"/&gt;
 *     &lt;enumeration value="IL"/&gt;
 *     &lt;enumeration value="IM"/&gt;
 *     &lt;enumeration value="IN"/&gt;
 *     &lt;enumeration value="IO"/&gt;
 *     &lt;enumeration value="IQ"/&gt;
 *     &lt;enumeration value="IR"/&gt;
 *     &lt;enumeration value="IS"/&gt;
 *     &lt;enumeration value="IT"/&gt;
 *     &lt;enumeration value="JE"/&gt;
 *     &lt;enumeration value="JM"/&gt;
 *     &lt;enumeration value="JO"/&gt;
 *     &lt;enumeration value="JP"/&gt;
 *     &lt;enumeration value="KE"/&gt;
 *     &lt;enumeration value="KG"/&gt;
 *     &lt;enumeration value="KH"/&gt;
 *     &lt;enumeration value="KI"/&gt;
 *     &lt;enumeration value="KM"/&gt;
 *     &lt;enumeration value="KN"/&gt;
 *     &lt;enumeration value="KP"/&gt;
 *     &lt;enumeration value="KR"/&gt;
 *     &lt;enumeration value="KW"/&gt;
 *     &lt;enumeration value="KY"/&gt;
 *     &lt;enumeration value="KZ"/&gt;
 *     &lt;enumeration value="LA"/&gt;
 *     &lt;enumeration value="LB"/&gt;
 *     &lt;enumeration value="LC"/&gt;
 *     &lt;enumeration value="LI"/&gt;
 *     &lt;enumeration value="LK"/&gt;
 *     &lt;enumeration value="LR"/&gt;
 *     &lt;enumeration value="LS"/&gt;
 *     &lt;enumeration value="LT"/&gt;
 *     &lt;enumeration value="LU"/&gt;
 *     &lt;enumeration value="LV"/&gt;
 *     &lt;enumeration value="LY"/&gt;
 *     &lt;enumeration value="MA"/&gt;
 *     &lt;enumeration value="MC"/&gt;
 *     &lt;enumeration value="MD"/&gt;
 *     &lt;enumeration value="ME"/&gt;
 *     &lt;enumeration value="MF"/&gt;
 *     &lt;enumeration value="MG"/&gt;
 *     &lt;enumeration value="MH"/&gt;
 *     &lt;enumeration value="MK"/&gt;
 *     &lt;enumeration value="ML"/&gt;
 *     &lt;enumeration value="MM"/&gt;
 *     &lt;enumeration value="MN"/&gt;
 *     &lt;enumeration value="MO"/&gt;
 *     &lt;enumeration value="MP"/&gt;
 *     &lt;enumeration value="MQ"/&gt;
 *     &lt;enumeration value="MR"/&gt;
 *     &lt;enumeration value="MS"/&gt;
 *     &lt;enumeration value="MT"/&gt;
 *     &lt;enumeration value="MU"/&gt;
 *     &lt;enumeration value="MV"/&gt;
 *     &lt;enumeration value="MW"/&gt;
 *     &lt;enumeration value="MX"/&gt;
 *     &lt;enumeration value="MY"/&gt;
 *     &lt;enumeration value="MZ"/&gt;
 *     &lt;enumeration value="NA"/&gt;
 *     &lt;enumeration value="NC"/&gt;
 *     &lt;enumeration value="NE"/&gt;
 *     &lt;enumeration value="NF"/&gt;
 *     &lt;enumeration value="NG"/&gt;
 *     &lt;enumeration value="NI"/&gt;
 *     &lt;enumeration value="NL"/&gt;
 *     &lt;enumeration value="NO"/&gt;
 *     &lt;enumeration value="NP"/&gt;
 *     &lt;enumeration value="NR"/&gt;
 *     &lt;enumeration value="NU"/&gt;
 *     &lt;enumeration value="NZ"/&gt;
 *     &lt;enumeration value="OM"/&gt;
 *     &lt;enumeration value="PA"/&gt;
 *     &lt;enumeration value="PE"/&gt;
 *     &lt;enumeration value="PF"/&gt;
 *     &lt;enumeration value="PG"/&gt;
 *     &lt;enumeration value="PH"/&gt;
 *     &lt;enumeration value="PK"/&gt;
 *     &lt;enumeration value="PL"/&gt;
 *     &lt;enumeration value="PM"/&gt;
 *     &lt;enumeration value="PN"/&gt;
 *     &lt;enumeration value="PR"/&gt;
 *     &lt;enumeration value="PS"/&gt;
 *     &lt;enumeration value="PT"/&gt;
 *     &lt;enumeration value="PW"/&gt;
 *     &lt;enumeration value="PY"/&gt;
 *     &lt;enumeration value="QA"/&gt;
 *     &lt;enumeration value="QM..QZ"/&gt;
 *     &lt;enumeration value="RE"/&gt;
 *     &lt;enumeration value="RO"/&gt;
 *     &lt;enumeration value="RS"/&gt;
 *     &lt;enumeration value="RU"/&gt;
 *     &lt;enumeration value="RW"/&gt;
 *     &lt;enumeration value="SA"/&gt;
 *     &lt;enumeration value="SB"/&gt;
 *     &lt;enumeration value="SC"/&gt;
 *     &lt;enumeration value="SD"/&gt;
 *     &lt;enumeration value="SE"/&gt;
 *     &lt;enumeration value="SG"/&gt;
 *     &lt;enumeration value="SH"/&gt;
 *     &lt;enumeration value="SI"/&gt;
 *     &lt;enumeration value="SJ"/&gt;
 *     &lt;enumeration value="SK"/&gt;
 *     &lt;enumeration value="SL"/&gt;
 *     &lt;enumeration value="SM"/&gt;
 *     &lt;enumeration value="SN"/&gt;
 *     &lt;enumeration value="SO"/&gt;
 *     &lt;enumeration value="SR"/&gt;
 *     &lt;enumeration value="SS"/&gt;
 *     &lt;enumeration value="ST"/&gt;
 *     &lt;enumeration value="SV"/&gt;
 *     &lt;enumeration value="SX"/&gt;
 *     &lt;enumeration value="SY"/&gt;
 *     &lt;enumeration value="SZ"/&gt;
 *     &lt;enumeration value="TA"/&gt;
 *     &lt;enumeration value="TC"/&gt;
 *     &lt;enumeration value="TD"/&gt;
 *     &lt;enumeration value="TF"/&gt;
 *     &lt;enumeration value="TG"/&gt;
 *     &lt;enumeration value="TH"/&gt;
 *     &lt;enumeration value="TJ"/&gt;
 *     &lt;enumeration value="TK"/&gt;
 *     &lt;enumeration value="TL"/&gt;
 *     &lt;enumeration value="TM"/&gt;
 *     &lt;enumeration value="TN"/&gt;
 *     &lt;enumeration value="TO"/&gt;
 *     &lt;enumeration value="TR"/&gt;
 *     &lt;enumeration value="TT"/&gt;
 *     &lt;enumeration value="TV"/&gt;
 *     &lt;enumeration value="TW"/&gt;
 *     &lt;enumeration value="TZ"/&gt;
 *     &lt;enumeration value="UA"/&gt;
 *     &lt;enumeration value="UG"/&gt;
 *     &lt;enumeration value="UM"/&gt;
 *     &lt;enumeration value="US"/&gt;
 *     &lt;enumeration value="UY"/&gt;
 *     &lt;enumeration value="UZ"/&gt;
 *     &lt;enumeration value="VA"/&gt;
 *     &lt;enumeration value="VC"/&gt;
 *     &lt;enumeration value="VE"/&gt;
 *     &lt;enumeration value="VG"/&gt;
 *     &lt;enumeration value="VI"/&gt;
 *     &lt;enumeration value="VN"/&gt;
 *     &lt;enumeration value="VU"/&gt;
 *     &lt;enumeration value="WF"/&gt;
 *     &lt;enumeration value="WS"/&gt;
 *     &lt;enumeration value="XA..XZ"/&gt;
 *     &lt;enumeration value="YE"/&gt;
 *     &lt;enumeration value="YT"/&gt;
 *     &lt;enumeration value="ZA"/&gt;
 *     &lt;enumeration value="ZM"/&gt;
 *     &lt;enumeration value="ZW"/&gt;
 *     &lt;enumeration value="ZZ"/&gt;
 *     &lt;enumeration value="001"/&gt;
 *     &lt;enumeration value="002"/&gt;
 *     &lt;enumeration value="003"/&gt;
 *     &lt;enumeration value="005"/&gt;
 *     &lt;enumeration value="009"/&gt;
 *     &lt;enumeration value="011"/&gt;
 *     &lt;enumeration value="013"/&gt;
 *     &lt;enumeration value="014"/&gt;
 *     &lt;enumeration value="015"/&gt;
 *     &lt;enumeration value="017"/&gt;
 *     &lt;enumeration value="018"/&gt;
 *     &lt;enumeration value="019"/&gt;
 *     &lt;enumeration value="021"/&gt;
 *     &lt;enumeration value="029"/&gt;
 *     &lt;enumeration value="030"/&gt;
 *     &lt;enumeration value="034"/&gt;
 *     &lt;enumeration value="035"/&gt;
 *     &lt;enumeration value="039"/&gt;
 *     &lt;enumeration value="053"/&gt;
 *     &lt;enumeration value="054"/&gt;
 *     &lt;enumeration value="057"/&gt;
 *     &lt;enumeration value="061"/&gt;
 *     &lt;enumeration value="142"/&gt;
 *     &lt;enumeration value="143"/&gt;
 *     &lt;enumeration value="145"/&gt;
 *     &lt;enumeration value="150"/&gt;
 *     &lt;enumeration value="151"/&gt;
 *     &lt;enumeration value="154"/&gt;
 *     &lt;enumeration value="155"/&gt;
 *     &lt;enumeration value="419"/&gt;
 *   &lt;/restriction&gt;
 * &lt;/simpleType&gt;
 * </pre>
 * 
 */
@XmlType(name = "regionIdType")
@XmlEnum
public enum RegionIdType {

    AA("AA"),
    AC("AC"),
    AD("AD"),
    AE("AE"),
    AF("AF"),
    AG("AG"),
    AI("AI"),
    AL("AL"),
    AM("AM"),
    AO("AO"),
    AQ("AQ"),
    AR("AR"),
    AS("AS"),
    AT("AT"),
    AU("AU"),
    AW("AW"),
    AX("AX"),
    AZ("AZ"),
    BA("BA"),
    BB("BB"),
    BD("BD"),
    BE("BE"),
    BF("BF"),
    BG("BG"),
    BH("BH"),
    BI("BI"),
    BJ("BJ"),
    BL("BL"),
    BM("BM"),
    BN("BN"),
    BO("BO"),
    BQ("BQ"),
    BR("BR"),
    BS("BS"),
    BT("BT"),
    BV("BV"),
    BW("BW"),
    BY("BY"),
    BZ("BZ"),
    CA("CA"),
    CC("CC"),
    CD("CD"),
    CF("CF"),
    CG("CG"),
    CH("CH"),
    CI("CI"),
    CK("CK"),
    CL("CL"),
    CM("CM"),
    CN("CN"),
    CO("CO"),
    CP("CP"),
    CR("CR"),
    CU("CU"),
    CV("CV"),
    CW("CW"),
    CX("CX"),
    CY("CY"),
    CZ("CZ"),
    DE("DE"),
    DG("DG"),
    DJ("DJ"),
    DK("DK"),
    DM("DM"),
    DO("DO"),
    DZ("DZ"),
    EA("EA"),
    EC("EC"),
    EE("EE"),
    EG("EG"),
    EH("EH"),
    ER("ER"),
    ES("ES"),
    ET("ET"),
    EU("EU"),
    FI("FI"),
    FJ("FJ"),
    FK("FK"),
    FM("FM"),
    FO("FO"),
    FR("FR"),
    GA("GA"),
    GB("GB"),
    GD("GD"),
    GE("GE"),
    GF("GF"),
    GG("GG"),
    GH("GH"),
    GI("GI"),
    GL("GL"),
    GM("GM"),
    GN("GN"),
    GP("GP"),
    GQ("GQ"),
    GR("GR"),
    GS("GS"),
    GT("GT"),
    GU("GU"),
    GW("GW"),
    GY("GY"),
    HK("HK"),
    HM("HM"),
    HN("HN"),
    HR("HR"),
    HT("HT"),
    HU("HU"),
    IC("IC"),
    ID("ID"),
    IE("IE"),
    IL("IL"),
    IM("IM"),
    IN("IN"),
    IO("IO"),
    IQ("IQ"),
    IR("IR"),
    IS("IS"),
    IT("IT"),
    JE("JE"),
    JM("JM"),
    JO("JO"),
    JP("JP"),
    KE("KE"),
    KG("KG"),
    KH("KH"),
    KI("KI"),
    KM("KM"),
    KN("KN"),
    KP("KP"),
    KR("KR"),
    KW("KW"),
    KY("KY"),
    KZ("KZ"),
    LA("LA"),
    LB("LB"),
    LC("LC"),
    LI("LI"),
    LK("LK"),
    LR("LR"),
    LS("LS"),
    LT("LT"),
    LU("LU"),
    LV("LV"),
    LY("LY"),
    MA("MA"),
    MC("MC"),
    MD("MD"),
    ME("ME"),
    MF("MF"),
    MG("MG"),
    MH("MH"),
    MK("MK"),
    ML("ML"),
    MM("MM"),
    MN("MN"),
    MO("MO"),
    MP("MP"),
    MQ("MQ"),
    MR("MR"),
    MS("MS"),
    MT("MT"),
    MU("MU"),
    MV("MV"),
    MW("MW"),
    MX("MX"),
    MY("MY"),
    MZ("MZ"),
    NA("NA"),
    NC("NC"),
    NE("NE"),
    NF("NF"),
    NG("NG"),
    NI("NI"),
    NL("NL"),
    NO("NO"),
    NP("NP"),
    NR("NR"),
    NU("NU"),
    NZ("NZ"),
    OM("OM"),
    PA("PA"),
    PE("PE"),
    PF("PF"),
    PG("PG"),
    PH("PH"),
    PK("PK"),
    PL("PL"),
    PM("PM"),
    PN("PN"),
    PR("PR"),
    PS("PS"),
    PT("PT"),
    PW("PW"),
    PY("PY"),
    QA("QA"),
    @XmlEnumValue("QM..QZ")
    QM__QZ("QM..QZ"),
    RE("RE"),
    RO("RO"),
    RS("RS"),
    RU("RU"),
    RW("RW"),
    SA("SA"),
    SB("SB"),
    SC("SC"),
    SD("SD"),
    SE("SE"),
    SG("SG"),
    SH("SH"),
    SI("SI"),
    SJ("SJ"),
    SK("SK"),
    SL("SL"),
    SM("SM"),
    SN("SN"),
    SO("SO"),
    SR("SR"),
    SS("SS"),
    ST("ST"),
    SV("SV"),
    SX("SX"),
    SY("SY"),
    SZ("SZ"),
    TA("TA"),
    TC("TC"),
    TD("TD"),
    TF("TF"),
    TG("TG"),
    TH("TH"),
    TJ("TJ"),
    TK("TK"),
    TL("TL"),
    TM("TM"),
    TN("TN"),
    TO("TO"),
    TR("TR"),
    TT("TT"),
    TV("TV"),
    TW("TW"),
    TZ("TZ"),
    UA("UA"),
    UG("UG"),
    UM("UM"),
    US("US"),
    UY("UY"),
    UZ("UZ"),
    VA("VA"),
    VC("VC"),
    VE("VE"),
    VG("VG"),
    VI("VI"),
    VN("VN"),
    VU("VU"),
    WF("WF"),
    WS("WS"),
    @XmlEnumValue("XA..XZ")
    XA__XZ("XA..XZ"),
    YE("YE"),
    YT("YT"),
    ZA("ZA"),
    ZM("ZM"),
    ZW("ZW"),
    ZZ("ZZ"),
    @XmlEnumValue("001")
    V001("001"),
    @XmlEnumValue("002")
    V002("002"),
    @XmlEnumValue("003")
    V003("003"),
    @XmlEnumValue("005")
    V005("005"),
    @XmlEnumValue("009")
    V009("009"),
    @XmlEnumValue("011")
    V011("011"),
    @XmlEnumValue("013")
    V013("013"),
    @XmlEnumValue("014")
    V014("014"),
    @XmlEnumValue("015")
    V015("015"),
    @XmlEnumValue("017")
    V017("017"),
    @XmlEnumValue("018")
    V018("018"),
    @XmlEnumValue("019")
    V019("019"),
    @XmlEnumValue("021")
    V021("021"),
    @XmlEnumValue("029")
    V029("029"),
    @XmlEnumValue("030")
    V030("030"),
    @XmlEnumValue("034")
    V034("034"),
    @XmlEnumValue("035")
    V035("035"),
    @XmlEnumValue("039")
    V039("039"),
    @XmlEnumValue("053")
    V053("053"),
    @XmlEnumValue("054")
    V054("054"),
    @XmlEnumValue("057")
    V057("057"),
    @XmlEnumValue("061")
    V061("061"),
    @XmlEnumValue("142")
    V142("142"),
    @XmlEnumValue("143")
    V143("143"),
    @XmlEnumValue("145")
    V145("145"),
    @XmlEnumValue("150")
    V150("150"),
    @XmlEnumValue("151")
    V151("151"),
    @XmlEnumValue("154")
    V154("154"),
    @XmlEnumValue("155")
    V155("155"),
    @XmlEnumValue("419")
    V419("419");
    private final String value;

    RegionIdType(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static RegionIdType fromValue(String v) {
        for (RegionIdType c: RegionIdType.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
