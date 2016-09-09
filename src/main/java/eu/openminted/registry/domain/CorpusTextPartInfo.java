package eu.openminted.registry.domain;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import java.util.List;

/**
 * Created by stefania on 9/5/16.
 */
@XmlAccessorType(XmlAccessType.FIELD)
public class CorpusTextPartInfo {

    //required
    private final String mediaType = "text";
    //required
    private LingualityInfo lingualityInfo;
    //required
    @XmlElementWrapper(name="languages")
    @XmlElement(name="languageInfo")
    private List<LanguageInfo> languages;
    @XmlElementWrapper(name = "modalities")
    @XmlElement(name="modalityInfo")
    private List<ModalityInfo> modalities;
    //required
    @XmlElementWrapper(name = "sizes")
    @XmlElement(name="sizeInfo")
    private List<SizeInfo> sizes;
    @XmlElementWrapper(name="textFormats")
    @XmlElement(name = "textFormatInfo")
    private List<TextFormatInfo> textFormats;
    @XmlElementWrapper(name="characterEncodings")
    @XmlElement(name = "characterEncodingInfo")
    private List<CharacterEncodingInfo> characterEncodings;
    @XmlElementWrapper(name="domains")
    @XmlElement(name = "domainInfo")
    private List<DomainInfo> domains;
    @XmlElementWrapper(name="textClassifications")
    @XmlElement(name = "textClassificationInfo")
    private List<TextClassificationInfo> textClassifications;
    @XmlElementWrapper(name="timeClassifications")
    @XmlElement(name = "timeCoverageInfo")
    private List<TimeCoverageInfo> timeClassifications;
    @XmlElementWrapper(name="geographicClassifications")
    @XmlElement(name="GeographicCoverageInfo")
    private List<GeographicCoverageInfo> geographicClassifications;
    private CreationInfo creationInfo;

    public CorpusTextPartInfo() {
    }

    public CorpusTextPartInfo(LingualityInfo lingualityInfo, List<LanguageInfo> languages, List<SizeInfo> sizes) {
        this.lingualityInfo = lingualityInfo;
        this.languages = languages;
        this.sizes = sizes;
    }

    public CorpusTextPartInfo(LingualityInfo lingualityInfo, List<LanguageInfo> languages, List<ModalityInfo> modalities,
                              List<SizeInfo> sizes, List<TextFormatInfo> textFormats, List<CharacterEncodingInfo> characterEncodings,
                              List<DomainInfo> domains, List<TextClassificationInfo> textClassifications,
                              List<TimeCoverageInfo> timeClassifications, List<GeographicCoverageInfo> geographicClassifications,
                              CreationInfo creationInfo) {
        this.lingualityInfo = lingualityInfo;
        this.languages = languages;
        this.modalities = modalities;
        this.sizes = sizes;
        this.textFormats = textFormats;
        this.characterEncodings = characterEncodings;
        this.domains = domains;
        this.textClassifications = textClassifications;
        this.timeClassifications = timeClassifications;
        this.geographicClassifications = geographicClassifications;
        this.creationInfo = creationInfo;
    }

    public String getMediaType() {
        return mediaType;
    }

    public LingualityInfo getLingualityInfo() {
        return lingualityInfo;
    }

    public void setLingualityInfo(LingualityInfo lingualityInfo) {
        this.lingualityInfo = lingualityInfo;
    }

    public List<LanguageInfo> getLanguages() {
        return languages;
    }

    public void setLanguages(List<LanguageInfo> languages) {
        this.languages = languages;
    }

    public List<ModalityInfo> getModalities() {
        return modalities;
    }

    public void setModalities(List<ModalityInfo> modalities) {
        this.modalities = modalities;
    }

    public List<SizeInfo> getSizes() {
        return sizes;
    }

    public void setSizes(List<SizeInfo> sizes) {
        this.sizes = sizes;
    }

    public List<TextFormatInfo> getTextFormats() {
        return textFormats;
    }

    public void setTextFormats(List<TextFormatInfo> textFormats) {
        this.textFormats = textFormats;
    }

    public List<CharacterEncodingInfo> getCharacterEncodings() {
        return characterEncodings;
    }

    public void setCharacterEncodings(List<CharacterEncodingInfo> characterEncodings) {
        this.characterEncodings = characterEncodings;
    }

    public List<DomainInfo> getDomains() {
        return domains;
    }

    public void setDomains(List<DomainInfo> domains) {
        this.domains = domains;
    }

    public List<TextClassificationInfo> getTextClassifications() {
        return textClassifications;
    }

    public void setTextClassifications(List<TextClassificationInfo> textClassifications) {
        this.textClassifications = textClassifications;
    }

    public List<TimeCoverageInfo> getTimeClassifications() {
        return timeClassifications;
    }

    public void setTimeClassifications(List<TimeCoverageInfo> timeClassifications) {
        this.timeClassifications = timeClassifications;
    }

    public List<GeographicCoverageInfo> getGeographicClassifications() {
        return geographicClassifications;
    }

    public void setGeographicClassifications(List<GeographicCoverageInfo> geographicClassifications) {
        this.geographicClassifications = geographicClassifications;
    }

    public CreationInfo getCreationInfo() {
        return creationInfo;
    }

    public void setCreationInfo(CreationInfo creationInfo) {
        this.creationInfo = creationInfo;
    }
}
