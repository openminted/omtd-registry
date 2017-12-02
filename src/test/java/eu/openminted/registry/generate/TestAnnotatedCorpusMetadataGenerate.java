package eu.openminted.registry.generate;

import java.io.File;
import java.io.FileNotFoundException;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

import org.apache.log4j.Logger;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.util.ResourceUtils;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.ContextHierarchy;

import com.fasterxml.jackson.core.JsonProcessingException;

import eu.openminted.registry.domain.Component;
import eu.openminted.registry.domain.Corpus;
import eu.openminted.registry.messages.OperationMessageConfig;
import eu.openminted.registry.service.ComponentServiceImpl;
import eu.openminted.registry.service.CorpusServiceImpl;

 
@ActiveProfiles("test")
@RunWith(MockitoJUnitRunner.class)//(SpringJUnit4ClassRunner.class)
@ContextConfiguration//(classes = TestAnnotatedCorpusMetadataGenerate.class)
//@Configuration
@ComponentScan("eu.openminted")
public class TestAnnotatedCorpusMetadataGenerate {

	static final Logger logger = Logger.getLogger(TestAnnotatedCorpusMetadataGenerate.class.getName());

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
	public void testFoo() throws JsonProcessingException, FileNotFoundException {
		

		logger.info("Running test foo");
		String inputCorpusId =  "d309d239-222e-4cd8-9bf6-032d3cb6b40e"; //"OMTD_Demo_Dataset4"; // omtdid	
		String componentId = "DemoWF3SSHNER";  //omtdid
		String userId = "0931731143127784@openminted.eu"; 
		String outputCorpusArchiveId = "outputArchiveId";
	
		//Mockito.when(corpusService.get(inputCorpusID). .getUserName("SomeId")).thenReturn("Mock user name");
		Mockito.when(corpusService.get(inputCorpusId)).thenReturn(this.generateCorpus("/metadata_resources_v300/Corpus3.xml"));
		Mockito.when(componentService.get(componentId)).thenReturn(this.generateComponent("/metadata_resources_v300/component1.xml"));
		Corpus outputCorpus = corpusMetadataGenerator.generateAnnotatedCorpusMetadata(inputCorpusId, componentId, userId, outputCorpusArchiveId);

	}

	
}
