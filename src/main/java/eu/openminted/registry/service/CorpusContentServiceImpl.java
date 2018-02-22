package eu.openminted.registry.service;


import eu.openminted.registry.core.service.ResourceCRUDService;
import eu.openminted.registry.core.service.ServiceException;
import eu.openminted.registry.domain.Corpus;
import eu.openminted.registry.domain.CorpusContent;
import eu.openminted.registry.domain.PublicationInfo;
import eu.openminted.store.common.StoreResponse;
import eu.openminted.store.restclient.StoreRESTClient;
import eu.openminted.utils.files.ZipToDir;
import org.apache.commons.io.FilenameUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.data.redis.connection.lettuce.LettuceConnectionFactory;
import org.springframework.data.redis.core.ListOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;

import javax.annotation.Resource;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathExpression;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

/**
 * Created by spyroukostas on 7-Feb-2018.
 */

@Service("corpusContentService")
@Primary
public class CorpusContentServiceImpl implements CorpusContentService {

    private Logger logger = Logger.getLogger(CorpusContentServiceImpl.class);

    @Autowired
    StoreRESTClient storeClient;

    @Autowired
    ResourceCRUDService<Corpus> corpusService;

    @Autowired
    LettuceConnectionFactory lettuceConnectionFactory;  // TODO

    private String resolveCorpusArchive(String corpusId) {
        final Pattern pattern = Pattern.compile(".*?\\?archiveId=(?<archive>[\\d\\w-]+)$");
        Corpus corpus = corpusService.get(corpusId);
        if (corpus == null) {
            logger.error("Corpus with id " + corpusId + " not found");
            throw new ServiceException("Corpus with id " + corpusId + " not found");
        }
        String distributionLocation = corpus.getCorpusInfo().getDatasetDistributionInfo().getDistributionLocation();
        Matcher archiveMatcher = pattern.matcher(distributionLocation);
        if (!archiveMatcher.find()) {
            throw new ServiceException("No archive Id was present");
        }
        String archiveId = archiveMatcher.group("archive");
        logger.debug(archiveId);
        return archiveId;
    }


    @Override
    public CorpusContent getCorpusContent(String corpusId) {
        String archiveId = resolveCorpusArchive(corpusId);

        CorpusContent content;

        content = new CorpusContent(archiveId);

        try {
            // retrieve all files inside the archive
            content.setFilepaths(storeClient.listFiles(archiveId, false, true, true));
        } catch (Exception e) {
            logger.error("Could not retrieve file names from endpoint: " + storeClient.getEndpoint());
            e.printStackTrace();
        }

        // analyze file-paths and create publication entries
        createPublicationEntries(content);

        return content;
    }

    /**
     * Downloads metadata files to extract publication titles.
     * Returns a HashMap of Publication IDs and Publication Titles.
     *
     * @param archiveId
     * @returns {@link HashMap <String, String>}
     */
    private HashMap<String, String> extractPublicationTitles(String archiveId) {

        File metadata_zip = new File(System.getProperty("java.io.tmpdir") + "/corpus_metadata/" + archiveId + ".zip");
        File metadata_dir = new File(FilenameUtils.removeExtension(metadata_zip.toString()) + "/metadata");

        if (!metadata_dir.exists()) {

            // download metadata folder as zip
            metadata_zip.getParentFile().mkdirs();
            StoreResponse response = storeClient.fetchMetadata(archiveId, metadata_zip.toString()); // FIXME: response?

            try {
                File save_dir = new File(metadata_zip.getParent().toString());
                ZipToDir.unpackToWorkDir(metadata_zip, save_dir);
            } catch (IOException e) {
                e.printStackTrace();
                return null;
            } finally { // delete zip file
                try {
                    metadata_zip.delete();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
        HashMap<String, String> publication_titles = new HashMap<>();
        String title;
        String id;
        try {
            File[] file_list = metadata_dir.listFiles();
            for (File f : file_list) {
                if (!(title = extractTitleFromXML(f.toString())).equals("")) {
                    id = FilenameUtils.removeExtension(f.getName());
                    publication_titles.put(id, title);
                }
            }
        } catch (NullPointerException e) {
            e.printStackTrace();
        }
//        metadata_dir.delete();
        return publication_titles;
    }


    /**
     * Parses an XML file of a Publication and retrieves the Title.
     *
     * @param filename
     * @return {@link String}
     */
    private String extractTitleFromXML(String filename) {
        File xml = new File(filename);
        String title = "";
        if (!xml.exists()) {
            return title;
        }

        try {
            DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder documentBuilder;

            documentBuilder = documentBuilderFactory.newDocumentBuilder();
            Document document = documentBuilder.parse(xml);

            XPathFactory xPathfactory = XPathFactory.newInstance();
            XPath xpath = xPathfactory.newXPath();

            XPathExpression expr = xpath.compile("//*[local-name()='publication']//*[local-name()='title']");

            title = expr.evaluate(document);

        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (XPathExpressionException e) {
            e.printStackTrace();
        }

        return title;
    }


    /**
     * Populates the list of Publications.
     */
    public void createPublicationEntries(CorpusContent content) {
        int abstractMask = 0x0001;
        int fulltextMask = 0x0010;
        int metadataMask = 0x0100;
        int annotationsMask = 0x1000;

        String archiveId = content.getArchiveId();
        List<String> filepaths = content.getFilepaths();

        if (filepaths == null) {
            content.setTotalPublications(0);
            return;
        }

        List<Path> paths = filepaths.stream()
                .map(Paths::get)
                .collect(Collectors.toList());

        // save for each publication the name (String) and a value (int)
        // which represents the existence/absence of abstract, fulltext, metadata and annotations.
        HashMap<String, Integer> publicationInfo = new HashMap<>();

        // create a set with publication IDs extracted from the filenames.
        Set<String> publicationId = new HashSet<>();

        for (Path file : paths) {
            String filename = file.getFileName().toString();
            filename = FilenameUtils.removeExtension(filename);
            publicationId.add(filename);
            publicationInfo.putIfAbsent(filename, 0x0000);

            String parent = file.getParent().getFileName().toString();

            if (parent.equals("abstract")) {
                publicationInfo.replace(filename, publicationInfo.get(filename) + abstractMask);

            } else if (parent.equals("fulltext")) {
                publicationInfo.replace(filename, publicationInfo.get(filename) + fulltextMask);

            } else if (parent.equals("metadata")) {
                publicationInfo.replace(filename, publicationInfo.get(filename) + metadataMask);

            } else if (parent.equals("annotations")) {
                publicationInfo.replace(filename, publicationInfo.get(filename) + annotationsMask);

            } else {
                //
            }
        }

        List pubInfo = new ArrayList<>();

        // download and parse metadata files to extract publication titles
        HashMap<String, String> publication_titles = extractPublicationTitles(archiveId);

        // create publication entries
        Iterator it = publicationId.iterator();
        while (it.hasNext()) {
            String id = (String) it.next();
            int value = publicationInfo.get(id);
            String title = publication_titles.get(id);
            if (title == null || title.equals("")) {
                title = id;
            }

            boolean hasAbstract = ((value & abstractMask) == abstractMask);
            boolean hasFulltext = ((value & fulltextMask) == fulltextMask);
            boolean hasMetadata = ((value & metadataMask) == metadataMask);
            boolean hasAnnotations = ((value & annotationsMask) == annotationsMask);

            pubInfo.add(new PublicationInfo(id, title, archiveId,
                    hasFulltext, hasAbstract, hasMetadata, hasAnnotations));
        }

        content.setPubInfo(pubInfo);
        content.setTotalPublications(publicationInfo.size());
    }

    /**
     * Prints {@link PublicationInfo} fields.
     * @param info
     */
    public void printPublicationInfo(PublicationInfo info) {
        System.out.println("\n");
        System.out.println("Archive ID:\t" + info.getArchiveId());
        System.out.println("Pub ID:  \t" + info.getId());
        System.out.println("Title:   \t" + info.getTitle());
        System.out.println("Abstract:\t" + info.isHasAbstract());
        System.out.println("Fulltext:\t" + info.isHasFulltext());
        System.out.println("Metadata:\t" + info.isHasMetadata());
        System.out.println("Annotations:\t" + info.isHasAnnotations());
    }

    /**
     * Prints the {@link List<PublicationInfo>} that is given as an argument.
     *
     * @param pubInfo
     */
    public void printPubInfoList(List<PublicationInfo> pubInfo) {
        if (pubInfo != null) {
            System.out.println("\nPrinting Publication Info:");
            pubInfo.forEach(pub -> printPublicationInfo(pub));
        }
    }


    /**
     * Returns a subset of information of publications.
     *
     * @param from
     * @param size
     * @return {@link List<PublicationInfo>}
     */
    public List<PublicationInfo> getCorpusSubset(CorpusContent content, int from, int size) {
        List<PublicationInfo> pubInfo = content.getPubInfo();

        if (pubInfo != null)

            if (pubInfo.size() >= from + size)
                return pubInfo.subList(from, (from + size));

            else if (pubInfo.size() > from)
                return pubInfo.subList(from, pubInfo.size());

        return null;
    }

}




