package eu.openminted.registry.domain;

import org.w3c.dom.Document;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathExpression;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;
import java.io.*;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Collectors;

/**
 * Class representing a corpus of publications.
 *
 * @author spyroukostas
 */

public class CorpusContent {

    private int totalPublications;
    private String archiveId;
    private List<String> filepaths;
    private List<PublicationInfo> pubInfo = null;

    public CorpusContent() {

    }

    public CorpusContent(String archiveId) {
        this.archiveId = archiveId;
    }

    public String getArchiveId() {
        return archiveId;
    }

    public void setArchiveId(String archiveId) {
        this.archiveId = archiveId;
    }

    public int getTotalPublications() {
        return totalPublications;
    }

    public void setTotalPublications(int totalPublications) {
        this.totalPublications = totalPublications;
    }

    public List<PublicationInfo> getPubInfo() {
        return pubInfo;
    }

    public void setPubInfo(List<PublicationInfo> publications) {
        this.pubInfo = publications;
    }

    public List<String> getFilepaths() {
        return filepaths;
    }

    public void setFilepaths(List<String> filepaths) {
        this.filepaths = filepaths;
    }


}
