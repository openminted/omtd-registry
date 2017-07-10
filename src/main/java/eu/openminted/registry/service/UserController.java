package eu.openminted.registry.service;

import eu.openminted.registry.core.service.ResourceService;
import eu.openminted.registry.core.service.SearchService;
import eu.openminted.registry.domain.User;
import org.apache.log4j.Logger;
import org.mitre.openid.connect.model.OIDCAuthenticationToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;


@RestController
public class UserController {

    @Autowired
    ResourceService resourceService;

    @Autowired
    SearchService searchService;

    private Logger logger = Logger.getLogger(UserController.class);

    @PreAuthorize("hasRole('ROLE_USER')")
    @RequestMapping(value = "/user", method = RequestMethod.GET, produces= MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> getUser() {
        OIDCAuthenticationToken authentication = (OIDCAuthenticationToken) SecurityContextHolder.getContext().getAuthentication();
        Map<String,Object> body = new HashMap<>();
        body.put("sub",authentication.getSub());
        body.put("name",authentication.getUserInfo().getName());
        body.put("email",authentication.getUserInfo().getEmail());
        return new ResponseEntity<>(body, HttpStatus.OK);
    }

    @RequestMapping(value = "/user/register", method = RequestMethod.POST, headers = "Accept=application/json")
    public ResponseEntity<String> addUser(@RequestBody User user) {
        return new ResponseEntity<>("{\"message\":\"not supported.\"}", HttpStatus.NOT_IMPLEMENTED);
    }

    @RequestMapping(value = "/user/edit", method = RequestMethod.POST, headers = "Accept=application/json")
    public ResponseEntity<String> updateUser(@RequestBody User user) {
        return new ResponseEntity<>("{\"message\":\"not supported.\"}", HttpStatus.NOT_IMPLEMENTED);
    }

}
