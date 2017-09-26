package eu.openminted.registry.generate;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;


import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.util.ISO8601DateFormat;

import eu.openminted.registry.core.domain.Resource;
import eu.openminted.registry.core.service.ParserService;
import eu.openminted.registry.domain.AnnotationInfo;
import eu.openminted.registry.domain.AnnotationLevelEnum;
import eu.openminted.registry.domain.AnnotationsInfo;
import eu.openminted.registry.domain.AttributionText;
import eu.openminted.registry.domain.CommunicationInfo;
import eu.openminted.registry.domain.Component;
import eu.openminted.registry.domain.ContactInfo;
import eu.openminted.registry.domain.Corpus;
import eu.openminted.registry.domain.CorpusInfo;
import eu.openminted.registry.domain.CorpusSubtypeSpecificInfo;
import eu.openminted.registry.domain.DataFormatInfo;
import eu.openminted.registry.domain.DatasetDistributionInfo;
import eu.openminted.registry.domain.Date;
import eu.openminted.registry.domain.DateCombination;
import eu.openminted.registry.domain.Description;
import eu.openminted.registry.domain.DistributionLoc;
import eu.openminted.registry.domain.DistributionMediumEnum;
import eu.openminted.registry.domain.IdentificationInfo;
import eu.openminted.registry.domain.LicenceEnum;
import eu.openminted.registry.domain.LicenceInfo;
import eu.openminted.registry.domain.LicenceInfos;
import eu.openminted.registry.domain.MetadataHeaderInfo;
import eu.openminted.registry.domain.MetadataIdentifier;
import eu.openminted.registry.domain.MetadataIdentifierSchemeNameEnum;
import eu.openminted.registry.domain.Name;
import eu.openminted.registry.domain.PersonInfo;
import eu.openminted.registry.domain.ProcessMode;
import eu.openminted.registry.domain.RelatedResource;
import eu.openminted.registry.domain.ResourceIdentifier;
import eu.openminted.registry.domain.ResourceIdentifierSchemeNameEnum;
import eu.openminted.registry.domain.ResourceName;
import eu.openminted.registry.domain.RightsInfo;
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
    
    public Corpus generateAnnotatedCorpusMetadata(String inputCorpusId, String componentId, String userId, String outputCorpusArchiveId) throws JsonProcessingException  {
    	Corpus corpus = new Corpus();
    	corpus.setMetadataHeaderInfo(generateMetadataHeaderInfo(userId));
    	corpus.setCorpusInfo(generateAnnotatedCorpusInfo(inputCorpusId, componentId, userId, outputCorpusArchiveId));
    	//logger.info("Output corpus metadata::\n " + mapper.writeValueAsString(corpus)+"\n");
    	return corpus;
    }
	
	public CorpusInfo generateAnnotatedCorpusInfo(String inputCorpusId, String componentId, String userId, String outputCorpusArchiveId) throws JsonProcessingException {
	
		// Get input corpus information
		Corpus inputCorpus = corpusService.get(inputCorpusId);		
		//logger.info("Input corpus:\n" + mapper.writeValueAsString(inputCorpus.getCorpusInfo()) +"\n");
		
		// Get component information
		Component component = componentService.get(componentId);
		//logger.info("Component:\n" + mapper.writeValueAsString(component.getComponentInfo()) +"\n");
							
		// CorpusInfo 
		CorpusInfo corpusInfo = new CorpusInfo();
				
		////////////////////////
		// IdentificationInfo
		IdentificationInfo identificationInfo = generateIdentificationInfo(inputCorpus, component);		
        corpusInfo.setIdentificationInfo(identificationInfo);
        //logger.info("Identification Info:\n" + mapper.writeValueAsString(identificationInfo) +"\n");
        
        //////////////////////////
        // ContactInfo
        ContactInfo contactInfo = generateContactInfo(userId);
        corpusInfo.setContactInfo(contactInfo);
        //logger.info("Contact info::\n" + mapper.writeValueAsString(contactInfo) + "\n");
        
        /////////////////////////
        // VersionInfo
        VersionInfo versionInfo = new VersionInfo();
        versionInfo.setVersion("1.0.0");
        corpusInfo.setVersionInfo(versionInfo);
        //logger.info("Version info:\n" + mapper.writeValueAsString(versionInfo)+"\n");
        
    	//////////////////////////
	    // distributionInfo.datasetDistributionInfo
        List<DatasetDistributionInfo> distributionInfos = this.generateDistributionInfos(inputCorpus, component, outputCorpusArchiveId);
        corpusInfo.setDistributionInfos(distributionInfos);
        logger.info("Distribution info:\n" + mapper.writeValueAsString(distributionInfos)+"\n");
        
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
        AnnotationInfo annotationInfo = generateAnnotationInfo(component); 
        annotationsInfo.setAnnotationInfo(annotationInfo);
        //logger.info("AnnotationInfo:\n" + mapper.writeValueAsString(annotationInfo) + "\n");
        
        corpusSubtypeSpecificInfo.setAnnotationsInfo(annotationsInfo);
        //logger.info("CorpusSubtypeSpecificInfo:\n" + mapper.writeValueAsString(corpusSubtypeSpecificInfo) + "\n");
        corpusInfo.setCorpusSubtypeSpecificInfo(corpusSubtypeSpecificInfo);             
		       
		return corpusInfo;
	}
	
	private String getInputCorpusName(Corpus inputCorpus) {
		String inputCorpusName = getEnglishResourceName(inputCorpus.getCorpusInfo().getIdentificationInfo().getResourceNames());
		return inputCorpusName;
	}
	
	private String getComponentName(Component component) {
		String componentName = getEnglishResourceName(component.getComponentInfo().getIdentificationInfo().getResourceNames());
		return componentName;
	}
	
	
	private String getEnglishResourceName(List<ResourceName> resourceNames) {
		
		String resourceName = resourceNames.get(0).getValue();
		for (int i = 0; i < resourceNames.size(); i++) {
			if (resourceNames.get(i).getLang().equals("en")) {
				resourceName = resourceNames.get(i).getValue();
			}
		}
		
		return resourceName;
	}
	
	private String getEnglishDescription(List<Description> resourceNames) {
			
			String resourceName = resourceNames.get(0).getValue();
			for (int i = 0; i < resourceNames.size(); i++) {
				if (resourceNames.get(i).getLang().equals("en")) {
					resourceName = resourceNames.get(i).getValue();
				}
			}
			
			return resourceName;
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
	
	private IdentificationInfo generateIdentificationInfo(Corpus inputCorpus, Component component) {
		
		String inputCorpusDescription = getEnglishDescription(inputCorpus.getCorpusInfo().getIdentificationInfo().getDescriptions());		  
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
		// TODO in OMTD-Share v2.0.2 schema should be OMTD
		resourceIdentifier.setResourceIdentifierSchemeName(ResourceIdentifierSchemeNameEnum.OTHER);
		identificationInfo.getResourceIdentifiers().add(resourceIdentifier);
		
		return identificationInfo;
	}
	
	/*
	 * Set the contact information of the annotated corpus as the user
	 * that run the workflow
	 */
	private ContactInfo generateContactInfo(String userId) {		
		ContactInfo contactInfo = new ContactInfo();
		List<PersonInfo> contactPersons = new ArrayList<>();
		
		PersonInfo contactPerson = generatePersonInfo(userId);
		contactPersons.add(contactPerson);
		contactInfo.setContactPersons(contactPersons);
		return contactInfo;		
	}
	
	private PersonInfo generatePersonInfo(String userId) {
		PersonInfo personInfo = new PersonInfo();
		
		// TODO find user information given userId		
		
		// User's name
		List<Name> names = new ArrayList<>();
		Name name = new Name();
		name.setValue("Katerina Gkirtzou");
		name.setLang("en");
		names.add(name);
		personInfo.setNames(names);
		
		// User's communication info
		CommunicationInfo  communicationInfo = new CommunicationInfo();
		List<String> emails = new ArrayList<>();
		emails.add("katerina.gkirtzou@ilsp.gr");
		communicationInfo.setEmails(emails);		
		personInfo.setCommunicationInfo(communicationInfo);
		return personInfo;
		
	}
	
	private  List<DatasetDistributionInfo> generateDistributionInfos(Corpus inputCorpus, Component component, String outputCorpusArchiveId) {
		
	    List<DatasetDistributionInfo> distributionInfos = new ArrayList<>();
	    DatasetDistributionInfo datasetDistributionInfo = new DatasetDistributionInfo();
	   
	    // distributionInfo.datasetDistributionInfo.distributionLoc
	    DistributionLoc distributionLoc = new DistributionLoc();
	    distributionLoc.setDistributionMedium(DistributionMediumEnum.DOWNLOADABLE);
	    distributionLoc.setDistributionLocation(registryHost + "/request/corpus/download?archiveId=" + outputCorpusArchiveId);
	    datasetDistributionInfo.getDistributionLoc().add(distributionLoc);
	   
	
	    // distributionInfo.datasetDistributionInfo.rightsInfo
	    RightsInfo rightsInfo = new RightsInfo();
	    List<LicenceInfos> licenceInfosList = new ArrayList<>();
	    LicenceInfos licenceInfos = new LicenceInfos();
	    List<LicenceInfo> licenceInfoList = new ArrayList<>();
	    
	    // TODO replace licence CC0 to correct value when known.
	    // TODO If licence change attribution text should change as well
	    LicenceInfo licenceInfo = new LicenceInfo();
	    licenceInfo.setLicence(LicenceEnum.CC0_1_0);
	    
	    licenceInfoList.add(licenceInfo);
	    licenceInfos.setLicenceInfo(licenceInfoList);
	    licenceInfosList.add(licenceInfos);
	    rightsInfo.setLicenceInfos(licenceInfosList);
	    datasetDistributionInfo.setRightsInfo(rightsInfo);	
	    	    	  
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
	    
	    String licenceName = "";
	    Iterator<LicenceInfo> iterLicence = licenceInfoList.iterator();
		while (iterLicence.hasNext()) {
			
	    	licenceName += iterLicence.next().getLicence().toString();
	    	if (iterLicence.hasNext()) {
				licenceName +=  ", ";
			}
	    }
	    licenceInfo.getLicence().toString();
	    attributionTextDescription = attributionTextDescription.replaceAll("\\[licence_name\\]", 
	    		licenceName);	     	  
	    
	    
	    AttributionText attributionText = new AttributionText();
	    attributionText.setLang("en");
	    attributionText.setValue(attributionTextDescription);
	    List<AttributionText> attributionTextsInfo = new ArrayList<>();
	    attributionTextsInfo.add(attributionText);
	    datasetDistributionInfo.setAttributionTexts(attributionTextsInfo);
	  
	    distributionInfos.add(datasetDistributionInfo);
	    return distributionInfos;
	}
	
	private AnnotationInfo generateAnnotationInfo(Component component) {
		
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
		// TODO Component output resource info may have multiple annotation levels 
		// while annotated corpus has one
		List<AnnotationLevelEnum> annotationLevel = component.getComponentInfo().getOutputResourceInfo().getAnnotationLevels();
		if ( annotationLevel != null && annotationLevel.size() != 0 ) {
			annotationInfo.setAnnotationLevel(annotationLevel.get(0));
		}
		
		// TODO annotation standoff missing information? Where do we get this?
		// corpusSubtypeSpecificationInfo.annotationsInfo.annotationInfo.annotationStandoff
		
		// corpusSubtypeSpecificationInfo.annotationsInfo.annotationInfo.dataFormatInfo
		// TODO Component output resource info may have multiple annotation levels 
		// while annotated corpus has one 		
		List<DataFormatInfo> dataFormat = component.getComponentInfo().getOutputResourceInfo().getDataFormats();
		if ( dataFormat != null && dataFormat.size() != 0 ) {
			annotationInfo.setDataFormatInfo(dataFormat.get(0));
		}
				
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
	
	 public MetadataHeaderInfo generateMetadataHeaderInfo(String userId){
		 
		 	MetadataHeaderInfo metadataHeaderInfo = new MetadataHeaderInfo();
	
		 	// Set creation date and last date updated
		 	GregorianCalendar gregory = new GregorianCalendar();
	        gregory.setTime(new java.util.Date());
	        XMLGregorianCalendar calendar = null;
	        try {
	            calendar = DatatypeFactory.newInstance().newXMLGregorianCalendar(gregory);
	        } catch (DatatypeConfigurationException e) {
	            e.printStackTrace();
	        }
	        metadataHeaderInfo.setMetadataCreationDate(calendar);
	        metadataHeaderInfo.setMetadataLastDateUpdated(calendar);
	        
	        // Set metadata record identifier
	        if(metadataHeaderInfo.getMetadataRecordIdentifier() == null) {
	            MetadataIdentifier identifier = new MetadataIdentifier();
	            identifier.setValue(UUID.randomUUID().toString());
	    		// TODO in OMTD-Share v2.0.2 schema should be OMTD
	            identifier.setMetadataIdentifierSchemeName(MetadataIdentifierSchemeNameEnum.OTHER);
	            metadataHeaderInfo.setMetadataRecordIdentifier(identifier);
	        }

	        // Set metadata creator
	        metadataHeaderInfo.setMetadataCreators(new ArrayList<PersonInfo>());
	        PersonInfo personInfo = generatePersonInfo(userId);
	        metadataHeaderInfo.getMetadataCreators().add(personInfo);
	        
	        return metadataHeaderInfo;
	    }
}
