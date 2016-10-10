package eu.openminted.registry.domain;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


@XmlRootElement(name = "lcrMetadataRecord", namespace = "http://www.meta-share.org/OMTD-SHARE_XMLSchema")
@XmlType(propOrder={"metadataHeaderInfo","lexicalConceptualResourceInfo"})
public class LexicalConceptualResource {

	private MetadataHeaderInfo metadataHeaderInfo;
	
	private LexicalConceptualResourceInfo lexicalConceptualResourceInfo;  
	
    
    public LexicalConceptualResource() {
	}


	public LexicalConceptualResource(MetadataHeaderInfo metadataHeaderInfo,
			LexicalConceptualResourceInfo lexicalConceptualResourceInfo) {
		super();
		this.metadataHeaderInfo = metadataHeaderInfo;
		this.lexicalConceptualResourceInfo = lexicalConceptualResourceInfo;
	}


	public MetadataHeaderInfo getMetadataHeaderInfo() {
		return metadataHeaderInfo;
	}


	public void setMetadataHeaderInfo(MetadataHeaderInfo metadataHeaderInfo) {
		this.metadataHeaderInfo = metadataHeaderInfo;
	}


	public LexicalConceptualResourceInfo getLexicalConceptualResourceInfo() {
		return lexicalConceptualResourceInfo;
	}


	public void setLexicalConceptualResourceInfo(
			LexicalConceptualResourceInfo lexicalConceptualResourceInfo) {
		this.lexicalConceptualResourceInfo = lexicalConceptualResourceInfo;
	}

    
    
}
