package eu.openminted.registry.service.tool;

import eu.openminted.registry.core.service.ServiceException;
import eu.openminted.registry.domain.*;
import eu.openminted.registry.service.MavenResolverService;
import eu.openminted.share.annotations.util.DescriptorResolver;
import org.apache.commons.io.IOUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.map.SerializationConfig;
import org.springframework.stereotype.Service;

import javax.xml.bind.*;
import java.io.StringReader;
import java.io.StringWriter;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

import static javax.xml.bind.JAXBContext.newInstance;

@Service("mavenResolverService")
public class MavenResolverImpl implements MavenResolverService {

    static JAXBContext jaxbContext;
    private static Logger logger = LogManager.getLogger(MavenResolverImpl.class);
    private ExecutorService executor;

    MavenResolverImpl() throws JAXBException {
        jaxbContext = newInstance(ObjectFactory.class);
        executor = Executors.newCachedThreadPool();
    }

    public List<MavenComponent> resolveCoordinates(String groupID, String artifactID, String version) {

        List<MavenComponent> records = new ArrayList<>();
        try {
            List<Future<MavenComponent>> futureRecords = new ArrayList<>();
            URL[] descriptors = DescriptorResolver.scanDescriptors(groupID, artifactID, version);
            for (URL url : descriptors) {
                futureRecords.add(executor.submit(new FetchDescriptor(url)));
            }

            if (descriptors.length == 0) {
                String[] xmlDescriptors = DescriptorResolver.generateDescriptors(groupID, artifactID, version);
                for (String xml : xmlDescriptors) {
                    futureRecords.add(executor.submit(new FetchDescriptor(xml)));
                }
            }

            ObjectMapper mapper = new ObjectMapper();
            mapper.enable(SerializationConfig.Feature.INDENT_OUTPUT);
            for (Future<MavenComponent> future : futureRecords) {
                records.add(future.get());
            }
        } catch (Exception e) {
            logger.error("scan descriptors error", e);
            throw new ServiceException(e);
        }
        return records;
    }


    class FetchDescriptor implements Callable<MavenComponent> {

        private URL url;
        private String xml;

        FetchDescriptor(URL url) {
            this.url = url;
        }

        FetchDescriptor(String xml) {
            this.xml = xml;
        }


        @Override
        public MavenComponent call() throws Exception {
            MavenComponent ret = new MavenComponent();
            if (xml == null) {
                StringWriter writer = new StringWriter();
                URLConnection urlConnection = url.openConnection();
                IOUtils.copy(urlConnection.getInputStream(), writer);
                ret.setXml(writer.toString());
            } else {
                ret.setXml(xml);
            }

            Unmarshaller unmarshaller = MavenResolverImpl.jaxbContext.createUnmarshaller();
            ret.setComponent((Component) unmarshaller.unmarshal(new StringReader(ret.getXml())));
            return ret;

        }
    }
}
