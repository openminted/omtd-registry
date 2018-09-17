package eu.openminted.registry.service;

import eu.openminted.registry.core.service.ResourceCRUDService;
import eu.openminted.registry.domain.Corpus;
import org.mitre.openid.connect.model.OIDCAuthenticationToken;
import org.mitre.openid.connect.model.UserInfo;
import org.springframework.security.core.Authentication;

/**
 * Created by stefanos on 3/12/18.
 */
public interface CorpusService extends ResourceCRUDService<Corpus,OIDCAuthenticationToken> {

    /**
     * Sets the archiveId as a distribution location of the corpus and as a resource identifier.
     * @param corpus to be filled with the archiveId
     * @param archiveId of the corpus
     * @return the corpus filled.
     */
    Corpus uploadZip(Corpus corpus, String archiveId, Authentication auth);
}
