package eu.openminted.registry.service.omtd;

import eu.openminted.registry.domain.Corpus;
import eu.openminted.registry.service.CorpusService;
import eu.openminted.registry.service.IncompleteCorpusService;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;
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
    CorpusService corpusService;

    private Logger logger = LogManager.getLogger(IncompleteCorpusServiceImpl.class);

    public IncompleteCorpusServiceImpl() {
        super(Corpus.class);
    }

    public void move(String corpusId) {
        logger.info("moving corpus with id " + corpusId);
        Corpus resource = this.get(corpusId);
        if (resource != null) {
            corpusService.add(resource);
        }
        this.delete(resource);
    }

    @Override
    public String getResourceType() {
        return "incompletecorpus";
    }
}
