package eu.openminted.registry.service;

import eu.openminted.registry.domain.Corpus;
import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@RestController
@RequestMapping("/request/incompleteCorpus")
public class IncompleteCorpusController extends GenericRestController<Corpus>{

    final private IncompleteCorpusService corpusService;

    @Autowired
    IncompleteCorpusController(IncompleteCorpusService service) {
        super(service);
        this.corpusService = service;
    }
}