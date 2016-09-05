package eu.openminted.registry.domain;

public class Corpus extends Common{

	public String country;
	public int no_pub;
	
	public String getCountry() {
		return country;
	}
	
	public void setCountry(String country) {
		this.country = country;
	}
	
	public int getNo_pub() {
		return no_pub;
	}
	
	public void setNo_pub(int no_pub) {
		this.no_pub = no_pub;
	}
	
}
