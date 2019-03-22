package eu.openminted.registry.service.omtd;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import eu.openminted.registry.core.domain.Browsing;
import eu.openminted.registry.core.domain.FacetFilter;
import eu.openminted.registry.core.domain.Resource;
import eu.openminted.registry.core.exception.ResourceNotFoundException;
import eu.openminted.registry.core.service.AbstractGenericService;
import eu.openminted.registry.core.service.ParserService;
import eu.openminted.registry.core.service.SearchService;
import eu.openminted.registry.core.service.ServiceException;
import eu.openminted.registry.core.validation.ResourceValidator;
import eu.openminted.registry.domain.BaseMetadataRecord;
import eu.openminted.registry.domain.ResourceIdentifier;
import eu.openminted.registry.domain.ResourceIdentifierSchemeNameEnum;
import eu.openminted.registry.service.ValidateInterface;
import eu.openminted.registry.service.generate.LabelGenerate;
import eu.openminted.registry.service.generate.MetadataHeaderInfoGenerate;
import eu.openminted.registry.utils.OMTDUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.mitre.openid.connect.model.OIDCAuthenticationToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.util.StringUtils;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;
import java.io.StringWriter;
import java.net.UnknownHostException;
import java.util.*;
import java.util.stream.Collectors;

/**
 * Created by stefanos on 30/6/2017.
 */
public abstract class OmtdGenericService<T extends BaseMetadataRecord> extends AbstractGenericService<T>
        implements ValidateInterface<T> {

    private static final String OMTD_ID = "omtdid";
    private static Logger logger = LogManager.getLogger(OmtdGenericService.class);
    @Autowired
    LabelGenerate labelGenerate;
    @Autowired
    private ResourceValidator resourceValidator;
    @Autowired
    private JAXBContext omtdJAXBContext;

    public OmtdGenericService(Class<T> typeParameterClass) {
        super(typeParameterClass);
    }

    @SuppressWarnings("unchecked")
    static Map deepMergeLocal(Map original, Map newMap) {
        Set merge = new HashSet();
        merge.addAll(original.keySet());
        merge.addAll(newMap.keySet());
        for (Object key : merge) {
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
    public T get(String id) {
        T resource;
        try {
            SearchService.KeyValue kv = new SearchService.KeyValue(OMTD_ID, id);
            Resource res = searchService.searchId(getResourceType(), kv);
            if (res == null) {
                return null;
            }
            resource = parserPool.deserialize(res, typeParameterClass);
        } catch (UnknownHostException e) {
            logger.fatal("get omtd generic", e);
            throw new ServiceException(e);
        }
        return resource;
    }

    static public FacetFilter convertFacetFilter(FacetFilter filter, String userInfo) {
        String query;
        String searchableArea = "";
        if(userInfo == null) {
            query = "public=true";
        } else if (!userInfo.equals("ROLE_ADMIN")) {
            query = "public=true or personIdentifier="+userInfo;
        } else {
            query = "*";
        }

        if(!StringUtils.isEmpty(filter.getKeyword())){
            searchableArea = "(searchableArea =\""+ filter.getKeyword()+"\")";
        }

        if(!"*".equals(query))
            query = "("+ query+")";
//        else
//            query = "";

        filter.getFilter().remove("resourceType");

        String filters ="(" + filter.getFilter().entrySet().stream().map((x) -> x.getKey() + "=\"" + x.getValue()+"\"").collect(Collectors.joining(" and ")) + ")";

        String finalQuery = "";
        if(!searchableArea.isEmpty())
            finalQuery = searchableArea.concat(" and ");

        finalQuery = finalQuery.concat(query);

        if(!"()".equals(filters))
            finalQuery = finalQuery.concat(" and " + filters);

        filter.setKeyword(finalQuery);
        return filter;
    }

    @Override
    public Browsing<T> getAll(FacetFilter filter, OIDCAuthenticationToken authentication) {
        filter.getFilter().keySet().retainAll(getBrowseBy());
        String query;
        Browsing<T> ret;
        String userInfo = null;
        if (authentication != null) {
            boolean hasAdminRole = authentication.getAuthorities().stream()
                    .anyMatch(r -> r.getAuthority().equals("ROLE_ADMIN"));
            if (hasAdminRole) {
                userInfo = "ROLE_ADMIN";
            } else {
                userInfo = authentication.getSub();
            }
        }
        filter = convertFacetFilter(filter,userInfo);
        filter.setResourceType(getResourceType());
        filter.setBrowseBy(getBrowseBy());
        ret = cqlQuery(filter);
        labelGenerate.createLabels(ret.getFacets());
        return ret;
    }

    @Override
    public Browsing<T> getMy(FacetFilter filter, OIDCAuthenticationToken auth) {
        if (auth == null) {
            throw new AccessDeniedException("Authentication Required");
        }
        filter.getFilter().keySet().retainAll(getBrowseBy());
        filter.addFilter("personIdentifier", auth.getSub());
        return getResults(filter);
    }

    @Override
    public T add(T resource, OIDCAuthenticationToken auth) {
        resource.setMetadataHeaderInfo(MetadataHeaderInfoGenerate.generate(resource.getMetadataHeaderInfo(),auth));
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
        identifiers.add(0, resourceIdentifier);

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

        String serialized = parserPool.serialize(resource, ParserService.ParserServiceTypes.XML);
        resourceDb.setCreationDate(new Date());
        resourceDb.setModificationDate(new Date());
        resourceDb.setPayloadFormat("xml");
        resourceDb.setResourceType(resourceType);
        resourceDb.setVersion("not_set");
        resourceDb.setId(insertionId);
        resourceDb.setPayload(serialized);
        resourceService.addResource(resourceDb);
        logger.info("Added new Resource with id " + insertionId);
        return resource;
    }

    @Override
    public T update(T newResource, OIDCAuthenticationToken auth) throws ResourceNotFoundException {
        Resource oldResource;
        SearchService.KeyValue kv = new SearchService.KeyValue(
                OMTD_ID,
                newResource.getMetadataHeaderInfo().getMetadataRecordIdentifier().getValue()
        );

        try {
            oldResource = searchService.searchId(getResourceType(), kv);
            Resource resource = new Resource();
            if (oldResource == null) {
                throw new ResourceNotFoundException(kv.getValue(), getResourceType());
            } else {
                GregorianCalendar gregory = new GregorianCalendar();
                gregory.setTime(new Date());
                XMLGregorianCalendar calendar;
                calendar = DatatypeFactory.newInstance().newXMLGregorianCalendar(gregory);
                newResource.getMetadataHeaderInfo().setMetadataLastDateUpdated(calendar);
                T old = parserPool.deserialize(oldResource, typeParameterClass);
                T insert = deepMerge(old, newResource);
                String serialized = parserPool.serialize(insert, ParserService.ParserServiceTypes.XML);

                if (!serialized.equals("failed")) {
                    resource.setPayload(serialized);
                } else {
                    throw new ServiceException("Serialization failed");
                }
                resource = oldResource;
                resource.setPayloadFormat("xml");
                resource.setPayload(serialized);
                resource.setResourceType(resourceType);
                resourceService.updateResource(resource);
                return insert;
            }
        } catch (UnknownHostException | DatatypeConfigurationException e) {
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

    private T deepMerge(T original_, T newMap_) {
        ObjectMapper mapper = new ObjectMapper();
//        mapper.configure(DeserializationFeature.ACCEPT_EMPTY_ARRAY_AS_NULL_OBJECT,false);
        mapper.setSerializationInclusion(JsonInclude.Include.NON_EMPTY);
        mapper.enable(SerializationFeature.INDENT_OUTPUT);
        Map original = mapper.convertValue(original_, Map.class);
        Map newMap = mapper.convertValue(newMap_, Map.class);
        deepMergeLocal(original, newMap);
        return mapper.convertValue(original, typeParameterClass);
    }

    @Override
    public Boolean validate(T resource) {
        String resource_;
        Resource resource1 = new Resource();

        resource_ = parserPool.serialize(resource, ParserService.ParserServiceTypes.XML);
        resource1.setPayload(resource_);
        resource1.setPayloadFormat("xml");
        resource1.setResourceType(resourceType);
        return resourceValidator.validateXML(resource1);
    }

    @Override
    public T deserialize(String resource) {
        Resource resource_ = new Resource();
        resource_.setPayload(resource);
        resource_.setPayloadFormat("xml");
        return parserPool.deserialize(resource_, typeParameterClass);
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

