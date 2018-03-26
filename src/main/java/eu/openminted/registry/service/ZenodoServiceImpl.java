package eu.openminted.registry.service;


import eu.openminted.registry.core.service.ParserService;
import eu.openminted.registry.core.service.ResourceCRUDService;
import eu.openminted.registry.core.service.ServiceException;
import eu.openminted.registry.domain.Corpus;
import eu.openminted.store.restclient.StoreRESTClient;
import net.sf.saxon.s9api.*;
import org.apache.commons.io.IOUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.FileSystemResource;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import javax.xml.transform.Source;
import javax.xml.transform.stream.StreamSource;
import java.io.*;
import java.util.concurrent.ExecutionException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by spyroukostas on 16-Mar-2018.
 */

@Service("zenodoService")
public class ZenodoServiceImpl implements ZenodoService {

    private Logger logger = LogManager.getLogger(ZenodoServiceImpl.class);

    private RestTemplate restTemplate = new RestTemplate();

    @Value("${zenodo.host}")
    private String host;

    @Value("${zenodo.token}")
    private String token;

    @Value("${zenodo.xsl}")
    private String xsl_file;

    @Autowired
    StoreRESTClient storeClient;

    @Autowired
    ParserService parserPool;

    @Autowired
    @Qualifier("corpusService")
    ResourceCRUDService<Corpus> corpusService;


    @Override
    public String publishCorpus(String corpusId) {
        String zenodo_metadata = createZenodoMetadata(corpusId);
        logger.info(zenodo_metadata);
        String ret = createDeposition();
        updateDeposition(ret, zenodo_metadata);
        deleteDeposition(ret);
        logger.info("deleted entry: " + ret);

        ret = createDeposition(zenodo_metadata);
        retrieveDeposition(ret);
        File f = null;
        try {
            f = File.createTempFile("corpus", ".zip");

            storeClient.downloadArchive(resolveCorpusArchive(corpusId), f.getAbsolutePath());
            logger.info("downloaded file: "+f.getAbsolutePath()+" can write: "+ f.canWrite());
            uploadFile(ret, f);
            f.delete();
//            publish(ret);
        } catch (Exception e) {
            e.printStackTrace();
        }

//        JSONObject response = new JSONObject(ret);
//        return response.get("id").toString();
        return listDepositions();
    }

    @Override
    public String createDeposition() {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.set("Authorization", "Bearer " + token);

        HttpEntity<String> request = new HttpEntity<>("{}", headers);
        logger.info("POST request: " + request.toString());

        ResponseEntity<String> response = restTemplate.exchange( host, HttpMethod.POST, request , String.class );
        if (response.getStatusCode().value() != 201) {
            throw new RuntimeException("Zenodo createDeposition error code: "+response.getStatusCode().value());
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
        logger.info("POST request: " + request.toString());

        ResponseEntity<String> response = restTemplate.exchange( host, HttpMethod.POST, request , String.class );
        if (response.getStatusCode().value() != 201) {
            throw new RuntimeException("Zenodo createDeposition error code: "+response.getStatusCode().value());
        }
        JSONObject res = new JSONObject(response.getBody());
        return res.get("id").toString();
    }

    @Override
    public String listDepositions() {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.set("Authorization", "Bearer " + token);

        HttpEntity<String> request = new HttpEntity<>("", headers);
        logger.info("GET request: " + request.toString());

        ResponseEntity<String> response = restTemplate.exchange( host, HttpMethod.GET, request, String.class );
        if (response.getStatusCode().value() != 200) {
            throw new RuntimeException("Zenodo listDepositions error code: "+response.getStatusCode().value());
        }
        return response.getBody();
    }

    @Override
    public String retrieveDeposition(String zenodo_id) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.set("Authorization", "Bearer " + token);

        HttpEntity<String> request = new HttpEntity<>("", headers);
        logger.info("GET request: " + request.toString());

        ResponseEntity<String> response = restTemplate.exchange(
                host+"/"+zenodo_id, HttpMethod.GET, request, String.class );
        if (response.getStatusCode().value() != 200) {
            throw new RuntimeException("Zenodo retrieveDeposition error code: "+response.getStatusCode().value());
        }
        return response.getBody();
    }

    @Override
    public String updateDeposition(String zenodo_id, String metadata) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.set("Authorization", "Bearer " + token);

        HttpEntity<String> request = new HttpEntity<>(metadata, headers);
        logger.info("PUT request: " + request.toString());

        ResponseEntity<String> response = restTemplate.exchange(
                host+"/"+zenodo_id, HttpMethod.PUT, request, String.class );
        if (response.getStatusCode().value() != 200) {
            throw new RuntimeException("Zenodo updateDeposition error code: "+response.getStatusCode().value());
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
                host+"/"+zenodo_id, HttpMethod.DELETE, request, String.class );
        if (response.getStatusCode().value() != 204) {
            throw new RuntimeException("Zenodo deleteDeposition error code: "+response.getStatusCode().value());
        }
    }

    @Override
    public String uploadFile(String zenodoId, File file) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.MULTIPART_FORM_DATA);
        headers.set("Authorization", "Bearer " + token);

//        MultipartEntityBuilder builder = MultipartEntityBuilder.create();
//        try {
//            builder.addBinaryBody(
//                    "file",
//                    new FileInputStream(file),
//                    ContentType.APPLICATION_OCTET_STREAM,
//                    file.getName());
//        } catch (FileNotFoundException e) {
//            e.printStackTrace();
//        }
//        HttpEntity request = (HttpEntity) builder.build();

        LinkedMultiValueMap<String, Object> parts = new LinkedMultiValueMap<>();
        parts.add("file", new FileSystemResource(file));
        HttpEntity<MultiValueMap<String, Object>> request = new HttpEntity<>(parts, headers);

        ResponseEntity<String> response = restTemplate.exchange(
                host+"/"+zenodoId+"/files", HttpMethod.POST, request , String.class );
        if (response.getStatusCode().value() != 201) {
            throw new RuntimeException("Zenodo uploadFile error code: "+response.getStatusCode().value());
        }
        JSONObject res = new JSONObject(response.getBody());
        logger.info("uploadFile response:" + res.toString());
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
        logger.info("GET request: " + request.toString());

        ResponseEntity<String> response = restTemplate.exchange(
                host+"/"+zenodoId+"/files/"+fileId, HttpMethod.GET, request, String.class );
        if (response.getStatusCode().value() != 200) {
            throw new RuntimeException("Zenodo update error code: "+response.getStatusCode().value());
        }
        return response.getBody();
    }

    @Override
    public String updateFile(String zenodoId, String fileId, String newName) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.set("Authorization", "Bearer " + token);

        HttpEntity<String> request = new HttpEntity<>(newName, headers);
        logger.info("PUT request: " + request.toString());

        ResponseEntity<String> response = restTemplate.exchange(
                host+"/"+zenodoId+"/files/"+fileId, HttpMethod.PUT, request, String.class );
        if (response.getStatusCode().value() != 200) {
            throw new RuntimeException("Zenodo updateFile error code: "+response.getStatusCode().value());
        }
        return response.getBody();
    }

    @Override
    public void deleteFile(String zenodoId, String fileId) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.set("Authorization", "Bearer " + token);

        HttpEntity<String> request = new HttpEntity<>("", headers);
        logger.info("DELETE request: " + request.toString());

        ResponseEntity<String> response = restTemplate.exchange(
                host+"/"+zenodoId+"/files/"+fileId, HttpMethod.DELETE, request, String.class );
        if (response.getStatusCode().value() != 204) {
            throw new RuntimeException("Zenodo deleteFile error code: "+response.getStatusCode().value());
        }
    }

    @Override
    public void publish(String zenodoId) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.set("Authorization", "Bearer " + token);

        HttpEntity<String> request = new HttpEntity<>("{}", headers);
        logger.info("POST request: " + request.toString());

        ResponseEntity<String> response = restTemplate.exchange(
                host+"/"+zenodoId+"/actions/publish", HttpMethod.POST, request , String.class );
        if (response.getStatusCode().value() != 202) {
            throw new RuntimeException("Zenodo publish error code: "+response.getStatusCode().value());
        }
    }

    @Override
    public String edit(String zenodoId) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.set("Authorization", "Bearer " + token);

        HttpEntity<String> request = new HttpEntity<>("{}", headers);
        logger.info("POST request: " + request.toString());

        ResponseEntity<String> response = restTemplate.exchange(
                host+"/"+zenodoId+"/actions/edit", HttpMethod.POST, request , String.class );
        if (response.getStatusCode().value() == 201) {
            throw new RuntimeException("Zenodo edit error code: "+response.getStatusCode().value());
        }
        return response.getBody();
    }

    @Override
    public void discard(String zenodoId) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.set("Authorization", "Bearer " + token);

        HttpEntity<String> request = new HttpEntity<>("{}", headers);
        logger.info("POST request: " + request.toString());

        ResponseEntity<String> response = restTemplate.exchange(
                host+"/"+zenodoId+"/actions/discard", HttpMethod.POST, request , String.class );
        if (response.getStatusCode().value() != 201) {
            throw new RuntimeException("Zenodo discard error code: "+response.getStatusCode().value());
        }
    }

    /**
     * Resolves archiveId from corpusId.
     *
     * @param corpusId
     * @return archiveId
     */
    private String resolveCorpusArchive(String corpusId) {
        final Pattern pattern = Pattern.compile(".*?\\?archiveId=(?<archive>[\\d\\w-]+)$");
        Corpus corpus = corpusService.get(corpusId);
        if (corpus == null) {
            logger.error("Corpus with id " + corpusId + " not found");
            throw new ServiceException("Corpus with id " + corpusId + " not found");
        }
        String distributionLocation = corpus.getCorpusInfo().getDatasetDistributionInfo().getDistributionLocation();
        Matcher archiveMatcher = pattern.matcher(distributionLocation);
        if (!archiveMatcher.find()) {
            throw new ServiceException("No archive Id was present");
        }
        String archiveId = archiveMatcher.group("archive");
        logger.debug(archiveId);
        return archiveId;
    }


    /**
     *
     * @param corpusId
     * @return
     */
    private String createZenodoMetadata(String corpusId) {
        String corpusXML = "";
        Corpus corpus = corpusService.get(corpusId);
        try {
            corpusXML = parserPool.serialize(corpus, ParserService.ParserServiceTypes.XML).get();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        logger.info("corpus metadata: " + corpusXML);

        Processor processor = new Processor(false);
        XsltCompiler xsltCompiler = processor.newXsltCompiler();
        StreamSource stylesource =
                new StreamSource(new File(this.getClass().getClassLoader()
                        .getResource(xsl_file).getFile()));

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
}
