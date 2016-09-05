package eu.openminted.registry.domain;

import java.util.List;

/**
 * Created by stefania on 9/5/16.
 */
public class RelatedJournal {

    enum JournalIdentifierSchema implements IdentifierSchema {

        DOI("doi"),
        HDL("hdl"),
        ISSN("issn"),
        OTHER("other");

        private String value;

        JournalIdentifierSchema(String value) {
            this.value = value;
        }

        @Override
        public String getValue() {
            return value;
        }
    }

    //one of the two
    private List<String> journalTitles;
    private List<Identifier<JournalIdentifierSchema>> journalIdentifiers;

    public RelatedJournal() {
    }

    public List<String> getJournalTitles() {
        return journalTitles;
    }

    public void setJournalTitles(List<String> journalTitles) {
        this.journalTitles = journalTitles;
    }

    public List<Identifier<JournalIdentifierSchema>> getJournalIdentifiers() {
        return journalIdentifiers;
    }

    public void setJournalIdentifiers(List<Identifier<JournalIdentifierSchema>> journalIdentifiers) {
        this.journalIdentifiers = journalIdentifiers;
    }
}
