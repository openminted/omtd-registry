package eu.openminted.registry.service.omtd;

import eu.openminted.registry.core.exception.ResourceNotFoundException;
import eu.openminted.registry.core.service.ServiceException;
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

    @Override
    public Component add(Component resource) {
        if(!resource.getComponentInfo().isApplication()){
            throw new ServiceException("Expected an application not a component");
        }
        return super.add(resource);
    }

    @Override
    public Component update(Component newResource) throws ResourceNotFoundException {
        if(!newResource.getComponentInfo().isApplication()){
            throw new ServiceException("Cannot update an application to a component");
        }
        return super.update(newResource);
    }

}
