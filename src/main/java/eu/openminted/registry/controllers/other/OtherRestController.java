package eu.openminted.registry.controllers.other;

import eu.openminted.registry.core.exception.ResourceNotFoundException;
import eu.openminted.registry.core.service.ResourceCRUDService;
import eu.openminted.registry.controllers.GenericRestController;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import springfox.documentation.annotations.ApiIgnore;

public class OtherRestController<T> extends GenericRestController<T> {

    public OtherRestController(ResourceCRUDService service) {
        super(service);
    }

    @Override
    public ResponseEntity<T> get(@PathVariable("id") String id) throws ResourceNotFoundException {
        return super.get(id);
    }

    @Override
    @ApiIgnore
    @PreAuthorize("hasRole('ROLE_ADMIN') or denyAll()")
    public ResponseEntity<T> update(@RequestBody T component) throws ResourceNotFoundException {
        return super.update(component);
    }

    @Override
    @ApiIgnore
    @PreAuthorize("hasRole('ROLE_ADMIN') or denyAll()")
    public ResponseEntity<String> delete(@RequestBody T component) throws ResourceNotFoundException {
        return super.delete(component);
    }

    @Override
    @ApiIgnore
    @PreAuthorize("hasRole('ROLE_ADMIN') or denyAll()")
    public ResponseEntity<T> add(@RequestBody T component) {
        return super.add(component);
    }

}
