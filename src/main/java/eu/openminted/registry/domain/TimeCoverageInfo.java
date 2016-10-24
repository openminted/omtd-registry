
package eu.openminted.registry.domain;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for timeCoverageInfoType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="timeCoverageInfoType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="timeCoverage"&gt;
 *           &lt;simpleType&gt;
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *               &lt;maxLength value="100"/&gt;
 *             &lt;/restriction&gt;
 *           &lt;/simpleType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="sizePerTimeCoverage" type="{http://www.meta-share.org/OMTD-SHARE_XMLSchema}sizeInfoType" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "timeCoverageInfoType", propOrder = {
    "timeCoverage",
    "sizePerTimeCoverage"
})
public class TimeCoverageInfo {

    @XmlElement(required = true)
    protected String timeCoverage;
    protected SizeInfo sizePerTimeCoverage;

    /**
     * Gets the value of the timeCoverage property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTimeCoverage() {
        return timeCoverage;
    }

    /**
     * Sets the value of the timeCoverage property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTimeCoverage(String value) {
        this.timeCoverage = value;
    }

    /**
     * Gets the value of the sizePerTimeCoverage property.
     * 
     * @return
     *     possible object is
     *     {@link SizeInfo }
     *     
     */
    public SizeInfo getSizePerTimeCoverage() {
        return sizePerTimeCoverage;
    }

    /**
     * Sets the value of the sizePerTimeCoverage property.
     * 
     * @param value
     *     allowed object is
     *     {@link SizeInfo }
     *     
     */
    public void setSizePerTimeCoverage(SizeInfo value) {
        this.sizePerTimeCoverage = value;
    }

}
