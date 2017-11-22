package eu.openminted.registry.service;

import eu.openminted.registry.domain.Component;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

@Service("applicationService")
@Primary
public class ApplicationServiceImpl extends OmtdGenericService<Component>{

    public ApplicationServiceImpl() {
        super(Component.class);
    }

    @Override
    public String getResourceType() {
        return "application";
    }

}
