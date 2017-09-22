package eu.openminted.registry.generate;

import org.apache.log4j.Logger;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.ContextConfiguration;


import com.fasterxml.jackson.core.JsonProcessingException;
import eu.openminted.registry.domain.Corpus;

 

@RunWith(SpringJUnit4ClassRunner.class)
@Configuration
@ComponentScan("eu.openminted")
@ContextConfiguration(classes = {TestAnnotatedCorpusMetadataGenerate.class}) 
public class TestAnnotatedCorpusMetadataGenerate {

	static final Logger logger = Logger.getLogger(TestAnnotatedCorpusMetadataGenerate.class);

	@Autowired
	private AnnotatedCorpusMetadataGenerate corpusMetadataGenerator;
	
	@Test
	public void testFoo() throws JsonProcessingException {	
		String inputCorpusId = "OMTD_Demo_Dataset4"; // omtdid	
		String componentId = "DemoWF3SSHNER";  //omtdid
		String userId = "0931731143127784@openminted.eu"; 
		String outputCorpusArchiveId = "outputArchiveId";
		Corpus outputCorpus = corpusMetadataGenerator.generateAnnotatedCorpusMetadata(inputCorpusId, componentId, userId, outputCorpusArchiveId);

	}

}
