package eu.openminted.registry.domain;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.adapters.XmlAdapter;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import java.util.List;

/**
 * Created by stefania on 9/5/16.
 */
@XmlAccessorType(XmlAccessType.FIELD)
public class ProcessingResourceInfo {

    @XmlJavaTypeAdapter(ResourceTypeAdapter.class)
    enum ResourceType {

        CORPUS("corpus"),
        DOCUMENT("document"),
        USER_INPUT_TEXT("userInputText"),
        LEXICAL_CONCEPTUAL_RESOURCE("lexicalConceptualResource"),
        LANGUAGE_DESCRIPTION("languageDescription");

        private String value;

        ResourceType(String value) {
            this.value = value;
        }

        public String getValue() {
            return value;
        }

        public static ResourceType forValue(String value) {
            for (ResourceType ut: values()) {
                if (ut.getValue().equals(value))
                    return ut;
            }

            return null;
        }
    }

    //required ??
    @XmlElementWrapper(name="resourceTypes")
    @XmlElement(name="resourceType")
    private List<ResourceType> resourceTypes;
    //required
    @XmlElement(name="mediaType")
    private MediaType mediaType;
    @XmlElementWrapper(name="languages")
    @XmlElement(name="language")
    private List<Language> languages;
    @XmlElementWrapper(name="characterEncodings")
    @XmlElement(name="characterEncoding")
    private List<CharacterEncoding> characterEncodings;
    @XmlElementWrapper(name="dataFormats")
    @XmlElement(name="dataFormat")
    private List<DataFormat> dataFormats;
    @XmlElement(name="typeSystem")
    private RelatedResource typeSystem;
    @XmlElement(name="tagSet")
    private RelatedResource tagSet;
    @XmlElementWrapper(name="annotationLevels")
    @XmlElement(name="annotationLevel")
    private List<AnnotationLevel> annotationLevels;
    @XmlElementWrapper(name="modalityTypes")
    @XmlElement(name="modalityType")
    private List<ModalityType> modalityTypes;
    private List<Identifier<ClassificationScheme>> domains;
    private List<Identifier<ClassificationScheme>> textGenres;
    private List<Identifier<ClassificationScheme>> textTypes;
    private List<Identifier<ClassificationScheme>> registers;
    private List<Identifier<ClassificationScheme>> subjects;
    private List<String> keywords;

    public ProcessingResourceInfo() {
    }

    public ProcessingResourceInfo(List<ResourceType> resourceTypes, MediaType mediaType) {
        this.resourceTypes = resourceTypes;
        this.mediaType = mediaType;
    }

    public ProcessingResourceInfo(List<ResourceType> resourceTypes, MediaType mediaType, List<Language> languages,
                                  List<CharacterEncoding> characterEncodings, List<DataFormat> dataFormats, RelatedResource typeSystem,
                                  RelatedResource tagSet, List<AnnotationLevel> annotationLevels, List<ModalityType> modalityTypes,
                                  List<Identifier<ClassificationScheme>> domains, List<Identifier<ClassificationScheme>> textGenres,
                                  List<Identifier<ClassificationScheme>> textTypes, List<Identifier<ClassificationScheme>> registers,
                                  List<Identifier<ClassificationScheme>> subjects, List<String> keywords) {
        this.resourceTypes = resourceTypes;
        this.mediaType = mediaType;
        this.languages = languages;
        this.characterEncodings = characterEncodings;
        this.dataFormats = dataFormats;
        this.typeSystem = typeSystem;
        this.tagSet = tagSet;
        this.annotationLevels = annotationLevels;
        this.modalityTypes = modalityTypes;
        this.domains = domains;
        this.textGenres = textGenres;
        this.textTypes = textTypes;
        this.registers = registers;
        this.subjects = subjects;
        this.keywords = keywords;
    }

    public List<ResourceType> getResourceTypes() {
        return resourceTypes;
    }

    public void setResourceTypes(List<ResourceType> resourceTypes) {
        this.resourceTypes = resourceTypes;
    }

    public MediaType getMediaType() {
        return mediaType;
    }

    public void setMediaType(MediaType mediaType) {
        this.mediaType = mediaType;
    }

    public List<Language> getLanguages() {
        return languages;
    }

    public void setLanguages(List<Language> languages) {
        this.languages = languages;
    }

    public List<CharacterEncoding> getCharacterEncodings() {
        return characterEncodings;
    }

    public void setCharacterEncodings(List<CharacterEncoding> characterEncodings) {
        this.characterEncodings = characterEncodings;
    }

    public List<DataFormat> getDataFormats() {
        return dataFormats;
    }

    public void setDataFormats(List<DataFormat> dataFormats) {
        this.dataFormats = dataFormats;
    }

    public RelatedResource getTypeSystem() {
        return typeSystem;
    }

    public void setTypeSystem(RelatedResource typeSystem) {
        this.typeSystem = typeSystem;
    }

    public RelatedResource getTagSet() {
        return tagSet;
    }

    public void setTagSet(RelatedResource tagSet) {
        this.tagSet = tagSet;
    }

    public List<AnnotationLevel> getAnnotationLevels() {
        return annotationLevels;
    }

    public void setAnnotationLevels(List<AnnotationLevel> annotationLevels) {
        this.annotationLevels = annotationLevels;
    }

    public List<ModalityType> getModalityTypes() {
        return modalityTypes;
    }

    public void setModalityTypes(List<ModalityType> modalityTypes) {
        this.modalityTypes = modalityTypes;
    }

    public List<Identifier<ClassificationScheme>> getDomains() {
        return domains;
    }

    public void setDomains(List<Identifier<ClassificationScheme>> domains) {
        this.domains = domains;
    }

    public List<Identifier<ClassificationScheme>> getTextGenres() {
        return textGenres;
    }

    public void setTextGenres(List<Identifier<ClassificationScheme>> textGenres) {
        this.textGenres = textGenres;
    }

    public List<Identifier<ClassificationScheme>> getTextTypes() {
        return textTypes;
    }

    public void setTextTypes(List<Identifier<ClassificationScheme>> textTypes) {
        this.textTypes = textTypes;
    }

    public List<Identifier<ClassificationScheme>> getRegisters() {
        return registers;
    }

    public void setRegisters(List<Identifier<ClassificationScheme>> registers) {
        this.registers = registers;
    }

    public List<Identifier<ClassificationScheme>> getSubjects() {
        return subjects;
    }

    public void setSubjects(List<Identifier<ClassificationScheme>> subjects) {
        this.subjects = subjects;
    }

    public List<String> getKeywords() {
        return keywords;
    }

    public void setKeywords(List<String> keywords) {
        this.keywords = keywords;
    }
}

class ResourceTypeAdapter extends XmlAdapter<String, ProcessingResourceInfo.ResourceType> {

    @Override
    public String marshal(ProcessingResourceInfo.ResourceType v) throws Exception {
        return v!=null?v.getValue():null;
    }

    @Override
    public ProcessingResourceInfo.ResourceType unmarshal(String v) throws Exception {
        return ProcessingResourceInfo.ResourceType.forValue(v);
    }
}

