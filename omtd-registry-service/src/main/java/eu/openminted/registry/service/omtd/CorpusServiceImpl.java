package eu.openminted.registry.service.omtd;

import eu.openminted.registry.core.exception.ResourceNotFoundException;
import eu.openminted.registry.core.service.ServiceException;
import eu.openminted.registry.domain.*;
import eu.openminted.registry.service.CorpusService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.mitre.openid.connect.model.OIDCAuthenticationToken;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Primary;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

/**
 * Created by stefanos on 15-Nov-16.
 */
@Service("corpusService")
@Primary
public class CorpusServiceImpl extends OmtdGenericService<Corpus> implements CorpusService {

    @Value("${registry.host}/request/corpus/download/")
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
    public Corpus uploadZip(Corpus corpus, String archiveId, Authentication authentication) {
        //Set the distributionLocation to the base path in order to pass the validation
        String distributionLocation = hostUrl;
        corpus.getCorpusInfo().getDatasetDistributionInfo().setDistributionLocation(distributionLocation);
        corpus.getCorpusInfo().getDatasetDistributionInfo().setDistributionMedium(DistributionMediumEnum.DOWNLOADABLE);
        ResourceIdentifier identifier = new ResourceIdentifier();
        identifier.setValue(archiveId);
        identifier.setResourceIdentifierSchemeName(ResourceIdentifierSchemeNameEnum.OTHER);
        identifier.setSchemeURI("archiveID");
        corpus.getCorpusInfo().getIdentificationInfo().getResourceIdentifiers().add(identifier);
        corpus = super.add(corpus, (OIDCAuthenticationToken) authentication);
        corpus.getCorpusInfo().getDatasetDistributionInfo().
                setDistributionLocation(hostUrl + corpus.getMetadataHeaderInfo().getMetadataRecordIdentifier()
                        .getValue());
        try {
            corpus = super.update(corpus,null);
        } catch (ResourceNotFoundException e) {
            throw new ServiceException(e);
        }
        return corpus;
    }

    @Override
    public Corpus add(Corpus resource, OIDCAuthenticationToken auth) {
        return super.add(resource,auth);
    }
}
