package eu.openminted.registry.domain;

import java.util.List;

/**
 * Created by stefania on 9/5/16.
 */
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
    private List<String> organizationNames;
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
