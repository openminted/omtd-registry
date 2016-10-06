package eu.openminted.registry.domain;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

/**
 * Created by stefania on 9/5/16.
 */
@XmlRootElement(name = "corpusMetadataRecord", namespace = "http://www.meta-share.org/OMTD-SHARE_XMLSchema")
@XmlType(propOrder = {
	    "metadataHeaderInfo",
	    "corpusInfo"
	})
public class Corpus {

    //required
    @XmlElement(name = "metadataHeaderInfo", required = true)
    private MetadataHeaderInfo metadataHeaderInfo;
    
    private CorpusInfo corpusInfo;

    public Corpus() {
    }

	public MetadataHeaderInfo getMetadataHeaderInfo() {
		return metadataHeaderInfo;
	}

	public void setMetadataHeaderInfo(MetadataHeaderInfo metadataHeaderInfo) {
		this.metadataHeaderInfo = metadataHeaderInfo;
	}


	public CorpusInfo getCorpusInfo() {
		return corpusInfo;
	}


	public void setCorpusInfo(CorpusInfo corpusInfo) {
		this.corpusInfo = corpusInfo;
	}


    
}
