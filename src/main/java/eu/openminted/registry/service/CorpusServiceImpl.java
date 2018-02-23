package eu.openminted.registry.service;

import eu.openminted.registry.domain.Corpus;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

/**
 * Created by stefanos on 15-Nov-16.
 */
@Service("corpusService")
@Primary
public class CorpusServiceImpl extends OmtdGenericService<Corpus> {

    private Logger logger = Logger.getLogger(CorpusServiceImpl.class);

    public CorpusServiceImpl() {
        super(Corpus.class);
    }

    @Override
    public String getResourceType() {
        return "corpus";
    }

}
