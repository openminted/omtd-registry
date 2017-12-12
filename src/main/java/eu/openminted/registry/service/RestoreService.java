package eu.openminted.registry.service;

import org.springframework.web.multipart.MultipartFile;

public interface RestoreService {

	void restoreDataFromZip(MultipartFile file);
}
