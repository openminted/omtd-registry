package eu.openminted.registry.service;

import eu.openminted.registry.core.service.ServiceException;
import eu.openminted.registry.domain.Component;
import eu.openminted.registry.domain.MavenComponent;
import eu.openminted.registry.domain.ObjectFactory;
import eu.openminted.share.annotations.util.DescriptorResolver;
import org.apache.commons.io.IOUtils;
import org.apache.log4j.Logger;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.map.SerializationConfig;
import org.springframework.stereotype.Service;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.StringReader;
import java.io.StringWriter;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import static javax.xml.bind.JAXBContext.newInstance;

@Service
public class MavenResolverImpl implements MavenResolverService {

    private static Logger logger = Logger.getLogger(MavenResolverImpl.class);

    private ExecutorService executor;

    static JAXBContext jaxbContext;

    MavenResolverImpl() throws JAXBException {
        jaxbContext = newInstance(ObjectFactory.class);
        executor = Executors.newCachedThreadPool();
    }

    public List<MavenComponent> resolveCoordinates(String groupID, String artifactID, String version) {
        URL[] descriptors;
        List<MavenComponent> records = new ArrayList<>();
        try {
            List<Future<MavenComponent>> futureRecords = new ArrayList<>();
            descriptors = DescriptorResolver.scanDescriptors(groupID, artifactID, version);
            for(URL url : descriptors) {
                futureRecords.add(executor.submit(new FetchDescriptorUrl(url)));
            }
            ObjectMapper mapper = new ObjectMapper();
            mapper.enable(SerializationConfig.Feature.INDENT_OUTPUT);
            for(Future<MavenComponent> future : futureRecords) {
                records.add(future.get());
            }
        } catch (Exception e) {
            logger.error("scan descriptors error",e);
            throw new ServiceException(e);
        }
        return records;
    }


    class FetchDescriptorUrl implements Callable<MavenComponent> {

        private URL url;

        FetchDescriptorUrl(URL url) {
            this.url = url;
        }

        @Override
        public MavenComponent call() throws Exception {
            MavenComponent ret = new MavenComponent();
            StringWriter writer = new StringWriter();
            URLConnection urlConnection = url.openConnection();
            IOUtils.copy(urlConnection.getInputStream(),writer);
            ret.setXml(writer.toString());
            Unmarshaller unmarshaller = MavenResolverImpl.jaxbContext.createUnmarshaller();
            ret.setComponent((Component)unmarshaller.unmarshal(new StringReader(ret.getXml())));
            return ret;

        }
    }
}
