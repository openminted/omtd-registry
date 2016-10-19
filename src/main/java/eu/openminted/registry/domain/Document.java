
package eu.openminted.registry.domain;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElements;
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
 *       &lt;choice&gt;
 *         &lt;element ref="{http://www.meta-share.org/OMTD-SHARE_XMLSchema}publication"/&gt;
 *         &lt;element ref="{http://www.meta-share.org/OMTD-SHARE_XMLSchema}annotatedPublication"/&gt;
 *       &lt;/choice&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "publicationOrAnnotatedPublication"
})
public class Document {

    @XmlElements({
        @XmlElement(name = "publication", type = DocumentInfo.class),
        @XmlElement(name = "annotatedPublication", type = AnnotatedDocumentInfo.class)
    })
    protected Object publicationOrAnnotatedPublication;

    /**
     * Gets the value of the publicationOrAnnotatedPublication property.
     * 
     * @return
     *     possible object is
     *     {@link DocumentInfo }
     *     {@link AnnotatedDocumentInfo }
     *     
     */
    public Object getPublicationOrAnnotatedPublication() {
        return publicationOrAnnotatedPublication;
    }

    /**
     * Sets the value of the publicationOrAnnotatedPublication property.
     * 
     * @param value
     *     allowed object is
     *     {@link DocumentInfo }
     *     {@link AnnotatedDocumentInfo }
     *     
     */
    public void setPublicationOrAnnotatedPublication(Object value) {
        this.publicationOrAnnotatedPublication = value;
    }

}
