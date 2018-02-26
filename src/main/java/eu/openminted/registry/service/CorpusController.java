package eu.openminted.registry.service;

import eu.openminted.registry.core.domain.Browsing;
import eu.openminted.registry.core.service.ResourceCRUDService;
import eu.openminted.registry.domain.Corpus;
import eu.openminted.registry.domain.PublicationInfo;
import org.apache.commons.io.IOUtils;
import org.hibernate.service.spi.ServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@RestController
@RequestMapping("/request/corpus")
public class CorpusController extends OmtdRestController<Corpus> {

    @Autowired
    private StoreService storeService;

    @Autowired
    private CorpusContentService corpusContentService;

    @Autowired
    @SuppressWarnings("unchecked")
    CorpusController(@Qualifier("corpusService") ResourceCRUDService<Corpus> service) {
        super((ValidateInterface<Corpus>) service);
    }

    @RequestMapping(value = "xmlUpload", method = RequestMethod.POST, consumes = {
            MediaType.APPLICATION_XML_VALUE,
            MediaType.APPLICATION_JSON_UTF8_VALUE
    })
    public ResponseEntity<Corpus> saveCorpusWithArchiveId(@RequestParam("archiveId") String archiveId, @RequestBody Corpus corpus) {
        corpus.getCorpusInfo().getDatasetDistributionInfo().setDistributionLocation(archiveId);
        service.add(corpus);
        return ResponseEntity.ok(corpus);
    }

    @RequestMapping(path = "getCorpusContent/{corpusId}", method = RequestMethod.GET, produces = {MediaType.APPLICATION_JSON_UTF8_VALUE})
    public Browsing<PublicationInfo> getCorpusContent(@PathVariable(value="corpusId") String corpusId,
                                                      @RequestParam(defaultValue = "0") int from,
                                                      @RequestParam(defaultValue = "1000") int size) {
        if(size < 0) throw new ServiceException("Size is negative");
        return corpusContentService.getCorpusContent(corpusId, from, size);
    }

    @RequestMapping(value = "upload", method = RequestMethod.POST)
    public ResponseEntity<String> uploadCorpus(@RequestParam("filename") String filename, @RequestParam("file") MultipartFile file) {

        try {
            return new ResponseEntity<>(storeService.uploadCorpus(filename, file.getInputStream()), HttpStatus.OK);
        } catch (IOException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @RequestMapping(value = "download", method = RequestMethod.GET)
    @ResponseBody
    public void downloadCorpus(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String mimeType = "application/zip";
        String filename = request.getParameter("archiveId") + ".zip";
        response.setHeader("Content-Disposition", "attachment; filename=\"" + filename + "\"");
        response.setContentType(mimeType);
        IOUtils.copyLarge(storeService.downloadCorpus(request.getParameter("archiveId")), response.getOutputStream());
    }
}