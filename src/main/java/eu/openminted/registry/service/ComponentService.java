package eu.openminted.registry.service;

import eu.openminted.registry.domain.Component;
import org.springframework.http.ResponseEntity;

public interface ComponentService {

	 ResponseEntity<String> addComponent(Component component);
	 
	 ResponseEntity<String> updateComponent(Component component);
	 
	 ResponseEntity<String> deleteComponent(Component component);
	
}
