package eu.openminted.registry.service.util;

import eu.openminted.corpus.CorpusBuildingState;
import eu.openminted.registry.core.exception.ResourceNotFoundException;
import eu.openminted.registry.core.service.ResourceCRUDService;
import eu.openminted.registry.service.CorpusBuildingStatusService;
import eu.openminted.registry.service.GenericRestController;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/request/corpusbuildingstate")
@Api(value = "/request/corpusbuildingstate", description = "Operations about OMTD corpus building states.")
public class CorpusBuildingStateController extends GenericRestController<CorpusBuildingState> {

    @Autowired
    CorpusBuildingStateController(ResourceCRUDService<CorpusBuildingState> service) {
        super(service);
    }


    @ApiOperation(value = "Returns the corpus building states from all providers for a single corpus build.")
    @RequestMapping(value = "/aggregate/{id}", method = RequestMethod.GET, produces = "application/json; charset=utf-8")
    public ResponseEntity<List<CorpusBuildingState>> getAggregate(@PathVariable("id") String id) {
        String id_decoded = id; //new String(Base64.getDecoder().decode(id));
        List<CorpusBuildingState> component;
        component = ((CorpusBuildingStatusService) service).getAggregate(id_decoded);
        if (component == null)
            throw new ResourceNotFoundException();
        else
            return new ResponseEntity<>(component, HttpStatus.OK);

    }
}
