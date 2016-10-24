
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
 *     &lt;enumeration value="anaphoraResolution"/&gt;
 *     &lt;enumeration value="chunking"/&gt;
 *     &lt;enumeration value="parsing"/&gt;
 *     &lt;enumeration value="npRecognition"/&gt;
 *     &lt;enumeration value="titlesParsing"/&gt;
 *     &lt;enumeration value="definitionsParsing"/&gt;
 *     &lt;enumeration value="analysis"/&gt;
 *     &lt;enumeration value="generation"/&gt;
 *     &lt;enumeration value="other"/&gt;
 *   &lt;/restriction&gt;
 * &lt;/simpleType&gt;
 * </pre>
 * 
 */
@XmlType(name = "")
@XmlEnum
public enum TaskEnum {


    /**
     * Value for task; for grammars used for anaphora resolution
     * 
     */
    @XmlEnumValue("anaphoraResolution")
    ANAPHORA_RESOLUTION("anaphoraResolution"),

    /**
     * Value for task; for grammars used for chunking (shallow syntactic parsing)
     * 
     */
    @XmlEnumValue("chunking")
    CHUNKING("chunking"),

    /**
     * Value for task; for grammars used for parsing
     * 
     */
    @XmlEnumValue("parsing")
    PARSING("parsing"),

    /**
     * Value for task; for grammars used for identifying noun phrases
     * 
     */
    @XmlEnumValue("npRecognition")
    NP_RECOGNITION("npRecognition"),

    /**
     * Value for task; for grammars that are restricted to parsing titles
     * 
     */
    @XmlEnumValue("titlesParsing")
    TITLES_PARSING("titlesParsing"),

    /**
     * Value for task; for grammars that are restricted to parsing definitions
     * 
     */
    @XmlEnumValue("definitionsParsing")
    DEFINITIONS_PARSING("definitionsParsing"),

    /**
     * Value for task; for grammars used for analysis tasks
     * 
     */
    @XmlEnumValue("analysis")
    ANALYSIS("analysis"),

    /**
     * Value for task; for grammars used for language generation
     * 
     */
    @XmlEnumValue("generation")
    GENERATION("generation"),
    @XmlEnumValue("other")
    OTHER("other");
    private final String value;

    TaskEnum(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static TaskEnum fromValue(String v) {
        for (TaskEnum c: TaskEnum.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
