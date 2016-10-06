package eu.openminted.registry.domain;

import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlType;

@XmlType(propOrder = { "mediaType", "lingualityInfo", "languages",
		"metalanguages", "modalities", "sizes", "domains",
		"timeClassifications", "geographicClassifications", "creationInfo" })
public class LexicalConceptualResourceMediaType {

	private MediaType mediaType;

	private List<LingualityInfo> lingualityInfo;

	@XmlElementWrapper(name = "languages")
	@XmlElement(name = "languageInfo")
	private List<LanguageInfo> languages;

	@XmlElementWrapper(name = "metalanguages")
    @XmlElement(name = "metalanguageInfo")
	private List<LanguageInfo> metalanguages;

	@XmlElementWrapper(name = "modalities")
    @XmlElement(name = "modalityInfo")
	private List<ModalityInfo> modalities;

    @XmlElementWrapper(name = "sizes")
    @XmlElement(name = "sizeInfo",required = true)
    protected List<SizeInfo> sizes;
    
    @XmlElementWrapper(name = "domains")
    @XmlElement(name = "domainInfo")
    protected List<DomainInfo> domains;
    
    @XmlElementWrapper(name = "timeClassifications")
    @XmlElement(name = "timeCoverageInfo")
    protected List<TimeCoverageInfo> timeClassifications;
    
    @XmlElementWrapper(name = "geographicClassifications")
    @XmlElement(name = "geographicCoverageInfo")
    protected List<GeographicCoverageInfo> geographicClassifications;

	private CreationInfo creationInfo;

	public LexicalConceptualResourceMediaType() {
	}

	public LexicalConceptualResourceMediaType(MediaType mediaType,
			List<LingualityInfo> lingualityInfo, List<LanguageInfo> languages,
			List<LanguageInfo> metalanguages, List<ModalityInfo> modalities,
			List<SizeInfo> sizes, List<DomainInfo> domains,
			List<TimeCoverageInfo> timeClassifications,
			List<GeographicCoverageInfo> geographicClassifications,
			CreationInfo creationInfo) {
		super();
		this.mediaType = mediaType;
		this.lingualityInfo = lingualityInfo;
		this.languages = languages;
		this.metalanguages = metalanguages;
		this.modalities = modalities;
		this.sizes = sizes;
		this.domains = domains;
		this.timeClassifications = timeClassifications;
		this.geographicClassifications = geographicClassifications;
		this.creationInfo = creationInfo;
	}

	public List<LingualityInfo> getLingualityInfo() {
		return lingualityInfo;
	}

	public void setLingualityInfo(List<LingualityInfo> linguilityInfo) {
		this.lingualityInfo = linguilityInfo;
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

	public List<DomainInfo> getDomains() {
		return domains;
	}

	public void setDomains(List<DomainInfo> domains) {
		this.domains = domains;
	}

	public List<TimeCoverageInfo> getTimeClassifications() {
		return timeClassifications;
	}

	public void setTimeClassifications(
			List<TimeCoverageInfo> timeClassifications) {
		this.timeClassifications = timeClassifications;
	}

	public List<GeographicCoverageInfo> getGeographicClassifications() {
		return geographicClassifications;
	}

	public void setGeographicClassifications(
			List<GeographicCoverageInfo> geographicClassifications) {
		this.geographicClassifications = geographicClassifications;
	}

	public CreationInfo getCreationInfo() {
		return creationInfo;
	}

	public void setCreationInfo(CreationInfo creationInfo) {
		this.creationInfo = creationInfo;
	}

	public List<LanguageInfo> getMetalanguages() {
		return metalanguages;
	}

	public void setMetalanguages(List<LanguageInfo> metalanguages) {
		this.metalanguages = metalanguages;
	}

	public MediaType getMediaType() {
		return mediaType;
	}

	public void setMediaType(MediaType mediaType) {
		this.mediaType = mediaType;
	}
}
