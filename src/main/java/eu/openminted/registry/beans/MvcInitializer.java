package eu.openminted.registry.beans;

import eu.openminted.registry.beans.security.SecurityConfig;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class MvcInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {



    @Override
    protected Class<?>[] getRootConfigClasses() {
        return null;// new Class[] { SecurityConfig.class, SessionConfig.class, WebConfig.class };
    }
    // end::config[]

    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class[] { SecurityConfig.class, SessionConfig.class, WebConfig.class };
    }

    @Override
    protected String[] getServletMappings() {
        return new String[] { "/" };
    }
}
