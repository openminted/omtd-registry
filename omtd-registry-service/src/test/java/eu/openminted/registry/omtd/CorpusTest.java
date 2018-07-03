package eu.openminted.registry.omtd;

import eu.openminted.registry.core.service.ServiceException;
import eu.openminted.registry.domain.*;
import eu.openminted.registry.utils.OMTDUtils;
import org.junit.Before;
import org.junit.Test;

import java.util.UUID;

import static org.junit.Assert.*;

public class CorpusTest {


    private Corpus corpus;

    @Before
    public void prepareCorpus() {
        corpus = new Corpus();
        corpus.setCorpusInfo(new CorpusInfo());
        corpus.getCorpusInfo().setIdentificationInfo(new IdentificationInfo());
        corpus.getCorpusInfo().setDatasetDistributionInfo(new DatasetDistributionInfo());
    }

    @Test
    public void testWithArchiveIdIdentifier() {
        String value = UUID.randomUUID().toString();
        ResourceIdentifier resourceIdentifier = new ResourceIdentifier();
        resourceIdentifier.setSchemeURI("archiveID");
        resourceIdentifier.setResourceIdentifierSchemeName(ResourceIdentifierSchemeNameEnum.OTHER);
        resourceIdentifier.setValue(value);
        corpus.getCorpusInfo().getDatasetDistributionInfo().setDistributionLocation("dummyValue");
        corpus.getCorpusInfo().getIdentificationInfo().getResourceIdentifiers().add(resourceIdentifier);
        assertEquals(value, OMTDUtils.resolveCorpusArchive(corpus));
    }

    @Test
    public void testWithArchiveIdLocation() {
        String value = UUID.randomUUID().toString();
        corpus.getCorpusInfo().getDatasetDistributionInfo().setDistributionLocation("http://test.openminted.eu/request/corpus/download?archiveId=" + value);
        assertEquals(value, OMTDUtils.resolveCorpusArchive(corpus));
    }

    @Test(expected = ServiceException.class)
    public void testWithNone() {
        String value = UUID.randomUUID().toString();
        corpus.getCorpusInfo().getDatasetDistributionInfo().setDistributionLocation("http://test.openminted.eu/request/corpus");
        assertEquals(value, OMTDUtils.resolveCorpusArchive(corpus));
    }
}
