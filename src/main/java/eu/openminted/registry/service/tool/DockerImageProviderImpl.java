package eu.openminted.registry.service.tool;

import eu.openminted.registry.service.DockerImageProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;

import eu.openminted.registry.domain.Component;
import eu.openminted.registry.domain.ComponentDistributionFormEnum;
import eu.openminted.workflows.galaxywrappers.Utils;

public class DockerImageProviderImpl implements DockerImageProvider {

	public final static String dockerImageProperty = "docker.image";
	
	@Autowired
	Environment env;
	
	@Override
	public String getImage(Component metaComponent) {
		String imageName = "NOT FOUND";
		
		String imageSelector = "";
		
		if(Utils.isWebService(metaComponent.getComponentInfo().getDistributionInfos())){
			imageSelector = ComponentDistributionFormEnum.WEB_SERVICE.value();
			
		}else{
			imageSelector = metaComponent.getComponentInfo().getComponentCreationInfo().getFramework().value();
		}
		
		imageName = env.getProperty(dockerImageProperty + "." + imageSelector);
		
		return imageName;
	}

}
