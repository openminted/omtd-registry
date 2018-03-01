package eu.openminted.registry.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;

import eu.openminted.registry.domain.Component;
import eu.openminted.registry.domain.ComponentDistributionFormEnum;
import eu.openminted.workflows.galaxywrappers.Utils;

public class DockerImageProviderImpl implements DockerImageProvider{

	public final static String dockerImageProperty = "docker.image";
	
	@Autowired
	Environment env;
	
	@Override
	public String getImage(Component metaComponent) {
		String imageName = "NOT FOUND";
		
		String imageIDSelector = "";
		
		if(Utils.isWebService(metaComponent.getComponentInfo().getDistributionInfos())){
			imageIDSelector = ComponentDistributionFormEnum.WEB_SERVICE.value();
			
		}else{
			imageIDSelector = metaComponent.getComponentInfo().getComponentCreationInfo().getFramework().value();
		}
		
		imageName = env.getProperty(dockerImageProperty + "." + imageIDSelector);
		
		return imageName;
	}

}
