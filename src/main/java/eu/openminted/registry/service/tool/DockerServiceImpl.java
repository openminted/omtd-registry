package eu.openminted.registry.service.tool;


import com.github.dockerjava.api.DockerClient;
import com.github.dockerjava.api.command.*;
import com.github.dockerjava.api.exception.NotFoundException;
import com.github.dockerjava.api.model.AuthConfig;
import com.github.dockerjava.api.model.PullResponseItem;
import com.github.dockerjava.api.model.PushResponseItem;
import com.github.dockerjava.core.command.PullImageResultCallback;
import com.github.dockerjava.core.command.PushImageResultCallback;
import eu.openminted.registry.service.DockerService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.json.JSONArray;
import org.json.JSONObject;
import org.postgresql.util.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Primary;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import java.io.Closeable;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service("dockerService")
@Primary
public class DockerServiceImpl implements DockerService {

    private Logger logger = LogManager.getLogger(DockerServiceImpl.class);

    @Value("${docker.registry}")
    private String OPENMINTED_REPO;

    @Value("${docker.username}")
    private String dockerUsername;

    @Value("${docker.password}")
    private String dockerPassword;

    @Value("${geranos.key}")
    private String geranosApiKey;

    @Value("${geranos.endpoint}")
    private String geranosEndpoint;

    final private String DEFAULT_PULL_SOURCE = "https://index.docker.io/v1";
    final private Pattern pattern = Pattern.compile("^(?:(?<host>[\\w\\d\\.]+)\\/)?(?<image>[\\w\\d.-]+)(?::(?<version>[\\w\\d\\.]+))?$");


    @Autowired
    DockerClient dockerClient;

    @Autowired
    AuthConfig authConfig;

    @Autowired
    RestTemplate restTemplate;

    private DockerImage parseLocation(String url){
        DockerImage image = new DockerImage();
        Matcher matcher = pattern.matcher(url);
        matcher.find();
        image.domain = matcher.group("host") != null ? matcher.group("host") : DEFAULT_PULL_SOURCE;
        if (matcher.group("image") != null){
            image.name = matcher.group("image");
            if(!image.name.contains("/"))
                image.name="library/".concat(image.name);
        }if (matcher.group("version") != null)
            image.version = matcher.group("version");
        else {
            image.version = "latest";
        }


        return image;
    }


    private String uploadDockerFlow(String url) {

        DockerImage image = parseLocation(url);

        InspectImageCmd inspectImageCmd = dockerClient.inspectImageCmd(image.name+":"+image.version);

        String image_id = inspectImageCmd.exec().getId();

        TagImageCmd tagImageCmd = dockerClient.tagImageCmd(image_id,OPENMINTED_REPO+"/"+image.name,image.version);
        tagImageCmd.exec();


        PushImageCmd pushImageCmd = dockerClient.pushImageCmd(OPENMINTED_REPO+"/"+image.name);


        pushImageCmd.withAuthConfig(authConfig);

        pushImageCmd.exec(new PushImageResultCallback(){
            @Override
            public void onStart(Closeable stream) {
                logger.info("Sending name out to "+OPENMINTED_REPO);
                super.onStart(stream);
            }

            @Override
            public void onError(Throwable throwable) {
                logger.info("Error:"+throwable.getMessage());
                super.onError(throwable);
            }

            @Override
            public void onComplete() {
                logger.info("Image transfer completed!");
                super.onComplete();
            }

            @Override
            public void close() throws IOException {
                super.close();
            }

            @Override
            public void onNext(PushResponseItem item) {
                logger.info("Sending out:"+item.getProgressDetail());
                super.onNext(item);
            }
        }).awaitSuccess();

        return image_id;

    }

    @Override
    public void downloadDockerFlow(String url) {
        privateRegistryDownload(url);
        if(getSizeOfImage(url)<=1000*1000*1000) { //1 GB
            //send to geranos
            geranosDownload(url);
        }
    }

    private void deleteDockerFlow(String image_id) {
        RemoveImageCmd removeImageCmd = dockerClient.removeImageCmd(image_id);
        removeImageCmd.hasForceEnabled();
        removeImageCmd.withForce(true);
        try {
            removeImageCmd.exec();
        }catch (NotFoundException e){
            logger.error(e.getMessage());
        }

    }

    private void geranosDownload(String url) {
        DockerImage image = parseLocation(url);

        MultiValueMap<String, String> map= new LinkedMultiValueMap<String, String>();
        HttpHeaders headers = new HttpHeaders();
        headers.add("X-API-KEY",geranosApiKey);
        headers.setAccept(MediaType.parseMediaTypes("application/vnd.docker.distribution.manifest.v2+json"));

        HttpEntity<MultiValueMap<String, String>> request = new HttpEntity<MultiValueMap<String, String>>(map, headers);

        restTemplate.put(geranosEndpoint+"/geranos/heavy/docker/pull?image="+image.name+":"+image.version, request, String.class);


    }

    private void privateRegistryDownload(String url){
        DockerImage image = parseLocation(url);
        PullImageCmd pullImageCmd = dockerClient.pullImageCmd(image.name);
        pullImageCmd.withTag(image.version);
        AuthConfig authConfigPull = new AuthConfig();
        authConfigPull.withRegistryAddress(image.domain);
        pullImageCmd.withAuthConfig(authConfigPull);
        pullImageCmd.exec( new PullImageResultCallback(){

            @Override
            public void onStart(Closeable stream) {
                logger.info("Starting the transfer");
                super.onStart(stream);
            }

            @Override
            public void onError(Throwable throwable) {
                throwable.printStackTrace();
                logger.info("Error:"+throwable.getMessage());
                super.onError(throwable);
            }

            @Override
            public void onNext(PullResponseItem item) {
                logger.info("Next:"+item.getProgressDetail());
                super.onNext(item);
            }

            @Override
            public void onComplete() {
                logger.info("Image is here!");
                super.onComplete();
            }

            @Override
            public void close() throws IOException {
                super.close();
            }
        }).awaitSuccess();

        deleteDockerFlow(uploadDockerFlow(url));

    }


    class DockerImage {
        DockerImage() {}
        public String domain;
        public String name;
        public String version;
    }

    private int getSizeOfImage(String url){
        DockerImage image = parseLocation(url);
        if(image.domain.equals(DEFAULT_PULL_SOURCE)){
            ResponseEntity response = restTemplate.getForEntity("https://auth.docker.io/token?service=registry.docker.io&scope=repository:"+image.name+":*",String.class);
            String token = new JSONObject(response.getBody().toString()).getString("token");

            HttpHeaders headers = new HttpHeaders();
            headers.add("Authorization","Bearer "+token);
            headers.setAccept(MediaType.parseMediaTypes("application/vnd.docker.distribution.manifest.v2+json"));

            MultiValueMap<String, String> map= new LinkedMultiValueMap<String, String>();

            HttpEntity<MultiValueMap<String, String>> request = new HttpEntity<MultiValueMap<String, String>>(map, headers);

            response = restTemplate.exchange("https://registry.hub.docker.com/v2/"+image.name+"/manifests/"+image.version, HttpMethod.GET, request, String.class);

            JSONArray jsonArray = new JSONObject(response.getBody().toString()).getJSONArray("layers");

            int size=0;
            for(int i=0; i<jsonArray.length();i++)
                size+= jsonArray.getJSONObject(i).getInt("size");

            return size;
        }else{
            MultiValueMap<String, String> map= new LinkedMultiValueMap<String, String>();
            HttpHeaders headers = new HttpHeaders();
            headers.add("Authorization","Basic "+new String(Base64.encodeBytes((dockerUsername+":"+dockerPassword).getBytes()).getBytes()));
            headers.setAccept(MediaType.parseMediaTypes("application/vnd.docker.distribution.manifest.v2+json"));


            HttpEntity<MultiValueMap<String, String>> request = new HttpEntity<MultiValueMap<String, String>>(map, headers);
            ResponseEntity response = restTemplate.exchange("http://"+image.domain+"/v2/"+image.name+"/manifests/"+image.version, HttpMethod.GET, request, String.class);
            JSONArray jsonArray = new JSONObject(response.getBody().toString()).getJSONArray("layers");

            int size=0;
            for(int i=0; i<jsonArray.length();i++)
                size+= jsonArray.getJSONObject(i).getInt("size");

            return size;
        }
    }
}
