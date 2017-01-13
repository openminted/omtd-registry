package eu.openminted.registry.service;

import eu.openminted.registry.core.domain.Resource;
import eu.openminted.registry.core.service.ResourceService;
import eu.openminted.registry.core.service.SearchService;
import eu.openminted.registry.core.service.ServiceException;
import eu.openminted.registry.domain.Model;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.net.UnknownHostException;
import java.util.Date;

/**
 * Created by stefanos on 13/1/2017.
 */
@Service("modelService")
public class ModelServiceImpl implements ResourceCRUDService<Model>{

    private Logger logger = Logger.getLogger(ModelServiceImpl.class);
    private static String RESOURCE_TYPE = "model";

    @Autowired
    SearchService searchService;

    @Autowired
    ResourceService resourceService;

    @Override
    public Model get(String id) {
        Model resource;
        try {
            resource = Utils.serialize(searchService.searchId(RESOURCE_TYPE, id), Model.class);
        } catch (UnknownHostException e) {
            logger.fatal(e);
            throw new ServiceException(e);
        }
        return resource;
    }

    @Override
    public void add(Model model) {
        Model $model;
        try {
            $model = Utils.serialize(searchService.searchId(RESOURCE_TYPE,
                    model.getMetadataHeaderInfo().getMetadataRecordIdentifier().getValue()), Model.class);
        } catch (UnknownHostException e) {
            logger.fatal(e);
            throw new ServiceException(e);
        }

        if ($model != null) {
            throw new ServiceException(RESOURCE_TYPE + " already exists");
        }

        Resource resource = new Resource();

        String serialized = Utils.unserialize(model, Model.class);

        if (!serialized.equals("failed")) {
            resource.setPayload(serialized);
        } else {
            throw new ServiceException("Serialization failed");
        }

        resource.setCreationDate(new Date());
        resource.setModificationDate(new Date());
        resource.setPayloadFormat("xml");
        resource.setResourceType(RESOURCE_TYPE);
        resource.setVersion("not_set");
        resource.setId("wont be saved");


        resourceService.addResource(resource);
    }

    @Override
    public void update(Model model) {
        Resource $resource;
        Resource resource = new Resource();
        try {
            $resource = searchService.searchId(RESOURCE_TYPE, model.getMetadataHeaderInfo().getMetadataRecordIdentifier().getValue());
        } catch (UnknownHostException e) {
            logger.fatal(e);
            throw new ServiceException(e);
        }

        if ($resource != null) {
            throw new ServiceException(RESOURCE_TYPE + " already exists");
        } else {
            String serialized = Utils.unserialize(model, Model.class);

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
    public void delete(Model model) {
        Resource resource;
        try {
            resource = searchService.searchId(RESOURCE_TYPE, model.getMetadataHeaderInfo().getMetadataRecordIdentifier().getValue());
            if (resource != null) {
                throw new ServiceException(RESOURCE_TYPE + " already exists");
            } else {
                resourceService.deleteResource(resource.getId());
            }
        } catch (UnknownHostException e) {
            logger.fatal(e);
            throw new ServiceException(e);
        }
    }
}
