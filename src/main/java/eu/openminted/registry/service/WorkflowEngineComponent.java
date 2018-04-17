package eu.openminted.registry.service;

public class WorkflowEngineComponent {

	private String name;
	private String componentID;
	private String componentVersion;
	
	private String location;
	
	public WorkflowEngineComponent(){
		
	}
	
	public WorkflowEngineComponent(String componentID, String componentVersion) {
		super();
		this.componentID = componentID;
		this.componentVersion = componentVersion;
	}

	public WorkflowEngineComponent(String componentID, String componentVersion, String name) {
		this.componentID = componentID;
		this.componentVersion = componentVersion;
		this.name = name;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
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


	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
