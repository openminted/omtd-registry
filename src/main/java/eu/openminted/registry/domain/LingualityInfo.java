package eu.openminted.registry.domain;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.adapters.XmlAdapter;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

/**
 * Created by stefania on 9/5/16.
 */
@XmlAccessorType(XmlAccessType.FIELD)
public class LingualityInfo {

    @XmlJavaTypeAdapter(LingualityTypeAdapter.class)
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

        public static LingualityType forValue(String value) {
            for (LingualityType ut: values()) {
                if (ut.getValue().equals(value))
                    return ut;
            }

            return null;
        }
    }

    @XmlJavaTypeAdapter(ModalityTypeAdapter.class)
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

        public static MultiLingualityType forValue(String value) {
            for (MultiLingualityType ut: values()) {
                if (ut.getValue().equals(value))
                    return ut;
            }

            return null;
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

class LingualityTypeAdapter extends XmlAdapter<String, LingualityInfo.LingualityType> {

    @Override
    public String marshal(LingualityInfo.LingualityType v) throws Exception {
        return v!=null?v.getValue():null;
    }

    @Override
    public LingualityInfo.LingualityType unmarshal(String v) throws Exception {
        return LingualityInfo.LingualityType.forValue(v);
    }
}

class MultiLingualityTypeAdapter extends XmlAdapter<String, LingualityInfo.MultiLingualityType> {

    @Override
    public String marshal(LingualityInfo.MultiLingualityType v) throws Exception {
        return v!=null?v.getValue():null;
    }

    @Override
    public LingualityInfo.MultiLingualityType unmarshal(String v) throws Exception {
        return LingualityInfo.MultiLingualityType.forValue(v);
    }
}