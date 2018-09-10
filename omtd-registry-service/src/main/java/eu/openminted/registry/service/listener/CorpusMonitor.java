package eu.openminted.registry.service.listener;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import eu.openminted.registry.core.service.ResourceCRUDService;
import eu.openminted.registry.domain.Corpus;
import eu.openminted.registry.service.process.SizeCorpusProcessor;
import eu.openminted.registry.domain.file.FileStats;
import eu.openminted.store.restclient.StoreRESTClient;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;

import org.mitre.openid.connect.model.OIDCAuthenticationToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class CorpusMonitor {

    private static Logger logger = LogManager.getLogger(CorpusMonitor.class);

    private ResourceCRUDService<FileStats, OIDCAuthenticationToken> fileStatsService;

    private SizeCorpusProcessor sizeCorpusProcessor;

    @Autowired
    public CorpusMonitor(
            ResourceCRUDService<FileStats, OIDCAuthenticationToken> fileStatsService,
            StoreRESTClient storeService)
    {
        this.fileStatsService = fileStatsService;
        this.sizeCorpusProcessor = new SizeCorpusProcessor(storeService, this.fileStatsService);
    }

    @After("execution (* eu.openminted.registry.service.omtd.CorpusServiceImpl.add(*,*)) && args(corpus,*)")
    public Corpus addCorpus(Corpus corpus) throws JsonProcessingException {
        FileStats fileStats = sizeCorpusProcessor.process(corpus);
        ObjectMapper mapper = new ObjectMapper();
        logger.info(mapper.writeValueAsString(fileStats));
        fileStatsService.add(fileStats,null);
        return corpus;
    }

}
