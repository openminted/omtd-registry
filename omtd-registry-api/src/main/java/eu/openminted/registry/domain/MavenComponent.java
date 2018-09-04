package eu.openminted.registry.domain;

public class MavenComponent {
    Component component;
    String xml;

    public MavenComponent() {
    }

    public MavenComponent(Component component, String xml) {
        this.component = component;
        this.xml = xml;
    }

    public Component getComponent() {
        return component;
    }

    public void setComponent(Component component) {
        this.component = component;
    }

    public String getXml() {
        return xml;
    }

    public void setXml(String xml) {
        this.xml = xml;
    }
}