package eu.openminted.registry.domain;

import java.util.List;

/**
 * Created by stefania on 9/5/16.
 */
public class ComponentDependencies {

    enum RequiresHardware {

        GRAPHIC_CARD("graphicCard"),
        MICROPHONE("microphone"),
        ORC_SYSTEM("ocrSystem"),
        SPECIAL_HARDWARE_EQUIPMENT("specialHardwareEquipment"),
        NONE("none"),
        OTHER("other");

        private String value;

        RequiresHardware(String value) {
            this.value = value;
        }

        public String getValue() {
            return value;
        }
    }

    //required
    private RelatedResource typeSystem;
    private List<RelatedResource> tagSets;
    private List<RelatedResource> annotationResources;
    private List<String> softwareLibraries;
    private List<RequiresHardware> requiresHardwareList;

    public ComponentDependencies() {
    }

    public ComponentDependencies(RelatedResource typeSystem) {
        this.typeSystem = typeSystem;
    }

    public ComponentDependencies(RelatedResource typeSystem, List<RelatedResource> tagSets, List<RelatedResource> annotationResources,
                                 List<String> softwareLibraries, List<RequiresHardware> requiresHardwareList) {
        this.typeSystem = typeSystem;
        this.tagSets = tagSets;
        this.annotationResources = annotationResources;
        this.softwareLibraries = softwareLibraries;
        this.requiresHardwareList = requiresHardwareList;
    }

    public RelatedResource getTypeSystem() {
        return typeSystem;
    }

    public void setTypeSystem(RelatedResource typeSystem) {
        this.typeSystem = typeSystem;
    }

    public List<RelatedResource> getTagSets() {
        return tagSets;
    }

    public void setTagSets(List<RelatedResource> tagSets) {
        this.tagSets = tagSets;
    }

    public List<RelatedResource> getAnnotationResources() {
        return annotationResources;
    }

    public void setAnnotationResources(List<RelatedResource> annotationResources) {
        this.annotationResources = annotationResources;
    }

    public List<String> getSoftwareLibraries() {
        return softwareLibraries;
    }

    public void setSoftwareLibraries(List<String> softwareLibraries) {
        this.softwareLibraries = softwareLibraries;
    }

    public List<RequiresHardware> getRequiresHardwareList() {
        return requiresHardwareList;
    }

    public void setRequiresHardwareList(List<RequiresHardware> requiresHardwareList) {
        this.requiresHardwareList = requiresHardwareList;
    }
}
