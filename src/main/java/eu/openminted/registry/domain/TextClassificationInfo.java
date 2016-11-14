
package eu.openminted.registry.domain;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for textClassificationInfoType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="textClassificationInfoType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element ref="{http://www.meta-share.org/OMTD-SHARE_XMLSchema}textGenre" minOccurs="0"/&gt;
 *         &lt;element ref="{http://www.meta-share.org/OMTD-SHARE_XMLSchema}textType" minOccurs="0"/&gt;
 *         &lt;element ref="{http://www.meta-share.org/OMTD-SHARE_XMLSchema}register" minOccurs="0"/&gt;
 *         &lt;element ref="{http://www.meta-share.org/OMTD-SHARE_XMLSchema}subject" minOccurs="0"/&gt;
 *         &lt;element name="keywords" minOccurs="0"&gt;
 *           &lt;complexType&gt;
 *             &lt;complexContent&gt;
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                 &lt;sequence&gt;
 *                   &lt;element ref="{http://www.meta-share.org/OMTD-SHARE_XMLSchema}keyword" maxOccurs="unbounded" minOccurs="0"/&gt;
 *                 &lt;/sequence&gt;
 *               &lt;/restriction&gt;
 *             &lt;/complexContent&gt;
 *           &lt;/complexType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="sizePerTextClassification" type="{http://www.meta-share.org/OMTD-SHARE_XMLSchema}sizeInfoType" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "textClassificationInfoType", propOrder = {
    "textGenre",
    "textType",
    "register",
    "subject",
    "keywords",
    "sizePerTextClassification"
})
public class TextClassificationInfo {

    protected TextGenre textGenre;
    protected Text textType;
    protected Register register;
    protected Subject subject;
    @XmlElementWrapper
    @XmlElement(name = "keyword", namespace = "http://www.meta-share.org/OMTD-SHARE_XMLSchema")
    protected List<String> keywords;
    protected SizeInfo sizePerTextClassification;

    /**
     * Genre: The conventionalized discourse or text types of the content of the resource, based on extra-linguistic and internal linguistic criteria
     * 
     * @return
     *     possible object is
     *     {@link TextGenre }
     *     
     */
    public TextGenre getTextGenre() {
        return textGenre;
    }

    /**
     * Sets the value of the textGenre property.
     * 
     * @param value
     *     allowed object is
     *     {@link TextGenre }
     *     
     */
    public void setTextGenre(TextGenre value) {
        this.textGenre = value;
    }

    /**
     * Specifies the type of the text according to a text type classification
     * 
     * @return
     *     possible object is
     *     {@link Text }
     *     
     */
    public Text getTextType() {
        return textType;
    }

    /**
     * Sets the value of the textType property.
     * 
     * @param value
     *     allowed object is
     *     {@link Text }
     *     
     */
    public void setTextType(Text value) {
        this.textType = value;
    }

    /**
     * For corpora that have already been using register classification
     * 
     * @return
     *     possible object is
     *     {@link Register }
     *     
     */
    public Register getRegister() {
        return register;
    }

    /**
     * Sets the value of the register property.
     * 
     * @param value
     *     allowed object is
     *     {@link Register }
     *     
     */
    public void setRegister(Register value) {
        this.register = value;
    }

    /**
     * For corpora that have already been using subject classification
     * 
     * @return
     *     possible object is
     *     {@link Subject }
     *     
     */
    public Subject getSubject() {
        return subject;
    }

    /**
     * Sets the value of the subject property.
     * 
     * @param value
     *     allowed object is
     *     {@link Subject }
     *     
     */
    public void setSubject(Subject value) {
        this.subject = value;
    }

    /**
     * Gets the value of the sizePerTextClassification property.
     * 
     * @return
     *     possible object is
     *     {@link SizeInfo }
     *     
     */
    public SizeInfo getSizePerTextClassification() {
        return sizePerTextClassification;
    }

    /**
     * Sets the value of the sizePerTextClassification property.
     * 
     * @param value
     *     allowed object is
     *     {@link SizeInfo }
     *     
     */
    public void setSizePerTextClassification(SizeInfo value) {
        this.sizePerTextClassification = value;
    }

    public List<String> getKeywords() {
        if (keywords == null) {
            keywords = new ArrayList<String>();
        }
        return keywords;
    }

    public void setKeywords(List<String> keywords) {
        this.keywords = keywords;
    }

}
