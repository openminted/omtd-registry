package eu.openminted.registry.generate;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.UUID;

import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;

import org.apache.commons.lang3.tuple.Pair;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.util.ISO8601DateFormat;

import eu.openminted.registry.core.service.ResourceCRUDService;
import eu.openminted.registry.domain.ActorInfo;
import eu.openminted.registry.domain.ActorTypeEnum;
import eu.openminted.registry.domain.CharacterEncodingEnum;
import eu.openminted.registry.domain.CharacterEncodingInfo;
import eu.openminted.registry.domain.CommunicationInfo;
import eu.openminted.registry.domain.Component;
import eu.openminted.registry.domain.ContactInfo;
import eu.openminted.registry.domain.ContactTypeEnum;
import eu.openminted.registry.domain.Corpus;
import eu.openminted.registry.domain.CreationInfo;
import eu.openminted.registry.domain.DataFormatInfo;
import eu.openminted.registry.domain.DataFormatType;
import eu.openminted.registry.domain.DatasetDistributionInfo;
import eu.openminted.registry.domain.Date;
import eu.openminted.registry.domain.DateCombination;
import eu.openminted.registry.domain.Description;
import eu.openminted.registry.domain.DistributionMediumEnum;
import eu.openminted.registry.domain.GroupName;
import eu.openminted.registry.domain.IdentificationInfo;
import eu.openminted.registry.domain.LicenceEnum;
import eu.openminted.registry.domain.LicenceInfo;
import eu.openminted.registry.domain.MetadataHeaderInfo;
import eu.openminted.registry.domain.MetadataIdentifier;
import eu.openminted.registry.domain.MetadataIdentifierSchemeNameEnum;
import eu.openminted.registry.domain.OrganizationName;
import eu.openminted.registry.domain.PersonIdentifier;
import eu.openminted.registry.domain.PersonIdentifierSchemeNameEnum;
import eu.openminted.registry.domain.PersonInfo;
import eu.openminted.registry.domain.ProcessMode;
import eu.openminted.registry.domain.RelatedResource;
import eu.openminted.registry.domain.RelationInfo;
import eu.openminted.registry.domain.ResourceCreationInfo;
import eu.openminted.registry.domain.ResourceIdentifier;
import eu.openminted.registry.domain.ResourceIdentifierSchemeNameEnum;
import eu.openminted.registry.domain.ResourceName;
import eu.openminted.registry.domain.RightsInfo;
import eu.openminted.registry.domain.RightsStatementEnum;
import eu.openminted.registry.domain.SizeInfo;
import eu.openminted.registry.domain.TextFormatInfo;
import eu.openminted.registry.domain.VersionInfo;
import eu.openminted.registry.service.aai.UserInfoAAIRetrieve;

public abstract class WorkflowOutputMetadataGenerate {
	
	 static final Logger logger = LogManager.getLogger(WorkflowOutputMetadataGenerate.class);
	    
	 @Autowired
	 protected ResourceCRUDService<Corpus> corpusService;
		
	 @Autowired
	 @Qualifier("applicationService")
	 protected ResourceCRUDService<Component> applicationService;
	 
	 @Autowired
	 protected UserInfoAAIRetrieve aaiUserInfoRetriever;
		
	 @Value("${registry.host}")
	 protected String registryHost;
	 
	 @Value("${webapp.front}")
	 protected String landingPageDomain;
		
	 protected GregorianCalendar gregory;
		
	 protected ObjectMapper mapper;
		
	
		
	 public WorkflowOutputMetadataGenerate() {
		 mapper = new ObjectMapper();
		 mapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
		 mapper.setDateFormat(new ISO8601DateFormat());
		 gregory = new GregorianCalendar();
		 gregory.setTime(new java.util.Date());	 
	 }
	 
	 protected MetadataHeaderInfo generateMetadataHeaderInfo(String userId) throws IOException{
		 
		 
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
		 PersonInfo personInfo = generatePersonInfo(userId, true);
		 metadataHeaderInfo.getMetadataCreators().add(personInfo);
	        
		 logger.info("MetadataHeaderInfo:\n" + mapper.writeValueAsString(metadataHeaderInfo) + "\n");
		 return metadataHeaderInfo;
	 }
	
	 /* Set boolean to true to add the OMTD id in the user info. For the metadataHeaderInfo */
	 protected PersonInfo generatePersonInfo(String userId, boolean addOMTDPersonId) throws JsonParseException, JsonMappingException, IOException {
		PersonInfo personInfo = new PersonInfo();
		
		// Retrieve user information from aai service
		int coId =  aaiUserInfoRetriever.getCoId(userId);
		Pair<String, String> userNames = aaiUserInfoRetriever.getSurnameGivenName(coId);  
		String surname = userNames.getKey();
		String givenName =  userNames.getValue();
		String email = aaiUserInfoRetriever.getEmail(coId);
		
		// User's name
		personInfo.setSurname(surname);
		personInfo.setGivenName(givenName);
		
		if (addOMTDPersonId) {
			// Identifiers
			List<PersonIdentifier> personIdentifiers = new ArrayList<>();
			PersonIdentifier personID = new PersonIdentifier();
			personID.setValue(userId);
			personID.setPersonIdentifierSchemeName(PersonIdentifierSchemeNameEnum.OTHER);
			personIdentifiers.add(personID);
			personInfo.setPersonIdentifiers(personIdentifiers);
		}
		
		// User's communication info
		CommunicationInfo  communicationInfo = new CommunicationInfo();
		List<String> emails = new ArrayList<>();
		emails.add(email);
		communicationInfo.setEmails(emails);		
		personInfo.setCommunicationInfo(communicationInfo);
		logger.info("Person info as retrieved from aai :: " + mapper.writeValueAsString(personInfo));
		return personInfo;
		
	 }
	 
	 protected abstract IdentificationInfo generateIdentificationInfo(Corpus inputCorpus, Component component);
	 
	 protected ArrayList<ResourceName> generateResourceNameList(Corpus inputCorpus, Component component) {
		 
		 // identificationInfo.resourceNames.resourceName		
		 ArrayList<ResourceName> resourceNameList = new ArrayList<>();				
		 ResourceName resourceName = new ResourceName();	
		 resourceName.setLang("en");
		 resourceName.setValue(getWorkingResourceName(inputCorpus, component));
		 resourceNameList.add(resourceName);
		 return resourceNameList;		
	 }
	 	 
	 protected ArrayList<Description> generateDescriptionList(Corpus inputCorpus, Component component, String descriptionDescription) {

		// identificationInfo.descriptions.description
		String inputCorpusDescription = getEnglishDescription(inputCorpus.getCorpusInfo().getIdentificationInfo().getDescriptions());		  

		descriptionDescription = descriptionDescription.replaceAll("\\[input_corpus_name\\]", 
			getInputCorpusName(inputCorpus));
		descriptionDescription = descriptionDescription.replaceAll("\\[input_corpus_description\\]", 
			inputCorpusDescription);
		descriptionDescription = descriptionDescription.replaceAll("\\[component_name\\]", 
			getComponentName(component));		
		descriptionDescription = descriptionDescription.replaceAll("\\[component_version\\]", 
			getComponentVersion(component));
		ArrayList<Description> resourceDescriptionList = new ArrayList<>();
		Description description = new Description();
		description.setLang("en");
		description.setValue(descriptionDescription);
		resourceDescriptionList.add(description);
		return(resourceDescriptionList);
	 }
	 
	 protected ArrayList<ResourceIdentifier> generateResourceIdentifierList() {
		// identificationInfo.resourceIdentifiers.resourceIdentifier
		ArrayList<ResourceIdentifier> idList = new ArrayList<>();
		ResourceIdentifier resourceIdentifier = new ResourceIdentifier();
		resourceIdentifier.setValue(UUID.randomUUID().toString());
		resourceIdentifier.setResourceIdentifierSchemeName(ResourceIdentifierSchemeNameEnum.OMTD);
		idList.add(resourceIdentifier);
		return(idList);
		 
	 }
	 
	 protected abstract String getWorkingResourceName(Corpus inputCorpus, Component component);
	 
	 protected String getInputCorpusName(Corpus inputCorpus) {
		 String inputCorpusName = getEnglishResourceName(inputCorpus.getCorpusInfo().getIdentificationInfo().getResourceNames());
		 return inputCorpusName;
	 }	
		
	 
	 protected String getInputCorpusLicence(Corpus inputCorpus) {
		 String inputCorpusLicence = inputCorpus.getCorpusInfo().getRightsInfo().getLicenceInfos().get(0).getLicence().toString();
		 return inputCorpusLicence;
	 }
	 
	 protected String getComponentName(Component component) {
		 String componentName = getEnglishResourceName(component.getComponentInfo().getIdentificationInfo().getResourceNames());
		 return componentName;
	 }
		
		
	 protected String getEnglishResourceName(List<ResourceName> resourceNames) {
		 
		 String resourceName = resourceNames.get(0).getValue();
		 for (int i = 0; i < resourceNames.size(); i++) {
			 if (resourceNames.get(i).getLang().equals("en")) {
				 resourceName = resourceNames.get(i).getValue();
			}
		 }		
		 return resourceName;
	 }
		
	 protected String getEnglishDescription(List<Description> resourceNames) {
			
		 String resourceName = resourceNames.get(0).getValue();
		 for (int i = 0; i < resourceNames.size(); i++) {
			 if (resourceNames.get(i).getLang().equals("en")) {
				 resourceName = resourceNames.get(i).getValue();
			 }
		 }		 
		 return resourceName;
	 }
		
		
	 protected String getComponentVersion(Component component) {
		 String componentVersion = component.getComponentInfo().getVersionInfo().getVersion();
		 if (componentVersion == null) {			
			 componentVersion = component.getComponentInfo().getVersionInfo().getVersionDate();
		 }			
		 return componentVersion;
	 }	
	 
	 protected VersionInfo generateVersionInfo() {
		 VersionInfo versionInfo = new VersionInfo();
		 versionInfo.setVersion("0.0.1");
		 // Set creation date and last date updated
		 XMLGregorianCalendar calendar = null;
		 try {
			 calendar = DatatypeFactory.newInstance().newXMLGregorianCalendar(gregory);
		 } catch (DatatypeConfigurationException e) {
			 e.printStackTrace();
		 }
		 versionInfo.setVersionDate(calendar.toXMLFormat());
		 return versionInfo;
	 }
	 
	 /*
	  * Set the contact information of the annotated corpus as the user
	  * that run the workflow
	 */
	 protected ContactInfo generateContactInfo(String userId, String resourceOmtdId) throws JsonParseException, JsonMappingException, IOException {		
		 ContactInfo contactInfo = new ContactInfo();
		 
		 // contactPoint	
		 //contactInfo.setContactPoint(landingPageDomain + resourceOmtdId);
		 contactInfo.setContactPoint(generateWorkingResourceLandingPage(resourceOmtdId));
		 
		 // contactType
		 contactInfo.setContactType(ContactTypeEnum.LANDING_PAGE);
		 
		 // contactPersons.contactPerson
		 List<PersonInfo> contactPersons = new ArrayList<>();
		 PersonInfo contactPerson = generatePersonInfo(userId, false);
		 contactPersons.add(contactPerson);
		 contactInfo.setContactPersons(contactPersons);
		 return contactInfo;		
	}
	
	protected abstract String generateWorkingResourceLandingPage(String resourceOmtdId);
	
	protected DatasetDistributionInfo generateDatasetDistributionInfo(Corpus inputCorpus, Component component, String outputArchiveId) {
	    
		DatasetDistributionInfo datasetDistributionInfo = new DatasetDistributionInfo();
		
	    // datasetDistributionInfo.distributionMedium
	    datasetDistributionInfo.setDistributionMedium(DistributionMediumEnum.DOWNLOADABLE);
	    
	    // datasetDistributionInfo.distributionLocation
	    datasetDistributionInfo.setDistributionLocation(generateDistributionLocation(outputArchiveId));
	    
	    // datasetDistributionInfo.sizes	
		datasetDistributionInfo.setSizes(generateDistributionSizeInfo(inputCorpus));
		
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
				dataFormatInfo.setDataFormat(DataFormatType.HTTP___W3ID_ORG_META_SHARE_OMTD_SHARE_XMI);
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
			dataFormatInfo.setDataFormat(DataFormatType.HTTP___W3ID_ORG_META_SHARE_OMTD_SHARE_XMI);
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
	
	protected abstract String generateDistributionLocation(String outputArchiveId);
		
	protected abstract  List<SizeInfo> generateDistributionSizeInfo(Corpus inputCorpus);
	
	protected RightsInfo generateRightsInfo(Corpus inputCorpus, Component component) {

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
		String attributionTextStart = generateAttributionTextStart();
		String attributionText  = attributionTextStart + "processing of <input_corpus_name>(by <input_corpus_creator_name>) " +
	       "performed under <input_corpus_licence> has been enabled by the OpenMinTeD infrastructure " +
	       "using the <component_name>. <working_resource_name> is licensed under " +
	       "<working_resource_licence>.";
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
		attributionText = attributionText.replaceAll("<working_resource_name>",
				getWorkingResourceName(inputCorpus, component));
		
	
		rightsInfo.setAttributionText(attributionText);
		
		return rightsInfo;
	}
	
	protected String getInputCorpusCreatorName(Corpus inputCorpus) {
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
	
	protected String generateAttributionTextStart(){
		return "The ";
	}
	
	protected ResourceCreationInfo generateResourceCreationInfo(String userId) throws JsonParseException, JsonMappingException, IOException {
		ResourceCreationInfo resourceCreationInfo = new ResourceCreationInfo();	

		// resourceCreators.resourceCreator.relatedPerson
		List<ActorInfo> resourceCreators = new ArrayList<>();
		ActorInfo actorInfo = new ActorInfo();
		actorInfo.setActorType(ActorTypeEnum.PERSON);		
		actorInfo.setRelatedPerson(generatePersonInfo(userId, false));
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

	protected abstract RelationInfo generateRelationInfo(Corpus inputCorpus);
	protected abstract RelationInfo generateRelationInfo(Component component);
	
	protected CreationInfo generateCreationInfo(Corpus inputCorpus, Component component) {
		CreationInfo creationInfo = new CreationInfo();
		
		// originalSources.relatedResource
		List<RelatedResource> originalSources = new ArrayList<>();
		RelatedResource rawCorpus = new RelatedResource();
		ResourceIdentifier identifier = new ResourceIdentifier();
		identifier.setResourceIdentifierSchemeName(ResourceIdentifierSchemeNameEnum.OMTD);
		identifier.setValue(inputCorpus.getMetadataHeaderInfo().getMetadataRecordIdentifier().getValue());
		rawCorpus.setResourceIdentifiers(Collections.singletonList(identifier));
//		rawCorpus.setResourceIdentifiers(inputCorpus.getCorpusInfo().getIdentificationInfo().getResourceIdentifiers());
		rawCorpus.setResourceNames(inputCorpus.getCorpusInfo().getIdentificationInfo().getResourceNames());
		originalSources.add(rawCorpus);
		creationInfo.setOriginalSources(originalSources);
		
		// creationMode
		creationInfo.setCreationMode(ProcessMode.AUTOMATIC);
		
		//
		// creationSwComponent.isCreatedBy.relatedResource
		List<RelatedResource> creationSwComponents = new ArrayList<>();		
		RelatedResource componentRR = new RelatedResource();
		identifier = new ResourceIdentifier();
		identifier.setResourceIdentifierSchemeName(ResourceIdentifierSchemeNameEnum.OMTD);
		identifier.setValue(component.getMetadataHeaderInfo().getMetadataRecordIdentifier().getValue());
		componentRR.setResourceIdentifiers(Collections.singletonList(identifier));
//		rawCorpus.setResourceIdentifiers(inputCorpus.getCorpusInfo().getIdentificationInfo().getResourceIdentifiers());
		componentRR.setResourceNames(component.getComponentInfo().getIdentificationInfo().getResourceNames());
		creationSwComponents.add(componentRR);
		creationInfo.setCreationSwComponents(creationSwComponents);
		
		return creationInfo;
	}
}
