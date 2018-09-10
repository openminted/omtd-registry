package eu.openminted.registry.beans.security;

import com.nimbusds.jwt.JWT;
import eu.openminted.registry.core.service.ServiceException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.mitre.openid.connect.client.OIDCAuthoritiesMapper;
import org.mitre.openid.connect.model.UserInfo;
import org.springframework.core.io.ClassPathResource;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.*;

/**
 * Created by stefanos on 23/6/2017.
 */
@Component
public class OMTDAuthoritiesMapper implements OIDCAuthoritiesMapper {

    final private static String ROLE_CLAIMS = "edu_person_entitlements";
    private static Logger logger = LogManager.getLogger(OMTDAuthoritiesMapper.class);
    private Map<String, SimpleGrantedAuthority> userRolesMap;

    public OMTDAuthoritiesMapper() throws IOException {
        userRolesMap = new HashMap<>();
        Properties properties = new Properties();
        String filename = "/eu/openminted/registry/maps/aaiRoles.xml";
        org.springframework.core.io.Resource resource = new ClassPathResource(filename);
        properties.loadFromXML(resource.getInputStream());
        for (final String name : properties.stringPropertyNames()) {
            userRolesMap.put(name, new SimpleGrantedAuthority(properties.getProperty(name)));
        }
    }

    OMTDAuthoritiesMapper(Map<String, String> userRoles) {
        userRolesMap = new HashMap<>();
        userRoles.forEach((omtdRole, appRole) -> userRolesMap.put(omtdRole, new SimpleGrantedAuthority(appRole)));
    }

    @Override
    public Collection<? extends GrantedAuthority> mapAuthorities(JWT idToken, UserInfo userInfo) {
        Set<GrantedAuthority> out = new HashSet<>();
        if(userInfo==null) {
            throw new ServiceException("Could not validate JWT Token");
        }
        out.add(new SimpleGrantedAuthority("ROLE_USER"));
        if (userInfo.getSource().getAsJsonArray(ROLE_CLAIMS) != null) {
            userInfo.getSource().getAsJsonArray(ROLE_CLAIMS).forEach(role -> {
                SimpleGrantedAuthority authority = userRolesMap.get(role.getAsString());
                if (authority != null) {
                    logger.debug("Role mapped " + role);
                    out.add(authority);
                }
            });
        }
        return out;
    }
}
