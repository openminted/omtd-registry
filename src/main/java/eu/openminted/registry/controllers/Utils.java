package eu.openminted.registry.controllers;

import java.io.StringReader;
import java.io.StringWriter;
import java.net.URL;
import java.util.Scanner;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

import org.apache.log4j.Logger;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import eu.openminted.registry.core.domain.Resource;
import eu.openminted.registry.domain.ObjectFactory;


public class Utils {
    
    private static Logger logger = Logger.getLogger(Utils.class);

    @SuppressWarnings("unchecked")
    public static <T> T serialize(Resource resource, Class<T> returnType){
        T type;
        try {
            type = returnType.newInstance();
            JAXBContext jc = JAXBContext.newInstance(ObjectFactory.class);
            Unmarshaller unmarshaller = jc.createUnmarshaller();

            type = (T) unmarshaller.unmarshal(new StringReader(resource.getPayload()));
        } catch (JAXBException | InstantiationException | IllegalAccessException je) {
            type = null;
        }
        return type;
    }
}
