package eu.openminted.registry.service;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import eu.openminted.registry.core.domain.Paging;
import eu.openminted.registry.core.domain.Resource;
import eu.openminted.registry.core.service.ResourceService;
import eu.openminted.registry.core.service.SearchService;
import eu.openminted.registry.core.service.ServiceException;
import eu.openminted.registry.domain.User;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.Date;

@RestController
public class UserController {

    @Autowired
    ResourceService resourceService;

    @Autowired
    SearchService searchService;

    private Logger logger = Logger.getLogger(UserController.class);

//    @RequestMapping(value = "/user/login", method = RequestMethod.POST, headers =
//            "Accept=application/json")
//    public ResponseEntity<String> getUser(@PathVariable("username") String username,
//                                          @PathVariable("password") String password) {
//        return new ResponseEntity<>("{\"message\":\"not supported.\"}", HttpStatus.NOT_IMPLEMENTED);
//    }

    @RequestMapping(value = "/user/register", method = RequestMethod.POST, headers = "Accept=application/json")
    public ResponseEntity<String> addUser(@RequestBody User user) {
        return new ResponseEntity<>("{\"message\":\"not supported.\"}", HttpStatus.NOT_IMPLEMENTED);
    }

    @RequestMapping(value = "/user/edit", method = RequestMethod.POST, headers = "Accept=application/json")
    public ResponseEntity<String> updateUser(@RequestBody User user) {
        return new ResponseEntity<>("{\"message\":\"not supported.\"}", HttpStatus.NOT_IMPLEMENTED);
    }
//	  
//	    @RequestMapping(value = "/resources/{id}", method = RequestMethod.DELETE, headers = "Accept=application/json")  
//	    public void deleteResources(@PathVariable("id") String id) {  
//	        resourceService.deleteResource(id);  
//	    }   


}
