
package eu.openminted.registry.domain;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for languageDescriptionEncodingInfoType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="languageDescriptionEncodingInfoType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="encodingLevels"&gt;
 *           &lt;complexType&gt;
 *             &lt;complexContent&gt;
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                 &lt;sequence&gt;
 *                   &lt;element ref="{http://www.meta-share.org/OMTD-SHARE_XMLSchema}encodingLevel" maxOccurs="unbounded"/&gt;
 *                 &lt;/sequence&gt;
 *               &lt;/restriction&gt;
 *             &lt;/complexContent&gt;
 *           &lt;/complexType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="standardsBestPractices" minOccurs="0"&gt;
 *           &lt;complexType&gt;
 *             &lt;complexContent&gt;
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                 &lt;sequence&gt;
 *                   &lt;element name="conformanceToStandardsBestPractices" type="{http://www.meta-share.org/OMTD-SHARE_XMLSchema}conformanceToStandardsBestPractices" maxOccurs="unbounded" minOccurs="0"/&gt;
 *                 &lt;/sequence&gt;
 *               &lt;/restriction&gt;
 *             &lt;/complexContent&gt;
 *           &lt;/complexType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="theoreticModels" minOccurs="0"&gt;
 *           &lt;complexType&gt;
 *             &lt;complexContent&gt;
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                 &lt;sequence&gt;
 *                   &lt;element ref="{http://www.meta-share.org/OMTD-SHARE_XMLSchema}theoreticModel" maxOccurs="unbounded" minOccurs="0"/&gt;
 *                 &lt;/sequence&gt;
 *               &lt;/restriction&gt;
 *             &lt;/complexContent&gt;
 *           &lt;/complexType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="formalisms" minOccurs="0"&gt;
 *           &lt;complexType&gt;
 *             &lt;complexContent&gt;
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                 &lt;sequence&gt;
 *                   &lt;element name="formalism" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *                 &lt;/sequence&gt;
 *               &lt;/restriction&gt;
 *             &lt;/complexContent&gt;
 *           &lt;/complexType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="tasks" minOccurs="0"&gt;
 *           &lt;complexType&gt;
 *             &lt;complexContent&gt;
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                 &lt;sequence&gt;
 *                   &lt;element name="task" maxOccurs="unbounded" minOccurs="0"&gt;
 *                     &lt;simpleType&gt;
 *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *                         &lt;maxLength value="30"/&gt;
 *                         &lt;enumeration value="anaphoraResolution"/&gt;
 *                         &lt;enumeration value="chunking"/&gt;
 *                         &lt;enumeration value="parsing"/&gt;
 *                         &lt;enumeration value="npRecognition"/&gt;
 *                         &lt;enumeration value="titlesParsing"/&gt;
 *                         &lt;enumeration value="definitionsParsing"/&gt;
 *                         &lt;enumeration value="analysis"/&gt;
 *                         &lt;enumeration value="generation"/&gt;
 *                         &lt;enumeration value="other"/&gt;
 *                       &lt;/restriction&gt;
 *                     &lt;/simpleType&gt;
 *                   &lt;/element&gt;
 *                 &lt;/sequence&gt;
 *               &lt;/restriction&gt;
 *             &lt;/complexContent&gt;
 *           &lt;/complexType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="grammaticalPhenomenaCoverages" minOccurs="0"&gt;
 *           &lt;complexType&gt;
 *             &lt;complexContent&gt;
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                 &lt;sequence&gt;
 *                   &lt;element name="grammaticalPhenomenaCoverage" maxOccurs="unbounded" minOccurs="0"&gt;
 *                     &lt;simpleType&gt;
 *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *                         &lt;maxLength value="30"/&gt;
 *                         &lt;enumeration value="clauseStructure"/&gt;
 *                         &lt;enumeration value="ppAttachment"/&gt;
 *                         &lt;enumeration value="npStructure"/&gt;
 *                         &lt;enumeration value="coordination"/&gt;
 *                         &lt;enumeration value="anaphora"/&gt;
 *                         &lt;enumeration value="other"/&gt;
 *                       &lt;/restriction&gt;
 *                     &lt;/simpleType&gt;
 *                   &lt;/element&gt;
 *                   &lt;element name="weightedGrammar" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/&gt;
 *                 &lt;/sequence&gt;
 *               &lt;/restriction&gt;
 *             &lt;/complexContent&gt;
 *           &lt;/complexType&gt;
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
@XmlType(name = "languageDescriptionEncodingInfoType", propOrder = {
    "encodingLevels",
    "standardsBestPractices",
    "theoreticModels",
    "formalisms",
    "tasks",
    "grammaticalPhenomenaCoverages"
})
public class LanguageDescriptionEncodingInfo {

    @XmlElementWrapper(required = true)
    @XmlElement(name = "encodingLevel", namespace = "http://www.meta-share.org/OMTD-SHARE_XMLSchema")
    protected List<EncodingLevelEnum> encodingLevels;
    @XmlElementWrapper
    @XmlElement(name = "conformanceToStandardsBestPractices", namespace = "http://www.meta-share.org/OMTD-SHARE_XMLSchema")
    protected List<ConformanceToStandardsBestPractices> standardsBestPractices;
    @XmlElementWrapper
    @XmlElement(name = "theoreticModel", namespace = "http://www.meta-share.org/OMTD-SHARE_XMLSchema")
    protected List<String> theoreticModels;
    protected Formalisms formalisms;
    @XmlElementWrapper
    @XmlElement(name = "task", namespace = "http://www.meta-share.org/OMTD-SHARE_XMLSchema")
    protected List<TaskEnum> tasks;
    protected GrammaticalPhenomenaCoverages grammaticalPhenomenaCoverages;

    /**
     * Gets the value of the formalisms property.
     * 
     * @return
     *     possible object is
     *     {@link Formalisms }
     *     
     */
    public Formalisms getFormalisms() {
        return formalisms;
    }

    /**
     * Sets the value of the formalisms property.
     * 
     * @param value
     *     allowed object is
     *     {@link Formalisms }
     *     
     */
    public void setFormalisms(Formalisms value) {
        this.formalisms = value;
    }

    /**
     * Gets the value of the grammaticalPhenomenaCoverages property.
     * 
     * @return
     *     possible object is
     *     {@link GrammaticalPhenomenaCoverages }
     *     
     */
    public GrammaticalPhenomenaCoverages getGrammaticalPhenomenaCoverages() {
        return grammaticalPhenomenaCoverages;
    }

    /**
     * Sets the value of the grammaticalPhenomenaCoverages property.
     * 
     * @param value
     *     allowed object is
     *     {@link GrammaticalPhenomenaCoverages }
     *     
     */
    public void setGrammaticalPhenomenaCoverages(GrammaticalPhenomenaCoverages value) {
        this.grammaticalPhenomenaCoverages = value;
    }

    public List<EncodingLevelEnum> getEncodingLevels() {
        if (encodingLevels == null) {
            encodingLevels = new ArrayList<EncodingLevelEnum>();
        }
        return encodingLevels;
    }

    public void setEncodingLevels(List<EncodingLevelEnum> encodingLevels) {
        this.encodingLevels = encodingLevels;
    }

    public List<ConformanceToStandardsBestPractices> getStandardsBestPractices() {
        if (standardsBestPractices == null) {
            standardsBestPractices = new ArrayList<ConformanceToStandardsBestPractices>();
        }
        return standardsBestPractices;
    }

    public void setStandardsBestPractices(List<ConformanceToStandardsBestPractices> standardsBestPractices) {
        this.standardsBestPractices = standardsBestPractices;
    }

    public List<String> getTheoreticModels() {
        if (theoreticModels == null) {
            theoreticModels = new ArrayList<String>();
        }
        return theoreticModels;
    }

    public void setTheoreticModels(List<String> theoreticModels) {
        this.theoreticModels = theoreticModels;
    }

    public List<TaskEnum> getTasks() {
        if (tasks == null) {
            tasks = new ArrayList<TaskEnum>();
        }
        return tasks;
    }

    public void setTasks(List<TaskEnum> tasks) {
        this.tasks = tasks;
    }

}
