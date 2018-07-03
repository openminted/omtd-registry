package eu.openminted.registry.beans;

/**
 * @author Stefanos Gatsios
 */

import eu.openminted.store.restclient.StoreRESTClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.*;

@Configuration
@PropertySource(value = {"classpath:application.properties", "classpath:registry.properties"})
public class StoreRestConfig {

    @Value("${services.store.ip:#{'http://83.212.101.85:8090'}}")
    private String storeHost;

    @Bean
    StoreRESTClient storeRESTClient() {
        return new StoreRESTClient(storeHost);
    }

    public String getStoreHost() {
        return storeHost;
    }

    public void setStoreHost(String storeHost) {
        this.storeHost = storeHost;
    }
}
