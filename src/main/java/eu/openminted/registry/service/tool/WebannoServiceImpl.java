package eu.openminted.registry.service.tool;


import eu.openminted.registry.service.WebannoService;
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


@Service("webannoService")
public class WebannoServiceImpl implements WebannoService{

    private Logger logger = LogManager.getLogger(WebannoServiceImpl.class);

    private RestTemplate restTemplate = new RestTemplateBuilder().customizers(new LoggingCustomizer()).build();

    @Value("${webanno.host:https://webanno.openminted.eu/api/v2}")
    private String webannoHost;

    @Value("${webanno.username}")
    private String webannoUsername;

    @Value("${webanno.password}")
    private String webannoPassword;

    @Autowired
    StoreRESTClient storeClient;

    @Override
    public boolean createProject(String corpusId) {

        MultiValueMap<String, String> map= new LinkedMultiValueMap<String, String>();
        map.add("name", corpusId);

        HttpHeaders headers = new HttpHeaders();
        headers.add("Authorization","Basic "+basicAuth());
        headers.setContentType(MediaType.MULTIPART_FORM_DATA);

        HttpEntity<MultiValueMap<String, String>> request = new HttpEntity<MultiValueMap<String, String>>(map, headers);
        ResponseEntity response = restTemplate.postForEntity(webannoHost+"/projects",request, String.class);
        if(response.getStatusCode() == HttpStatus.CREATED) {
            int projectId = new JSONObject(response.getBody().toString()).getJSONObject("body").getInt("id");
            File metadata_zip = new File(System.getProperty("java.io.tmpdir") + "/corpus_annotations/" + corpusId + ".zip");
            File metadata_dir = new File(FilenameUtils.removeExtension(metadata_zip.toString()) + "/annotations");
            if (!metadata_dir.exists()) {
                metadata_zip.getParentFile().mkdirs();
                logger.info("Searching @ " + storeClient.getEndpoint() + "    with arguments id:" + corpusId + "   path:" + metadata_zip.toString());
                StoreResponse responseStore = storeClient.fetchAnnotations(corpusId, metadata_zip.toString());
                if (responseStore.getResponse().equals("true")) {
                    try {
                        File save_dir = new File(metadata_zip.getParent().toString());
                        ZipToDir.unpackToWorkDir(metadata_zip, save_dir);
                        for (File file : metadata_dir.listFiles()) {
                            if(FilenameUtils.getExtension(file.getName()).equals("xmi"))
                                uploadDocument(projectId,file);
                        }
                        save_dir.delete();
                    } catch (IOException e) {
                        deleteProject(projectId);
                        logger.error("Failed creating files ", e);
                        return false;
                    } finally { // delete zip file
                        try {
                            new File(System.getProperty("java.io.tmpdir") + "/corpus_annotations/" + corpusId).delete();
                        } catch (Exception e) {
                            logger.error("Failed deleting .zip", e);
                        }
                    }
                }
            }

            return true;
        }else {
            logger.debug(webannoHost + " returned " + response.getStatusCode() + " | Logger level ERROR for more info");
            logger.error(response.getBody().toString());
            return false;
        }
    }

    private void uploadDocument(int projectId, File file){
        MultiValueMap<String, Object> map= new LinkedMultiValueMap<String, Object>();
        map.add("name", file.getName());
        map.add("format", "xmi");
        map.add("content", new FileSystemResource(file));

        HttpHeaders headers = new HttpHeaders();
        headers.add("Authorization","Basic "+basicAuth());
//        headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);

        HttpEntity<MultiValueMap<String, Object>> request = new HttpEntity<MultiValueMap<String, Object>>(map, headers);
        ResponseEntity response = restTemplate.postForEntity(webannoHost+"/projects/"+String.valueOf(projectId)+"/documents",request, String.class);

        if(response.getStatusCode()!=HttpStatus.CREATED) {
            logger.info("Could not upload " + file.getName()+ " @ Webanno. Moving on to the next one");
        }else{
            logger.info("Uploaded " + file.getName());
        }

    }

    private void deleteProject(int projectId) {
        HttpHeaders headers = new HttpHeaders();
        headers.add("Authorization","Basic "+basicAuth());

        HttpEntity request = new HttpEntity<>(headers);
        restTemplate.delete(webannoHost+"/projects/"+projectId,request, String.class);

    }

    @Override
    public void triggerRetrieval(long projectId, String projectName) {
        HttpHeaders headers = new HttpHeaders();
        headers.add("Authorization","Basic "+basicAuth());

        HttpEntity request = new HttpEntity<>(headers);
        ResponseEntity<byte[]> response = restTemplate.exchange(webannoHost+"/projects/"+Math.toIntExact(projectId)+"/export.zip", HttpMethod.GET, request, byte[].class);
        if(response.getStatusCode() == HttpStatus.OK) {
            try {
                File temp = new File(System.getProperty("java.io.tmpdir") +"/"+ projectName + ".zip");
                Files.write(temp.toPath(), response.getBody());

                // WHAT TO DO WITH THE ZIP?



                deleteProject(Math.toIntExact(projectId));
            } catch (IOException e) {
                logger.error(e);
            }
        }else {
            logger.debug(webannoHost + " returned " + response.getStatusCode() + " | Logger level ERROR for more info");
            logger.error(response.getBody().toString());
        }



    }


    private String basicAuth(){
        return new String(Base64.encodeBytes((webannoUsername+":"+webannoPassword).getBytes()).getBytes());
    }
}