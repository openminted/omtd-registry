package eu.openminted.registry.domain;

/**
 * Created by stefania on 9/5/16.
 */
public class LingualityInfo {

    enum LingualityType {

        MONOLINGUAL("monolingual"),
        BILINGUAL("bilingual"),
        MULTILINGUAL("multilingual");

        private String value;

        LingualityType(String value) {
            this.value = value;
        }

        public String getValue() {
            return value;
        }
    }

    enum MultiLingualityType {

        PARALLEL("parallel"),
        COMPARABLE("comparable"),
        MULTILINGUAL_SINGLE_TEXT("multilingualSingleText"),
        ORIGINAL_TRANSLATIONS_IN_SAME_TEXT("originalTranslationsInSameText"),
        OTHER("other");

        private String value;

        MultiLingualityType(String value) {
            this.value = value;
        }

        public String getValue() {
            return value;
        }
    }

    //required
    private LingualityType lingualityType;
    private MultiLingualityType multiLingualityType;
    private String multilingualityTypeDetails;

    public LingualityInfo() {
    }

    public LingualityInfo(LingualityType lingualityType) {
        this.lingualityType = lingualityType;
    }

    public LingualityInfo(LingualityType lingualityType, MultiLingualityType multiLingualityType, String multilingualityTypeDetails) {
        this.lingualityType = lingualityType;
        this.multiLingualityType = multiLingualityType;
        this.multilingualityTypeDetails = multilingualityTypeDetails;
    }

    public LingualityType getLingualityType() {
        return lingualityType;
    }

    public void setLingualityType(LingualityType lingualityType) {
        this.lingualityType = lingualityType;
    }

    public MultiLingualityType getMultiLingualityType() {
        return multiLingualityType;
    }

    public void setMultiLingualityType(MultiLingualityType multiLingualityType) {
        this.multiLingualityType = multiLingualityType;
    }

    public String getMultilingualityTypeDetails() {
        return multilingualityTypeDetails;
    }

    public void setMultilingualityTypeDetails(String multilingualityTypeDetails) {
        this.multilingualityTypeDetails = multilingualityTypeDetails;
    }
}
