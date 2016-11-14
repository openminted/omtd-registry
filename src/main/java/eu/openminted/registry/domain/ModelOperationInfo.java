
package eu.openminted.registry.domain;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
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
 *         &lt;element name="variantName" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element ref="{http://www.meta-share.org/OMTD-SHARE_XMLSchema}tagset" minOccurs="0"/&gt;
 *         &lt;element ref="{http://www.meta-share.org/OMTD-SHARE_XMLSchema}typesystem" minOccurs="0"/&gt;
 *         &lt;element name="algorithm" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="algorithmDetails" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="trainingCorpusDetails" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
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
    "variantName",
    "tagset",
    "typesystem",
    "algorithm",
    "algorithmDetails",
    "trainingCorpusDetails"
})
public class ModelOperationInfo {

    @XmlElement(required = true)
    protected String variantName;
    protected RelatedResource tagset;
    protected RelatedResource typesystem;
    protected String algorithm;
    protected String algorithmDetails;
    protected String trainingCorpusDetails;

    /**
     * Gets the value of the variantName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getVariantName() {
        return variantName;
    }

    /**
     * Sets the value of the variantName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setVariantName(String value) {
        this.variantName = value;
    }

    /**
     * Gets the value of the tagset property.
     * 
     * @return
     *     possible object is
     *     {@link RelatedResource }
     *     
     */
    public RelatedResource getTagset() {
        return tagset;
    }

    /**
     * Sets the value of the tagset property.
     * 
     * @param value
     *     allowed object is
     *     {@link RelatedResource }
     *     
     */
    public void setTagset(RelatedResource value) {
        this.tagset = value;
    }

    /**
     * Gets the value of the typesystem property.
     * 
     * @return
     *     possible object is
     *     {@link RelatedResource }
     *     
     */
    public RelatedResource getTypesystem() {
        return typesystem;
    }

    /**
     * Sets the value of the typesystem property.
     * 
     * @param value
     *     allowed object is
     *     {@link RelatedResource }
     *     
     */
    public void setTypesystem(RelatedResource value) {
        this.typesystem = value;
    }

    /**
     * Gets the value of the algorithm property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAlgorithm() {
        return algorithm;
    }

    /**
     * Sets the value of the algorithm property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAlgorithm(String value) {
        this.algorithm = value;
    }

    /**
     * Gets the value of the algorithmDetails property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAlgorithmDetails() {
        return algorithmDetails;
    }

    /**
     * Sets the value of the algorithmDetails property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAlgorithmDetails(String value) {
        this.algorithmDetails = value;
    }

    /**
     * Gets the value of the trainingCorpusDetails property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTrainingCorpusDetails() {
        return trainingCorpusDetails;
    }

    /**
     * Sets the value of the trainingCorpusDetails property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTrainingCorpusDetails(String value) {
        this.trainingCorpusDetails = value;
    }

}
