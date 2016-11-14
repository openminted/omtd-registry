
package eu.openminted.registry.domain;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for componentOperationInfoType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="componentOperationInfoType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element ref="{http://www.meta-share.org/OMTD-SHARE_XMLSchema}runningEnvironmentInfo" minOccurs="0"/&gt;
 *         &lt;element name="runningTime" minOccurs="0"&gt;
 *           &lt;simpleType&gt;
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *               &lt;maxLength value="100"/&gt;
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
@XmlType(name = "componentOperationInfoType", propOrder = {
    "runningEnvironmentInfo",
    "runningTime"
})
public class ComponentOperationInfo {

    protected RunningEnvironmentInfo runningEnvironmentInfo;
    protected String runningTime;

    /**
     * Groups together information on the running environment of a tool or a language description
     * 
     * @return
     *     possible object is
     *     {@link RunningEnvironmentInfo }
     *     
     */
    public RunningEnvironmentInfo getRunningEnvironmentInfo() {
        return runningEnvironmentInfo;
    }

    /**
     * Sets the value of the runningEnvironmentInfo property.
     * 
     * @param value
     *     allowed object is
     *     {@link RunningEnvironmentInfo }
     *     
     */
    public void setRunningEnvironmentInfo(RunningEnvironmentInfo value) {
        this.runningEnvironmentInfo = value;
    }

    /**
     * Gets the value of the runningTime property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRunningTime() {
        return runningTime;
    }

    /**
     * Sets the value of the runningTime property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRunningTime(String value) {
        this.runningTime = value;
    }

}
