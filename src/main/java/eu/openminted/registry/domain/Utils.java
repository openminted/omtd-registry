package eu.openminted.registry.domain;

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


public class Utils {
	
	private static Logger logger = Logger.getLogger(Utils.class);

<<<<<<< HEAD
	public static Component serializeComponent(Resource resource){
		Component component = new Component();
		try {
		       	JAXBContext jc = JAXBContext.newInstance(ObjectFactory.class);
		       	Unmarshaller unmarshaller = jc.createUnmarshaller();
	
		       	component = (Component) unmarshaller.unmarshal(new StringReader(resource.getPayload()));
		 } catch (JAXBException je) {
		    	component = null;
		 }
		return component;
	}
	
	public static String unserializeCorpus(Corpus corpus){
	
		try {
		       	JAXBContext jc = JAXBContext.newInstance(Corpus.class);
		       	Marshaller marshaller = jc.createMarshaller();
	
		       	StringWriter sw = new StringWriter();
		       	marshaller.marshal(corpus, sw);
		       	return sw.toString();
		       	
		 } catch (JAXBException je) {
		    	return "failed";
		 }
	}
	
	public static String unserializeComponent(Component component){
		
		try {
		       	JAXBContext jc = JAXBContext.newInstance(Component.class);
		       	Marshaller marshaller = jc.createMarshaller();
	
		       	StringWriter sw = new StringWriter();
		       	marshaller.marshal(component, sw);
		       	return sw.toString();
		       	
		 } catch (JAXBException je) {
		    	return "failed";
		 }
	}
	
	public static Corpus serializeCorpus(Resource resource){
		Corpus corpus = new Corpus();
		try {
		       	JAXBContext jc = JAXBContext.newInstance(ObjectFactory.class);
		       	Unmarshaller unmarshaller = jc.createUnmarshaller();
	
		       	corpus = (Corpus) unmarshaller.unmarshal(new StringReader(resource.getPayload()));
		 } catch (JAXBException je) {
		    	corpus = null;
		 }
		return corpus;
	}
	
	
	public static String objToJson(Paging paging){

		ObjectMapper mapper = new ObjectMapper();

=======
	@SuppressWarnings("unchecked")
	public static <T> T serialize(Resource resource, Class<T> returnType){
		T type;
>>>>>>> 3fe4f10e7b8d1be7f7799e9920c4bb11b6ac505f
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
	
	public static <T> String objToJson(T paging){

		ObjectMapper mapper = new ObjectMapper();

		try {
			return mapper.writeValueAsString(paging);
		} catch (JsonProcessingException e) {
//			logger.error("Error serializing object to json", e);
			return e.getMessage();
//			return null;
		}
	}
	
	
	public static String getText(String url) throws Exception {

		String out = new Scanner(new URL(url).openStream(), "UTF-8").useDelimiter("\\A").next();


		if(out==null || out.isEmpty()){
			return null;
		}else{
			return out;
		}
	}
}
