
package eu.openminted.registry.domain;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for relatedDocumentInfoType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="relatedDocumentInfoType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;choice&gt;
 *         &lt;element name="documentUnstructured"&gt;
 *           &lt;simpleType&gt;
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *               &lt;maxLength value="500"/&gt;
 *             &lt;/restriction&gt;
 *           &lt;/simpleType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="publicationIdentifiers"&gt;
 *           &lt;complexType&gt;
 *             &lt;complexContent&gt;
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                 &lt;sequence&gt;
 *                   &lt;element name="publicationIdentifier" type="{http://www.meta-share.org/OMTD-SHARE_XMLSchema}publicationIdentifierType" maxOccurs="unbounded"/&gt;
 *                 &lt;/sequence&gt;
 *               &lt;/restriction&gt;
 *             &lt;/complexContent&gt;
 *           &lt;/complexType&gt;
 *         &lt;/element&gt;
 *       &lt;/choice&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "relatedDocumentInfoType", propOrder = {
    "documentUnstructured","publicationIdentifiers"
})
public class RelatedDocumentInfo {

//    @XmlElements({
//        @XmlElement(name = "documentUnstructured", type = String.class),
//        @XmlElement(name = "publicationIdentifiers", type = PublicationIdentifiers.class)
//    })
//    protected Object documentUnstructuredOrPublicationIdentifiers;

    protected String documentUnstructured;

    @XmlElementWrapper
    @XmlElement(name = "publicationIdentifier", namespace = "http://www.meta-share.org/OMTD-SHARE_XMLSchema")
    protected List<PublicationIdentifier> publicationIdentifiers;
    
    public List<PublicationIdentifier> getPublicationIdentifiers() {
        if (publicationIdentifiers == null) {
        	publicationIdentifiers = new ArrayList<PublicationIdentifier>();
        }
        return publicationIdentifiers;
    }

    public void setPublicationIdentifiers(List<PublicationIdentifier> publicationIdentifiers) {
        this.publicationIdentifiers = publicationIdentifiers;
    }

	public String getDocumentUnstructured() {
		return documentUnstructured;
	}

	public void setDocumentUnstructured(String documentUnstructured) {
		this.documentUnstructured = documentUnstructured;
	}

    
    
}
