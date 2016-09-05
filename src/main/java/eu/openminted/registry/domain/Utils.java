package eu.openminted.registry.domain;

import java.net.URL;
import java.util.List;
import java.util.Scanner;

import org.apache.log4j.Logger;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import eu.openminted.registry.core.domain.Occurencies;
import eu.openminted.registry.core.domain.Paging;
import eu.openminted.registry.core.domain.Resource;
import eu.openminted.registry.core.domain.ResourceType;


public class Utils {
	
	private static Logger logger = Logger.getLogger(Utils.class);

	
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
