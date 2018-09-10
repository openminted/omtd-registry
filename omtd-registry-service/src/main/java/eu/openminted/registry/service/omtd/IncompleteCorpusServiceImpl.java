package eu.openminted.registry.service.omtd;

import eu.openminted.registry.core.service.ResourceCRUDService;
import eu.openminted.registry.domain.Corpus;
import eu.openminted.registry.service.IncompleteCorpusService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.mitre.openid.connect.model.OIDCAuthenticationToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

/**
 * Created by stefanos on 15-Nov-16.
 */
@Service("incompleteCorpusService")
@Primary
public class IncompleteCorpusServiceImpl extends OmtdGenericService<Corpus> implements IncompleteCorpusService {

    @Autowired
    ResourceCRUDService<Corpus, OIDCAuthenticationToken> corpusService;
    private Logger logger = LogManager.getLogger(IncompleteCorpusServiceImpl.class);

    public IncompleteCorpusServiceImpl() {
        super(Corpus.class);
    }

    public void move(String corpusId) {
        logger.info("moving corpus with id " + corpusId);
        Corpus resource = this.get(corpusId);
        if (resource != null) {
            resource.getMetadataHeaderInfo().setRevision("output");
            corpusService.add(resource,null);
        }
        this.delete(resource);
    }

    @Override
    public Corpus add(Corpus resource, OIDCAuthenticationToken auth) {
        resource.getMetadataHeaderInfo().setRevision("incomplete");
        return super.add(resource,auth);
    }

    @Override
    public String getResourceType() {
        return "incompletecorpus";
    }
}
