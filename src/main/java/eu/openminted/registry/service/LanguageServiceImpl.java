package eu.openminted.registry.service;

import eu.openminted.registry.core.domain.Resource;
import eu.openminted.registry.core.service.ResourceService;
import eu.openminted.registry.core.service.SearchService;
import eu.openminted.registry.core.service.ServiceException;
import eu.openminted.registry.domain.Language;
import eu.openminted.registry.domain.LanguageDescription;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;
import java.net.UnknownHostException;
import java.util.Date;
import java.util.GregorianCalendar;

/**
 * Created by stefanos on 13/1/2017.
 */
@Service("languageService")
public class LanguageServiceImpl implements ResourceCRUDService<LanguageDescription>{

    private Logger logger = Logger.getLogger(LanguageServiceImpl.class);
    private static String RESOURCE_TYPE = "language";

    @Autowired
    SearchService searchService;

    @Autowired
    ResourceService resourceService;

    @Override
    public LanguageDescription get(String id) {
        LanguageDescription resource;
        try {
            resource = Utils.serialize(searchService.searchId(RESOURCE_TYPE, id), LanguageDescription.class);
        } catch (UnknownHostException e) {
            logger.fatal(e);
            throw new ServiceException(e);
        }
        return resource;
    }

    @Override
    public void add(LanguageDescription language) {
        LanguageDescription $language;
        XMLGregorianCalendar calendar;
        try {
            $language = Utils.serialize(searchService.searchId(RESOURCE_TYPE,
                    language.getMetadataHeaderInfo().getMetadataRecordIdentifier().getValue()), LanguageDescription.class);
            GregorianCalendar gregory = new GregorianCalendar();
            gregory.setTime(new Date());

            calendar = DatatypeFactory.newInstance()
                    .newXMLGregorianCalendar(
                            gregory);
        } catch (UnknownHostException | DatatypeConfigurationException e) {
            logger.fatal(e);
            throw new ServiceException(e);
        }

        if ($language != null) {
            throw new ServiceException(RESOURCE_TYPE + " already exists");
        }

        Resource resource = new Resource();

        $language.getMetadataHeaderInfo().setMetadataCreationDate(calendar);
        $language.getMetadataHeaderInfo().setMetadataLastDateUpdated(calendar);

        String serialized = Utils.unserialize(language, LanguageDescription.class);

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
    public void update(LanguageDescription language) {
        Resource $resource;
        Resource resource = new Resource();
        try {
            $resource = searchService.searchId(RESOURCE_TYPE, language.getMetadataHeaderInfo().getMetadataRecordIdentifier().getValue());
        } catch (UnknownHostException e) {
            logger.fatal(e);
            throw new ServiceException(e);
        }

        if ($resource != null) {
            throw new ServiceException(RESOURCE_TYPE + " already exists");
        } else {
            String serialized = Utils.unserialize(language, LanguageDescription.class);

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
    public void delete(LanguageDescription language) {
        Resource resource;
        try {
            resource = searchService.searchId(RESOURCE_TYPE, language.getMetadataHeaderInfo().getMetadataRecordIdentifier().getValue());
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
