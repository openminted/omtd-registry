package eu.openminted.registry.service.omtd;

import eu.openminted.registry.domain.Corpus;
import eu.openminted.registry.domain.DistributionMediumEnum;
import eu.openminted.registry.domain.ResourceIdentifier;
import eu.openminted.registry.domain.ResourceIdentifierSchemeNameEnum;
import eu.openminted.registry.service.CorpusService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

/**
 * Created by stefanos on 15-Nov-16.
 */
@Service("corpusService")
@Primary
public class CorpusServiceImpl extends OmtdGenericService<Corpus> implements CorpusService {

    @Value("${registry.host}/request/corpus/download?archiveId=")
    private String hostUrl;

    private Logger logger = LogManager.getLogger(CorpusServiceImpl.class);

    public CorpusServiceImpl() {
        super(Corpus.class);
    }

    @Override
    public String getResourceType() {
        return "corpus";
    }

    @Override
    public Corpus uploadZip(Corpus corpus, String archiveId) {
        String distributionLocation = hostUrl + archiveId;
        corpus.getCorpusInfo().getDatasetDistributionInfo().setDistributionLocation(distributionLocation);
        corpus.getCorpusInfo().getDatasetDistributionInfo().setDistributionMedium(DistributionMediumEnum.DOWNLOADABLE);
        ResourceIdentifier identifier = new ResourceIdentifier();
        identifier.setValue(archiveId);
        identifier.setResourceIdentifierSchemeName(ResourceIdentifierSchemeNameEnum.OMTD);
        corpus.getCorpusInfo().getIdentificationInfo().getResourceIdentifiers().add(identifier);
        super.add(corpus);
        return corpus;
    }
}
