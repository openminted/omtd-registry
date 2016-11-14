
package eu.openminted.registry.domain;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for languageDescriptionOperationInfoType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="languageDescriptionOperationInfoType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element ref="{http://www.meta-share.org/OMTD-SHARE_XMLSchema}runningEnvironmentInfo" minOccurs="0"/&gt;
 *         &lt;element name="relatedLexiconInfo" type="{http://www.meta-share.org/OMTD-SHARE_XMLSchema}relatedLexiconInfoType" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "languageDescriptionOperationInfoType", propOrder = {
    "runningEnvironmentInfo",
    "relatedLexiconInfo"
})
public class LanguageDescriptionOperationInfo {

    protected RunningEnvironmentInfo runningEnvironmentInfo;
    protected RelatedLexiconInfo relatedLexiconInfo;

    /**
     * Gets the value of the runningEnvironmentInfo property.
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
     * Gets the value of the relatedLexiconInfo property.
     * 
     * @return
     *     possible object is
     *     {@link RelatedLexiconInfo }
     *     
     */
    public RelatedLexiconInfo getRelatedLexiconInfo() {
        return relatedLexiconInfo;
    }

    /**
     * Sets the value of the relatedLexiconInfo property.
     * 
     * @param value
     *     allowed object is
     *     {@link RelatedLexiconInfo }
     *     
     */
    public void setRelatedLexiconInfo(RelatedLexiconInfo value) {
        this.relatedLexiconInfo = value;
    }

}
