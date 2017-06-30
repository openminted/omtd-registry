package eu.openminted.registry.parser;

import eu.openminted.registry.core.domain.Resource;
import eu.openminted.registry.core.service.ServiceException;
import eu.openminted.registry.domain.ObjectFactory;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.StringReader;
import java.io.StringWriter;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import static javax.xml.bind.JAXBContext.newInstance;

/**
 * Created by stefanos on 26/6/2017.
 */
@Component("parserPool")
public class ParserPool {

    private ExecutorService executor;

    private static Logger logger = Logger.getLogger(ParserPool.class);

    private JAXBContext jaxbContext = null;

    public ParserPool() {
        executor = Executors.newCachedThreadPool();
        try {
            jaxbContext = newInstance(ObjectFactory.class);
        } catch (JAXBException e) {
            throw new RuntimeException(e);
        }
    }

    @SuppressWarnings("unchecked")
    public <T> Future<T> serialize(Resource resource, Class<T> returnType) {
        return executor.submit(() -> {
            T type;
            if (resource == null) {
                throw new ServiceException("null resource");
            }
            try {
                Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
                type = (T) unmarshaller.unmarshal(new StringReader(resource.getPayload()));
            } catch (JAXBException je) {
                throw new ServiceException(je);
            }
            return type;
        });

    }

    @SuppressWarnings("unchecked")
    public <T> Future<String> unserialize(T resource, Class<T> returnType) {
        return executor.submit(() -> {
            Marshaller marshaller = jaxbContext.createMarshaller();
            StringWriter sw = new StringWriter();
            marshaller.marshal(resource, sw);
            return sw.toString();
        });
    }
}

