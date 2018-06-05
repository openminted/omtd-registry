package eu.openminted.registry.utils;

import eu.openminted.registry.core.service.ServiceException;
import eu.openminted.registry.domain.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;
import java.util.Optional;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class OMTDUtils {

    private static Logger logger = LogManager.getLogger(OMTDUtils.class);

    final static  private Pattern oldPattern = Pattern.compile(".*?\\?archiveId=(?<archive>[\\d\\w-]+)$");

    static public IdentificationInfo resolveIdentificationInfo(BaseMetadataRecord resource) {
        if (resource instanceof Component) {
            return ((Component) resource).getComponentInfo().getIdentificationInfo();
        } else if (resource instanceof Corpus) {
            return ((Corpus) resource).getCorpusInfo().getIdentificationInfo();
        } else if (resource instanceof Lexical) {
            return ((Lexical) resource).getLexicalConceptualResourceInfo().getIdentificationInfo();
        } else if (resource instanceof LanguageDescription) {
            return ((LanguageDescription) resource).getLanguageDescriptionInfo().getIdentificationInfo();
        } else {
            return null;
        }
    }

    /**
     * Resolves archiveId from corpusId.
     *
     * @param corpus
     * @return archiveId
     */
    public static String resolveCorpusArchive(Corpus corpus) {
        String archiveId;
        if (corpus == null) {
            logger.error("Application with id not found");
            throw new ServiceException("Corpus with id not found");
        }
        String distributionLocation = corpus.getCorpusInfo().getDatasetDistributionInfo().getDistributionLocation();
        Matcher archiveMatcher = oldPattern.matcher(distributionLocation);
        if (!archiveMatcher.find()) {
            Optional<ResourceIdentifier> resourceIdentifier = corpus.getCorpusInfo()
                    .getIdentificationInfo().getResourceIdentifiers()
                    .stream().filter(r -> r.getResourceIdentifierSchemeName().equals(ResourceIdentifierSchemeNameEnum.OTHER)
                    && r.getSchemeURI().equals("archiveID")).findAny();
            if(resourceIdentifier.isPresent()) {
                archiveId = resourceIdentifier.get().getValue();
            } else {
                throw new ServiceException("No archive Id was present");
            }
        } else {
            archiveId = archiveMatcher.group("archive");
        }

        logger.debug(archiveId);
        return archiveId;
    }

    public static String resolveApplicationWorkflow(Component application) {
        if (application == null) {
            logger.error("Application with id not found");
            throw new ServiceException("Application with id not found");
        }
        List<ResourceIdentifier> applicationIdentifiers = application.getComponentInfo().getIdentificationInfo().getResourceIdentifiers();
        Optional<ResourceIdentifier> workflowIdentifier = applicationIdentifiers.stream()
                .filter(identifier -> identifier.getResourceIdentifierSchemeName().equals(ResourceIdentifierSchemeNameEnum.OTHER)
                        && identifier.getSchemeURI().equals("workflowName")).findAny();
        if (!workflowIdentifier.isPresent()) {
            throw new ServiceException("No workflow name found in this application");
        }
        logger.debug(workflowIdentifier.get().getValue());
        return workflowIdentifier.get().getValue();
    }
}
