package eu.openminted.registry.domain;

/**
 * Created by antleb on 9/7/16.
 */
public enum UserType {

	ACADEMIC("academic"),
	COMMERCIAL("commercial"),
	MEMBERS_OF_GROUP("membersOfGroup");

	private String value;

	UserType(String value) {
		this.value = value;
	}

	public String getValue() {
		return value;
	}
}
