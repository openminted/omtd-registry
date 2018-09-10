package eu.openminted.registry.service.process;

import eu.openminted.registry.core.service.ResourceCRUDService;
import eu.openminted.registry.domain.Corpus;
import eu.openminted.registry.domain.file.FileStats;
import eu.openminted.registry.utils.OMTDUtils;
import eu.openminted.store.restclient.StoreRESTClient;
import org.springframework.batch.core.configuration.annotation.StepScope;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.batch.item.ItemWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@StepScope
public class OperationQuotaProcessor implements ItemProcessor<Corpus,FileStats>, ItemWriter<FileStats> {


    private ResourceCRUDService<FileStats, ?> operationService;

    @Autowired
    public OperationQuotaProcessor(ResourceCRUDService<FileStats, ?> operationService) {
        this.operationService = operationService;
    }

    @Override
    public FileStats process(Corpus item) {
        return null;
    }

    @Override
    public void write(List<? extends FileStats> items) throws Exception {
        for(FileStats item : items) {
            this.operationService.add(item,null);
        }
    }
}
