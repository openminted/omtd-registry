package eu.openminted.registry.generate;

import eu.openminted.registry.core.service.ResourceCRUDService;
import eu.openminted.registry.domain.Component;
import eu.openminted.registry.domain.Corpus;
import eu.openminted.registry.service.aai.UserInfoAAIRetrieve;

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
import org.springframework.test.util.ReflectionTestUtils;
import org.springframework.util.ResourceUtils;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.AnnotationConfigContextLoader;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

 
@ActiveProfiles("test")
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(loader=AnnotationConfigContextLoader.class)
public class TestAnnotatedCorpusMetadataGenerate {

	static final Logger logger = Logger.getLogger(TestAnnotatedCorpusMetadataGenerate.class.getName());
	
    @InjectMocks
	private AnnotatedCorpusMetadataGenerate corpusMetadataGenerator;
	
	@Mock
	private ResourceCRUDService<Corpus> corpusService;

	@Mock
	private ResourceCRUDService<Component> componentService;

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
	    ReflectionTestUtils.setField(corpusMetadataGenerator, "aaiUserInfoRetriever", aaiUserService);
	}
	
	
	@Test
	public void testBasic() throws IOException {
		
	
		logger.info("Running Corpus Metadata Generate");
		String inputCorpusId =  "corpus_maximum.xml"; // omtdid	
		String componentId = "component_real2.xml";  //omtdid
		String userId = "0931731143127784@openminted.eu"; 
		String outputCorpusArchiveId = "outputArchiveId";
			
		
		Mockito.when(corpusService.get(inputCorpusId)).thenReturn(this.generateCorpus("/metadata_resources_v301/" + inputCorpusId));
		Mockito.when(componentService.get(componentId)).thenReturn(this.generateComponent("/metadata_resources_v301/" + componentId));
		Mockito.when(aaiUserService.getCoId(userId)).thenReturn(14);
		Mockito.when(aaiUserService.getEmail(14)).thenReturn("katerina.gkirtzou@ilsp.gr");
		Mockito.when(aaiUserService.getSurnameGivenName(14)).thenReturn(new ImmutablePair<>("Gkirtzou", "Katerina"));	
		
		Corpus outputCorpus = corpusMetadataGenerator.generateAnnotatedCorpusMetadata(inputCorpusId, componentId, userId, outputCorpusArchiveId);

	}

	
}
