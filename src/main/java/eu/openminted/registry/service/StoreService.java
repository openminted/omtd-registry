package eu.openminted.registry.service;

import java.io.InputStream;

public interface StoreService {

    /**
     * Uploads a zipped corpus and returns the archive id where it was saved.
     *
     * @param inputStream
     * @return
     */
    String uploadCorpus(String filename, InputStream inputStream);

    /**
     * Download the corpus.
     *
     * @param archiveId
     * @return
     */
    InputStream downloadCorpus(String archiveId);
}
