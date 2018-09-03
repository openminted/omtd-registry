package eu.openminted.registry.beans;

import com.github.jmchilton.blend4j.galaxy.GalaxyInstance;
import com.github.jmchilton.blend4j.galaxy.GalaxyInstanceFactory;

import eu.openminted.omtdshareontology.OWLOntManager;
import eu.openminted.omtdshareontology.SectionGen;
import eu.openminted.registry.service.tool.DockerImageProviderImpl;
import eu.openminted.workflows.galaxywrappers.GalaxyToolWrapperWriter;
import eu.openminted.workflows.galaxywrappers.GalaxyWrapperGenerator;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.*;

@Configuration
@PropertySource(value = {"classpath:application.properties", "classpath:registry.properties"})
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

    // Beans for Galaxy wrappers generation ...
    @Bean
    public GalaxyWrapperGenerator galaxyWrapperGenerator() {
        logger.info("Creating:" + GalaxyWrapperGenerator.class.getName());
        return new GalaxyWrapperGenerator();
    }

    @Bean
    public GalaxyToolWrapperWriter galaxyToolWrapperWriter() {
        logger.info("Creating:" + GalaxyToolWrapperWriter.class.getName());
        return new GalaxyToolWrapperWriter();
    }

    @Bean
    public DockerImageProviderImpl dockerImageProviderImpl() {
        logger.info("Creating:" + DockerImageProviderImpl.class.getName());
        return new DockerImageProviderImpl();
    }
    
    @Bean
    public SectionGen sectionGenImpl() {
        logger.info("Creating:" + SectionGen.class.getName());
        OWLOntManager ontManager = new OWLOntManager();
        ontManager.load();
        return new SectionGen(ontManager);
    }
}
