package eu.openminted.registry.service;

import eu.openminted.registry.core.service.ResourceCRUDService;
import eu.openminted.registry.domain.Corpus;

/**
 * Created by stefanos on 3/12/18.
 */
public interface AncillaryService<T> extends ResourceCRUDService<T> {

    /**
     * Sets the archiveId as a distribution location of the corpus and as a resource identifier.
     * @param ancillary to be filled with the archiveId
     * @param archiveId of the uploaded zip
     * @return the resource filled.
     */
    T uploadZip(T ancillary, String archiveId);
}
