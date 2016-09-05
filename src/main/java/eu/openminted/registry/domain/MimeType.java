package eu.openminted.registry.domain;

/**
 * Created by stefania on 9/5/16.
 */
public class MimeType {

    //TODO this should be made into an enum (use mimeType from ResourceCommon.xsd)
    private String mimeType;

    public MimeType() {
    }

    public MimeType(String mimeType) {
        this.mimeType = mimeType;
    }

    public String getMimeType() {
        return mimeType;
    }

    public void setMimeType(String mimeType) {
        this.mimeType = mimeType;
    }
}
