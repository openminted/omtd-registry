package eu.openminted.registry.domain;

import java.util.List;
import java.util.Map;

import eu.openminted.registry.core.domain.Occurencies;

public class Browsing {

	int total;
	 int from;
	 int to;
	 List<Result> results;
	 Occurencies occurencies;

	 public Browsing(int total, int from, int to, List<Result> results, Occurencies occurencies) {
		 this.total = total;
		 this.from = from;
		 this.to = to;
		 this.results = results;
		 this.occurencies = occurencies;
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
	public List<Result> getResults() {
		return results;
	}
	public void setResults(List<Result> results) {
		this.results = results;
	}

	public Occurencies getOccurencies() {
		return occurencies;
	}

	public void setOccurencies(Occurencies occurencies) {
		this.occurencies = occurencies;
	}
	
	
	
}
