package eu.openminted.registry.generate;


import com.fasterxml.jackson.databind.ObjectMapper;
import eu.openminted.registry.core.service.ResourceCRUDService;
import eu.openminted.registry.domain.*;
import eu.openminted.registry.service.CorpusServiceImpl;
import eu.openminted.registry.service.aai.UserInfoAAIRetrieve;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;

import java.util.*;


@org.springframework.stereotype.Component
public class LanguageConceptualResourceMetadataGenerate {
	
    static final Logger logger = LogManager.getLogger(LanguageConceptualResourceMetadataGenerate.class);
    
	@Autowired
	private CorpusServiceImpl corpusService;
	
	@Autowired
	@Qualifier("applicationService")
	private ResourceCRUDService<Component> applicationService;
	
	@Value("${registry.host}")
	private String registryHost;
	
	@Value("${webapp.front}/landingPage/corpus/")
	private String landingPageDomain;
	
	private GregorianCalendar gregory;
	
	private ObjectMapper mapper;
	
	@Autowired
	private UserInfoAAIRetrieve aaiUserInfoRetriever;

}