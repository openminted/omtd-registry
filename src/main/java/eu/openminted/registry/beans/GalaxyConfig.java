package eu.openminted.registry.beans;

import com.github.jmchilton.blend4j.galaxy.GalaxyInstance;
import com.github.jmchilton.blend4j.galaxy.GalaxyInstanceFactory;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource(value = { "classpath:application.properties", "classpath:registry.properties"} )
public class GalaxyConfig {

    static final private Logger logger = LogManager.getLogger(GalaxyConfig.class);

    @Value("${galaxy.host}")
    private String galaxyEditorHost;

    @Value("${galaxy.api}")
    private String galaxyEditorAPI;

    @Value("${galaxy.executor.host}")
    private String galaxyExecutorHost;

    @Value("${galaxy.executor.api}")
    private String galaxyExecutorAPI;

    @Bean
    public GalaxyInstance galaxyInstanceFactory() {
        logger.info("Connected to galaxy editor in host " + galaxyEditorHost);
        return GalaxyInstanceFactory.get(galaxyEditorHost, galaxyEditorAPI);
    }

    @Bean
    public GalaxyInstance galaxyExecutorInstanceFactory() {
        logger.info("Connected to galaxy executor in host " + galaxyEditorHost);
        return GalaxyInstanceFactory.get(galaxyExecutorHost, galaxyExecutorAPI);
    }
}
