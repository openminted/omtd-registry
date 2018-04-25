package eu.openminted.registry.service.omtd;

import eu.openminted.registry.core.exception.ResourceNotFoundException;
import eu.openminted.registry.core.service.ServiceException;
import eu.openminted.registry.domain.BaseMetadataRecord;
import eu.openminted.registry.service.GenericRestController;
import eu.openminted.registry.service.ValidateInterface;
import org.apache.commons.io.IOUtils;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PostAuthorize;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.io.StringWriter;
import java.net.URL;
import java.net.URLConnection;

public class OmtdRestController<T extends BaseMetadataRecord> extends GenericRestController<T> {

    private ValidateInterface<T> validateInterface;

    OmtdRestController(ValidateInterface<T> service) {
        super(service);
        validateInterface = service;
    }

    @Override
    @PostAuthorize("hasRole('ROLE_ADMIN') or (@omtdPolicyService.isPublic(returnObject.body) or (isAuthenticated() and @omtdPolicyService.isOwn(returnObject.body,principal['sub'])))")
    public ResponseEntity<T> get(@PathVariable("id") String id) throws ResourceNotFoundException {
        return super.get(id);
    }

    @Override
    @PreAuthorize("hasRole('ROLE_ADMIN') or (not @omtdPolicyService.isPublic(component) and isAuthenticated() and @omtdPolicyService.isOwn(component,principal['sub']))")
    public ResponseEntity<T> update(@RequestBody T component) throws ResourceNotFoundException {
        return super.update(component);
    }

    @Override
    @PreAuthorize("hasRole('ROLE_ADMIN') or (not @omtdPolicyService.isPublic(component) and isAuthenticated() and @omtdPolicyService.isOwn(component,principal['sub']))")
    public ResponseEntity<String> delete(@RequestBody T component) throws ResourceNotFoundException {
        return super.delete(component);
    }

    @Override
    @PreAuthorize("isAuthenticated()")
    public ResponseEntity<T> add(@RequestBody T component) {
        return super.add(component);
    }

    @PreAuthorize("isAuthenticated()")
    @RequestMapping(path = "load", method = RequestMethod.GET)
    public ResponseEntity<String> loadURL(@RequestParam("url") String url, @RequestParam(value = "validate", defaultValue = "true") Boolean validate) {
        URL requestUrl;
        T resource;
        try {
            requestUrl = new URL(url);
            URLConnection yc = requestUrl.openConnection();
            StringWriter writer = new StringWriter();
            IOUtils.copy(yc.getInputStream(),writer);
            resource = validateInterface.deserialize(writer.toString());
            if(validate) {
                validateInterface.validate(resource);
            }
        } catch (IOException e) {
            throw new ServiceException(e);
        }
        return ResponseEntity.ok().
                contentType(MediaType.APPLICATION_XML).body(validateInterface.serialize(resource));
    }
}
