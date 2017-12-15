package eu.openminted.registry.service;

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
    public void add(Component resource) {
        if(!resource.getComponentInfo().isApplication()){
            throw new ServiceException("Expected an application not a component");
        }
        super.add(resource);
    }

    @Override
    public void update(Component newResource) {
        if(!newResource.getComponentInfo().isApplication()){
            throw new ServiceException("Cannot update an application to a component");
        }
        super.update(newResource);
    }

}
