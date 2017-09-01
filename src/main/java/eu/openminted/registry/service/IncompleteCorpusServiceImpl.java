package eu.openminted.registry.service;

import eu.openminted.registry.domain.Corpus;
import eu.openminted.store.restclient.StoreRESTClient;
import org.apache.commons.io.FileDeleteStrategy;
import org.apache.commons.io.IOUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

import java.io.*;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

/**
 * Created by stefanos on 15-Nov-16.
 */
@Service("incompleteCorpusService")
@Primary
public class IncompleteCorpusServiceImpl extends OmtdGenericService<Corpus> implements IncompleteCorpusService {

    private Logger logger = Logger.getLogger(IncompleteCorpusServiceImpl.class);


    public IncompleteCorpusServiceImpl() {
        super(Corpus.class);
    }

    @Override
    public String getResourceType() {
        return "incompleteCorpus";
    }
}
