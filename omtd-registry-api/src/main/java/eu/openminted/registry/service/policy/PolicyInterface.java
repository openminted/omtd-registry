package eu.openminted.registry.service.policy;

/**
 * Interface draft that services can use to abstract the authorization policies.
 * @param <T> the resource to be checked
 */
public interface PolicyInterface<T> {

    /**
     * @param resource to be checked for ownership
     * @param sub the owner
     */
    boolean isOwn(T resource, String sub);

    /**
     * @param resource to be checked if it is publicly available
     */
    boolean isPublic(T resource);

}
