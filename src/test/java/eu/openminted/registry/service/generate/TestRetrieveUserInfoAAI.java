package eu.openminted.registry.service.generate;


import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import eu.openminted.registry.service.aai.UserInfoAAIRetrieve;
import org.apache.commons.lang3.tuple.Pair;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.IOException;


//@ActiveProfiles("test")
//@RunWith(SpringJUnit4ClassRunner.class)
//@SpringBootConfiguration
//@PropertySource("classpath:/test.properties")
//@ContextConfiguration(classes=RestTemplateBeanConfig.class)//, loader=AnnotationConfigContextLoader.class)
public class TestRetrieveUserInfoAAI {
    static final Logger logger = Logger.getLogger(TestRetrieveUserInfoAAI.class.getName());

    @Autowired
    private UserInfoAAIRetrieve aaiRetriever;

    //@Test
    public void testBasic() throws JsonParseException, JsonMappingException, IOException {

        logger.info("Running Retrieving User info");
        String userId = "0931731143127784@openminted.eu";

        int coId = aaiRetriever.getCoId(userId);
        logger.info("User has coId " + coId);

        String email = aaiRetriever.getEmail(coId);
        logger.info("User has email " + email);

        Pair name = aaiRetriever.getSurnameGivenName(coId);
        logger.info("User has surname " + name.getLeft());
        logger.info("User has name " + name.getRight());

    }
}
