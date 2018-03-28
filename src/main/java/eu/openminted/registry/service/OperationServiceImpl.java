package eu.openminted.registry.service;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.util.ISO8601DateFormat;
import eu.openminted.registry.beans.WorkflowConfig;
import eu.openminted.registry.core.domain.Browsing;
import eu.openminted.registry.core.domain.FacetFilter;
import eu.openminted.registry.core.domain.Resource;
import eu.openminted.registry.core.service.AbstractGenericService;
import eu.openminted.registry.core.service.ResourceCRUDService;
import eu.openminted.registry.core.service.SearchService;
import eu.openminted.registry.core.service.ServiceException;
import eu.openminted.registry.domain.*;
import eu.openminted.registry.domain.operation.Operation;
import eu.openminted.workflow.api.ExecutionStatus;
import org.apache.http.client.utils.URIBuilder;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.mitre.openid.connect.model.OIDCAuthenticationToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.net.URL;
import java.net.UnknownHostException;
import java.util.*;
import java.util.Date;
import java.util.concurrent.ExecutionException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by stefanos on 30/6/2017.
 */
@Service("operationService")
@Primary
public class OperationServiceImpl extends AbstractGenericService<Operation> implements OperationService {

    private static final String OPERATION_ID = "operation_id";
    private static final String OMTD_ID = "omtdid";

    private Logger logger = LogManager.getLogger(OperationServiceImpl.class);

    private ObjectMapper mapper;

    @Autowired
    private WorkflowConfig workflowConfig;

    @Autowired
    @Qualifier("workflowRestTemplate")
    private RestTemplate workflowRestTemplate;

    @Autowired
    @Qualifier("applicationService")
    private ResourceCRUDService<Component> applicationResolver;

    @Autowired
    @Qualifier("corpusService")
    private ResourceCRUDService<Corpus> corpusResolver;

    public OperationServiceImpl() {
        super(Operation.class);
        mapper = new ObjectMapper();
        mapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
        mapper.setDateFormat(new ISO8601DateFormat());
    }

    @Override
    public Operation get(String id) {
        Operation operation;
        logger.debug("Getting operation with id " + id);
        try {
            SearchService.KeyValue kv = new SearchService.KeyValue(OPERATION_ID, id);
            operation = parserPool.deserialize(searchService.searchId(getResourceType(), kv), typeParameterClass).get();
        } catch (UnknownHostException | ExecutionException | InterruptedException e) {
            logger.fatal("operation get fatal error", e);
            throw new ServiceException(e);
        }
        return operation;
    }

    @Override
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public Browsing getAll(FacetFilter filter) {
        filter.setBrowseBy(getBrowseBy());
        Browsing browsing = getResults(filter);
        return applicationJoinForOperations(browsing);
    }

    @Override
    public Browsing getMy(FacetFilter filter) {
        OIDCAuthenticationToken authentication = (OIDCAuthenticationToken) SecurityContextHolder.getContext().getAuthentication();
        filter.addFilter("personIdentifier", authentication.getSub());
        Browsing browsing = getResults(filter);
        return applicationJoinForOperations(browsing);
    }

    @Override
    public Operation add(Operation operation) {

        Resource resourceDb = new Resource();
        try {
            String serialized = mapper.writeValueAsString(operation);
            resourceDb.setPayloadFormat("json");
            resourceDb.setResourceType(resourceType);
            resourceDb.setVersion("not_set");
            resourceDb.setId(operation.getId());
            resourceDb.setPayload(serialized);
            resourceService.addResource(resourceDb);
            return operation;
        } catch (JsonProcessingException e) {
            logger.info("add operation", e);
            throw new ServiceException(e);
        }
    }

    @Override
    public Operation update(Operation operation) {

        Resource resourceDb;
        SearchService.KeyValue kv = new SearchService.KeyValue(
                OPERATION_ID,
                operation.getId()
        );
        try {
            resourceDb = searchService.searchId(getResourceType(), kv);
            if (resourceDb == null) {
                throw new ServiceException(getResourceType() + " with key " + kv.toString() + " does not exists");
            } else {
                String serialized = mapper.writeValueAsString(operation);
                resourceDb.setPayload(serialized);
                resourceDb.setPayloadFormat("json");
                resourceDb.setPayload(serialized);
                resourceService.updateResource(resourceDb);
                return operation;
            }
        } catch (IOException e) { //| ExecutionException | InterruptedException   e) { //| | JsonProcessingException | UnknownHostException  |
            logger.fatal("operation update fatal error", e);
            throw new ServiceException(e);
        }
    }

    @Override
    public void delete(Operation operation) {
        Resource resourceDb;
        try {
            SearchService.KeyValue kv = new SearchService.KeyValue(
                    OPERATION_ID,
                    operation.getId()
            );
            resourceDb = searchService.searchId(getResourceType(), kv);
            if (resourceDb == null) {
                throw new ServiceException(getResourceType() + " does not exists");
            } else {
                resourceService.deleteResource(operation.getId());
            }
        } catch (UnknownHostException e) {
            logger.fatal(e);
            throw new ServiceException(e);
        }
    }

    @Override
    public String getResourceType() {
        return "operation";
    }

    private Browsing<FatOperations> applicationJoinForOperations(Browsing<Operation> browsing) {
        List<FatOperations> operations = new ArrayList<>();
        for (Operation operation : browsing.getResults()) {

            FatOperations fatOperation = new FatOperations();
            fatOperation.setOperation(operation);
            fatOperation.setResources(resolveOperationResources(operation));
            operations.add(fatOperation);
        }
        return new Browsing<>(browsing.getTotal(), browsing.getFrom(), browsing.getTo(), operations, browsing.getFacets());
    }

    private Map<String, BaseMetadataRecord> resolveOperationResources(Operation operation) {
        Map<String, BaseMetadataRecord> records = new HashMap<>();
        //Component
        if (operation.getComponent() != null) {
            Component component = resolveIndividualResource(operation.getComponent(), "application", Component.class);
            records.put(operation.getComponent(), component);
        }

        //Corpus input
        if (operation.getCorpus().getInput() != null) {
           // Corpus input = resolveIndividualResource(operation.getCorpus().getInput(), "corpus", Corpus.class);
           // records.put(operation.getCorpus().getInput(), input);
            BaseMetadataRecord input = resolveIndividualResource(operation.getCorpus().getInput(), "resourceTypes", BaseMetadataRecord.class);
        	records.put(operation.getCorpus().getInput(), input);            
        }

        //Corpus output
        if (operation.getCorpus().getOutput() != null) {
            //Corpus output = resolveIndividualResource(operation.getCorpus().getOutput(), "corpus", Corpus.class);
            //records.put(operation.getCorpus().getOutput(), output);      
        	BaseMetadataRecord output = resolveIndividualResource(operation.getCorpus().getOutput(), "resourceTypes", BaseMetadataRecord.class);
        	records.put(operation.getCorpus().getOutput(), output);
        }

        return records;
    }

    private <T> T resolveIndividualResource(String resourceId, String resourceName, Class<T> resourceType) {
        T output = null;
        try {
            SearchService.KeyValue kv = new SearchService.KeyValue(OMTD_ID, resourceId);
            Resource resource = this.searchService.searchId(resourceName, kv);
            output = parserPool.deserialize(resource, resourceType).get();
        } catch (Exception e) {
            logger.error("the resourceType of the operation " + resourceId + " was not found");
        }
        return output;
    }

    private String resolveApplicationWorkflow(String applicationId) {
        Component application = applicationResolver.get(applicationId);
        if (application == null) {
            logger.error("Application with id " + applicationId + " not found");
            throw new ServiceException("Application with id " + applicationId + " not found");
        }
        List<ResourceIdentifier> applicationIdentifiers = application.getComponentInfo().getIdentificationInfo().getResourceIdentifiers();
        String workflowId = applicationIdentifiers.get(0).getValue();
        logger.debug(workflowId);
        return workflowId;
    }

    private String resolveCorpusArchive(String corpusId) {
        final Pattern pattern = Pattern.compile(".*?\\?archiveId=(?<archive>[\\d\\w-]+)$");
        Corpus corpus = corpusResolver.get(corpusId);
        if (corpus == null) {
            logger.error("Corpus with id " + corpusId + " not found");
            throw new ServiceException("Corpus with id " + corpusId + " not found");
        }
        String distributionLocation = corpus.getCorpusInfo().getDatasetDistributionInfo().getDistributionLocation();
        Matcher archiveMatcher = pattern.matcher(distributionLocation);
        if (!archiveMatcher.find()) {
            throw new ServiceException("No archive Id was present");
        }
        String archiveId = archiveMatcher.group("archive");
        logger.debug(archiveId);
        return archiveId;
    }

    private Operation createOperation(String corpusId, String applicationId, String workflowId) {
        Operation ret = new Operation();
        ret.setId(workflowId);
        ret.setCorpus(new eu.openminted.registry.domain.operation.Corpus());
        ret.getCorpus().setInput(corpusId);
        ret.setComponent(applicationId);
        ret.setStatus(ExecutionStatus.Status.PENDING.toString());
        eu.openminted.registry.domain.operation.Date date = new eu.openminted.registry.domain.operation.Date();
        date.setSubmitted(new Date());
        ret.setDate(date);

        OIDCAuthenticationToken authentication;
        try {
            authentication = (OIDCAuthenticationToken) SecurityContextHolder.getContext().getAuthentication();
        } catch (ClassCastException e) {
            throw new ServiceException("User is not authenticated in order to generate metadata");
        }
        ret.setPerson(authentication.getSub());

        return ret;
    }

    @Override
    public String executeJob(String corpusId, String applicationId) {

        String workflowName = resolveApplicationWorkflow(applicationId);
        String archiveId = resolveCorpusArchive(corpusId);
        URL url;
        try {
            URIBuilder uriBuilder = new URIBuilder(workflowConfig.getWorkflowServiceHost());
            uriBuilder.setPath("/executeJob");
            uriBuilder.addParameter("corpusId",archiveId);
            uriBuilder.addParameter("workflowId",workflowName);
            url = uriBuilder.build().toURL();
        } catch (URISyntaxException | MalformedURLException e) {
            throw new RuntimeException(e);
        }

        logger.debug(url.toString());
        ResponseEntity<String> executionId;
        Operation operation;
        synchronized (OperationServiceImpl.class) {
        	logger.info("Starting workflow job");
        	logger.info(this);
            executionId = workflowRestTemplate.postForEntity(url.toString(), null, String.class);
            operation = createOperation(corpusId, applicationId, executionId.getBody());
            add(operation);
            logger.info("Added operation with execution id " + executionId.getBody());
        }
        try {
            logger.debug(mapper.writeValueAsString(operation));
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return executionId.getBody();
    }
}
