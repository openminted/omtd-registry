package eu.openminted.registry.service.omtd;

import eu.openminted.registry.core.domain.Browsing;
import eu.openminted.registry.domain.Corpus;
import eu.openminted.registry.domain.PublicationInfo;
import eu.openminted.registry.domain.ResourceIdentifier;
import eu.openminted.registry.domain.ResourceIdentifierSchemeNameEnum;
import eu.openminted.registry.service.CorpusContentService;
import eu.openminted.registry.service.CorpusService;
import eu.openminted.registry.service.StoreService;
import eu.openminted.registry.service.ValidateInterface;
import org.apache.commons.io.IOUtils;
import org.apache.tika.exception.TikaException;
import org.apache.tika.parser.ParseContext;
import org.apache.tika.sax.BodyContentHandler;
import org.apache.tika.metadata.Metadata;
import org.apache.tika.parser.AutoDetectParser;
import org.apache.tika.parser.Parser;
import org.hibernate.service.spi.ServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.xml.sax.ContentHandler;
import org.xml.sax.SAXException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.ws.Response;
import java.io.IOException;
import java.io.InputStream;
import java.util.Optional;

@RestController
@RequestMapping("/request/corpus")
public class CorpusController extends OmtdRestController<Corpus> {

    @Autowired
    private StoreService storeService;

    @Autowired
    private CorpusContentService corpusContentService;

    @Autowired
    @SuppressWarnings("unchecked")
    CorpusController(@Qualifier("corpusService") CorpusService service) {
        super((ValidateInterface<Corpus>) service);
    }

    @RequestMapping(value = "xmlUpload", method = RequestMethod.POST, consumes = {
            MediaType.APPLICATION_XML_VALUE,
            MediaType.APPLICATION_JSON_UTF8_VALUE
    })
    public ResponseEntity<Corpus> saveCorpusWithArchiveId(@RequestParam("archiveId") String archiveId, @RequestBody Corpus corpus) {
        Corpus corpusRet = ((CorpusService) service).uploadZip(corpus,archiveId);
        return ResponseEntity.ok(corpusRet);
    }

    @RequestMapping(value = "zipUpload", method = RequestMethod.POST, consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<Corpus> uploadCorpus(@RequestPart("file") MultipartFile file,
                                               @RequestPart("corpus") Corpus corpus) throws IOException {
        String archiveId = storeService.uploadCorpus(file.getName(), file.getInputStream());
        Corpus corpusRet = ((CorpusService) service).uploadZip(corpus,archiveId);
        return ResponseEntity.ok(corpusRet);
    }

    @RequestMapping(path = "getCorpusContent/{corpusId}", method = RequestMethod.GET, produces = {MediaType.APPLICATION_JSON_UTF8_VALUE})
    public Browsing<PublicationInfo> getCorpusContent(@PathVariable(value="corpusId") String corpusId,
                                                      @RequestParam(defaultValue = "0") int from,
                                                      @RequestParam(defaultValue = "0") int size) {
        if(size < 0) throw new ServiceException("Size is negative");
        if(from < 0) throw new ServiceException("From is negative");
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

    @RequestMapping(value = "download/{corpusID}", method = RequestMethod.GET)
    @ResponseBody
    public void download(@PathVariable("corpusID") String corpusId , HttpServletResponse response) throws IOException {
        Corpus corpus = service.get(corpusId);
        String mimeType = "application/zip";
        Optional<ResourceIdentifier> identifier = corpus.getCorpusInfo().getIdentificationInfo().getResourceIdentifiers()
                .stream()
                .filter(p->p.getResourceIdentifierSchemeName().equals(ResourceIdentifierSchemeNameEnum.OTHER) && "archiveID".equals(p.getSchemeURI()))
                .findFirst();
        if(!identifier.isPresent()) {
            throw new ServiceException("ArchiveID not found");
        }
        String filename = identifier.get().getValue() + ".zip";
        response.setHeader("Content-Disposition", "attachment; filename=\"" + filename + "\"");
        response.setContentType(mimeType);
        IOUtils.copyLarge(storeService.downloadCorpus(identifier.get().getValue()), response.getOutputStream());
    }

    @RequestMapping(value = "downloadFile", method = RequestMethod.GET)
    @ResponseBody
    public void downloadFile(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String filename = request.getParameter("path");

        InputStream is = storeService.downloadFile(filename);

        ContentHandler contenthandler = new BodyContentHandler();
        Metadata metadata = new Metadata();
        metadata.set(Metadata.RESOURCE_NAME_KEY, filename);
        Parser parser = new AutoDetectParser();
        ParseContext context = new ParseContext();

        try {
            parser.parse(is, contenthandler, metadata, context);
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (TikaException e) {
            e.printStackTrace();
        }

        response.setHeader("Content-Disposition", "attachment; filename=\"" + filename + "\"");
        response.setContentType(metadata.get(Metadata.CONTENT_TYPE));

        IOUtils.copy(storeService.downloadFile(filename), response.getOutputStream());
    }

    @RequestMapping(value = "showFile", method = RequestMethod.GET)
    @ResponseBody
    public void showFile(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String filename = request.getParameter("path");
        response.setHeader("Content-Disposition", "inline; filename=\"" + filename + "\"");
        IOUtils.copy(storeService.downloadFile(filename), response.getOutputStream());
    }

}