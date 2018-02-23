package eu.openminted.registry.service;

public class WorkflowEngineComponent {

	private String componentID;
	private String componentVersion;
	
	public WorkflowEngineComponent(){
		
	}
	
	public WorkflowEngineComponent(String componentID, String componentVersion) {
		super();
		this.componentID = componentID;
		this.componentVersion = componentVersion;
	}
	
	public String getComponentID() {
		return componentID;
	}
	public void setComponentID(String componentID) {
		this.componentID = componentID;
	}
	public String getComponentVersion() {
		return componentVersion;
	}
	public void setComponentVersion(String componentVersion) {
		this.componentVersion = componentVersion;
	}
	
	
}
