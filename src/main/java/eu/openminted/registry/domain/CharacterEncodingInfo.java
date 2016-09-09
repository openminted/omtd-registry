package eu.openminted.registry.domain;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;

/**
 * Created by stefania on 9/5/16.
 */
@XmlAccessorType(XmlAccessType.FIELD)
public class CharacterEncodingInfo {

    //required
    private CharacterEncoding characterEncoding;
    private SizeInfo sizePerCharacterEncoding;

    public CharacterEncodingInfo() {
    }

    public CharacterEncodingInfo(CharacterEncoding characterEncoding) {
        this.characterEncoding = characterEncoding;
    }

    public CharacterEncodingInfo(CharacterEncoding characterEncoding, SizeInfo sizePerCharacterEncoding) {
        this.characterEncoding = characterEncoding;
        this.sizePerCharacterEncoding = sizePerCharacterEncoding;
    }

    public CharacterEncoding getCharacterEncoding() {
        return characterEncoding;
    }

    public void setCharacterEncoding(CharacterEncoding characterEncoding) {
        this.characterEncoding = characterEncoding;
    }

    public SizeInfo getSizePerCharacterEncoding() {
        return sizePerCharacterEncoding;
    }

    public void setSizePerCharacterEncoding(SizeInfo sizePerCharacterEncoding) {
        this.sizePerCharacterEncoding = sizePerCharacterEncoding;
    }
}
