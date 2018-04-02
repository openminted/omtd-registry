package eu.openminted.registry.generate;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import eu.openminted.registry.domain.Component;
import eu.openminted.registry.domain.Corpus;
import eu.openminted.registry.domain.DatasetDistributionInfo;
import eu.openminted.registry.domain.IdentificationInfo;
import eu.openminted.registry.domain.LanguageDescription;
import eu.openminted.registry.domain.LanguageDescriptionInfo;
import eu.openminted.registry.domain.LanguageDescriptionTextInfo;
import eu.openminted.registry.domain.LanguageDescriptionTypeEnum;
import eu.openminted.registry.domain.ModelOperationInfo;
import eu.openminted.registry.domain.OperationType;
import eu.openminted.registry.domain.ProcessingResourceTypeEnum;
import eu.openminted.registry.domain.RelatedResource;
import eu.openminted.registry.domain.RelationInfo;
import eu.openminted.registry.domain.ResourceCreationInfo;
import eu.openminted.registry.domain.RightsInfo;
import eu.openminted.registry.domain.SizeInfo;
import eu.openminted.registry.domain.SizeUnitEnum;


public class LanguageDescriptionMetadataGenerate extends WorkflowOutputMetadataGenerate {

	 static final Logger logger = LogManager.getLogger(LanguageDescriptionMetadataGenerate.class);
	    
	 public LanguageDescription generateLanguageDescriptionMetadata(String inputCorpusId, String componentId, String userId, String outputResourceArchiveId) 
			 throws IOException, NullPointerException  {
		 //eu.openminted.registry.domain.LanguageDescription
		 LanguageDescription languageDescription = new LanguageDescription();
		 
		 languageDescription.setMetadataHeaderInfo(generateMetadataHeaderInfo(userId));
		 String ldOmtdId = languageDescription.getMetadataHeaderInfo().getMetadataRecordIdentifier().getValue();    
		 languageDescription.setLanguageDescriptionInfo(generateLanguageDescriptionInfo(ldOmtdId, inputCorpusId, componentId, userId, outputResourceArchiveId));
		 //logger.debug("Output lrc metadata::\n " + mapper.writeValueAsString(languageDescription)+"\n");
		 return languageDescription;
	 }

	 public LanguageDescriptionInfo generateLanguageDescriptionInfo(String lcrOmtdId, String inputCorpusId, String componentId, String userId, String outputCorpusArchiveId) 
			 throws IOException, NullPointerException {
	     // Get input corpus information       		
		 Corpus inputCorpus = getInputCorpusMetadata(inputCorpusId);
		 // Get component information
		 Component component = getComponentMetadata(componentId);    	
		 
		 LanguageDescriptionInfo ldInfo = new LanguageDescriptionInfo();
		 
		 ////////////////////////
		 // IdentificationInfo      
		 ldInfo.setIdentificationInfo(generateIdentificationInfo(inputCorpus, component));
		 logger.debug("Identification Info:\n" + mapper.writeValueAsString(ldInfo.getIdentificationInfo()) +"\n");
	        
		 /////////////////////////
		 // VersionInfo     
		 ldInfo.setVersionInfo(generateVersionInfo());
		 logger.debug("Version info:\n" + mapper.writeValueAsString(ldInfo.getVersionInfo())+"\n");
	        
	     //////////////////////////
		 // ContactInfo       
		 ldInfo.setContactInfo(generateContactInfo(userId, lcrOmtdId));
		 logger.debug("Contact info::\n" + mapper.writeValueAsString(ldInfo.getContactInfo()) + "\n");
			        
		 //////////////////////////
		 // datasetDistributionInfo       
		 List<DatasetDistributionInfo> distributionInfos = new ArrayList<>() ;
		 distributionInfos.add(generateDatasetDistributionInfo(inputCorpus, component, outputCorpusArchiveId));
		 ldInfo.setDistributionInfos(distributionInfos);
		 logger.debug("Distribution info:\n" + mapper.writeValueAsString(ldInfo.getDistributionInfos())+"\n");
		 
		 //////////////////////////
		 // rightsInfo
		 RightsInfo rightsInfo = generateRightsInfo(inputCorpus, component);
		 ldInfo.setRightsInfo(rightsInfo);
		 logger.debug("Rights info:\n" + mapper.writeValueAsString(rightsInfo) + "\n");    
		 
		 //////////////////////////
		 // resourceCreationInfo
		 ResourceCreationInfo resourceCreationInfo = generateResourceCreationInfo(userId);
		 ldInfo.setResourceCreationInfo(resourceCreationInfo);
		 logger.debug("Resource Creation info::\n" + mapper.writeValueAsString(resourceCreationInfo) + "\n");
		 
		 //////////////////////////////
		 // languageDescriptionType
		 OperationType componentOperation = component.getComponentInfo().getFunctionInfo().getFunction();                
		 // TrainerOfMachineLearningModels --> mlModel
		 if (componentOperation.equals(OperationType.HTTP___W3ID_ORG_META_SHARE_OMTD_SHARE_TRAINER_OF_MACHINE_LEARNING_MODELS))  {
	        logger.debug("Into mlModel");
			ldInfo.setLanguageDescriptionType(LanguageDescriptionTypeEnum.ML_MODEL);
	     }	       
		 // rest --> other 
		 else {
			logger.debug("Into other functionality");
			ldInfo.setLanguageDescriptionType(LanguageDescriptionTypeEnum.OTHER);
	     }	
	        
		 ///////////////////////////
		 // modelOperationInfo
		 if (ldInfo.getLanguageDescriptionType().equals(LanguageDescriptionTypeEnum.ML_MODEL)) {
			 ldInfo.setModelOperationInfo(generateModelOperationInfo(inputCorpus, component));
			 logger.debug("Model Operation info::\n" + mapper.writeValueAsString(ldInfo.getModelOperationInfo()) + "\n");   
		 } 
		 		 
		 //////////////////////////
		 // relations.relationInfo
		 List<RelationInfo> relations = new ArrayList<>();        		
		 relations.add(generateRelationInfo(component));
		 ldInfo.setRelations(relations);
		 logger.debug("Resource Relation info::\n" + mapper.writeValueAsString(relations) + "\n");   
		 
		 /////////////////////////////////////////////////
		 // languageDescriptionTextInfo
		 LanguageDescriptionTextInfo lcrTextInfo =  generateDescriptionTextInfo(inputCorpus, component);
		 ldInfo.setLanguageDescriptionTextInfo(lcrTextInfo);
		 logger.debug("Text info::\n" + mapper.writeValueAsString(lcrTextInfo) + "\n");
		 
		 return(ldInfo);		
	}
	
	@Override
	protected IdentificationInfo generateIdentificationInfo(Corpus inputCorpus, Component component) {
		String descriptionDescription  =  "The language description generated by the processing of " +  
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
		String lexicalName = "The language description generated by the processing of " + 
				"[input_corpus_name] with [component_name]";
		lexicalName = lexicalName.replaceAll("\\[input_corpus_name\\]", 
				getInputCorpusName(inputCorpus));			
		lexicalName = lexicalName .replaceAll("\\[component_name\\]", 
				getComponentName(component));
									
		return lexicalName;
	}

	@Override
	protected String generateWorkingResourceLandingPage(String resourceOmtdId) {
		return landingPageDomain + "/landingPage/language/" + resourceOmtdId;
	}

	@Override
	protected String generateDistributionLocation(String outputArchiveId) {
		return registryHost + "/request/language/download?archiveId=" + outputArchiveId;
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
	protected String generateAttributionTextStart(){
		return "The language description generated by the ";
	}
	
	private ModelOperationInfo generateModelOperationInfo(Corpus inputCorpus, Component component) {
		ModelOperationInfo modelOperation = new ModelOperationInfo();
		
		if (component.getComponentInfo().getOutputResourceInfo() == null && 
			component.getComponentInfo().getInputContentResourceInfo() == null) {
			return null;
		}
			
		////////////////////	
		// typesystem
		if (component.getComponentInfo().getOutputResourceInfo() != null &&
			component.getComponentInfo().getOutputResourceInfo().getTypesystem() != null	) {
			modelOperation.setTypesystem(component.getComponentInfo().getOutputResourceInfo().getTypesystem());
		}
		else if (component.getComponentInfo().getInputContentResourceInfo() != null &&
				component.getComponentInfo().getInputContentResourceInfo().getTypesystem() != null) {
			modelOperation.setTypesystem(component.getComponentInfo().getInputContentResourceInfo().getTypesystem());
		}
		
		////////////////////
		// annotationSchema
		if (component.getComponentInfo().getOutputResourceInfo() != null &&
		    component.getComponentInfo().getOutputResourceInfo().getAnnotationSchema() != null	) {
			modelOperation.setAnnotationSchema(component.getComponentInfo().getOutputResourceInfo().getAnnotationSchema());
		}
		else if (component.getComponentInfo().getInputContentResourceInfo() != null &&
		         component.getComponentInfo().getInputContentResourceInfo().getAnnotationSchema() != null) {
			modelOperation.setAnnotationSchema(component.getComponentInfo().getInputContentResourceInfo().getAnnotationSchema());
		}
		
		////////////////////
		// annotationResources
		if (component.getComponentInfo().getOutputResourceInfo() != null &&
		    component.getComponentInfo().getOutputResourceInfo().getAnnotationResource() != null	) {
			List<RelatedResource> annotationResources = new ArrayList<>();
			annotationResources.add(component.getComponentInfo().getOutputResourceInfo().getAnnotationResource());			
			modelOperation.setAnnotationResources(annotationResources);
		}
		else if (component.getComponentInfo().getInputContentResourceInfo() != null &&
		         component.getComponentInfo().getInputContentResourceInfo().getAnnotationResource() != null) {
			List<RelatedResource> annotationResources = new ArrayList<>();
			annotationResources.add(component.getComponentInfo().getInputContentResourceInfo().getAnnotationResource());			
			modelOperation.setAnnotationResources(annotationResources);
		}
		
		if (component.getComponentInfo().getInputContentResourceInfo() != null &&
			component.getComponentInfo().getInputContentResourceInfo().getProcessingResourceType().equals(ProcessingResourceTypeEnum.CORPUS) ) {
			modelOperation.setTrainingCorpusDetails("The training corpus is " + getInputCorpusName(inputCorpus) );
			
		}
		
		return modelOperation;
	}
	

	@Override
	protected RelationInfo generateRelationInfo(Corpus inputCorpus) {
		return null;
	}
	
	private LanguageDescriptionTextInfo generateDescriptionTextInfo(Corpus inputCorpus, Component component) {
		LanguageDescriptionTextInfo ldTextInfo = new LanguageDescriptionTextInfo();
		return ldTextInfo;
	}

}
