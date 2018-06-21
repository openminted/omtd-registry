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
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.io.Closeable;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service("dockerService")
@Primary
public class DockerServiceImpl implements DockerService {

    private Logger logger = LogManager.getLogger(DockerServiceImpl.class);

    @Value("${docker.registry:#{'docker.openminted.eu'}}")
    private String OPENMINTED_REPO;

    final private String DEFAULT_PULL_SOURCE = "https://index.docker.io/v1";
    final private Pattern pattern = Pattern.compile("^(?:(?<name>[^\\.]*?)|(?<host>[\\w\\d\\.]*?)\\/)?(?<image>[\\w\\d.-]+)(?::(?<version>[\\w\\d\\.]+))?$");


    @Autowired
    DockerClient dockerClient;

    @Autowired
    AuthConfig authConfig;

    private DockerImage parseLocation(String url){
        DockerImage image = new DockerImage();
        Matcher matcher = pattern.matcher(url);
        matcher.find();
        image.domain = matcher.group("host") != null ? matcher.group("host") : DEFAULT_PULL_SOURCE;
        if (matcher.group("image") != null)
            image.name = matcher.group("image");
            if(matcher.group("name")==null || matcher.group("name").isEmpty()) {
                if (!image.name.contains("/")) {
                    image.name = "library/".concat(image.name);
                }
            }else{
                image.name =  matcher.group("name").concat(image.name);
            }
        }

        if (matcher.group("version") != null)
            image.version = matcher.group("version");
        else {
            image.version = "latest";
        }


        return image;
    }


    @Override
    public String uploadDockerFlow(String url) {

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

        logger.info(image.domain);
        logger.info(image.name);
        logger.info(image.version);

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
    }

    @Override
    public void deleteDockerFlow(String url, String image_id) {
        RemoveImageCmd removeImageCmd = dockerClient.removeImageCmd(image_id);
        removeImageCmd.hasForceEnabled();
        removeImageCmd.withForce(true);
        try {
            removeImageCmd.exec();
        }catch (NotFoundException e){
            logger.error(e.getMessage());
        }

    }

    class DockerImage {
        DockerImage() {}
        public String domain;
        public String name;
        public String version;
    }
}
