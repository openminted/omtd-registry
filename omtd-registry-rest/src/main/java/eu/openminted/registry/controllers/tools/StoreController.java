package eu.openminted.registry.controllers.tools;

import eu.openminted.registry.domain.file.FileStats;
import eu.openminted.registry.service.StoreService;
import io.swagger.annotations.Api;
import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@RestController
@RequestMapping("/request/store")
@Api(description = "Upload and Download Files", tags="Store")
public class StoreController {

    @Autowired
    private StoreService storeService;


    @RequestMapping(value = "upload", method = RequestMethod.POST)
    @PreAuthorize("isAuthenticated()")
    public ResponseEntity<FileStats> uploadCorpus(@RequestParam("file") MultipartFile file) throws IOException {
        return new ResponseEntity<>(storeService.uploadAuxiliary(file.getName(), file.getInputStream()), HttpStatus.OK);
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