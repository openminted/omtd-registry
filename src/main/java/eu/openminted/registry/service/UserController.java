package eu.openminted.registry.service;

import eu.openminted.registry.core.exception.ServerError;
import eu.openminted.registry.core.service.ResourceService;
import eu.openminted.registry.core.service.SearchService;
import eu.openminted.registry.domain.User;
import org.apache.log4j.Logger;
import org.mitre.openid.connect.model.OIDCAuthenticationToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;


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
        if(authentication.getUserInfo().getName() == null || authentication.getUserInfo().getName().equals("")) {
            body.put("name",authentication.getUserInfo().getGivenName() + " " + authentication.getUserInfo().getFamilyName());
        } else {
            body.put("name",authentication.getUserInfo().getName());
        }
        body.put("email",authentication.getUserInfo().getEmail());
        List<String> roles = authentication.getAuthorities().stream().map(GrantedAuthority::getAuthority).collect(Collectors.toList());
        body.put("role",roles);
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

    @ResponseStatus(HttpStatus.FORBIDDEN)
    @ExceptionHandler(AccessDeniedException.class)
    @ResponseBody
    ServerError securityException(HttpServletRequest req, Exception ex) {
        return new ServerError(req.getRequestURL().toString(),ex);
    }
}
