package eu.openminted.registry.domain;

import java.util.List;

public class Result {

    private List<Order<Corpus>> corpora;
    private List<Order<Component>> components;

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


}