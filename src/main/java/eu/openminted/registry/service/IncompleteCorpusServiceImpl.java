package eu.openminted.registry.service;

import eu.openminted.registry.core.domain.Resource;
import eu.openminted.registry.core.service.ResourceCRUDService;
import eu.openminted.registry.core.service.SearchService;
import eu.openminted.registry.core.service.ServiceException;
import eu.openminted.registry.domain.Corpus;
import org.apache.log4j.Logger;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.net.UnknownHostException;

/**
 * Created by stefanos on 15-Nov-16.
 */
@Service("incompleteCorpusService")
@Primary
public class IncompleteCorpusServiceImpl extends OmtdGenericService<Corpus> implements ResourceCRUDService<Corpus>, IncompleteCorpusService {

    private static final String CORPUS_ID = "omtdid";

    private Logger logger = Logger.getLogger(IncompleteCorpusServiceImpl.class);


    public IncompleteCorpusServiceImpl() {
        super(Corpus.class);
    }

    @Override
    public void delete(Corpus resource) {
        Resource resource1;
        try {
            SearchService.KeyValue kv = new SearchService.KeyValue(
                    CORPUS_ID,
                    resource.getMetadataHeaderInfo().getMetadataRecordIdentifier().getValue()
            );
            resource1 = searchService.searchId(getResourceType(), kv);
            if (resource1 == null) {
                throw new ServiceException(getResourceType() + " does not exists");
            } else {
                resourceService.deleteResource(resource.getMetadataHeaderInfo().getMetadataRecordIdentifier().getValue());
            }
        } catch (UnknownHostException e) {
            logger.fatal(e);
            throw new ServiceException(e);
        }
    }

    @Override
    public String getResourceType() {
        return "incompletecorpus";
    }
}
