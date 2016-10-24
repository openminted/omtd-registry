
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
 *     &lt;maxLength value="30"/&gt;
 *     &lt;enumeration value="clauseStructure"/&gt;
 *     &lt;enumeration value="ppAttachment"/&gt;
 *     &lt;enumeration value="npStructure"/&gt;
 *     &lt;enumeration value="coordination"/&gt;
 *     &lt;enumeration value="anaphora"/&gt;
 *     &lt;enumeration value="other"/&gt;
 *   &lt;/restriction&gt;
 * &lt;/simpleType&gt;
 * </pre>
 * 
 */
@XmlType(name = "")
@XmlEnum
public enum GrammaticalPhenomenaCoverageEnum {


    /**
     * Value for grammaticalPheonomenaCoverage; for grammars that can recognise the structure of clauses
     * 
     */
    @XmlEnumValue("clauseStructure")
    CLAUSE_STRUCTURE("clauseStructure"),

    /**
     * Value for grammaticalPheonomenaCoverage; for grammars that cover pp-attachment (attachment of prepositional phrases)
     * 
     */
    @XmlEnumValue("ppAttachment")
    PP_ATTACHMENT("ppAttachment"),

    /**
     * Value for grammaticalPheonomenaCoverage; for grammars that cover structure of noun phrases
     * 
     */
    @XmlEnumValue("npStructure")
    NP_STRUCTURE("npStructure"),

    /**
     * Value for grammaticalPheonomenaCoverage; for grammars that cover coordination
     * 
     */
    @XmlEnumValue("coordination")
    COORDINATION("coordination"),

    /**
     * Value for grammaticalPheonomenaCoverage; for grammars that cover anaphora problems
     * 
     */
    @XmlEnumValue("anaphora")
    ANAPHORA("anaphora"),
    @XmlEnumValue("other")
    OTHER("other");
    private final String value;

    GrammaticalPhenomenaCoverageEnum(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static GrammaticalPhenomenaCoverageEnum fromValue(String v) {
        for (GrammaticalPhenomenaCoverageEnum c: GrammaticalPhenomenaCoverageEnum.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
