
package eu.openminted.registry.domain;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for modalityInfoType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="modalityInfoType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element ref="{http://www.meta-share.org/OMTD-SHARE_XMLSchema}modalityType" maxOccurs="unbounded"/&gt;
 *         &lt;element name="modalityTypeDetails" minOccurs="0"&gt;
 *           &lt;simpleType&gt;
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *               &lt;maxLength value="500"/&gt;
 *             &lt;/restriction&gt;
 *           &lt;/simpleType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="sizePerModality" type="{http://www.meta-share.org/OMTD-SHARE_XMLSchema}sizeInfoType" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "modalityInfoType", propOrder = {
    "modalityType",
    "modalityTypeDetails",
    "sizePerModality"
})
public class ModalityInfo {

    @XmlElement(required = true)
    protected List<ModalityTypeEnum> modalityType;
    protected String modalityTypeDetails;
    protected SizeInfo sizePerModality;

    /**
     * Gets the value of the modalityType property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the modalityType property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getModalityType().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ModalityTypeEnum }
     * 
     * 
     */
    public List<ModalityTypeEnum> getModalityType() {
        if (modalityType == null) {
            modalityType = new ArrayList<ModalityTypeEnum>();
        }
        return this.modalityType;
    }

    /**
     * Gets the value of the modalityTypeDetails property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getModalityTypeDetails() {
        return modalityTypeDetails;
    }

    /**
     * Sets the value of the modalityTypeDetails property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setModalityTypeDetails(String value) {
        this.modalityTypeDetails = value;
    }

    /**
     * Gets the value of the sizePerModality property.
     * 
     * @return
     *     possible object is
     *     {@link SizeInfo }
     *     
     */
    public SizeInfo getSizePerModality() {
        return sizePerModality;
    }

    /**
     * Sets the value of the sizePerModality property.
     * 
     * @param value
     *     allowed object is
     *     {@link SizeInfo }
     *     
     */
    public void setSizePerModality(SizeInfo value) {
        this.sizePerModality = value;
    }

}
