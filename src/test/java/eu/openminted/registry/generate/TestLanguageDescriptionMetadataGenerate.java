package eu.openminted.registry.generate;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

import org.apache.commons.lang3.tuple.ImmutablePair;
import org.apache.log4j.Logger;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.AnnotationConfigContextLoader;
import org.springframework.test.util.ReflectionTestUtils;
import org.springframework.util.ResourceUtils;

import eu.openminted.registry.core.service.ResourceCRUDService;
import eu.openminted.registry.domain.Component;
import eu.openminted.registry.domain.Corpus;
import eu.openminted.registry.domain.LanguageDescription;
import eu.openminted.registry.domain.Lexical;
import eu.openminted.registry.service.ApplicationServiceImpl;
import eu.openminted.registry.service.CorpusServiceImpl;
import eu.openminted.registry.service.aai.UserInfoAAIRetrieve;

@ActiveProfiles("test")
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(loader=AnnotationConfigContextLoader.class)
public class TestLanguageDescriptionMetadataGenerate {

	static final Logger logger = Logger.getLogger(TestLanguageConceptualResourceMetadataGenerate.class.getName());
	
    @InjectMocks
	private LanguageDescriptionMetadataGenerate ldMetadataGenerator;
	
	@Mock
	private CorpusServiceImpl corpusService;

	@Mock
	private ApplicationServiceImpl componentService;

	@Mock	
	private UserInfoAAIRetrieve aaiUserService;
	
	
	private Corpus generateCorpus(String fileToCorpus) throws FileNotFoundException {
				
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
		//componentService = Mockito.mock(.class, Mockito.RETURNS_DEEP_STUBS);
	    ReflectionTestUtils.setField(ldMetadataGenerator, "aaiUserInfoRetriever", aaiUserService);
	}
	
	//@Test
	public void testWithMinimalCorpusMinimalComponent() throws IOException, JAXBException, Exception {
		
	
		logger.info("Running Language Description Metadata Generate");
		String inputCorpusId = "corpus_minimal.xml"; // omtdid	
		String componentId = "component_minimal_generatesMLmodel.xml";  //omtdid
		String userId = "0931731143127784@openminted.eu"; 
		String outputCorpusArchiveId = "outputArchiveId";
					
		
	    Mockito.when(corpusService.get(inputCorpusId)).thenReturn(this.generateCorpus("/metadata_resources_v302/" + inputCorpusId));		
	    Mockito.when(componentService.get(componentId)).thenReturn(this.generateComponent("/metadata_resources_v302/" + componentId));
	    Mockito.when(aaiUserService.getCoId(userId)).thenReturn(14);
	    Mockito.when(aaiUserService.getEmail(14)).thenReturn("katerina.gkirtzou@ilsp.gr");
	    Mockito.when(aaiUserService.getSurnameGivenName(14)).thenReturn(new ImmutablePair<>("Gkirtzou", "Katerina"));		   		
		
	    LanguageDescription output = ldMetadataGenerator.generateLanguageDescriptionMetadata(inputCorpusId, componentId, userId, outputCorpusArchiveId); 					
	}
	
	//@Test
	public void testWithMinimalCorpusDemimaxComponent() throws IOException, JAXBException, Exception {
		
	
		logger.info("Running Language Description Metadata Generate");
		String inputCorpusId = "corpus_minimal.xml"; // omtdid	
		String componentId = "component_demimax_generatesMLmodel.xml";  //omtdid
		String userId = "0931731143127784@openminted.eu"; 
		String outputCorpusArchiveId = "outputArchiveId";
					
		
	    Mockito.when(corpusService.get(inputCorpusId)).thenReturn(this.generateCorpus("/metadata_resources_v302/" + inputCorpusId));		
	    Mockito.when(componentService.get(componentId)).thenReturn(this.generateComponent("/metadata_resources_v302/" + componentId));
	    Mockito.when(aaiUserService.getCoId(userId)).thenReturn(14);
	    Mockito.when(aaiUserService.getEmail(14)).thenReturn("katerina.gkirtzou@ilsp.gr");
	    Mockito.when(aaiUserService.getSurnameGivenName(14)).thenReturn(new ImmutablePair<>("Gkirtzou", "Katerina"));		   		
		
	    LanguageDescription output = ldMetadataGenerator.generateLanguageDescriptionMetadata(inputCorpusId, componentId, userId, outputCorpusArchiveId);								
	}
	
	//@Test
	public void testWithMinimalCorpusMaxComponent() throws IOException, JAXBException, Exception {
		
	
		logger.info("Running Language Description Metadata Generate");
		String inputCorpusId = "corpus_minimal.xml"; // omtdid	
		String componentId = "component_maximum_generatesMLmodel.xml"; //omtdid
		String userId = "0931731143127784@openminted.eu"; 
		String outputCorpusArchiveId = "outputArchiveId";
					
		
	    Mockito.when(corpusService.get(inputCorpusId)).thenReturn(this.generateCorpus("/metadata_resources_v302/" + inputCorpusId));		
	    Mockito.when(componentService.get(componentId)).thenReturn(this.generateComponent("/metadata_resources_v302/" + componentId));
	    Mockito.when(aaiUserService.getCoId(userId)).thenReturn(14);
	    Mockito.when(aaiUserService.getEmail(14)).thenReturn("katerina.gkirtzou@ilsp.gr");
	    Mockito.when(aaiUserService.getSurnameGivenName(14)).thenReturn(new ImmutablePair<>("Gkirtzou", "Katerina"));		   		
		
	    LanguageDescription output = ldMetadataGenerator.generateLanguageDescriptionMetadata(inputCorpusId, componentId, userId, outputCorpusArchiveId); 									
	}
	
	//@Test
	public void testWithMaximumCorpusMinimalComponent() throws IOException, JAXBException, Exception {
		
	
		logger.info("Running Language Description Metadata Generate");
		String inputCorpusId = "corpus_maximum.xml"; // omtdid	
		String componentId = "component_minimal_generatesMLmodel.xml";  //omtdid
		String userId = "0931731143127784@openminted.eu"; 
		String outputCorpusArchiveId = "outputArchiveId";
					
		
	    Mockito.when(corpusService.get(inputCorpusId)).thenReturn(this.generateCorpus("/metadata_resources_v302/" + inputCorpusId));		
	    Mockito.when(componentService.get(componentId)).thenReturn(this.generateComponent("/metadata_resources_v302/" + componentId));
	    Mockito.when(aaiUserService.getCoId(userId)).thenReturn(14);
	    Mockito.when(aaiUserService.getEmail(14)).thenReturn("katerina.gkirtzou@ilsp.gr");
	    Mockito.when(aaiUserService.getSurnameGivenName(14)).thenReturn(new ImmutablePair<>("Gkirtzou", "Katerina"));		   		
		
	    LanguageDescription output = ldMetadataGenerator.generateLanguageDescriptionMetadata(inputCorpusId, componentId, userId, outputCorpusArchiveId);								
	}
	
	//@Test
	public void testWithMaximumCorpusDemimaxComponent() throws IOException, JAXBException, Exception {
		
	
		logger.info("Running Language Description Metadata Generate");
		String inputCorpusId = "corpus_maximum.xml"; // omtdid	
		String componentId = "component_demimax_generatesMLmodel.xml";  //omtdid
		String userId = "0931731143127784@openminted.eu"; 
		String outputCorpusArchiveId = "outputArchiveId";
					
		
	    Mockito.when(corpusService.get(inputCorpusId)).thenReturn(this.generateCorpus("/metadata_resources_v302/" + inputCorpusId));		
	    Mockito.when(componentService.get(componentId)).thenReturn(this.generateComponent("/metadata_resources_v302/" + componentId));
	    Mockito.when(aaiUserService.getCoId(userId)).thenReturn(14);
	    Mockito.when(aaiUserService.getEmail(14)).thenReturn("katerina.gkirtzou@ilsp.gr");
	    Mockito.when(aaiUserService.getSurnameGivenName(14)).thenReturn(new ImmutablePair<>("Gkirtzou", "Katerina"));		   		
		
	    LanguageDescription output = ldMetadataGenerator.generateLanguageDescriptionMetadata(inputCorpusId, componentId, userId, outputCorpusArchiveId); 									
	}
	
	@Test
	public void testWithMaximumCorpusMaxComponent() throws IOException, JAXBException, Exception {
		
	
		logger.info("Running Language Description Metadata Generate");
		String inputCorpusId = "corpus_maximum.xml"; // omtdid	
		String componentId = "component_maximum_generatesMLmodel.xml"; //omtdid
		String userId = "0931731143127784@openminted.eu"; 
		String outputCorpusArchiveId = "outputArchiveId";
					
		
	    Mockito.when(corpusService.get(inputCorpusId)).thenReturn(this.generateCorpus("/metadata_resources_v302/" + inputCorpusId));		
	    Mockito.when(componentService.get(componentId)).thenReturn(this.generateComponent("/metadata_resources_v302/" + componentId));
	    Mockito.when(aaiUserService.getCoId(userId)).thenReturn(14);
	    Mockito.when(aaiUserService.getEmail(14)).thenReturn("katerina.gkirtzou@ilsp.gr");
	    Mockito.when(aaiUserService.getSurnameGivenName(14)).thenReturn(new ImmutablePair<>("Gkirtzou", "Katerina"));		   		
		
	    LanguageDescription output = ldMetadataGenerator.generateLanguageDescriptionMetadata(inputCorpusId, componentId, userId, outputCorpusArchiveId);								
	}
}
