package eu.openminted.registry.domain;

/**
 * Created by stefania on 9/5/16.
 */
public class DomainInfo {

    //required
    private Identifier<ClassificationScheme> domain;
    private SizeInfo sizePerDomain;

    public DomainInfo() {
    }

    public DomainInfo(Identifier<ClassificationScheme> domain) {
        this.domain = domain;
    }

    public DomainInfo(Identifier<ClassificationScheme> domain, SizeInfo sizePerDomain) {
        this.domain = domain;
        this.sizePerDomain = sizePerDomain;
    }

    public Identifier<ClassificationScheme> getDomain() {
        return domain;
    }

    public void setDomain(Identifier<ClassificationScheme> domain) {
        this.domain = domain;
    }

    public SizeInfo getSizePerDomain() {
        return sizePerDomain;
    }

    public void setSizePerDomain(SizeInfo sizePerDomain) {
        this.sizePerDomain = sizePerDomain;
    }
}
