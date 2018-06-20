package eu.openminted.registry.service;


import eu.openminted.registry.core.domain.Browsing;
import eu.openminted.registry.domain.CorpusContent;
import eu.openminted.registry.domain.PublicationInfo;

/**
 * Created by spyroukostas on 7-Feb-2018.
 */
public interface CorpusContentService {

    /**
     * Retrieves information about the content of the corpus.
     * @param corpusId
     * @return
     */
    Browsing<PublicationInfo> getCorpusContent(String corpusId, int from, int size);
}
