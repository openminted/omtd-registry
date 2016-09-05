package eu.openminted.registry.domain;

/**
 * Created by stefania on 9/5/16.
 */
public class TextFormatInfo {

    //required
    private MimeType mimeType;
    //required
    private SizeInfo sizeInfo;

    public TextFormatInfo() {
    }

    public TextFormatInfo(MimeType mimeType, SizeInfo sizeInfo) {
        this.mimeType = mimeType;
        this.sizeInfo = sizeInfo;
    }

    public MimeType getMimeType() {
        return mimeType;
    }

    public void setMimeType(MimeType mimeType) {
        this.mimeType = mimeType;
    }

    public SizeInfo getSizeInfo() {
        return sizeInfo;
    }

    public void setSizeInfo(SizeInfo sizeInfo) {
        this.sizeInfo = sizeInfo;
    }
}
