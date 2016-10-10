package eu.openminted.registry.domain;

import javax.xml.bind.annotation.adapters.XmlAdapter;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

/**
 * @author Steve
 *
 */
@XmlJavaTypeAdapter(ConformanceToStandardsBestPracticesAdapter.class)
public enum ConformanceToStandardsBestPractices {

	AGROVOC("AgroVoc"),
	ALVIS("ALVIS"),
	ARGO("ARGO"),
	BML("BML"),
	CES("CES"),
	DKPRO_CORE("DKPro_Core"),
	EAGLES("EAGLES"),
	EDAMONTOLOGY("EDAMontology"),
	ELSST("ELSST"),
	EML("EML"),
	EMMA("EMMA"),
	GATE("GATE"),
	GESIS("GESIS"),
	GMX("GMX"),
	GRAF("GrAF"),
	HAMNOSYS("HamNoSys"),
	HASSET("HASSET"),
	INKML("InkML"),
	ILSP_NLP("ILSP_NLP"),
	ISO12620("ISO12620"),
	ISO16642("ISO16642"),
	ISO1987("ISO1987"),
	ISO26162("ISO26162"),
	ISO30042("ISO30042"),
	ISO704("ISO704"),
	JATS("JATS"),
	LAF("LAF"),
	LAPPS("LAPPS"),
	LEMON("Lemon"),
	LMF("LMF"),
	MAF("MAF"),
	MLIF("MLIF"),
	MOSES("MOSES"),
	MULTEXT("MULTEXT"),
	MUMIN("MUMIN"),
	MULTIMODALINTERACTIONFRAMEWORK("multimodalInteractionFramework"),
	OAXAL("OAXAL"),
	OLIA("OLIA"),
	OWL("OWL"),
	PANACEA("PANACEA"),
	PENNTREEBANK("pennTreeBank"),
	PRAGUETREEBANK("pragueTreebank"),
	RDF("RDF"),
	SEMAF("SemAF"),
	SEMAF_DA("SemAF_DA"),
	SEMAF_NE("SemAF_NE"),
	SEMAF_SRL("SemAF_SRL"),
	SEMAF_DS("SemAF_DS"),
	SKOS("SKOS"),
	SRX("SRX"),
	SYNAF("SynAF"),
	TBX("TBX"),
	TMX("TMX"),
	TEI("TEI"),
	TEI_P3("TEI_P3"),
	TEI_P4("TEI_P4"),
	TEI_P5("TEI_P5"),
	TIMEML("TimeML"),
	XCES("XCES"),
	XLIFF("XLIFF"),
	UD("UD"),
	WORDNET("WordNet"),
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

