package eu.openminted.registry.generate;

import java.io.IOException;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import eu.openminted.registry.domain.*;
import eu.openminted.registry.domain.Date;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;
import java.util.*;


/*
 * Generator for annotated corpus when a workflow ends successfully at the
 * workflow engine.
 */

@org.springframework.stereotype.Component
public class AnnotatedCorpusMetadataGenerate extends WorkflowOutputMetadataGenerate {

    static final Logger logger = LogManager.getLogger(AnnotatedCorpusMetadataGenerate.class);
  
    public Corpus generateAnnotatedCorpusMetadata(String inputCorpusId, String componentId, String userId, String outputCorpusArchiveId) throws IOException  {
    	Corpus corpus = new Corpus();
    	corpus.setMetadataHeaderInfo(generateMetadataHeaderInfo(userId));
    	String workingCorpusOmtdId = corpus.getMetadataHeaderInfo().getMetadataRecordIdentifier().getValue();
    	corpus.setCorpusInfo(generateAnnotatedCorpusInfo(workingCorpusOmtdId, inputCorpusId, componentId, userId, outputCorpusArchiveId));
    	//logger.info("Output corpus metadata::\n " + mapper.writeValueAsString(corpus)+"\n");
    	return corpus;
    }
	
	  
    public CorpusInfo generateAnnotatedCorpusInfo(String corpusOmtdId, String inputCorpusId, String componentId, String userId, String outputCorpusArchiveId) throws IOException {

        // Get input corpus information
        logger.info("Retrieving input corpus " + inputCorpusId);
        Corpus inputCorpus = corpusService.get(inputCorpusId);
        //logger.info("Input corpus:\n" + mapper.writeValueAsString(inputCorpus.getCorpusInfo()) +"\n");

        // Get component information
        logger.info("Retrieving component " + componentId);
        Component component = applicationService.get(componentId);
        //logger.info("Component:\n" + mapper.writeValueAsString(component.getComponentInfo()) +"\n");

        // CorpusInfo
        CorpusInfo corpusInfo = new CorpusInfo();

        ////////////////////////
        // IdentificationInfo      
        corpusInfo.setIdentificationInfo(generateIdentificationInfo(inputCorpus, component));
        logger.info("Identification Info:\n" + mapper.writeValueAsString(corpusInfo.getIdentificationInfo()) +"\n");

        /////////////////////////
        // VersionInfo     
        corpusInfo.setVersionInfo(generateVersionInfo());
        logger.info("Version info:\n" + mapper.writeValueAsString(corpusInfo.getVersionInfo())+"\n");

        //////////////////////////
        // ContactInfo       
        corpusInfo.setContactInfo(generateContactInfo(userId, corpusOmtdId));
        logger.info("Contact info::\n" + mapper.writeValueAsString(corpusInfo.getContactInfo()) + "\n");

        //////////////////////////
        // datasetDistributionInfo       
        corpusInfo.setDatasetDistributionInfo(generateDatasetDistributionInfo(inputCorpus, component, outputCorpusArchiveId));
        logger.info("Distribution info:\n" + mapper.writeValueAsString(corpusInfo.getDatasetDistributionInfo())+"\n");

        //////////////////////////
        // rightsInfo
        RightsInfo rightsInfo = generateRightsInfo(inputCorpus, component);
        corpusInfo.setRightsInfo(rightsInfo);
        logger.info("Rights info:\n" + mapper.writeValueAsString(rightsInfo) + "\n");    

        //////////////////////////
        // resourceCreationInfo
        ResourceCreationInfo resourceCreationInfo = generateResourceCreationInfo(userId);
        corpusInfo.setResourceCreationInfo(resourceCreationInfo);
        logger.info("Resource Creation info::\n" + mapper.writeValueAsString(resourceCreationInfo) + "\n");

        //////////////////////////
        // relations.relationInfo
        List<RelationInfo> relations = new ArrayList<>();        
        relations.add(generateRelationInfo(inputCorpus));
        relations.add(generateRelationInfo(component));
        corpusInfo.setRelations(relations);
        logger.info("Resource Relation info::\n" + mapper.writeValueAsString(relations) + "\n");                

        ///////////////////////////
        // corpusSubtypeSpecificationInfo.annotatedCorpusInfo
        CorpusSubtypeSpecificInfo corpusSubtypeSpecificInfo = new CorpusSubtypeSpecificInfo();

        AnnotatedCorpusInfo annotatedCorpusInfo = generateAnnotatedCorpusInfo(inputCorpus, component);
        corpusSubtypeSpecificInfo.setAnnotatedCorpusInfo(annotatedCorpusInfo);
        logger.info("CorpusSubtypeSpecificInfo:\n" + mapper.writeValueAsString(corpusSubtypeSpecificInfo) + "\n");
        corpusInfo.setCorpusSubtypeSpecificInfo(corpusSubtypeSpecificInfo);

        return corpusInfo;
    }

    private AnnotatedCorpusInfo generateAnnotatedCorpusInfo(Corpus inputCorpus, Component component) throws JsonProcessingException {

    	logger.info("In generateAnnotatedCorpusInfo");
        AnnotatedCorpusInfo generatedAnnotatedCorpusInfo = new AnnotatedCorpusInfo();

       
        // inputCorpus is raw corpus
        if (inputCorpus.getCorpusInfo().getCorpusSubtypeSpecificInfo().getRawCorpusInfo() != null) {
        	
        	RawCorpusInfo rawCorpusInfo = inputCorpus.getCorpusInfo().getCorpusSubtypeSpecificInfo().getRawCorpusInfo();
        	
        	// corpusSubtypeSpecificationInfo.annotatedCorpusInfo.lingualityInfo
        	LingualityInfo lingualityInfo = rawCorpusInfo.getLingualityInfo();
        	generatedAnnotatedCorpusInfo.setLingualityInfo(lingualityInfo);
        	logger.info("Added lingualityInfo from raw corpus");
        	
        	// corpusSubtypeSpecificationInfo.annotatedCorpusInfo.languages
            List<LanguageInfo> languages = rawCorpusInfo.getLanguages();
            generatedAnnotatedCorpusInfo.setLanguages(languages);
            logger.info("Added languages from raw corpus");
                        
        	// corpusSubtypeSpecificationInfo.annotatedCorpusInfo.textClassifications
    		List<TextClassificationInfo> textClassifications = rawCorpusInfo.getTextClassifications();
    		generatedAnnotatedCorpusInfo.setTextClassifications(textClassifications);
    	    logger.info("Added textClassifications from raw corpus");
    		
    		// corpusSubtypeSpecificationInfo.annotatedCorpusInfo.domains
    		List<DomainInfo> domains = rawCorpusInfo.getDomains();
    		generatedAnnotatedCorpusInfo.setDomains(domains);
    	    logger.info("Added domains from raw corpus");
    		
    		// corpusSubtypeSpecificationInfo.annotatedCorpusInfo.timeClassifications
    		List<TimeCoverageInfo> timeClassifications = rawCorpusInfo.getTimeClassifications();
    		generatedAnnotatedCorpusInfo.setTimeClassifications(timeClassifications);
    	    logger.info("Added timeClassifications from raw corpus");
    		
    		// corpusSubtypeSpecificationInfo.annotatedCorpusInfo.geographicClassifications
    		List<GeographicCoverageInfo> geographicClassifications = rawCorpusInfo.getGeographicClassifications();
    		generatedAnnotatedCorpusInfo.setGeographicClassifications(geographicClassifications);
    	    logger.info("Added geographicClassifications from raw corpus");
        }  
        // inputCorpus is annotated corpus
        else if (inputCorpus.getCorpusInfo().getCorpusSubtypeSpecificInfo().getAnnotatedCorpusInfo() != null) {
        	
        	AnnotatedCorpusInfo annotatedCorpusInfo = inputCorpus.getCorpusInfo().getCorpusSubtypeSpecificInfo().getAnnotatedCorpusInfo();
        	
        	// corpusSubtypeSpecificationInfo.annotatedCorpusInfo.lingualityInfo	
        	LingualityInfo lingualityInfo = annotatedCorpusInfo.getLingualityInfo();
        	generatedAnnotatedCorpusInfo.setLingualityInfo(lingualityInfo);
        	logger.info("Added lingualityInfo from annotated corpus");
        	
        	// corpusSubtypeSpecificationInfo.annotatedCorpusInfo.languages
            List<LanguageInfo> languages = annotatedCorpusInfo.getLanguages();
            generatedAnnotatedCorpusInfo.setLanguages(languages);
            logger.info("Added languages from annotated corpus");
            
            // corpusSubtypeSpecificationInfo.annotatedCorpusInfo.textClassifications
    		List<TextClassificationInfo> textClassifications = annotatedCorpusInfo.getTextClassifications();
    		generatedAnnotatedCorpusInfo.setTextClassifications(textClassifications);
    	    logger.info("Added textClassifications from annotated corpus");
    		
    		// corpusSubtypeSpecificationInfo.annotatedCorpusInfo.domains
    		List<DomainInfo> domains = annotatedCorpusInfo.getDomains();
    		generatedAnnotatedCorpusInfo.setDomains(domains);
    	    logger.info("Added domains from annotated corpus");
    		
    		// corpusSubtypeSpecificationInfo.annotatedCorpusInfo.timeClassifications
    		List<TimeCoverageInfo> timeClassifications = annotatedCorpusInfo.getTimeClassifications();
    		generatedAnnotatedCorpusInfo.setTimeClassifications(timeClassifications);
    	    logger.info("Added timeClassifications from annotated corpus");
    		
    		// corpusSubtypeSpecificationInfo.annotatedCorpusInfo.geographicClassifications
    		List<GeographicCoverageInfo> geographicClassifications = annotatedCorpusInfo.getGeographicClassifications();
    		generatedAnnotatedCorpusInfo.setGeographicClassifications(geographicClassifications);
    	    logger.info("Added geographicClassifications from annotated corpus");
        }
               	
		// corpusSubtypeSpecificationInfo.annotatedCorpusInfo.annotations.annotationInfo
		List<AnnotationInfo> annotations = new ArrayList<>();
		AnnotationInfo annotationInfo = new AnnotationInfo();
		logger.info("Adding annotationInfo");
		
		if (component.getComponentInfo().getOutputResourceInfo() != null) {
			logger.info("Workflow has outputResourceInfo metadata.");
			// annotatationInfo.annotationTypes
			List<AnnotationTypeInfo> annotationTypes = component.getComponentInfo().getOutputResourceInfo().getAnnotationTypes();
			// TODO Added a dummy node just for passing validation of add in registry 	
			if (annotationTypes.size() == 0) { 
				AnnotationTypeInfo annotationTypeInfo = new AnnotationTypeInfo();
				annotationTypeInfo.setAnnotationType(AnnotationTypeType.HTTP___W3ID_ORG_META_SHARE_OMTD_SHARE_LEMMA);
				annotationTypes.add(annotationTypeInfo);
			}
			annotationInfo.setAnnotationTypes(annotationTypes);
			
			// annotationInfo.typesystem	
			RelatedResource typesystem = component.getComponentInfo().getOutputResourceInfo().getTypesystem();
			annotationInfo.setTypesystem(typesystem);
	
			// annotationInfo.annotationSchema
			RelatedResource annotationSchema = component.getComponentInfo().getOutputResourceInfo().getAnnotationSchema();
			annotationInfo.setAnnotationSchema(annotationSchema);
			
			// annotationInfo.annotationResource
			RelatedResource annotationResource = component.getComponentInfo().getOutputResourceInfo().getAnnotationResource();
			annotationInfo.setAnnotationResource(annotationResource);
		}
		else {
			logger.info("Workflow does not has outputResourceInfo metadata. Add dummy node.");
			// TODO Added a dummy node just for passing validation of add in registry 	
			List<AnnotationTypeInfo> annotationTypes = new ArrayList<>();
			AnnotationTypeInfo annotationTypeInfo = new AnnotationTypeInfo();
			annotationTypeInfo.setAnnotationType(AnnotationTypeType.HTTP___W3ID_ORG_META_SHARE_OMTD_SHARE_LEMMA);
			annotationTypes.add(annotationTypeInfo);
			annotationInfo.setAnnotationTypes(annotationTypes);
		}
		
		// annotationInfo.annotationMode
		annotationInfo.setAnnotationMode(ProcessMode.AUTOMATIC);
		
		// annotationInfo.isAnnotatedBy
		RelatedResource isAnnotatedBy = new RelatedResource();
		isAnnotatedBy.setResourceNames(component.getComponentInfo().getIdentificationInfo().getResourceNames());
		isAnnotatedBy.setResourceIdentifiers(component.getComponentInfo().getIdentificationInfo().getResourceIdentifiers());		
		List<RelatedResource> annotatedByList = new ArrayList<>();
		annotatedByList.add(isAnnotatedBy);
		annotationInfo.setIsAnnotatedBy(annotatedByList);
		
		// annotationInfo.annotationDate
		DateCombination annotationDate = new DateCombination();
		XMLGregorianCalendar calendar = null;
		try {
			calendar = DatatypeFactory.newInstance().newXMLGregorianCalendar(gregory);
	    } catch (DatatypeConfigurationException e) {
	    	e.printStackTrace();
	    }
		Date date = new Date();
		date.setYear(calendar.getYear());
		date.setMonth(calendar.getMonth());
		date.setDay(calendar.getDay());		
		annotationDate.setDate(date);
		annotationInfo.setAnnotationDate(annotationDate);
				
		annotations.add(annotationInfo);
		generatedAnnotatedCorpusInfo.setAnnotations(annotations);

		logger.info("Annotations " + mapper.writeValueAsString(annotationInfo) + "\n");
			
		                
		
		return generatedAnnotatedCorpusInfo;
	}
    
    @Override    
	protected RelationInfo generateRelationInfo(Corpus inputCorpus) {
		
		RelationInfo relationInfo = new RelationInfo();
		// relationType
		relationInfo.setRelationType(RelationTypeEnum.IS_ANNOTATED_VERSION_OF);
		
		// relatedResource
		RelatedResource rawCorpus = new RelatedResource();
		ResourceIdentifier identifier = new ResourceIdentifier();
		identifier.setResourceIdentifierSchemeName(ResourceIdentifierSchemeNameEnum.OMTD);
		identifier.setValue(inputCorpus.getMetadataHeaderInfo().getMetadataRecordIdentifier().getValue());
		rawCorpus.setResourceIdentifiers(Collections.singletonList(identifier));
//		rawCorpus.setResourceIdentifiers(inputCorpus.getCorpusInfo().getIdentificationInfo().getResourceIdentifiers());
		rawCorpus.setResourceNames(inputCorpus.getCorpusInfo().getIdentificationInfo().getResourceNames());
		relationInfo.setRelatedResource(rawCorpus);
		
		return relationInfo;
	}
    
    @Override        
	protected RelationInfo generateRelationInfo(Component component) {
		
		RelationInfo relationInfo = new RelationInfo();
		// relationType
		relationInfo.setRelationType(RelationTypeEnum.IS_CREATED_BY);
		
		// relatedResource
		RelatedResource componentRR = new RelatedResource();
		ResourceIdentifier identifier = new ResourceIdentifier();
		identifier.setResourceIdentifierSchemeName(ResourceIdentifierSchemeNameEnum.OMTD);
		identifier.setValue(component.getMetadataHeaderInfo().getMetadataRecordIdentifier().getValue());
		componentRR.setResourceIdentifiers(Collections.singletonList(identifier));
//		rawCorpus.setResourceIdentifiers(inputCorpus.getCorpusInfo().getIdentificationInfo().getResourceIdentifiers());
		componentRR.setResourceNames(component.getComponentInfo().getIdentificationInfo().getResourceNames());
		relationInfo.setRelatedResource(componentRR);
			
		return relationInfo;
	}
	

	
	@Override
	protected String getWorkingResourceName(Corpus inputCorpus, Component component) {
		String corpusName = "[input_corpus_name] processed by [component_name]";
		corpusName = corpusName.replaceAll("\\[input_corpus_name\\]", 
				getInputCorpusName(inputCorpus));			
		corpusName = corpusName .replaceAll("\\[component_name\\]", 
				getComponentName(component));
									
		return corpusName;
	}	
	
	@Override
	protected IdentificationInfo generateIdentificationInfo(Corpus inputCorpus, Component component) {
		
		String descriptionDescription  =  "[input_corpus_name] processed by [component_name] " +
					"version [component_version]." + "[input_corpus_description]"; 		    
		
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
	protected String generateWorkingResourceLandingPage(String resourceOmtdId) {
		 
		return landingPageDomain + "/landingPage/corpus/" + resourceOmtdId;
	}


	@Override
	protected String generateDistributionLocation(String outputArchiveId) {
		return registryHost + "/request/corpus/download?archiveId=" + outputArchiveId;
	}


	@Override
	protected List<SizeInfo> generateDistributionSizeInfo(Corpus inputCorpus) {
		return inputCorpus.getCorpusInfo().getDatasetDistributionInfo().getSizes();
	}

	
	
}
