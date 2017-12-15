package eu.openminted.registry.service;

import eu.openminted.registry.core.service.ServiceException;
import eu.openminted.registry.domain.Component;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service("componentService")
@Primary
public class ComponentServiceImpl extends OmtdGenericService<Component>{

    public ComponentServiceImpl() {
        super(Component.class);
    }

    @Override
    public String getResourceType() {
        return "component";
    }

    @Override
    public void add(Component resource) {
        if(resource.getComponentInfo().isApplication()){
            throw new ServiceException("Expected a component not an application");
        }
        super.add(resource);
    }

    @Override
    public void update(Component newResource) {
        if(newResource.getComponentInfo().isApplication()){
            throw new ServiceException("Cannot update a component to an application");
        }
        super.update(newResource);
    }
}
