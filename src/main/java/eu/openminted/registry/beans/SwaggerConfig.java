package eu.openminted.registry.beans;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.*;
import springfox.documentation.builders.*;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.ApiKey;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.paths.RelativePathProvider;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import javax.servlet.ServletContext;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Collections;

@Configuration
@EnableSwagger2
@PropertySource(value = {"classpath:application.properties", "classpath:registry.properties"})
public class SwaggerConfig {


    @Value("${openminted.debug:#{false}}")
    public Boolean isLocalhost;

    @Value("${registry.host}")
    public String host;

    @Autowired
    ServletContext context;

    private RelativePathProvider pathProvider() {
        if (isLocalhost) {
            return new RelativePathProvider(context);
        } else {
            return new RelativePathProvider(context) {
                @Override
                protected String applicationPath() {
                    return "";
                }
            };
        }
    }

    @Bean
    public ApiInfo apiInfo() {
        ApiInfoBuilder apiInfoBuilder = new ApiInfoBuilder();
        apiInfoBuilder.title("OpenMinTeD API Documentation")
                .licenseUrl("http://www.apache.org/licenses/LICENSE-2.0");
        return apiInfoBuilder.build();
    }

    @Bean
    public Docket api() throws MalformedURLException {
        URL hostURL = new URL(host);
        return new Docket(DocumentationType.SWAGGER_2)
                .pathProvider(pathProvider())
                .apiInfo(apiInfo())
                .host(isLocalhost ? null : hostURL.getHost() + hostURL.getPath())
                .securitySchemes(Collections.singletonList(
                        new ApiKey("apiKey", "Authorization", "header"))
                )
                .select()
                .apis(RequestHandlerSelectors.basePackage("eu.openminted.registry.controllers"))
                .paths(PathSelectors.any())
                .build();
    }
}
