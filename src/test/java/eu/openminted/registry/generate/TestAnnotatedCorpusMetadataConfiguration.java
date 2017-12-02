package eu.openminted.registry.generate;

import org.mockito.Mockito;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import eu.openminted.registry.service.ComponentServiceImpl;
import eu.openminted.registry.service.CorpusServiceImpl;

@Profile("test")
@Configuration
public class TestAnnotatedCorpusMetadataConfiguration {
	
/*	@Bean 
	public AnnotatedCorpusMetadataGenerate annotatedCorpusMetadataGenerate() {
		return new AnnotatedCorpusMetadataGenerate();
	}
	*/
	
}