package eu.openminted.registry.service.other;


import eu.openminted.registry.core.domain.Browsing;
import eu.openminted.registry.core.domain.FacetFilter;
import eu.openminted.registry.domain.SizeQuota;
import eu.openminted.registry.domain.file.FileStats;
import eu.openminted.registry.service.FileStatsService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

/**
 * Created by stefanos on 30/6/2017.
 */
@Service("fileStatsService")
@Primary
public class FileStatsServiceImpl extends OtherGenericService<FileStats> implements FileStatsService {

    private static final String OMTD_ID = "omtdId";

    private Logger logger = LogManager.getLogger(FileStatsServiceImpl.class);

    public FileStatsServiceImpl() {
        super(FileStats.class);
    }

    @Override
    String getResourceId() {
        return OMTD_ID;
    }

    @Override
    public String getResourceType() {
        return "filestats";
    }

    @Override
    public SizeQuota getUserQuota(String sub) {
        FacetFilter filter = new FacetFilter();
        filter.setQuantity(1000);
        filter.setKeyword("personIdentifier=" + sub);
        Browsing<FileStats> fileStats = this.cqlQuery(filter);
        return new SizeQuota(sub,fileStats.getResults());
    }
}
