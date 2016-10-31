
package eu.openminted.registry.domain;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for runningEnvironmentInfoType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="runningEnvironmentInfoType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="requiresSoftware" type="{http://www.meta-share.org/OMTD-SHARE_XMLSchema}relatedResourceType" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;element name="requiresHardware" maxOccurs="unbounded" minOccurs="0"&gt;
 *           &lt;simpleType&gt;
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *               &lt;maxLength value="100"/&gt;
 *               &lt;enumeration value="graphicCard"/&gt;
 *               &lt;enumeration value="microphone"/&gt;
 *               &lt;enumeration value="ocrSystem"/&gt;
 *               &lt;enumeration value="specialHardwareEquipment"/&gt;
 *               &lt;enumeration value="none"/&gt;
 *               &lt;enumeration value="other"/&gt;
 *             &lt;/restriction&gt;
 *           &lt;/simpleType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="requiresLRs" type="{http://www.meta-share.org/OMTD-SHARE_XMLSchema}relatedResourceType" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;element name="runningEnvironmentDetails" minOccurs="0"&gt;
 *           &lt;simpleType&gt;
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *               &lt;maxLength value="200"/&gt;
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
@XmlType(name = "runningEnvironmentInfoType", propOrder = {
    "requiresSoftware",
    "requiresHardware",
    "requiresLRs",
    "runningEnvironmentDetails"
})
public class RunningEnvironmentInfo {

    protected List<RelatedResource> requiresSoftware;
    protected List<RequiresHardwareEnum> requiresHardware;
    protected List<RelatedResource> requiresLRs;
    protected String runningEnvironmentDetails;

    /**
     * Gets the value of the requiresSoftware property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the requiresSoftware property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getRequiresSoftware().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link RelatedResource }
     * 
     * 
     */
    public List<RelatedResource> getRequiresSoftware() {
        if (requiresSoftware == null) {
            requiresSoftware = new ArrayList<RelatedResource>();
        }
        return this.requiresSoftware;
    }

    /**
     * Gets the value of the requiresHardware property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the requiresHardware property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getRequiresHardware().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link RequiresHardwareEnum }
     * 
     * 
     */
    public List<RequiresHardwareEnum> getRequiresHardware() {
        if (requiresHardware == null) {
            requiresHardware = new ArrayList<RequiresHardwareEnum>();
        }
        return this.requiresHardware;
    }

    /**
     * Gets the value of the requiresLRs property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the requiresLRs property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getRequiresLRs().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link RelatedResource }
     * 
     * 
     */
    public List<RelatedResource> getRequiresLRs() {
        if (requiresLRs == null) {
            requiresLRs = new ArrayList<RelatedResource>();
        }
        return this.requiresLRs;
    }

    /**
     * Gets the value of the runningEnvironmentDetails property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRunningEnvironmentDetails() {
        return runningEnvironmentDetails;
    }

    /**
     * Sets the value of the runningEnvironmentDetails property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRunningEnvironmentDetails(String value) {
        this.runningEnvironmentDetails = value;
    }

}
