package eu.openminted.registry.domain;

import javax.xml.bind.annotation.adapters.XmlAdapter;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

/**
 * Created by antleb on 9/7/16.
 */
@XmlJavaTypeAdapter(UserTypeAdapter.class)
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

	public static UserType forValue(String value) {
		for (UserType ut: UserType.values()) {
			if (ut.getValue().equals(value))
				return ut;
		}

		return null;
	}
}

class UserTypeAdapter extends XmlAdapter<String, UserType> {

	@Override
	public String marshal(UserType v) throws Exception {
		return v!=null?v.getValue():null;
	}

	@Override
	public UserType unmarshal(String v) throws Exception {
		return UserType.forValue(v);
	}
}

