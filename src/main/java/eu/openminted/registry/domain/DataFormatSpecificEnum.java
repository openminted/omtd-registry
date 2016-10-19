
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
 *     &lt;enumeration value="aclAnthology"/&gt;
 *     &lt;enumeration value="alvisEnrichedDocument"/&gt;
 *     &lt;enumeration value="bnc"/&gt;
 *     &lt;enumeration value="bioNLP"/&gt;
 *     &lt;enumeration value="bioNLP; format-variant=ST2013a1_a2"/&gt;
 *     &lt;enumeration value="cadixeJSON"/&gt;
 *     &lt;enumeration value="conll2000"/&gt;
 *     &lt;enumeration value="conll2002"/&gt;
 *     &lt;enumeration value="conll2006"/&gt;
 *     &lt;enumeration value="conll2007"/&gt;
 *     &lt;enumeration value="conll2009"/&gt;
 *     &lt;enumeration value="conll2012"/&gt;
 *     &lt;enumeration value="dataSift"/&gt;
 *     &lt;enumeration value="factoredTagLem"/&gt;
 *     &lt;enumeration value="gate"/&gt;
 *     &lt;enumeration value="genia"/&gt;
 *     &lt;enumeration value="graf"/&gt;
 *     &lt;enumeration value="html5Microdata"/&gt;
 *     &lt;enumeration value="i2b2"/&gt;
 *     &lt;enumeration value="imsCwb"/&gt;
 *     &lt;enumeration value="jdbc"/&gt;
 *     &lt;enumeration value="keaCorpus"/&gt;
 *     &lt;enumeration value="lll"/&gt;
 *     &lt;enumeration value="lll"/&gt;
 *     &lt;enumeration value="lll"/&gt;
 *     &lt;enumeration value="lll"/&gt;
 *     &lt;enumeration value="lll"/&gt;
 *     &lt;enumeration value="lll"/&gt;
 *     &lt;enumeration value="negraExport"/&gt;
 *     &lt;enumeration value="ptb; format-variant=chunked"/&gt;
 *     &lt;enumeration value="ptb; format-variant=combined"/&gt;
 *     &lt;enumeration value="pml"/&gt;
 *     &lt;enumeration value="relp"/&gt;
 *     &lt;enumeration value="aimedCorpus"/&gt;
 *     &lt;enumeration value="tiger"/&gt;
 *     &lt;enumeration value="tupp-dz"/&gt;
 *     &lt;enumeration value="twitter"/&gt;
 *     &lt;enumeration value="xces; format-variant=ilsp"/&gt;
 *     &lt;enumeration value="web1t"/&gt;
 *     &lt;enumeration value="uimaCASDump"/&gt;
 *     &lt;enumeration value="uimaBinaryCas"/&gt;
 *   &lt;/restriction&gt;
 * &lt;/simpleType&gt;
 * </pre>
 * 
 */
@XmlType(name = "")
@XmlEnum
public enum DataFormatSpecificEnum {

    @XmlEnumValue("aclAnthology")
    ACL_ANTHOLOGY("aclAnthology"),
    @XmlEnumValue("alvisEnrichedDocument")
    ALVIS_ENRICHED_DOCUMENT("alvisEnrichedDocument"),
    @XmlEnumValue("bnc")
    BNC("bnc"),
    @XmlEnumValue("bioNLP")
    BIO_NLP("bioNLP"),
    @XmlEnumValue("bioNLP; format-variant=ST2013a1_a2")
    BIONLP_FORMAT_VARIANT_ST2013A1_A2("bioNLP; format-variant=ST2013a1_a2"),
    @XmlEnumValue("cadixeJSON")
    CADIXE_JSON("cadixeJSON"),
    @XmlEnumValue("conll2000")
    CONLL_2000("conll2000"),
    @XmlEnumValue("conll2002")
    CONLL_2002("conll2002"),
    @XmlEnumValue("conll2006")
    CONLL_2006("conll2006"),
    @XmlEnumValue("conll2007")
    CONLL_2007("conll2007"),
    @XmlEnumValue("conll2009")
    CONLL_2009("conll2009"),
    @XmlEnumValue("conll2012")
    CONLL_2012("conll2012"),
    @XmlEnumValue("dataSift")
    DATA_SIFT("dataSift"),
    @XmlEnumValue("factoredTagLem")
    FACTORED_TAG_LEM("factoredTagLem"),
    @XmlEnumValue("gate")
    GATE("gate"),
    @XmlEnumValue("genia")
    GENIA("genia"),
    @XmlEnumValue("graf")
    GRAF("graf"),
    @XmlEnumValue("html5Microdata")
    HTML_5_MICRODATA("html5Microdata"),
    @XmlEnumValue("i2b2")
    I_2_B_2("i2b2"),
    @XmlEnumValue("imsCwb")
    IMS_CWB("imsCwb"),
    @XmlEnumValue("jdbc")
    JDBC("jdbc"),
    @XmlEnumValue("keaCorpus")
    KEA_CORPUS("keaCorpus"),
    @XmlEnumValue("lll")
    LLL("lll"),
    @XmlEnumValue("negraExport")
    NEGRA_EXPORT("negraExport"),
    @XmlEnumValue("ptb; format-variant=chunked")
    PTB_FORMAT_VARIANT_CHUNKED("ptb; format-variant=chunked"),
    @XmlEnumValue("ptb; format-variant=combined")
    PTB_FORMAT_VARIANT_COMBINED("ptb; format-variant=combined"),
    @XmlEnumValue("pml")
    PML("pml"),
    @XmlEnumValue("relp")
    RELP("relp"),
    @XmlEnumValue("aimedCorpus")
    AIMED_CORPUS("aimedCorpus"),
    @XmlEnumValue("tiger")
    TIGER("tiger"),
    @XmlEnumValue("tupp-dz")
    TUPP_DZ("tupp-dz"),
    @XmlEnumValue("twitter")
    TWITTER("twitter"),
    @XmlEnumValue("xces; format-variant=ilsp")
    XCES_FORMAT_VARIANT_ILSP("xces; format-variant=ilsp"),
    @XmlEnumValue("web1t")
    WEB_1_T("web1t"),
    @XmlEnumValue("uimaCASDump")
    UIMA_CAS_DUMP("uimaCASDump"),
    @XmlEnumValue("uimaBinaryCas")
    UIMA_BINARY_CAS("uimaBinaryCas");
    private final String value;

    DataFormatSpecificEnum(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static DataFormatSpecificEnum fromValue(String v) {
        for (DataFormatSpecificEnum c: DataFormatSpecificEnum.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
