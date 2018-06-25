package eu.openminted.registry.service.tool;


import eu.openminted.registry.core.domain.Paging;
import eu.openminted.registry.core.domain.Resource;
import eu.openminted.registry.core.service.*;
import eu.openminted.registry.domain.*;
import eu.openminted.registry.service.*;
import eu.openminted.store.common.StoreResponse;
import eu.openminted.store.restclient.StoreRESTClient;
import eu.openminted.utils.files.ZipToDir;
import org.apache.commons.io.FilenameUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hobsoft.spring.resttemplatelogger.LoggingCustomizer;
import org.json.JSONObject;
import org.postgresql.util.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.core.io.FileSystemResource;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.ExecutionException;


@Service("webannoService")
public class WebannoServiceImpl implements WebannoService {

    @Autowired
    public ParserService parserPool;
    @Autowired
    CorpusService corpusService;
    @Autowired
    IncompleteCorpusService incompleteCorpusService;
    @Autowired
    SearchService searchService;
    @Autowired
    StoreRESTClient storeClient;
    private Logger logger = LogManager.getLogger(WebannoServiceImpl.class);
    private RestTemplate restTemplate = new RestTemplateBuilder().customizers(new LoggingCustomizer()).build();
    @Value("${webanno.host:https://webanno.openminted.eu/api/v2}")
    private String webannoHost;
    @Value("${webanno.username}")
    private String webannoUsername;
    @Value("${webanno.password}")
    private String webannoPassword;

    @Override
    public boolean createProject(String corpusId) {


        Corpus corpus = corpusService.get(corpusId);
        if (corpus == null)
            return false;

        ResourceIdentifier tempIdentifier = find(corpus, "archiveID");
        if (tempIdentifier == null) {
            logger.info("ArchiveID not found in corpus with id:" + corpusId);
            return false;
        }
        String newCorpusId = tempIdentifier.getValue();
        String oldCorpusId = newCorpusId;

        newCorpusId = storeClient.cloneArchive(newCorpusId).getResponse();

        if (newCorpusId == null) {
            logger.info("Failed to clone archive with id: " + oldCorpusId);
            return false;
        }

        ResourceIdentifier resourceIdentifier = new ResourceIdentifier();
        resourceIdentifier.setSchemeURI("archiveID");
        resourceIdentifier.setValue(newCorpusId);
        resourceIdentifier.setResourceIdentifierSchemeName(ResourceIdentifierSchemeNameEnum.OTHER);
        corpus.getCorpusInfo().getIdentificationInfo().getResourceIdentifiers().remove(tempIdentifier);
        corpus.getCorpusInfo().getIdentificationInfo().getResourceIdentifiers().add(resourceIdentifier);

        String projectName = corpus.getCorpusInfo().getIdentificationInfo().getResourceNames().get(0).getValue();

        MultiValueMap<String, String> map = new LinkedMultiValueMap<String, String>();
        map.add("name", projectName);
        HttpHeaders headers = new HttpHeaders();
        headers.add("Authorization", "Basic " + basicAuth());
        headers.setContentType(MediaType.MULTIPART_FORM_DATA);

        HttpEntity<MultiValueMap<String, String>> request = new HttpEntity<MultiValueMap<String, String>>(map, headers);
        ResponseEntity response = restTemplate.postForEntity(webannoHost + "/projects", request, String.class);
        if (response.getStatusCode() == HttpStatus.CREATED) {

            int projectId = new JSONObject(response.getBody().toString()).getJSONObject("body").getInt("id");

            resourceIdentifier = new ResourceIdentifier();
            resourceIdentifier.setSchemeURI("projectID");
            resourceIdentifier.setValue(projectId + "");
            resourceIdentifier.setResourceIdentifierSchemeName(ResourceIdentifierSchemeNameEnum.OTHER);
            corpus.getCorpusInfo().getIdentificationInfo().getResourceIdentifiers().add(resourceIdentifier);

            File metadata_zip = new File(System.getProperty("java.io.tmpdir") + "/corpus_annotations/" + newCorpusId
                    + ".zip");
            File metadata_dir = new File(FilenameUtils.removeExtension(metadata_zip.toString()) + "/annotations");
            if (!metadata_dir.exists()) {
                metadata_zip.getParentFile().mkdirs();
                logger.info("Searching @ " + storeClient.getEndpoint() + "    with arguments id:" + newCorpusId + "  " +
                        " path:" + metadata_zip.toString());
                StoreResponse responseStore = storeClient.fetchAnnotations(newCorpusId, metadata_zip.toString());
                if (responseStore.getResponse().equals("true")) {
                    try {
                        deleteFiles(newCorpusId, "fulltext");
                        File save_dir = new File(metadata_zip.getParent().toString());
                        ZipToDir.unpackToWorkDir(metadata_zip, save_dir);
                        for (File file : metadata_dir.listFiles()) {
                            if (FilenameUtils.getExtension(file.getName()).equals("xmi")) {
                                uploadDocument(projectId, file);
                            }
                        }
                        storeClient.moveFile(newCorpusId, "annotations", "fulltext");
                        deleteFiles(newCorpusId, "annotations");
                        corpus.getMetadataHeaderInfo().setRevision("output");
                        incompleteCorpusService.add(corpus);
                        save_dir.delete();
                    } catch (IOException e) {
                        deleteProject(projectId);
                        logger.error("Failed creating files ", e);
                        return false;
                    } finally { // delete zip file
                        try {
                            new File(System.getProperty("java.io.tmpdir") + "/corpus_annotations/" + newCorpusId)
                                    .delete();
                        } catch (Exception e) {
                            logger.error("Failed deleting .zip", e);
                        }
                    }
                }
            }

            return true;
        } else {
            logger.debug(webannoHost + " returned " + response.getStatusCode() + " | Logger level ERROR for more info");
            logger.error(response.getBody().toString());
            return false;
        }
    }

    @Override
    public void triggerRetrieval(long projectId, String projectName) {
        HttpHeaders headers = new HttpHeaders();
        headers.add("Authorization", "Basic " + basicAuth());

        HttpEntity request = new HttpEntity<>(headers);
        ResponseEntity<byte[]> response = restTemplate.exchange(webannoHost + "/projects/" + Math.toIntExact
                (projectId) + "/export.zip", HttpMethod.GET, request, byte[].class);
        if (response.getStatusCode() == HttpStatus.OK) {
            try {
                File temp = new File(System.getProperty("java.io.tmpdir") + "/" + projectName + ".zip");
                Files.write(temp.toPath(), response.getBody());
                Corpus corpus = findIdentifier(Math.toIntExact(projectId), "projectID");
                if (corpus != null) {
                    String archiveId = findId(corpus, "archiveID");
                    File save_dir = new File(temp.getParent());
                    ZipToDir.unpackToWorkDir(temp, save_dir);
                    File annotations_dir = new File(save_dir.getAbsolutePath() + "/source");
                    for (File file : annotations_dir.listFiles()) {
                        if (FilenameUtils.getExtension(file.getName()).equals("xmi")) {
                            storeClient.storeFile(file, archiveId, "annotations/" + file.getName());
                        }
                    }
                    storeClient.finalizeArchive(archiveId);
                    String omtdId = findId(corpus, "OMTD");
                    if (omtdId != null)
                        incompleteCorpusService.move(omtdId);
                    else
                        logger.debug("Could not find identifier OMTD of corpus");
                } else
                    logger.debug("Could not find identifier archiveID of corpus");

                deleteProject(Math.toIntExact(projectId));
            } catch (IOException e) {
                logger.error(e);
            }
        } else {
            logger.debug(webannoHost + " returned " + response.getStatusCode() + " | Logger level ERROR for more info");
            logger.error(response.getBody().toString());
        }


    }

    private void deleteFiles(String corpusId, String folder) {
        List<String> listFiles = storeClient.listFiles(corpusId + "/" + folder, false, false, true);
        for (String file : listFiles) {
            logger.info("Deleting :" + file);
            storeClient.deleteFile(corpusId, folder + "/" + file.split("/")[2]);
        }
    }

    private void uploadDocument(int projectId, File file) {
        MultiValueMap<String, Object> map = new LinkedMultiValueMap<String, Object>();
        map.add("name", file.getName());
        map.add("format", "xmi");
        map.add("content", new FileSystemResource(file));

        HttpHeaders headers = new HttpHeaders();
        headers.add("Authorization", "Basic " + basicAuth());

        HttpEntity<MultiValueMap<String, Object>> request = new HttpEntity<MultiValueMap<String, Object>>(map, headers);
        ResponseEntity response = restTemplate.postForEntity(webannoHost + "/projects/" + String.valueOf(projectId) +
                "/documents", request, String.class);

        if (response.getStatusCode() != HttpStatus.CREATED) {
            logger.info("Could not upload " + file.getName() + " @ Webanno. Moving on to the next one");
        } else {
            logger.info("Uploaded " + file.getName());
        }

    }

    private void deleteProject(int projectId) {
        logger.info("Deleting " + projectId + "   " + basicAuth());
        HttpHeaders headers = new HttpHeaders();
        headers.add("Authorization", "Basic " + basicAuth());


        HttpEntity request = new HttpEntity<>(headers);
        restTemplate.delete(webannoHost + "/projects/" + projectId, headers, String.class);

    }

    private String findId(Corpus corpus, String idType) {
        Optional<ResourceIdentifier> identifier = corpus.getCorpusInfo().getIdentificationInfo()
                .getResourceIdentifiers()
                .stream()
                .filter(p -> p.getResourceIdentifierSchemeName().equals(ResourceIdentifierSchemeNameEnum.OTHER) &&
                        idType.equals(p.getSchemeURI()))
                .findFirst();
        if (!identifier.isPresent()) {
            return null;
        } else {
            return identifier.get().getValue();
        }
    }

    private ResourceIdentifier find(Corpus corpus, String idType) {
        Optional<ResourceIdentifier> identifier = corpus.getCorpusInfo().getIdentificationInfo()
                .getResourceIdentifiers()
                .stream()
                .filter(p -> p.getResourceIdentifierSchemeName().equals(ResourceIdentifierSchemeNameEnum.OTHER) &&
                        idType.equals(p.getSchemeURI()))
                .findFirst();
        return identifier.orElse(null);
    }

    private Corpus findIdentifier(int projectId, String identifierName) {
        try {
            Paging paging= searchService.cqlQuery("payload=*"+identifierName+"*","incompletecorpus",10, 0, "", "ASC");
            if(paging==null) {
                return null;
            }

            for (Resource res : (List<Resource>) paging.getResults()) {
                Corpus corpus = parserPool.deserialize(res, Corpus.class).get();
                for (ResourceIdentifier resourceIdentifier : corpus.getCorpusInfo().getIdentificationInfo()
                        .getResourceIdentifiers()) {
                    if (resourceIdentifier.getSchemeURI() != null && resourceIdentifier.getSchemeURI().equals
                            (identifierName) && Integer.parseInt(resourceIdentifier.getValue()) == projectId) {
                        return corpus;
                    }
                }
            }
        } catch (ExecutionException | InterruptedException e) {
            logger.fatal("get omtd generic", e);
            throw new ServiceException(e);
        }

        return null;
    }


    private String basicAuth() {
        return new String(Base64.encodeBytes((webannoUsername + ":" + webannoPassword).getBytes()).getBytes());
    }
}