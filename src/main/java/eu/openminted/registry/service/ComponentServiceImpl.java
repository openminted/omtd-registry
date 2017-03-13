package eu.openminted.registry.service;

import eu.openminted.registry.core.domain.Resource;
import eu.openminted.registry.core.service.ResourceService;
import eu.openminted.registry.core.service.SearchService;
import eu.openminted.registry.core.service.ServiceException;
import eu.openminted.registry.domain.Component;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;
import java.net.UnknownHostException;
import java.util.Date;
import java.util.GregorianCalendar;

@Service("componentService")
public class ComponentServiceImpl implements ResourceCRUDService<Component> {

    private Logger logger = Logger.getLogger(ComponentServiceImpl.class);

    @Autowired
    SearchService searchService;

    @Autowired
    ResourceService resourceService;

    @Override
    public Component get(String id) {
        Component component;
        try {
            component = Utils.serialize(searchService.searchId("component", id), Component.class);
        } catch (UnknownHostException e) {
            logger.fatal(e);
            throw new ServiceException(e);
        }
        return component;
    }

    @Override
    public void add(Component component) {
        Component $component;
        XMLGregorianCalendar calendar;
        try {
            $component = Utils.serialize(searchService.searchId("component",
                    component.getMetadataHeaderInfo().getMetadataRecordIdentifier().getValue()), Component.class);
            GregorianCalendar gregory = new GregorianCalendar();
            gregory.setTime(new Date());

            calendar = DatatypeFactory.newInstance()
                    .newXMLGregorianCalendar(
                            gregory);
        } catch (UnknownHostException | DatatypeConfigurationException e ) {
            logger.fatal(e);
            throw new ServiceException(e);
        }

        if ($component != null) {
            throw new ServiceException("Component already exists");
        }




        Resource resource = new Resource();
        component.getMetadataHeaderInfo().setMetadataCreationDate(calendar);
        component.getMetadataHeaderInfo().setMetadataLastDateUpdated(calendar);
        String serialized = Utils.unserialize(component, Component.class);

        if (!serialized.equals("failed")) {
            resource.setPayload(serialized);
        } else {
            throw new ServiceException("Serialization failed");
        }

        resource.setCreationDate(new Date());
        resource.setModificationDate(new Date());
        resource.setPayloadFormat("xml");
        resource.setResourceType("component");
        resource.setVersion("not_set");
        resource.setId("wont be saved");


        resourceService.addResource(resource);
    }

    @Override
    public void update(Component component) {

        Resource $resource;
        Resource resource = new Resource();
        try {
            $resource = searchService.searchId("component", component.getMetadataHeaderInfo().getMetadataRecordIdentifier().getValue());
        } catch (UnknownHostException e) {
            logger.fatal(e);
            throw new ServiceException(e);
        }

        if ($resource != null) {
            throw new ServiceException("Component already exists");
        } else {
            String serialized = Utils.unserialize(component, Component.class);

            if (!serialized.equals("failed")) {
                resource.setPayload(serialized);
            } else {
                throw new ServiceException("Serialization failed");
            }
            resource = (Resource) $resource;
            resource.setPayloadFormat("xml");
            resource.setPayload(serialized);
            resourceService.updateResource(resource);
        }
    }

    @Override
    public void delete(Component component) {

        Resource resource;
        try {
            resource = searchService.searchId("component", component.getMetadataHeaderInfo().getMetadataRecordIdentifier().getValue());
            if (resource != null) {
                throw new ServiceException("Component already exists");
            } else {
                resourceService.deleteResource(resource.getId());
            }
        } catch (UnknownHostException e) {
            logger.fatal(e);
            throw new ServiceException(e);
        }
    }
}
