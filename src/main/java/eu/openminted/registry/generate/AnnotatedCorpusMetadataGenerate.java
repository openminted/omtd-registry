package eu.openminted.registry.generate;

import java.util.ArrayList;
import java.util.GregorianCalendar;
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

import eu.openminted.registry.domain.ActorInfo;
import eu.openminted.registry.domain.ActorTypeEnum;
import eu.openminted.registry.domain.AnnotatedCorpusInfo;
import eu.openminted.registry.domain.AnnotationInfo;
import eu.openminted.registry.domain.AnnotationTypeInfo;
import eu.openminted.registry.domain.AnnotationTypeType;
import eu.openminted.registry.domain.CharacterEncodingEnum;
import eu.openminted.registry.domain.CharacterEncodingInfo;
import eu.openminted.registry.domain.CommunicationInfo;
import eu.openminted.registry.domain.Component;
import eu.openminted.registry.domain.ContactInfo;
import eu.openminted.registry.domain.ContactTypeEnum;
import eu.openminted.registry.domain.Corpus;
import eu.openminted.registry.domain.CorpusInfo;
import eu.openminted.registry.domain.CorpusSubtypeSpecificInfo;
import eu.openminted.registry.domain.DataFormatInfo;
import eu.openminted.registry.domain.DataFormatType;
import eu.openminted.registry.domain.DatasetDistributionInfo;
import eu.openminted.registry.domain.Date;
import eu.openminted.registry.domain.DateCombination;
import eu.openminted.registry.domain.Description;
import eu.openminted.registry.domain.DistributionMediumEnum;
import eu.openminted.registry.domain.DomainInfo;
import eu.openminted.registry.domain.GeographicCoverageInfo;
import eu.openminted.registry.domain.GroupName;
import eu.openminted.registry.domain.IdentificationInfo;
import eu.openminted.registry.domain.LanguageInfo;
import eu.openminted.registry.domain.LicenceEnum;
import eu.openminted.registry.domain.LicenceInfo;
import eu.openminted.registry.domain.LingualityInfo;
import eu.openminted.registry.domain.MetadataHeaderInfo;
import eu.openminted.registry.domain.MetadataIdentifier;
import eu.openminted.registry.domain.MetadataIdentifierSchemeNameEnum;
import eu.openminted.registry.domain.OrganizationName;
import eu.openminted.registry.domain.PersonInfo;
import eu.openminted.registry.domain.ProcessMode;
import eu.openminted.registry.domain.RelatedResource;
import eu.openminted.registry.domain.RelationInfo;
import eu.openminted.registry.domain.RelationTypeEnum;
import eu.openminted.registry.domain.ResourceCreationInfo;
import eu.openminted.registry.domain.ResourceIdentifier;
import eu.openminted.registry.domain.ResourceIdentifierSchemeNameEnum;
import eu.openminted.registry.domain.ResourceName;
import eu.openminted.registry.domain.RightsInfo;
import eu.openminted.registry.domain.RightsStatementEnum;
import eu.openminted.registry.domain.TextClassificationInfo;
import eu.openminted.registry.domain.TextFormatInfo;
import eu.openminted.registry.domain.TimeCoverageInfo;
import eu.openminted.registry.domain.VersionInfo;
import eu.openminted.registry.service.ComponentServiceImpl;
import eu.openminted.registry.service.CorpusServiceImpl;
import org.springframework.beans.factory.annotation.Value;


/*
 * Generator for annotated corpus when a workflow ends successfully at the
 * workflow engine.
 */

@org.springframework.stereotype.Component
public class AnnotatedCorpusMetadataGenerate {

	static final Logger logger = Logger.getLogger(AnnotatedCorpusMetadataGenerate.class);
	
	@Autowired 
	private CorpusServiceImpl corpusService;
	
	@Autowired 
	private ComponentServiceImpl componentService;
		
    @Value("${registry.host}")
    private String registryHost;

    @Value("${webapp.front}/landingPage/corpus/")
    private String landingPageDomain;
    
    private GregorianCalendar gregory;
    
    private ObjectMapper mapper;
         
    public AnnotatedCorpusMetadataGenerate() {    
    	mapper = new ObjectMapper();
     	mapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
     	mapper.setDateFormat(new ISO8601DateFormat());
        gregory = new GregorianCalendar();
        gregory.setTime(new java.util.Date());       
     	
    }
    
    public Corpus generateAnnotatedCorpusMetadata(String inputCorpusId, String componentId, String userId, String outputCorpusArchiveId) throws JsonProcessingException  {
    	Corpus corpus = new Corpus();
    	corpus.setMetadataHeaderInfo(generateMetadataHeaderInfo(userId));
    	String corpusOmtdId = corpus.getMetadataHeaderInfo().getMetadataRecordIdentifier().getValue();
    	corpus.setCorpusInfo(generateAnnotatedCorpusInfo(corpusOmtdId, inputCorpusId, componentId, userId, outputCorpusArchiveId));
    	//logger.info("Output corpus metadata::\n " + mapper.writeValueAsString(corpus)+"\n");
    	return corpus;
    }
	
	public CorpusInfo generateAnnotatedCorpusInfo(String corpusOmtdId, String inputCorpusId, String componentId, String userId, String outputCorpusArchiveId) throws JsonProcessingException {
	
		// Get input corpus information
		logger.info("Retrieving input corpus " + inputCorpusId);
		Corpus inputCorpus = corpusService.get(inputCorpusId);		
		//logger.info("Input corpus:\n" + mapper.writeValueAsString(inputCorpus.getCorpusInfo()) +"\n");
		
		// Get component information
		logger.info("Retrieving component " + componentId);
		Component component = componentService.get(componentId);
		//logger.info("Component:\n" + mapper.writeValueAsString(component.getComponentInfo()) +"\n");
							
		// CorpusInfo 
		CorpusInfo corpusInfo = new CorpusInfo();
				
		////////////////////////
		// IdentificationInfo
		IdentificationInfo identificationInfo = generateIdentificationInfo(inputCorpus, component);		
        corpusInfo.setIdentificationInfo(identificationInfo);
        //logger.info("Identification Info:\n" + mapper.writeValueAsString(identificationInfo) +"\n");
        
        
        /////////////////////////
        // VersionInfo
        VersionInfo versionInfo = new VersionInfo();
        versionInfo.setVersion("0.0.1");
        corpusInfo.setVersionInfo(versionInfo);
        //logger.info("Version info:\n" + mapper.writeValueAsString(versionInfo)+"\n");
        
        //////////////////////////
        // ContactInfo
        ContactInfo contactInfo = generateContactInfo(userId, corpusOmtdId);
        corpusInfo.setContactInfo(contactInfo);
        //logger.info("Contact info::\n" + mapper.writeValueAsString(contactInfo) + "\n");
        
    	//////////////////////////
	    // datasetDistributionInfo
        DatasetDistributionInfo datasetDistributionInfo = generateDatasetDistributionInfo(inputCorpus, component, outputCorpusArchiveId);
        corpusInfo.setDatasetDistributionInfo(datasetDistributionInfo);
        //logger.info("Distribution info:\n" + mapper.writeValueAsString(datasetDistributionInfo)+"\n");
        
        //////////////////////////
        // rightsInfo
        RightsInfo rightsInfo = generateRightsInfo(inputCorpus, component);
        corpusInfo.setRightsInfo(rightsInfo);
        //logger.info("Rights info:\n" + mapper.writeValueAsString(rightsInfo) + "\n");    
       
        //////////////////////////
        // resourceCreationInfo
        ResourceCreationInfo resourceCreationInfo = generateResourceCreationInfo(userId);
        corpusInfo.setResourceCreationInfo(resourceCreationInfo);
        //logger.info("Resource Creation info::\n" + mapper.writeValueAsString(resourceCreationInfo) + "\n");
        
        //////////////////////////
        // relations.relationInfo
        List<RelationInfo> relations = new ArrayList<>(); 
        RelationInfo relationInfo = generateRelationInfo(inputCorpus);
        relations.add(relationInfo);
        corpusInfo.setRelations(relations);
        //logger.info("Resource Relation info::\n" + mapper.writeValueAsString(relationInfo) + "\n");                
       
        ///////////////////////////
        // corpusSubtypeSpecificationInfo.annotatedCorpusInfo
        CorpusSubtypeSpecificInfo corpusSubtypeSpecificInfo = new CorpusSubtypeSpecificInfo();

        AnnotatedCorpusInfo annotatedCorpusInfo = generateAnnotatedCorpusInfo(inputCorpus, component);        		           
        corpusSubtypeSpecificInfo.setAnnotatedCorpusInfo(annotatedCorpusInfo);
        //logger.info("CorpusSubtypeSpecificInfo:\n" + mapper.writeValueAsString(corpusSubtypeSpecificInfo) + "\n");
        corpusInfo.setCorpusSubtypeSpecificInfo(corpusSubtypeSpecificInfo);             
		       
		return corpusInfo;
	}
	
	private AnnotatedCorpusInfo generateAnnotatedCorpusInfo(Corpus inputCorpus, Component component) throws JsonProcessingException {
		
		AnnotatedCorpusInfo annotatedCorpusInfo = new AnnotatedCorpusInfo();
        
        // corpusSubtypeSpecificationInfo.annotatedCorpusInfo.lingualityInfo
        LingualityInfo lingualityInfo = inputCorpus.getCorpusInfo().getCorpusSubtypeSpecificInfo().getRawCorpusInfo().getLingualityInfo();
        annotatedCorpusInfo.setLingualityInfo(lingualityInfo);
		
        // corpusSubtypeSpecificationInfo.annotatedCorpusInfo.languages
        List<LanguageInfo> languages = inputCorpus.getCorpusInfo().getCorpusSubtypeSpecificInfo().getRawCorpusInfo().getLanguages();
        annotatedCorpusInfo.setLanguages(languages);
       	
		// corpusSubtypeSpecificationInfo.annotatedCorpusInfo.annotations.annotationInfo
		List<AnnotationInfo> annotations = new ArrayList<>();
		AnnotationInfo annotationInfo = new AnnotationInfo();
		
		if (component.getComponentInfo().getOutputResourceInfo() != null) {
			// annotatationInfo.annotationTypes
			List<AnnotationTypeInfo> annotationTypes = component.getComponentInfo().getOutputResourceInfo().getAnnotationTypes();
			// TODO Added a dummy node just for passing validation of add in registry 	
			if (annotationTypes.size() == 0) { 
				AnnotationTypeInfo annotationTypeInfo = new AnnotationTypeInfo();
				annotationTypeInfo.setAnnotationType(AnnotationTypeType.LEMMA);		
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
		annotatedCorpusInfo.setAnnotations(annotations);

		//logger.info("Annotations " + mapper.writeValueAsString(annotationInfo) + "\n");
			
		// corpusSubtypeSpecificationInfo.annotatedCorpusInfo.textClassifications
		List<TextClassificationInfo> textClassifications = inputCorpus.getCorpusInfo().getCorpusSubtypeSpecificInfo().getRawCorpusInfo().getTextClassifications();
		annotatedCorpusInfo.setTextClassifications(textClassifications);
		
		// corpusSubtypeSpecificationInfo.annotatedCorpusInfo.domains
		List<DomainInfo> domains = inputCorpus.getCorpusInfo().getCorpusSubtypeSpecificInfo().getRawCorpusInfo().getDomains();
		annotatedCorpusInfo.setDomains(domains);
		
		// corpusSubtypeSpecificationInfo.annotatedCorpusInfo.timeClassifications
		List<TimeCoverageInfo> timeClassifications = inputCorpus.getCorpusInfo().getCorpusSubtypeSpecificInfo().getRawCorpusInfo().getTimeClassifications();
		annotatedCorpusInfo.setTimeClassifications(timeClassifications);
		
		// corpusSubtypeSpecificationInfo.annotatedCorpusInfo.geographicClassifications
		List<GeographicCoverageInfo> geographicClassifications = inputCorpus.getCorpusInfo().getCorpusSubtypeSpecificInfo().getRawCorpusInfo().getGeographicClassifications();
		annotatedCorpusInfo.setGeographicClassifications(geographicClassifications);
		                
		return annotatedCorpusInfo;
	}

	private RightsInfo generateRightsInfo(Corpus inputCorpus, Component component) {

		RightsInfo rightsInfo = new RightsInfo();
		
		// rightsInfo.licenceInfos.licenceInfo
		List<LicenceInfo> licenceInfos = new ArrayList<>();
		// TODO that license CC0 is chosen by default to avoid validation error
		// User must select the appropriate license.
		LicenceInfo licenceInfo = new LicenceInfo();
		licenceInfo.setLicence(LicenceEnum.CC0_1_0);			
		licenceInfos.add(licenceInfo);
		rightsInfo.setLicenceInfos(licenceInfos);
		
		// rightsInfo.rightsStatement
		// TODO that right statement restricted access is chosen by default to avoid validation error
		// User must select the appropriate right statement.
		rightsInfo.setRightsStatement(RightsStatementEnum.RESTRICTED_ACCESS);
		
		// rightsInfo.attributionText
		// TODO replace <annotated_corpus_licence when user selects the correct licence.
		String  attributionText  =  "The processing of <input_corpus_name>(by <input_corpus_creator_name>) " +
	       "performed under <input_corpus_licence> has been enabled by the OpenMinTeD infrastructure " +
	       "using the <component_name>. <annotated_corpus_name> is licensed under " +
	       "<annotated_corpus_licence>.";
		attributionText = attributionText.replaceAll("<input_corpus_name>", 
				getInputCorpusName(inputCorpus));
		String inputCorpusCreatorName = getInputCorpusCreatorName(inputCorpus);
		if (inputCorpusCreatorName != null) {
			attributionText = attributionText.replaceAll("<input_corpus_creator_name>",
					inputCorpusCreatorName);
		}
		else {
			attributionText = attributionText.replaceAll("\\(by <input_corpus_creator_name>\\)",
					"");
		}
		attributionText = attributionText.replaceAll("<input_corpus_licence>", 
				getInputCorpusLicence(inputCorpus));
		attributionText = attributionText.replaceAll("<component_name>",
				getComponentName(component));
		attributionText = attributionText.replaceAll("<annotated_corpus_name>",
				getCorpusName(inputCorpus, component));
		
	
		rightsInfo.setAttributionText(attributionText);
		
		return rightsInfo;
	}

	private String getInputCorpusCreatorName(Corpus inputCorpus) {
		String creatorsName = null;
		if (inputCorpus.getCorpusInfo().getResourceCreationInfo() != null ) {
			List<ActorInfo> creatorsList = inputCorpus.getCorpusInfo().getResourceCreationInfo().getResourceCreators();
			//logger.info("Creators list has size " + creatorsList.size());
			creatorsName = "";
			for (int i = 0; i < creatorsList.size(); i++) {
				if (creatorsList.get(i).getRelatedPerson() != null) {
					creatorsName += creatorsList.get(i).getRelatedPerson().getSurname();
					//logger.info("Creators name : " + creatorsName);
					if (creatorsList.get(i).getRelatedPerson().getGivenName() != null) {
						creatorsName += " " + creatorsList.get(i).getRelatedPerson().getGivenName();
						//logger.info("Creators name : " + creatorsName);
					}
				}
				else if(creatorsList.get(i).getRelatedGroup() != null) {
					List<GroupName> relatedGroups = creatorsList.get(i).getRelatedGroup().getGroupNames();
					for (int j = 0; j < relatedGroups.size(); j++) {
						creatorsName += relatedGroups.get(j).getValue();
						if (j+1 != relatedGroups.size()) {
							creatorsName += ", ";
						} 						
					}					
				}
				else if (creatorsList.get(i).getRelatedOrganization() != null) {
					List<OrganizationName> organizationsName = creatorsList.get(i).getRelatedOrganization().getOrganizationNames();
					for (int j = 0; j < organizationsName.size(); j++) {
						creatorsName += organizationsName.get(j).getValue();
						if (j+1 != organizationsName.size()) {
							creatorsName += ", ";
						} 						
					}	
				}
				
				if (i+1 != creatorsList.size()) {
					creatorsName += ", ";
				} 
			}
		}		
		//logger.info("CreatorsName is : " + creatorsName);
		return creatorsName;
	}

	private RelationInfo generateRelationInfo(Corpus inputCorpus) {
		
		RelationInfo relationInfo = new RelationInfo();
		// relationType
		relationInfo.setRelationType(RelationTypeEnum.IS_ANNOTATED_VERSION_OF);
		
		// relatedResource
		RelatedResource rawCorpus = new RelatedResource();
		rawCorpus.setResourceIdentifiers(inputCorpus.getCorpusInfo().getIdentificationInfo().getResourceIdentifiers());
		rawCorpus.setResourceNames(inputCorpus.getCorpusInfo().getIdentificationInfo().getResourceNames());
		relationInfo.setRelatedResource(rawCorpus);
		
		return relationInfo;
	}

	private ResourceCreationInfo generateResourceCreationInfo(String userId) {
		ResourceCreationInfo resourceCreationInfo = new ResourceCreationInfo();
		

		// resourceCreators.resourceCreator.relatedPerson
		List<ActorInfo> resourceCreators = new ArrayList<>();
		ActorInfo actorInfo = new ActorInfo();
		actorInfo.setActorType(ActorTypeEnum.PERSON);		
		actorInfo.setRelatedPerson(generatePersonInfo(userId));
		resourceCreators.add(actorInfo);
		resourceCreationInfo.setResourceCreators(resourceCreators);
		
		// resourceCreationDate
		DateCombination creationDate = new DateCombination();
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
		
		creationDate.setDate(date);
		resourceCreationInfo.setCreationDate(creationDate);
	
		return resourceCreationInfo;
	}

	private String getInputCorpusName(Corpus inputCorpus) {
		String inputCorpusName = getEnglishResourceName(inputCorpus.getCorpusInfo().getIdentificationInfo().getResourceNames());
		return inputCorpusName;
	}
	

	private String getInputCorpusLicence(Corpus inputCorpus) {
		String inputCorpusLicence = inputCorpus.getCorpusInfo().getRightsInfo().getLicenceInfos().get(0).getLicence().toString();
		return inputCorpusLicence;
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
		String corpusName = "[input_corpus_name] processed by [component_name]";
		corpusName = corpusName.replaceAll("\\[input_corpus_name\\]", 
				getInputCorpusName(inputCorpus));			
		corpusName = corpusName .replaceAll("\\[component_name\\]", 
				getComponentName(component));
									
		return corpusName;
	}	
	
	private IdentificationInfo generateIdentificationInfo(Corpus inputCorpus, Component component) {
		
		String inputCorpusDescription = getEnglishDescription(inputCorpus.getCorpusInfo().getIdentificationInfo().getDescriptions());		  
		String descriptionDescription  =  "[input_corpus_name] processed by [component_name] " +
					"version [component_version]." + "[input_corpus_description]"; 		    
		
		IdentificationInfo identificationInfo = new IdentificationInfo();
		
		// identificationInfo.resourceNames.resourceName		
		identificationInfo.setResourceNames(new ArrayList<>());				
		ResourceName resourceName = new ResourceName();	
		resourceName.setLang("en");
		resourceName.setValue(getCorpusName(inputCorpus, component));
		identificationInfo.getResourceNames().add(resourceName);
		
		// identificationInfo.descriptions.description
		descriptionDescription = descriptionDescription.replaceAll("\\[input_corpus_name\\]", 
			getInputCorpusName(inputCorpus));
		descriptionDescription = descriptionDescription.replaceAll("\\[input_corpus_description\\]", 
			inputCorpusDescription);
		descriptionDescription = descriptionDescription.replaceAll("\\[component_name\\]", 
			getComponentName(component));		
		descriptionDescription = descriptionDescription.replaceAll("\\[component_version\\]", 
				getComponentVersion(component));
		
		identificationInfo.setDescriptions(new ArrayList<>());
		Description description = new Description();
		description.setLang("en");
		description.setValue(descriptionDescription);
		identificationInfo.getDescriptions().add(description);
		
		// identificationInfo.resourceIdentifiers.resourceIdentifier
		ResourceIdentifier resourceIdentifier = new ResourceIdentifier();
		resourceIdentifier.setValue(UUID.randomUUID().toString());
		resourceIdentifier.setResourceIdentifierSchemeName(ResourceIdentifierSchemeNameEnum.OMTD);
		identificationInfo.getResourceIdentifiers().add(resourceIdentifier);
		
		return identificationInfo;
	}
	
	/*
	 * Set the contact information of the annotated corpus as the user
	 * that run the workflow
	 */
	private ContactInfo generateContactInfo(String userId, String corpusOmtdId) {		
		ContactInfo contactInfo = new ContactInfo();
		
		// contactPoint	
		contactInfo.setContactPoint(landingPageDomain + corpusOmtdId);
		
		// contactType
		contactInfo.setContactType(ContactTypeEnum.LANDING_PAGE);
		
		// contactPersons.contactPerson
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
		personInfo.setSurname("Gkirtzou");
		personInfo.setGivenName("Katerina");
		
		// User's communication info
		CommunicationInfo  communicationInfo = new CommunicationInfo();
		List<String> emails = new ArrayList<>();
		emails.add("katerina.gkirtzou@ilsp.gr");
		communicationInfo.setEmails(emails);		
		personInfo.setCommunicationInfo(communicationInfo);
		return personInfo;
		
	}
	
	private  DatasetDistributionInfo generateDatasetDistributionInfo(Corpus inputCorpus, Component component, String outputCorpusArchiveId) {
				    
		DatasetDistributionInfo datasetDistributionInfo = new DatasetDistributionInfo();
		
	    // datasetDistributionInfo.distributionMedium
	    datasetDistributionInfo.setDistributionMedium(DistributionMediumEnum.DOWNLOADABLE);
	    
	    // datasetDistributionInfo.distributionLocation
	    datasetDistributionInfo.setDistributionLocation(registryHost + "/request/corpus/download?archiveId=" + outputCorpusArchiveId);
	    
	    // datasetDistributionInfo.sizes	
		datasetDistributionInfo.setSizes(inputCorpus.getCorpusInfo().getDatasetDistributionInfo().getSizes());
		
		// datasetDistributionInfo.textFormats.textFormatInfo.dataFormatInfo
		if (component.getComponentInfo().getOutputResourceInfo() != null) {
		
			List<DataFormatInfo> dataFormats = component.getComponentInfo().getOutputResourceInfo().getDataFormats();			
			if (dataFormats != null && dataFormats.size() != 0) {
				
				List<TextFormatInfo> textFormats = new ArrayList<>();
				for (int i = 0; i < dataFormats.size(); i++) {
					TextFormatInfo textFormatInfo = new TextFormatInfo();
					textFormatInfo.setDataFormatInfo(dataFormats.get(i));
					textFormats.add(textFormatInfo);
				}	
				datasetDistributionInfo.setTextFormats(textFormats);
			}
			// TODO Added a dummy node just for passing validation of add in registry 		
			else {
				List<TextFormatInfo> textFormats = new ArrayList<>();
				TextFormatInfo textFormatInfo = new TextFormatInfo();
				DataFormatInfo dataFormatInfo = new DataFormatInfo();
				dataFormatInfo.setDataFormat(DataFormatType.APPLICATION_VND_XMI_XML);
				textFormatInfo.setDataFormatInfo(dataFormatInfo);
				textFormats.add(textFormatInfo);
				datasetDistributionInfo.setTextFormats(textFormats);
			}
		}
		// TODO Added a dummy node just for passing validation of add in registry		
		else {
			List<TextFormatInfo> textFormats = new ArrayList<>();
			TextFormatInfo textFormatInfo = new TextFormatInfo();
			DataFormatInfo dataFormatInfo = new DataFormatInfo();
			dataFormatInfo.setDataFormat(DataFormatType.APPLICATION_VND_XMI_XML);
			textFormatInfo.setDataFormatInfo(dataFormatInfo);
			textFormats.add(textFormatInfo);
			datasetDistributionInfo.setTextFormats(textFormats);
		}
		
		// datasetDistributionInfo.characterEncodings
		// If exists in component get from compoment
		if (component.getComponentInfo().getOutputResourceInfo() != null &&
				component.getComponentInfo().getOutputResourceInfo().getCharacterEncodings() != null) {
			
			
			List<CharacterEncodingEnum> componentCharacterEncodings = component.getComponentInfo().getOutputResourceInfo().getCharacterEncodings();			
			List<CharacterEncodingInfo> characterEncodings = new ArrayList<>();
			
			for (int i = 0; i < componentCharacterEncodings.size(); i++) {
				CharacterEncodingInfo cei = new CharacterEncodingInfo();
				cei.setCharacterEncoding(componentCharacterEncodings.get(i));
				characterEncodings.add(cei);				
			}
						
			datasetDistributionInfo.setCharacterEncodings(characterEncodings);
		}
		// otherwise get from corpus
		else {				
			datasetDistributionInfo.setCharacterEncodings(inputCorpus.getCorpusInfo().getDatasetDistributionInfo().getCharacterEncodings());
		}
				
	    return datasetDistributionInfo;
	}

	
	 public MetadataHeaderInfo generateMetadataHeaderInfo(String userId) throws JsonProcessingException{
		 
		 	MetadataHeaderInfo metadataHeaderInfo = new MetadataHeaderInfo();
		 	
		     // Set metadata record identifier
	        MetadataIdentifier identifier = new MetadataIdentifier();
	        identifier.setValue(UUID.randomUUID().toString());		       
	        identifier.setMetadataIdentifierSchemeName(MetadataIdentifierSchemeNameEnum.OMTD);
	        metadataHeaderInfo.setMetadataRecordIdentifier(identifier);	        
	
		 	// Set creation date and last date updated
		 	XMLGregorianCalendar calendar = null;
	        try {
	            calendar = DatatypeFactory.newInstance().newXMLGregorianCalendar(gregory);
	        } catch (DatatypeConfigurationException e) {
	            e.printStackTrace();
	        }
	        metadataHeaderInfo.setMetadataCreationDate(calendar);
	        metadataHeaderInfo.setMetadataLastDateUpdated(calendar);
	        
	   
	        // Set metadata creator
	        metadataHeaderInfo.setMetadataCreators(new ArrayList<PersonInfo>());
	        PersonInfo personInfo = generatePersonInfo(userId);
	        metadataHeaderInfo.getMetadataCreators().add(personInfo);
	        
	        //logger.info("MetadataHeaderInfo:\n" + mapper.writeValueAsString(metadataHeaderInfo) + "\n");
	        return metadataHeaderInfo;
	}
}
