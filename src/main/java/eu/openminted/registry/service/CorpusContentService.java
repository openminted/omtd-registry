package eu.openminted.registry.service;


import eu.openminted.registry.domain.CorpusContent;

/**
 * Created by spyroukostas on 7-Feb-2018.
 */
public interface CorpusContentService {

    /**
     * Retrieves information about the content of the corpus.
     * @param corpusId
     * @return
     */
    CorpusContent getCorpusContent(String corpusId);
}
