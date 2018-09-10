package eu.openminted.registry.service;

import eu.openminted.registry.core.service.ResourceCRUDService;
import eu.openminted.registry.domain.Corpus;
import org.mitre.openid.connect.model.OIDCAuthenticationToken;
import org.mitre.openid.connect.model.UserInfo;

import java.io.InputStream;

/**
 * Created by antleb on 1/19/17.
 */
public interface IncompleteCorpusService extends ResourceCRUDService<Corpus,OIDCAuthenticationToken> {
    void move(String corpusId);
}
