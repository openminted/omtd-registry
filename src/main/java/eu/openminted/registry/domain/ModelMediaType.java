
package eu.openminted.registry.domain;

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
 *         &lt;element ref="{http://www.meta-share.org/OMTD-SHARE_XMLSchema}modelTextInfo" minOccurs="0"/&gt;
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
    "modelTextInfo"
})
public class ModelMediaType {

    protected ModelTextInfo modelTextInfo;

    /**
     * Gets the value of the modelTextInfo property.
     * 
     * @return
     *     possible object is
     *     {@link ModelTextInfo }
     *     
     */
    public ModelTextInfo getModelTextInfo() {
        return modelTextInfo;
    }

    /**
     * Sets the value of the modelTextInfo property.
     * 
     * @param value
     *     allowed object is
     *     {@link ModelTextInfo }
     *     
     */
    public void setModelTextInfo(ModelTextInfo value) {
        this.modelTextInfo = value;
    }

}
