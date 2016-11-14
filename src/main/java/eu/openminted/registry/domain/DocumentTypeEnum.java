
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
 *     &lt;enumeration value="bibliographicRecordOnly"/&gt;
 *     &lt;enumeration value="abstract"/&gt;
 *     &lt;enumeration value="fullText"/&gt;
 *   &lt;/restriction&gt;
 * &lt;/simpleType&gt;
 * </pre>
 * 
 */
@XmlType(name = "")
@XmlEnum
public enum DocumentTypeEnum {

    @XmlEnumValue("bibliographicRecordOnly")
    BIBLIOGRAPHIC_RECORD_ONLY("bibliographicRecordOnly"),
    @XmlEnumValue("abstract")
    ABSTRACT("abstract"),
    @XmlEnumValue("fullText")
    FULL_TEXT("fullText");
    private final String value;

    DocumentTypeEnum(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static DocumentTypeEnum fromValue(String v) {
        for (DocumentTypeEnum c: DocumentTypeEnum.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
