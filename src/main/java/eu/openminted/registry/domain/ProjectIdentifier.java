package eu.openminted.registry.domain;

/**
 * Created by stefania on 9/5/16.
 */
public class ProjectIdentifier {

    //required
    private String id;
    //required
    private String schema;
    private String url;

    public ProjectIdentifier() {
    }

    public ProjectIdentifier(String id, String schema) {
        this.id = id;
        this.schema = schema;
    }

    public ProjectIdentifier(String schema, String id, String url) {
        this.schema = schema;
        this.id = id;
        this.url = url;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getSchema() {
        return schema;
    }

    public void setSchema(String schema) {
        this.schema = schema;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
