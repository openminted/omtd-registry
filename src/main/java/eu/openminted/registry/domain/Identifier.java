package eu.openminted.registry.domain;

/**
 * Created by stefania on 9/5/16.
 */
public class Identifier<T extends IdentifierSchema> {

    private T schema;
    private String id;
    private String url;

    public Identifier(T schema, String id, String url) {
        this.schema = schema;
        this.id = id;
        this.url = url;
    }

    public Identifier() {
    }

    public T getSchema() {
        return schema;
    }

    public void setSchema(T schema) {
        this.schema = schema;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
