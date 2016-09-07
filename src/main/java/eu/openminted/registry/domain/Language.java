package eu.openminted.registry.domain;

/**
 * Created by stefania on 9/5/16.
 */
public class Language {

    //required
    private String languageTag;
    //required
    //TODO this should be made into an enum (use languageIdType)
    private String languageId;
    //TODO this should be made into an enum (use scriptIdType)
    private String scriptId;
    //TODO this should be made into an enum (use regionIdType)
    private String regionId;
    //TODO this should be made into an enum (use variantIdType)
    private String variantId;

    public Language() {
    }

    public Language(String languageTag, String languageId, String scriptId, String regionId, String variantId) {
        this.languageTag = languageTag;
        this.languageId = languageId;
        this.scriptId = scriptId;
        this.regionId = regionId;
        this.variantId = variantId;
    }

    public String getLanguageTag() {
        return languageTag;
    }

    public void setLanguageTag(String languageTag) {
        this.languageTag = languageTag;
    }

    public String getLanguageId() {
        return languageId;
    }

    public void setLanguageId(String languageId) {
        this.languageId = languageId;
    }

    public String getScriptId() {
        return scriptId;
    }

    public void setScriptId(String scriptId) {
        this.scriptId = scriptId;
    }

    public String getRegionId() {
        return regionId;
    }

    public void setRegionId(String regionId) {
        this.regionId = regionId;
    }

    public String getVariantId() {
        return variantId;
    }

    public void setVariantId(String variantId) {
        this.variantId = variantId;
    }
}
