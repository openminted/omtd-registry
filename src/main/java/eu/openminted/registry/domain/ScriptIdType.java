
package eu.openminted.registry.domain;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for scriptIdType.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="scriptIdType"&gt;
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *     &lt;enumeration value="Afak"/&gt;
 *     &lt;enumeration value="Aghb"/&gt;
 *     &lt;enumeration value="Ahom"/&gt;
 *     &lt;enumeration value="Arab"/&gt;
 *     &lt;enumeration value="Armi"/&gt;
 *     &lt;enumeration value="Armn"/&gt;
 *     &lt;enumeration value="Avst"/&gt;
 *     &lt;enumeration value="Bali"/&gt;
 *     &lt;enumeration value="Bamu"/&gt;
 *     &lt;enumeration value="Bass"/&gt;
 *     &lt;enumeration value="Batk"/&gt;
 *     &lt;enumeration value="Beng"/&gt;
 *     &lt;enumeration value="Blis"/&gt;
 *     &lt;enumeration value="Bopo"/&gt;
 *     &lt;enumeration value="Brah"/&gt;
 *     &lt;enumeration value="Brai"/&gt;
 *     &lt;enumeration value="Bugi"/&gt;
 *     &lt;enumeration value="Buhd"/&gt;
 *     &lt;enumeration value="Cakm"/&gt;
 *     &lt;enumeration value="Cans"/&gt;
 *     &lt;enumeration value="Cari"/&gt;
 *     &lt;enumeration value="Cham"/&gt;
 *     &lt;enumeration value="Cher"/&gt;
 *     &lt;enumeration value="Cirt"/&gt;
 *     &lt;enumeration value="Copt"/&gt;
 *     &lt;enumeration value="Cprt"/&gt;
 *     &lt;enumeration value="Cyrl"/&gt;
 *     &lt;enumeration value="Cyrs"/&gt;
 *     &lt;enumeration value="Deva"/&gt;
 *     &lt;enumeration value="Dsrt"/&gt;
 *     &lt;enumeration value="Dupl"/&gt;
 *     &lt;enumeration value="Egyd"/&gt;
 *     &lt;enumeration value="Egyh"/&gt;
 *     &lt;enumeration value="Egyp"/&gt;
 *     &lt;enumeration value="Elba"/&gt;
 *     &lt;enumeration value="Ethi"/&gt;
 *     &lt;enumeration value="Geok"/&gt;
 *     &lt;enumeration value="Geor"/&gt;
 *     &lt;enumeration value="Glag"/&gt;
 *     &lt;enumeration value="Goth"/&gt;
 *     &lt;enumeration value="Gran"/&gt;
 *     &lt;enumeration value="Grek"/&gt;
 *     &lt;enumeration value="Gujr"/&gt;
 *     &lt;enumeration value="Guru"/&gt;
 *     &lt;enumeration value="Hang"/&gt;
 *     &lt;enumeration value="Hani"/&gt;
 *     &lt;enumeration value="Hano"/&gt;
 *     &lt;enumeration value="Hans"/&gt;
 *     &lt;enumeration value="Hant"/&gt;
 *     &lt;enumeration value="Hatr"/&gt;
 *     &lt;enumeration value="Hebr"/&gt;
 *     &lt;enumeration value="Hira"/&gt;
 *     &lt;enumeration value="Hluw"/&gt;
 *     &lt;enumeration value="Hmng"/&gt;
 *     &lt;enumeration value="Hrkt"/&gt;
 *     &lt;enumeration value="Hung"/&gt;
 *     &lt;enumeration value="Inds"/&gt;
 *     &lt;enumeration value="Ital"/&gt;
 *     &lt;enumeration value="Java"/&gt;
 *     &lt;enumeration value="Jpan"/&gt;
 *     &lt;enumeration value="Jurc"/&gt;
 *     &lt;enumeration value="Kali"/&gt;
 *     &lt;enumeration value="Kana"/&gt;
 *     &lt;enumeration value="Khar"/&gt;
 *     &lt;enumeration value="Khmr"/&gt;
 *     &lt;enumeration value="Khoj"/&gt;
 *     &lt;enumeration value="Knda"/&gt;
 *     &lt;enumeration value="Kore"/&gt;
 *     &lt;enumeration value="Kpel"/&gt;
 *     &lt;enumeration value="Kthi"/&gt;
 *     &lt;enumeration value="Lana"/&gt;
 *     &lt;enumeration value="Laoo"/&gt;
 *     &lt;enumeration value="Latf"/&gt;
 *     &lt;enumeration value="Latg"/&gt;
 *     &lt;enumeration value="Latn"/&gt;
 *     &lt;enumeration value="Lepc"/&gt;
 *     &lt;enumeration value="Limb"/&gt;
 *     &lt;enumeration value="Lina"/&gt;
 *     &lt;enumeration value="Linb"/&gt;
 *     &lt;enumeration value="Lisu"/&gt;
 *     &lt;enumeration value="Loma"/&gt;
 *     &lt;enumeration value="Lyci"/&gt;
 *     &lt;enumeration value="Lydi"/&gt;
 *     &lt;enumeration value="Mahj"/&gt;
 *     &lt;enumeration value="Mand"/&gt;
 *     &lt;enumeration value="Mani"/&gt;
 *     &lt;enumeration value="Maya"/&gt;
 *     &lt;enumeration value="Mend"/&gt;
 *     &lt;enumeration value="Merc"/&gt;
 *     &lt;enumeration value="Mero"/&gt;
 *     &lt;enumeration value="Mlym"/&gt;
 *     &lt;enumeration value="Modi"/&gt;
 *     &lt;enumeration value="Mong"/&gt;
 *     &lt;enumeration value="Moon"/&gt;
 *     &lt;enumeration value="Mroo"/&gt;
 *     &lt;enumeration value="Mtei"/&gt;
 *     &lt;enumeration value="Mult"/&gt;
 *     &lt;enumeration value="Mymr"/&gt;
 *     &lt;enumeration value="Narb"/&gt;
 *     &lt;enumeration value="Nbat"/&gt;
 *     &lt;enumeration value="Nkgb"/&gt;
 *     &lt;enumeration value="Nkoo"/&gt;
 *     &lt;enumeration value="Nshu"/&gt;
 *     &lt;enumeration value="Ogam"/&gt;
 *     &lt;enumeration value="Olck"/&gt;
 *     &lt;enumeration value="Orkh"/&gt;
 *     &lt;enumeration value="Orya"/&gt;
 *     &lt;enumeration value="Osma"/&gt;
 *     &lt;enumeration value="Palm"/&gt;
 *     &lt;enumeration value="Pauc"/&gt;
 *     &lt;enumeration value="Perm"/&gt;
 *     &lt;enumeration value="Phag"/&gt;
 *     &lt;enumeration value="Phli"/&gt;
 *     &lt;enumeration value="Phlp"/&gt;
 *     &lt;enumeration value="Phlv"/&gt;
 *     &lt;enumeration value="Phnx"/&gt;
 *     &lt;enumeration value="Plrd"/&gt;
 *     &lt;enumeration value="Prti"/&gt;
 *     &lt;enumeration value="Qaaa..Qabx"/&gt;
 *     &lt;enumeration value="Rjng"/&gt;
 *     &lt;enumeration value="Roro"/&gt;
 *     &lt;enumeration value="Runr"/&gt;
 *     &lt;enumeration value="Samr"/&gt;
 *     &lt;enumeration value="Sara"/&gt;
 *     &lt;enumeration value="Sarb"/&gt;
 *     &lt;enumeration value="Saur"/&gt;
 *     &lt;enumeration value="Sgnw"/&gt;
 *     &lt;enumeration value="Shaw"/&gt;
 *     &lt;enumeration value="Shrd"/&gt;
 *     &lt;enumeration value="Sidd"/&gt;
 *     &lt;enumeration value="Sind"/&gt;
 *     &lt;enumeration value="Sinh"/&gt;
 *     &lt;enumeration value="Sora"/&gt;
 *     &lt;enumeration value="Sund"/&gt;
 *     &lt;enumeration value="Sylo"/&gt;
 *     &lt;enumeration value="Syrc"/&gt;
 *     &lt;enumeration value="Syre"/&gt;
 *     &lt;enumeration value="Syrj"/&gt;
 *     &lt;enumeration value="Syrn"/&gt;
 *     &lt;enumeration value="Tagb"/&gt;
 *     &lt;enumeration value="Takr"/&gt;
 *     &lt;enumeration value="Tale"/&gt;
 *     &lt;enumeration value="Talu"/&gt;
 *     &lt;enumeration value="Taml"/&gt;
 *     &lt;enumeration value="Tang"/&gt;
 *     &lt;enumeration value="Tavt"/&gt;
 *     &lt;enumeration value="Telu"/&gt;
 *     &lt;enumeration value="Teng"/&gt;
 *     &lt;enumeration value="Tfng"/&gt;
 *     &lt;enumeration value="Tglg"/&gt;
 *     &lt;enumeration value="Thaa"/&gt;
 *     &lt;enumeration value="Thai"/&gt;
 *     &lt;enumeration value="Tibt"/&gt;
 *     &lt;enumeration value="Tirh"/&gt;
 *     &lt;enumeration value="Ugar"/&gt;
 *     &lt;enumeration value="Vaii"/&gt;
 *     &lt;enumeration value="Visp"/&gt;
 *     &lt;enumeration value="Wara"/&gt;
 *     &lt;enumeration value="Wole"/&gt;
 *     &lt;enumeration value="Xpeo"/&gt;
 *     &lt;enumeration value="Xsux"/&gt;
 *     &lt;enumeration value="Yiii"/&gt;
 *     &lt;enumeration value="Zinh"/&gt;
 *     &lt;enumeration value="Zmth"/&gt;
 *     &lt;enumeration value="Zsym"/&gt;
 *     &lt;enumeration value="Zxxx"/&gt;
 *     &lt;enumeration value="Zyyy"/&gt;
 *     &lt;enumeration value="Zzzz"/&gt;
 *   &lt;/restriction&gt;
 * &lt;/simpleType&gt;
 * </pre>
 * 
 */
@XmlType(name = "scriptIdType")
@XmlEnum
public enum ScriptIdType {

    @XmlEnumValue("Afak")
    AFAK("Afak"),
    @XmlEnumValue("Aghb")
    AGHB("Aghb"),
    @XmlEnumValue("Ahom")
    AHOM("Ahom"),
    @XmlEnumValue("Arab")
    ARAB("Arab"),
    @XmlEnumValue("Armi")
    ARMI("Armi"),
    @XmlEnumValue("Armn")
    ARMN("Armn"),
    @XmlEnumValue("Avst")
    AVST("Avst"),
    @XmlEnumValue("Bali")
    BALI("Bali"),
    @XmlEnumValue("Bamu")
    BAMU("Bamu"),
    @XmlEnumValue("Bass")
    BASS("Bass"),
    @XmlEnumValue("Batk")
    BATK("Batk"),
    @XmlEnumValue("Beng")
    BENG("Beng"),
    @XmlEnumValue("Blis")
    BLIS("Blis"),
    @XmlEnumValue("Bopo")
    BOPO("Bopo"),
    @XmlEnumValue("Brah")
    BRAH("Brah"),
    @XmlEnumValue("Brai")
    BRAI("Brai"),
    @XmlEnumValue("Bugi")
    BUGI("Bugi"),
    @XmlEnumValue("Buhd")
    BUHD("Buhd"),
    @XmlEnumValue("Cakm")
    CAKM("Cakm"),
    @XmlEnumValue("Cans")
    CANS("Cans"),
    @XmlEnumValue("Cari")
    CARI("Cari"),
    @XmlEnumValue("Cham")
    CHAM("Cham"),
    @XmlEnumValue("Cher")
    CHER("Cher"),
    @XmlEnumValue("Cirt")
    CIRT("Cirt"),
    @XmlEnumValue("Copt")
    COPT("Copt"),
    @XmlEnumValue("Cprt")
    CPRT("Cprt"),
    @XmlEnumValue("Cyrl")
    CYRL("Cyrl"),
    @XmlEnumValue("Cyrs")
    CYRS("Cyrs"),
    @XmlEnumValue("Deva")
    DEVA("Deva"),
    @XmlEnumValue("Dsrt")
    DSRT("Dsrt"),
    @XmlEnumValue("Dupl")
    DUPL("Dupl"),
    @XmlEnumValue("Egyd")
    EGYD("Egyd"),
    @XmlEnumValue("Egyh")
    EGYH("Egyh"),
    @XmlEnumValue("Egyp")
    EGYP("Egyp"),
    @XmlEnumValue("Elba")
    ELBA("Elba"),
    @XmlEnumValue("Ethi")
    ETHI("Ethi"),
    @XmlEnumValue("Geok")
    GEOK("Geok"),
    @XmlEnumValue("Geor")
    GEOR("Geor"),
    @XmlEnumValue("Glag")
    GLAG("Glag"),
    @XmlEnumValue("Goth")
    GOTH("Goth"),
    @XmlEnumValue("Gran")
    GRAN("Gran"),
    @XmlEnumValue("Grek")
    GREK("Grek"),
    @XmlEnumValue("Gujr")
    GUJR("Gujr"),
    @XmlEnumValue("Guru")
    GURU("Guru"),
    @XmlEnumValue("Hang")
    HANG("Hang"),
    @XmlEnumValue("Hani")
    HANI("Hani"),
    @XmlEnumValue("Hano")
    HANO("Hano"),
    @XmlEnumValue("Hans")
    HANS("Hans"),
    @XmlEnumValue("Hant")
    HANT("Hant"),
    @XmlEnumValue("Hatr")
    HATR("Hatr"),
    @XmlEnumValue("Hebr")
    HEBR("Hebr"),
    @XmlEnumValue("Hira")
    HIRA("Hira"),
    @XmlEnumValue("Hluw")
    HLUW("Hluw"),
    @XmlEnumValue("Hmng")
    HMNG("Hmng"),
    @XmlEnumValue("Hrkt")
    HRKT("Hrkt"),
    @XmlEnumValue("Hung")
    HUNG("Hung"),
    @XmlEnumValue("Inds")
    INDS("Inds"),
    @XmlEnumValue("Ital")
    ITAL("Ital"),
    @XmlEnumValue("Java")
    JAVA("Java"),
    @XmlEnumValue("Jpan")
    JPAN("Jpan"),
    @XmlEnumValue("Jurc")
    JURC("Jurc"),
    @XmlEnumValue("Kali")
    KALI("Kali"),
    @XmlEnumValue("Kana")
    KANA("Kana"),
    @XmlEnumValue("Khar")
    KHAR("Khar"),
    @XmlEnumValue("Khmr")
    KHMR("Khmr"),
    @XmlEnumValue("Khoj")
    KHOJ("Khoj"),
    @XmlEnumValue("Knda")
    KNDA("Knda"),
    @XmlEnumValue("Kore")
    KORE("Kore"),
    @XmlEnumValue("Kpel")
    KPEL("Kpel"),
    @XmlEnumValue("Kthi")
    KTHI("Kthi"),
    @XmlEnumValue("Lana")
    LANA("Lana"),
    @XmlEnumValue("Laoo")
    LAOO("Laoo"),
    @XmlEnumValue("Latf")
    LATF("Latf"),
    @XmlEnumValue("Latg")
    LATG("Latg"),
    @XmlEnumValue("Latn")
    LATN("Latn"),
    @XmlEnumValue("Lepc")
    LEPC("Lepc"),
    @XmlEnumValue("Limb")
    LIMB("Limb"),
    @XmlEnumValue("Lina")
    LINA("Lina"),
    @XmlEnumValue("Linb")
    LINB("Linb"),
    @XmlEnumValue("Lisu")
    LISU("Lisu"),
    @XmlEnumValue("Loma")
    LOMA("Loma"),
    @XmlEnumValue("Lyci")
    LYCI("Lyci"),
    @XmlEnumValue("Lydi")
    LYDI("Lydi"),
    @XmlEnumValue("Mahj")
    MAHJ("Mahj"),
    @XmlEnumValue("Mand")
    MAND("Mand"),
    @XmlEnumValue("Mani")
    MANI("Mani"),
    @XmlEnumValue("Maya")
    MAYA("Maya"),
    @XmlEnumValue("Mend")
    MEND("Mend"),
    @XmlEnumValue("Merc")
    MERC("Merc"),
    @XmlEnumValue("Mero")
    MERO("Mero"),
    @XmlEnumValue("Mlym")
    MLYM("Mlym"),
    @XmlEnumValue("Modi")
    MODI("Modi"),
    @XmlEnumValue("Mong")
    MONG("Mong"),
    @XmlEnumValue("Moon")
    MOON("Moon"),
    @XmlEnumValue("Mroo")
    MROO("Mroo"),
    @XmlEnumValue("Mtei")
    MTEI("Mtei"),
    @XmlEnumValue("Mult")
    MULT("Mult"),
    @XmlEnumValue("Mymr")
    MYMR("Mymr"),
    @XmlEnumValue("Narb")
    NARB("Narb"),
    @XmlEnumValue("Nbat")
    NBAT("Nbat"),
    @XmlEnumValue("Nkgb")
    NKGB("Nkgb"),
    @XmlEnumValue("Nkoo")
    NKOO("Nkoo"),
    @XmlEnumValue("Nshu")
    NSHU("Nshu"),
    @XmlEnumValue("Ogam")
    OGAM("Ogam"),
    @XmlEnumValue("Olck")
    OLCK("Olck"),
    @XmlEnumValue("Orkh")
    ORKH("Orkh"),
    @XmlEnumValue("Orya")
    ORYA("Orya"),
    @XmlEnumValue("Osma")
    OSMA("Osma"),
    @XmlEnumValue("Palm")
    PALM("Palm"),
    @XmlEnumValue("Pauc")
    PAUC("Pauc"),
    @XmlEnumValue("Perm")
    PERM("Perm"),
    @XmlEnumValue("Phag")
    PHAG("Phag"),
    @XmlEnumValue("Phli")
    PHLI("Phli"),
    @XmlEnumValue("Phlp")
    PHLP("Phlp"),
    @XmlEnumValue("Phlv")
    PHLV("Phlv"),
    @XmlEnumValue("Phnx")
    PHNX("Phnx"),
    @XmlEnumValue("Plrd")
    PLRD("Plrd"),
    @XmlEnumValue("Prti")
    PRTI("Prti"),
    @XmlEnumValue("Qaaa..Qabx")
    QAAA__QABX("Qaaa..Qabx"),
    @XmlEnumValue("Rjng")
    RJNG("Rjng"),
    @XmlEnumValue("Roro")
    RORO("Roro"),
    @XmlEnumValue("Runr")
    RUNR("Runr"),
    @XmlEnumValue("Samr")
    SAMR("Samr"),
    @XmlEnumValue("Sara")
    SARA("Sara"),
    @XmlEnumValue("Sarb")
    SARB("Sarb"),
    @XmlEnumValue("Saur")
    SAUR("Saur"),
    @XmlEnumValue("Sgnw")
    SGNW("Sgnw"),
    @XmlEnumValue("Shaw")
    SHAW("Shaw"),
    @XmlEnumValue("Shrd")
    SHRD("Shrd"),
    @XmlEnumValue("Sidd")
    SIDD("Sidd"),
    @XmlEnumValue("Sind")
    SIND("Sind"),
    @XmlEnumValue("Sinh")
    SINH("Sinh"),
    @XmlEnumValue("Sora")
    SORA("Sora"),
    @XmlEnumValue("Sund")
    SUND("Sund"),
    @XmlEnumValue("Sylo")
    SYLO("Sylo"),
    @XmlEnumValue("Syrc")
    SYRC("Syrc"),
    @XmlEnumValue("Syre")
    SYRE("Syre"),
    @XmlEnumValue("Syrj")
    SYRJ("Syrj"),
    @XmlEnumValue("Syrn")
    SYRN("Syrn"),
    @XmlEnumValue("Tagb")
    TAGB("Tagb"),
    @XmlEnumValue("Takr")
    TAKR("Takr"),
    @XmlEnumValue("Tale")
    TALE("Tale"),
    @XmlEnumValue("Talu")
    TALU("Talu"),
    @XmlEnumValue("Taml")
    TAML("Taml"),
    @XmlEnumValue("Tang")
    TANG("Tang"),
    @XmlEnumValue("Tavt")
    TAVT("Tavt"),
    @XmlEnumValue("Telu")
    TELU("Telu"),
    @XmlEnumValue("Teng")
    TENG("Teng"),
    @XmlEnumValue("Tfng")
    TFNG("Tfng"),
    @XmlEnumValue("Tglg")
    TGLG("Tglg"),
    @XmlEnumValue("Thaa")
    THAA("Thaa"),
    @XmlEnumValue("Thai")
    THAI("Thai"),
    @XmlEnumValue("Tibt")
    TIBT("Tibt"),
    @XmlEnumValue("Tirh")
    TIRH("Tirh"),
    @XmlEnumValue("Ugar")
    UGAR("Ugar"),
    @XmlEnumValue("Vaii")
    VAII("Vaii"),
    @XmlEnumValue("Visp")
    VISP("Visp"),
    @XmlEnumValue("Wara")
    WARA("Wara"),
    @XmlEnumValue("Wole")
    WOLE("Wole"),
    @XmlEnumValue("Xpeo")
    XPEO("Xpeo"),
    @XmlEnumValue("Xsux")
    XSUX("Xsux"),
    @XmlEnumValue("Yiii")
    YIII("Yiii"),
    @XmlEnumValue("Zinh")
    ZINH("Zinh"),
    @XmlEnumValue("Zmth")
    ZMTH("Zmth"),
    @XmlEnumValue("Zsym")
    ZSYM("Zsym"),
    @XmlEnumValue("Zxxx")
    ZXXX("Zxxx"),
    @XmlEnumValue("Zyyy")
    ZYYY("Zyyy"),
    @XmlEnumValue("Zzzz")
    ZZZZ("Zzzz");
    private final String value;

    ScriptIdType(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static ScriptIdType fromValue(String v) {
        for (ScriptIdType c: ScriptIdType.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
