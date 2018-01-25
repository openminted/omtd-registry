package eu.openminted.registry.controllers.omtd;

import eu.openminted.registry.domain.Corpus;
import eu.openminted.registry.service.CorpusService;
import eu.openminted.registry.controllers.GenericRestController;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
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
@RequestMapping("/request/corpus")
@Api(value = "/request/corpus", description = "Operations about OMTD corpora.")
public class CorpusController extends OmtdRestController<Corpus> {

    final private CorpusService corpusService;

    @Autowired
    CorpusController(CorpusService service) {
        super(service);
        this.corpusService = service;
    }

    @ApiOperation(value = "Upload a corpus zip.")
    @RequestMapping(value = "upload", method = RequestMethod.POST)
    public ResponseEntity<String> uploadCorpus(@RequestParam("filename") String filename, @RequestParam("file") MultipartFile file) {

        try {
            return new ResponseEntity<>(corpusService.uploadCorpus(filename, file.getInputStream()), HttpStatus.OK);
        } catch (IOException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @ApiOperation(value = "Download a corpus zip.")
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