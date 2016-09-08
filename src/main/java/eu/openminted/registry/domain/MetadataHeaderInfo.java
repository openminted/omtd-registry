package eu.openminted.registry.domain;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.XmlValue;
import javax.xml.bind.annotation.adapters.XmlAdapter;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import java.util.Date;
import java.util.List;

/**
 * Created by stefania on 9/5/16.
 */
@XmlAccessorType(XmlAccessType.FIELD)
public class MetadataHeaderInfo {

    @XmlEnum
    public enum MetadataIdentifierSchema implements IdentifierSchema {

        HDL("hdl"),
        PURL("purl"),
        URL("url"),
        URN("urn"),
        OTHER("other");

        private String value;

        MetadataIdentifierSchema(String value) {
            this.value = value;
        }

        @Override
        public String getValue() {
            return value;
        }

        public static MetadataIdentifierSchema forValue(String value) {
            for (MetadataIdentifierSchema ut: values()) {
                if (ut.getValue().equals(value))
                    return ut;
            }

            return null;
        }
    }

    //required
    @XmlJavaTypeAdapter(value = ComponentIdentifierAdapter.class)
    private Identifier<MetadataIdentifierSchema> metadataRecordIdentifier;
    //required
    @XmlElement(name="metadataCreationDate")
    @XmlSchemaType(name="date")
    private Date metadataCreationDate;
    @XmlElementWrapper(name = "metadataCreators")
    @XmlElement(name="metadataCreator")
    private List<RelatedPerson> metadataCreators;
    private SourceOfMetadataRecord sourceOfMetadataRecord;
    @XmlElementWrapper(name="metadataLanguages")
    @XmlElement(name="metadataLanguage")
    private List<Language> languages;
    //required
    @XmlSchemaType(name="date")
    @XmlElement(name = "metadataLastDateUpdated")
    private Date metadataLastUpdated;
    private String revision;

    public MetadataHeaderInfo() {
    }

    public MetadataHeaderInfo(Identifier<MetadataIdentifierSchema> metadataRecordIdentifier, Date metadataCreationDate,
                              List<RelatedPerson> metedataCreators, SourceOfMetadataRecord sourceOfMetadataRecord,
                              List<Language> languages, Date metadataLastUpdated, String revision) {
        this.metadataRecordIdentifier = metadataRecordIdentifier;
        this.metadataCreationDate = metadataCreationDate;
        this.metadataCreators = metedataCreators;
        this.sourceOfMetadataRecord = sourceOfMetadataRecord;
        this.languages = languages;
        this.metadataLastUpdated = metadataLastUpdated;
        this.revision = revision;
    }

    public Identifier<MetadataIdentifierSchema> getMetadataRecordIdentifier() {
        return metadataRecordIdentifier;
    }

    public void setMetadataRecordIdentifier(Identifier<MetadataIdentifierSchema> metadataRecordIdentifier) {
        this.metadataRecordIdentifier = metadataRecordIdentifier;
    }

    public Date getMetadataCreationDate() {
        return metadataCreationDate;
    }

    public void setMetadataCreationDate(Date metadataCreationDate) {
        this.metadataCreationDate = metadataCreationDate;
    }

    public List<RelatedPerson> getMetadataCreators() {
        return metadataCreators;
    }

    public void setMetadataCreators(List<RelatedPerson> metedataCreators) {
        this.metadataCreators = metedataCreators;
    }

    public SourceOfMetadataRecord getSourceOfMetadataRecord() {
        return sourceOfMetadataRecord;
    }

    public void setSourceOfMetadataRecord(SourceOfMetadataRecord sourceOfMetadataRecord) {
        this.sourceOfMetadataRecord = sourceOfMetadataRecord;
    }

    public List<Language> getLanguages() {
        return languages;
    }

    public void setLanguages(List<Language> languages) {
        this.languages = languages;
    }

    public Date getMetadataLastUpdated() {
        return metadataLastUpdated;
    }

    public void setMetadataLastUpdated(Date metadataLastUpdated) {
        this.metadataLastUpdated = metadataLastUpdated;
    }

    public String getRevision() {
        return revision;
    }

    public void setRevision(String revision) {
        this.revision = revision;
    }
}

class ComponentIdentifierAdapter extends XmlAdapter<ComponentIdentifierAdapter.SIdentifier, Identifier<MetadataHeaderInfo.MetadataIdentifierSchema>> {
    @Override
    public eu.openminted.registry.domain.Identifier<MetadataHeaderInfo.MetadataIdentifierSchema> unmarshal(SIdentifier v) throws Exception {
        return new eu.openminted.registry.domain.Identifier<>(
                MetadataHeaderInfo.MetadataIdentifierSchema.forValue(v.schema), v.id, v.url);
    }

    @Override
    public SIdentifier marshal(eu.openminted.registry.domain.Identifier<MetadataHeaderInfo.MetadataIdentifierSchema> v) throws Exception {
        return new SIdentifier(v.getId(), v.getSchema().getValue(), v.getUrl());
    }

    public static class SIdentifier {
        @XmlValue
        private String id;
        @XmlAttribute(name="metadataIdentifierSchemeName")
        private String schema;
        @XmlAttribute(name="schemeURI")
        private String url;

        public SIdentifier() {
        }

        public SIdentifier(String id, String schema, String url) {
            this.id = id;
            this.schema = schema;
            this.url = url;
        }
    }
}