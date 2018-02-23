package eu.openminted.registry.beans;

import com.github.dockerjava.api.DockerClient;
import com.github.dockerjava.api.command.DockerCmdExecFactory;
import com.github.dockerjava.api.model.AuthConfig;
import com.github.dockerjava.core.DefaultDockerClientConfig;
import com.github.dockerjava.core.DockerClientBuilder;
import com.github.dockerjava.core.DockerClientConfig;
import com.github.dockerjava.jaxrs.JerseyDockerCmdExecFactory;

import eu.openminted.store.restclient.StoreRESTClient;
import eu.openminted.workflows.galaxywrappers.GalaxyToolWrapperWriter;
import eu.openminted.workflows.galaxywrappers.GalaxyWrapperGenerator;

import org.apache.activemq.spring.ActiveMQConnectionFactory;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.jms.annotation.EnableJms;
import org.springframework.session.data.redis.config.annotation.web.http.EnableRedisHttpSession;
import org.springframework.session.web.http.CookieSerializer;
import org.springframework.session.web.http.DefaultCookieSerializer;

/**
 * Created by stefanos on 14/6/2017.
 */

@Configuration
@EnableRedisHttpSession
@PropertySource(value = {"classpath:application.properties", "classpath:registry.properties"})
public class Config {

    private static Logger logger = LogManager.getLogger(Config.class);

    @Value("${redis.host}")
    private String host;

    @Value("${redis.port}")
    private String port;

    @Value("${redis.password:#{null}}")
    private String password;

    @Value("${jms.host}")
    private String jmsHost;

    @Value("${docker.username}")
    private String dockerUsername;

    @Value("${docker.password}")
    private String dockerPassword;

    @Value("${docker.host}")
    private String dockerHost;

    @Value("${services.store.ip:#{'http://83.212.101.85:8090'}}")
    private String storeServiceHost;

    @Bean
    public DockerClient dockerClient() {
        DockerClientConfig config = DefaultDockerClientConfig.createDefaultConfigBuilder()
                .withDockerHost("tcp://" + dockerHost)
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
    JedisConnectionFactory connectionFactory() {
        JedisConnectionFactory jedisConnectionFactory = new JedisConnectionFactory();
        jedisConnectionFactory.setHostName(host);
        jedisConnectionFactory.setPort(Integer.parseInt(port));
        if(password != null) jedisConnectionFactory.setPassword(password);
        return jedisConnectionFactory;
    }

    @Bean
    public RedisTemplate redisTemplate() {
        RedisTemplate template = new RedisTemplate();
        template.setConnectionFactory(connectionFactory());
        return template;
    }

    @Bean
    public CookieSerializer cookieSerializer() {
        DefaultCookieSerializer serializer = new DefaultCookieSerializer();
        serializer.setCookieName("SESSION"); // <1>
        serializer.setCookiePath("/"); // <2>
        // serializer.setDomainNamePattern("^.+?\\.(\\w+\\.[a-z]+)$"); // <3>
        return serializer;
    }

    @Bean
    public StoreRESTClient storeRESTClient() {
        logger.info("Store Service is connected to " + storeServiceHost);
        return new StoreRESTClient(storeServiceHost);
    }
   
    
    // Beans for Galaxy wrappers generation ...
    
    @Bean
    public GalaxyWrapperGenerator galaxyWrapperGenerator() {
        logger.info("galaxyWrapperGenerator");
        return new GalaxyWrapperGenerator();
    }
    
    @Bean
    public GalaxyToolWrapperWriter galaxyToolWrapperWriter() {
        logger.info("GalaxyToolWrapperWriter");
        return new GalaxyToolWrapperWriter();
    }
   
    /*
    @Bean
    public SSH galaxySSH() {
        logger.info("Galaxy SSH");
        return new SSH("","","","");
    }
    */
}