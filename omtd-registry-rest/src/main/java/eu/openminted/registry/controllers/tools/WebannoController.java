package eu.openminted.registry.controllers.tools;

import eu.openminted.registry.controllers.requests.ProjectStateChangeMessage;
import eu.openminted.registry.domain.WebannoProject;
import eu.openminted.registry.service.WebannoService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.ServletContext;

@RestController
public class WebannoController {

    private Logger logger = LogManager.getLogger(WebannoController.class);

    @Autowired
    ServletContext context;

    @Autowired
    WebannoService webannoService;

    @RequestMapping(value = "/webanno/done", method = RequestMethod.POST)
    public void done (ProjectStateChangeMessage projectStateChangeMessage) {
        webannoService.triggerRetrieval(projectStateChangeMessage.getProjectId(), projectStateChangeMessage.getProjectName());
    }


    @RequestMapping(value = "/webanno/create/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity create (@PathVariable("id") String id) {
        return new ResponseEntity(new WebannoProject(webannoService.moveToWebanno(id)),HttpStatus.OK);
    }
}
