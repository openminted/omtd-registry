package eu.openminted.registry.domain;

import java.util.List;

/**
 * Created by stefania on 9/5/16.
 */
public class CorpusTextPartInfo {

    //required
    private final String mediaType = "text";
    //required
    private LingualityInfo lingualityInfo;
    //required
    private List<LanguageInfo> languages;
    private List<ModalityInfo> modalities;
    //required
    private List<SizeInfo> sizes;
    private List<TextFormatInfo> textFormats;
    private List<CharacterEncodingInfo> characterEncodings;
    private List<DomainInfo> domains;
    private List<TextClassificationInfo> textClassifications;
    private List<TimeCoverageInfo> timeClassifications;
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
