
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
 *     &lt;enumeration value="bodyGesture"/&gt;
 *     &lt;enumeration value="facialExpression"/&gt;
 *     &lt;enumeration value="voice"/&gt;
 *     &lt;enumeration value="combinationOfModalities"/&gt;
 *     &lt;enumeration value="signLanguage"/&gt;
 *     &lt;enumeration value="spokenLanguage"/&gt;
 *     &lt;enumeration value="writtenLanguage"/&gt;
 *     &lt;enumeration value="other"/&gt;
 *   &lt;/restriction&gt;
 * &lt;/simpleType&gt;
 * </pre>
 * 
 */
@XmlType(name = "")
@XmlEnum
public enum ModalityTypeEnum {

    @XmlEnumValue("bodyGesture")
    BODY_GESTURE("bodyGesture"),
    @XmlEnumValue("facialExpression")
    FACIAL_EXPRESSION("facialExpression"),
    @XmlEnumValue("voice")
    VOICE("voice"),
    @XmlEnumValue("combinationOfModalities")
    COMBINATION_OF_MODALITIES("combinationOfModalities"),
    @XmlEnumValue("signLanguage")
    SIGN_LANGUAGE("signLanguage"),
    @XmlEnumValue("spokenLanguage")
    SPOKEN_LANGUAGE("spokenLanguage"),
    @XmlEnumValue("writtenLanguage")
    WRITTEN_LANGUAGE("writtenLanguage"),
    @XmlEnumValue("other")
    OTHER("other");
    private final String value;

    ModalityTypeEnum(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static ModalityTypeEnum fromValue(String v) {
        for (ModalityTypeEnum c: ModalityTypeEnum.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
