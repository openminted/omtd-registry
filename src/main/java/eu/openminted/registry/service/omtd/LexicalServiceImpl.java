package eu.openminted.registry.service.omtd;

import eu.openminted.registry.domain.*;
import eu.openminted.registry.service.AncillaryService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

/**
 * Created by stefanos on 13/1/2017.
 */
@Service("lexicalService")
@Primary
public class LexicalServiceImpl extends OmtdGenericService<Lexical> implements AncillaryService<Lexical> {

    public LexicalServiceImpl() {
        super(Lexical.class);
    }

    @Override
    public String getResourceType() {
        return "lexical";
    }

    @Value("${registry.host}/request/store/download?archiveId=")
    private String hostUrl;

    @Override
    public Lexical uploadZip(Lexical ancillary, String archiveId) {
        String distributionLocation = hostUrl + archiveId;
        for (DatasetDistributionInfo info : ancillary.getLexicalConceptualResourceInfo().getDistributionInfos()) {
            info.setDistributionLocation(distributionLocation);
        }
        ResourceIdentifier identifier = new ResourceIdentifier();
        identifier.setValue(archiveId);
        identifier.setResourceIdentifierSchemeName(ResourceIdentifierSchemeNameEnum.OMTD);
        ancillary.getLexicalConceptualResourceInfo().getIdentificationInfo().getResourceIdentifiers().add(identifier);
        super.add(ancillary);
        return ancillary;
    }

}
