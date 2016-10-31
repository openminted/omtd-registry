
package eu.openminted.registry.domain;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for anonymous complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="grammaticalPhenomenaCoverage" maxOccurs="unbounded" minOccurs="0"&gt;
 *           &lt;simpleType&gt;
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *               &lt;maxLength value="30"/&gt;
 *               &lt;enumeration value="clauseStructure"/&gt;
 *               &lt;enumeration value="ppAttachment"/&gt;
 *               &lt;enumeration value="npStructure"/&gt;
 *               &lt;enumeration value="coordination"/&gt;
 *               &lt;enumeration value="anaphora"/&gt;
 *               &lt;enumeration value="other"/&gt;
 *             &lt;/restriction&gt;
 *           &lt;/simpleType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="weightedGrammar" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "grammaticalPhenomenaCoverage",
    "weightedGrammar"
})
public class GrammaticalPhenomenaCoverages {

    protected List<GrammaticalPhenomenaCoverageEnum> grammaticalPhenomenaCoverage;
    protected Boolean weightedGrammar;

    /**
     * Gets the value of the grammaticalPhenomenaCoverage property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the grammaticalPhenomenaCoverage property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getGrammaticalPhenomenaCoverage().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link GrammaticalPhenomenaCoverageEnum }
     * 
     * 
     */
    public List<GrammaticalPhenomenaCoverageEnum> getGrammaticalPhenomenaCoverage() {
        if (grammaticalPhenomenaCoverage == null) {
            grammaticalPhenomenaCoverage = new ArrayList<GrammaticalPhenomenaCoverageEnum>();
        }
        return this.grammaticalPhenomenaCoverage;
    }

    /**
     * Gets the value of the weightedGrammar property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isWeightedGrammar() {
        return weightedGrammar;
    }

    /**
     * Sets the value of the weightedGrammar property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setWeightedGrammar(Boolean value) {
        this.weightedGrammar = value;
    }

}
