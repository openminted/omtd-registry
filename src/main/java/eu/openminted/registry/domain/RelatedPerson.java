package eu.openminted.registry.domain;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import java.util.List;

/**
 * Created by stefania on 9/5/16.
 */
public class RelatedPerson {

    enum PersonIdentifierSchema implements IdentifierSchema {

        ORCID("orcid"),
        ISNI("isni"),
        RESEARCHER_ID("researcherId"),
        SCOPUS_ID("scopusId"),
        OTHER("other");

        private String value;

        PersonIdentifierSchema(String value) {
            this.value = value;
        }

        @Override
        public String getValue() {
            return value;
        }
    }

    //one of the two
    @XmlElementWrapper(name = "personNames")
    @XmlElement(name="personName")
    private List<LangAttributeField> personNames;
    private List<Identifier<PersonIdentifierSchema>> personIdentifiers;

    public RelatedPerson() {
    }

    public List<LangAttributeField> getPersonNames() {
        return personNames;
    }

    public void setPersonNames(List<LangAttributeField> personNames) {
        this.personNames = personNames;
    }

    public List<Identifier<PersonIdentifierSchema>> getPersonIdentifiers() {
        return personIdentifiers;
    }

    public void setPersonIdentifiers(List<Identifier<PersonIdentifierSchema>> personIdentifiers) {
        this.personIdentifiers = personIdentifiers;
    }
}
