package eu.openminted.registry.service;

import eu.openminted.registry.core.domain.Resource;
import eu.openminted.registry.core.service.ResourceService;
import eu.openminted.registry.core.service.SearchService;
import eu.openminted.registry.core.service.ServiceException;
import eu.openminted.registry.domain.Corpus;
import eu.openminted.store.restclient.StoreRESTClient;
import org.apache.commons.io.FileDeleteStrategy;
import org.apache.commons.io.IOUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;
import java.io.*;
import java.net.UnknownHostException;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

/**
 * Created by stefanos on 15-Nov-16.
 */
@Service("corpusService")
public class CorpusServiceImpl implements CorpusService {

    private Logger logger = Logger.getLogger(CorpusServiceImpl.class);
    private final int BUFFER_SIZE = 4096;

    @Autowired
    SearchService searchService;

    @Autowired
    ResourceService resourceService;

    @Autowired
    Environment environment;

    @Override
    public Corpus get(String id) {
        Corpus resource;
        try {
            resource = Utils.serialize(searchService.searchId("corpus", id), Corpus.class);
        } catch (UnknownHostException e) {
            logger.fatal(e);
            throw new ServiceException(e);
        }
        return resource;
    }

    @Override
    public void add(Corpus corpus) {
        Corpus $corpus;
        XMLGregorianCalendar calendar;

        try {

            $corpus = Utils.serialize(searchService.searchId("corpus",
                    corpus.getMetadataHeaderInfo().getMetadataRecordIdentifier().getValue()), Corpus.class);

            GregorianCalendar gregory = new GregorianCalendar();
            gregory.setTime(new Date());

            calendar = DatatypeFactory.newInstance()
                    .newXMLGregorianCalendar(
                            gregory);

        } catch (UnknownHostException | DatatypeConfigurationException e) {
            logger.fatal(e);
            throw new ServiceException(e);
        }

        if ($corpus != null) {
            throw new ServiceException("Corpus already exists");
        }

        Resource resource = new Resource();

        corpus.getMetadataHeaderInfo().setMetadataCreationDate(calendar);
        corpus.getMetadataHeaderInfo().setMetadataLastDateUpdated(calendar);

        String serialized = Utils.unserialize(corpus, Corpus.class);

        if (!serialized.equals("failed")) {
            resource.setPayload(serialized);
        } else {
            throw new ServiceException("Serialization failed");
        }

        resource.setCreationDate(new Date());
        resource.setModificationDate(new Date());
        resource.setPayloadFormat("xml");
        resource.setResourceType("corpus");
        resource.setVersion("not_set");
        resource.setId("wont be saved");


        resourceService.addResource(resource);
    }

    @Override
    public void update(Corpus corpus) {
        Resource $resource;
        Resource resource = new Resource();
        try {
            $resource = searchService.searchId("corpus", corpus.getMetadataHeaderInfo().getMetadataRecordIdentifier().getValue());
        } catch (UnknownHostException e) {
            logger.fatal(e);
            throw new ServiceException(e);
        }

        if ($resource != null) {
            throw new ServiceException("Corpus already exists");
        } else {
            String serialized = Utils.unserialize(corpus, Corpus.class);

            if (!serialized.equals("failed")) {
                resource.setPayload(serialized);
            } else {
                throw new ServiceException("Serialization failed");
            }
            resource = (Resource) $resource;
            resource.setPayloadFormat("xml");
            resource.setPayload(serialized);
            resourceService.updateResource(resource);
        }
    }

    @Override
    public void delete(Corpus corpus) {
        Resource resource;
        try {
            resource = searchService.searchId("corpus", corpus.getMetadataHeaderInfo().getMetadataRecordIdentifier().getValue());
            if (resource != null) {
                throw new ServiceException("Corpus already exists");
            } else {
                resourceService.deleteResource(resource.getId());
            }
        } catch (UnknownHostException e) {
            logger.fatal(e);
            throw new ServiceException(e);
        }
    }


    @Override
    public String uploadCorpus(String filename, InputStream inputStream) {
        String archiveId = null;

        try {
            StoreRESTClient storeClient = new StoreRESTClient(environment.getProperty("services.store.ip", "http://83.212.101.85:8090"));
            File temp = File.createTempFile("copr", "tmp");
            OutputStream fos = new BufferedOutputStream(new FileOutputStream(temp));

            IOUtils.copyLarge(inputStream, fos);
            fos.flush();
            fos.close();

            archiveId = storeClient.createArchive().getResponse();

            logger.info("Creating archiveId " + archiveId);
            logger.info("Creating subarchive " + storeClient.createSubArchive(archiveId, "metadata").getResponse());
            logger.info("Creating subarchive " + storeClient.createSubArchive(archiveId, "fulltext").getResponse());
            logger.info("Creating subarchive " + storeClient.createSubArchive(archiveId, "abstract").getResponse());

            /*
               * unzip file
               * iterate through its directories
               * upload each file according to the corresponding directory
             */

            String destDirectory = "tmpDirectory";
            File destDir = new File(destDirectory);
            if (!destDir.exists()) {
                destDir.mkdirs();
            }

            ZipInputStream zipIn = new ZipInputStream(new FileInputStream(temp));
            ZipEntry entry = zipIn.getNextEntry();
            // iterates over entries in the zip file
            while (entry != null) {
                String filePath = destDirectory + File.separator + entry.getName();
                File unzippedFile = new File(filePath);

                if (!entry.isDirectory()) {
                    new File(unzippedFile.getParent()).mkdirs();
                    unzippedFile.createNewFile();
                    // if the entry is a file, extracts it
                    extractFile(zipIn, unzippedFile);
                } else {
                    // if the entry is a directory, make the directory
                    unzippedFile.mkdirs();
                }
                zipIn.closeEntry();
                entry = zipIn.getNextEntry();
            }
            zipIn.close();

            if (destDir.listFiles() != null)
                for (File file : destDir.listFiles()) {
                    iterateThroughDirectories(storeClient, archiveId, file, file.getParent());
                }

            logger.info("Done uploading files");

            storeClient.finalizeArchive(archiveId);

            FileDeleteStrategy.FORCE.delete(temp);
            FileDeleteStrategy.FORCE.delete(destDir);

        } catch (IOException e) {
            logger.error("Error uploading corpus", e);
        }

        return archiveId;
    }

    @Override
    public InputStream downloadCorpus(String archiveId) {
        try {
            StoreRESTClient storeClient = new StoreRESTClient(environment.getProperty("services.store.ip", "http://83.212.101.85:8090"));
            File temp = File.createTempFile("cor", "tmp");

            temp.deleteOnExit();
            storeClient.downloadArchive(archiveId, temp.getAbsolutePath());

            return new FileInputStream(temp);
        } catch (Exception e) {
            logger.error("error downloading file", e);
        }

        return null;
    }

    private void extractFile(ZipInputStream zipIn, File file) throws IOException {
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(file);
            BufferedOutputStream bos = new BufferedOutputStream(fileOutputStream);
            byte[] bytesIn = new byte[BUFFER_SIZE];
            int read = 0;
            while ((read = zipIn.read(bytesIn)) != -1) {
                bos.write(bytesIn, 0, read);
            }
            bos.close();
        } catch (FileNotFoundException e) {
            logger.error("Error reading file while unzipping", e);
        }
    }

    private void iterateThroughDirectories(StoreRESTClient storeClient, String archiveId, File file, String parent) throws IOException {
        if (file.getName().matches("^\\.[_|A-Z|a-z|0-9].*")
                || file.getName().matches(".*[M|m][A|a][C|c][O|o][S|s][X|x].*")) {

            FileDeleteStrategy.FORCE.delete(file);

            return;
        }

        if (file.isDirectory()) {
            if (file.listFiles() == null) return;
            for (File child : file.listFiles()) {
                if (child == null) continue;
                iterateThroughDirectories(storeClient, archiveId, child, file.getName());
            }
        } else {
            if (parent.equalsIgnoreCase("metadata")
                    || parent.equalsIgnoreCase("fulltext")
                    || parent.equalsIgnoreCase("abstract")) {
                storeClient.storeFile(file, archiveId + File.separator + parent, file.getName());
                logger.info("Uploading " + archiveId + File.separator + parent + File.separator + file.getName());
            }
        }
    }

}
