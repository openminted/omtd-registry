package eu.openminted.registry.domain;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlValue;

public class LangAttributeField {

	@XmlAttribute(name = "lang")
	@XmlSchemaType(name = "lang")
	private String lang;
	
	@XmlValue
	private String value;

	public String getLang() {
		return lang;
	}

	public LangAttributeField() {
	}
	
	public LangAttributeField(String lang, String value) {
		super();
		this.lang = lang;
		this.value = value;
	}



	public void setLang(String lang) {
		this.lang = lang;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}
	
	
}
