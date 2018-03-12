package eu.openminted.registry.service;

import eu.openminted.registry.core.service.ResourceCRUDService;
import eu.openminted.registry.domain.Corpus;

/**
 * Created by stefanos on 3/12/18.
 */
public interface CorpusService extends ResourceCRUDService<Corpus> {

    /**
     * Sets the archiveId as a distribution location of the corpus and as a resource identifier.
     * @param corpus to be filled with the archiveId
     * @param archiveId of the corpus
     * @return the corpus filled.
     */
    Corpus uploadZip(Corpus corpus, String archiveId);
}
