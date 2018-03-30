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
import eu.openminted.registry.domain.OperationType;
import eu.openminted.registry.domain.RelationInfo;
import eu.openminted.registry.domain.ResourceCreationInfo;
import eu.openminted.registry.domain.RightsInfo;
import eu.openminted.registry.domain.SizeInfo;


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
		 
		 LanguageDescriptionInfo lcrInfo = new LanguageDescriptionInfo();
		 
		 ////////////////////////
		 // IdentificationInfo      
		 lcrInfo.setIdentificationInfo(generateIdentificationInfo(inputCorpus, component));
		 logger.debug("Identification Info:\n" + mapper.writeValueAsString(lcrInfo.getIdentificationInfo()) +"\n");
	        
		 /////////////////////////
		 // VersionInfo     
		 lcrInfo.setVersionInfo(generateVersionInfo());
		 logger.debug("Version info:\n" + mapper.writeValueAsString(lcrInfo.getVersionInfo())+"\n");
	        
	     //////////////////////////
		 // ContactInfo       
		 lcrInfo.setContactInfo(generateContactInfo(userId, lcrOmtdId));
		 logger.debug("Contact info::\n" + mapper.writeValueAsString(lcrInfo.getContactInfo()) + "\n");
			        
		 //////////////////////////
		 // datasetDistributionInfo       
		 List<DatasetDistributionInfo> distributionInfos = new ArrayList<>() ;
		 distributionInfos.add(generateDatasetDistributionInfo(inputCorpus, component, outputCorpusArchiveId));
		 lcrInfo.setDistributionInfos(distributionInfos);
		 //logger.info("Distribution info:\n" + mapper.writeValueAsString(lcrInfo.getDistributionInfos())+"\n");
		 
		 //////////////////////////
		 // rightsInfo
		 RightsInfo rightsInfo = generateRightsInfo(inputCorpus, component);
		 lcrInfo.setRightsInfo(rightsInfo);
		 //logger.info("Rights info:\n" + mapper.writeValueAsString(rightsInfo) + "\n");    
		 
		 //////////////////////////
		 // resourceCreationInfo
		 ResourceCreationInfo resourceCreationInfo = generateResourceCreationInfo(userId);
		 lcrInfo.setResourceCreationInfo(resourceCreationInfo);
		 //logger.info("Resource Creation info::\n" + mapper.writeValueAsString(resourceCreationInfo) + "\n");
		 
		 //////////////////////////////
		 // lexicalConceptualResourceType
		 OperationType componentOperation = component.getComponentInfo().getFunctionInfo().getFunction();                
		 // OntologyAcquisition, OntologyEnhancement --> Ontology         
		 if (componentOperation.equals(OperationType.HTTP___W3ID_ORG_META_SHARE_OMTD_SHARE_ONTOLOGY_ACQUISITION) ||
				 componentOperation.equals(OperationType.HTTP___W3ID_ORG_META_SHARE_OMTD_SHARE_ONTOLOGY_ENHANCEMENT)) {
	        //logger.info("Into ontology functionality");
		//	lcrInfo.setLexicalConceptualResourceType(LexicalConceptualResourceTypeEnum.ONTOLOGY);
	     }	
		 // LexiconAquisitionFromCorpora, LexiconEnhancement, BilignualLexiconInduction --> Lexicon
		 else if (componentOperation.equals(OperationType.HTTP___W3ID_ORG_META_SHARE_OMTD_SHARE_LEXICON_ACQUISITION_FROM_CORPORA) || 
				 componentOperation.equals(OperationType.HTTP___W3ID_ORG_META_SHARE_OMTD_SHARE_LEXICON_EXTRACTION_FROM_LEXICA) ||
				 componentOperation.equals(OperationType.HTTP___W3ID_ORG_META_SHARE_OMTD_SHARE_LEXICON_EXTRACTOR_FROM_CORPORA) ||        
				 componentOperation.equals(OperationType.HTTP___W3ID_ORG_META_SHARE_OMTD_SHARE_LEXICON_ENHANCEMENT) ||
				 componentOperation.equals(OperationType.HTTP___W3ID_ORG_META_SHARE_OMTD_SHARE_BILINGUAL_LEXICON_INDUCTION) ) {
	        //logger.info("Into lexicon functionality");
		//	lcrInfo.setLexicalConceptualResourceType(LexicalConceptualResourceTypeEnum.LEXICON);
	     }       
		 // rest --> other 
		 else {
			 //logger.info("Into other functionality");
			// lcrInfo.setLexicalConceptualResourceType(LexicalConceptualResourceTypeEnum.OTHER);
	     }	
	        
		 //////////////////////////
		 // relations.relationInfo
		 List<RelationInfo> relations = new ArrayList<>();        		
		 relations.add(generateRelationInfo(component));
		 lcrInfo.setRelations(relations);
		 //logger.info("Resource Relation info::\n" + mapper.writeValueAsString(relations) + "\n");   
		 
		 /////////////////////////////////////////////////
		 // lexicalConceptualResourceTextInfo
		// LanguageDescriptionTextInfo lcrTextInfo =  generateLexicalConceptualResourceTextInfo(inputCorpus, component);
		// lcrInfo.setLexicalConceptualResourceTextInfo(lcrTextInfo);
		 //logger.info("Text info::\n" + mapper.writeValueAsString(lcrTextInfo) + "\n");
		 
		 return(lcrInfo);		
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
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected List<SizeInfo> generateDistributionSizeInfo(Corpus inputCorpus) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected RelationInfo generateRelationInfo(Corpus inputCorpus) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected RelationInfo generateRelationInfo(Component component) {
		// TODO Auto-generated method stub
		return null;
	}

}
