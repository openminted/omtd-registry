package eu.openminted.registry.service;

import eu.openminted.registry.core.service.ServiceException;
import eu.openminted.registry.domain.BaseMetadataRecord;
import org.apache.commons.io.IOUtils;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.io.IOException;
import java.io.StringWriter;
import java.net.URL;
import java.net.URLConnection;

public class OmtdRestController<T extends BaseMetadataRecord> extends GenericRestController<T>{

    private ValidateInterface<T> validateInterface;

    OmtdRestController(ValidateInterface<T> service) {
        super(service);
        validateInterface = service;
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
