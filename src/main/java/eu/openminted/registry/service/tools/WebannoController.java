package eu.openminted.registry.service.tools;

import eu.openminted.registry.service.WebannoService;
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

    @RequestMapping(value = "/webanno/done", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity done_GET() {
            logger.info("Hello there!");
            return new ResponseEntity<>("hello",HttpStatus.OK);

    }

    @RequestMapping(value = "/webanno/done", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity done_POST (    HttpServletRequest request,
	          			 HttpServletResponse response) {
	   logger.info(request.toString());
           logger.info("Hello there from POST!");
           return new ResponseEntity<>("hello",HttpStatus.OK);
    }


}
