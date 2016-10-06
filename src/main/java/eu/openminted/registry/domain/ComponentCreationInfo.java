package eu.openminted.registry.domain;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.XmlAdapter;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

/**
 * Created by stefania on 9/5/16.
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "componentCreationInfoType", propOrder = {
    "framework",
    "implementationLanguages",
    "formalisms",
    "hasOriginalSources",
    "creationDetails"
})
public class ComponentCreationInfo {

	@XmlJavaTypeAdapter(ComponentCreationInfo.FrameworkAdapter.class)
    enum Framework {

        UIMA("UIMA"),
        GATE("GATE"),
        OTHER("other");

        private String value;

        Framework(String value) {
            this.value = value;
        }

        public String getValue() {
            return value;
        }
        
        public static ComponentCreationInfo.Framework forValue(String value) {
            for (ComponentCreationInfo.Framework ut: values()) {
                if (ut.getValue().equals(value))
                    return ut;
            }

            return null;
        }
    }

    //required
    private Framework framework;
    @XmlElement(name = "implementationLanguage")
    private List<String> implementationLanguages;
    
    @XmlElement(name = "formalism")
    private List<String> formalisms;
    
    @XmlElement(name = "hasOriginalSource")
    private List<Identifier<ResourceIdentifierSchema>> hasOriginalSources;
    private String creationDetails;

    public ComponentCreationInfo() {
    }

    public ComponentCreationInfo(Framework framework) {
        this.framework = framework;
    }

    public ComponentCreationInfo(Framework framework, List<String> implementationLanguages, List<String> formalisms,
                                 List<Identifier<ResourceIdentifierSchema>> hasOriginalSources, String creationDetails) {
        this.framework = framework;
        this.implementationLanguages = implementationLanguages;
        this.formalisms = formalisms;
        this.hasOriginalSources = hasOriginalSources;
        this.creationDetails = creationDetails;
    }

    public Framework getFramework() {
        return framework;
    }

    public void setFramework(Framework framework) {
        this.framework = framework;
    }

    public List<String> getImplementationLanguages() {
        return implementationLanguages;
    }

    public void setImplementationLanguages(List<String> implementationLanguages) {
        this.implementationLanguages = implementationLanguages;
    }

    public List<String> getFormalisms() {
        return formalisms;
    }

    public void setFormalisms(List<String> formalisms) {
        this.formalisms = formalisms;
    }

    public List<Identifier<ResourceIdentifierSchema>> getHasOriginalSources() {
        return hasOriginalSources;
    }

    public void setHasOriginalSources(List<Identifier<ResourceIdentifierSchema>> hasOriginalSources) {
        this.hasOriginalSources = hasOriginalSources;
    }

    public String getCreationDetails() {
        return creationDetails;
    }

    public void setCreationDetails(String creationDetails) {
        this.creationDetails = creationDetails;
    }
    
    static class FrameworkAdapter extends XmlAdapter<String, ComponentCreationInfo.Framework> {

        @Override
        public String marshal(ComponentCreationInfo.Framework v) throws Exception {
            return v!=null?v.getValue():null;
        }

        @Override
        public ComponentCreationInfo.Framework unmarshal(String v) throws Exception {
            return ComponentCreationInfo.Framework.forValue(v);
        }
    }
}
