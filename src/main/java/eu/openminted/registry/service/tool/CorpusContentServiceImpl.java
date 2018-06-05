package eu.openminted.registry.service.tool;


import eu.openminted.registry.core.domain.Browsing;
import eu.openminted.registry.core.service.ResourceCRUDService;
import eu.openminted.registry.core.service.ServiceException;
import eu.openminted.registry.domain.Corpus;
import eu.openminted.registry.domain.CorpusContent;
import eu.openminted.registry.domain.PublicationInfo;
import eu.openminted.registry.service.CorpusContentService;
import eu.openminted.registry.utils.OMTDUtils;
import eu.openminted.store.common.StoreResponse;
import eu.openminted.store.restclient.StoreRESTClient;
import eu.openminted.utils.files.ZipToDir;
import org.apache.commons.io.FilenameUtils;
import org.apache.log4j.Logger;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.map.SerializationConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathExpression;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;
import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
import java.util.concurrent.TimeUnit;
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
    @Qualifier("corpusService")
    ResourceCRUDService<Corpus> corpusService;

    @Autowired
    private RedisTemplate<String, CorpusContent> template;

    private final String redis_prefix = "corpuscontent:id:";


    @Override
    public Browsing<PublicationInfo> getCorpusContent(String corpusId, int from, int size) {
        String archiveId = OMTDUtils.resolveCorpusArchive(corpusService.get(corpusId));

        CorpusContent content = null;
        content = getContent(corpusId);

        if (content == null) {
            logger.info("CorpusContent is not saved in redis, communicating with store service ...");
            content = new CorpusContent(archiveId);

            // analyze file-paths and create publication entries
            createPublicationEntries(content);
            Collections.sort(content.getPubInfo());
            ObjectMapper mapper = new ObjectMapper();
            mapper.configure(SerializationConfig.Feature.INDENT_OUTPUT, true);
            try {
                logger.debug(mapper.writeValueAsString(content));
            } catch (IOException e) {
                e.printStackTrace();
            }
            addContent(corpusId, content);
        }
        return getCorpusSubset(content, from, size);
    }


    /**
     * Saves {@link CorpusContent} with ID {@param corpusId} to Redis.
     *
     * @param corpusId
     * @param content
     */
    private void addContent(String corpusId, CorpusContent content) {
        String key = redis_prefix + corpusId;
        if (!template.hasKey(key)) {
            template.opsForList().leftPush(key, content);
            template.expire(key, 5, TimeUnit.MINUTES);
        }

    }


    /**
     * Retrieves {@link CorpusContent} from Redis.
     *
     * @param corpusId
     * @return {@link CorpusContent}
     */
    private CorpusContent getContent(String corpusId) {
        String key = redis_prefix + corpusId;
        if (template.hasKey(key)) {
            return template.opsForList().rightPopAndLeftPush(key, key);
        } else {
            return null;
        }
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
     * Retrieves all filenames inside a corpus.
     */
    private void getCorpusFiles(CorpusContent content) {
        try {
            // retrieve all files inside the archive
            List<String> filepaths = storeClient.listFiles(content.getArchiveId(),
                    false, true, true);

            // filter out files not inside the following folders: abstract, fulltext, metadata, annotations
            if(filepaths == null) {
                throw new ServiceException("Store did not return anything");
            }
            filepaths.removeIf(file -> !file.contains("/abstract/") && !file.contains("/fulltext/") &&
                    !file.contains("/metadata/") && !file.contains("/annotations/"));
            content.setFilepaths(filepaths);
        } catch (Exception e) {
            logger.error("Could not retrieve file names from endpoint: " + storeClient.getEndpoint());
            e.printStackTrace();
        }
    }


    /**
     * Removes the first extension of a filename and any following extensions
     * of the types .pdf .txt .xml .xmi
     */
    private String customRemoveExtension(String filename) {
        do {
            filename = FilenameUtils.removeExtension(filename);
        } while (filename.toLowerCase().endsWith(".pdf") || filename.toLowerCase().endsWith(".txt") ||
                filename.toLowerCase().endsWith(".xml") || filename.toLowerCase().endsWith(".xmi"));
        return filename;
    }


    /**
     * Populates the list of Publications.
     */
    private void createPublicationEntries(CorpusContent content) {
        int abstractMask = 0x0001;
        int fulltextMask = 0x0010;
        int metadataMask = 0x0100;
        int annotationsMask = 0x1000;

        getCorpusFiles(content);

        String archiveId = content.getArchiveId();
        List<String> filepaths = content.getFilepaths();

        if (filepaths == null) {
            content.setTotalPublications(0);
            return;
        }

        List<Path> paths = filepaths.stream()
                .map(Paths::get)
                .collect(Collectors.toList());

        // save, for each publication, the name (String) and a value (int)
        // which represents the existence/absence of abstract, fulltext, metadata and annotations.
        HashMap<String, Integer> publicationInfo = new HashMap<>();

        // create a set with publication IDs extracted from the filenames.
        Set<String> publicationId = new HashSet<>();
        HashMap<String, String> abstract_paths = new HashMap<>();
        HashMap<String, String> fulltext_paths = new HashMap<>();
        HashMap<String, String> metadata_paths = new HashMap<>();
        HashMap<String, String> annotations_paths = new HashMap<>();

        for (Path file : paths) {
            String filename = file.getFileName().toString();
            filename = customRemoveExtension(filename);
            publicationId.add(filename);
            publicationInfo.putIfAbsent(filename, 0x0000);

            String parent = file.getParent().getFileName().toString();

            abstract_paths.putIfAbsent(filename, "");
            fulltext_paths.putIfAbsent(filename, "");
            metadata_paths.putIfAbsent(filename, "");
            annotations_paths.putIfAbsent(filename, "");

            if (parent.equals("abstract")) {
                publicationInfo.replace(filename, publicationInfo.get(filename) + abstractMask);
                abstract_paths.replace(filename, file.toString());

            } else if (parent.equals("fulltext")) {
                publicationInfo.replace(filename, publicationInfo.get(filename) + fulltextMask);
                fulltext_paths.replace(filename, file.toString());

            } else if (parent.equals("metadata")) {
                publicationInfo.replace(filename, publicationInfo.get(filename) + metadataMask);
                metadata_paths.replace(filename, file.toString());

            } else if (parent.equals("annotations")) {
                publicationInfo.replace(filename, publicationInfo.get(filename) + annotationsMask);
                annotations_paths.replace(filename, file.toString());

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
            String title = id;
            int value = publicationInfo.get(id);
            if (publication_titles != null) {
                title = publication_titles.get(id);
                if (title == null || title.equals("")) {
                    title = id;
                }
            }

            boolean hasAbstract = ((value & abstractMask) == abstractMask);
            boolean hasFulltext = ((value & fulltextMask) == fulltextMask);
            boolean hasMetadata = ((value & metadataMask) == metadataMask);
            boolean hasAnnotations = ((value & annotationsMask) == annotationsMask);

            pubInfo.add(new PublicationInfo(id, title, archiveId,
                    hasAbstract, hasFulltext, hasMetadata, hasAnnotations,
                    abstract_paths.get(id), fulltext_paths.get(id),
                    metadata_paths.get(id), annotations_paths.get(id)));
        }

        content.setPubInfo(pubInfo);
        content.setTotalPublications(publicationInfo.size());
    }


    /**
     * Returns a subset of information of publications.
     *
     * @param from
     * @param size
     * @return {@link Browsing<PublicationInfo>}
     */
    private Browsing<PublicationInfo> getCorpusSubset(CorpusContent content, int from, int size) {
        Browsing<PublicationInfo> browsing = new Browsing<>(content.getTotalPublications(), from, 0, null, null);
        browsing.setResults(content.getPubInfo());

        if (size == 0) size = content.getTotalPublications();

        if (content.getPubInfo() != null) {

            if (content.getTotalPublications() >= from + size) {
                browsing.setResults(content.getPubInfo().subList(from, (from + size)));
                browsing.setTo(from + size);

            } else if (content.getTotalPublications() > from) {
                browsing.setResults(content.getPubInfo().subList(from, content.getTotalPublications()));
                browsing.setTo(content.getTotalPublications());
            }
            return browsing;
        }
        return null;
    }

}




