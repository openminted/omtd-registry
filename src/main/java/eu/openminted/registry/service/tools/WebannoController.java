package eu.openminted.registry.service.tools;

import eu.openminted.registry.service.WebannoService;
import eu.openminted.registry.service.requests.AnnotationStateChangeMessage;
import eu.openminted.registry.service.requests.ProjectStateChangeMessage;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@RestController
public class WebannoController {

    private Logger logger = LogManager.getLogger(WebannoController.class);

    @Autowired
    WebannoService webannoService;

    @RequestMapping(value = "/webanno/done", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity done_POST (ProjectStateChangeMessage projectStateChangeMessage) {
           webannoService.triggerRetrieval(projectStateChangeMessage.getProjectId());
           return new ResponseEntity<>("hello",HttpStatus.OK);
    }


}
