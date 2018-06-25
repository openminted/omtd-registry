package eu.openminted.registry.beans;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.CachingConfigurerSupport;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.GenericJackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.JdkSerializationRedisSerializer;

/**
 * Created by stefanos on 14/6/2017.
 */

@Configuration
@EnableCaching
public class CacheConfig extends CachingConfigurerSupport {

    @Value("${redis.host}")
    private String host;

    @Value("${redis.port}")
    private String port;

    @Value("${redis.password:#{null}}")
    private String password;

    @Bean
    JedisConnectionFactory connectionFactory() {
        JedisConnectionFactory jedisConnectionFactory = new JedisConnectionFactory();
        jedisConnectionFactory.setHostName(host);
        jedisConnectionFactory.setPort(Integer.parseInt(port));
        if (password != null) jedisConnectionFactory.setPassword(password);
        return jedisConnectionFactory;
    }

    @Bean
    public JdkSerializationRedisSerializer jdkSerializationRedisSerializer() {
        return new JdkSerializationRedisSerializer();
    }

    @Bean
    public RedisTemplate redisTemplate() {
        RedisTemplate template = new RedisTemplate();
        template.setConnectionFactory(connectionFactory());
        template.setKeySerializer(jdkSerializationRedisSerializer());
        template.setValueSerializer(genericJackson2JsonRedisJsonSerializer());
        return template;
    }

    @Bean
    public GenericJackson2JsonRedisSerializer genericJackson2JsonRedisJsonSerializer() {
        GenericJackson2JsonRedisSerializer genericJackson2JsonRedisJsonSerializer =
                new GenericJackson2JsonRedisSerializer();
        return genericJackson2JsonRedisJsonSerializer;
    }

    @Bean
    public CacheManager cacheManager(RedisTemplate redisTemplate) {
        RedisCacheManager cacheManager = new RedisCacheManager(redisTemplate);
        // Number of seconds before expiration. Defaults to unlimited (0)
        cacheManager.setDefaultExpiration(60 * 60 * 24);
        return cacheManager;
    }

}