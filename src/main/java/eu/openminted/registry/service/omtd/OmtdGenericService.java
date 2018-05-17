package eu.openminted.registry.service.omtd;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import eu.openminted.registry.core.domain.Browsing;
import eu.openminted.registry.core.domain.FacetFilter;
import eu.openminted.registry.core.domain.Resource;
import eu.openminted.registry.core.exception.ResourceNotFoundException;
import eu.openminted.registry.core.service.ParserService;
import eu.openminted.registry.core.service.SearchService;
import eu.openminted.registry.core.service.ServiceException;
import eu.openminted.registry.core.validation.ResourceValidator;
import eu.openminted.registry.domain.BaseMetadataRecord;
import eu.openminted.registry.domain.ResourceIdentifier;
import eu.openminted.registry.domain.ResourceIdentifierSchemeNameEnum;
import eu.openminted.registry.generate.LabelGenerate;
import eu.openminted.registry.generate.MetadataHeaderInfoGenerate;
import eu.openminted.registry.service.ValidateInterface;
import eu.openminted.registry.service.hotfix.AbstractPublicUsersGenericService;
import eu.openminted.registry.utils.OMTDUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.mitre.openid.connect.model.OIDCAuthenticationToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;
import java.io.StringWriter;
import java.net.UnknownHostException;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

/**
 * Created by stefanos on 30/6/2017.
 */
public abstract class OmtdGenericService<T extends BaseMetadataRecord> extends AbstractPublicUsersGenericService<T> implements ValidateInterface<T> {

    private static Logger logger = LogManager.getLogger(OmtdGenericService.class);

    private static final String OMTD_ID = "omtdid";

    @Autowired
    private ResourceValidator resourceValidator;

    @Autowired
    LabelGenerate labelGenerate;

    @Autowired
    private JAXBContext omtdJAXBContext;

    public OmtdGenericService(Class<T> typeParameterClass) {
        super(typeParameterClass);
    }

    @Override
    public T get(String id) {
        T resource;
        try {
        	SearchService.KeyValue kv = new SearchService.KeyValue(OMTD_ID, id);            	
            Resource res = searchService.searchId(getResourceType(), kv);            
            if(res==null) {           
                return null;
            }
            resource = parserPool.deserialize(res, typeParameterClass).get();
        } catch (UnknownHostException | ExecutionException | InterruptedException e) {
            logger.fatal("get omtd generic", e);
            throw new ServiceException(e);
        }
        return resource;
    }

    @Override
    public Browsing getAll(FacetFilter filter) {
        filter.getFilter().keySet().retainAll(getBrowseBy());
        Browsing ret;
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication instanceof OIDCAuthenticationToken) {
            ret = getResponseByFiltersAndUserElastic(filter,((OIDCAuthenticationToken) authentication).getSub());
        } else {
            filter.setBrowseBy(getBrowseBy());
            filter.addFilter("public",true);
            ret = getResults(filter);
        }
        labelGenerate.createLabels(ret);
        return ret;
    }

    @Override
    public Browsing getMy(FacetFilter filter) {
        OIDCAuthenticationToken authentication = (OIDCAuthenticationToken) SecurityContextHolder.getContext().getAuthentication();
        filter.addFilter("personIdentifier", authentication.getSub());
        return getResults(filter);
    }

    @Override
    public T add(T resource) {
        resource.setMetadataHeaderInfo(MetadataHeaderInfoGenerate.generate(resource.getMetadataHeaderInfo()));
        try {
            GregorianCalendar gregory = new GregorianCalendar();
            gregory.setTime(new Date());
            XMLGregorianCalendar calendar;
            calendar = DatatypeFactory.newInstance().newXMLGregorianCalendar(gregory);
            resource.getMetadataHeaderInfo().setMetadataCreationDate(calendar);
            resource.getMetadataHeaderInfo().setMetadataLastDateUpdated(calendar);
        } catch (DatatypeConfigurationException e) {
            throw new ServiceException(e);
        }
        String insertionId = resource.getMetadataHeaderInfo().getMetadataRecordIdentifier().getValue();
        List<ResourceIdentifier> identifiers = OMTDUtils.resolveIdentificationInfo(resource).getResourceIdentifiers();
        identifiers.removeIf(p -> p.getResourceIdentifierSchemeName().equals(ResourceIdentifierSchemeNameEnum.OMTD));
        ResourceIdentifier resourceIdentifier = new ResourceIdentifier();
        resourceIdentifier.setValue(insertionId);
        resourceIdentifier.setResourceIdentifierSchemeName(ResourceIdentifierSchemeNameEnum.OMTD);
        identifiers.add(0,resourceIdentifier);

        Resource checkResource;

        try {
            //Check existence if resource
            SearchService.KeyValue kv = new SearchService.KeyValue(OMTD_ID, insertionId);
            checkResource = searchService.searchId(getResourceType(), kv);
        } catch (UnknownHostException e) {
            logger.fatal(e);
            throw new ServiceException(e);
        }

        if (checkResource != null) {
            throw new ServiceException(String.format("%s with id [%s] already exists", getResourceType(), insertionId));
        }

        Resource resourceDb = new Resource();


        Future<String> serialized = parserPool.serialize(resource, ParserService.ParserServiceTypes.XML);
        try {
            resourceDb.setCreationDate(new Date());
            resourceDb.setModificationDate(new Date());
            resourceDb.setPayloadFormat("xml");
            resourceDb.setResourceType(resourceType);
            resourceDb.setVersion("not_set");
            resourceDb.setId(insertionId);
            resourceDb.setPayload(serialized.get());
            resourceService.addResource(resourceDb);
            logger.info("Added new Resource with id " + insertionId);
        } catch (InterruptedException | ExecutionException e) {
            throw new ServiceException(e);
        }
        return resource;
    }

    @Override
    public T update(T newResource) throws ResourceNotFoundException {
        Resource oldResource;
        SearchService.KeyValue kv = new SearchService.KeyValue(
                OMTD_ID,
                newResource.getMetadataHeaderInfo().getMetadataRecordIdentifier().getValue()
        );

        try {
            oldResource = searchService.searchId(getResourceType(), kv);
            Resource resource = new Resource();
            if (oldResource == null) {
                throw new ResourceNotFoundException(kv.getValue(),getResourceType());
            } else {
                GregorianCalendar gregory = new GregorianCalendar();
                gregory.setTime(new Date());
                XMLGregorianCalendar calendar;
                calendar = DatatypeFactory.newInstance().newXMLGregorianCalendar(gregory);
                newResource.getMetadataHeaderInfo().setMetadataLastDateUpdated(calendar);
                T old = parserPool.deserialize(oldResource, typeParameterClass).get();
                T insert = deepMerge(old, newResource);
                String serialized = parserPool.serialize(insert, ParserService.ParserServiceTypes.XML).get();

                if (!serialized.equals("failed")) {
                    resource.setPayload(serialized);
                } else {
                    throw new ServiceException("Serialization failed");
                }
                resource = oldResource;
                resource.setPayloadFormat("xml");
                resource.setPayload(serialized);
                resourceService.updateResource(resource);
                return insert;
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

    public T deepMerge(T original_, T newMap_) {
        ObjectMapper mapper = new ObjectMapper();
//        mapper.configure(DeserializationFeature.ACCEPT_EMPTY_ARRAY_AS_NULL_OBJECT,false);
        mapper.setSerializationInclusion(JsonInclude.Include.NON_EMPTY);
        mapper.enable(SerializationFeature.INDENT_OUTPUT);
        Map original = mapper.convertValue(original_, Map.class);
        Map newMap = mapper.convertValue(newMap_, Map.class);
        deepMergeLocal(original, newMap);
        return mapper.convertValue(original, typeParameterClass);
    }

    static Map deepMergeLocal(Map original, Map newMap) {
        for (Object key : newMap.keySet()) {
            if (newMap.get(key) instanceof Map && original.get(key) instanceof Map) {
                Map originalChild = (Map) original.get(key);
                Map newChild = (Map) newMap.get(key);
                original.put(key, deepMergeLocal(originalChild, newChild));
            } else if (newMap.get(key) instanceof List && original.get(key) instanceof List) {
                if (((List) original.get(key)).isEmpty()) {
                    logger.trace("Removed list " + key);
                    original.put(key, null);
                } else {
                    original.put(key, newMap.get(key));
                }
            } else {
                original.put(key, newMap.get(key));
            }
        }
        return original;
    }

    @Override
    public Boolean validate(T resource) {
        String resource_;
        try {
            resource_ = parserPool.serialize(resource, ParserService.ParserServiceTypes.XML).get();
        } catch (InterruptedException | ExecutionException e) {
            throw new ServiceException(e);
        }
        return resourceValidator.validateXML(getResourceType(),resource_);
    }

    @Override
    public T deserialize(String resource) {
        Resource resource_ = new Resource();
        resource_.setPayload(resource);
        resource_.setPayloadFormat("xml");
        T ret;
        try {
            ret = parserPool.deserialize(resource_, typeParameterClass).get();
        } catch (InterruptedException | ExecutionException e) {
            throw new ServiceException(e);
        }
        return ret;
    }

    @Override
    public String serialize(T resource) {
        StringWriter writer = new StringWriter();
        try {
            Marshaller marshaller = omtdJAXBContext.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
            marshaller.marshal(resource, writer);
        } catch (JAXBException e) {
            throw new ServiceException(e);
        }
        return writer.toString();
    }
}
