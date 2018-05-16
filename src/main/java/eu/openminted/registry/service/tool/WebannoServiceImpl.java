package eu.openminted.registry.service.tool;


import eu.openminted.registry.service.WebannoService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hobsoft.spring.resttemplatelogger.LoggingCustomizer;
import org.json.JSONObject;
import org.postgresql.util.Base64;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.core.io.FileSystemResource;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import java.io.File;


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

    @Override
    public boolean createProject(String corpusId) {

        MultiValueMap<String, String> map= new LinkedMultiValueMap<String, String>();
        map.add("name", corpusId);

        HttpHeaders headers = new HttpHeaders();
        headers.add("Authorization","Basic "+basicAuth());
        headers.setContentType(MediaType.MULTIPART_FORM_DATA);

        HttpEntity<MultiValueMap<String, String>> request = new HttpEntity<MultiValueMap<String, String>>(map, headers);
        ResponseEntity response = restTemplate.postForEntity(webannoHost+"/projects",request, String.class);
        logger.error(response.getStatusCode());
        if(response.getStatusCode().value()==201) {
            int projectId = new JSONObject(response.getBody().toString()).getJSONObject("body").getInt("id");

//            for(File file : listFiles()){
//                uploadDocument(projectId, file);
//            }


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
        map.add("format", "XMI");
        map.add("content", new FileSystemResource(file));

        HttpHeaders headers = new HttpHeaders();
        headers.add("Authorization","Basic "+basicAuth());
        headers.setContentType(MediaType.MULTIPART_FORM_DATA);

        HttpEntity<MultiValueMap<String, Object>> request = new HttpEntity<MultiValueMap<String, Object>>(map, headers);
        ResponseEntity response = restTemplate.postForEntity(webannoHost+"/projects/"+String.valueOf(projectId)+"/documents",request, String.class);

        if(response.getStatusCode().value()!=201) {
            logger.error("Could not upload " + file.getName()+ " @ Webanno. Moving on to the next one");
        }

    }

    private void deleteProject(String corpusId) {
        MultiValueMap<String, String> map= new LinkedMultiValueMap<String, String>();
        map.add("name", corpusId);

        HttpHeaders headers = new HttpHeaders();
        headers.add("Authorization","Basic "+basicAuth());

        HttpEntity<MultiValueMap<String, String>> request = new HttpEntity<MultiValueMap<String, String>>(map, headers);
        restTemplate.delete(webannoHost+"/projects/"+corpusId,request, String.class);

    }

    @Override
    public void triggerRetrieval(long projectId) {
        HttpHeaders headers = new HttpHeaders();
        headers.add("Authorization","Basic "+basicAuth());
        headers.setContentType(MediaType.MULTIPART_FORM_DATA);

        HttpEntity request = new HttpEntity<>(headers);
        ResponseEntity response = restTemplate.postForEntity(webannoHost+"/projects/"+Math.toIntExact(projectId)+"/export.zip",request, String.class);
        logger.error(response.getStatusCode());
        if(response.getStatusCode().value()==201) {
            logger.error(response.getBody().toString());
        }else {
            logger.debug(webannoHost + " returned " + response.getStatusCode() + " | Logger level ERROR for more info");
            logger.error(response.getBody().toString());
        }



    }


    private String basicAuth(){
        return new String(Base64.encodeBytes((webannoUsername+":"+webannoPassword).getBytes()).getBytes());
    }
}