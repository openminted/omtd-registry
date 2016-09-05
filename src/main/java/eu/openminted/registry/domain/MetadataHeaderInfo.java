package eu.openminted.registry.domain;

import java.util.Date;
import java.util.List;

/**
 * Created by stefania on 9/5/16.
 */
public class MetadataHeaderInfo {

    enum MetadataIdentifierSchema implements IdentifierSchema {

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
    }

    //required
    private Identifier<MetadataIdentifierSchema> metadataRecordIdentifier;
    //required
    private Date metadataCreationDate;
    private List<RelatedPerson> metedataCreators;
    private SourceOfMetadataRecord sourceOfMetadataRecord;
    private List<Language> languages;
    //required
    private Date metadataLastUpdated;
    private String revision;

    public MetadataHeaderInfo() {
    }

    public MetadataHeaderInfo(Identifier<MetadataIdentifierSchema> metadataRecordIdentifier, Date metadataCreationDate,
                              List<RelatedPerson> metedataCreators, SourceOfMetadataRecord sourceOfMetadataRecord,
                              List<Language> languages, Date metadataLastUpdated, String revision) {
        this.metadataRecordIdentifier = metadataRecordIdentifier;
        this.metadataCreationDate = metadataCreationDate;
        this.metedataCreators = metedataCreators;
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

    public List<RelatedPerson> getMetedataCreators() {
        return metedataCreators;
    }

    public void setMetedataCreators(List<RelatedPerson> metedataCreators) {
        this.metedataCreators = metedataCreators;
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
