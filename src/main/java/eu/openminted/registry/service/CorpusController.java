package eu.openminted.registry.service;

import eu.openminted.registry.core.service.ServiceException;
import eu.openminted.registry.domain.Corpus;
import eu.openminted.registry.exception.ResourceNotFoundException;
import eu.openminted.registry.exception.ServerError;
import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;
import java.util.Base64;
import java.util.List;

@RestController
@RequestMapping("/request/corpus")
public class CorpusController {

    @Autowired
    CorpusService corpusService;


    @RequestMapping(value = "{id}", method = RequestMethod.GET, produces = "application/json; charset=utf-8")
    public ResponseEntity<Corpus> getCorpus(@PathVariable("id") String id) {
        String id_decoded = new String(Base64.getDecoder().decode(id));
        Corpus component = corpusService.get(id_decoded);
        if(component == null)
            throw new ResourceNotFoundException();
        else
            return new ResponseEntity<>(component, HttpStatus.OK);

    }

    @RequestMapping(method = RequestMethod.POST, headers = "Accept=application/json; charset=utf-8")
    public ResponseEntity<String> addCorpus(@RequestBody Corpus corpus) {
        corpusService.add(corpus);
        return new ResponseEntity<>(HttpStatus.OK);
    }


    @RequestMapping(method = RequestMethod.POST, headers = "Accept=application/xml")
    public ResponseEntity<String> addCorpusXml(@RequestBody Corpus corpus) {

        corpusService.add(corpus);
        return new ResponseEntity<>(HttpStatus.OK);

    }

    @RequestMapping(method = RequestMethod.PUT, headers = "Accept=application/json")
    public ResponseEntity<String> updateCorpus(@RequestBody Corpus corpus) {

        corpusService.update(corpus);
        return new ResponseEntity<>(HttpStatus.OK);

    }

    @RequestMapping(method = RequestMethod.DELETE, headers = "Accept=application/json")
    public ResponseEntity<String> deleteCorpus(@RequestBody Corpus corpus) {

        corpusService.delete(corpus);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @RequestMapping(value = "all",method = RequestMethod.GET, headers = "charset=utf-8", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Corpus>> getAllCorpora() {
        return new ResponseEntity<>(corpusService.getAll(),HttpStatus.OK);
    }

    @PreAuthorize("isAuthenticated()")
    @RequestMapping(value = "my",method = RequestMethod.GET, headers = "charset=utf-8", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Corpus>> getMyCorpora() {
        return new ResponseEntity<>(corpusService.getMy(),HttpStatus.OK);
    }

    @RequestMapping(value = "upload", method = RequestMethod.POST)
    public ResponseEntity<String> uploadCorpus(@RequestParam("filename") String filename, @RequestParam("file") MultipartFile file) {

        try {
            return new ResponseEntity<>(corpusService.uploadCorpus(filename, file.getInputStream()), HttpStatus.OK);
        } catch (IOException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @RequestMapping(value = "download", method = RequestMethod.GET)
    @ResponseBody
    public void downloadCorpus(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String mimeType = "application/zip";
        String filename = request.getParameter("archiveId") + ".zip";
        response.setHeader("Content-Disposition", "attachment; filename=\""+ filename +"\"");
        response.setContentType(mimeType);
        IOUtils.copyLarge(corpusService.downloadCorpus(request.getParameter("archiveId")), response.getOutputStream());
    }
}