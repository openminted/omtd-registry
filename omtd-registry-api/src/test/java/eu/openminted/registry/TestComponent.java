package eu.openminted.registry;

import eu.openminted.registry.domain.Component;
import eu.openminted.registry.domain.MetadataHeaderInfo;
import eu.openminted.registry.domain.ObjectFactory;
import org.junit.Test;
import static javax.xml.bind.JAXBContext.newInstance;
import org.junit.Ignore;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

import java.io.StringReader;
import java.io.StringWriter;
import java.util.Collections;

import static org.junit.Assert.*;


/**
 * Created by stefanos on 28/7/2017.
 */
public class TestComponent {

    JAXBContext jaxbContext;

    public TestComponent() throws JAXBException {
        jaxbContext = newInstance(ObjectFactory.class);
    }

    static void printMsg(String msg) {
        String separator = String.join("",Collections.nCopies(25,"="));
        System.out.println(separator);
        System.out.println(msg);
        System.out.println(separator);
    }

    @Test
    public void testSerialization() throws Exception {
        Component resource = new Component();
        resource.setMetadataHeaderInfo(new MetadataHeaderInfo());

        /*
         * Marshalling
         */
        Marshaller marshaller = jaxbContext.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
        StringWriter sw = new StringWriter();
        marshaller.marshal(resource, sw);
        printMsg("This is the xml generated from the component");
        System.out.println(sw.toString());

        /*
         * Unmarshalling
         */
        Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
        Component xmlresource = (Component) unmarshaller.unmarshal(new StringReader(sw.toString()));
        StringWriter xmlsw = new StringWriter();
        marshaller.marshal(xmlresource,xmlsw);
        printMsg("This is the xml to java to xml of the component");
        System.out.println(xmlsw.toString());

        /*
         * This uses the getter with the lazy instantiation thus returns a new empty List
         */
        assertNotNull(xmlresource.getMetadataHeaderInfo().getMetadataCreators());

        /*
         * Both xml generated are the same.
         */
        assertEquals(sw.toString(),xmlsw.toString());

        /*
         * Unmarshalling
         */
        StringWriter xmlsw2 = new StringWriter();
        marshaller.marshal(xmlresource,xmlsw2);
        printMsg("This is the xml to java to xml of the component after the lazy instantiation");
        System.out.println(xmlsw2.toString());
    }
}
