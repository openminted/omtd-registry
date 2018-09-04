package eu.openminted.registry.service.generate;


import eu.openminted.registry.domain.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


@org.springframework.stereotype.Component
public class LanguageConceptualResourceMetadataGenerate extends WorkflowOutputMetadataGenerate {

    static final Logger logger = LogManager.getLogger(LanguageConceptualResourceMetadataGenerate.class);

    public Lexical generateLanguageConceptualResourceMetadata(String inputCorpusId, String componentId, String userId,
                                                              String outputResourceArchiveId)
            throws IOException, NullPointerException {
        //eu.openminted.registry.domain.Lexical
        Lexical lcr = new Lexical();
        lcr.setMetadataHeaderInfo(generateMetadataHeaderInfo(userId));
        String lcrOmtdId = lcr.getMetadataHeaderInfo().getMetadataRecordIdentifier().getValue();
        lcr.setLexicalConceptualResourceInfo(generateLanguageConceptualResourceInfo(lcrOmtdId, inputCorpusId,
                componentId, userId, outputResourceArchiveId));
        logger.debug("Output language description metadata::\n " + mapper.writeValueAsString(lcr) + "\n");
        return lcr;
    }

    public LexicalConceptualResourceInfo generateLanguageConceptualResourceInfo(String lcrOmtdId, String inputCorpusId,
                                                                                String componentId, String userId,
                                                                                String outputCorpusArchiveId)
            throws IOException, NullPointerException {
        // Get input corpus information
        Corpus inputCorpus = getInputCorpusMetadata(inputCorpusId);
        // Get component information
        Component component = getComponentMetadata(componentId);

        LexicalConceptualResourceInfo lcrInfo = new LexicalConceptualResourceInfo();

        ////////////////////////
        // IdentificationInfo
        lcrInfo.setIdentificationInfo(generateIdentificationInfo(inputCorpus, component));
        logger.debug("Identification Info:\n" + mapper.writeValueAsString(lcrInfo.getIdentificationInfo()) + "\n");

        /////////////////////////
        // VersionInfo
        lcrInfo.setVersionInfo(generateVersionInfo());
        logger.debug("Version info:\n" + mapper.writeValueAsString(lcrInfo.getVersionInfo()) + "\n");

        //////////////////////////
        // ContactInfo
        lcrInfo.setContactInfo(generateContactInfo(userId, lcrOmtdId));
        logger.debug("Contact info::\n" + mapper.writeValueAsString(lcrInfo.getContactInfo()) + "\n");

        //////////////////////////
        // datasetDistributionInfo
        List<DatasetDistributionInfo> distributionInfos = new ArrayList<>();
        distributionInfos.add(generateDatasetDistributionInfo(inputCorpus, component, outputCorpusArchiveId));
        lcrInfo.setDistributionInfos(distributionInfos);
        logger.debug("Distribution info:\n" + mapper.writeValueAsString(lcrInfo.getDistributionInfos()) + "\n");

        //////////////////////////
        // rightsInfo
        RightsInfo rightsInfo = generateRightsInfo(inputCorpus, component);
        lcrInfo.setRightsInfo(rightsInfo);
        logger.debug("Rights info:\n" + mapper.writeValueAsString(rightsInfo) + "\n");

        //////////////////////////
        // resourceCreationInfo
        ResourceCreationInfo resourceCreationInfo = generateResourceCreationInfo(userId);
        lcrInfo.setResourceCreationInfo(resourceCreationInfo);
        logger.debug("Resource Creation info::\n" + mapper.writeValueAsString(resourceCreationInfo) + "\n");

        //////////////////////////////
        // lexicalConceptualResourceType
        OperationType componentOperation = component.getComponentInfo().getFunctionInfo().getFunction();
        // OntologyAcquisition, OntologyEnhancement --> Ontology
        if (componentOperation.equals(OperationType.HTTP___W3ID_ORG_META_SHARE_OMTD_SHARE_ONTOLOGY_ACQUISITION) ||
                componentOperation.equals(OperationType.HTTP___W3ID_ORG_META_SHARE_OMTD_SHARE_ONTOLOGY_ENHANCEMENT)) {
            //logger.info("Into ontology functionality");
            lcrInfo.setLexicalConceptualResourceType(LexicalConceptualResourceTypeEnum.ONTOLOGY);
        }
        // LexiconAquisitionFromCorpora, LexiconEnhancement, BilignualLexiconInduction --> Lexicon
        else if (componentOperation.equals(OperationType
				.HTTP___W3ID_ORG_META_SHARE_OMTD_SHARE_LEXICON_ACQUISITION_FROM_CORPORA) ||
                componentOperation.equals(OperationType
						.HTTP___W3ID_ORG_META_SHARE_OMTD_SHARE_LEXICON_EXTRACTION_FROM_LEXICA) ||
                componentOperation.equals(OperationType
						.HTTP___W3ID_ORG_META_SHARE_OMTD_SHARE_LEXICON_EXTRACTOR_FROM_CORPORA) ||
                componentOperation.equals(OperationType.HTTP___W3ID_ORG_META_SHARE_OMTD_SHARE_LEXICON_ENHANCEMENT) ||
                componentOperation.equals(OperationType
						.HTTP___W3ID_ORG_META_SHARE_OMTD_SHARE_BILINGUAL_LEXICON_INDUCTION)) {
            //logger.info("Into lexicon functionality");
            lcrInfo.setLexicalConceptualResourceType(LexicalConceptualResourceTypeEnum.LEXICON);
        }
        // rest --> other
        else {
            //logger.info("Into other functionality");
            lcrInfo.setLexicalConceptualResourceType(LexicalConceptualResourceTypeEnum.OTHER);
        }

        //////////////////////////
        // relations.relationInfo
        List<RelationInfo> relations = new ArrayList<>();
        relations.add(generateRelationInfo(component));
        lcrInfo.setRelations(relations);
        logger.debug("Resource Relation info::\n" + mapper.writeValueAsString(relations) + "\n");

        /////////////////////////////////////////////////
        // lexicalConceptualResourceTextInfo
        LexicalConceptualResourceTextInfo lcrTextInfo = generateLexicalConceptualResourceTextInfo(inputCorpus,
				component);
        lcrInfo.setLexicalConceptualResourceTextInfo(lcrTextInfo);
        logger.debug("Text info::\n" + mapper.writeValueAsString(lcrTextInfo) + "\n");

        return (lcrInfo);
    }

    @Override
    protected IdentificationInfo generateIdentificationInfo(Corpus inputCorpus, Component component) {

        String descriptionDescription = "The lexical/conceptual resource generated by the processing of " +
                "[input_corpus_name] with [component_name] version [component_version].";

        IdentificationInfo identificationInfo = new IdentificationInfo();

        // identificationInfo.resourceNames.resourceName
        identificationInfo.setResourceNames(generateResourceNameList(inputCorpus, component));

        // identificationInfo.descriptions.description
        identificationInfo.setDescriptions(generateDescriptionList(inputCorpus, component, descriptionDescription));

        // identificationInfo.resourceIdentifiers.resourceIdentifier
        identificationInfo.setResourceIdentifiers(generateResourceIdentifierList());

        return identificationInfo;
    }

    @Override
    protected String getWorkingResourceName(Corpus inputCorpus, Component component) {
        String lexicalName = "The lexical/conceptual resource generated by the processing of " +
                "[input_corpus_name] with [component_name]";
        lexicalName = lexicalName.replaceAll("\\[input_corpus_name\\]",
                getInputCorpusName(inputCorpus));
        lexicalName = lexicalName.replaceAll("\\[component_name\\]",
                getComponentName(component));

        return lexicalName;
    }

    @Override
    protected String generateWorkingResourceLandingPage(String resourceOmtdId) {
        return landingPageDomain + "/landingPage/lexical/" + resourceOmtdId;
    }

    @Override
    protected String generateDistributionLocation(String outputArchiveId) {
        return registryHost + "/request/lexical/download?archiveId=" + outputArchiveId;
    }

    @Override
    protected List<SizeInfo> generateDistributionSizeInfo(Corpus inputCorpus) {
        List<SizeInfo> sizeInfoList = new ArrayList<>();
        SizeInfo sizeInfo = new SizeInfo();
        sizeInfo.setSize("1");
        sizeInfo.setSizeUnit(SizeUnitEnum.FILES);
        sizeInfoList.add(sizeInfo);
        return sizeInfoList;
    }

    @Override
    protected String generateAttributionTextStart() {
        return "The language/conceptual resource generated by the ";
    }

    @Override
    protected RelationInfo generateRelationInfo(Corpus inputCorpus) {
        return null;
    }


    protected LexicalConceptualResourceTextInfo generateLexicalConceptualResourceTextInfo(Corpus inputCorpus,
                                                                                          Component component) {

        LexicalConceptualResourceTextInfo lcrTextInfo = new LexicalConceptualResourceTextInfo();

        // inputCorpus is raw corpus
        if (inputCorpus.getCorpusInfo().getCorpusSubtypeSpecificInfo().getRawCorpusInfo() != null) {

            RawCorpusInfo rawCorpusInfo = inputCorpus.getCorpusInfo().getCorpusSubtypeSpecificInfo().getRawCorpusInfo();

            // lexicalConceptualResourceTextInfo.lingualityInfo
            LingualityInfo lingualityInfo = rawCorpusInfo.getLingualityInfo();
            lcrTextInfo.setLingualityInfo(lingualityInfo);
            //logger.info("Added lingualityInfo from raw corpus");

            // lexicalConceptualResourceTextInfo.languages
            List<LanguageInfo> languages = rawCorpusInfo.getLanguages();
            lcrTextInfo.setLanguages(languages);
            //logger.info("Added languages from raw corpus");

            // lexicalConceptualResourceTextInfo.timeCoverage
            String timeCoverage = generateTimeCoverage(rawCorpusInfo.getTimeClassifications());
            if (timeCoverage != null) {
                lcrTextInfo.setTimeCoverage(timeCoverage);
            }

            // lexicalConceptualResourceTextInfo.geographicCoverage
            String geoCoverage = generateGeoCoverage(rawCorpusInfo.getGeographicClassifications());
            if (geoCoverage != null) {
                lcrTextInfo.setGeographicCoverage(geoCoverage);
            }

        }
        // inputCorpus is annotated corpus
        else if (inputCorpus.getCorpusInfo().getCorpusSubtypeSpecificInfo().getAnnotatedCorpusInfo() != null) {

            AnnotatedCorpusInfo annotatedCorpusInfo = inputCorpus.getCorpusInfo().getCorpusSubtypeSpecificInfo().getAnnotatedCorpusInfo();

            // lexicalConceptualResourceTextInfo.lingualityInfo
            LingualityInfo lingualityInfo = annotatedCorpusInfo.getLingualityInfo();
            lcrTextInfo.setLingualityInfo(lingualityInfo);
            //logger.info("Added lingualityInfo from annotated corpus");

            // lexicalConceptualResourceTextInfo.languages
            List<LanguageInfo> languages = annotatedCorpusInfo.getLanguages();
            lcrTextInfo.setLanguages(languages);
            //logger.info("Added languages from annotated corpus");

            // lexicalConceptualResourceTextInfo.timeCoverage
            String timeCoverage = generateTimeCoverage(annotatedCorpusInfo.getTimeClassifications());
            if (timeCoverage != null) {
                lcrTextInfo.setTimeCoverage(timeCoverage);
            }

            // lexicalConceptualResourceTextInfo.geographicCoverage
            String geoCoverage = generateGeoCoverage(annotatedCorpusInfo.getGeographicClassifications());
            if (geoCoverage != null) {
                lcrTextInfo.setGeographicCoverage(geoCoverage);
            }
        }

        // lexicalConceptualResourceTextInfo.creationInfo
        CreationInfo creationInfo = generateCreationInfo(inputCorpus, component);
        lcrTextInfo.setCreationInfo(creationInfo);
        return lcrTextInfo;
    }


}