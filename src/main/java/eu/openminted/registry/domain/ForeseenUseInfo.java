
package eu.openminted.registry.domain;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for foreseenUseInfoType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="foreseenUseInfoType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="foreseenUse"&gt;
 *           &lt;simpleType&gt;
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *               &lt;maxLength value="30"/&gt;
 *               &lt;enumeration value="humanUse"/&gt;
 *               &lt;enumeration value="nlpApplications"/&gt;
 *             &lt;/restriction&gt;
 *           &lt;/simpleType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="useNlpApplications" minOccurs="0"&gt;
 *           &lt;complexType&gt;
 *             &lt;complexContent&gt;
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                 &lt;sequence&gt;
 *                   &lt;element ref="{http://www.meta-share.org/OMTD-SHARE_XMLSchema}useNLPSpecific" maxOccurs="unbounded" minOccurs="0"/&gt;
 *                 &lt;/sequence&gt;
 *               &lt;/restriction&gt;
 *             &lt;/complexContent&gt;
 *           &lt;/complexType&gt;
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
@XmlType(name = "foreseenUseInfoType", propOrder = {
    "foreseenUse",
    "useNlpApplications"
})
public class ForeseenUseInfo {

    @XmlElement(required = true)
    protected ForeseenUseEnum foreseenUse;
    @XmlElementWrapper
    @XmlElement(name = "useNLPSpecific", namespace = "http://www.meta-share.org/OMTD-SHARE_XMLSchema")
    protected List<UseNLPSpecificEnum> useNlpApplications;

    /**
     * Gets the value of the foreseenUse property.
     * 
     * @return
     *     possible object is
     *     {@link ForeseenUseEnum }
     *     
     */
    public ForeseenUseEnum getForeseenUse() {
        return foreseenUse;
    }

    /**
     * Sets the value of the foreseenUse property.
     * 
     * @param value
     *     allowed object is
     *     {@link ForeseenUseEnum }
     *     
     */
    public void setForeseenUse(ForeseenUseEnum value) {
        this.foreseenUse = value;
    }

    public List<UseNLPSpecificEnum> getUseNlpApplications() {
        if (useNlpApplications == null) {
            useNlpApplications = new ArrayList<UseNLPSpecificEnum>();
        }
        return useNlpApplications;
    }

    public void setUseNlpApplications(List<UseNLPSpecificEnum> useNlpApplications) {
        this.useNlpApplications = useNlpApplications;
    }

}
