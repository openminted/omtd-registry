package eu.openminted.registry.domain;

import java.util.List;

public class Result {

    private List<Order<Corpus>> corpora;
    private List<Order<Component>> components;
    private List<Order<Lexical>> lexicalConceptualResources;
    private List<Order<Model>> models;
    private List<Order<LanguageDescription>> languageDescriptions;

    public List<Order<Corpus>> getCorpora() {
        return corpora;
    }

    public void setCorpora(List<Order<Corpus>> corpora) {
        this.corpora = corpora;
    }

    public List<Order<Component>> getComponents() {
        return components;
    }

    public void setComponents(List<Order<Component>> components) {
        this.components = components;
    }

    public int getTotal() {
        return corpora.size() + components.size();
    }

    public List<Order<Lexical>> getLexicalConceptualResources() {
        return lexicalConceptualResources;
    }

    public void setLexicalConceptualResources(List<Order<Lexical>> lexicalConceptualResources) {
        this.lexicalConceptualResources = lexicalConceptualResources;
    }

    public List<Order<Model>> getModels() {
        return models;
    }

    public void setModels(List<Order<Model>> models) {
        this.models = models;
    }

    public List<Order<LanguageDescription>> getLanguageDescriptions() {
        return languageDescriptions;
    }

    public void setLanguageDescriptions(List<Order<LanguageDescription>> languageDescriptions) {
        this.languageDescriptions = languageDescriptions;
    }
}