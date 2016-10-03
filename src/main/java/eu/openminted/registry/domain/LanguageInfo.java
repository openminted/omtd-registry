package eu.openminted.registry.domain;

import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlType;

/**
 * Created by stefania on 9/5/16.
 */
@XmlType(name = "languageInfo", propOrder = {
	    "language",
	    "sizePerLanguage",
	    "languageVarieties"
	})
public class LanguageInfo {

    //required
    private Language language;
    private SizeInfo sizePerLanguage;
    
    @XmlElementWrapper(name = "languageVarieties")
    @XmlElement(name = "languageVarietyInfo")
    private List<LanguageVarietyInfo> languageVarieties;

    public LanguageInfo() {
    }

    public LanguageInfo(Language language) {
        this.language = language;
    }

    public LanguageInfo(Language language, SizeInfo sizePerLanguage, List<LanguageVarietyInfo> languageVarieties) {
        this.language = language;
        this.sizePerLanguage = sizePerLanguage;
        this.languageVarieties = languageVarieties;
    }

    public Language getLanguage() {
        return language;
    }

    public void setLanguage(Language language) {
        this.language = language;
    }

    public SizeInfo getSizePerLanguage() {
        return sizePerLanguage;
    }

    public void setSizePerLanguage(SizeInfo sizePerLanguage) {
        this.sizePerLanguage = sizePerLanguage;
    }

    public List<LanguageVarietyInfo> getLanguageVarieties() {
        return languageVarieties;
    }

    public void setLanguageVarieties(List<LanguageVarietyInfo> languageVarieties) {
        this.languageVarieties = languageVarieties;
    }
}
