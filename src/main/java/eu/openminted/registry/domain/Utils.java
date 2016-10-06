package eu.openminted.registry.domain;

import java.io.StringReader;
import java.io.StringWriter;
import java.net.URL;
import java.util.List;
import java.util.Scanner;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

import org.apache.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import eu.openminted.registry.core.domain.Occurencies;
import eu.openminted.registry.core.domain.Paging;
import eu.openminted.registry.core.domain.Resource;
import eu.openminted.registry.core.domain.ResourceType;


public class Utils {
	
	private static Logger logger = Logger.getLogger(Utils.class);

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

		try {
			return mapper.writeValueAsString(paging);
		} catch (JsonProcessingException e) {
//			logger.error("Error serializing object to json", e);
			return e.getMessage();
//			return null;
		}
	}
	
	public static String objToJson(Component component){

		ObjectMapper mapper = new ObjectMapper();

		try {
			return mapper.writeValueAsString(component);
		} catch (JsonProcessingException e) {
//			logger.error("Error serializing object to json", e);
			return e.getMessage();
//			return null;
		}
	}
	
	public static String objToJson(Corpus corpus){

		ObjectMapper mapper = new ObjectMapper();

		try {
			return mapper.writeValueAsString(corpus);
		} catch (JsonProcessingException e) {
//			logger.error("Error serializing object to json", e);
			return e.getMessage();
//			return null;
		}
	}
	
	public static String objToJson(Browsing browsing){

		ObjectMapper mapper = new ObjectMapper();

		try {
			return mapper.writeValueAsString(browsing);
		} catch (JsonProcessingException e) {
//			logger.error("Error serializing object to json", e);
			return e.getMessage();
//			return null;
		}
	}
	
	public static String objToJson(Occurencies occurencies){

		ObjectMapper mapper = new ObjectMapper();

		try {
			return mapper.writeValueAsString(occurencies);
		} catch (JsonProcessingException e) {
//			logger.error("Error serializing object to json", e);
			return e.getMessage();
//			return null;
		}
	}
	
	public static String objToJson(List<Occurencies> occurencies){

		ObjectMapper mapper = new ObjectMapper();

		try {
			return mapper.writeValueAsString(occurencies);
		} catch (JsonProcessingException e) {
//			logger.error("Error serializing object to json", e);
			return e.getMessage();
//			return null;
		}
	}

	public static String objToJson(eu.openminted.registry.core.domain.Schema schema){

		ObjectMapper mapper = new ObjectMapper();

		try {
			return mapper.writeValueAsString(schema);
		} catch (JsonProcessingException e) {
//			logger.error("Error serializing object to json", e);
			return e.getMessage();
//			return null;
		}
	}

	public static String objToJson(Resource resource){

		ObjectMapper mapper = new ObjectMapper();

		try {
			return mapper.writeValueAsString(resource);
		} catch (JsonProcessingException e) {
			logger.error("Error serializing object to json", e);

			return null;
		}
	}

	public static String objToJson(ResourceType resourceType){

		ObjectMapper mapper = new ObjectMapper();

		try {
			return mapper.writeValueAsString(resourceType);
		} catch (JsonProcessingException e) {
			logger.error("Error serializing object to json", e);

			return null;
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
	
	public static String objToJson(User user){

		ObjectMapper mapper = new ObjectMapper();

		try {
			return mapper.writeValueAsString(user);
		} catch (JsonProcessingException e) {
			logger.error("Error serializing object to json", e);

			return null;
		}
	}

}
