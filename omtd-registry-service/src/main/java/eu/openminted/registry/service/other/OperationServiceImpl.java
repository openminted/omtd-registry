package eu.openminted.registry.service.other;


import com.fasterxml.jackson.core.JsonProcessingException;
import eu.openminted.registry.beans.WorkflowConfig;
import eu.openminted.registry.core.domain.Browsing;
import eu.openminted.registry.core.domain.FacetFilter;
import eu.openminted.registry.core.domain.Resource;
import eu.openminted.registry.core.service.ParserService;
import eu.openminted.registry.core.service.ResourceCRUDService;
import eu.openminted.registry.core.service.SearchService;
import eu.openminted.registry.core.service.ServiceException;
import eu.openminted.registry.domain.BaseMetadataRecord;
import eu.openminted.registry.domain.Component;
import eu.openminted.registry.domain.Corpus;
import eu.openminted.registry.domain.FatOperations;
import eu.openminted.registry.domain.operation.Monitoring;
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
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.*;
import java.util.function.BinaryOperator;

/**
 * Created by stefanos on 30/6/2017.
 */
@Service("operationService")
@Primary
public class OperationServiceImpl extends OtherGenericService<Operation> implements OperationService {

    private static final String OMTD_ID = "omtdId";

    private Logger logger = LogManager.getLogger(OperationServiceImpl.class);

    @Autowired
    private WorkflowConfig workflowConfig;

    @Autowired
    @Qualifier("workflowRestTemplate")
    private RestTemplate workflowRestTemplate;

    @Autowired
    @Qualifier("applicationService")
    private ResourceCRUDService<Component, OIDCAuthenticationToken> applicationResolver;

    @Autowired
    @Qualifier("corpusService")
    private ResourceCRUDService<Corpus, OIDCAuthenticationToken> corpusResolver;

    public OperationServiceImpl() {
        super(Operation.class);
    }

    @Override
    String getResourceId() {
        return OMTD_ID;
    }

    @Override
    public String getResourceType() {
        return "operation";
    }

    @Override
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public Browsing getAll(FacetFilter filter, OIDCAuthenticationToken auth) {
        return applicationJoinForOperations(super.getAll(filter, auth));
    }

    @Override
    public Browsing getMy(FacetFilter filter, OIDCAuthenticationToken auth) {
        return applicationJoinForOperations(super.getMy(filter, auth));
    }


    private Browsing<FatOperations> applicationJoinForOperations(Browsing<Operation> browsing) {
        List<FatOperations> operations = new ArrayList<>();
        for (Operation operation : browsing.getResults()) {

            FatOperations fatOperation = new FatOperations();
            fatOperation.setOperation(operation);
            fatOperation.setResources(resolveOperationResources(operation));
            operations.add(fatOperation);
        }
        return new Browsing<>(browsing, operations, browsing.getFacets());
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
            SearchService.KeyValue kv = new SearchService.KeyValue("omtdid", resourceId);
            Resource resource = this.searchService.searchId(resourceName, kv);
            output = parserPool.deserialize(resource, resourceType);
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
    public String executeJob(String corpusId, String applicationId, String subArchive) {

        Component application = applicationResolver.get(applicationId);
        String workflowName = OMTDUtils.resolveApplicationWorkflow(application);
        String archiveId = OMTDUtils.resolveCorpusArchive(corpusResolver.get(corpusId));
        URL url;
        try {
            URIBuilder uriBuilder = new URIBuilder(workflowConfig.getWorkflowServiceHost());
            uriBuilder.setPath("/executeJob");
//            uriBuilder.addParameter("corpusId", archiveId);
//            uriBuilder.addParameter("subArchive", subArchive);
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
//            headers.setContentType(MediaType.APPLICATION_JSON);
            MultiValueMap<String, String> params = new LinkedMultiValueMap<>();
            params.add("workflow", parserPool.serialize(application, ParserService.ParserServiceTypes.JSON));
            params.add("subArchive", subArchive);
            params.add("corpusId", archiveId); //teleia
//            HttpEntity<Component> entity = new HttpEntity<>(application, headers);
            HttpEntity<MultiValueMap<String, String>> entity = new HttpEntity<>(params, headers);
            executionId = workflowRestTemplate.postForEntity(url.toString(), entity, String.class);
            operation = createOperation(corpusId, applicationId, executionId.getBody());
            add(operation, null);
            logger.info("Added operation with execution id " + executionId.getBody());
        }
        try {
            logger.debug(mapper.writeValueAsString(operation));
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return executionId.getBody();
    }

    @Override
    public Monitoring aggregate(OIDCAuthenticationToken auth) {
        FacetFilter filter = new FacetFilter();
        filter.setQuantity(1000);
        Browsing<Operation> result = super.getMy(filter,auth);
        Monitoring monitoring = new Monitoring();
        monitoring.setRamUsage(0);
        monitoring.setVmCount(0);
        monitoring.setCpuCount(0);
        monitoring.setCpuMilliseconds(0);
        return result.getResults().stream()
                .map(Operation::getMonitoring)
                .filter(Objects::nonNull)
                .reduce(monitoring,new MergeMonitoring());
    }

    private static class MergeMonitoring implements BinaryOperator<Monitoring>

    {
        @Override
        public Monitoring apply(Monitoring m1, Monitoring m2) {
            Integer cpuMills = m1.getCpuMilliseconds() + m2.getCpuMilliseconds();
            Integer maxRam = Math.max(m1.getRamUsage(),m2.getRamUsage());
            Integer maxVm = Math.max(m1.getVmCount(),m2.getVmCount());
            Integer maxCpu = Math.max(m1.getCpuCount(),m2.getCpuCount());
            Monitoring m = new Monitoring();
            m.setCpuMilliseconds(cpuMills);
            m.setVmCount(maxVm);
            m.setCpuCount(maxCpu);
            m.setRamUsage(maxRam);
            return m;
        }
    }

}
