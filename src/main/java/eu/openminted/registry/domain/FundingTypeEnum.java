
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
 *     &lt;enumeration value="other"/&gt;
 *     &lt;enumeration value="ownFunds"/&gt;
 *     &lt;enumeration value="nationalFunds"/&gt;
 *     &lt;enumeration value="euFunds"/&gt;
 *   &lt;/restriction&gt;
 * &lt;/simpleType&gt;
 * </pre>
 * 
 */
@XmlType(name = "")
@XmlEnum
public enum FundingTypeEnum {


    /**
     * When none of the above is applicable
     * 
     */
    @XmlEnumValue("other")
    OTHER("other"),

    /**
     * Funding from the resource creators’s own sources
     * 
     */
    @XmlEnumValue("ownFunds")
    OWN_FUNDS("ownFunds"),

    /**
     * Funding coming from national sources
     * 
     */
    @XmlEnumValue("nationalFunds")
    NATIONAL_FUNDS("nationalFunds"),

    /**
     * Funding coming from EU sources
     * 
     */
    @XmlEnumValue("euFunds")
    EU_FUNDS("euFunds");
    private final String value;

    FundingTypeEnum(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static FundingTypeEnum fromValue(String v) {
        for (FundingTypeEnum c: FundingTypeEnum.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
