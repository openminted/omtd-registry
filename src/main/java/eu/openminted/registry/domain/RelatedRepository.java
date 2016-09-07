package eu.openminted.registry.domain;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import java.util.List;

/**
 * Created by stefania on 9/5/16.
 */
public class RelatedRepository {

    enum RepositoryIdentifierSchema implements IdentifierSchema {

        DOI("doi"),
        HDL("hdl"),
        URL("url"),
        OAI("oai"),
        OPENDOAR("opendoar"),
        RE3D("re3d"),
        ROAR("roar"),
        OTHER("other");

        private String value;

        RepositoryIdentifierSchema(String value) {
            this.value = value;
        }

        @Override
        public String getValue() {
            return value;
        }
    }

    //one of the two
    @XmlElementWrapper(name="repositoryNames")
    @XmlElement(name="repositoryName")
    private List<String> repositoryNames;
    private List<Identifier<RepositoryIdentifierSchema>> repositoryIdentifiers;

    public RelatedRepository() {
    }

    public List<String> getRepositoryNames() {
        return repositoryNames;
    }

    public void setRepositoryNames(List<String> repositoryNames) {
        this.repositoryNames = repositoryNames;
    }

    public List<Identifier<RepositoryIdentifierSchema>> getRepositoryIdentifiers() {
        return repositoryIdentifiers;
    }

    public void setRepositoryIdentifiers(List<Identifier<RepositoryIdentifierSchema>> repositoryIdentifiers) {
        this.repositoryIdentifiers = repositoryIdentifiers;
    }
}
