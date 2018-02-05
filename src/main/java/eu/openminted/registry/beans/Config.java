package eu.openminted.registry.beans;

import com.github.dockerjava.api.DockerClient;
import com.github.dockerjava.api.command.DockerCmdExecFactory;
import com.github.dockerjava.api.model.AuthConfig;
import com.github.dockerjava.core.DefaultDockerClientConfig;
import com.github.dockerjava.core.DockerClientBuilder;
import com.github.dockerjava.core.DockerClientConfig;
import com.github.dockerjava.jaxrs.JerseyDockerCmdExecFactory;
import org.apache.activemq.spring.ActiveMQConnectionFactory;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.redis.connection.lettuce.LettuceConnectionFactory;
import org.springframework.jms.annotation.EnableJms;
import org.springframework.jms.config.DefaultJmsListenerContainerFactory;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.support.converter.MappingJackson2MessageConverter;
import org.springframework.jms.support.converter.MessageConverter;
import org.springframework.jms.support.converter.MessageType;
import org.springframework.session.data.redis.config.annotation.web.http.EnableRedisHttpSession;
import org.springframework.session.web.http.CookieSerializer;
import org.springframework.session.web.http.DefaultCookieSerializer;

/**
 * Created by stefanos on 14/6/2017.
 */

@Configuration
@EnableRedisHttpSession
@EnableJms
@PropertySource(value = { "classpath:application.properties", "classpath:registry.properties"} )
public class Config {

    private static Logger logger = Logger.getLogger(Config.class);

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



    @Bean
    public ActiveMQConnectionFactory activeMQConnectionFactory() {
        ActiveMQConnectionFactory connectionFactory = new ActiveMQConnectionFactory();
        connectionFactory.setBrokerURL(jmsHost);
        connectionFactory.setConnectionIDPrefix("omtd-registry");
        logger.info("ActiveMQConnection Factory created for " + jmsHost);
        return connectionFactory;
    }

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


    @Bean // Serialize message content to json using TextMessage
    public MessageConverter jacksonJmsMessageConverter() {
        MappingJackson2MessageConverter converter = new MappingJackson2MessageConverter();
        converter.setTargetType(MessageType.TEXT);
        converter.setTypeIdPropertyName("_type");
        return converter;
    }

    @Bean
    public DefaultJmsListenerContainerFactory jmsQueueListenerContainerFactory() {
        DefaultJmsListenerContainerFactory factory
                = new DefaultJmsListenerContainerFactory();
        factory.setConnectionFactory(activeMQConnectionFactory());
        factory.setPubSubDomain(false); // false is for queue
        factory.setMessageConverter(jacksonJmsMessageConverter());
        return factory;
    }

    @Bean
    public DefaultJmsListenerContainerFactory jmsTopicListenerContainerFactory() {
        DefaultJmsListenerContainerFactory factory
                = new DefaultJmsListenerContainerFactory();
        factory.setConnectionFactory(activeMQConnectionFactory());
        factory.setPubSubDomain(true); // false is for queue
//        factory.setMessageConverter(jacksonJmsMessageConverter());
        return factory;
    }

    @Bean
    public JmsTemplate jmsQueueTemplate(){
        JmsTemplate template = new JmsTemplate();
        template.setConnectionFactory(activeMQConnectionFactory());
        template.setPubSubDomain(false); //false is for queue
        template.setMessageConverter(jacksonJmsMessageConverter());
        return template;
    }

    @Bean
    public LettuceConnectionFactory connectionFactory() {
        logger.info(String.format("Redis connection listens to %s:%s",host,port));
        LettuceConnectionFactory factory = new LettuceConnectionFactory(host,Integer.parseInt(port));
        if(password != null) factory.setPassword(password);
        return factory;
    }

    @Bean
    public CookieSerializer cookieSerializer() {
        DefaultCookieSerializer serializer = new DefaultCookieSerializer();
        serializer.setCookieName("SESSION"); // <1>
        serializer.setCookiePath("/"); // <2>
        // serializer.setDomainNamePattern("^.+?\\.(\\w+\\.[a-z]+)$"); // <3>
        return serializer;
    }

}