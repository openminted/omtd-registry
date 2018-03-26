package eu.openminted.registry.service;

import org.json.JSONObject;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.InputStream;

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
     * List all depositions for the currently authenticated user.
     * @return
     */
    String listDepositions();

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
    String retrieveDeposition(String zenodoId);

    /**
     * Update an existing deposition resource.
     * @return
     */
    String updateDeposition(String zenodoId, String metadata);

    /**
     * Delete an existing deposition resource.
     * Note, only unpublished depositions may be deleted.
     * @return
     */
    void deleteDeposition(String zenodoId);

    /**
     * Upload a new file.
     * @param zenodoId
     * @param file
     * @return
     */
    String uploadFile(String zenodoId, File file);

    /**
     * Sort the files for a deposition.
     * By default, the first file is shown in the file preview.
     * @param zenodoId
     * @param ids
     * @return
     */
    String sort(String zenodoId, JSONObject ids);

    /**
     * Retrieve a single deposition file.
     * @param zenodoId
     * @param fileId
     * @return
     */
    String retrieveFile(String zenodoId, String fileId);

    /**
     * Update a deposition file resource. Currently the only use is renaming an already uploaded file.
     * If you want to replace the actual file, please delete the file and upload a new file.
     * @param zenodoId
     * @param fileId
     * @param newName
     * @return
     */
    String updateFile(String zenodoId, String fileId, String newName);

    /**
     * Delete an existing deposition file resource.
     * Note, only deposition files for unpublished depositions may be deleted.
     * @param zenodoId
     * @param fileId
     * @return
     */
    void deleteFile(String zenodoId, String fileId);

    /**
     * Publish a deposition.
     * Note, once a deposition is published, you can no longer delete it.
     * @param zenodoId
     * @return
     */
    void publish(String zenodoId);

    /**
     * Unlock already submitted deposition for editing.
     * @param zenodoId
     * @return
     */
    String edit(String zenodoId);

    /**
     * Discard changes in the current editing session.
     * @param zenodoId
     * @return
     */
    void discard(String zenodoId);

}
