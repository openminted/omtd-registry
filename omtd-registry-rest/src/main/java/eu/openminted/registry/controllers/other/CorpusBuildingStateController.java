package eu.openminted.registry.controllers.other;


import eu.openminted.registry.core.exception.ResourceNotFoundException;
import eu.openminted.registry.core.service.ResourceCRUDService;
import eu.openminted.registry.domain.connector.CorpusBuildingState;
import eu.openminted.registry.service.CorpusBuildingStatusService;
import io.swagger.annotations.Api;
import org.mitre.openid.connect.model.OIDCAuthenticationToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/request/corpusbuildingstate")
@Api(value = "/request/corpusbuildingstate", description = "Operations about OMTD corpus building states.", tags="Corpus Building State")
public class CorpusBuildingStateController extends OtherRestController<CorpusBuildingState> {

    @Autowired
    CorpusBuildingStateController(
            @Qualifier("corpusBuildingStateService")
                    ResourceCRUDService<CorpusBuildingState,OIDCAuthenticationToken> service) {
        super(service);
    }


    @RequestMapping(value = "/aggregate/{id}", method = RequestMethod.GET, produces = "application/json; charset=utf-8")
    public ResponseEntity<List<CorpusBuildingState>> getAggregate(@PathVariable("id") String id) throws ResourceNotFoundException {
        String id_decoded = id; //new String(Base64.getDecoder().decode(id));
        List<CorpusBuildingState> component;
        component = ((CorpusBuildingStatusService) service).getAggregate(id_decoded);
        if (component == null)
            throw new ResourceNotFoundException();
        else
            return new ResponseEntity<>(component, HttpStatus.OK);

    }
}
