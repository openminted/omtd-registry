
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
 *       &lt;choice&gt;
 *         &lt;element ref="{http://www.meta-share.org/OMTD-SHARE_XMLSchema}rawCorpusInfo"/&gt;
 *         &lt;element ref="{http://www.meta-share.org/OMTD-SHARE_XMLSchema}annotatedCorpusInfo"/&gt;
 *         &lt;element ref="{http://www.meta-share.org/OMTD-SHARE_XMLSchema}annotationsInfo"/&gt;
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
    "rawCorpusInfo","annotatedCorpusInfo","annotationsInfo"
})
public class CorpusSubtypeSpecificInfo {

//    @XmlElements({
//        @XmlElement(name = "rawCorpusInfo", type = RawCorpusInfo.class),
//        @XmlElement(name = "annotatedCorpusInfo", type = AnnotatedCorpusInfo.class),
//        @XmlElement(name = "annotationsInfo", type = AnnotationsInfo.class)
//    })
//    protected Object rawCorpusInfoOrAnnotatedCorpusInfoOrAnnotationsInfo;
	
    protected AnnotatedCorpusInfo annotatedCorpusInfo;
    protected RawCorpusInfo rawCorpusInfo;
    protected AnnotationsInfo annotationsInfo;
    
	public AnnotatedCorpusInfo getAnnotatedCorpusInfo() {
		return annotatedCorpusInfo;
	}
	public void setAnnotatedCorpusInfo(AnnotatedCorpusInfo annotatedCorpusInfo) {
		this.annotatedCorpusInfo = annotatedCorpusInfo;
	}
	public RawCorpusInfo getRawCorpusInfo() {
		return rawCorpusInfo;
	}
	public void setRawCorpusInfo(RawCorpusInfo rawCorpusInfo) {
		this.rawCorpusInfo = rawCorpusInfo;
	}
	public AnnotationsInfo getAnnotationsInfo() {
		return annotationsInfo;
	}
	public void setAnnotationsInfo(AnnotationsInfo annotationsInfo) {
		this.annotationsInfo = annotationsInfo;
	}


    

}
