
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
 *     &lt;enumeration value="US-ASCII"/&gt;
 *     &lt;enumeration value="windows-1250"/&gt;
 *     &lt;enumeration value="windows-1251"/&gt;
 *     &lt;enumeration value="windows-1252"/&gt;
 *     &lt;enumeration value="windows-1253"/&gt;
 *     &lt;enumeration value="windows-1254"/&gt;
 *     &lt;enumeration value="windows-1257"/&gt;
 *     &lt;enumeration value="ISO-8859-1"/&gt;
 *     &lt;enumeration value="ISO-8859-2"/&gt;
 *     &lt;enumeration value="ISO-8859-4"/&gt;
 *     &lt;enumeration value="ISO-8859-5"/&gt;
 *     &lt;enumeration value="ISO-8859-7"/&gt;
 *     &lt;enumeration value="ISO-8859-9"/&gt;
 *     &lt;enumeration value="ISO-8859-13"/&gt;
 *     &lt;enumeration value="ISO-8859-15"/&gt;
 *     &lt;enumeration value="KOI8-R"/&gt;
 *     &lt;enumeration value="UTF-8"/&gt;
 *     &lt;enumeration value="UTF-16"/&gt;
 *     &lt;enumeration value="UTF-16BE"/&gt;
 *     &lt;enumeration value="UTF-16LE"/&gt;
 *     &lt;enumeration value="windows-1255"/&gt;
 *     &lt;enumeration value="windows-1256"/&gt;
 *     &lt;enumeration value="windows-1258"/&gt;
 *     &lt;enumeration value="ISO-8859-3"/&gt;
 *     &lt;enumeration value="ISO-8859-6"/&gt;
 *     &lt;enumeration value="ISO-8859-8"/&gt;
 *     &lt;enumeration value="windows-31j"/&gt;
 *     &lt;enumeration value="EUC-JP"/&gt;
 *     &lt;enumeration value="x-EUC-JP-LINUX"/&gt;
 *     &lt;enumeration value="Shift_JIS"/&gt;
 *     &lt;enumeration value="ISO-2022-JP"/&gt;
 *     &lt;enumeration value="x-mswin-936"/&gt;
 *     &lt;enumeration value="GB18030"/&gt;
 *     &lt;enumeration value="x-EUC-CN"/&gt;
 *     &lt;enumeration value="GBK"/&gt;
 *     &lt;enumeration value="ISCII91"/&gt;
 *     &lt;enumeration value="x-windows-949"/&gt;
 *     &lt;enumeration value="EUC-KR"/&gt;
 *     &lt;enumeration value="ISO-2022-KR"/&gt;
 *     &lt;enumeration value="x-windows-950"/&gt;
 *     &lt;enumeration value="x-MS950-HKSCS"/&gt;
 *     &lt;enumeration value="x-EUC-TW"/&gt;
 *     &lt;enumeration value="Big5"/&gt;
 *     &lt;enumeration value="Big5-HKSCS"/&gt;
 *     &lt;enumeration value="TIS-620"/&gt;
 *     &lt;enumeration value="Big5_Solaris"/&gt;
 *     &lt;enumeration value="Cp037"/&gt;
 *     &lt;enumeration value="Cp273"/&gt;
 *     &lt;enumeration value="Cp277"/&gt;
 *     &lt;enumeration value="Cp278"/&gt;
 *     &lt;enumeration value="Cp280"/&gt;
 *     &lt;enumeration value="Cp284"/&gt;
 *     &lt;enumeration value="Cp285"/&gt;
 *     &lt;enumeration value="Cp297"/&gt;
 *     &lt;enumeration value="Cp420"/&gt;
 *     &lt;enumeration value="Cp424"/&gt;
 *     &lt;enumeration value="Cp437"/&gt;
 *     &lt;enumeration value="Cp500"/&gt;
 *     &lt;enumeration value="Cp737"/&gt;
 *     &lt;enumeration value="Cp775"/&gt;
 *     &lt;enumeration value="Cp838"/&gt;
 *     &lt;enumeration value="Cp850"/&gt;
 *     &lt;enumeration value="Cp852"/&gt;
 *     &lt;enumeration value="Cp855"/&gt;
 *     &lt;enumeration value="Cp856"/&gt;
 *     &lt;enumeration value="Cp857"/&gt;
 *     &lt;enumeration value="Cp858"/&gt;
 *     &lt;enumeration value="Cp860"/&gt;
 *     &lt;enumeration value="Cp861"/&gt;
 *     &lt;enumeration value="Cp862"/&gt;
 *     &lt;enumeration value="Cp863"/&gt;
 *     &lt;enumeration value="Cp864"/&gt;
 *     &lt;enumeration value="Cp865"/&gt;
 *     &lt;enumeration value="Cp866"/&gt;
 *     &lt;enumeration value="Cp868"/&gt;
 *     &lt;enumeration value="Cp869"/&gt;
 *     &lt;enumeration value="Cp870"/&gt;
 *     &lt;enumeration value="Cp871"/&gt;
 *     &lt;enumeration value="Cp874"/&gt;
 *     &lt;enumeration value="Cp875"/&gt;
 *     &lt;enumeration value="Cp918"/&gt;
 *     &lt;enumeration value="Cp921"/&gt;
 *     &lt;enumeration value="Cp922"/&gt;
 *     &lt;enumeration value="Cp930"/&gt;
 *     &lt;enumeration value="Cp933"/&gt;
 *     &lt;enumeration value="Cp935"/&gt;
 *     &lt;enumeration value="Cp937"/&gt;
 *     &lt;enumeration value="Cp939"/&gt;
 *     &lt;enumeration value="Cp942"/&gt;
 *     &lt;enumeration value="Cp942C"/&gt;
 *     &lt;enumeration value="Cp943"/&gt;
 *     &lt;enumeration value="Cp943C"/&gt;
 *     &lt;enumeration value="Cp948"/&gt;
 *     &lt;enumeration value="Cp949"/&gt;
 *     &lt;enumeration value="Cp949C"/&gt;
 *     &lt;enumeration value="Cp950"/&gt;
 *     &lt;enumeration value="Cp964"/&gt;
 *     &lt;enumeration value="Cp970"/&gt;
 *     &lt;enumeration value="Cp1006"/&gt;
 *     &lt;enumeration value="Cp1025"/&gt;
 *     &lt;enumeration value="Cp1026"/&gt;
 *     &lt;enumeration value="Cp1046"/&gt;
 *     &lt;enumeration value="Cp1047"/&gt;
 *     &lt;enumeration value="Cp1097"/&gt;
 *     &lt;enumeration value="Cp1098"/&gt;
 *     &lt;enumeration value="Cp1112"/&gt;
 *     &lt;enumeration value="Cp1122"/&gt;
 *     &lt;enumeration value="Cp1123"/&gt;
 *     &lt;enumeration value="Cp1124"/&gt;
 *     &lt;enumeration value="Cp1140"/&gt;
 *     &lt;enumeration value="Cp1141"/&gt;
 *     &lt;enumeration value="Cp1142"/&gt;
 *     &lt;enumeration value="Cp1143"/&gt;
 *     &lt;enumeration value="Cp1144"/&gt;
 *     &lt;enumeration value="Cp1145"/&gt;
 *     &lt;enumeration value="Cp1146"/&gt;
 *     &lt;enumeration value="Cp1147"/&gt;
 *     &lt;enumeration value="Cp1148"/&gt;
 *     &lt;enumeration value="Cp1149"/&gt;
 *     &lt;enumeration value="Cp1381"/&gt;
 *     &lt;enumeration value="Cp1383"/&gt;
 *     &lt;enumeration value="Cp33722"/&gt;
 *     &lt;enumeration value="ISO2022_CN_CNS"/&gt;
 *     &lt;enumeration value="ISO2022_CN_GB"/&gt;
 *     &lt;enumeration value="JISAutoDetect"/&gt;
 *     &lt;enumeration value="MS874"/&gt;
 *     &lt;enumeration value="MacArabic"/&gt;
 *     &lt;enumeration value="MacCentralEurope"/&gt;
 *     &lt;enumeration value="MacCroatian"/&gt;
 *     &lt;enumeration value="MacCyrillic"/&gt;
 *     &lt;enumeration value="MacDingbat"/&gt;
 *     &lt;enumeration value="MacGreek"/&gt;
 *     &lt;enumeration value="MacHebrew"/&gt;
 *     &lt;enumeration value="MacIceland"/&gt;
 *     &lt;enumeration value="MacRoman"/&gt;
 *     &lt;enumeration value="MacRomania"/&gt;
 *     &lt;enumeration value="MacSymbol"/&gt;
 *     &lt;enumeration value="MacThai"/&gt;
 *     &lt;enumeration value="MacTurkish"/&gt;
 *     &lt;enumeration value="MacUkraine"/&gt;
 *   &lt;/restriction&gt;
 * &lt;/simpleType&gt;
 * </pre>
 * 
 */
@XmlType(name = "")
@XmlEnum
public enum CharacterEncodingEnum {

    @XmlEnumValue("US-ASCII")
    US_ASCII("US-ASCII"),
    @XmlEnumValue("windows-1250")
    WINDOWS_1250("windows-1250"),
    @XmlEnumValue("windows-1251")
    WINDOWS_1251("windows-1251"),
    @XmlEnumValue("windows-1252")
    WINDOWS_1252("windows-1252"),
    @XmlEnumValue("windows-1253")
    WINDOWS_1253("windows-1253"),
    @XmlEnumValue("windows-1254")
    WINDOWS_1254("windows-1254"),
    @XmlEnumValue("windows-1257")
    WINDOWS_1257("windows-1257"),
    @XmlEnumValue("ISO-8859-1")
    ISO_8859_1("ISO-8859-1"),
    @XmlEnumValue("ISO-8859-2")
    ISO_8859_2("ISO-8859-2"),
    @XmlEnumValue("ISO-8859-4")
    ISO_8859_4("ISO-8859-4"),
    @XmlEnumValue("ISO-8859-5")
    ISO_8859_5("ISO-8859-5"),
    @XmlEnumValue("ISO-8859-7")
    ISO_8859_7("ISO-8859-7"),
    @XmlEnumValue("ISO-8859-9")
    ISO_8859_9("ISO-8859-9"),
    @XmlEnumValue("ISO-8859-13")
    ISO_8859_13("ISO-8859-13"),
    @XmlEnumValue("ISO-8859-15")
    ISO_8859_15("ISO-8859-15"),
    @XmlEnumValue("KOI8-R")
    KOI_8_R("KOI8-R"),
    @XmlEnumValue("UTF-8")
    UTF_8("UTF-8"),
    @XmlEnumValue("UTF-16")
    UTF_16("UTF-16"),
    @XmlEnumValue("UTF-16BE")
    UTF_16_BE("UTF-16BE"),
    @XmlEnumValue("UTF-16LE")
    UTF_16_LE("UTF-16LE"),
    @XmlEnumValue("windows-1255")
    WINDOWS_1255("windows-1255"),
    @XmlEnumValue("windows-1256")
    WINDOWS_1256("windows-1256"),
    @XmlEnumValue("windows-1258")
    WINDOWS_1258("windows-1258"),
    @XmlEnumValue("ISO-8859-3")
    ISO_8859_3("ISO-8859-3"),
    @XmlEnumValue("ISO-8859-6")
    ISO_8859_6("ISO-8859-6"),
    @XmlEnumValue("ISO-8859-8")
    ISO_8859_8("ISO-8859-8"),
    @XmlEnumValue("windows-31j")
    WINDOWS_31_J("windows-31j"),
    @XmlEnumValue("EUC-JP")
    EUC_JP("EUC-JP"),
    @XmlEnumValue("x-EUC-JP-LINUX")
    X_EUC_JP_LINUX("x-EUC-JP-LINUX"),
    @XmlEnumValue("Shift_JIS")
    SHIFT_JIS("Shift_JIS"),
    @XmlEnumValue("ISO-2022-JP")
    ISO_2022_JP("ISO-2022-JP"),
    @XmlEnumValue("x-mswin-936")
    X_MSWIN_936("x-mswin-936"),
    @XmlEnumValue("GB18030")
    GB_18030("GB18030"),
    @XmlEnumValue("x-EUC-CN")
    X_EUC_CN("x-EUC-CN"),
    GBK("GBK"),
    @XmlEnumValue("ISCII91")
    ISCII_91("ISCII91"),
    @XmlEnumValue("x-windows-949")
    X_WINDOWS_949("x-windows-949"),
    @XmlEnumValue("EUC-KR")
    EUC_KR("EUC-KR"),
    @XmlEnumValue("ISO-2022-KR")
    ISO_2022_KR("ISO-2022-KR"),
    @XmlEnumValue("x-windows-950")
    X_WINDOWS_950("x-windows-950"),
    @XmlEnumValue("x-MS950-HKSCS")
    X_MS_950_HKSCS("x-MS950-HKSCS"),
    @XmlEnumValue("x-EUC-TW")
    X_EUC_TW("x-EUC-TW"),
    @XmlEnumValue("Big5")
    BIG_5("Big5"),
    @XmlEnumValue("Big5-HKSCS")
    BIG_5_HKSCS("Big5-HKSCS"),
    @XmlEnumValue("TIS-620")
    TIS_620("TIS-620"),
    @XmlEnumValue("Big5_Solaris")
    BIG_5_SOLARIS("Big5_Solaris"),
    @XmlEnumValue("Cp037")
    CP_037("Cp037"),
    @XmlEnumValue("Cp273")
    CP_273("Cp273"),
    @XmlEnumValue("Cp277")
    CP_277("Cp277"),
    @XmlEnumValue("Cp278")
    CP_278("Cp278"),
    @XmlEnumValue("Cp280")
    CP_280("Cp280"),
    @XmlEnumValue("Cp284")
    CP_284("Cp284"),
    @XmlEnumValue("Cp285")
    CP_285("Cp285"),
    @XmlEnumValue("Cp297")
    CP_297("Cp297"),
    @XmlEnumValue("Cp420")
    CP_420("Cp420"),
    @XmlEnumValue("Cp424")
    CP_424("Cp424"),
    @XmlEnumValue("Cp437")
    CP_437("Cp437"),
    @XmlEnumValue("Cp500")
    CP_500("Cp500"),
    @XmlEnumValue("Cp737")
    CP_737("Cp737"),
    @XmlEnumValue("Cp775")
    CP_775("Cp775"),
    @XmlEnumValue("Cp838")
    CP_838("Cp838"),
    @XmlEnumValue("Cp850")
    CP_850("Cp850"),
    @XmlEnumValue("Cp852")
    CP_852("Cp852"),
    @XmlEnumValue("Cp855")
    CP_855("Cp855"),
    @XmlEnumValue("Cp856")
    CP_856("Cp856"),
    @XmlEnumValue("Cp857")
    CP_857("Cp857"),
    @XmlEnumValue("Cp858")
    CP_858("Cp858"),
    @XmlEnumValue("Cp860")
    CP_860("Cp860"),
    @XmlEnumValue("Cp861")
    CP_861("Cp861"),
    @XmlEnumValue("Cp862")
    CP_862("Cp862"),
    @XmlEnumValue("Cp863")
    CP_863("Cp863"),
    @XmlEnumValue("Cp864")
    CP_864("Cp864"),
    @XmlEnumValue("Cp865")
    CP_865("Cp865"),
    @XmlEnumValue("Cp866")
    CP_866("Cp866"),
    @XmlEnumValue("Cp868")
    CP_868("Cp868"),
    @XmlEnumValue("Cp869")
    CP_869("Cp869"),
    @XmlEnumValue("Cp870")
    CP_870("Cp870"),
    @XmlEnumValue("Cp871")
    CP_871("Cp871"),
    @XmlEnumValue("Cp874")
    CP_874("Cp874"),
    @XmlEnumValue("Cp875")
    CP_875("Cp875"),
    @XmlEnumValue("Cp918")
    CP_918("Cp918"),
    @XmlEnumValue("Cp921")
    CP_921("Cp921"),
    @XmlEnumValue("Cp922")
    CP_922("Cp922"),
    @XmlEnumValue("Cp930")
    CP_930("Cp930"),
    @XmlEnumValue("Cp933")
    CP_933("Cp933"),
    @XmlEnumValue("Cp935")
    CP_935("Cp935"),
    @XmlEnumValue("Cp937")
    CP_937("Cp937"),
    @XmlEnumValue("Cp939")
    CP_939("Cp939"),
    @XmlEnumValue("Cp942")
    CP_942("Cp942"),
    @XmlEnumValue("Cp942C")
    CP_942_C("Cp942C"),
    @XmlEnumValue("Cp943")
    CP_943("Cp943"),
    @XmlEnumValue("Cp943C")
    CP_943_C("Cp943C"),
    @XmlEnumValue("Cp948")
    CP_948("Cp948"),
    @XmlEnumValue("Cp949")
    CP_949("Cp949"),
    @XmlEnumValue("Cp949C")
    CP_949_C("Cp949C"),
    @XmlEnumValue("Cp950")
    CP_950("Cp950"),
    @XmlEnumValue("Cp964")
    CP_964("Cp964"),
    @XmlEnumValue("Cp970")
    CP_970("Cp970"),
    @XmlEnumValue("Cp1006")
    CP_1006("Cp1006"),
    @XmlEnumValue("Cp1025")
    CP_1025("Cp1025"),
    @XmlEnumValue("Cp1026")
    CP_1026("Cp1026"),
    @XmlEnumValue("Cp1046")
    CP_1046("Cp1046"),
    @XmlEnumValue("Cp1047")
    CP_1047("Cp1047"),
    @XmlEnumValue("Cp1097")
    CP_1097("Cp1097"),
    @XmlEnumValue("Cp1098")
    CP_1098("Cp1098"),
    @XmlEnumValue("Cp1112")
    CP_1112("Cp1112"),
    @XmlEnumValue("Cp1122")
    CP_1122("Cp1122"),
    @XmlEnumValue("Cp1123")
    CP_1123("Cp1123"),
    @XmlEnumValue("Cp1124")
    CP_1124("Cp1124"),
    @XmlEnumValue("Cp1140")
    CP_1140("Cp1140"),
    @XmlEnumValue("Cp1141")
    CP_1141("Cp1141"),
    @XmlEnumValue("Cp1142")
    CP_1142("Cp1142"),
    @XmlEnumValue("Cp1143")
    CP_1143("Cp1143"),
    @XmlEnumValue("Cp1144")
    CP_1144("Cp1144"),
    @XmlEnumValue("Cp1145")
    CP_1145("Cp1145"),
    @XmlEnumValue("Cp1146")
    CP_1146("Cp1146"),
    @XmlEnumValue("Cp1147")
    CP_1147("Cp1147"),
    @XmlEnumValue("Cp1148")
    CP_1148("Cp1148"),
    @XmlEnumValue("Cp1149")
    CP_1149("Cp1149"),
    @XmlEnumValue("Cp1381")
    CP_1381("Cp1381"),
    @XmlEnumValue("Cp1383")
    CP_1383("Cp1383"),
    @XmlEnumValue("Cp33722")
    CP_33722("Cp33722"),
    @XmlEnumValue("ISO2022_CN_CNS")
    ISO_2022_CN_CNS("ISO2022_CN_CNS"),
    @XmlEnumValue("ISO2022_CN_GB")
    ISO_2022_CN_GB("ISO2022_CN_GB"),
    @XmlEnumValue("JISAutoDetect")
    JIS_AUTO_DETECT("JISAutoDetect"),
    @XmlEnumValue("MS874")
    MS_874("MS874"),
    @XmlEnumValue("MacArabic")
    MAC_ARABIC("MacArabic"),
    @XmlEnumValue("MacCentralEurope")
    MAC_CENTRAL_EUROPE("MacCentralEurope"),
    @XmlEnumValue("MacCroatian")
    MAC_CROATIAN("MacCroatian"),
    @XmlEnumValue("MacCyrillic")
    MAC_CYRILLIC("MacCyrillic"),
    @XmlEnumValue("MacDingbat")
    MAC_DINGBAT("MacDingbat"),
    @XmlEnumValue("MacGreek")
    MAC_GREEK("MacGreek"),
    @XmlEnumValue("MacHebrew")
    MAC_HEBREW("MacHebrew"),
    @XmlEnumValue("MacIceland")
    MAC_ICELAND("MacIceland"),
    @XmlEnumValue("MacRoman")
    MAC_ROMAN("MacRoman"),
    @XmlEnumValue("MacRomania")
    MAC_ROMANIA("MacRomania"),
    @XmlEnumValue("MacSymbol")
    MAC_SYMBOL("MacSymbol"),
    @XmlEnumValue("MacThai")
    MAC_THAI("MacThai"),
    @XmlEnumValue("MacTurkish")
    MAC_TURKISH("MacTurkish"),
    @XmlEnumValue("MacUkraine")
    MAC_UKRAINE("MacUkraine");
    private final String value;

    CharacterEncodingEnum(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static CharacterEncodingEnum fromValue(String v) {
        for (CharacterEncodingEnum c: CharacterEncodingEnum.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
