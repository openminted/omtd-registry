package eu.openminted.registry.service.tool;


import eu.openminted.registry.core.exception.ResourceNotFoundException;
import eu.openminted.registry.core.service.ParserService;
import eu.openminted.registry.core.service.ResourceCRUDService;
import eu.openminted.registry.domain.*;
import eu.openminted.registry.service.ZenodoService;
import eu.openminted.registry.utils.OMTDUtils;
import eu.openminted.store.restclient.StoreRESTClient;
import net.sf.saxon.s9api.*;
import org.apache.commons.io.IOUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.json.JSONObject;
import org.mitre.openid.connect.model.OIDCAuthenticationToken;
import org.springframework.beans.factory.annotation.*;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import javax.xml.transform.Source;
import javax.xml.transform.stream.StreamSource;
import java.io.*;
import java.util.concurrent.ExecutionException;

/**
 * Created by spyroukostas on 16-Mar-2018.
 */

@Service("zenodoService")
public class ZenodoServiceImpl implements ZenodoService {

    @Autowired
    StoreRESTClient storeClient;
    @Autowired
    ParserService parserPool;
    @Autowired
    @Qualifier("corpusService")
    ResourceCRUDService<Corpus, OIDCAuthenticationToken> corpusService;
    private Logger logger = LogManager.getLogger(ZenodoServiceImpl.class);
    private RestTemplate restTemplate = new RestTemplate();
    @Value("${zenodo.host}")
    private String host;
    @Value("${zenodo.token}")
    private String token;
    @Value("classpath:eu/openminted/registry/service/corpusMetadataToJson.xsl")
    private Resource xslFile;

    /**
     * Function that tests all Zenodo methods.
     *
     * @param corpusId
     * @return
     */
    private String test(String corpusId) throws IOException {
        String deposition_id = null;
        String zenodo_metadata = createZenodoMetadata(corpusId);
        deposition_id = createDeposition();
        updateDeposition(deposition_id, zenodo_metadata);
        deleteDeposition(deposition_id);
        deposition_id = createDeposition(zenodo_metadata);
        retrieveDeposition(deposition_id);
        File file = null;
        try {
            file = File.createTempFile("test", "tmp");
            FileWriter fileWriter = new FileWriter(file);
            fileWriter.write("This is a test deposition");
            fileWriter.flush();
            fileWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        String file_id = uploadFile(deposition_id, file);
        file.delete();
//        updateFile(deposition_id, file_id, "NewName.txt");
        String doi = publish(deposition_id);
        String file_info = retrieveFile(deposition_id, file_id);
        edit(deposition_id, zenodo_metadata);
        discard(deposition_id);
        return file_info;
    }

    @Override
    public String publishCorpus(String corpusId) {
        String deposition_id;
        String doi = null;

        File file;
        try {
            String zenodo_metadata = createZenodoMetadata(corpusId);
            logger.info(zenodo_metadata);
            deposition_id = createDeposition(zenodo_metadata);
            file = File.createTempFile("corpus", ".zip");
            storeClient.downloadArchive(OMTDUtils.resolveCorpusArchive(corpusService.get(corpusId)), file
                    .getAbsolutePath());
            uploadFile(deposition_id, file);
            file.delete();

            doi = publish(deposition_id);
            insertDoiToMetadata(corpusId, doi);


        } catch (IOException e) {
            e.printStackTrace();
        } catch (RuntimeException e) {
            e.printStackTrace();
        }
        return doi;
    }

    @Override
    public String createDeposition() {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.set("Authorization", "Bearer " + token);

        HttpEntity<String> request = new HttpEntity<>("{}", headers);
        logger.info("POST request: " + request.toString());

        ResponseEntity<String> response = restTemplate.exchange(host, HttpMethod.POST, request, String.class);
        if (response.getStatusCode().value() != 201) {
            throw new RuntimeException("Zenodo createDeposition error code: " + response.getStatusCode().value());
        }
        JSONObject res = new JSONObject(response.getBody());
        return res.get("id").toString();
    }

    @Override
    public String createDeposition(String metadata) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.set("Authorization", "Bearer " + token);

        HttpEntity<String> request = new HttpEntity<>(metadata, headers);
        logger.info("createDeposition : POST request: " + request.toString());

        ResponseEntity<String> response = restTemplate.exchange(host, HttpMethod.POST, request, String.class);
        if (response.getStatusCode().value() != 201) {
            throw new RuntimeException("Zenodo createDeposition error code: " + response.getStatusCode().value());
        }
        JSONObject res = new JSONObject(response.getBody());
//        logger.info(response);
        return res.get("id").toString();
    }

    @Override
    public JSONObject listDepositions() {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.set("Authorization", "Bearer " + token);

        HttpEntity<String> request = new HttpEntity<>("", headers);
        logger.info("GET request: " + request.toString());

        ResponseEntity<String> response = restTemplate.exchange(host, HttpMethod.GET, request, String.class);
        if (response.getStatusCode().value() != 200) {
            throw new RuntimeException("Zenodo listDepositions error code: " + response.getStatusCode().value());
        }
        return new JSONObject(response.getBody());
    }

    @Override
    public JSONObject retrieveDeposition(String zenodo_id) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.set("Authorization", "Bearer " + token);

        HttpEntity<String> request = new HttpEntity<>("", headers);
        logger.info("GET request: " + request.toString());

        ResponseEntity<String> response = restTemplate.exchange(
                host + "/" + zenodo_id, HttpMethod.GET, request, String.class);
        if (response.getStatusCode().value() != 200) {
            throw new RuntimeException("Zenodo retrieveDeposition error code: " + response.getStatusCode().value());
        }
        return new JSONObject(response.getBody());
    }

    @Override
    public String updateDeposition(String zenodo_id, String metadata) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.set("Authorization", "Bearer " + token);

        HttpEntity<String> request = new HttpEntity<>(metadata, headers);
        logger.info("PUT request: " + request.toString());

        ResponseEntity<String> response = restTemplate.exchange(
                host + "/" + zenodo_id, HttpMethod.PUT, request, String.class);
        if (response.getStatusCode().value() != 200) {
            throw new RuntimeException("Zenodo updateDeposition error code: " + response.getStatusCode().value());
        }
        JSONObject res = new JSONObject(response.getBody());
        return res.get("id").toString();
    }

    @Override
    public void deleteDeposition(String zenodo_id) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.set("Authorization", "Bearer " + token);

        HttpEntity<String> request = new HttpEntity<>("", headers);
        logger.info("DELETE request: " + request.toString());

        ResponseEntity<String> response = restTemplate.exchange(
                host + "/" + zenodo_id, HttpMethod.DELETE, request, String.class);
        if (response.getStatusCode().value() != 204) {
            throw new RuntimeException("Zenodo deleteDeposition error code: " + response.getStatusCode().value());
        }
    }

    @Override
    public String uploadFile(String zenodoId, File file) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.MULTIPART_FORM_DATA);
        headers.set("Authorization", "Bearer " + token);

        LinkedMultiValueMap<String, Object> parts = new LinkedMultiValueMap<>();
        parts.add("file", new FileSystemResource(file));
        HttpEntity<MultiValueMap<String, Object>> request = new HttpEntity<>(parts, headers);

        ResponseEntity<String> response = restTemplate.exchange(
                host + "/" + zenodoId + "/files", HttpMethod.POST, request, String.class);
        if (response.getStatusCode().value() != 201) {
            throw new RuntimeException("Zenodo uploadFile error code: " + response.getStatusCode().value());
        }
        JSONObject res = new JSONObject(response.getBody());
//        logger.info("uploadFile response:" + res.toString());
        return res.get("id").toString();
    }

    @Override
    public String sort(String zenodoId, JSONObject ids) {
        // TODO method
        return null;
    }

    @Override
    public String retrieveFile(String zenodoId, String fileId) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.set("Authorization", "Bearer " + token);

        HttpEntity<String> request = new HttpEntity<>("", headers);
        logger.info("retrieveFile : GET request: " + request.toString());

        ResponseEntity<String> response = restTemplate.exchange(
                host + "/" + zenodoId + "/files/" + fileId, HttpMethod.GET, request, String.class);
        if (response.getStatusCode().value() != 200) {
            throw new RuntimeException("Zenodo update error code: " + response.getStatusCode().value());
        }
        return response.getBody();
    }

    @Override
    public String updateFile(String zenodoId, String fileId, String newName) {
        // FIXME: needs debugging
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.set("Authorization", "Bearer " + token);

//        HttpEntity<String> request = new HttpEntity<>(newName, headers);
//        logger.info("updateFile : PUT request: " + request.toString());

        LinkedMultiValueMap<String, Object> parts = new LinkedMultiValueMap<>();
        parts.add("filename", newName);
        HttpEntity<MultiValueMap<String, Object>> request = new HttpEntity<>(parts, headers);

        ResponseEntity<String> response = restTemplate.exchange(
                host + "/" + zenodoId + "/files/" + fileId, HttpMethod.PUT, request, String.class);
        if (response.getStatusCode().value() != 200) {
            logger.error(response.toString());
            throw new RuntimeException("Zenodo updateFile error code: " + response.getStatusCode().value());
        }
        return response.getBody();
    }

    @Override
    public void deleteFile(String zenodoId, String fileId) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.set("Authorization", "Bearer " + token);

        HttpEntity<String> request = new HttpEntity<>("", headers);
        logger.info("deleteFile : DELETE request: " + request.toString());

        ResponseEntity<String> response = restTemplate.exchange(
                host + "/" + zenodoId + "/files/" + fileId, HttpMethod.DELETE, request, String.class);
        if (response.getStatusCode().value() != 204) {
            throw new RuntimeException("Zenodo deleteFile error code: " + response.getStatusCode().value());
        }
    }

    @Override
    public String publish(String zenodoId) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.set("Authorization", "Bearer " + token);

        HttpEntity<String> request = new HttpEntity<>("{}", headers);
        logger.info("publish : POST request: " + request.toString());

        ResponseEntity<String> response = restTemplate.exchange(
                host + "/" + zenodoId + "/actions/publish", HttpMethod.POST, request, String.class);
        if (response.getStatusCode().value() != 202) {
            throw new RuntimeException("Zenodo publish error code: " + response.getStatusCode().value());
        }
        JSONObject res = new JSONObject(response.getBody());
        return res.get("doi").toString();
    }

    @Override
    public String edit(String zenodoId, String metadata) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.set("Authorization", "Bearer " + token);

        HttpEntity<String> request = new HttpEntity<>(metadata, headers);
        logger.info("POST request: " + request.toString());

        ResponseEntity<String> response = restTemplate.exchange(
                host + "/" + zenodoId + "/actions/edit", HttpMethod.POST, request, String.class);
        if (response.getStatusCode().value() != 201) {
            throw new RuntimeException("Zenodo edit error code: " + response.getStatusCode().value());
        }
        return response.getBody();
    }

    @Override
    public void discard(String zenodoId) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.set("Authorization", "Bearer " + token);

        HttpEntity<String> request = new HttpEntity<>("", headers);
        logger.info("POST request: " + request.toString());

        ResponseEntity<String> response = restTemplate.exchange(
                host + "/" + zenodoId + "/actions/discard", HttpMethod.POST, request, String.class);
        if (response.getStatusCode().value() != 201) {
            throw new RuntimeException("Zenodo discard error code: " + response.getStatusCode().value());
        }
    }

    @Override
    public String newVersion(String zenodoId) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.set("Authorization", "Bearer " + token);

        HttpEntity<String> request = new HttpEntity<>("", headers);
        logger.info("POST request: " + request.toString());

        ResponseEntity<String> response = restTemplate.exchange(
                host + "/" + zenodoId + "/actions/newversion", HttpMethod.POST, request, String.class);
        if (response.getStatusCode().value() != 201) {
            throw new RuntimeException("Zenodo discard error code: " + response.getStatusCode().value());
        }
        JSONObject res = new JSONObject(response.getBody());
//        logger.info(response.toString());
        return res.get("id").toString();
    }

    /**
     * Downloads the metadata of a corpus with id = {@param corpusId}.
     * Transforms the metadata to be compatible with
     * <a href="http://developers.zenodo.org/?python#representation">Zenodo</a>.
     *
     * @param corpusId
     * @return
     */
    private String createZenodoMetadata(String corpusId) throws IOException {
        String corpusXML = "";
        Corpus corpus = corpusService.get(corpusId);
        corpusXML = parserPool.serialize(corpus, ParserService.ParserServiceTypes.XML);
        corpusXML = corpusXML.replaceAll("&quot;","\\\\&quot;");
        logger.info("corpus metadata: " + corpusXML);

        Processor processor = new Processor(false);
        XsltCompiler xsltCompiler = processor.newXsltCompiler();
        StreamSource stylesource = new StreamSource(xslFile.getFile());

        XsltExecutable xsltExecutable;
        String result = null;
        XdmNode source = null;
        try {
            xsltExecutable = xsltCompiler.compile(stylesource);
            XsltTransformer xsltTransformer = xsltExecutable.load();

            Source src = new StreamSource(IOUtils.toInputStream(corpusXML));
            source = processor.newDocumentBuilder().build(src);

            Serializer out = new Serializer();
            out.setOutputProperty(Serializer.Property.METHOD, "text");
            out.setOutputProperty(Serializer.Property.INDENT, "yes");

            StringWriter sw = new StringWriter();
            out.setOutputWriter(sw);

            xsltTransformer.setInitialContextNode(source);
            xsltTransformer.setDestination(out);
            xsltTransformer.transform();
            result = sw.toString();

        } catch (SaxonApiException e) {
            e.printStackTrace();
        }
        if (result == null) {
            logger.warn("createZenodoMetadata returned " + result);
            return null;
        }
        logger.info(result);
        return new JSONObject(result).toString();
    }

    private void insertDoiToMetadata(String corpusId, String doi) throws IOException {
        Corpus corpus = corpusService.get(corpusId);
        ResourceIdentifier r = new ResourceIdentifier();
        r.setResourceIdentifierSchemeName(ResourceIdentifierSchemeNameEnum.DOI);
        r.setValue(doi);
        corpus.getCorpusInfo().getIdentificationInfo().getResourceIdentifiers().add(r);

        try {
            corpusService.update(corpus,null);
            logger.info("Updated corpus metadata with DOI");
        } catch (ResourceNotFoundException e) {
            e.printStackTrace();
        }
    }
}
