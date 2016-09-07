package eu.openminted.registry.domain;

/**
 * Created by stefania on 9/5/16.
 */
public class DataFormat {

    //required
    //TODO this should be made into an enum (use mimeType from ResourceCommon.xsd)
    private MimeType mimeType;
    //TODO this should be made into an enum (use dataFormatSpecific from ResourceCommon.xsd)
    private String dataFormatSpecific;
    private String documentationURL;

    public DataFormat() {
    }

    public DataFormat(MimeType mimeType) {
        this.mimeType = mimeType;
    }

    public DataFormat(MimeType mimeType, String dataFormatSpecific, String documentationURL) {
        this.mimeType = mimeType;
        this.dataFormatSpecific = dataFormatSpecific;
        this.documentationURL = documentationURL;
    }

    public MimeType getMimeType() {
        return mimeType;
    }

    public void setMimeType(MimeType mimeType) {
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
