package eu.openminted.registry.service;


import com.github.dockerjava.api.DockerClient;
import com.github.dockerjava.api.command.*;
import com.github.dockerjava.api.exception.NotFoundException;
import com.github.dockerjava.api.model.AuthConfig;
import com.github.dockerjava.api.model.PullResponseItem;
import com.github.dockerjava.api.model.PushResponseItem;
import com.github.dockerjava.core.command.PullImageResultCallback;
import com.github.dockerjava.core.command.PushImageResultCallback;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;
import org.omg.CosNaming.NamingContextPackage.NotFound;
import org.springframework.beans.factory.annotation.Autowired;
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

    final private String OPENMINTED_REPO = "docker.openminted.eu";
    final private String DEFAULT_PULL_SOURCE = "https://index.docker.io/v1";


    @Autowired
    DockerClient dockerClient;

    @Autowired
    AuthConfig authConfig;

    private DockerImage parseLocation(String url){
        DockerImage image = new DockerImage();
        Pattern pattern = Pattern.compile("^(?:([\\w\\d\\.]+)\\/)?([\\w\\d]+)(?::([\\w\\d\\.]+))?$");
        Matcher matcher = pattern.matcher(url);
        matcher.find();
        image.domain = matcher.group(1) != null ? matcher.group(1) : DEFAULT_PULL_SOURCE;
        if (matcher.group(2) != null)
            image.name = matcher.group(2);
        if (matcher.group(3) != null)
            image.version = matcher.group(3);
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
