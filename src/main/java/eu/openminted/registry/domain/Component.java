package eu.openminted.registry.domain;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Created by stefania on 9/5/16.
 */
@XmlRootElement(name = "componentMetadataRecord", namespace = "http://www.meta-share.org/OMTD-SHARE_XMLSchema")
public class Component {

    //required
    @XmlElement(name = "metadataHeaderInfo", required = true)
    private MetadataHeaderInfo metadataHeaderInfo;

    private ComponentInfo componentInfo;

    public Component() {
    }

    public MetadataHeaderInfo getMetadataHeaderInfo() {
        return metadataHeaderInfo;
    }

    public void setMetadataHeaderInfo(MetadataHeaderInfo metadataHeaderInfo) {
        this.metadataHeaderInfo = metadataHeaderInfo;
    }

	public ComponentInfo getComponentInfo() {
		return componentInfo;
	}

	public void setComponentInfo(ComponentInfo componentInfo) {
		this.componentInfo = componentInfo;
	}
}
