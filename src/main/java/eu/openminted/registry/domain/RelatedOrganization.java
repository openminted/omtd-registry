package eu.openminted.registry.domain;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;

/**
 * Created by stefania on 9/5/16.
 */
@XmlAccessorType(XmlAccessType.FIELD)
public class RelatedOrganization {

    enum OrganizationIdentifierSchema implements IdentifierSchema {

        ISNI("isni"),
        FUNDREF("fundref"),
        OTHER("other");

        private String value;

        OrganizationIdentifierSchema(String value) {
            this.value = value;
        }

        @Override
        public String getValue() {
            return value;
        }
    }

    //one of the two
    @XmlElementWrapper(name = "organizationNames")
    @XmlElement(name="organizationName")
    private List<String> organizationNames;
    
    @XmlElementWrapper(name = "organizationIdentifiers")
    @XmlElement(name="organizationIdentifier")
    private List<Identifier<OrganizationIdentifierSchema>> organizationIdentifiers;

    public RelatedOrganization() {
    }

    public List<String> getOrganizationNames() {
        return organizationNames;
    }

    public void setOrganizationNames(List<String> organizationNames) {
        this.organizationNames = organizationNames;
    }

    public List<Identifier<OrganizationIdentifierSchema>> getOrganizationIdentifiers() {
        return organizationIdentifiers;
    }

    public void setOrganizationIdentifiers(List<Identifier<OrganizationIdentifierSchema>> organizationIdentifiers) {
        this.organizationIdentifiers = organizationIdentifiers;
    }
}
