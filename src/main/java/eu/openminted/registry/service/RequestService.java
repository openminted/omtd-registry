package eu.openminted.registry.service;

import org.springframework.http.ResponseEntity;

public interface RequestService {
	
	ResponseEntity<String> getResponseByFiltersElastic(String keyword, String[] resourceType, String[] language,
			String[] mediaType, String[] rights, String[] mimeType, String[] dataFormatSpecific, String[] license,
			int from, int to);

}
