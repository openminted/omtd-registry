package eu.openminted.registry.service;

import eu.openminted.registry.core.domain.Browsing;
import eu.openminted.registry.core.domain.FacetFilter;
import eu.openminted.registry.core.domain.Resource;
import eu.openminted.registry.core.service.*;
import eu.openminted.registry.domain.BaseMetadataRecord;
import eu.openminted.registry.generate.MetadataHeaderInfoGenerate;
import org.apache.log4j.Logger;
import org.mitre.openid.connect.model.OIDCAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;

import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;
import java.net.UnknownHostException;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

/**
 * Created by stefanos on 30/6/2017.
 */
public abstract class OmtdGenericService<T extends BaseMetadataRecord> extends AbstractGenericService<T> implements ResourceCRUDService<T> {

    private Logger logger = Logger.getLogger(OmtdGenericService.class);

    private static final String OMTD_ID = "omtdid";

    public OmtdGenericService(Class<T> typeParameterClass) {
        super(typeParameterClass);
    }

    @Override
    public T get(String id) {
        T resource;
        try {
            SearchService.KeyValue kv = new SearchService.KeyValue(OMTD_ID,id);
            resource = parserPool.serialize(searchService.searchId(getResourceType(), kv),typeParameterClass).get();
        } catch (UnknownHostException | ExecutionException | InterruptedException e) {
            logger.fatal("get omtd generic", e);
            throw new ServiceException(e);
        }
        return resource;
    }

    @Override
    public Browsing getAll(FacetFilter filter) {
        filter.addFilter("public",true);
        filter.setBrowseBy(getBrowseBy());
        return getResults(filter);
    }

    @Override
    public Browsing getMy(FacetFilter filter) {
        OIDCAuthenticationToken authentication = (OIDCAuthenticationToken) SecurityContextHolder.getContext().getAuthentication();
        filter.addFilter("personIdentifier",authentication.getSub());
        return getResults(filter);
    }

    @Override
    public void add(T resource) {
        if(resource.getMetadataHeaderInfo() == null) {
            logger.info("Auto-generate metadata header info for " + getResourceType());
            resource.setMetadataHeaderInfo(MetadataHeaderInfoGenerate.generate());
        } else {
            try {
                GregorianCalendar gregory = new GregorianCalendar();
                gregory.setTime(new Date());
                XMLGregorianCalendar calendar;
                calendar = DatatypeFactory.newInstance().newXMLGregorianCalendar(gregory);
                resource.getMetadataHeaderInfo().setMetadataCreationDate(calendar);
                resource.getMetadataHeaderInfo().setMetadataLastDateUpdated(calendar);
            } catch(DatatypeConfigurationException e) {
                throw new ServiceException(e);
            }
        }

        String insertionId = resource.getMetadataHeaderInfo().getMetadataRecordIdentifier().getValue();
        Resource checkResource;
        try {
            //Check existence if resource
            SearchService.KeyValue kv = new SearchService.KeyValue(OMTD_ID,insertionId);
            checkResource = searchService.searchId(getResourceType(), kv);
        } catch (UnknownHostException e ) {
            logger.fatal(e);
            throw new ServiceException(e);
        }

        if (checkResource != null) {
            throw new ServiceException(String.format("%s with id [%s] already exists",getResourceType(),insertionId));
        }

        Resource resourceDb = new Resource();


        Future<String> serialized = parserPool.deserialize(resource, ParserService.ParserServiceTypes.XML);
        try {
            resourceDb.setCreationDate(new Date());
            resourceDb.setModificationDate(new Date());
            resourceDb.setPayloadFormat("xml");
            resourceDb.setResourceType(getResourceType());
            resourceDb.setVersion("not_set");
            resourceDb.setId(insertionId);
            resourceDb.setPayload(serialized.get());
        } catch (InterruptedException | ExecutionException e) {
            throw new ServiceException(e);
        }
        resourceService.addResource(resourceDb);
    }

    @Override
    public void update(T resources) {
        Resource $resource;
        SearchService.KeyValue kv = new SearchService.KeyValue(
                OMTD_ID,
                resources.getMetadataHeaderInfo().getMetadataRecordIdentifier().getValue()
        );

        try {
            $resource = searchService.searchId(getResourceType(), kv);
            Resource resource = new Resource();
            if ($resource == null) {
                throw new ServiceException(getResourceType() + " does not exists");
            } else {
                GregorianCalendar gregory = new GregorianCalendar();
                gregory.setTime(new Date());
                XMLGregorianCalendar calendar;
                calendar = DatatypeFactory.newInstance().newXMLGregorianCalendar(gregory);
                resources.getMetadataHeaderInfo().setMetadataLastDateUpdated(calendar);
                String serialized = parserPool.deserialize(resources, ParserService.ParserServiceTypes.XML).get();

                if (!serialized.equals("failed")) {
                    resource.setPayload(serialized);
                } else {
                    throw new ServiceException("Serialization failed");
                }
                resource = $resource;
                resource.setPayloadFormat("xml");
                resource.setPayload(serialized);
                resourceService.updateResource(resource);
            }
        } catch (UnknownHostException | ExecutionException | InterruptedException | DatatypeConfigurationException e) {
            logger.fatal(e);
            throw new ServiceException(e);
        }
    }

    @Override
    public void delete(T component) {
        Resource resource;
        try {
            SearchService.KeyValue kv = new SearchService.KeyValue(
                    OMTD_ID,
                    component.getMetadataHeaderInfo().getMetadataRecordIdentifier().getValue()
            );
            resource = searchService.searchId(getResourceType(), kv);
            if (resource == null) {
                throw new ServiceException(getResourceType() + " does not exists");
            } else {
                resourceService.deleteResource(resource.getId());
            }
        } catch (UnknownHostException e) {
            logger.fatal(e);
            throw new ServiceException(e);
        }
    }
}
