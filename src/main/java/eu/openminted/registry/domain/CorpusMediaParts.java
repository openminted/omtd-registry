
package eu.openminted.registry.domain;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
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
 *         &lt;element name="corpusTextParts"&gt;
 *           &lt;complexType&gt;
 *             &lt;complexContent&gt;
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                 &lt;sequence&gt;
 *                   &lt;element ref="{http://www.meta-share.org/OMTD-SHARE_XMLSchema}corpusTextPartInfo" maxOccurs="unbounded"/&gt;
 *                 &lt;/sequence&gt;
 *               &lt;/restriction&gt;
 *             &lt;/complexContent&gt;
 *           &lt;/complexType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="annotations"&gt;
 *           &lt;complexType&gt;
 *             &lt;complexContent&gt;
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                 &lt;sequence&gt;
 *                   &lt;element ref="{http://www.meta-share.org/OMTD-SHARE_XMLSchema}annotationInfo" maxOccurs="unbounded"/&gt;
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
@XmlType(name = "", propOrder = {
    "corpusTextParts",
    "annotations"
})
public class CorpusMediaParts {

    @XmlElementWrapper(required = true)
    @XmlElement(name = "corpusTextPartInfo", namespace = "http://www.meta-share.org/OMTD-SHARE_XMLSchema")
    protected List<CorpusTextPartInfo> corpusTextParts;
    @XmlElementWrapper(required = true)
    @XmlElement(name = "annotationInfo", namespace = "http://www.meta-share.org/OMTD-SHARE_XMLSchema")
    protected List<AnnotationInfo> annotations;

    public List<CorpusTextPartInfo> getCorpusTextParts() {
        if (corpusTextParts == null) {
            corpusTextParts = new ArrayList<CorpusTextPartInfo>();
        }
        return corpusTextParts;
    }

    public void setCorpusTextParts(List<CorpusTextPartInfo> corpusTextParts) {
        this.corpusTextParts = corpusTextParts;
    }

    public List<AnnotationInfo> getAnnotations() {
        if (annotations == null) {
            annotations = new ArrayList<AnnotationInfo>();
        }
        return annotations;
    }

    public void setAnnotations(List<AnnotationInfo> annotations) {
        this.annotations = annotations;
    }

}
