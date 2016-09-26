package eu.openminted.registry.domain;

import javax.xml.bind.annotation.adapters.XmlAdapter;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

/**
 * @author Steve
 *
 */
@XmlJavaTypeAdapter(ConformanceToStandardsBestPracticesAdapter.class)
public enum ConformanceToStandardsBestPractices {

	AGROVOC("agrovoc"),
	ALVIS("alvis"),
	ARGO("argo"),
	BML("bml"),
	CES("ces"),
	DKPRO_CORE("dkpro_core"),
	EAGLES("eagles"),
	EDAMONTOLOGY("edamontology"),
	ELSST("elsst"),
	EML("eml"),
	EMMA("emma"),
	GATE("gate"),
	GESIS("gesis"),
	GMX("gmx"),
	GRAF("graf"),
	HAMNOSYS("hamnosys"),
	HASSET("hasset"),
	INKML("inkml"),
	ILSP_NLP("ilsp_nlp"),
	ISO12620("iso12620"),
	ISO16642("iso16642"),
	ISO1987("iso1987"),
	ISO26162("iso26162"),
	ISO30042("iso30042"),
	ISO704("iso704"),
	JATS("jats"),
	LAF("laf"),
	LAPPS("lapps"),
	LEMON("lemon"),
	LMF("lmf"),
	MAF("maf"),
	MLIF("mlif"),
	MOSES("moses"),
	MULTEXT("multext"),
	MUMIN("mumin"),
	MULTIMODALINTERACTIONFRAMEWORK("multimodalinteractionframework"),
	OAXAL("oaxal"),
	OLIA("olia"),
	OWL("owl"),
	PANACEA("panacea"),
	PENNTREEBANK("penntreebank"),
	PRAGUETREEBANK("praguetreebank"),
	RDF("rdf"),
	SEMAF("semaf"),
	SEMAF_DA("semaf_da"),
	SEMAF_NE("semaf_ne"),
	SEMAF_SRL("semaf_srl"),
	SEMAF_DS("semaf_ds"),
	SKOS("skos"),
	SRX("srx"),
	SYNAF("synaf"),
	TBX("tbx"),
	TMX("tmx"),
	TEI("tei"),
	TEI_P3("tei_p3"),
	TEI_P4("tei_p4"),
	TEI_P5("tei_p5"),
	TIMEML("timeml"),
	XCES("xces"),
	XLIFF("xliff"),
	UD("ud"),
	WORDNET("wordnet"),
	OTHER("other");

    private String value;

    ConformanceToStandardsBestPractices(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public static ConformanceToStandardsBestPractices forValue(String value) {
        for (ConformanceToStandardsBestPractices ut: values()) {
            if (ut.getValue().equals(value))
                return ut;
        }

        return null;
    }
}

class ConformanceToStandardsBestPracticesAdapter extends XmlAdapter<String, ConformanceToStandardsBestPractices> {

    @Override
    public String marshal(ConformanceToStandardsBestPractices v) throws Exception {
        return v!=null?v.getValue():null;
    }

    @Override
    public ConformanceToStandardsBestPractices unmarshal(String v) throws Exception {
        return ConformanceToStandardsBestPractices.forValue(v);
    }
}

