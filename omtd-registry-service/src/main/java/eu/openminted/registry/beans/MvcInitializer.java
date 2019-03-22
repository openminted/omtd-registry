package eu.openminted.registry.beans;

import eu.openminted.registry.beans.security.SecurityRootConfig;
import eu.openminted.registry.beans.security.UserInfoAAIConfig;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class MvcInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {

    @Override
    protected Class<?>[] getRootConfigClasses() {
        return new Class[]{SecurityRootConfig.class, UserInfoAAIConfig.class, SessionConfig.class, DockerConfig
                .class, ServiceConfig.class, StoreRestConfig.class, CacheConfig.class, GalaxyConfig.class,
                WorkflowConfig.class, AdminToolsConfig.class}; //
    }

    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class[]{SecurityRootConfig.class, WebConfig.class};
    }

    @Override
    protected String[] getServletMappings() {
        return new String[]{"/"};
    }
}
