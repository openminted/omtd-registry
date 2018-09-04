package eu.openminted.registry.service.other;


import com.fasterxml.jackson.core.JsonProcessingException;
import eu.openminted.registry.beans.WorkflowConfig;
import eu.openminted.registry.core.domain.Browsing;
import eu.openminted.registry.core.domain.FacetFilter;
import eu.openminted.registry.core.domain.Resource;
import eu.openminted.registry.core.service.ResourceCRUDService;
import eu.openminted.registry.core.service.SearchService;
import eu.openminted.registry.core.service.ServiceException;
import eu.openminted.registry.domain.BaseMetadataRecord;
import eu.openminted.registry.domain.Component;
import eu.openminted.registry.domain.Corpus;
import eu.openminted.registry.domain.FatOperations;
import eu.openminted.registry.domain.operation.Operation;
import eu.openminted.registry.service.OperationService;
import eu.openminted.registry.utils.OMTDUtils;
import eu.openminted.workflow.api.ExecutionStatus;
import org.apache.http.client.utils.URIBuilder;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.mitre.openid.connect.model.OIDCAuthenticationToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.*;

/**
 * Created by stefanos on 30/6/2017.
 */
@Service("operationService")
@Primary
public class OperationServiceImpl extends OtherGenericService<Operation> implements OperationService {

    private static final String OPERATION_ID = "operation_id";
    private static final String OMTD_ID = "omtdid";

    private Logger logger = LogManager.getLogger(OperationServiceImpl.class);

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
    }

    @Override
    String getResourceId() {
        return OPERATION_ID;
    }

    @Override
    public String getResourceType() {
        return "operation";
    }

    @Override
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public Browsing getAll(FacetFilter filter) {
        return applicationJoinForOperations(super.getAll(filter));
    }

    @Override
    public Browsing getMy(FacetFilter filter) {
        return applicationJoinForOperations(super.getMy(filter));
    }


    private Browsing<FatOperations> applicationJoinForOperations(Browsing<Operation> browsing) {
        List<FatOperations> operations = new ArrayList<>();
        for (Operation operation : browsing.getResults()) {

            FatOperations fatOperation = new FatOperations();
            fatOperation.setOperation(operation);
            fatOperation.setResources(resolveOperationResources(operation));
            operations.add(fatOperation);
        }
        return new Browsing<>(browsing.getTotal(), browsing.getFrom(), browsing.getTo(), operations, browsing
                .getFacets());
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
            BaseMetadataRecord input = resolveIndividualResource(operation.getCorpus().getInput(), "resourceTypes",
                    BaseMetadataRecord.class);
            records.put(operation.getCorpus().getInput(), input);
        }

        //Corpus output
        if (operation.getCorpus().getOutput() != null) {
            //Corpus output = resolveIndividualResource(operation.getCorpus().getOutput(), "corpus", Corpus.class);
            //records.put(operation.getCorpus().getOutput(), output);      
            BaseMetadataRecord output = resolveIndividualResource(operation.getCorpus().getOutput(), "resourceTypes",
                    BaseMetadataRecord.class);
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

    private Operation createOperation(String corpusId, String applicationId, String workflowId) {
        Operation ret = new Operation();
        ret.setOmtdId(workflowId);
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
        ret.setPersonIdentifier(authentication.getSub());

        return ret;
    }

    @Override
    public String executeJob(String corpusId, String applicationId) {

        Component application = applicationResolver.get(applicationId);
        String workflowName = OMTDUtils.resolveApplicationWorkflow(application);
        String archiveId = OMTDUtils.resolveCorpusArchive(corpusResolver.get(corpusId));
        URL url;
        try {
            URIBuilder uriBuilder = new URIBuilder(workflowConfig.getWorkflowServiceHost());
            uriBuilder.setPath("/executeJob");
            uriBuilder.addParameter("corpusId", archiveId);
            url = uriBuilder.build().toURL();
        } catch (URISyntaxException | MalformedURLException e) {
            throw new RuntimeException(e);
        }

        logger.debug(url.toString());
        ResponseEntity<String> executionId;
        Operation operation;
        synchronized (OperationServiceImpl.class) {
            logger.info(String.format("Starting workflow job archiveId [%s] workflowName [%s]", archiveId,
                    workflowName));
            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.APPLICATION_JSON);
            HttpEntity<Component> entity = new HttpEntity<>(application, headers);
            executionId = workflowRestTemplate.postForEntity(url.toString(), entity, String.class);
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
