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
public class SizeCorpusProcessor implements ItemProcessor<Corpus,FileStats>, ItemWriter<FileStats> {

    private StoreRESTClient storeService;

    private ResourceCRUDService<FileStats, ?> fileStatsService;

    @Autowired
    public SizeCorpusProcessor(StoreRESTClient storeService, ResourceCRUDService<FileStats, ?> fileStatsService) {
        this.storeService = storeService;
        this.fileStatsService = fileStatsService;
    }

    @Override
    public FileStats process(Corpus item) {
        FileStats x = fileStatsService.get(item.getMetadataHeaderInfo().getMetadataRecordIdentifier().getValue());
        if(x != null) {
            return null;
        } else {
            String archiveId = OMTDUtils.resolveCorpusArchive(item);
            FileStats fileStats = new FileStats();
            fileStats.setArchiveId(archiveId);
            fileStats.setFilename(OMTDUtils.resolveIdentificationInfo(item).getResourceNames().get(0).getValue());
            fileStats.setPersonIdentifier(OMTDUtils.resolveUser(item));
            fileStats.setSizeOnDisk(storeService.getSizeOnDisk(archiveId));
            fileStats.setSize(storeService.getSize(archiveId));
            fileStats.setOmtdId(item.getMetadataHeaderInfo().getMetadataRecordIdentifier().getValue());
            return fileStats;
        }
    }

    @Override
    public void write(List<? extends FileStats> items) throws Exception {
        for(FileStats item : items) {
            this.fileStatsService.add(item,null);
        }
    }
}
