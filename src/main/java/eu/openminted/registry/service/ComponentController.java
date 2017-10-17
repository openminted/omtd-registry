package eu.openminted.registry.service;

import eu.openminted.registry.core.service.ServiceException;
import eu.openminted.registry.domain.Component;
import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.io.StringWriter;
import java.net.URL;
import java.net.URLConnection;

@RestController
@RequestMapping("/request/component")
public class ComponentController extends GenericRestController<Component>{

    private ValidateInterface<Component> validateInterface;

    @Autowired
    ComponentController(ValidateInterface<Component> service) {
        super(service);
        validateInterface = service;
    }

    @PreAuthorize("isAuthenticated()")
    @RequestMapping(path = "load", method = RequestMethod.GET, produces = MediaType.APPLICATION_XML_VALUE)
    public ResponseEntity<Component> loadURL(@RequestParam("url") String url,@RequestParam(value = "validate", defaultValue = "true") Boolean validate) {
        URL requestUrl;
        Component ret;
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
        return new ResponseEntity<>(ret,HttpStatus.OK);
    }
}
