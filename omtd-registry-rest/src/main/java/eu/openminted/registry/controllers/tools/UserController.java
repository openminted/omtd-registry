package eu.openminted.registry.controllers.tools;

import eu.openminted.registry.core.service.ResourceService;
import eu.openminted.registry.core.service.SearchService;
import eu.openminted.registry.service.AdminService;
import io.swagger.annotations.Api;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.mitre.openid.connect.model.OIDCAuthenticationToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;


@RestController
@Api(description = "Returns user Details", tags = "User")
public class UserController {

    @Autowired
    ResourceService resourceService;

    @Autowired
    SearchService searchService;

    @Autowired
    AdminService adminService;

    private Logger logger = LogManager.getLogger(UserController.class);

    @PreAuthorize("hasRole('ROLE_USER')")
    @RequestMapping(value = "/user", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> getUser() {
        OIDCAuthenticationToken authentication = (OIDCAuthenticationToken) SecurityContextHolder.getContext().getAuthentication();
        Map<String, Object> body = new HashMap<>();
        body.put("sub", authentication.getSub());
        if (authentication.getUserInfo().getName() == null || authentication.getUserInfo().getName().equals("")) {
            body.put("name", authentication.getUserInfo().getGivenName() + " " + authentication.getUserInfo().getFamilyName());
        } else {
            body.put("name", authentication.getUserInfo().getName());
        }
        body.put("email", authentication.getUserInfo().getEmail());
        List<String> roles = authentication.getAuthorities().stream().map(GrantedAuthority::getAuthority).collect(Collectors.toList());
        body.put("role", roles);
        return new ResponseEntity<>(body, HttpStatus.OK);
    }

    @PreAuthorize("hasRole('ROLE_USER')")
    @RequestMapping(value = "/task/corpusSize", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> calculate() throws Exception {
        adminService.computeSizes();
        return null;
    }

    @PreAuthorize("hasRole('ROLE_USER')")
    @RequestMapping(value = "/task/process", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> calculateProcess() throws Exception {
        adminService.computeProcessStatistics();
        return null;
    }

}
