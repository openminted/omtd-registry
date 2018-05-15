package eu.openminted.registry.service.tool;


import eu.openminted.registry.service.WebannoService;
import eu.openminted.registry.templates.AuthorizedRestTemplate;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hobsoft.spring.resttemplatelogger.LoggingCustomizer;
import org.json.JSONObject;
import org.postgresql.util.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;


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
    AuthorizedRestTemplate authorizedRestTemplate;

//    @Autowired
//    eu.openminted.store.core.StoreService storeService;

    @Override
    public boolean createProject(String corpusId) {

        MultiValueMap<String, String> map= new LinkedMultiValueMap<String, String>();
        map.add("name", corpusId);

        HttpHeaders headers = new HttpHeaders();
        headers.add("Authorization","Basic "+basicAuth());
        headers.setContentType(MediaType.MULTIPART_FORM_DATA);

        HttpEntity<MultiValueMap<String, String>> request = new HttpEntity<MultiValueMap<String, String>>(map, headers);
        ResponseEntity response = restTemplate.postForEntity(webannoHost+"/projects",request, String.class);
        if(response.getStatusCode().equals("201")) {
            JSONObject jsonObject = (JSONObject) new JSONObject(response.getBody().toString()).getJSONObject("body");
            logger.error(jsonObject.getInt("id"));
            return true;
        }else {
            logger.debug(webannoHost + " returned " + response.getStatusCode() + " | Logger level ERROR for more info");
            logger.error(response.getBody().toString());
            return false;
        }
    }

    @Override
    public void deleteProject(String corpusId) {
        MultiValueMap<String, String> map= new LinkedMultiValueMap<String, String>();
        map.add("name", corpusId);

        HttpHeaders headers = new HttpHeaders();
        headers.add("Authorization","Basic "+basicAuth());

        HttpEntity<MultiValueMap<String, String>> request = new HttpEntity<MultiValueMap<String, String>>(map, headers);
        restTemplate.delete(webannoHost+"/projects/"+corpusId,request, String.class);

    }


    private String basicAuth(){
        return new String(Base64.encodeBytes((webannoUsername+":"+webannoPassword).getBytes()).getBytes());
    }
}