package eu.openminted.registry.domain;

import javax.xml.bind.annotation.XmlAttribute;

/**
 * Created by stefania on 9/5/16.
 */
public class Identifier<T extends IdentifierSchema> {

	//@XmlAttribute(name = ResourceIdentifierSchema.ATTRIBUTE_NAME)
	private T schema;
	// @XmlValue
	private String id;
	// @XmlAttribute(name = "schemeURI")
	private String url;

	public Identifier(T schema, String id, String url) {
		this.schema = schema;
		this.id = id;
		this.url = url;
	}

	public Identifier() {
	}

	public T getSchema() {
		return schema;
	}

	public void setSchema(T schema) {
		this.schema = schema;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}
}