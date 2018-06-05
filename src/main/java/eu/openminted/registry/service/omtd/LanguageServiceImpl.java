package eu.openminted.registry.service.omtd;

import eu.openminted.registry.domain.DatasetDistributionInfo;
import eu.openminted.registry.domain.LanguageDescription;
import eu.openminted.registry.domain.ResourceIdentifier;
import eu.openminted.registry.domain.ResourceIdentifierSchemeNameEnum;
import eu.openminted.registry.service.AncillaryService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

/**
 * Created by stefanos on 13/1/2017.
 */
@Service("languageService")
@Primary
public class LanguageServiceImpl extends OmtdGenericService<LanguageDescription> implements AncillaryService<LanguageDescription> {

    public LanguageServiceImpl() {
        super(LanguageDescription.class);
    }

    @Override
    public String getResourceType() {
        return "language";
    }

    @Value("${registry.host}/request/store/download?archiveId=")
    private String hostUrl;

    @Override
    public LanguageDescription uploadZip(LanguageDescription ancillary, String archiveId) {
        String distributionLocation = hostUrl + archiveId;
        for (DatasetDistributionInfo info : ancillary.getLanguageDescriptionInfo().getDistributionInfos()) {
            info.setDistributionLocation(distributionLocation);
        }
        ResourceIdentifier identifier = new ResourceIdentifier();
        identifier.setValue(archiveId);
        identifier.setResourceIdentifierSchemeName(ResourceIdentifierSchemeNameEnum.OMTD);
        ancillary.getLanguageDescriptionInfo().getIdentificationInfo().getResourceIdentifiers().add(identifier);
        super.add(ancillary);
        return ancillary;
    }
}
