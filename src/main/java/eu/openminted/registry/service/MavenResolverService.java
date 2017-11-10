package eu.openminted.registry.service;

import eu.openminted.registry.domain.MavenComponent;

import java.util.List;

public interface MavenResolverService {

    List<MavenComponent> resolveCoordinates(String groupID, String artifactID, String version);

}