package eu.openminted.registry.service;

/**
 * Created by stefanos on 3/12/18.
 */
public interface WebannoService {

    /**
     * Method for uploading a corpus, at the webanno
     * annotation viewer, as a project.
     * @param corpusId
     */
    boolean createProject(String corpusId);

    void triggerRetrieval(long projectId);
}
