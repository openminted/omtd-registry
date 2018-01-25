package eu.openminted.registry.beans;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan({"eu.openminted.registry.core","eu.openminted.registry.service"})
public class ServiceConfig {
}
