
package eu.openminted.registry.domain;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for variantIdType.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="variantIdType"&gt;
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *     &lt;enumeration value="1606nict"/&gt;
 *     &lt;enumeration value="alalc97"/&gt;
 *     &lt;enumeration value="fonipa"/&gt;
 *     &lt;enumeration value="fonupa"/&gt;
 *     &lt;enumeration value="fonxsamp"/&gt;
 *     &lt;enumeration value="1694acad"/&gt;
 *     &lt;enumeration value="1901"/&gt;
 *     &lt;enumeration value="1959acad"/&gt;
 *     &lt;enumeration value="1994"/&gt;
 *     &lt;enumeration value="1996"/&gt;
 *     &lt;enumeration value="aluku"/&gt;
 *     &lt;enumeration value="arevela"/&gt;
 *     &lt;enumeration value="arevmda"/&gt;
 *     &lt;enumeration value="baku1926"/&gt;
 *     &lt;enumeration value="balanka"/&gt;
 *     &lt;enumeration value="barla"/&gt;
 *     &lt;enumeration value="bauddha"/&gt;
 *     &lt;enumeration value="biscayan"/&gt;
 *     &lt;enumeration value="biske"/&gt;
 *     &lt;enumeration value="bohoric"/&gt;
 *     &lt;enumeration value="boont"/&gt;
 *     &lt;enumeration value="dajnko"/&gt;
 *     &lt;enumeration value="ekavsk"/&gt;
 *     &lt;enumeration value="emodeng"/&gt;
 *     &lt;enumeration value="hepburn"/&gt;
 *     &lt;enumeration value="hognorsk"/&gt;
 *     &lt;enumeration value="ijekavsk"/&gt;
 *     &lt;enumeration value="itihasa"/&gt;
 *     &lt;enumeration value="jauer"/&gt;
 *     &lt;enumeration value="jyutping"/&gt;
 *     &lt;enumeration value="kkcor"/&gt;
 *     &lt;enumeration value="kscor"/&gt;
 *     &lt;enumeration value="laukika"/&gt;
 *     &lt;enumeration value="lipaw"/&gt;
 *     &lt;enumeration value="luna1918"/&gt;
 *     &lt;enumeration value="metelko"/&gt;
 *     &lt;enumeration value="monoton"/&gt;
 *     &lt;enumeration value="ndyuka"/&gt;
 *     &lt;enumeration value="nedis"/&gt;
 *     &lt;enumeration value="njiva"/&gt;
 *     &lt;enumeration value="nulik"/&gt;
 *     &lt;enumeration value="osojs"/&gt;
 *     &lt;enumeration value="pamaka"/&gt;
 *     &lt;enumeration value="petr1708"/&gt;
 *     &lt;enumeration value="pinyin"/&gt;
 *     &lt;enumeration value="polyton"/&gt;
 *     &lt;enumeration value="puter"/&gt;
 *     &lt;enumeration value="rigik"/&gt;
 *     &lt;enumeration value="rozaj"/&gt;
 *     &lt;enumeration value="rumgr"/&gt;
 *     &lt;enumeration value="scotland"/&gt;
 *     &lt;enumeration value="scouse"/&gt;
 *     &lt;enumeration value="solba"/&gt;
 *     &lt;enumeration value="sotav"/&gt;
 *     &lt;enumeration value="surmiran"/&gt;
 *     &lt;enumeration value="sursilv"/&gt;
 *     &lt;enumeration value="sutsilv"/&gt;
 *     &lt;enumeration value="tarask"/&gt;
 *     &lt;enumeration value="uccor"/&gt;
 *     &lt;enumeration value="ucrcor"/&gt;
 *     &lt;enumeration value="ulster"/&gt;
 *     &lt;enumeration value="unifon"/&gt;
 *     &lt;enumeration value="vaidika"/&gt;
 *     &lt;enumeration value="valencia"/&gt;
 *     &lt;enumeration value="vallader"/&gt;
 *     &lt;enumeration value="wadegile"/&gt;
 *   &lt;/restriction&gt;
 * &lt;/simpleType&gt;
 * </pre>
 * 
 */
@XmlType(name = "variantIdType")
@XmlEnum
public enum VariantIdType {


    /**
     *  16th century French as in Jean Nicot, "Thresor de la langue francoyse", 1606, but also including some French similar to that of Rabelais
     * 
     */
    @XmlEnumValue("1606nict")
    V1606NICT("1606nict"),

    /**
     * Romanizations recommended by the American Library Association and the Library of Congress, in "ALA-LC Romanization Tables: Transliteration Schemes for Non-Roman Scripts" (1997), ISBN 978-0-8444-0940-5.
     * 
     */
    @XmlEnumValue("alalc97")
    ALALC_97("alalc97"),
    @XmlEnumValue("fonipa")
    FONIPA("fonipa"),
    @XmlEnumValue("fonupa")
    FONUPA("fonupa"),

    /**
     * Indicates that the content is transcribed according to X-SAMPA
     * 
     */
    @XmlEnumValue("fonxsamp")
    FONXSAMP("fonxsamp"),

    /**
     *  17th century French, as catalogued in the "Dictionnaire de l'acadιmie franηoise", 4eme ed. 1694; frequently includes elements of Middle French, as this is a transitional period
     * 
     */
    @XmlEnumValue("1694acad")
    V1694ACAD("1694acad"),
    @XmlEnumValue("1901")
    V1901("1901"),
    @XmlEnumValue("1959acad")
    V1959ACAD("1959acad"),

    /**
     * For standardized Resian an orthography was published in 1994.
     * 
     */
    @XmlEnumValue("1994")
    V1994("1994"),
    @XmlEnumValue("1996")
    V1996("1996"),

    /**
     * Aluku dialect of the "Busi Nenge Tongo" English-based Creole continuum in Eastern Suriname and Western French Guiana
     * 
     */
    @XmlEnumValue("aluku")
    ALUKU("aluku"),
    @XmlEnumValue("arevela")
    AREVELA("arevela"),
    @XmlEnumValue("arevmda")
    AREVMDA("arevmda"),

    /**
     * Denotes alphabet used in Turkic republics/regions of the former USSR in late 1920s, and throughout 1930s, which aspired to represent equivalent phonemes in a unified fashion. Also known as: New Turkic Alphabet; Birl\u04d9\u015fdirilmi\u015f Jeni Tyrk \u04d8lifbas\u044c (Birlesdirilmis Jeni Tyrk Elifbasi); Ja\u014balif (Janalif).
     * 
     */
    @XmlEnumValue("baku1926")
    BAKU_1926("baku1926"),

    /**
     * Balanka is one of 19 Anii dialects.
     * 
     */
    @XmlEnumValue("balanka")
    BALANKA("balanka"),

    /**
     * Barlavento is one of the two main dialect groups of Kabuverdianu.
     * 
     */
    @XmlEnumValue("barla")
    BARLA("barla"),
    @XmlEnumValue("bauddha")
    BAUDDHA("bauddha"),
    @XmlEnumValue("biscayan")
    BISCAYAN("biscayan"),

    /**
     * The dialect of San Giorgio/Bila is one of the four major local   dialects of Resian
     * 
     */
    @XmlEnumValue("biske")
    BISKE("biske"),

    /**
     * The subtag represents the alphabet codified by Adam Bohori\u010d in 1584 and used from the first printed Slovene book and up to the mid-19th century.
     * 
     */
    @XmlEnumValue("bohoric")
    BOHORIC("bohoric"),

    /**
     * Jargon embedded in American English
     * 
     */
    @XmlEnumValue("boont")
    BOONT("boont"),

    /**
     * The subtag represents the alphabet codified by Peter Dajnko and used from 1824 to 1839 mostly in Styria (in what is now Eastern Slovenia).
     * 
     */
    @XmlEnumValue("dajnko")
    DAJNKO("dajnko"),
    @XmlEnumValue("ekavsk")
    EKAVSK("ekavsk"),
    @XmlEnumValue("emodeng")
    EMODENG("emodeng"),
    @XmlEnumValue("hepburn")
    HEPBURN("hepburn"),

    /**
     * Norwegian following Ivar Aasen's orthographical principles, including modern usage.
     * 
     */
    @XmlEnumValue("hognorsk")
    HOGNORSK("hognorsk"),
    @XmlEnumValue("ijekavsk")
    IJEKAVSK("ijekavsk"),
    @XmlEnumValue("itihasa")
    ITIHASA("itihasa"),

    /**
     * The spoken dialect of the Val Mόstair, which has no written standard.
     * 
     */
    @XmlEnumValue("jauer")
    JAUER("jauer"),

    /**
     * Jyutping romanization of Cantonese
     * 
     */
    @XmlEnumValue("jyutping")
    JYUTPING("jyutping"),
    @XmlEnumValue("kkcor")
    KKCOR("kkcor"),
    @XmlEnumValue("kscor")
    KSCOR("kscor"),
    @XmlEnumValue("laukika")
    LAUKIKA("laukika"),

    /**
     * The dialect of Lipovaz/Lipovec is one of the minor local dialects of Resian
     * 
     */
    @XmlEnumValue("lipaw")
    LIPAW("lipaw"),

    /**
     * Russian orthography as established by the 1917/1918 orthographic reforms
     * 
     */
    @XmlEnumValue("luna1918")
    LUNA_1918("luna1918"),

    /**
     * The subtag represents the alphabet codified by Franc Serafin Metelko and used from 1825 to 1833.
     * 
     */
    @XmlEnumValue("metelko")
    METELKO("metelko"),
    @XmlEnumValue("monoton")
    MONOTON("monoton"),

    /**
     * Ndyuka dialect of the "Busi Nenge Tongo" English-based Creole continuum in Eastern Suriname and Western French Guiana
     * 
     */
    @XmlEnumValue("ndyuka")
    NDYUKA("ndyuka"),
    @XmlEnumValue("nedis")
    NEDIS("nedis"),
    @XmlEnumValue("njiva")
    NJIVA("njiva"),
    @XmlEnumValue("nulik")
    NULIK("nulik"),

    /**
     * The dialect of Oseacco/Osojane is one of the four major local dialects of Resian
     * 
     */
    @XmlEnumValue("osojs")
    OSOJS("osojs"),

    /**
     * Pamaka dialect of the "Busi Nenge Tongo" English-based Creole continuum in Eastern Suriname and Western French Guiana
     * 
     */
    @XmlEnumValue("pamaka")
    PAMAKA("pamaka"),

    /**
     * Russian orthography from the Petrine orthographic reforms of 1708 to the 1917 orthographic reform
     * 
     */
    @XmlEnumValue("petr1708")
    PETR_1708("petr1708"),
    @XmlEnumValue("pinyin")
    PINYIN("pinyin"),
    @XmlEnumValue("polyton")
    POLYTON("polyton"),

    /**
     * Puter is one of the five traditional written standards or "idioms" of the Romansh language.
     * 
     */
    @XmlEnumValue("puter")
    PUTER("puter"),
    @XmlEnumValue("rigik")
    RIGIK("rigik"),
    @XmlEnumValue("rozaj")
    ROZAJ("rozaj"),

    /**
     * Supraregional Romansh written standard
     * 
     */
    @XmlEnumValue("rumgr")
    RUMGR("rumgr"),
    @XmlEnumValue("scotland")
    SCOTLAND("scotland"),

    /**
     * English Liverpudlian dialect known as 'Scouse'
     * 
     */
    @XmlEnumValue("scouse")
    SCOUSE("scouse"),

    /**
     * The dialect of Stolvizza/Solbica is one of the four major local dialects of Resian
     * 
     */
    @XmlEnumValue("solba")
    SOLBA("solba"),

    /**
     * Sotavento is one of the two main dialect groups of Kabuverdianu.
     * 
     */
    @XmlEnumValue("sotav")
    SOTAV("sotav"),

    /**
     * Surmiran is one of the five traditional written standards or "idioms" of the Romansh language.
     * 
     */
    @XmlEnumValue("surmiran")
    SURMIRAN("surmiran"),

    /**
     * Sursilvan is one of the five traditional written standards or "idioms" of the Romansh language.
     * 
     */
    @XmlEnumValue("sursilv")
    SURSILV("sursilv"),

    /**
     * Sutsilvan is one of the five traditional written standards or "idioms" of the Romansh language.
     * 
     */
    @XmlEnumValue("sutsilv")
    SUTSILV("sutsilv"),

    /**
     * The subtag represents Branislau Taraskievic's Belarusian orthography as published in "Bielaruski klasycny pravapis" by Juras Buslakou, Vincuk Viacorka, Zmicier Sanko, and Zmicier Sauka (Vilnia-Miensk 2005).
     * 
     */
    @XmlEnumValue("tarask")
    TARASK("tarask"),
    @XmlEnumValue("uccor")
    UCCOR("uccor"),
    @XmlEnumValue("ucrcor")
    UCRCOR("ucrcor"),
    @XmlEnumValue("ulster")
    ULSTER("ulster"),
    @XmlEnumValue("unifon")
    UNIFON("unifon"),

    /**
     * The most ancient dialect of Sanskrit used in verse and prose composed until about the 4th century B.C.E.
     * 
     */
    @XmlEnumValue("vaidika")
    VAIDIKA("vaidika"),

    /**
     * Variety spoken in the "Comunidad Valenciana" region of Spain, where it is co-official with Spanish.
     * 
     */
    @XmlEnumValue("valencia")
    VALENCIA("valencia"),

    /**
     * Vallader is one of the five traditional written standards or "idioms" of the Romansh language.
     * 
     */
    @XmlEnumValue("vallader")
    VALLADER("vallader"),
    @XmlEnumValue("wadegile")
    WADEGILE("wadegile");
    private final String value;

    VariantIdType(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static VariantIdType fromValue(String v) {
        for (VariantIdType c: VariantIdType.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
