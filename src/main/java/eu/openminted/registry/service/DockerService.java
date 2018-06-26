package eu.openminted.registry.service;


public interface DockerService {


    void downloadDockerFlow(String url);

    int getSizeOfImage(String url);

}
