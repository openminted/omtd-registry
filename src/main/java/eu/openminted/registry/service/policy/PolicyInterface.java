package eu.openminted.registry.service.policy;

public interface PolicyInterface<T> {

    boolean isOwn(T resource, String sub);

    boolean isPublic(T resource);

}
