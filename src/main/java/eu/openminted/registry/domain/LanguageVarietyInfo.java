package eu.openminted.registry.domain;

import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.XmlAdapter;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

/**
 * Created by stefania on 9/5/16.
 */

@XmlType(name = "languageVarietyInfoType", propOrder = {
	    "languageVarietyType",
	    "languageVarietyName",
	    "sizePerLanguageVariety"
	})
public class LanguageVarietyInfo {

	@XmlJavaTypeAdapter(LanguageVarietyTypeAdapter.class)
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
        
        public static LanguageVarietyType forValue(String value) {
            for (LanguageVarietyType ut: values()) {
                if (ut.getValue().equals(value))
                    return ut;
            }

            return null;
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


class LanguageVarietyTypeAdapter extends XmlAdapter<String, LanguageVarietyInfo.LanguageVarietyType> {

    @Override
    public String marshal(LanguageVarietyInfo.LanguageVarietyType v) throws Exception {
        return v!=null?v.getValue():null;
    }

    @Override
    public LanguageVarietyInfo.LanguageVarietyType unmarshal(String v) throws Exception {
        return LanguageVarietyInfo.LanguageVarietyType.forValue(v);
    }
}
