package eu.openminted.registry.service;

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

}
