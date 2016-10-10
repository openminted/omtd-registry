package eu.openminted.registry.domain;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.XmlAdapter;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

/**
 * Created by stefania on 9/5/16.
 */
@XmlType(propOrder = { "originalDataProviderType", "relatedRepository",
		"relatedJournal", "relatedOrganization" })
public class OriginalDataProviderInfo {

	@XmlJavaTypeAdapter(OriginalDataProviderTypeAdapter.class)
	enum OriginalDataProviderType {

		REPOSITORY("repository"), JOURNAL("journal"), PUBLISHER("publisher");

		private String value;

		OriginalDataProviderType(String value) {
			this.value = value;
		}

		public String getValue() {
			return value;
		}

		public static OriginalDataProviderType forValue(String value) {
			for (OriginalDataProviderType ut : values()) {
				if (ut.getValue().equals(value))
					return ut;
			}

			return null;
		}
	}

	// required
	private OriginalDataProviderType originalDataProviderType;

	// one of the 3
	@XmlElement(name = "originalDataProviderRepository")
	private RelatedRepository relatedRepository;

	@XmlElement(name = "originalDataProviderJournal")
	private RelatedJournal relatedJournal;

	@XmlElement(name = "originalDataProviderOrganization")
	private RelatedOrganization relatedOrganization;

	public OriginalDataProviderInfo() {
	}

	public OriginalDataProviderInfo(
			OriginalDataProviderType originalDataProviderType,
			RelatedRepository relatedRepository) {
		this.originalDataProviderType = originalDataProviderType;
		this.relatedRepository = relatedRepository;
	}

	public OriginalDataProviderInfo(
			OriginalDataProviderType originalDataProviderType,
			RelatedJournal relatedJournal) {
		this.originalDataProviderType = originalDataProviderType;
		this.relatedJournal = relatedJournal;
	}

	public OriginalDataProviderInfo(
			OriginalDataProviderType originalDataProviderType,
			RelatedOrganization relatedOrganization) {
		this.originalDataProviderType = originalDataProviderType;
		this.relatedOrganization = relatedOrganization;
	}

	public OriginalDataProviderType getOriginalDataProviderType() {
		return originalDataProviderType;
	}

	public void setOriginalDataProviderType(
			OriginalDataProviderType originalDataProviderType) {
		this.originalDataProviderType = originalDataProviderType;
	}

	public RelatedRepository getRelatedRepository() {
		return relatedRepository;
	}

	public void setRelatedRepository(RelatedRepository relatedRepository) {
		this.relatedRepository = relatedRepository;
	}

	public RelatedJournal getRelatedJournal() {
		return relatedJournal;
	}

	public void setRelatedJournal(RelatedJournal relatedJournal) {
		this.relatedJournal = relatedJournal;
	}

	public RelatedOrganization getRelatedOrganization() {
		return relatedOrganization;
	}

	public void setRelatedOrganization(RelatedOrganization relatedOrganization) {
		this.relatedOrganization = relatedOrganization;
	}

}

class OriginalDataProviderTypeAdapter extends
		XmlAdapter<String, OriginalDataProviderInfo.OriginalDataProviderType> {

	@Override
	public String marshal(OriginalDataProviderInfo.OriginalDataProviderType v)
			throws Exception {
		return v != null ? v.getValue() : null;
	}

	@Override
	public OriginalDataProviderInfo.OriginalDataProviderType unmarshal(String v)
			throws Exception {
		return OriginalDataProviderInfo.OriginalDataProviderType.forValue(v);
	}
}
