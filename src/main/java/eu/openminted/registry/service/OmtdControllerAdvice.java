package eu.openminted.registry.service;

import eu.openminted.registry.core.exception.ServerError;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.NoHandlerFoundException;

import javax.servlet.http.HttpServletRequest;

@ControllerAdvice
public class OmtdControllerAdvice {

    private Logger logger = LogManager.getLogger(OmtdControllerAdvice.class);

    @ResponseStatus(HttpStatus.FORBIDDEN)
    @ExceptionHandler(AccessDeniedException.class)
    @ResponseBody
    ServerError securityException(HttpServletRequest req, Exception ex) {
        return new ServerError(req.getRequestURL().toString(),ex);
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(NoHandlerFoundException.class)
    @ResponseBody
    ServerError handleBadHandler(HttpServletRequest req, Exception ex) {
        logger.info(ex);
        return new ServerError(req.getRequestURL().toString(),ex);
    }

}
