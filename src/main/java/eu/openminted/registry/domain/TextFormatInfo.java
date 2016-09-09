package eu.openminted.registry.domain;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;

/**
 * Created by stefania on 9/5/16.
 */
@XmlAccessorType(XmlAccessType.FIELD)
public class TextFormatInfo {

    //required
    @XmlElement(name="mimeType")
    private MimeType mimeType;
    //required
    @XmlElement(name="sizeInfo")
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
