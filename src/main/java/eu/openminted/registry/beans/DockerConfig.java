package eu.openminted.registry.beans;

import com.github.dockerjava.api.DockerClient;
import com.github.dockerjava.api.command.DockerCmdExecFactory;
import com.github.dockerjava.api.model.AuthConfig;
import com.github.dockerjava.core.DefaultDockerClientConfig;
import com.github.dockerjava.core.DockerClientBuilder;
import com.github.dockerjava.core.DockerClientConfig;
import com.github.dockerjava.jaxrs.JerseyDockerCmdExecFactory;
import com.github.jmchilton.blend4j.galaxy.GalaxyInstance;
import com.github.jmchilton.blend4j.galaxy.GalaxyInstanceFactory;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

/**
 * Created by stefanos on 14/6/2017.
 */

@Configuration
@PropertySource(value = { "classpath:application.properties", "classpath:registry.properties"} )
public class DockerConfig {

    private static Logger logger = Logger.getLogger(DockerConfig.class);

    @Value("${docker.username}")
    private String dockerUsername;

    @Value("${docker.password}")
    private String dockerPassword;

    @Value("${docker.host}")
    private String dockerHost;

    @Value("${galaxy.host}")
    private String galaxyHost;

    @Value("${galaxy.api}")
    private String galaxyAPI;

    @Bean
    public DockerClient dockerClient() {
        DockerClientConfig config = DefaultDockerClientConfig.createDefaultConfigBuilder()
                .withDockerHost("tcp://"+dockerHost)
                .withDockerTlsVerify(false)
                .build();

        DockerCmdExecFactory dockerCmdExecFactory = new JerseyDockerCmdExecFactory()
                .withReadTimeout(10000)
                .withConnectTimeout(10000)
                .withMaxTotalConnections(100)
                .withMaxPerRouteConnections(10);

        DockerClient dockerClient = DockerClientBuilder.getInstance(config)
                .withDockerCmdExecFactory(dockerCmdExecFactory)
                .build();
        return dockerClient;
    }

    @Bean
    public AuthConfig dockerAuth() {
        AuthConfig authConfig = new AuthConfig();
        authConfig.withUsername(dockerUsername);
        authConfig.withPassword(dockerPassword);
        return authConfig;
    }

    @Bean
    public GalaxyInstance galaxyInstanceFactory() {
        logger.info("Connected to galaxy in host " + galaxyHost);
        GalaxyInstance galaxy = GalaxyInstanceFactory.get(galaxyHost,galaxyAPI);
        return galaxy;
    }

}