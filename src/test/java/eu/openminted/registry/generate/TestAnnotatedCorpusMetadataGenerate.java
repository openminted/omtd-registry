package eu.openminted.registry.generate;

import com.fasterxml.jackson.core.JsonProcessingException;
import eu.openminted.registry.domain.Component;
import eu.openminted.registry.domain.Corpus;
import eu.openminted.registry.service.ComponentServiceImpl;
import eu.openminted.registry.service.CorpusServiceImpl;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.util.ResourceUtils;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.File;
import java.io.FileNotFoundException;

 
@ActiveProfiles("test")
@RunWith(MockitoJUnitRunner.class)
@ContextConfiguration
@ComponentScan("eu.openminted")
public class TestAnnotatedCorpusMetadataGenerate {

	static final Logger logger = LogManager.getLogger(TestAnnotatedCorpusMetadataGenerate.class.getName());

	@InjectMocks
	private AnnotatedCorpusMetadataGenerate corpusMetadataGenerator;
	
	@Mock
	private CorpusServiceImpl corpusService;

	@Mock
	private ComponentServiceImpl componentService;
	
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
	}
	
	@Bean 
	public AnnotatedCorpusMetadataGenerate annotatedCorpusMetadataGenerate() {

		return new AnnotatedCorpusMetadataGenerate();
	}
	
	
	
	@Test
	public void testBasic() throws JsonProcessingException, FileNotFoundException {
		

		logger.info("Running Corpus Metadata Generate");
		String inputCorpusId =  "corpus_maximum.xml"; // omtdid	
		String componentId = "component_real2.xml";  //omtdid
		String userId = "0931731143127784@openminted.eu"; 
		String outputCorpusArchiveId = "outputArchiveId";
			
		Mockito.when(corpusService.get(inputCorpusId)).thenReturn(this.generateCorpus("/metadata_resources_v301/" + inputCorpusId));
		Mockito.when(componentService.get(componentId)).thenReturn(this.generateComponent("/metadata_resources_v301/" + componentId));
		Corpus outputCorpus = corpusMetadataGenerator.generateAnnotatedCorpusMetadata(inputCorpusId, componentId, userId, outputCorpusArchiveId);

	}

	
}
