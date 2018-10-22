package eu.openminted.registry.service;

import eu.openminted.registry.core.service.ResourceCRUDService;
import eu.openminted.registry.domain.operation.Monitoring;
import eu.openminted.registry.domain.operation.Operation;
import org.mitre.openid.connect.model.OIDCAuthenticationToken;
import org.mitre.openid.connect.model.UserInfo;

public interface OperationService extends ResourceCRUDService<Operation,OIDCAuthenticationToken> {

    String executeJob(String corpusId,String applicationId, String subArchive);

    Monitoring aggregate(OIDCAuthenticationToken auth);

}
