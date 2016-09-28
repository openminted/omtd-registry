package eu.openminted.registry.domain;

import javax.xml.bind.annotation.adapters.XmlAdapter;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

/**
 * Created by stefania on 9/5/16.
 */

@XmlJavaTypeAdapter(CharacterEncodingAdapter.class)
public enum CharacterEncoding {

	US_ASCII("US-ASCII"),
	WINDOWS_1250("windows-1250"),
	WINDOWS_1251("windows-1251"),
	WINDOWS_1252("windows-1252"),
	WINDOWS_1253("windows-1253"),
	WINDOWS_1254("windows-1254"),
	WINDOWS_1257("windows-1257"),
	ISO_8859_1("ISO-8859-1"),
	ISO_8859_2("ISO-8859-2"),
	ISO_8859_4("ISO-8859-4"),
	ISO_8859_5("ISO-8859-5"),
	ISO_8859_7("ISO-8859-7"),
	ISO_8859_9("ISO-8859-9"),
	ISO_8859_13("ISO-8859-13"),
	ISO_8859_15("ISO-8859-15"),
	KOI8_R("KOI8-R"),
	UTF_8("UTF-8"),
	UTF_16("UTF-16"),
	UTF_16BE("UTF-16BE"),
	UTF_16LE("UTF-16LE"),
	WINDOWS_1255("windows-1255"),
	WINDOWS_1256("windows-1256"),
	WINDOWS_1258("windows-1258"),
	ISO_8859_3("ISO-8859-3"),
	ISO_8859_6("ISO-8859-6"),
	ISO_8859_8("ISO-8859-8"),
	WINDOWS_31J("windows-31j"),
	EUC_JP("EUC-JP"),
	X_EUC_JP_LINUX("x-EUC-JP-LINUX"),
	SHIFT_JIS("Shift_JIS"),
	ISO_2022_JP("ISO-2022-JP"),
	X_MSWIN_936("x-mswin-936"),
	GB18030("GB18030"),
	X_EUC_CN("x-EUC-CN"),
	GBK("GBK"),
	ISCII91("ISCII91"),
	X_WINDOWS_949("x-windows-949"),
	EUC_KR("EUC-KR"),
	ISO_2022_KR("ISO-2022-KR"),
	X_WINDOWS_950("x-windows-950"),
	X_MS950_HKSCS("x-MS950-HKSCS"),
	X_EUC_TW("x-EUC-TW"),
	BIG5("Big5"),
	BIG5_HKSCS("Big5-HKSCS"),
	TIS_620("TIS-620"),
	BIG5_SOLARIS("Big5_Solaris"),
	CP037("Cp037"),
	CP273("Cp273"),
	CP277("Cp277"),
	CP278("Cp278"),
	CP280("Cp280"),
	CP284("Cp284"),
	CP285("Cp285"),
	CP297("Cp297"),
	CP420("Cp420"),
	CP424("Cp424"),
	CP437("Cp437"),
	CP500("Cp500"),
	CP737("Cp737"),
	CP775("Cp775"),
	CP838("Cp838"),
	CP850("Cp850"),
	CP852("Cp852"),
	CP855("Cp855"),
	CP856("Cp856"),
	CP857("Cp857"),
	CP858("Cp858"),
	CP860("Cp860"),
	CP861("Cp861"),
	CP862("Cp862"),
	CP863("Cp863"),
	CP864("Cp864"),
	CP865("Cp865"),
	CP866("Cp866"),
	CP868("Cp868"),
	CP869("Cp869"),
	CP870("Cp870"),
	CP871("Cp871"),
	CP874("Cp874"),
	CP875("Cp875"),
	CP918("Cp918"),
	CP921("Cp921"),
	CP922("Cp922"),
	CP930("Cp930"),
	CP933("Cp933"),
	CP935("Cp935"),
	CP937("Cp937"),
	CP939("Cp939"),
	CP942("Cp942"),
	CP942C("Cp942C"),
	CP943("Cp943"),
	CP943C("Cp943C"),
	CP948("Cp948"),
	CP949("Cp949"),
	CP949C("Cp949C"),
	CP950("Cp950"),
	CP964("Cp964"),
	CP970("Cp970"),
	CP1006("Cp1006"),
	CP1025("Cp1025"),
	CP1026("Cp1026"),
	CP1046("Cp1046"),
	CP1047("Cp1047"),
	CP1097("Cp1097"),
	CP1098("Cp1098"),
	CP1112("Cp1112"),
	CP1122("Cp1122"),
	CP1123("Cp1123"),
	CP1124("Cp1124"),
	CP1140("Cp1140"),
	CP1141("Cp1141"),
	CP1142("Cp1142"),
	CP1143("Cp1143"),
	CP1144("Cp1144"),
	CP1145("Cp1145"),
	CP1146("Cp1146"),
	CP1147("Cp1147"),
	CP1148("Cp1148"),
	CP1149("Cp1149"),
	CP1381("Cp1381"),
	CP1383("Cp1383"),
	CP33722("Cp33722"),
	ISO2022_CN_CNS("ISO2022_CN_CNS"),
	ISO2022_CN_GB("ISO2022_CN_GB"),
	JISAUTODETECT("JISAutoDetect"),
	MS874("MS874"),
	MACARABIC("MacArabic"),
	MACCENTRALEUROPE("MacCentralEurope"),
	MACCROATIAN("MacCroatian"),
	MACCYRILLIC("MacCyrillic"),
	MACDINGBAT("MacDingbat"),
	MACGREEK("MacGreek"),
	MACHEBREW("MacHebrew"),
	MACICELAND("MacIceland"),
	MACROMAN("MacRoman"),
	MACROMANIA("MacRomania"),
	MACSYMBOL("MacSymbol"),
	MACTHAI("MacThai"),
	MACTURKISH("MacTurkish"),
	MACUKRAINE("MacUkraine");
	
    private String value;

    CharacterEncoding() {
    }
    
    

    private CharacterEncoding(String value) {
		this.value = value;
	}



	public String getValue() {
		return value;
	}



	public void setValue(String value) {
		this.value = value;
	}



	public static CharacterEncoding forValue(String value) {
        for (CharacterEncoding ut: values()) {
            if (ut.getValue().equals(value))
                return ut;
        }

        return null;
    }
}

class CharacterEncodingAdapter extends XmlAdapter<String, CharacterEncoding> {

    @Override
    public String marshal(CharacterEncoding v) throws Exception {
        return v!=null?v.getValue():null;
    }

    @Override
    public CharacterEncoding unmarshal(String v) throws Exception {
        return CharacterEncoding.forValue(v);
    }
}
