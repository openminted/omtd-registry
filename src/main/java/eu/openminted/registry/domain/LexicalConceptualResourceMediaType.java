package eu.openminted.registry.domain;

import java.util.List;

public class LexicalConceptualResourceMediaType {
	
	final private MediaType mediaType = MediaType.TEXT;
	
	private List<LingualityInfo> linguilityInfo;
	
	private List<LanguageInfo> metaLanguages;
	
	private List<ModalityInfo> modalities;
	
	private List<SizeInfo> sizes;
	
	private List<DomainInfo> domains;
	
	private List<TimeCoverageInfo> timeClassifications;
	
	private List<GeographicCoverageInfo> geographicClassifications;
	
	private CreationInfo creationInfo;
	
	public LexicalConceptualResourceMediaType() {
	}

	public LexicalConceptualResourceMediaType(
			List<LingualityInfo> linguilityInfo,
			List<LanguageInfo> metaLanguages, List<ModalityInfo> modalities,
			List<SizeInfo> sizes, List<DomainInfo> domains,
			List<TimeCoverageInfo> timeClassifications,
			List<GeographicCoverageInfo> geographicClassifications,
			CreationInfo creationInfo) {
		super();
		this.linguilityInfo = linguilityInfo;
		this.metaLanguages = metaLanguages;
		this.modalities = modalities;
		this.sizes = sizes;
		this.domains = domains;
		this.timeClassifications = timeClassifications;
		this.geographicClassifications = geographicClassifications;
		this.creationInfo = creationInfo;
	}

	public List<LingualityInfo> getLinguilityInfo() {
		return linguilityInfo;
	}

	public void setLinguilityInfo(List<LingualityInfo> linguilityInfo) {
		this.linguilityInfo = linguilityInfo;
	}

	public List<LanguageInfo> getMetaLanguages() {
		return metaLanguages;
	}

	public void setMetaLanguages(List<LanguageInfo> metaLanguages) {
		this.metaLanguages = metaLanguages;
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

	public void setTimeClassifications(List<TimeCoverageInfo> timeClassifications) {
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

	public MediaType getMediaType() {
		return mediaType;
	}
	
}
