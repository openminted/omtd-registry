package eu.openminted.registry.service.tool;

import eu.openminted.registry.domain.file.FileStats;
import eu.openminted.registry.domain.file.Info;
import eu.openminted.registry.service.CorpusService;
import eu.openminted.registry.service.StoreService;
import eu.openminted.registry.utils.OMTDUtils;
import eu.openminted.store.restclient.StoreRESTClient;
import org.apache.commons.io.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;
import java.util.stream.Collectors;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

@Component
public class StoreServiceImpl implements StoreService {

    static private final Logger logger = LogManager.getLogger(StoreServiceImpl.class);

    static private final int BUFFER_SIZE = 4096;

    @Autowired
    private CorpusService corpusService;

    @Autowired
    StoreRESTClient storeClient;

    @Override
    public String uploadCorpus(String filename, InputStream inputStream) {
        String archiveId = null;

        try {
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

            String destDirectory = archiveId;
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

            if (destDir.listFiles() != null) {
                for (File file : destDir.listFiles()) {
                    iterateThroughDirectories(storeClient, archiveId, file, file.getParent());
                }
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
    public FileStats uploadAuxiliary(String filename, InputStream inputStream) {
        FileStats stats = new FileStats();

        try {
            stats.setSizeOnDisk((long) inputStream.available());
            final String archiveId = storeClient.createArchive().getResponse();

            logger.info("Creating archiveId " + archiveId);

            stats.setArchiveId(archiveId);
            stats.setFilename(filename);
            Path directory = extractDirectory(inputStream);

            List<File> results = Files.walk(directory)
                    .parallel()
                    .filter(Files::isRegularFile)
                    .map(file -> uploadFile(file, archiveId, directory))
                    .collect(Collectors.toList());
            long size = results.stream().map(File::length).reduce(0L, (f1, f2) -> f1 + f2);
            stats.setSize(size);
            stats.setFileCount((long) results.size());
            stats.setInfo(new ArrayList<>());
            Map<String, Long> infos = results.stream()
                    .collect(Collectors.groupingBy(file -> FilenameUtils.getExtension(file.getName()), Collectors
                            .counting()));
            infos.forEach((type, count) -> {
                Info info = new Info();
                info.setCount(count);
                info.setFileType(type);
                stats.getInfo().add(info);
            });

            logger.info("Done uploading files");

            storeClient.finalizeArchive(archiveId);
            FileUtils.deleteDirectory(directory.toFile());
        } catch (IOException e) {
            logger.error("Error uploading corpus", e);
        }

        return stats;
    }

    private File uploadFile(Path file, String archiveId, Path base) {
        String relativeName = base.relativize(file).toString();
        storeClient.storeFile(file.toFile(), archiveId, relativeName);
        logger.info("Uploading " + relativeName + " size " + file.toFile().length());
        return file.toFile();
    }

    @Override
    public InputStream downloadCorpus(String archiveId) {
        try {
            File temp = File.createTempFile("cor", "tmp");

            temp.deleteOnExit();
            storeClient.downloadArchive(archiveId, temp.getAbsolutePath());
            return new FileInputStream(temp);
        } catch (Exception e) {
            logger.error("error downloading file", e);
        }

        return null;
    }

    @Override
    public InputStream downloadFile(String path) {
        try {
            File temp = File.createTempFile("file", "tmp");

            temp.deleteOnExit();
            storeClient.downloadFile(path, temp.getAbsolutePath());
            return new FileInputStream(temp);
        } catch (Exception e) {
            logger.error("error downloading file", e);
        }

        return null;
    }

    @Override
    public List<String> archiveContent(String corpusId, String path, boolean onlyDirectories) {
        String archiveId = OMTDUtils.resolveCorpusArchive(corpusService.get(corpusId));
        List<String> archiveContent = storeClient.listFiles(String.format("%s/%s", archiveId, path), true, false, false);
        // TODO: replace code below with a dedicated method
        if (onlyDirectories) {
            List<String> files = storeClient.listFiles(String.format("%s/%s", archiveId, path), false, false, false);
            files.forEach(archiveContent::remove);
        }
        return archiveContent;
    }

    private Path extractDirectory(InputStream inputStream) throws IOException {
        File temp = File.createTempFile("aux", "tmp");
        Path dest = Files.createTempDirectory("upload");
        OutputStream fos = new BufferedOutputStream(new FileOutputStream(temp));
        logger.info("Temp file " + temp.toString());
        IOUtils.copyLarge(inputStream, fos);
        fos.flush();
        fos.close();
        ZipInputStream zipIn = new ZipInputStream(new FileInputStream(temp));
        ZipEntry entry = zipIn.getNextEntry();

        // iterates over entries in the zip file
        while (entry != null) {
            logger.info("Unzip " + entry.getName());
            String filePath = dest + File.separator + entry.getName();
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
        FileDeleteStrategy.FORCE.delete(temp);
        return dest;
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

    private void iterateThroughDirectories(StoreRESTClient storeClient, String archiveId, File file,
                                           String parent) throws IOException {
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
