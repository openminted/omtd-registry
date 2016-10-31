
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
 *     &lt;enumeration value="doi"/&gt;
 *     &lt;enumeration value="hdl"/&gt;
 *     &lt;enumeration value="ark"/&gt;
 *     &lt;enumeration value="arXiv"/&gt;
 *     &lt;enumeration value="bibcode"/&gt;
 *     &lt;enumeration value="ean13"/&gt;
 *     &lt;enumeration value="eissn"/&gt;
 *     &lt;enumeration value="isbn"/&gt;
 *     &lt;enumeration value="issn"/&gt;
 *     &lt;enumeration value="istc"/&gt;
 *     &lt;enumeration value="lissn"/&gt;
 *     &lt;enumeration value="lsid"/&gt;
 *     &lt;enumeration value="purl"/&gt;
 *     &lt;enumeration value="upc"/&gt;
 *     &lt;enumeration value="url"/&gt;
 *     &lt;enumeration value="urn"/&gt;
 *     &lt;enumeration value="fct"/&gt;
 *     &lt;enumeration value="oai"/&gt;
 *     &lt;enumeration value="pmc"/&gt;
 *     &lt;enumeration value="pmid"/&gt;
 *     &lt;enumeration value="other"/&gt;
 *   &lt;/restriction&gt;
 * &lt;/simpleType&gt;
 * </pre>
 * 
 */
@XmlType(name = "")
@XmlEnum
public enum PublicationIdentifierSchemeNameEnum {

    @XmlEnumValue("doi")
    DOI("doi"),
    @XmlEnumValue("hdl")
    HDL("hdl"),
    @XmlEnumValue("ark")
    ARK("ark"),
    @XmlEnumValue("arXiv")
    AR_XIV("arXiv"),
    @XmlEnumValue("bibcode")
    BIBCODE("bibcode"),
    @XmlEnumValue("ean13")
    EAN_13("ean13"),
    @XmlEnumValue("eissn")
    EISSN("eissn"),
    @XmlEnumValue("isbn")
    ISBN("isbn"),
    @XmlEnumValue("issn")
    ISSN("issn"),
    @XmlEnumValue("istc")
    ISTC("istc"),
    @XmlEnumValue("lissn")
    LISSN("lissn"),
    @XmlEnumValue("lsid")
    LSID("lsid"),
    @XmlEnumValue("purl")
    PURL("purl"),
    @XmlEnumValue("upc")
    UPC("upc"),
    @XmlEnumValue("url")
    URL("url"),
    @XmlEnumValue("urn")
    URN("urn"),
    @XmlEnumValue("fct")
    FCT("fct"),
    @XmlEnumValue("oai")
    OAI("oai"),
    @XmlEnumValue("pmc")
    PMC("pmc"),
    @XmlEnumValue("pmid")
    PMID("pmid"),
    @XmlEnumValue("other")
    OTHER("other");
    private final String value;

    PublicationIdentifierSchemeNameEnum(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static PublicationIdentifierSchemeNameEnum fromValue(String v) {
        for (PublicationIdentifierSchemeNameEnum c: PublicationIdentifierSchemeNameEnum.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
