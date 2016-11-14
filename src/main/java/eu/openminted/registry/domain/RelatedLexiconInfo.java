
package eu.openminted.registry.domain;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for relatedLexiconInfoType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="relatedLexiconInfoType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="relatedLexiconType"&gt;
 *           &lt;simpleType&gt;
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *               &lt;maxLength value="30"/&gt;
 *               &lt;enumeration value="included"/&gt;
 *               &lt;enumeration value="attached"/&gt;
 *               &lt;enumeration value="compatible"/&gt;
 *               &lt;enumeration value="none"/&gt;
 *             &lt;/restriction&gt;
 *           &lt;/simpleType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="attachedLexiconPosition" minOccurs="0"&gt;
 *           &lt;simpleType&gt;
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *               &lt;maxLength value="500"/&gt;
 *             &lt;/restriction&gt;
 *           &lt;/simpleType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="compatibleLexiconType" maxOccurs="unbounded" minOccurs="0"&gt;
 *           &lt;simpleType&gt;
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *               &lt;maxLength value="30"/&gt;
 *               &lt;enumeration value="wordnet"/&gt;
 *               &lt;enumeration value="wordlist"/&gt;
 *               &lt;enumeration value="morphologicalLexicon"/&gt;
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
@XmlType(name = "relatedLexiconInfoType", propOrder = {
    "relatedLexiconType",
    "attachedLexiconPosition",
    "compatibleLexiconType"
})
public class RelatedLexiconInfo {

    @XmlElement(required = true)
    protected RelatedLexiconTypeEnum relatedLexiconType;
    protected String attachedLexiconPosition;
    protected List<CompatibleLexiconTypeEnum> compatibleLexiconType;

    /**
     * Gets the value of the relatedLexiconType property.
     * 
     * @return
     *     possible object is
     *     {@link RelatedLexiconTypeEnum }
     *     
     */
    public RelatedLexiconTypeEnum getRelatedLexiconType() {
        return relatedLexiconType;
    }

    /**
     * Sets the value of the relatedLexiconType property.
     * 
     * @param value
     *     allowed object is
     *     {@link RelatedLexiconTypeEnum }
     *     
     */
    public void setRelatedLexiconType(RelatedLexiconTypeEnum value) {
        this.relatedLexiconType = value;
    }

    /**
     * Gets the value of the attachedLexiconPosition property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAttachedLexiconPosition() {
        return attachedLexiconPosition;
    }

    /**
     * Sets the value of the attachedLexiconPosition property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAttachedLexiconPosition(String value) {
        this.attachedLexiconPosition = value;
    }

    /**
     * Gets the value of the compatibleLexiconType property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the compatibleLexiconType property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getCompatibleLexiconType().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link CompatibleLexiconTypeEnum }
     * 
     * 
     */
    public List<CompatibleLexiconTypeEnum> getCompatibleLexiconType() {
        if (compatibleLexiconType == null) {
            compatibleLexiconType = new ArrayList<CompatibleLexiconTypeEnum>();
        }
        return this.compatibleLexiconType;
    }

}
