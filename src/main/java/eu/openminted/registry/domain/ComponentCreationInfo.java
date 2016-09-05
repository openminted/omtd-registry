package eu.openminted.registry.domain;

import java.util.List;

/**
 * Created by stefania on 9/5/16.
 */
public class ComponentCreationInfo {

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
    }

    //required
    private Framework framework;
    private List<String> implementationLanguages;
    private List<String> formalisms;
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
}
