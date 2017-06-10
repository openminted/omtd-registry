package eu.openminted.registry.domain;

import java.util.List;

public class Browsing {

    int total;
    int from;
    int to;
    List<Order<BaseMetadataRecord>> results;
    List<Facet> facets;

    public Browsing(int total, int from, int to, List<Order<BaseMetadataRecord>> results, List<Facet> facets) {
        this.total = total;
        this.from = from;
        this.to = to;
        this.results = results;
        this.facets = facets;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public int getFrom() {
        return from;
    }

    public void setFrom(int from) {
        this.from = from;
    }

    public int getTo() {
        return to;
    }

    public void setTo(int to) {
        this.to = to;
    }

    public List<Order<BaseMetadataRecord>> getResults() {
        return results;
    }

    public void setResults(List<Order<BaseMetadataRecord>> results) {
        this.results = results;
    }

    public List<Facet> getFacets() {
        return facets;
    }

    public void setFacets(List<Facet> facets) {
        this.facets = facets;
    }


}
