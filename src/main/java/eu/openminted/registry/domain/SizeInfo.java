
package eu.openminted.registry.domain;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for sizeInfoType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="sizeInfoType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element ref="{http://www.meta-share.org/OMTD-SHARE_XMLSchema}size"/&gt;
 *         &lt;element name="sizeUnit"&gt;
 *           &lt;simpleType&gt;
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *               &lt;maxLength value="30"/&gt;
 *               &lt;enumeration value="terms"/&gt;
 *               &lt;enumeration value="entries"/&gt;
 *               &lt;enumeration value="turns"/&gt;
 *               &lt;enumeration value="utterances"/&gt;
 *               &lt;enumeration value="articles"/&gt;
 *               &lt;enumeration value="files"/&gt;
 *               &lt;enumeration value="items"/&gt;
 *               &lt;enumeration value="seconds"/&gt;
 *               &lt;enumeration value="elements"/&gt;
 *               &lt;enumeration value="units"/&gt;
 *               &lt;enumeration value="minutes"/&gt;
 *               &lt;enumeration value="hours"/&gt;
 *               &lt;enumeration value="texts"/&gt;
 *               &lt;enumeration value="sentences"/&gt;
 *               &lt;enumeration value="bytes"/&gt;
 *               &lt;enumeration value="tokens"/&gt;
 *               &lt;enumeration value="words"/&gt;
 *               &lt;enumeration value="keywords"/&gt;
 *               &lt;enumeration value="idiomaticExpressions"/&gt;
 *               &lt;enumeration value="triples"/&gt;
 *               &lt;enumeration value="neologisms"/&gt;
 *               &lt;enumeration value="multiWordUnits"/&gt;
 *               &lt;enumeration value="expressions"/&gt;
 *               &lt;enumeration value="synsets"/&gt;
 *               &lt;enumeration value="classes"/&gt;
 *               &lt;enumeration value="concepts"/&gt;
 *               &lt;enumeration value="lexicalTypes"/&gt;
 *               &lt;enumeration value="phoneticUnits"/&gt;
 *               &lt;enumeration value="syntacticUnits"/&gt;
 *               &lt;enumeration value="semanticUnits"/&gt;
 *               &lt;enumeration value="predicates"/&gt;
 *               &lt;enumeration value="phonemes"/&gt;
 *               &lt;enumeration value="diphones"/&gt;
 *               &lt;enumeration value="T-HPairs"/&gt;
 *               &lt;enumeration value="syllables"/&gt;
 *               &lt;enumeration value="frames"/&gt;
 *               &lt;enumeration value="images"/&gt;
 *               &lt;enumeration value="kb"/&gt;
 *               &lt;enumeration value="mb"/&gt;
 *               &lt;enumeration value="gb"/&gt;
 *               &lt;enumeration value="rb"/&gt;
 *               &lt;enumeration value="shots"/&gt;
 *               &lt;enumeration value="unigrams"/&gt;
 *               &lt;enumeration value="bigrams"/&gt;
 *               &lt;enumeration value="trigrams"/&gt;
 *               &lt;enumeration value="4-grams"/&gt;
 *               &lt;enumeration value="5-grams"/&gt;
 *               &lt;enumeration value="rules"/&gt;
 *               &lt;enumeration value="questions"/&gt;
 *               &lt;enumeration value="other"/&gt;
 *             &lt;/restriction&gt;
 *           &lt;/simpleType&gt;
 *         &lt;/element&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "sizeInfoType", propOrder = {
    "size",
    "sizeUnit"
})
public class SizeInfo {

    @XmlElement(required = true)
    protected String size;
    @XmlElement(required = true)
    protected SizeUnitEnum sizeUnit;

    /**
     * Gets the value of the size property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSize() {
        return size;
    }

    /**
     * Sets the value of the size property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSize(String value) {
        this.size = value;
    }

    /**
     * Gets the value of the sizeUnit property.
     * 
     * @return
     *     possible object is
     *     {@link SizeUnitEnum }
     *     
     */
    public SizeUnitEnum getSizeUnit() {
        return sizeUnit;
    }

    /**
     * Sets the value of the sizeUnit property.
     * 
     * @param value
     *     allowed object is
     *     {@link SizeUnitEnum }
     *     
     */
    public void setSizeUnit(SizeUnitEnum value) {
        this.sizeUnit = value;
    }

}
