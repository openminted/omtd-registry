package eu.openminted.registry.service.omtd;

import eu.openminted.registry.core.exception.ResourceNotFoundException;
import eu.openminted.registry.core.service.ServiceException;
import eu.openminted.registry.domain.Component;
import org.mitre.openid.connect.model.OIDCAuthenticationToken;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

@Service("componentService")
@Primary
public class ComponentServiceImpl extends OmtdGenericService<Component> {

    public ComponentServiceImpl() {
        super(Component.class);
    }

    @Override
    public String getResourceType() {
        return "component";
    }

    @Override
    public Component add(Component resource, OIDCAuthenticationToken auth) {
        if (resource.getComponentInfo().isApplication()) {
            throw new ServiceException("Expected a component not an application");
        }
        return super.add(resource,auth);
    }

    @Override
    public Component update(Component newResource, OIDCAuthenticationToken auth) throws ResourceNotFoundException {
        if (newResource.getComponentInfo().isApplication()) {
            throw new ServiceException("Cannot update a component to an application");
        }
        return super.update(newResource,auth);
    }

    @Override
    public void delete(Component component) {
        super.delete(component);
    }
}
