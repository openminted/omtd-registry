
package eu.openminted.registry.domain;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for geographicCoverageInfoType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="geographicCoverageInfoType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="geographicCoverage"&gt;
 *           &lt;simpleType&gt;
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *               &lt;maxLength value="100"/&gt;
 *             &lt;/restriction&gt;
 *           &lt;/simpleType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="sizePerGeographicCoverage" type="{http://www.meta-share.org/OMTD-SHARE_XMLSchema}sizeInfoType" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "geographicCoverageInfoType", propOrder = {
    "geographicCoverage",
    "sizePerGeographicCoverage"
})
public class GeographicCoverageInfo {

    @XmlElement(required = true)
    protected String geographicCoverage;
    protected SizeInfo sizePerGeographicCoverage;

    /**
     * Gets the value of the geographicCoverage property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getGeographicCoverage() {
        return geographicCoverage;
    }

    /**
     * Sets the value of the geographicCoverage property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setGeographicCoverage(String value) {
        this.geographicCoverage = value;
    }

    /**
     * Gets the value of the sizePerGeographicCoverage property.
     * 
     * @return
     *     possible object is
     *     {@link SizeInfo }
     *     
     */
    public SizeInfo getSizePerGeographicCoverage() {
        return sizePerGeographicCoverage;
    }

    /**
     * Sets the value of the sizePerGeographicCoverage property.
     * 
     * @param value
     *     allowed object is
     *     {@link SizeInfo }
     *     
     */
    public void setSizePerGeographicCoverage(SizeInfo value) {
        this.sizePerGeographicCoverage = value;
    }

}
