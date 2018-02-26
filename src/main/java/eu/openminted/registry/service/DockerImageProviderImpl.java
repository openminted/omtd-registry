package eu.openminted.registry.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;

import eu.openminted.registry.domain.Component;

public class DockerImageProviderImpl implements DockerImageProvider{

	public final static String dockerImageProperty = "docker.image";
	
	@Autowired
	Environment env;
	
	@Override
	public String getImage(Component metaComponent) {
		String imageName = "NOT FOUND";
		
		String imageID = metaComponent.getComponentInfo().getComponentCreationInfo().getFramework().value();
		imageName = env.getProperty(dockerImageProperty + "." + imageID);
		
		return imageName;
	}

}
