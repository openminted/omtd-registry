package eu.openminted.registry.service;

import eu.openminted.registry.core.domain.Resource;
import eu.openminted.registry.core.service.ResourceCRUDService;
import eu.openminted.registry.core.service.SearchService;
import eu.openminted.registry.core.service.ServiceException;
import eu.openminted.registry.domain.Corpus;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.net.UnknownHostException;

/**
 * Created by stefanos on 15-Nov-16.
 */
@Service("incompleteCorpusService")
@Primary
public class IncompleteCorpusServiceImpl extends OmtdGenericService<Corpus> implements IncompleteCorpusService {

    @Autowired
    CorpusService corpusService;

    private Logger logger = Logger.getLogger(IncompleteCorpusServiceImpl.class);

    public IncompleteCorpusServiceImpl() {
        super(Corpus.class);
    }

    public void move(String corpusId) {
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
