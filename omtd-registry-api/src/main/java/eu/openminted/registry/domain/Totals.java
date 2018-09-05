package eu.openminted.registry.domain;

public class Totals{

    private int publications = 0;

    private Components components;

    private Applications applications;

    public Totals() {
    }

    public Totals(int publications, int components_public, int applications_public, int components_private, int applications_private) {
        this.publications = publications;
        applications = new Applications(applications_public, applications_private);
        components = new Components(components_public, components_private);
    }

    public int getPublications() {
        return publications;
    }

    public void setPublications(int publications) {
        this.publications = publications;
    }

    public Components getComponents() {
        return components;
    }

    public void setComponents(Components components) {
        this.components = components;
    }

    public Applications getApplications() {
        return applications;
    }

    public void setApplications(Applications applications) {
        this.applications = applications;
    }

    static public class Components{
        private int pub=0;

        private int priv=0;

        public Components() {

        }

        public Components(int pub, int priv) {
            this.pub = pub;
            this.priv = priv;
        }

        public int getPub() {
            return pub;
        }

        public void setPub(int pub) {
            this.pub = pub;
        }

        public int getPriv() {
            return priv;
        }

        public void setPriv(int priv) {
            this.priv = priv;
        }
    }

    static public class Applications{

        private int pub=0;

        private int priv=0;

        public Applications() {

        }

        public Applications(int pub, int priv) {
            this.pub = pub;
            this.priv = priv;
        }

        public int getPub() {
            return pub;
        }

        public void setPub(int pub) {
            this.pub = pub;
        }

        public int getPriv() {
            return priv;
        }

        public void setPriv(int priv) {
            this.priv = priv;
        }
    }
}
