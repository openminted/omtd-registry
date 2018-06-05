package eu.openminted.registry.controllers.omtd;

import eu.openminted.registry.domain.Lexical;
import eu.openminted.registry.service.AncillaryService;
import eu.openminted.registry.service.StoreService;
import eu.openminted.registry.service.ValidateInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

/**
 * Created by stefanos on 13/1/2017.
 */
@RestController
@RequestMapping("/request/lexical")
public class LexicalController extends OmtdRestController<Lexical> {

    @Autowired
    LexicalController(ValidateInterface<Lexical> service) {
        super(service);
    }

    @Autowired
    private StoreService storeService;

    @RequestMapping(value = "zipUpload", method = RequestMethod.POST, consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<Lexical> uploadCorpus(@RequestPart("file") MultipartFile file,
                                                            @RequestPart("lexical") Lexical lexical) throws IOException {
        String archiveId = storeService.uploadCorpus(file.getName(), file.getInputStream());
        Lexical corpusRet = ((AncillaryService<Lexical>) service).uploadZip(lexical,archiveId);
        return ResponseEntity.ok(corpusRet);
    }
} 
