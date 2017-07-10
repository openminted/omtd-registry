package eu.openminted.registry.service;

import eu.openminted.registry.core.service.ResourceCRUDService;
import eu.openminted.registry.domain.Corpus;

import java.io.InputStream;

/**
 * Created by antleb on 1/19/17.
 */
public interface CorpusService extends ResourceCRUDService<Corpus> {

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
