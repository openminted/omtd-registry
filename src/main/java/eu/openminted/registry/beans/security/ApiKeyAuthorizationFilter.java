package eu.openminted.registry.beans.security;

import com.nimbusds.jwt.JWT;
import com.nimbusds.jwt.JWTParser;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.mitre.openid.connect.client.OIDCAuthenticationProvider;
import org.mitre.openid.connect.client.service.ServerConfigurationService;
import org.mitre.openid.connect.config.ServerConfiguration;
import org.mitre.openid.connect.model.PendingOIDCAuthenticationToken;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.util.StringUtils;
import org.springframework.web.filter.GenericFilterBean;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

public class ApiKeyAuthorizationFilter extends GenericFilterBean {

    static final private Logger logger = LogManager.getLogger(ApiKeyAuthorizationFilter.class);

    static final private String AUTHORIZATION_HEADER = "Authorization";

    private ServerConfigurationService serverConfigurationService;

    private AuthenticationProvider authenticationProvider;

    public ApiKeyAuthorizationFilter(ServerConfigurationService serverConfigurationService, OIDCAuthenticationProvider openIdConnectAuthenticationProvider) {
//        super("/**");
//        setRequiresAuthenticationRequestMatcher(new AntPathRequestMatcher("/**"));
        this.serverConfigurationService = serverConfigurationService;
        this.authenticationProvider = openIdConnectAuthenticationProvider;
    }

    @Override
    public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain) throws IOException, ServletException {
        logger.info("Attempt Authentication");
        HttpServletRequest request = (HttpServletRequest) req;
        String jwt = resolveToken(request);
        PendingOIDCAuthenticationToken token;
        try {
            JWT idToken = JWTParser.parse(jwt);
            String issuer = idToken.getJWTClaimsSet().getIssuer();
            String subject = idToken.getJWTClaimsSet().getSubject();
            String accessToken = idToken.getParsedString();
            ServerConfiguration serverConfig = serverConfigurationService.getServerConfiguration(issuer);
            token = new PendingOIDCAuthenticationToken(subject,issuer,serverConfig,idToken,accessToken,null);
        } catch (Exception e) {
            logger.error("JWT Error",e);
            throw new BadCredentialsException("JWT is not valid");
        }
        Authentication auth = this.authenticationProvider.authenticate(token);
        SecurityContextHolder.getContext().setAuthentication(auth);
        chain.doFilter(req, res);
    }


    private String resolveToken(HttpServletRequest request) {
        String bearerToken = request.getHeader(AUTHORIZATION_HEADER);
        if (StringUtils.hasText(bearerToken) && bearerToken.startsWith("Bearer ")) {
            String jwt = bearerToken.substring(7, bearerToken.length());
            return jwt;
        }
        return null;
    }

    public ServerConfigurationService getServerConfigurationService() {
        return serverConfigurationService;
    }

    public void setServerConfigurationService(ServerConfigurationService serverConfigurationService) {
        this.serverConfigurationService = serverConfigurationService;
    }
}
