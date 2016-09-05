package eu.openminted.registry.domain;

/**
 * Created by stefania on 9/5/16.
 */
public class CharacterEncoding {

    //TODO this should be made into an enum (use characterEncoding from ResourceCommon.xsd)
    private String characterEncoding;

    public CharacterEncoding() {
    }

    public CharacterEncoding(String characterEncoding) {
        this.characterEncoding = characterEncoding;
    }

    public String getCharacterEncoding() {
        return characterEncoding;
    }

    public void setCharacterEncoding(String characterEncoding) {
        this.characterEncoding = characterEncoding;
    }
}
