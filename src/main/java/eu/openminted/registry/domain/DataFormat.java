package eu.openminted.registry.domain;

/**
 * Created by stefania on 9/5/16.
 */
public class DataFormat {

    //required
    //TODO this should be made into an enum (use mimeType from ResourceCommon.xsd)
    private String mimeType;
    //TODO this should be made into an enum (use dataFormatSpecific from ResourceCommon.xsd)
    private String dataFormatSpecific;
    private String documentationURL;

    public DataFormat() {
    }

    public DataFormat(String mimeType) {
        this.mimeType = mimeType;
    }

    public DataFormat(String mimeType, String dataFormatSpecific, String documentationURL) {
        this.mimeType = mimeType;
        this.dataFormatSpecific = dataFormatSpecific;
        this.documentationURL = documentationURL;
    }

    public String getMimeType() {
        return mimeType;
    }

    public void setMimeType(String mimeType) {
        this.mimeType = mimeType;
    }

    public String getDataFormatSpecific() {
        return dataFormatSpecific;
    }

    public void setDataFormatSpecific(String dataFormatSpecific) {
        this.dataFormatSpecific = dataFormatSpecific;
    }

    public String getDocumentationURL() {
        return documentationURL;
    }

    public void setDocumentationURL(String documentationURL) {
        this.documentationURL = documentationURL;
    }
}
