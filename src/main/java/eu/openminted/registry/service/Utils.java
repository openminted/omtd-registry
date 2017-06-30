package eu.openminted.registry.service;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import eu.openminted.registry.core.domain.Resource;
import eu.openminted.registry.core.service.ServiceException;
import eu.openminted.registry.domain.ObjectFactory;
import org.apache.log4j.Logger;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.StringReader;
import java.io.StringWriter;
import java.net.URL;
import java.util.Scanner;

import static javax.xml.bind.JAXBContext.newInstance;


public class Utils {

    private static Logger logger = Logger.getLogger(Utils.class);

    private static JAXBContext JAXBCONTEXT = null;

    static {
        try {
            JAXBCONTEXT = newInstance(ObjectFactory.class);
        } catch (JAXBException e) {
            throw new RuntimeException(e);
        }
    }

    @SuppressWarnings("unchecked")
    static <T> T serialize(Resource resource, Class<T> returnType) {
        T type;
        if (resource == null) {
            throw new ServiceException("null resource");
        }
        try {
            Unmarshaller unmarshaller = JAXBCONTEXT.createUnmarshaller();
            type = (T) unmarshaller.unmarshal(new StringReader(resource.getPayload()));
        } catch (JAXBException je) {
            throw new ServiceException(je);
        }
        return type;
    }

    public static <T> String objToJson(T paging) {
        ObjectMapper mapper = new ObjectMapper();
        mapper.setSerializationInclusion(JsonInclude.Include.NON_EMPTY);
        try {
            return mapper.writeValueAsString(paging);
        } catch (JsonProcessingException e) {
            throw new ServiceException(e);
        }
    }


    public static String getText(String url) throws Exception {
        String out = new Scanner(new URL(url).openStream(), "UTF-8").useDelimiter("\\A").next();
        if (out == null || out.isEmpty()) {
            return null;
        } else {
            return out;
        }
    }

    public static <T> String unserialize(T component, Class<T> returnType) throws ServiceException {
        try {
            Marshaller marshaller = JAXBCONTEXT.createMarshaller();
            StringWriter sw = new StringWriter();
            marshaller.marshal(component, sw);
            return sw.toString();
        } catch (JAXBException je) {
            throw new ServiceException((je));
        }
    }

}
