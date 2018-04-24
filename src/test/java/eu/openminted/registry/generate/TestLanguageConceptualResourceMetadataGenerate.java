package eu.openminted.registry.generate;

import eu.openminted.registry.domain.Component;
import eu.openminted.registry.domain.Corpus;
import eu.openminted.registry.domain.Lexical;
import eu.openminted.registry.service.aai.UserInfoAAIRetrieve;
import eu.openminted.registry.service.omtd.ApplicationServiceImpl;
import eu.openminted.registry.service.omtd.CorpusServiceImpl;
import org.apache.commons.lang3.tuple.ImmutablePair;
import org.apache.log4j.Logger;
import org.junit.Before;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.test.util.ReflectionTestUtils;
import org.springframework.util.ResourceUtils;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
	
//@ActiveProfiles("test")
//@RunWith(SpringJUnit4ClassRunner.class)
//@ContextConfiguration(loader=AnnotationConfigContextLoader.class)
public class  TestLanguageConceptualResourceMetadataGenerate {

		static final Logger logger = Logger.getLogger(TestLanguageConceptualResourceMetadataGenerate.class.getName());
		
	    @InjectMocks
		private LanguageConceptualResourceMetadataGenerate lcrMetadataGenerator;
		
		@Mock
		private CorpusServiceImpl  corpusService;// = Mockito.mock(ResourceCRUDService.class, Mockito.RETURNS_DEEP_STUBS);

		@Mock
		private ApplicationServiceImpl componentService;

		@Mock	
		private UserInfoAAIRetrieve aaiUserService;
		
		
		private Corpus generateCorpus(String fileToCorpus) throws FileNotFoundException {
			
			logger.info("In generateCorpus @ testLCR " );
			Corpus inputCorpus = null;
			try {

					logger.info("File :: " + this.getClass().getResource(fileToCorpus));
					File file = ResourceUtils.getFile(this.getClass().getResource(fileToCorpus));
					JAXBContext jaxbContext = JAXBContext.newInstance(Corpus.class);

					Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
					inputCorpus = (Corpus) jaxbUnmarshaller.unmarshal(file);
					logger.info(inputCorpus.toString());
			

			} catch (JAXBException e) {
				e.printStackTrace();
			}
	        return inputCorpus;
	    }
		
		private Component generateComponent(String fileToComponent) throws FileNotFoundException {
			Component component = null;
			try {

					logger.info("File :: " + this.getClass().getResource(fileToComponent));
					File file = ResourceUtils.getFile(this.getClass().getResource(fileToComponent));
					JAXBContext jaxbContext = JAXBContext.newInstance(Corpus.class);

					Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
					component = (Component) jaxbUnmarshaller.unmarshal(file);
			

			} catch (JAXBException e) {
				e.printStackTrace();
			}
	        return component;
	    }
		
		@Before
		public void setup() {		        
		    MockitoAnnotations.initMocks(this);
			//corpusService = Mockito.mock(ResourceCRUDService.class, Mockito.RETURNS_DEEP_STUBS);
		    ReflectionTestUtils.setField(lcrMetadataGenerator, "aaiUserInfoRetriever", aaiUserService);
		}
		
		private void printToFile(String filename, Lexical outputLCR) throws JAXBException {
											
			File file = new File(filename);
			JAXBContext jaxbContext = JAXBContext.newInstance(Lexical.class);
			Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
				
			// output pretty printed
			jaxbMarshaller.setProperty(Marshaller.JAXB_SCHEMA_LOCATION, "http://www.meta-share.org/OMTD-SHARE_XMLSchema http://www.meta-share.org/OMTD-SHARE_XMLSchema/v302/OMTD-SHARE-LexicalConceptualResource.xsd");
			jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);			
			jaxbMarshaller.marshal(outputLCR, file);
			jaxbMarshaller.marshal(outputLCR, System.out);
			
			return;
		}
		
		private Lexical readFromFile(String fileToLexical) throws JAXBException, FileNotFoundException {
			// 
			JAXBContext jaxbContext = JAXBContext.newInstance(Lexical.class);
			Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
			Lexical validatorLCR = (Lexical) jaxbUnmarshaller.unmarshal(ResourceUtils.getFile(this.getClass().getResource(fileToLexical)));
			return validatorLCR;
		}
		
		//@Test
		public void testWithMinimalCorpusMinimalComponent() throws IOException, JAXBException, Exception {
			
		
			logger.info("Running Language/Conceptual Resource Metadata Generate");
			String inputCorpusId = "corpus_minimal.xml"; // omtdid	
			String componentId = "component_minimal_generatesLCRLexicon.xml";  //omtdid
			String userId = "0931731143127784@openminted.eu"; 
			String outputCorpusArchiveId = "outputArchiveId";
						
			
		    Mockito.when(corpusService.get(inputCorpusId)).thenReturn(this.generateCorpus("/metadata_resources_v302/" + inputCorpusId));		
		    Mockito.when(componentService.get(componentId)).thenReturn(this.generateComponent("/metadata_resources_v302/" + componentId));
		    Mockito.when(aaiUserService.getCoId(userId)).thenReturn(14);
		    Mockito.when(aaiUserService.getEmail(14)).thenReturn("katerina.gkirtzou@ilsp.gr");
		    Mockito.when(aaiUserService.getSurnameGivenName(14)).thenReturn(new ImmutablePair<>("Gkirtzou", "Katerina"));		   		
			
			Lexical outputLCR = lcrMetadataGenerator.generateLanguageConceptualResourceMetadata(inputCorpusId, componentId, userId, outputCorpusArchiveId);
			//printToFile("lcrMinCorpusMinComponent.xml", outputLCR); 					
		}
		
		//@Test
		public void testWithMinimalCorpusDemimaxComponent() throws IOException, JAXBException, Exception {
			
		
			logger.info("Running Language/Conceptual Resource Metadata Generate");
			String inputCorpusId = "corpus_minimal.xml"; // omtdid	
			String componentId = "component_demimax_generatesLCRLexicon.xml";  //omtdid
			String userId = "0931731143127784@openminted.eu"; 
			String outputCorpusArchiveId = "outputArchiveId";
						
			
		    Mockito.when(corpusService.get(inputCorpusId)).thenReturn(this.generateCorpus("/metadata_resources_v302/" + inputCorpusId));		
		    Mockito.when(componentService.get(componentId)).thenReturn(this.generateComponent("/metadata_resources_v302/" + componentId));
		    Mockito.when(aaiUserService.getCoId(userId)).thenReturn(14);
		    Mockito.when(aaiUserService.getEmail(14)).thenReturn("katerina.gkirtzou@ilsp.gr");
		    Mockito.when(aaiUserService.getSurnameGivenName(14)).thenReturn(new ImmutablePair<>("Gkirtzou", "Katerina"));		   		
			
			Lexical outputLCR = lcrMetadataGenerator.generateLanguageConceptualResourceMetadata(inputCorpusId, componentId, userId, outputCorpusArchiveId);
			//printToFile("lcrMinCorpusDemimaxComponent.xml", outputLCR); 									
		}
		
		//@Test
		public void testWithMinimalCorpusMaxComponent() throws IOException, JAXBException, Exception {
			
		
			logger.info("Running Language/Conceptual Resource Metadata Generate");
			String inputCorpusId = "corpus_minimal.xml"; // omtdid	
			String componentId = "component_maximum_generatesLCROntology.xml"; //omtdid
			String userId = "0931731143127784@openminted.eu"; 
			String outputCorpusArchiveId = "outputArchiveId";
						
			
		    Mockito.when(corpusService.get(inputCorpusId)).thenReturn(this.generateCorpus("/metadata_resources_v302/" + inputCorpusId));		
		    Mockito.when(componentService.get(componentId)).thenReturn(this.generateComponent("/metadata_resources_v302/" + componentId));
		    Mockito.when(aaiUserService.getCoId(userId)).thenReturn(14);
		    Mockito.when(aaiUserService.getEmail(14)).thenReturn("katerina.gkirtzou@ilsp.gr");
		    Mockito.when(aaiUserService.getSurnameGivenName(14)).thenReturn(new ImmutablePair<>("Gkirtzou", "Katerina"));		   		
			
			Lexical outputLCR = lcrMetadataGenerator.generateLanguageConceptualResourceMetadata(inputCorpusId, componentId, userId, outputCorpusArchiveId);
			//printToFile("lcrMinCorpusMaxComponent.xml", outputLCR); 									
		}
		
		//@Test
		public void testWithMaximumCorpusMinimalComponent() throws IOException, JAXBException, Exception {
			
		
			logger.info("Running Language/Conceptual Resource Metadata Generate");
			String inputCorpusId = "corpus_maximum.xml"; // omtdid	
			String componentId = "component_minimal_generatesLCRLexicon.xml";  //omtdid
			String userId = "0931731143127784@openminted.eu"; 
			String outputCorpusArchiveId = "outputArchiveId";
						
			
		    Mockito.when(corpusService.get(inputCorpusId)).thenReturn(this.generateCorpus("/metadata_resources_v302/" + inputCorpusId));		
		    Mockito.when(componentService.get(componentId)).thenReturn(this.generateComponent("/metadata_resources_v302/" + componentId));
		    Mockito.when(aaiUserService.getCoId(userId)).thenReturn(14);
		    Mockito.when(aaiUserService.getEmail(14)).thenReturn("katerina.gkirtzou@ilsp.gr");
		    Mockito.when(aaiUserService.getSurnameGivenName(14)).thenReturn(new ImmutablePair<>("Gkirtzou", "Katerina"));		   		
			
			Lexical outputLCR = lcrMetadataGenerator.generateLanguageConceptualResourceMetadata(inputCorpusId, componentId, userId, outputCorpusArchiveId);
			//printToFile("lcrMaxCorpusMinComponent.xml", outputLCR); 									
		}
		
		//@Test
		public void testWithMaximumCorpusDemimaxComponent() throws IOException, JAXBException, Exception {
			
		
			logger.info("Running Language/Conceptual Resource Metadata Generate");
			String inputCorpusId = "corpus_maximum.xml"; // omtdid	
			String componentId = "component_demimax_generatesLCRLexicon.xml";  //omtdid
			String userId = "0931731143127784@openminted.eu"; 
			String outputCorpusArchiveId = "outputArchiveId";
						
			
		    Mockito.when(corpusService.get(inputCorpusId)).thenReturn(this.generateCorpus("/metadata_resources_v302/" + inputCorpusId));		
		    Mockito.when(componentService.get(componentId)).thenReturn(this.generateComponent("/metadata_resources_v302/" + componentId));
		    Mockito.when(aaiUserService.getCoId(userId)).thenReturn(14);
		    Mockito.when(aaiUserService.getEmail(14)).thenReturn("katerina.gkirtzou@ilsp.gr");
		    Mockito.when(aaiUserService.getSurnameGivenName(14)).thenReturn(new ImmutablePair<>("Gkirtzou", "Katerina"));		   		
			
			Lexical outputLCR = lcrMetadataGenerator.generateLanguageConceptualResourceMetadata(inputCorpusId, componentId, userId, outputCorpusArchiveId);
			//printToFile("lcrMaxCorpusDemimaxComponent.xml", outputLCR); 									
		}
		
		//@Test
		public void testWithMaximumCorpusMaxComponent() throws IOException, JAXBException, Exception {
			
		
			logger.info("Running Language/Conceptual Resource Metadata Generate");
			String inputCorpusId = "corpus_maximum.xml"; // omtdid	
			String componentId = "component_maximum_generatesLCROntology.xml"; //omtdid
			String userId = "0931731143127784@openminted.eu"; 
			String outputCorpusArchiveId = "outputArchiveId";
						
			
		    Mockito.when(corpusService.get(inputCorpusId)).thenReturn(this.generateCorpus("/metadata_resources_v302/" + inputCorpusId));		
		    Mockito.when(componentService.get(componentId)).thenReturn(this.generateComponent("/metadata_resources_v302/" + componentId));
		    Mockito.when(aaiUserService.getCoId(userId)).thenReturn(14);
		    Mockito.when(aaiUserService.getEmail(14)).thenReturn("katerina.gkirtzou@ilsp.gr");
		    Mockito.when(aaiUserService.getSurnameGivenName(14)).thenReturn(new ImmutablePair<>("Gkirtzou", "Katerina"));		   		
			
			Lexical outputLCR = lcrMetadataGenerator.generateLanguageConceptualResourceMetadata(inputCorpusId, componentId, userId, outputCorpusArchiveId);
			//printToFile("lcrMaxCorpusMaxComponent.xml", outputLCR); 									
		}

		
	}

