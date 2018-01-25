package eu.openminted.registry.controllers.util;

import eu.openminted.registry.domain.MavenComponent;
import eu.openminted.registry.service.MavenResolverService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class MavenResolverController {

    @Autowired
    private MavenResolverService mavenResolverService;

    @ApiOperation(value = "Returns the components found inside a maven jar.")
    @RequestMapping(value = "request/maven", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<List<MavenComponent>> getComponents(
            @RequestParam("groupID") String groupID,
            @RequestParam("artifactID") String artifactID,
            @RequestParam("version") String version) {
        return ResponseEntity.ok(mavenResolverService.resolveCoordinates(groupID, artifactID, version));
    }
}