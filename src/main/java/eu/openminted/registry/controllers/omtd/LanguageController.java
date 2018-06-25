package eu.openminted.registry.controllers.omtd;

import eu.openminted.registry.domain.LanguageDescription;
import eu.openminted.registry.service.AncillaryService;
import eu.openminted.registry.controllers.GenericRestController;
import eu.openminted.registry.service.StoreService;
import eu.openminted.registry.service.ValidateInterface;
import io.swagger.annotations.Api;
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
@RequestMapping("/request/language")
@Api(value = "/request/language", description = "Operations about OMTD Models and Grammars.",tags="Models and Grammars")
public class LanguageController extends GenericRestController<LanguageDescription> {

    @Autowired
    LanguageController(ValidateInterface<LanguageDescription> service) {
        super(service);
    }

    @Autowired
    private StoreService storeService;

    @RequestMapping(value = "zipUpload", method = RequestMethod.POST, consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<LanguageDescription> uploadCorpus(@RequestPart("file") MultipartFile file,
                                               @RequestPart("language") LanguageDescription language) throws IOException {
        String archiveId = storeService.uploadCorpus(file.getName(), file.getInputStream());
        LanguageDescription corpusRet = ((AncillaryService<LanguageDescription>) service).uploadZip(language,archiveId);
        return ResponseEntity.ok(corpusRet);
    }
} 
