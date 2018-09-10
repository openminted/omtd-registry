package eu.openminted.registry.service;

import eu.openminted.registry.core.service.ResourceCRUDService;
import org.mitre.openid.connect.model.OIDCAuthenticationToken;

/**
 * Basic validation interface
 * @author stefanos
 */
public interface ValidateInterface<T> extends ResourceCRUDService<T,OIDCAuthenticationToken>{

    Boolean validate(T resource);

    T deserialize(String resource);

    String serialize(T resource);
}
