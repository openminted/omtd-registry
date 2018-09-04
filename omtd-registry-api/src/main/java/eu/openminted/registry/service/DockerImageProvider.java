package eu.openminted.registry.service;

public interface DockerImageProvider {

	public String getImage(eu.openminted.registry.domain.Component metaComponent);
	
}
