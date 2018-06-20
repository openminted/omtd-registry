package eu.openminted.registry.service.omtd;

import com.github.jmchilton.blend4j.galaxy.GalaxyInstance;
import eu.openminted.registry.core.exception.ResourceNotFoundException;
import eu.openminted.registry.core.service.ServiceException;
import eu.openminted.registry.domain.*;
import eu.openminted.registry.domain.workflow.WorkflowDefinition;
import eu.openminted.registry.service.*;
import eu.openminted.registry.service.generate.WorkflowGenerate;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service("applicationService")
@Primary
public class ApplicationServiceImpl extends OmtdGenericService<Component> {

    private static Logger logger = LogManager.getLogger(ApplicationServiceImpl.class);

    @Autowired
    private WorkflowGenerate workflowGenerate;

    @Autowired(required = false)
    @Qualifier("galaxyExecutorInstanceFactory")
    private GalaxyInstance galaxyExecutorInstance;

    @Autowired
    private WorkflowService workflowService;

    @Autowired
    private WorkflowEngineComponentRegistry workflowEngineComponentReg;

    public ApplicationServiceImpl() {
        super(Component.class);
    }

    @Override
    public String getResourceType() {
        return "application";
    }

    @Override
    public Component add(Component resource) {
        if (!resource.getComponentInfo().isApplication()) {
            throw new ServiceException("Expected an application not a component");
        }
        try {
            super.add(resource);
            resource = insertOMTDSpecificResources(resource);
            return this.update(resource);
        } catch (Throwable e) {
            throw new ServiceException(e);
        }
    }

    @Override
    public Component update(Component newResource) throws ResourceNotFoundException {
        if (!newResource.getComponentInfo().isApplication()) {
            throw new ServiceException("Cannot update an application to a component");
        }
        newResource = insertOMTDSpecificResources(newResource);
        return super.update(newResource);
    }

    @Override
    public void delete(Component component) {
        logger.info("Deleting application");
        workflowEngineComponentReg.deleteTDMComponentFromWorkflowEngine(component);
        super.delete(component);
    }

    private Component insertOMTDSpecificResources(Component application) {
        Optional<ComponentDistributionInfo> distLocation = application.getComponentInfo().getDistributionInfos()
                .stream().filter(dist -> dist.getComponentDistributionForm() == ComponentDistributionFormEnum
                        .GALAXY_WORKFLOW).findFirst();
        if (distLocation.isPresent()) {
            logger.info("application with id " + application.getComponentInfo().getIdentificationInfo()
                    .getResourceNames().get(0).getValue() + " has a workflow definition");
            String urlLocation = distLocation.get().getDistributionLocation();
            String workflowDefinition = urlLocation.substring(urlLocation.lastIndexOf("/") + 1);
            WorkflowDefinition definition = workflowService.get(workflowDefinition);
            if (definition == null) {
                throw new ServiceException("Workflow definition does not exist");
            }
            insertApplicationWorkflowName(application, definition.getWorkflowName());
        } else {
            WorkflowEngineComponent wec = workflowEngineComponentReg.registerTDMComponentToWorkflowEngine(application);
            String workflowDefinition = workflowGenerate.generateResource(wec);
            galaxyExecutorInstance.getWorkflowsClient().importWorkflow(workflowDefinition);
            insertApplicationWorkflowName(application, wec.getName());
        }
        return application;

    }

    private void insertApplicationWorkflowName(Component application, String workflowName) {
        ResourceIdentifier resourceIdentifier = new ResourceIdentifier();
        resourceIdentifier.setValue(workflowName);
        resourceIdentifier.setSchemeURI("workflowName");
        resourceIdentifier.setResourceIdentifierSchemeName(ResourceIdentifierSchemeNameEnum.OTHER);
        application.getComponentInfo().getIdentificationInfo().getResourceIdentifiers()
                .removeIf(r -> r.getResourceIdentifierSchemeName().equals(ResourceIdentifierSchemeNameEnum.OTHER)
                        && r.getSchemeURI().equals("workflowName"));
        application.getComponentInfo().getIdentificationInfo().getResourceIdentifiers().add(resourceIdentifier);
    }
}
