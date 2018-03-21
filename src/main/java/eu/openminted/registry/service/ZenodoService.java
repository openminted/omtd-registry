package eu.openminted.registry.service;

/**
 * Created by spyroukostas on 16-Mar-2018.
 */
public interface ZenodoService {

    /**
     * Create and publish a corpus deposition.
     * @param corpusId
     * @return
     */
    String publishCorpus(String corpusId);

    /**
     * Create a new deposition resource.
     * @return
     */
    String createDeposition();

    /**
     * Create a new deposition resource with the given metadata.
     * @return
     */
    String createDeposition(String metadata);

    /**
     * Retrieve a single deposition resource.
     * @return
     */
    String retrieveDeposition(String zenodo_id);

    /**
     * Update an existing deposition resource.
     * @return
     */
    String updateDeposition(String zenodo_id, String metadata);

    /**
     * Delete an existing deposition resource. Note, only unpublished depositions may be deleted.
     * @return
     */
    boolean deleteDeposition(String zenodo_id);

}
