package eu.openminted.registry.service;

import eu.openminted.registry.core.service.ResourceCRUDService;

/**
 * Basic validation interface
 * @author stefanos
 */
public interface ValidateInterface<T> extends ResourceCRUDService<T>{

    Boolean validate(T resource);

    T deserialize(String resource);

    String serialize(T resource);
}
