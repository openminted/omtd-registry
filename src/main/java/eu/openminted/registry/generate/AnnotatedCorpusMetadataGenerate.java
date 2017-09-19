package eu.openminted.registry.generate;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.util.ISO8601DateFormat;

import eu.openminted.registry.domain.AnnotationInfo;
import eu.openminted.registry.domain.AnnotationLevelEnum;
import eu.openminted.registry.domain.AnnotationsInfo;
import eu.openminted.registry.domain.AttributionText;
import eu.openminted.registry.domain.Component;
import eu.openminted.registry.domain.ContactInfo;
import eu.openminted.registry.domain.Corpus;
import eu.openminted.registry.domain.CorpusInfo;
import eu.openminted.registry.domain.CorpusSubtypeSpecificInfo;
import eu.openminted.registry.domain.DatasetDistributionInfo;
import eu.openminted.registry.domain.Date;
import eu.openminted.registry.domain.DateCombination;
import eu.openminted.registry.domain.Description;
import eu.openminted.registry.domain.DistributionLoc;
import eu.openminted.registry.domain.DistributionMediumEnum;
import eu.openminted.registry.domain.IdentificationInfo;
import eu.openminted.registry.domain.PersonInfo;
import eu.openminted.registry.domain.ProcessMode;
import eu.openminted.registry.domain.RelatedResource;
import eu.openminted.registry.domain.ResourceIdentifier;
import eu.openminted.registry.domain.ResourceIdentifierSchemeNameEnum;
import eu.openminted.registry.domain.ResourceName;
import eu.openminted.registry.domain.VersionInfo;
import eu.openminted.registry.service.ComponentServiceImpl;
import eu.openminted.registry.service.CorpusServiceImpl;


@org.springframework.stereotype.Component
public class AnnotatedCorpusMetadataGenerate {

	static final Logger logger = Logger.getLogger(AnnotatedCorpusMetadataGenerate.class);
	
	@Autowired 
	private CorpusServiceImpl corpusService;
	
	@Autowired 
	private ComponentServiceImpl componentService;
		
    private ObjectMapper mapper;
    
    @org.springframework.beans.factory.annotation.Value("${registry.host}")
    private String registryHost;

       
    public AnnotatedCorpusMetadataGenerate() {    
    	mapper = new ObjectMapper();
     	mapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
     	mapper.setDateFormat(new ISO8601DateFormat());
     	
    }
	
	public Corpus createMetadataOutputCorpus(String inputCorpusId, String componentId, String userId, String outputCorpusArchiveId) throws JsonProcessingException {
	
		// Get input corpus information
		Corpus inputCorpus = corpusService.get(inputCorpusId);		
		// Get component information
		Component component = componentService.get(componentId);
					
		Corpus outputCorpus = new Corpus();		
		// CorpusInfo 
		CorpusInfo corpusInfo = new CorpusInfo();
				
		////////////////////////
		// IdentificationInfo
		IdentificationInfo identificationInfo = this.createIdentificationInfo(inputCorpus, component);
        logger.info("Identification Info:\n" + mapper.writeValueAsString(identificationInfo) +"\n");        
        corpusInfo.setIdentificationInfo(identificationInfo);
        
        //////////////////////////
        // ContactInfo
        ContactInfo contactInfo = createContactInfo(userId);
        logger.info("Contact info::\n" + mapper.writeValueAsString(contactInfo) + "\n");
        corpusInfo.setContactInfo(contactInfo);
        
        /////////////////////////
        // VersionInfo
        VersionInfo versionInfo = new VersionInfo();
        versionInfo.setVersion("1.0.0");
        logger.info("Version info:\n" + mapper.writeValueAsString(versionInfo)+"\n");
        corpusInfo.setVersionInfo(versionInfo);
        
    	//////////////////////////
	    // distributionInfo.datasetDistributionInfo
        List<DatasetDistributionInfo> distributionInfos = this.createDistributionInfos(inputCorpus, component, outputCorpusArchiveId);
        logger.info("Distribution info:\n" + mapper.writeValueAsString(distributionInfos)+"\n");
        corpusInfo.setDistributionInfos(distributionInfos);
        
        ///////////////////////////
        // corpusSubtypeSpecificationInfo.annotationsInfo
        CorpusSubtypeSpecificInfo corpusSubtypeSpecificInfo = new CorpusSubtypeSpecificInfo();
        AnnotationsInfo annotationsInfo = new AnnotationsInfo();
        //  corpusSubtypeSpecificationInfo.annotationsInfo.rawCorpus
        RelatedResource rawCorpus = new RelatedResource();
        rawCorpus.setResourceIdentifiers(inputCorpus.getCorpusInfo().getIdentificationInfo().getResourceIdentifiers());
        rawCorpus.setResourceNames(inputCorpus.getCorpusInfo().getIdentificationInfo().getResourceNames());
        annotationsInfo.setRawCorpus(rawCorpus);
        
        //  corpusSubtypeSpecificationInfo.annotationsInfo.annotationInfo
        AnnotationInfo annotationInfo = createAnnotationInfo(component); 
        annotationsInfo.setAnnotationInfo(annotationInfo);
        logger.info("AnnotationInfo:\n" + mapper.writeValueAsString(annotationInfo) + "\n");
        
        corpusSubtypeSpecificInfo.setAnnotationsInfo(annotationsInfo);
        
        logger.info("CorpusSubtypeSpecificInfo:\n" + mapper.writeValueAsString(corpusSubtypeSpecificInfo) + "\n");
        corpusInfo.setCorpusSubtypeSpecificInfo(corpusSubtypeSpecificInfo);             
		outputCorpus.setCorpusInfo(corpusInfo);
        
		logger.info("Output corpus::\n " + mapper.writeValueAsString(outputCorpus)+"\n");
		return outputCorpus;
	}
	
	private String getInputCorpusName(Corpus inputCorpus) {
		// TODO get english language resource names, not the first one 
		String inputCorpusName = inputCorpus.getCorpusInfo().getIdentificationInfo().getResourceNames().get(0).getValue();
		return inputCorpusName;
	}
	
	private String getComponentName(Component component) {
		// TODO get english language resource names, not the first one
		String componentName = component.getComponentInfo().getIdentificationInfo().getResourceNames().get(0).getValue();
		return componentName;
	}
	
	private String getComponentVersion(Component component) {
		String componentVersion = component.getComponentInfo().getVersionInfo().getVersion();
		if (componentVersion == null) {			
			componentVersion = component.getComponentInfo().getVersionInfo().getVersionDate();
		}		
		return componentVersion;
	}
	
	private String getCorpusName(Corpus inputCorpus, Component component) {
		String corpusName = "[raw_corpus_name] processed by [component_name]";
		corpusName = corpusName.replaceAll("\\[raw_corpus_name\\]", 
				getInputCorpusName(inputCorpus));			
		corpusName = corpusName .replaceAll("\\[component_name\\]", 
				getComponentName(component));
									
		return corpusName;
	}	
	
	private IdentificationInfo createIdentificationInfo(Corpus inputCorpus, Component component) {
		
		String inputCorpusDescription = inputCorpus.getCorpusInfo().getIdentificationInfo().getDescriptions().get(0).getValue();		  
		String descriptionDescription  =  "[raw_corpus_name] processed by [component_name]." +
					"[raw_corpus_description]. Τhe corpus has processed by [component_name] " +
					"version [component_version] at annotation " +
					"level [annotation_level_of_component]."; 

		    
		
		IdentificationInfo identificationInfo = new IdentificationInfo();
		
		// identificationInfo.resourceNames.resourceName		
		identificationInfo.setResourceNames(new ArrayList<>());
				
		ResourceName resourceName = new ResourceName();	
		resourceName.setLang("en");
		resourceName.setValue(getCorpusName(inputCorpus, component));
		identificationInfo.getResourceNames().add(resourceName);
		
		// identificationInfo.descriptions.description
		descriptionDescription = descriptionDescription.replaceAll("\\[raw_corpus_name\\]", 
			getInputCorpusName(inputCorpus));
		descriptionDescription = descriptionDescription.replaceAll("\\[raw_corpus_description\\]", 
			inputCorpusDescription);
		descriptionDescription = descriptionDescription.replaceAll("\\[component_name\\]", 
			getComponentName(component));
		
		descriptionDescription = descriptionDescription.replaceAll("\\[component_version\\]", 
				getComponentVersion(component));
		List<AnnotationLevelEnum>  annotationLevels = component.getComponentInfo().getOutputResourceInfo().getAnnotationLevels();
		String annotationLevelsDescription = "";
		Iterator<AnnotationLevelEnum> iterAnnotation = annotationLevels.iterator();
		while (iterAnnotation.hasNext()) {
			annotationLevelsDescription +=  iterAnnotation.next().value();
			if (iterAnnotation.hasNext()) {
				annotationLevelsDescription +=  ", ";
			}
		}
		
		descriptionDescription = descriptionDescription.replaceAll("\\[annotation_level_of_component\\]", 			
				annotationLevelsDescription);					
		
		identificationInfo.setDescriptions(new ArrayList<>());
		Description description = new Description();
		description.setLang("en");
		description.setValue(descriptionDescription);
		identificationInfo.getDescriptions().add(description);
		
		// identificationInfo.resourceIdentifiers.resourceIdentifier
		ResourceIdentifier resourceIdentifier = new ResourceIdentifier();
		resourceIdentifier.setValue(UUID.randomUUID().toString());
		resourceIdentifier.setResourceIdentifierSchemeName(ResourceIdentifierSchemeNameEnum.OTHER);
		identificationInfo.getResourceIdentifiers().add(resourceIdentifier);
		
		return identificationInfo;
	}
	
	private ContactInfo createContactInfo(String userId) {
		ContactInfo contactInfo = new ContactInfo();
		List<PersonInfo> contactPersons = new ArrayList<>();
		PersonInfo contactPerson = new PersonInfo();
		
		contactPersons.add(contactPerson);
		contactInfo.setContactPersons(contactPersons);
		return contactInfo;		
	}
	
	private  List<DatasetDistributionInfo> createDistributionInfos(Corpus inputCorpus, Component component, String outputCorpusArchiveId) {
		
	    List<DatasetDistributionInfo> distributionInfos = new ArrayList<>();
	    DatasetDistributionInfo datasetDistributionInfo = new DatasetDistributionInfo();
	   
	    // distributionInfo.datasetDistributionInfo.distributionLoc
	    DistributionLoc distributionLoc = new DistributionLoc();
	    distributionLoc.setDistributionMedium(DistributionMediumEnum.DOWNLOADABLE);
	    distributionLoc.setDistributionLocation(registryHost + "/omtd-registry/request/corpus/download?archiveId=" + outputCorpusArchiveId);
	    datasetDistributionInfo.getDistributionLoc().add(distributionLoc);
	                   
	    // distributionInfo.datasetDistributionInfo.attributionTexts.attributionText
	    String  attributionTextDescription  =  "The proceesing of \"[annotated_corpus_name]\" has been enabled by the " +
	    		"OpenMinTed Infrastucture with the [component_name] " +
	    		"version [component_version]. The corpus is licenced by [licence_name]";
	    attributionTextDescription = attributionTextDescription.replaceAll("\\[annotated_corpus_name\\]", 
	    		getCorpusName(inputCorpus, component));
	    attributionTextDescription = attributionTextDescription.replaceAll("\\[component_name\\]", 
	    		getComponentName(component));
	    attributionTextDescription = attributionTextDescription.replaceAll("\\[component_version\\]", 
	    		getComponentVersion(component));
	    
	    // TODO replace licence when known.
	    
	    
	    AttributionText attributionText = new AttributionText();
	    attributionText.setLang("en");
	    attributionText.setValue(attributionTextDescription);
	    List<AttributionText> attributionTextsInfo = new ArrayList<>();
	    attributionTextsInfo.add(attributionText);
	    datasetDistributionInfo.setAttributionTexts(attributionTextsInfo);
	  
	    distributionInfos.add(datasetDistributionInfo);
	    return distributionInfos;
	}
	
	private AnnotationInfo createAnnotationInfo(Component component) {
		
		AnnotationInfo annotationInfo = new AnnotationInfo(); 
		
		// corpusSubtypeSpecificationInfo.annotationsInfo.annotationInfo.annotationMode
		annotationInfo.setAnnotationMode(ProcessMode.AUTOMATIC);  
		
		// corpusSubtypeSpecificationInfo.annotationsInfo.annotationInfo.annotationDate
		Date annotationDate = new Date();
		// Set year- month- day from current date
		java.util.Date currentDate = new java.util.Date();
		Calendar calendar = new GregorianCalendar();
		calendar.setTime(currentDate);
		int year = calendar.get(Calendar.YEAR);
		annotationDate.setYear(year);
		//Add one to month {0 - 11}
		int month = calendar.get(Calendar.MONTH) + 1;
		annotationDate.setMonth(new Integer(month));
		int day = calendar.get(Calendar.DAY_OF_MONTH);
		annotationDate.setDay(new Integer(day));
		DateCombination date = new DateCombination();
		date.setDate(annotationDate);
		annotationInfo.setAnnotationDate(date);
		
		// corpusSubtypeSpecificationInfo.annotationsInfo.annotationInfo.annotationLevel
		//annotationInfo.setAnnotationLevel(component.getComponentInfo().getOutputResourceInfo().getAnnotationLevels());
		//annotationInfo.setDataFormatInfo(component.getComponentInfo().getOutputResourceInfo().getd);
	
		// corpusSubtypeSpecificationInfo.annotationsInfo.annotationInfo.annotationStandoff
		
		// corpusSubtypeSpecificationInfo.annotationsInfo.annotationInfo.dataFormatInfo
		//annotationInfo.setDataFormatInfo(value);
		//component.getComponentInfo().getOutputResourceInfo().getDataFormats()
		
		// corpusSubtypeSpecificationInfo.annotationsInfo.annotationInfo.typesystem
		annotationInfo.setTypesystem(component.getComponentInfo().getOutputResourceInfo().getTypesystem());
		
		// corpusSubtypeSpecificationInfo.annotationsInfo.annotationInfo.annotationSchema
		annotationInfo.setAnnotationSchema(component.getComponentInfo().getOutputResourceInfo().getAnnotationSchema());
		
		//  corpusSubtypeSpecificationInfo.annotationsInfo.annotationInfo.annotationResource
		annotationInfo.setAnnotationResource(component.getComponentInfo().getOutputResourceInfo().getAnnotationResource());
		  
		// corpusSubtypeSpecificationInfo.annotationsInfo.annotationInfo.isAnnotatedBy
		List<RelatedResource> annotatedByResources = new ArrayList<>();
		RelatedResource annotatedByComponent = new RelatedResource();
		annotatedByComponent.setResourceIdentifiers(component.getComponentInfo().getIdentificationInfo().getResourceIdentifiers());
		annotatedByComponent.setResourceNames(component.getComponentInfo().getIdentificationInfo().getResourceNames());
		annotatedByResources.add(annotatedByComponent);
		annotationInfo.setIsAnnotatedBy(annotatedByResources);
		
		
		return annotationInfo;      
		  
	}
}
