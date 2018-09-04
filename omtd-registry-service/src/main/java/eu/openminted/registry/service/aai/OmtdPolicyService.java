package eu.openminted.registry.service.aai;

import eu.openminted.registry.domain.BaseMetadataRecord;
import eu.openminted.registry.domain.IdentificationInfo;
import eu.openminted.registry.service.policy.PolicyInterface;
import eu.openminted.registry.utils.OMTDUtils;
import org.springframework.stereotype.Service;

@Service("omtdPolicyService")
public class OmtdPolicyService<T extends BaseMetadataRecord> implements PolicyInterface<T> {

    @Override
    final public boolean isOwn(T resource, String sub) {
        return resource.getMetadataHeaderInfo().getMetadataCreators().stream().anyMatch(creator ->
                creator.getPersonIdentifiers().get(0).getValue().equals(sub));
    }

    @Override
    public boolean isPublic(T resource) {
        IdentificationInfo identificationInfo = OMTDUtils.resolveIdentificationInfo(resource);
        return (identificationInfo != null) && identificationInfo.isPublic();
    }
}
