package eu.openminted.registry.service.aai;

import eu.openminted.registry.domain.*;
import eu.openminted.registry.service.policy.PolicyInterface;
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
        if (resource instanceof Component) {
            return ((Component) resource).getComponentInfo().getIdentificationInfo().isPublic();
        } else if (resource instanceof Corpus) {
            return ((Corpus) resource).getCorpusInfo().getIdentificationInfo().isPublic();
        } else if (resource instanceof Lexical) {
            return ((Lexical) resource).getLexicalConceptualResourceInfo().getIdentificationInfo().isPublic();
        } else if (resource instanceof LanguageDescription) {
            return ((LanguageDescription) resource).getLanguageDescriptionInfo().getIdentificationInfo().isPublic();
        } else {
            return false;
        }
    }
}
