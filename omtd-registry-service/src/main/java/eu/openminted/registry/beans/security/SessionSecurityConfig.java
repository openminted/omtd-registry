package eu.openminted.registry.beans.security;

import com.google.common.collect.Sets;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.mitre.oauth2.model.ClientDetailsEntity;
import org.mitre.oauth2.model.RegisteredClient;
import org.mitre.openid.connect.client.OIDCAuthenticationFilter;
import org.mitre.openid.connect.client.OIDCAuthenticationProvider;
import org.mitre.openid.connect.client.service.*;
import org.mitre.openid.connect.client.service.impl.*;
import org.mitre.openid.connect.config.ServerConfiguration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.*;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.authentication.preauth.AbstractPreAuthenticatedProcessingFilter;
import org.springframework.security.web.header.writers.frameoptions.AllowFromStrategy;
import org.springframework.security.web.header.writers.frameoptions.RegExpAllowFromStrategy;
import org.springframework.security.web.header.writers.frameoptions.StaticAllowFromStrategy;
import org.springframework.security.web.header.writers.frameoptions.XFrameOptionsHeaderWriter;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

@Configuration
@PropertySource({"classpath:application.properties", "classpath:registry.properties"})
@Order(2)
public class SessionSecurityConfig extends WebSecurityConfigurerAdapter {

    static final private Logger logger = LogManager.getLogger(SessionSecurityConfig.class);
    @Autowired
    OMTDAuthoritiesMapper omtdAuthoritiesMapper;
    @Value("${webapp.front}")
    private String webappFrontUrl;
    @Value("${oidc.issuer}")
    private String oidcIssuer;
    @Value("${oidc.secret}")
    private String oidcSecret;
    @Value("${oidc.id}")
    private String oidcId;
    @Value("${webapp.home}")
    private String webappHome;


    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        logger.info("Register local");
        auth.authenticationProvider(openIdConnectAuthenticationProvider());
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        logger.info("Configure AAI Security Config");
        http
                .authenticationProvider(openIdConnectAuthenticationProvider())
                .addFilterBefore(openIdConnectAuthenticationFilter(),
                        AbstractPreAuthenticatedProcessingFilter.class)
                .logout()
                .deleteCookies("SESSION")
                .invalidateHttpSession(true)
                .logoutUrl("/openid_logout")
                .logoutSuccessUrl(webappFrontUrl)
                .and()
                .authorizeRequests()
                .anyRequest()
                .permitAll()
                .and()
                .headers()
                .addHeaderWriter(new XFrameOptionsHeaderWriter(XFrameOptionsHeaderWriter.XFrameOptionsMode.SAMEORIGIN))
                .and()
                .csrf()
                .disable();

        //authenticationEntryPoint(new LoginUrlAuthenticationEntryPoint("/openid_connect_login"))
    }

    @Autowired
    public void registerGlobal(AuthenticationManagerBuilder auth) throws Exception {
        logger.info("Register Global");
        auth.authenticationProvider(openIdConnectAuthenticationProvider());
    }

    @Bean
    OIDCAuthenticationProvider openIdConnectAuthenticationProvider() {
        OIDCAuthenticationProvider ret = new OIDCAuthenticationProvider();
        ret.setAuthoritiesMapper(omtdAuthoritiesMapper);
        return ret;
    }

    @Bean
    IssuerService issuerService() {
        StaticSingleIssuerService ret = new StaticSingleIssuerService();
        ret.setIssuer(oidcIssuer);
        return ret;
    }


    @Bean
    RegisteredClient platformClient() {
        RegisteredClient ret = new RegisteredClient();
        ret.setClientId(oidcId);
        ret.setClientSecret(oidcSecret);
        ret.setScope(Sets.newHashSet("openid"));
        ret.setTokenEndpointAuthMethod(ClientDetailsEntity.AuthMethod.SECRET_BASIC);
        ret.setRedirectUris(Sets.newHashSet(webappHome));
        return ret;
    }

    @Bean
    ServerConfigurationService serverConfigurationService() {
        DynamicServerConfigurationService serverConfigurationService = new DynamicServerConfigurationService();
        serverConfigurationService.setWhitelist(Collections.singleton(this.oidcIssuer));
        return serverConfigurationService;
    }

    @Bean
    ClientConfigurationService clientConfigurationService() {
        Map<String, RegisteredClient> clients = new HashMap<>();
        clients.put(oidcIssuer, platformClient());
        StaticClientConfigurationService ret = new StaticClientConfigurationService();
        ret.setClients(clients);
        return ret;
    }

    @Bean
    OIDCAuthenticationFilter openIdConnectAuthenticationFilter() throws Exception {
        OIDCAuthenticationFilter ret = new OIDCAuthenticationFilter();
        ret.setAuthenticationManager(authenticationManager());
        ret.setIssuerService(issuerService());
        ret.setServerConfigurationService(serverConfigurationService());
        ret.setClientConfigurationService(clientConfigurationService());
        ret.setAuthRequestOptionsService(new StaticAuthRequestOptionsService());
        ret.setAuthRequestUrlBuilder(new PlainAuthRequestUrlBuilder());
        ret.setAuthenticationSuccessHandler(new FrontEndLinkURIAuthenticationSuccessHandler(webappFrontUrl));
        return ret;
    }

}
