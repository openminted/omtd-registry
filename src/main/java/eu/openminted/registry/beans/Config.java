package eu.openminted.registry.beans;

import eu.openminted.registry.messages.JMSConsumer;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.redis.connection.lettuce.LettuceConnectionFactory;
import org.springframework.session.data.redis.config.annotation.web.http.EnableRedisHttpSession;
import org.springframework.session.web.http.CookieSerializer;
import org.springframework.session.web.http.DefaultCookieSerializer;

import javax.annotation.PostConstruct;

/**
 * Created by stefanos on 14/6/2017.
 */

@Configuration
@EnableRedisHttpSession
@PropertySource(value = { "classpath:application.properties", "classpath:registry.properties"} )
public class Config {

    private static Logger logger = Logger.getLogger(Config.class);

    @Value("${redis.host}")
    private String host;

    @Value("${redis.port}")
    private String port;

    @Value("${redis.password:#{null}}")
    private String password;

    @Autowired
    private JMSConsumer consumer;

    @PostConstruct
    public void initializeJMSConsumer() {
        System.out.println("Creating consumer");
        new Thread(() -> consumer.listen()).start();
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