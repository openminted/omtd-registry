
package eu.openminted.registry.domain;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for componentCreationInfoType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="componentCreationInfoType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="framework"&gt;
 *           &lt;simpleType&gt;
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *               &lt;enumeration value="UIMA"/&gt;
 *               &lt;enumeration value="GATE"/&gt;
 *               &lt;enumeration value="AlvisNLP"/&gt;
 *               &lt;enumeration value="other"/&gt;
 *             &lt;/restriction&gt;
 *           &lt;/simpleType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="implementationLanguage" maxOccurs="unbounded" minOccurs="0"&gt;
 *           &lt;simpleType&gt;
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *               &lt;maxLength value="100"/&gt;
 *             &lt;/restriction&gt;
 *           &lt;/simpleType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="formalism" maxOccurs="unbounded" minOccurs="0"&gt;
 *           &lt;simpleType&gt;
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *               &lt;maxLength value="100"/&gt;
 *             &lt;/restriction&gt;
 *           &lt;/simpleType&gt;
 *         &lt;/element&gt;
 *         &lt;element ref="{http://www.meta-share.org/OMTD-SHARE_XMLSchema}hasOriginalSource" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;element name="creationDetails" minOccurs="0"&gt;
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
@XmlType(name = "componentCreationInfoType", propOrder = {
    "framework",
    "implementationLanguage",
    "formalism",
    "hasOriginalSource",
    "creationDetails"
})
public class ComponentCreationInfo {

    @XmlElement(required = true)
    protected FrameworkEnum framework;
    protected List<String> implementationLanguage;
    protected List<String> formalism;
    protected List<ResourceIdentifier> hasOriginalSource;
    protected String creationDetails;

    /**
     * Gets the value of the framework property.
     * 
     * @return
     *     possible object is
     *     {@link FrameworkEnum }
     *     
     */
    public FrameworkEnum getFramework() {
        return framework;
    }

    /**
     * Sets the value of the framework property.
     * 
     * @param value
     *     allowed object is
     *     {@link FrameworkEnum }
     *     
     */
    public void setFramework(FrameworkEnum value) {
        this.framework = value;
    }

    /**
     * Gets the value of the implementationLanguage property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the implementationLanguage property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getImplementationLanguage().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link String }
     * 
     * 
     */
    public List<String> getImplementationLanguage() {
        if (implementationLanguage == null) {
            implementationLanguage = new ArrayList<String>();
        }
        return this.implementationLanguage;
    }

    /**
     * Gets the value of the formalism property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the formalism property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getFormalism().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link String }
     * 
     * 
     */
    public List<String> getFormalism() {
        if (formalism == null) {
            formalism = new ArrayList<String>();
        }
        return this.formalism;
    }

    /**
     * The name, the identifier or the url of thethe original resources that were at the base of the creation process of the resource Gets the value of the hasOriginalSource property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the hasOriginalSource property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getHasOriginalSource().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ResourceIdentifier }
     * 
     * 
     */
    public List<ResourceIdentifier> getHasOriginalSource() {
        if (hasOriginalSource == null) {
            hasOriginalSource = new ArrayList<ResourceIdentifier>();
        }
        return this.hasOriginalSource;
    }

    /**
     * Gets the value of the creationDetails property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCreationDetails() {
        return creationDetails;
    }

    /**
     * Sets the value of the creationDetails property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCreationDetails(String value) {
        this.creationDetails = value;
    }

}
