package eu.openminted.registry.service;

import eu.openminted.registry.core.service.ResourceCRUDService;
import eu.openminted.registry.domain.Corpus;

import java.io.InputStream;


public interface DockerService {

    String uploadDockerFlow(String url);

    void downloadDockerFlow(String url);

    void deleteDockerFlow(String url, String image_id);

}
