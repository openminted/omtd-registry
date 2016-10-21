package eu.openminted.registry.domain;

import java.util.List;

public class Result {

	private List<Corpus> corpora;
	private List<Component> components;
	
	public List<Corpus> getCorpora() {
		return corpora;
	}
	public void setCorpora(List<Corpus> corpora) {
		this.corpora = corpora;
	}
	public List<Component> getComponents() {
		return components;
	}
	public void setComponents(List<Component> components) {
		this.components = components;
	}
	
}