package eu.openminted.registry.domain;

import java.io.Serializable;

public class Totals implements Serializable {

    private int publications = 0;

    private int components = 0;

    private int applications = 0;

    public Totals(int publications, int components, int applications) {
        this.publications = publications;
        this.components = components;
        this.applications = applications;
    }

    public int getPublications() {
        return publications;
    }

    public void setPublications(int publications) {
        this.publications = publications;
    }

    public int getComponents() {
        return components;
    }

    public void setComponents(int components) {
        this.components = components;
    }

    public int getApplications() {
        return applications;
    }

    public void setApplications(int applications) {
        this.applications = applications;
    }
}
