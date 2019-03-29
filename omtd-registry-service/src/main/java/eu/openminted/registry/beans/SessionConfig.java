package eu.openminted.registry.beans;


import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.*;
import org.springframework.session.web.context.AbstractHttpSessionApplicationInitializer;
import org.springframework.session.web.http.CookieSerializer;
import org.springframework.session.web.http.DefaultCookieSerializer;

@Configuration
@PropertySource(value = {"classpath:application.properties", "classpath:registry.properties"})
public class SessionConfig extends AbstractHttpSessionApplicationInitializer {

    private static Logger logger = Logger.getLogger(SessionConfig.class);

    @Bean
    public CookieSerializer cookieSerializer() {
        DefaultCookieSerializer serializer = new DefaultCookieSerializer();
        serializer.setCookieName("SESSION"); // <1>
        serializer.setCookiePath("/"); // <2>
        return serializer;
    }
}
