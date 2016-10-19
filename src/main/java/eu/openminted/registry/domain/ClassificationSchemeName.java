
package eu.openminted.registry.domain;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for classificationSchemeName.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="classificationSchemeName"&gt;
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *     &lt;enumeration value="DDC"/&gt;
 *     &lt;enumeration value="UDC"/&gt;
 *     &lt;enumeration value="EuroVoc"/&gt;
 *     &lt;enumeration value="LCSH"/&gt;
 *     &lt;enumeration value="DK-5"/&gt;
 *     &lt;enumeration value="MeSH"/&gt;
 *     &lt;enumeration value="ANC_classification"/&gt;
 *     &lt;enumeration value="BNC_classification"/&gt;
 *     &lt;enumeration value="NLK_classification"/&gt;
 *     &lt;enumeration value="PAROLE_topicClassification"/&gt;
 *     &lt;enumeration value="PAROLE_genreClassification"/&gt;
 *     &lt;enumeration value="other"/&gt;
 *   &lt;/restriction&gt;
 * &lt;/simpleType&gt;
 * </pre>
 * 
 */
@XmlType(name = "classificationSchemeName")
@XmlEnum
public enum ClassificationSchemeName {


    /**
     * Dewey Decimal Classification system; https://www.oclc.org/dewey.en.html
     * 
     */
    DDC("DDC"),

    /**
     * Universal Decimal Classification system; for the Linked Data version, cf. http://udcdata.info/
     * 
     */
    UDC("UDC"),

    /**
     * EuroVoc, the EU's multilingual thesaurus; various downloadable versions at http://data.europa.eu/euodp/en/data/dataset/eurovoc
     * 
     */
    @XmlEnumValue("EuroVoc")
    EURO_VOC("EuroVoc"),

    /**
     * Library of Congress Subject Headings; cf. http://id.loc.gov/authorities/subjects.html
     * 
     */
    LCSH("LCSH"),

    /**
     * DK-5; Linked Data version at https://opensource.dbc.dk/linked-data/dk5-linked-data
     * 
     */
    @XmlEnumValue("DK-5")
    DK_5("DK-5"),

    /**
     * Medical Subject Headlings; downloadable versions at https://www.nlm.nih.gov/mesh/download_mesh.html
     * 
     */
    @XmlEnumValue("MeSH")
    ME_SH("MeSH"),

    /**
     * American National Corpus controlled vocabulary for text classification; cf. http://www.anc.org/
     * 
     */
    @XmlEnumValue("ANC_classification")
    ANC_CLASSIFICATION("ANC_classification"),

    /**
     * British National Corpus controlled vocabulary for text classification; cf. http://www.natcorp.ox.ac.uk/docs/URG/ subsections on selection and descriptive features
     * 
     */
    @XmlEnumValue("BNC_classification")
    BNC_CLASSIFICATION("BNC_classification"),
    @XmlEnumValue("NLK_classification")
    NLK_CLASSIFICATION("NLK_classification"),

    /**
     * Parole topic classification system; used for the consistent classification of text corpora in the LE-PAROLE project
     * 
     */
    @XmlEnumValue("PAROLE_topicClassification")
    PAROLE_TOPIC_CLASSIFICATION("PAROLE_topicClassification"),

    /**
     * Parole genre classification system; used for the consistent classification of text corpora in the LE-PAROLE project
     * 
     */
    @XmlEnumValue("PAROLE_genreClassification")
    PAROLE_GENRE_CLASSIFICATION("PAROLE_genreClassification"),
    @XmlEnumValue("other")
    OTHER("other");
    private final String value;

    ClassificationSchemeName(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static ClassificationSchemeName fromValue(String v) {
        for (ClassificationSchemeName c: ClassificationSchemeName.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
