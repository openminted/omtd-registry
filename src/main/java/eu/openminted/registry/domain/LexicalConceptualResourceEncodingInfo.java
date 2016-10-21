
package eu.openminted.registry.domain;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for lexicalConceptualResourceEncodingInfoType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="lexicalConceptualResourceEncodingInfoType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element ref="{http://www.meta-share.org/OMTD-SHARE_XMLSchema}encodingLevel" maxOccurs="unbounded"/&gt;
 *         &lt;element name="linguisticInformation" maxOccurs="unbounded" minOccurs="0"&gt;
 *           &lt;simpleType&gt;
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *               &lt;maxLength value="50"/&gt;
 *               &lt;enumeration value="accentuation"/&gt;
 *               &lt;enumeration value="lemma"/&gt;
 *               &lt;enumeration value="lemma-MultiWordUnits"/&gt;
 *               &lt;enumeration value="lemma-Variants"/&gt;
 *               &lt;enumeration value="lemma-Abbreviations"/&gt;
 *               &lt;enumeration value="lemma-Compounds"/&gt;
 *               &lt;enumeration value="lemma-CliticForms"/&gt;
 *               &lt;enumeration value="partOfSpeech"/&gt;
 *               &lt;enumeration value="morpho-Features"/&gt;
 *               &lt;enumeration value="morpho-Case"/&gt;
 *               &lt;enumeration value="morpho-Gender"/&gt;
 *               &lt;enumeration value="morpho-Number"/&gt;
 *               &lt;enumeration value="morpho-Degree"/&gt;
 *               &lt;enumeration value="morpho-IrregularForms"/&gt;
 *               &lt;enumeration value="morpho-Mood"/&gt;
 *               &lt;enumeration value="morpho-Tense"/&gt;
 *               &lt;enumeration value="morpho-Person"/&gt;
 *               &lt;enumeration value="morpho-Aspect"/&gt;
 *               &lt;enumeration value="morpho-Voice"/&gt;
 *               &lt;enumeration value="morpho-Auxiliary"/&gt;
 *               &lt;enumeration value="morpho-Inflection"/&gt;
 *               &lt;enumeration value="morpho-Reflexivity"/&gt;
 *               &lt;enumeration value="syntax-SubcatFrame"/&gt;
 *               &lt;enumeration value="semantics-Traits"/&gt;
 *               &lt;enumeration value="semantics-SemanticClass"/&gt;
 *               &lt;enumeration value="semantics-CrossReferences"/&gt;
 *               &lt;enumeration value="semantics-Relations"/&gt;
 *               &lt;enumeration value="semantics-Relations-Hyponyms"/&gt;
 *               &lt;enumeration value="semantics-Relations-Hyperonyms"/&gt;
 *               &lt;enumeration value="semantics-Relations-Synonyms"/&gt;
 *               &lt;enumeration value="semantics-Relations-Antonyms"/&gt;
 *               &lt;enumeration value="semantics-Relations-Troponyms"/&gt;
 *               &lt;enumeration value="semantics-Relations-Meronyms"/&gt;
 *               &lt;enumeration value="usage-Frequency"/&gt;
 *               &lt;enumeration value="usage-Register"/&gt;
 *               &lt;enumeration value="usage-Collocations"/&gt;
 *               &lt;enumeration value="usage-Examples"/&gt;
 *               &lt;enumeration value="usage-Notes"/&gt;
 *               &lt;enumeration value="definition/gloss"/&gt;
 *               &lt;enumeration value="translationEquivalent"/&gt;
 *               &lt;enumeration value="phonetics-Transcription"/&gt;
 *               &lt;enumeration value="semantics-Domain"/&gt;
 *               &lt;enumeration value="semantics-EventType"/&gt;
 *               &lt;enumeration value="semantics-SemanticRoles"/&gt;
 *               &lt;enumeration value="statisticalProperties"/&gt;
 *               &lt;enumeration value="morpho-Derivation"/&gt;
 *               &lt;enumeration value="semantics-QualiaStructure"/&gt;
 *               &lt;enumeration value="syntacticoSemanticLinks"/&gt;
 *               &lt;enumeration value="other"/&gt;
 *             &lt;/restriction&gt;
 *           &lt;/simpleType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="conformanceToStandardsBestPractices" type="{http://www.meta-share.org/OMTD-SHARE_XMLSchema}conformanceToStandardsBestPractices" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;element ref="{http://www.meta-share.org/OMTD-SHARE_XMLSchema}theoreticModel" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;element name="externalRef" maxOccurs="unbounded" minOccurs="0"&gt;
 *           &lt;simpleType&gt;
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *               &lt;maxLength value="100"/&gt;
 *             &lt;/restriction&gt;
 *           &lt;/simpleType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="extratextualInformation" maxOccurs="unbounded" minOccurs="0"&gt;
 *           &lt;simpleType&gt;
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *               &lt;maxLength value="30"/&gt;
 *               &lt;enumeration value="images"/&gt;
 *               &lt;enumeration value="videos"/&gt;
 *               &lt;enumeration value="soundRecordings"/&gt;
 *               &lt;enumeration value="other"/&gt;
 *             &lt;/restriction&gt;
 *           &lt;/simpleType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="extraTextualInformationUnit" maxOccurs="unbounded" minOccurs="0"&gt;
 *           &lt;simpleType&gt;
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *               &lt;maxLength value="30"/&gt;
 *               &lt;enumeration value="word"/&gt;
 *               &lt;enumeration value="lemma"/&gt;
 *               &lt;enumeration value="semantics"/&gt;
 *               &lt;enumeration value="example"/&gt;
 *               &lt;enumeration value="syntax"/&gt;
 *               &lt;enumeration value="lexicalUnit"/&gt;
 *               &lt;enumeration value="other"/&gt;
 *             &lt;/restriction&gt;
 *           &lt;/simpleType&gt;
 *         &lt;/element&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "lexicalConceptualResourceEncodingInfoType", propOrder = {
    "encodingLevel",
    "linguisticInformation",
    "conformanceToStandardsBestPractices",
    "theoreticModel",
    "externalRef",
    "extratextualInformation",
    "extraTextualInformationUnit"
})
public class LexicalConceptualResourceEncodingInfo {

    @XmlElement(required = true)
    protected List<EncodingLevelEnum> encodingLevel;
    protected List<LinguisticInformationEnum> linguisticInformation;
    @XmlSchemaType(name = "string")
    protected List<ConformanceToStandardsBestPractices> conformanceToStandardsBestPractices;
    protected List<String> theoreticModel;
    protected List<String> externalRef;
    protected List<ExtratextualInformationEnum> extratextualInformation;
    protected List<ExtraTextualInformationUnitEnum> extraTextualInformationUnit;

    /**
     * Gets the value of the encodingLevel property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the encodingLevel property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getEncodingLevel().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link EncodingLevelEnum }
     * 
     * 
     */
    public List<EncodingLevelEnum> getEncodingLevel() {
        if (encodingLevel == null) {
            encodingLevel = new ArrayList<EncodingLevelEnum>();
        }
        return this.encodingLevel;
    }

    /**
     * Gets the value of the linguisticInformation property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the linguisticInformation property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getLinguisticInformation().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link LinguisticInformationEnum }
     * 
     * 
     */
    public List<LinguisticInformationEnum> getLinguisticInformation() {
        if (linguisticInformation == null) {
            linguisticInformation = new ArrayList<LinguisticInformationEnum>();
        }
        return this.linguisticInformation;
    }

    /**
     * Gets the value of the conformanceToStandardsBestPractices property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the conformanceToStandardsBestPractices property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getConformanceToStandardsBestPractices().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ConformanceToStandardsBestPractices }
     * 
     * 
     */
    public List<ConformanceToStandardsBestPractices> getConformanceToStandardsBestPractices() {
        if (conformanceToStandardsBestPractices == null) {
            conformanceToStandardsBestPractices = new ArrayList<ConformanceToStandardsBestPractices>();
        }
        return this.conformanceToStandardsBestPractices;
    }

    /**
     * Gets the value of the theoreticModel property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the theoreticModel property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getTheoreticModel().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link String }
     * 
     * 
     */
    public List<String> getTheoreticModel() {
        if (theoreticModel == null) {
            theoreticModel = new ArrayList<String>();
        }
        return this.theoreticModel;
    }

    /**
     * Gets the value of the externalRef property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the externalRef property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getExternalRef().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link String }
     * 
     * 
     */
    public List<String> getExternalRef() {
        if (externalRef == null) {
            externalRef = new ArrayList<String>();
        }
        return this.externalRef;
    }

    /**
     * Gets the value of the extratextualInformation property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the extratextualInformation property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getExtratextualInformation().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ExtratextualInformationEnum }
     * 
     * 
     */
    public List<ExtratextualInformationEnum> getExtratextualInformation() {
        if (extratextualInformation == null) {
            extratextualInformation = new ArrayList<ExtratextualInformationEnum>();
        }
        return this.extratextualInformation;
    }

    /**
     * Gets the value of the extraTextualInformationUnit property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the extraTextualInformationUnit property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getExtraTextualInformationUnit().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ExtraTextualInformationUnitEnum }
     * 
     * 
     */
    public List<ExtraTextualInformationUnitEnum> getExtraTextualInformationUnit() {
        if (extraTextualInformationUnit == null) {
            extraTextualInformationUnit = new ArrayList<ExtraTextualInformationUnitEnum>();
        }
        return this.extraTextualInformationUnit;
    }

}
