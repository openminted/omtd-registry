package eu.openminted.registry.service.omtd;

import eu.openminted.registry.core.service.ResourceCRUDService;
import eu.openminted.registry.core.service.ServiceException;
import eu.openminted.registry.domain.BaseMetadataRecord;
import eu.openminted.registry.service.GenericRestController;
import eu.openminted.registry.service.ValidateInterface;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.io.IOUtils;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.io.IOException;
import java.io.StringWriter;
import java.net.URL;
import java.net.URLConnection;

public class OmtdRestController<T extends BaseMetadataRecord> extends GenericRestController<T> {

    private ValidateInterface<T> validateInterface;

    public OmtdRestController(ResourceCRUDService<T> service) {
        super(service);
        validateInterface = (ValidateInterface<T>) service;
    }

    @PreAuthorize("isAuthenticated()")
    @ApiOperation(value = "Loads the url and then validates according the resourceType schema.")
    @RequestMapping(path = "load", method = RequestMethod.GET)
    public ResponseEntity<T> loadURL(
            @RequestParam("url") String url,
            @RequestParam(value = "validate", defaultValue = "true", required = false) Boolean validate) {
        URL requestUrl;
        T ret;
        try {
            requestUrl = new URL(url);
            URLConnection yc = requestUrl.openConnection();
            StringWriter writer = new StringWriter();
            IOUtils.copy(yc.getInputStream(),writer);
            System.out.println(writer.toString());
            ret = validateInterface.deserialize(writer.toString());
            if(validate) {
                validateInterface.validate(ret);
            }
        } catch (IOException e) {
            throw new ServiceException(e);
        }
        ResponseEntity response = ResponseEntity.ok().
                contentType(MediaType.APPLICATION_XML).body(ret);
        return response;
    }

    @PreAuthorize("isAuthenticated()")
    @ApiOperation(value = "Validates the resource provided with the schema of the resource stored in the registry.")
    @RequestMapping(path = "validate", method = RequestMethod.POST)
    public ResponseEntity<Boolean> validate(@RequestBody T resource) {
        return ResponseEntity.ok(validateInterface.validate(resource));
    }
}
