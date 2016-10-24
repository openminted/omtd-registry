
package eu.openminted.registry.domain;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for conformanceToStandardsBestPractices.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="conformanceToStandardsBestPractices"&gt;
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *     &lt;maxLength value="100"/&gt;
 *     &lt;enumeration value="AgroVoc"/&gt;
 *     &lt;enumeration value="ALVIS"/&gt;
 *     &lt;enumeration value="ARGO"/&gt;
 *     &lt;enumeration value="BML"/&gt;
 *     &lt;enumeration value="CES"/&gt;
 *     &lt;enumeration value="DKPro_Core"/&gt;
 *     &lt;enumeration value="EAGLES"/&gt;
 *     &lt;enumeration value="EDAMontology"/&gt;
 *     &lt;enumeration value="ELSST"/&gt;
 *     &lt;enumeration value="EML"/&gt;
 *     &lt;enumeration value="EMMA"/&gt;
 *     &lt;enumeration value="GATE"/&gt;
 *     &lt;enumeration value="GESIS"/&gt;
 *     &lt;enumeration value="GMX"/&gt;
 *     &lt;enumeration value="GrAF"/&gt;
 *     &lt;enumeration value="HamNoSys"/&gt;
 *     &lt;enumeration value="HASSET"/&gt;
 *     &lt;enumeration value="InkML"/&gt;
 *     &lt;enumeration value="ILSP_NLP"/&gt;
 *     &lt;enumeration value="ISO12620"/&gt;
 *     &lt;enumeration value="ISO16642"/&gt;
 *     &lt;enumeration value="ISO1987"/&gt;
 *     &lt;enumeration value="ISO26162"/&gt;
 *     &lt;enumeration value="ISO30042"/&gt;
 *     &lt;enumeration value="ISO704"/&gt;
 *     &lt;enumeration value="JATS"/&gt;
 *     &lt;enumeration value="LAF"/&gt;
 *     &lt;enumeration value="LAPPS"/&gt;
 *     &lt;enumeration value="Lemon"/&gt;
 *     &lt;enumeration value="LMF"/&gt;
 *     &lt;enumeration value="MAF"/&gt;
 *     &lt;enumeration value="MLIF"/&gt;
 *     &lt;enumeration value="MOSES"/&gt;
 *     &lt;enumeration value="MULTEXT"/&gt;
 *     &lt;enumeration value="MUMIN"/&gt;
 *     &lt;enumeration value="multimodalInteractionFramework"/&gt;
 *     &lt;enumeration value="OAXAL"/&gt;
 *     &lt;enumeration value="OLIA"/&gt;
 *     &lt;enumeration value="OWL"/&gt;
 *     &lt;enumeration value="PANACEA"/&gt;
 *     &lt;enumeration value="pennTreeBank"/&gt;
 *     &lt;enumeration value="pragueTreebank"/&gt;
 *     &lt;enumeration value="RDF"/&gt;
 *     &lt;enumeration value="SemAF"/&gt;
 *     &lt;enumeration value="SemAF_DA"/&gt;
 *     &lt;enumeration value="SemAF_NE"/&gt;
 *     &lt;enumeration value="SemAF_SRL"/&gt;
 *     &lt;enumeration value="SemAF_DS"/&gt;
 *     &lt;enumeration value="SKOS"/&gt;
 *     &lt;enumeration value="SRX"/&gt;
 *     &lt;enumeration value="SynAF"/&gt;
 *     &lt;enumeration value="TBX"/&gt;
 *     &lt;enumeration value="TMX"/&gt;
 *     &lt;enumeration value="TEI"/&gt;
 *     &lt;enumeration value="TEI_P3"/&gt;
 *     &lt;enumeration value="TEI_P4"/&gt;
 *     &lt;enumeration value="TEI_P5"/&gt;
 *     &lt;enumeration value="TimeML"/&gt;
 *     &lt;enumeration value="XCES"/&gt;
 *     &lt;enumeration value="XLIFF"/&gt;
 *     &lt;enumeration value="UD"/&gt;
 *     &lt;enumeration value="WordNet"/&gt;
 *     &lt;enumeration value="other"/&gt;
 *   &lt;/restriction&gt;
 * &lt;/simpleType&gt;
 * </pre>
 * 
 */
@XmlType(name = "conformanceToStandardsBestPractices")
@XmlEnum
public enum ConformanceToStandardsBestPractices {

    @XmlEnumValue("AgroVoc")
    AGRO_VOC("AgroVoc"),
    ALVIS("ALVIS"),
    ARGO("ARGO"),
    BML("BML"),
    CES("CES"),
    @XmlEnumValue("DKPro_Core")
    DK_PRO_CORE("DKPro_Core"),
    EAGLES("EAGLES"),
    @XmlEnumValue("EDAMontology")
    EDA_MONTOLOGY("EDAMontology"),
    ELSST("ELSST"),
    EML("EML"),
    EMMA("EMMA"),
    GATE("GATE"),
    GESIS("GESIS"),
    GMX("GMX"),
    @XmlEnumValue("GrAF")
    GR_AF("GrAF"),
    @XmlEnumValue("HamNoSys")
    HAM_NO_SYS("HamNoSys"),
    HASSET("HASSET"),
    @XmlEnumValue("InkML")
    INK_ML("InkML"),
    ILSP_NLP("ILSP_NLP"),
    @XmlEnumValue("ISO12620")
    ISO_12620("ISO12620"),
    @XmlEnumValue("ISO16642")
    ISO_16642("ISO16642"),
    @XmlEnumValue("ISO1987")
    ISO_1987("ISO1987"),
    @XmlEnumValue("ISO26162")
    ISO_26162("ISO26162"),
    @XmlEnumValue("ISO30042")
    ISO_30042("ISO30042"),
    @XmlEnumValue("ISO704")
    ISO_704("ISO704"),
    JATS("JATS"),
    LAF("LAF"),
    LAPPS("LAPPS"),
    @XmlEnumValue("Lemon")
    LEMON("Lemon"),
    LMF("LMF"),
    MAF("MAF"),
    MLIF("MLIF"),
    MOSES("MOSES"),
    MULTEXT("MULTEXT"),
    MUMIN("MUMIN"),
    @XmlEnumValue("multimodalInteractionFramework")
    MULTIMODAL_INTERACTION_FRAMEWORK("multimodalInteractionFramework"),
    OAXAL("OAXAL"),
    OLIA("OLIA"),
    OWL("OWL"),
    PANACEA("PANACEA"),
    @XmlEnumValue("pennTreeBank")
    PENN_TREE_BANK("pennTreeBank"),
    @XmlEnumValue("pragueTreebank")
    PRAGUE_TREEBANK("pragueTreebank"),
    RDF("RDF"),
    @XmlEnumValue("SemAF")
    SEM_AF("SemAF"),
    @XmlEnumValue("SemAF_DA")
    SEM_AF_DA("SemAF_DA"),
    @XmlEnumValue("SemAF_NE")
    SEM_AF_NE("SemAF_NE"),
    @XmlEnumValue("SemAF_SRL")
    SEM_AF_SRL("SemAF_SRL"),
    @XmlEnumValue("SemAF_DS")
    SEM_AF_DS("SemAF_DS"),
    SKOS("SKOS"),
    SRX("SRX"),
    @XmlEnumValue("SynAF")
    SYN_AF("SynAF"),
    TBX("TBX"),
    TMX("TMX"),
    TEI("TEI"),
    @XmlEnumValue("TEI_P3")
    TEI_P_3("TEI_P3"),
    @XmlEnumValue("TEI_P4")
    TEI_P_4("TEI_P4"),
    @XmlEnumValue("TEI_P5")
    TEI_P_5("TEI_P5"),
    @XmlEnumValue("TimeML")
    TIME_ML("TimeML"),
    XCES("XCES"),
    XLIFF("XLIFF"),
    UD("UD"),
    @XmlEnumValue("WordNet")
    WORD_NET("WordNet"),
    @XmlEnumValue("other")
    OTHER("other");
    private final String value;

    ConformanceToStandardsBestPractices(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static ConformanceToStandardsBestPractices fromValue(String v) {
        for (ConformanceToStandardsBestPractices c: ConformanceToStandardsBestPractices.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
