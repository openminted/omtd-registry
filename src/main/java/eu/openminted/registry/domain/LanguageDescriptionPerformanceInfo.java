
package eu.openminted.registry.domain;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for languageDescriptionPerformanceInfoType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="languageDescriptionPerformanceInfoType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="robustness" minOccurs="0"&gt;
 *           &lt;simpleType&gt;
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *               &lt;maxLength value="500"/&gt;
 *             &lt;/restriction&gt;
 *           &lt;/simpleType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="shallowness" minOccurs="0"&gt;
 *           &lt;simpleType&gt;
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *               &lt;maxLength value="200"/&gt;
 *             &lt;/restriction&gt;
 *           &lt;/simpleType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="output" minOccurs="0"&gt;
 *           &lt;simpleType&gt;
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *               &lt;maxLength value="500"/&gt;
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
@XmlType(name = "languageDescriptionPerformanceInfoType", propOrder = {
    "robustness",
    "shallowness",
    "output"
})
public class LanguageDescriptionPerformanceInfo {

    protected String robustness;
    protected String shallowness;
    protected String output;

    /**
     * Gets the value of the robustness property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRobustness() {
        return robustness;
    }

    /**
     * Sets the value of the robustness property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRobustness(String value) {
        this.robustness = value;
    }

    /**
     * Gets the value of the shallowness property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getShallowness() {
        return shallowness;
    }

    /**
     * Sets the value of the shallowness property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setShallowness(String value) {
        this.shallowness = value;
    }

    /**
     * Gets the value of the output property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOutput() {
        return output;
    }

    /**
     * Sets the value of the output property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOutput(String value) {
        this.output = value;
    }

}
