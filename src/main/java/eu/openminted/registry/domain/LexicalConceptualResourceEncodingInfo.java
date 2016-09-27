package eu.openminted.registry.domain;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;

/**
 * 
 * @author Steve
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)
public class LexicalConceptualResourceEncodingInfo {
	
	//@XmlElement(name="ms:encodingLevel")
	private List<EncodingLevel> encodingLevel;
	
	//@XmlElement(name="ms:linguisticInformation")
	private List<LinguisticInformation> linguisticInformation;
	
	//@XmlElement(name="ms:conformanceToStandardsBestPractices")
	private List<ConformanceToStandardsBestPractices> conformanceToStandardsBestPractices;
	
	//@XmlElement(name="ms:theoreticModel")
	private List<String> theoreticModel;
	
	//@XmlElement(name="ms:externelRef")
	private List<String> externelRef;
	
	//@XmlElement(name="ms:extratextualInformation")
	private List<ExtratextualInformation> extratextualInformation;
	
	//@XmlElement(name="ms:extraTextualInformationUnit")
	private List<ExtraTextualInformationUnit> extraTextualInformationUnit;

	
	
	
	
	public LexicalConceptualResourceEncodingInfo() {
	}
	
	public LexicalConceptualResourceEncodingInfo(
			List<EncodingLevel> encodingLevel,
			List<LinguisticInformation> linguisticInformation,
			List<ConformanceToStandardsBestPractices> conformanceToStandardsBestPractices,
			List<String> theoreticModel, List<String> externelRef,
			List<ExtratextualInformation> extratextualInformation,
			List<ExtraTextualInformationUnit> extraTextualInformationUnit) {
		super();
		this.encodingLevel = encodingLevel;
		this.linguisticInformation = linguisticInformation;
		this.conformanceToStandardsBestPractices = conformanceToStandardsBestPractices;
		this.theoreticModel = theoreticModel;
		this.externelRef = externelRef;
		this.extratextualInformation = extratextualInformation;
		this.extraTextualInformationUnit = extraTextualInformationUnit;
	}

	public List<EncodingLevel> getEncodingLevel() {
		return encodingLevel;
	}

	public void setEncodingLevel(List<EncodingLevel> encodingLevel) {
		this.encodingLevel = encodingLevel;
	}

	public List<LinguisticInformation> getLinguisticInformation() {
		return linguisticInformation;
	}

	public void setLinguisticInformation(
			List<LinguisticInformation> linguisticInformation) {
		this.linguisticInformation = linguisticInformation;
	}

	public List<ConformanceToStandardsBestPractices> getConformanceToStandardsBestPractices() {
		return conformanceToStandardsBestPractices;
	}

	public void setConformanceToStandardsBestPractices(
			List<ConformanceToStandardsBestPractices> conformanceToStandardsBestPractices) {
		this.conformanceToStandardsBestPractices = conformanceToStandardsBestPractices;
	}

	public List<String> getTheoreticModel() {
		return theoreticModel;
	}

	public void setTheoreticModel(List<String> theoreticModel) {
		this.theoreticModel = theoreticModel;
	}

	public List<String> getExternelRef() {
		return externelRef;
	}

	public void setExternelRef(List<String> externelRef) {
		this.externelRef = externelRef;
	}

	public List<ExtratextualInformation> getExtratextualInformation() {
		return extratextualInformation;
	}

	public void setExtratextualInformation(
			List<ExtratextualInformation> extratextualInformation) {
		this.extratextualInformation = extratextualInformation;
	}

	public List<ExtraTextualInformationUnit> getExtraTextualInformationUnit() {
		return extraTextualInformationUnit;
	}

	public void setExtraTextualInformationUnit(
			List<ExtraTextualInformationUnit> extraTextualInformationUnit) {
		this.extraTextualInformationUnit = extraTextualInformationUnit;
	}

	
	
}
