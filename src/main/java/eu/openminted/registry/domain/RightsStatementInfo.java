
package eu.openminted.registry.domain;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * Groups information on official statements indicative of licensing terms for the use of a resource (e.g. open access, free to read, all rights reserved etc.); its semantics should be clear, preferrably formally expressed and stored at a url
 * 
 * <p>Java class for rightsStatementInfoType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="rightsStatementInfoType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="rightsStmtName"&gt;
 *           &lt;simpleType&gt;
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *               &lt;enumeration value="openAccess"/&gt;
 *               &lt;enumeration value="closedAccess"/&gt;
 *               &lt;enumeration value="embargoedAccess"/&gt;
 *               &lt;enumeration value="restrictedAccess"/&gt;
 *             &lt;/restriction&gt;
 *           &lt;/simpleType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="rightsStmtURL" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "rightsStatementInfoType", propOrder = {
    "rightsStmtName",
    "rightsStmtURL"
})
public class RightsStatementInfo {

    @XmlElement(required = true)
    protected RightsStmtNameEnum rightsStmtName;
    @XmlElement(required = true)
    protected String rightsStmtURL;

    /**
     * Gets the value of the rightsStmtName property.
     * 
     * @return
     *     possible object is
     *     {@link RightsStmtNameEnum }
     *     
     */
    public RightsStmtNameEnum getRightsStmtName() {
        return rightsStmtName;
    }

    /**
     * Sets the value of the rightsStmtName property.
     * 
     * @param value
     *     allowed object is
     *     {@link RightsStmtNameEnum }
     *     
     */
    public void setRightsStmtName(RightsStmtNameEnum value) {
        this.rightsStmtName = value;
    }

    /**
     * Gets the value of the rightsStmtURL property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRightsStmtURL() {
        return rightsStmtURL;
    }

    /**
     * Sets the value of the rightsStmtURL property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRightsStmtURL(String value) {
        this.rightsStmtURL = value;
    }

}
