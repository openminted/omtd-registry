package eu.openminted.registry.service;

import eu.openminted.registry.domain.file.FileStats;

import java.io.InputStream;

public interface StoreService {

    /**
     * Uploads a zipped corpus and returns the archive id where it was saved.
     *
     * @param inputStream
     * @return
     */
    String uploadCorpus(String filename, InputStream inputStream);


    FileStats uploadAuxiliary(String filename, InputStream inputStream);

    /**
     * Download the corpus.
     *
     * @param archiveId
     * @return
     */
    InputStream downloadCorpus(String archiveId);

    /**
     * Download a file.
     *
     * @param path
     * @return
     */
    InputStream downloadFile(String path);

}
