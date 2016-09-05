package eu.openminted.registry.domain;

/**
 * Created by stefania on 9/5/16.
 */
public class LanguageVarietyInfo {

    enum LanguageVarietyType {

        DIALECT("dialect"),
        JARGON("jargon"),
        OTHER("other");

        private String value;

        LanguageVarietyType(String value) {
            this.value = value;
        }

        public String getValue() {
            return value;
        }
    }

    //required
    private LanguageVarietyType languageVarietyType;
    //required
    private String languageVarietyName;
    private SizeInfo sizePerLanguageVariety;

    public LanguageVarietyInfo() {
    }

    public LanguageVarietyInfo(LanguageVarietyType languageVarietyType, String languageVarietyName) {
        this.languageVarietyType = languageVarietyType;
        this.languageVarietyName = languageVarietyName;
    }

    public LanguageVarietyInfo(LanguageVarietyType languageVarietyType, String languageVarietyName, SizeInfo sizePerLanguageVariety) {
        this.languageVarietyType = languageVarietyType;
        this.languageVarietyName = languageVarietyName;
        this.sizePerLanguageVariety = sizePerLanguageVariety;
    }

    public LanguageVarietyType getLanguageVarietyType() {
        return languageVarietyType;
    }

    public void setLanguageVarietyType(LanguageVarietyType languageVarietyType) {
        this.languageVarietyType = languageVarietyType;
    }

    public String getLanguageVarietyName() {
        return languageVarietyName;
    }

    public void setLanguageVarietyName(String languageVarietyName) {
        this.languageVarietyName = languageVarietyName;
    }

    public SizeInfo getSizePerLanguageVariety() {
        return sizePerLanguageVariety;
    }

    public void setSizePerLanguageVariety(SizeInfo sizePerLanguageVariety) {
        this.sizePerLanguageVariety = sizePerLanguageVariety;
    }
}
