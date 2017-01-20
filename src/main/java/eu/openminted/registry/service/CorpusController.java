package eu.openminted.registry.service;

import eu.openminted.registry.domain.Corpus;
import eu.openminted.registry.exception.ResourceNotFoundException;
import eu.openminted.registry.exception.ServerError;
import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;

@RestController
@RequestMapping("/request/corpus")
public class CorpusController {

    @Autowired
        CorpusService corpusService;

    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(ResourceNotFoundException.class)
    @ResponseBody
    ServerError handleBadRequest(HttpServletRequest req, Exception ex) {
        return new ServerError(req.getRequestURL().toString(), ex);
    }

    @RequestMapping(value = "{id}", method = RequestMethod.GET, produces = "application/json; charset=utf-8")
    public ResponseEntity<Corpus> getCorpus(@PathVariable("id") String id) {
        Corpus component = corpusService.get(id);
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

    @RequestMapping(value = "upload", method = RequestMethod.POST)
    public ResponseEntity<String> uploadCorpus(@RequestParam("filename") String filename, @RequestParam("file") MultipartFile file) {

        try {
            return new ResponseEntity<String>(corpusService.uploadCorpus(filename, file.getInputStream()), HttpStatus.OK);
        } catch (IOException e) {
            return new ResponseEntity<String>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @RequestMapping(value = "download", method = RequestMethod.GET)
    @ResponseBody
    public void downloadCorpus(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String mimeType = "application/octet-stream";

        response.setContentType(mimeType);
        IOUtils.copyLarge(corpusService.downloadCorpus(request.getParameter("archiveId")), response.getOutputStream());
    }
}