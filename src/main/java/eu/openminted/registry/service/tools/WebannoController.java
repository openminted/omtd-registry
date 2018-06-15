package eu.openminted.registry.service.tools;

import eu.openminted.registry.service.WebannoService;
import eu.openminted.registry.service.requests.ProjectStateChangeMessage;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
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
    public void done_POST (ProjectStateChangeMessage projectStateChangeMessage) {
        webannoService.triggerRetrieval(projectStateChangeMessage.getProjectId(), projectStateChangeMessage.getProjectName());
    }

}
