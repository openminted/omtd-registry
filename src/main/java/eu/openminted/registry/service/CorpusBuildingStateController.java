package eu.openminted.registry.service;

import eu.openminted.corpus.CorpusBuildingState;
import eu.openminted.registry.core.service.ResourceCRUDService;
import eu.openminted.registry.domain.Component;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/request/corpusbuildingstate")
public class CorpusBuildingStateController extends GenericRestController<CorpusBuildingState>{

    @Autowired
    CorpusBuildingStateController(ResourceCRUDService<CorpusBuildingState> service) {
        super(service);
    }



}
