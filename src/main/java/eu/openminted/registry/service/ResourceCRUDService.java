package eu.openminted.registry.service;

import java.util.List;

/**
 * Created by stefanos on 15-Nov-16.
 */
public interface ResourceCRUDService<T> {

    T get(String id);

    List<T> getAll();

    void add(T resource);

    void update(T resource);

    void delete(T resource);

}
